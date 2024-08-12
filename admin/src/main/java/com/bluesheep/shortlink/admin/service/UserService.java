package com.bluesheep.shortlink.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bluesheep.shortlink.admin.dao.entity.UserDO;
import com.bluesheep.shortlink.admin.remote.dto.resp.UserRespDTO;

/**
 * 用户接口层
 */
public interface UserService extends IService<UserDO> {

    /**
     * 根据用户名查询用户信息
     * @param username 用户名
     * @return 返回用户实体
     */
    UserRespDTO getUserByUsername(String username);
}
