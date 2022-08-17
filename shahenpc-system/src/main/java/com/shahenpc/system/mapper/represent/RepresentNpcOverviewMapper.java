package com.shahenpc.system.mapper.represent;

import java.util.List;
import com.shahenpc.system.domain.represent.RepresentNpcOverview;
import com.shahenpc.system.domain.represent.dto.NpcOverviewWxDto;

/**
 * 人大概览 只存一条信息Mapper接口
 * 
 * @author ruoyi
 * @date 2022-07-21
 */
public interface RepresentNpcOverviewMapper 
{
    /**
     * 查询人大概览 只存一条信息
     * 
     * @param npcId 人大概览 只存一条信息主键
     * @return 人大概览 只存一条信息
     */
    public RepresentNpcOverview selectRepresentNpcOverviewByNpcId(Long npcId);

    /**
     * 查询人大概览 只存一条信息列表
     * 
     * @param representNpcOverview 人大概览 只存一条信息
     * @return 人大概览 只存一条信息集合
     */
    public List<RepresentNpcOverview> selectRepresentNpcOverviewList(RepresentNpcOverview representNpcOverview);

    /**
     * 新增人大概览 只存一条信息
     * 
     * @param representNpcOverview 人大概览 只存一条信息
     * @return 结果
     */
    public int insertRepresentNpcOverview(RepresentNpcOverview representNpcOverview);

    /**
     * 修改人大概览 只存一条信息
     * 
     * @param representNpcOverview 人大概览 只存一条信息
     * @return 结果
     */
    public int updateRepresentNpcOverview(RepresentNpcOverview representNpcOverview);

    /**
     * 删除人大概览 只存一条信息
     * 
     * @param npcId 人大概览 只存一条信息主键
     * @return 结果
     */
    public int deleteRepresentNpcOverviewByNpcId(Long npcId);

    /**
     * 批量删除人大概览 只存一条信息
     * 
     * @param npcIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteRepresentNpcOverviewByNpcIds(Long[] npcIds);

    public RepresentNpcOverview selectByOverview();

    public NpcOverviewWxDto selectByWxOverview();
}
