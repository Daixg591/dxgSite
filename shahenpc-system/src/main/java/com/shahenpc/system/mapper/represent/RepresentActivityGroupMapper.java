package com.shahenpc.system.mapper.represent;

import java.util.List;
import com.shahenpc.system.domain.represent.RepresentActivityGroup;

/**
 * 【代表认领/活动分组】Mapper接口
 * 
 * @author ruoyi
 * @date 2022-12-12
 */
public interface RepresentActivityGroupMapper 
{
    /**
     * 查询【代表认领/活动分组】
     * 
     * @param activityGroupId 【代表认领/活动分组】主键
     * @return 【代表认领/活动分组】
     */
    public RepresentActivityGroup selectRepresentActivityGroupByActivityGroupId(Long activityGroupId);

    /**
     * 查询【代表认领/活动分组】列表
     * 
     * @param representActivityGroup 【代表认领/活动分组】
     * @return 【代表认领/活动分组】集合
     */
    public List<RepresentActivityGroup> selectRepresentActivityGroupList(RepresentActivityGroup representActivityGroup);

    /**
     * 新增【代表认领/活动分组】
     * 
     * @param representActivityGroup 【代表认领/活动分组】
     * @return 结果
     */
    public int insertRepresentActivityGroup(RepresentActivityGroup representActivityGroup);

    /**
     * 修改【代表认领/活动分组】
     * 
     * @param representActivityGroup 【代表认领/活动分组】
     * @return 结果
     */
    public int updateRepresentActivityGroup(RepresentActivityGroup representActivityGroup);

    /**
     * 删除【代表认领/活动分组】
     * 
     * @param activityGroupId 【代表认领/活动分组】主键
     * @return 结果
     */
    public int deleteRepresentActivityGroupByActivityGroupId(Long activityGroupId);

    /**
     * 根据活动id批量删除【代表认领/活动分组】
     *
     * @param activityGroupIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteByActivityId(Long activityId);

    /**
     * 批量删除【代表认领/活动分组】
     * 
     * @param activityGroupIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteRepresentActivityGroupByActivityGroupIds(Long[] activityGroupIds);
}
