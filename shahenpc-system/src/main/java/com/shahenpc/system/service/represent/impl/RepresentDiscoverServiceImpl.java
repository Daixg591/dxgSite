package com.shahenpc.system.service.represent.impl;

import java.util.List;
import com.shahenpc.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shahenpc.system.mapper.represent.RepresentDiscoverMapper;
import com.shahenpc.system.domain.represent.RepresentDiscover;
import com.shahenpc.system.service.represent.IRepresentDiscoverService;

/**
 * 代-代发现Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-07-28
 */
@Service
public class RepresentDiscoverServiceImpl implements IRepresentDiscoverService 
{
    @Autowired
    private RepresentDiscoverMapper representDiscoverMapper;

    /**
     * 查询代-代发现
     * 
     * @param discoverId 代-代发现主键
     * @return 代-代发现
     */
    @Override
    public RepresentDiscover selectRepresentDiscoverByDiscoverId(Long discoverId)
    {
        return representDiscoverMapper.selectRepresentDiscoverByDiscoverId(discoverId);
    }

    /**
     * 查询代-代发现列表
     * 
     * @param representDiscover 代-代发现
     * @return 代-代发现
     */
    @Override
    public List<RepresentDiscover> selectRepresentDiscoverList(RepresentDiscover representDiscover)
    {
        return representDiscoverMapper.selectRepresentDiscoverList(representDiscover);
    }

    /**
     * 新增代-代发现
     * 
     * @param representDiscover 代-代发现
     * @return 结果
     */
    @Override
    public int insertRepresentDiscover(RepresentDiscover representDiscover)
    {
        representDiscover.setCreateTime(DateUtils.getNowDate());
        return representDiscoverMapper.insertRepresentDiscover(representDiscover);
    }

    /**
     * 修改代-代发现
     * 
     * @param representDiscover 代-代发现
     * @return 结果
     */
    @Override
    public int updateRepresentDiscover(RepresentDiscover representDiscover)
    {
        representDiscover.setUpdateTime(DateUtils.getNowDate());
        return representDiscoverMapper.updateRepresentDiscover(representDiscover);
    }

    /**
     * 批量删除代-代发现
     * 
     * @param discoverIds 需要删除的代-代发现主键
     * @return 结果
     */
    @Override
    public int deleteRepresentDiscoverByDiscoverIds(Long[] discoverIds)
    {
        return representDiscoverMapper.deleteRepresentDiscoverByDiscoverIds(discoverIds);
    }

    /**
     * 删除代-代发现信息
     * 
     * @param discoverId 代-代发现主键
     * @return 结果
     */
    @Override
    public int deleteRepresentDiscoverByDiscoverId(Long discoverId)
    {
        return representDiscoverMapper.deleteRepresentDiscoverByDiscoverId(discoverId);
    }
}
