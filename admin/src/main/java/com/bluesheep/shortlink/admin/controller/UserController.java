package com.bluesheep.shortlink.admin.controller;

import com.bluesheep.shortlink.admin.common.convention.result.Result;
import com.bluesheep.shortlink.admin.common.convention.result.Results;
import com.bluesheep.shortlink.admin.common.enums.UserErrorCode;
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
        UserRespDTO result = userService.getUserByUsername(username);
        if(result == null){
            return new Result<UserRespDTO>().setCode(UserErrorCode.USER_NOT_EXIST.code()).setMessage(UserErrorCode.USER_NOT_EXIST.message());
        }else{
            return Results.success(result);
        }
    }
}
