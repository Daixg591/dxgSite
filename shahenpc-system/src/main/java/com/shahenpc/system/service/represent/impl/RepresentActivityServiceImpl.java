package com.shahenpc.system.service.represent.impl;

import java.util.List;
import com.shahenpc.common.utils.DateUtils;
import com.shahenpc.system.domain.represent.RepresentActivityRecord;
import com.shahenpc.system.domain.represent.dto.RepresentActivityAddDto;
import com.shahenpc.system.mapper.represent.RepresentActivityRecordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shahenpc.system.mapper.represent.RepresentActivityMapper;
import com.shahenpc.system.domain.represent.RepresentActivity;
import com.shahenpc.system.service.represent.IRepresentActivityService;
import org.springframework.transaction.annotation.Transactional;

/**
 * 代-活动列Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-07-21
 */
@Service
public class RepresentActivityServiceImpl implements IRepresentActivityService 
{
    @Autowired
    private RepresentActivityMapper representActivityMapper;
    @Autowired
    private RepresentActivityRecordMapper representActivityRecordMapper;
    /**
     * 查询代-活动列
     * 
     * @param activityId 代-活动列主键
     * @return 代-活动列
     */
    @Override
    public RepresentActivity selectRepresentActivityByActivityId(Long activityId)
    {
        return representActivityMapper.selectRepresentActivityByActivityId(activityId);
    }

    /**
     * 查询代-活动列列表
     * 
     * @param representActivity 代-活动列
     * @return 代-活动列
     */
    @Override
    public List<RepresentActivity> selectRepresentActivityList(RepresentActivity representActivity)
    {
        return representActivityMapper.selectRepresentActivityList(representActivity);
    }

    /**
     * 新增代-活动列
     * 
     * @param representActivity 代-活动列
     * @return 结果
     */
    @Override
    public int insertRepresentActivity(RepresentActivity representActivity)
    {
        representActivity.setCreateTime(DateUtils.getNowDate());
        return representActivityMapper.insertRepresentActivity(representActivity);
    }

    /**
     * 修改代-活动列
     * 
     * @param representActivity 代-活动列
     * @return 结果
     */
    @Override
    public int updateRepresentActivity(RepresentActivity representActivity)
    {
        representActivity.setUpdateTime(DateUtils.getNowDate());
        return representActivityMapper.updateRepresentActivity(representActivity);
    }

    /**
     * 批量删除代-活动列
     * 
     * @param activityIds 需要删除的代-活动列主键
     * @return 结果
     */
    @Override
    public int deleteRepresentActivityByActivityIds(Long[] activityIds)
    {
        return representActivityMapper.deleteRepresentActivityByActivityIds(activityIds);
    }

    /**
     * 删除代-活动列信息
     * 
     * @param activityId 代-活动列主键
     * @return 结果
     */
    @Override
    public int deleteRepresentActivityByActivityId(Long activityId)
    {
        return representActivityMapper.deleteRepresentActivityByActivityId(activityId);
    }

    @Override
    @Transactional
    public int newAdd(RepresentActivityAddDto dto) {
        dto.setCreateTime(DateUtils.getNowDate());
       int suss = representActivityMapper.insertRepresentActivity(dto);
        for(RepresentActivityRecord item:dto.getRecord()){
            item.setActivityId(dto.getActivityId());
            item.setCreateTime(DateUtils.getNowDate());
            representActivityRecordMapper.insertRepresentActivityRecord(item);
        }
        return suss;
    }
}
