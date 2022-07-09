package com.shahenpc.system.service.perform.impl;

import java.util.List;
import com.shahenpc.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shahenpc.system.mapper.perform.PerformNpcOverviewMapper;
import com.shahenpc.system.domain.perform.PerformNpcOverview;
import com.shahenpc.system.service.perform.IPerformNpcOverviewService;

/**
 * 小程序-信息发布Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-07-08
 */
@Service
public class PerformNpcOverviewServiceImpl implements IPerformNpcOverviewService 
{
    @Autowired
    private PerformNpcOverviewMapper performNpcOverviewMapper;

    /**
     * 查询小程序-信息发布
     * 
     * @param overviewId 小程序-信息发布主键
     * @return 小程序-信息发布
     */
    @Override
    public PerformNpcOverview selectPerformNpcOverviewByOverviewId(Long overviewId)
    {
        return performNpcOverviewMapper.selectPerformNpcOverviewByOverviewId(overviewId);
    }

    /**
     * 查询小程序-信息发布列表
     * 
     * @param performNpcOverview 小程序-信息发布
     * @return 小程序-信息发布
     */
    @Override
    public List<PerformNpcOverview> selectPerformNpcOverviewList(PerformNpcOverview performNpcOverview)
    {
        return performNpcOverviewMapper.selectPerformNpcOverviewList(performNpcOverview);
    }

    /**
     * 新增小程序-信息发布
     * 
     * @param performNpcOverview 小程序-信息发布
     * @return 结果
     */
    @Override
    public int insertPerformNpcOverview(PerformNpcOverview performNpcOverview)
    {
        performNpcOverview.setCreateTime(DateUtils.getNowDate());
        return performNpcOverviewMapper.insertPerformNpcOverview(performNpcOverview);
    }

    /**
     * 修改小程序-信息发布
     * 
     * @param performNpcOverview 小程序-信息发布
     * @return 结果
     */
    @Override
    public int updatePerformNpcOverview(PerformNpcOverview performNpcOverview)
    {
        performNpcOverview.setUpdateTime(DateUtils.getNowDate());
        return performNpcOverviewMapper.updatePerformNpcOverview(performNpcOverview);
    }

    /**
     * 批量删除小程序-信息发布
     * 
     * @param overviewIds 需要删除的小程序-信息发布主键
     * @return 结果
     */
    @Override
    public int deletePerformNpcOverviewByOverviewIds(Long[] overviewIds)
    {
        return performNpcOverviewMapper.deletePerformNpcOverviewByOverviewIds(overviewIds);
    }

    /**
     * 删除小程序-信息发布信息
     * 
     * @param overviewId 小程序-信息发布主键
     * @return 结果
     */
    @Override
    public int deletePerformNpcOverviewByOverviewId(Long overviewId)
    {
        return performNpcOverviewMapper.deletePerformNpcOverviewByOverviewId(overviewId);
    }
}
