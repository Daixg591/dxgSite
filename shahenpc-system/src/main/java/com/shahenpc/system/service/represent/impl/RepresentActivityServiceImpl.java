package com.shahenpc.system.service.represent.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.shahenpc.common.core.domain.entity.SysDictData;
import com.shahenpc.common.utils.DateUtils;
import com.shahenpc.system.domain.feature.FeatureDoubleWork;
import com.shahenpc.system.domain.feature.dto.FeatureCakeDto;
import com.shahenpc.system.domain.represent.RepresentActivityRecord;
import com.shahenpc.system.domain.represent.RepresentWorkLog;
import com.shahenpc.system.domain.represent.dto.*;
import com.shahenpc.system.mapper.feature.FeatureDoubleWorkMapper;
import com.shahenpc.system.mapper.represent.*;
import com.shahenpc.system.service.ISysDictDataService;
import com.shahenpc.system.service.ISysDictTypeService;
import com.shahenpc.system.service.represent.IRepresentWorkLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
    @Autowired
    private RepresentExperienceMapper representExperienceMapper;
    @Autowired
    private FeatureDoubleWorkMapper featureDoubleWorkMapper;
    @Autowired
    private RepresentDiscoverMapper representDiscoverMapper;
    @Autowired
    private RepresentMotionMapper representMotionMapper;
    @Autowired
    private RepresentProposalMapper representProposalMapper;
    @Autowired
    private ISysDictTypeService sysDictTypeService;
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

    @Override
    public List<RepresentActivity> selectClaimList(RepresentActivity representActivity) {
        return representActivityMapper.selectClaimList(representActivity);
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

    @Autowired
    private IRepresentWorkLogService representWorkLogService;

    @Override
    @Transactional
    public int newAdd(ActivityAddDto dto) {
        dto.setCreateTime(DateUtils.getNowDate());
       int suss = representActivityMapper.insertRepresentActivity(dto);
        RepresentWorkLog log = new RepresentWorkLog();
        log.setEventType(1);
        log.setEventId(dto.getActivityId());
        log.setUserId(dto.getSendUserId());
        log.setRemark("履职活动！");
        representWorkLogService.insertRepresentWorkLog(log);
        for(RepresentActivityRecord item:dto.getRecord()){
            item.setActivityId(dto.getActivityId());
            item.setCreateTime(DateUtils.getNowDate());
            representActivityRecordMapper.insertRepresentActivityRecord(item);
        }
        RepresentActivity ac = new  RepresentActivity();
        ac.setActivityId(dto.getActivityId());
        ac.setParticipateConut(dto.getRecord().size());
        representActivityMapper.updateRepresentActivity(ac);
        return suss;
    }

    @Override
    public int newUpdate(ActivityAddDto dto) {
       int a =  representActivityMapper.updateRepresentActivity(dto);
            representActivityRecordMapper.delectByActivityId(dto.getActivityId());
            for(RepresentActivityRecord item:dto.getRecord()){
                item.setActivityId(dto.getActivityId());
                item.setCreateTime(DateUtils.getNowDate());
                representActivityRecordMapper.insertRepresentActivityRecord(item);
            }
            RepresentActivity ac = new  RepresentActivity();
            ac.setActivityId(dto.getActivityId());
            ac.setParticipateConut(dto.getRecord().size());
            representActivityMapper.updateRepresentActivity(ac);
        return a;
    }

    @Override
    public ActivityDetailDto newDetail(Long activityId) {

        return representActivityMapper.newDetail(activityId);
    }

    @Override
    public ActivityFinishCountDto selectByFinishCount(Long userId) {
        ActivityFinishCountDto  dto = representActivityMapper.selectByFinishCount(userId);
        dto.setActivityList(representActivityMapper.selectByAppHomeList());
        return dto;
    }

    @Override
    public List<ActivityAppListDto> appList(RepresentActivity representActivity) {
        return representActivityMapper.appList(representActivity);
    }

    @Override
    public ActivityAppListDto appDetail(Long activityId) {
        return representActivityMapper.appDetail(activityId);
    }


    @Override
    public PerformDutieConutDto totalConut() {
        PerformDutieConutDto dto = new PerformDutieConutDto();
        dto.setActivityCount(representActivityMapper.getCount());
        dto.setExperienceCount(representExperienceMapper.getCount());
        dto.setDoubleCount(featureDoubleWorkMapper.getCount());
        dto.setDiscoveryCount(representDiscoverMapper.getCount());

        //改成建议
        dto.setMotionCount(representProposalMapper.getCount());
        dto.setTotalCount(dto.getActivityCount()+dto.getDoubleCount()+dto.getDiscoveryCount()+dto.getMotionCount()+dto.getExperienceCount());
        return dto;
    }
    @Autowired
    private ISysDictDataService dictDataService;
    @Override
    public List<ActivityPieDto> pie() {
        List<ActivityPieDto> dtoList = new ArrayList<>();
        List<RepresentActivity> alarBudg=representActivityMapper.selectRepresentActivityList(null);
        List<SysDictData> dictList=sysDictTypeService.selectDictDataByType("activity_type");
        for (int i = 0; i < dictList.size(); i++) {
            int finalI = i;
            int v = 0;
            v = alarBudg.stream().filter(p -> dictList.get(finalI).getDictValue().equals(p.getActivityType().toString()))
                    .collect(Collectors.toList()).size();
            ActivityPieDto item = new ActivityPieDto();
            item.setName(dictList.get(i).getDictLabel());
            item.setValue(v);
            dtoList.add(item);
        }
        return dtoList;
    }


}
