package com.bluesheep.shortlink.admin.remote.dto.resp;

import com.bluesheep.shortlink.admin.common.serialize.PhoneDesensitizationSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

/**
 * 用户返回参数响应
 */

@Data
public class UserRespDTO {

    /**
     * ID
     */
    private Long id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 真实姓名
     */
    private String realName;

    /**
     * 手机号
     */
    @JsonSerialize(using = PhoneDesensitizationSerializer.class)
    private String phone;

    /**
     * 游戏
     */
    private String mail;

}
