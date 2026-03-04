package com.bluesheep.shortlink.admin.remote.dto.resp;

import lombok.Data;

import java.util.Date;

/**
 * 短链接响应DTO
 */
@Data
public class ShortLinkRespDTO {

    /**
     * 短链接
     */
    private String shortUrl;

    /**
     * 原始链接
     */
    private String originUrl;

    /**
     * 点击数
     */
    private Integer clickNum;

    /**
     * 描述
     */
    private String description;

    /**
     * 创建时间
     */
    private Date createTime;
}
