package com.bluesheep.shortlink.admin.service;

import com.bluesheep.shortlink.admin.remote.dto.resp.ShortLinkRespDTO;

import java.util.List;

/**
 * 短链接接口层
 */
public interface ShortLinkService {

    /**
     * 根据用户名获取短链接列表
     *
     * @param username 用户名
     * @return 短链接列表
     */
    List<ShortLinkRespDTO> getShortLinksByUsername(String username);
}
