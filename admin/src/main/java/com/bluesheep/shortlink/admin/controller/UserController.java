package com.bluesheep.shortlink.admin.controller;

import cn.hutool.core.bean.BeanUtil;
import com.bluesheep.shortlink.admin.common.convention.result.Result;
import com.bluesheep.shortlink.admin.common.convention.result.Results;
import com.bluesheep.shortlink.admin.remote.dto.resp.UserActualRespDTO;
import com.bluesheep.shortlink.admin.remote.dto.resp.UserRespDTO;
import com.bluesheep.shortlink.admin.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户管理控制层
 */
@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

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

}
