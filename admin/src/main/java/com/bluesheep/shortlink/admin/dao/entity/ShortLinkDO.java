package com.bluesheep.shortlink.admin.dao.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * 短链接持久层实体
 */
@Data
@TableName("t_link")
public class ShortLinkDO {

    /**
     * ID
     */
    private Long id;

    /**
     * 短链接
     */
    private String shortUrl;

    /**
     * 原始链接
     */
    private String originUrl;

    /**
     * 创建用户名
     */
    private String username;

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

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 删除标识 0：未删除 1：已删除
     */
    private Integer delFlag;
}
