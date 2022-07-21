package com.shahenpc.system.service.represent.impl;

import java.util.List;
import com.shahenpc.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shahenpc.system.mapper.represent.RepresentNpcOverviewMapper;
import com.shahenpc.system.domain.represent.RepresentNpcOverview;
import com.shahenpc.system.service.represent.IRepresentNpcOverviewService;

/**
 * 人大概览 只存一条信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-07-21
 */
@Service
public class RepresentNpcOverviewServiceImpl implements IRepresentNpcOverviewService 
{
    @Autowired
    private RepresentNpcOverviewMapper representNpcOverviewMapper;

    /**
     * 查询人大概览 只存一条信息
     * 
     * @param npcId 人大概览 只存一条信息主键
     * @return 人大概览 只存一条信息
     */
    @Override
    public RepresentNpcOverview selectRepresentNpcOverviewByNpcId(Long npcId)
    {
        return representNpcOverviewMapper.selectRepresentNpcOverviewByNpcId(npcId);
    }

    /**
     * 查询人大概览 只存一条信息列表
     * 
     * @param representNpcOverview 人大概览 只存一条信息
     * @return 人大概览 只存一条信息
     */
    @Override
    public List<RepresentNpcOverview> selectRepresentNpcOverviewList(RepresentNpcOverview representNpcOverview)
    {
        return representNpcOverviewMapper.selectRepresentNpcOverviewList(representNpcOverview);
    }

    /**
     * 新增人大概览 只存一条信息
     * 
     * @param representNpcOverview 人大概览 只存一条信息
     * @return 结果
     */
    @Override
    public int insertRepresentNpcOverview(RepresentNpcOverview representNpcOverview)
    {
        representNpcOverview.setCreateTime(DateUtils.getNowDate());
        return representNpcOverviewMapper.insertRepresentNpcOverview(representNpcOverview);
    }

    /**
     * 修改人大概览 只存一条信息
     * 
     * @param representNpcOverview 人大概览 只存一条信息
     * @return 结果
     */
    @Override
    public int updateRepresentNpcOverview(RepresentNpcOverview representNpcOverview)
    {
        representNpcOverview.setUpdateTime(DateUtils.getNowDate());
        return representNpcOverviewMapper.updateRepresentNpcOverview(representNpcOverview);
    }

    /**
     * 批量删除人大概览 只存一条信息
     * 
     * @param npcIds 需要删除的人大概览 只存一条信息主键
     * @return 结果
     */
    @Override
    public int deleteRepresentNpcOverviewByNpcIds(Long[] npcIds)
    {
        return representNpcOverviewMapper.deleteRepresentNpcOverviewByNpcIds(npcIds);
    }

    /**
     * 删除人大概览 只存一条信息信息
     * 
     * @param npcId 人大概览 只存一条信息主键
     * @return 结果
     */
    @Override
    public int deleteRepresentNpcOverviewByNpcId(Long npcId)
    {
        return representNpcOverviewMapper.deleteRepresentNpcOverviewByNpcId(npcId);
    }

    @Override
    public RepresentNpcOverview selectByOverview() {
        return representNpcOverviewMapper.selectByOverview();
    }
}
