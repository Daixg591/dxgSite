package com.shahenpc.system.mapper.represent;

import java.util.List;
import com.shahenpc.system.domain.represent.RepresentActivity;
import com.shahenpc.system.domain.represent.dto.ActivityAppListDto;
import com.shahenpc.system.domain.represent.dto.ActivityDetailDto;
import com.shahenpc.system.domain.represent.dto.ActivityFinishCountDto;

/**
 * 代-活动列Mapper接口
 * 
 * @author ruoyi
 * @date 2022-07-21
 */
public interface RepresentActivityMapper 
{
    /**
     * 查询代-活动列
     * 
     * @param activityId 代-活动列主键
     * @return 代-活动列
     */
    public RepresentActivity selectRepresentActivityByActivityId(Long activityId);

    /**
     * 查询代-活动列列表
     * 
     * @param representActivity 代-活动列
     * @return 代-活动列集合
     */
    public List<RepresentActivity> selectRepresentActivityList(RepresentActivity representActivity);


    /**
     * 查询代表认领列表
     * @param representActivity 代表活动-认领
     * @return 代表活动-认领集合
     */
    public List<RepresentActivity> selectClaimList(RepresentActivity representActivity);

    /**
     * 新增代-活动列
     * 
     * @param representActivity 代-活动列
     * @return 结果
     */
    public int insertRepresentActivity(RepresentActivity representActivity);

    /**
     * 修改代-活动列
     * 
     * @param representActivity 代-活动列
     * @return 结果
     */
    public int updateRepresentActivity(RepresentActivity representActivity);

    /**
     * 删除代-活动列
     * 
     * @param activityId 代-活动列主键
     * @return 结果
     */
    public int deleteRepresentActivityByActivityId(Long activityId);

    /**
     * 批量删除代-活动列
     * 
     * @param activityIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteRepresentActivityByActivityIds(Long[] activityIds);

    public ActivityFinishCountDto selectByFinishCount(Long userId);

    public List<ActivityAppListDto> selectByAppHomeList();

    public List<ActivityAppListDto> appList(RepresentActivity representActivity);

    public ActivityAppListDto appDetail(Long activityId);

    public Integer getCount();

    public ActivityDetailDto newDetail(Long activityId);
}
