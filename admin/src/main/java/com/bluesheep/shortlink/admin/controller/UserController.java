package com.bluesheep.shortlink.admin.controller;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.bluesheep.shortlink.admin.common.convention.result.Result;
import com.bluesheep.shortlink.admin.common.convention.result.Results;
import com.bluesheep.shortlink.admin.remote.dto.resp.ShortLinkRespDTO;
import com.bluesheep.shortlink.admin.remote.dto.resp.UserActualRespDTO;
import com.bluesheep.shortlink.admin.remote.dto.resp.UserRespDTO;
import com.bluesheep.shortlink.admin.service.ShortLinkService;
import com.bluesheep.shortlink.admin.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * 用户管理控制层
 */
@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final ShortLinkService shortLinkService;

    /**
     * 根据用户名获取用户信息
     */
    @GetMapping("/api/shortlink/v1/user/{username}")
    Result<UserRespDTO> getUserByUsername(@PathVariable("username") String username) {
        return Results.success(userService.getUserByUsername(username));
    }

    /**
     * 根据用户名获取用户无脱敏信息
     */
    @GetMapping("/api/shortlink/v1/actual/user/{username}")
    Result<UserActualRespDTO> getActualUserByUsername(@PathVariable("username") String username) {
        return Results.success(BeanUtil.toBean(userService.getUserByUsername(username),UserActualRespDTO.class));
    }

    /**
     * 导出用户短链接到Excel
     */
    @GetMapping("/api/shortlink/v1/user/{username}/shortlinks/export")
    public void exportShortLinks(@PathVariable("username") String username, HttpServletResponse response) throws IOException {
        // 获取用户短链接列表
        List<ShortLinkRespDTO> shortLinks = shortLinkService.getShortLinksByUsername(username);
        
        // 设置响应头
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setCharacterEncoding("utf-8");
        String fileName = URLEncoder.encode("用户短链接_" + username, StandardCharsets.UTF_8);
        response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xlsx");
        
        // 创建Excel写入器
        ExcelWriter writer = ExcelUtil.getWriter(true);
        
        // 自定义列名
        writer.addHeaderAlias("shortUrl", "短链接");
        writer.addHeaderAlias("originUrl", "原始链接");
        writer.addHeaderAlias("clickNum", "点击数");
        writer.addHeaderAlias("description", "描述");
        writer.addHeaderAlias("createTime", "创建时间");
        
        // 写入数据
        writer.write(shortLinks, true);
        
        // 输出到响应流 (flush with autoClose=true will close the writer)
        ServletOutputStream out = response.getOutputStream();
        writer.flush(out, true);
    }

}
