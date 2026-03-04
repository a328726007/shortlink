package com.bluesheep.shortlink.admin.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.bluesheep.shortlink.admin.dao.entity.ShortLinkDO;
import com.bluesheep.shortlink.admin.dao.mapper.ShortLinkMapper;
import com.bluesheep.shortlink.admin.remote.dto.resp.ShortLinkRespDTO;
import com.bluesheep.shortlink.admin.service.ShortLinkService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 短链接接口实现层
 */
@Service
@RequiredArgsConstructor
public class ShortLinkServiceImpl implements ShortLinkService {

    private final ShortLinkMapper shortLinkMapper;

    @Override
    public List<ShortLinkRespDTO> getShortLinksByUsername(String username) {
        LambdaQueryWrapper<ShortLinkDO> queryWrapper = Wrappers.lambdaQuery(ShortLinkDO.class)
                .eq(ShortLinkDO::getUsername, username)
                .eq(ShortLinkDO::getDelFlag, 0);
        List<ShortLinkDO> shortLinkDOList = shortLinkMapper.selectList(queryWrapper);
        return BeanUtil.copyToList(shortLinkDOList, ShortLinkRespDTO.class);
    }
}
