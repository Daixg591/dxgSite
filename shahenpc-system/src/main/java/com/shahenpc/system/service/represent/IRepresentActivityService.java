package com.shahenpc.system.service.represent;

import java.util.List;
import com.shahenpc.system.domain.represent.RepresentActivity;
import com.shahenpc.system.domain.represent.dto.*;

/**
 * 代表履职活动列Service接口
 * 
 * @author ruoyi
 * @date 2022-07-21
 */
public interface IRepresentActivityService 
{
    /**
     * 查询代表履职活动列
     * 
     * @param activityId 代表履职活动列主键
     * @return 代表履职活动列
     */
    public RepresentActivity selectRepresentActivityByActivityId(Long activityId);

    /**
     * 查询代表履职活动列列表
     * 
     * @param representActivity 代表履职活动列
     * @return 代表履职活动列集合
     */
    public List<RepresentActivity> selectRepresentActivityList(RepresentActivity representActivity);


    public List<RepresentActivity> selectClaimList(RepresentActivity representActivity);

    /**
     * 新增代表履职活动列
     * 
     * @param representActivity 代表履职活动列
     * @return 结果
     */
    public int insertRepresentActivity(RepresentActivity representActivity);


    /**
     * 查询之前修改状态
     * @param representActivity
     * @return
     */
    public int updateStatusBeforeSelectList(RepresentActivity representActivity);

    /**
     * 修改代表履职活动列
     * 
     * @param representActivity 代表履职活动列
     * @return 结果
     */
    public int updateRepresentActivity(RepresentActivity representActivity);

    /**
     * 批量删除代表履职活动列
     * 
     * @param activityIds 需要删除的代表履职活动列主键集合
     * @return 结果
     */
    public int deleteRepresentActivityByActivityIds(Long[] activityIds);

    /**
     * 删除代表履职活动列信息
     * 
     * @param activityId 代表履职活动列主键
     * @return 结果
     */
    public int deleteRepresentActivityByActivityId(Long activityId);


    public int newAdd(ActivityAddDto dto);
    public int newUpdate(ActivityAddDto dto);
    public ActivityDetailDto newDetail(Long activityId);

    public ActivityFinishCountDto selectByFinishCount(Long userId);

    public List<ActivityAppListDto> appList(RepresentActivity representActivity);

    public ActivityAppListDto appDetail(Long activityId);

    /** 履职 总数  排行*/
    public PerformDutieConutDto totalConut();

    public List<ActivityPieDto> pie();

    public List<RepresentActivity> selectByUserId(RepresentActivity meeting);

}
