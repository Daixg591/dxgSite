package com.shahenpc.system.service.represent.impl;

import java.util.List;
import com.shahenpc.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shahenpc.system.mapper.represent.RepresentActivityGroupMapper;
import com.shahenpc.system.domain.represent.RepresentActivityGroup;
import com.shahenpc.system.service.represent.IRepresentActivityGroupService;

/**
 * 【代表认领/活动分组】Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-12-12
 */
@Service
public class RepresentActivityGroupServiceImpl implements IRepresentActivityGroupService 
{
    @Autowired
    private RepresentActivityGroupMapper representActivityGroupMapper;

    /**
     * 查询【代表认领/活动分组】
     * 
     * @param activityGroupId 【代表认领/活动分组】主键
     * @return 【代表认领/活动分组】
     */
    @Override
    public RepresentActivityGroup selectRepresentActivityGroupByActivityGroupId(Long activityGroupId)
    {
        return representActivityGroupMapper.selectRepresentActivityGroupByActivityGroupId(activityGroupId);
    }

    /**
     * 查询【代表认领/活动分组】列表
     * 
     * @param representActivityGroup 【代表认领/活动分组】
     * @return 【代表认领/活动分组】
     */
    @Override
    public List<RepresentActivityGroup> selectRepresentActivityGroupList(RepresentActivityGroup representActivityGroup)
    {
        return representActivityGroupMapper.selectRepresentActivityGroupList(representActivityGroup);
    }

    /**
     * 新增【代表认领/活动分组】
     * 
     * @param representActivityGroup 【代表认领/活动分组】
     * @return 结果
     */
    @Override
    public Long insertRepresentActivityGroup(RepresentActivityGroup representActivityGroup)
    {
        representActivityGroup.setCreateTime(DateUtils.getNowDate());
        representActivityGroupMapper.insertRepresentActivityGroup(representActivityGroup);
        Long aa=representActivityGroup.getActivityGroupId();
        return aa;
    }

    /**
     * 修改【代表认领/活动分组】
     * 
     * @param representActivityGroup 【代表认领/活动分组】
     * @return 结果
     */
    @Override
    public int updateRepresentActivityGroup(RepresentActivityGroup representActivityGroup)
    {
        representActivityGroup.setUpdateTime(DateUtils.getNowDate());
        return representActivityGroupMapper.updateRepresentActivityGroup(representActivityGroup);
    }

    /**
     * 批量删除【代表认领/活动分组】
     * 
     * @param activityGroupIds 需要删除的【代表认领/活动分组】主键
     * @return 结果
     */
    @Override
    public int deleteRepresentActivityGroupByActivityGroupIds(Long[] activityGroupIds)
    {
        return representActivityGroupMapper.deleteRepresentActivityGroupByActivityGroupIds(activityGroupIds);
    }

    @Override
    public int deleteByActivityId(Long activityId){
        return representActivityGroupMapper.deleteByActivityId(activityId);
    }

    /**
     * 删除【代表认领/活动分组】信息
     * 
     * @param activityGroupId 【代表认领/活动分组】主键
     * @return 结果
     */
    @Override
    public int deleteRepresentActivityGroupByActivityGroupId(Long activityGroupId)
    {
        return representActivityGroupMapper.deleteRepresentActivityGroupByActivityGroupId(activityGroupId);
    }
}
