package com.shahenpc.system.service.represent.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

import com.shahenpc.common.core.domain.entity.SysDictData;
import com.shahenpc.common.utils.DateUtils;
import com.shahenpc.system.domain.feature.FeatureDoubleWork;
import com.shahenpc.system.domain.feature.dto.FeatureCakeDto;
import com.shahenpc.system.domain.represent.*;
import com.shahenpc.system.domain.represent.dto.*;
import com.shahenpc.system.mapper.feature.FeatureDoubleWorkMapper;
import com.shahenpc.system.mapper.represent.*;
import com.shahenpc.system.service.ISysDictDataService;
import com.shahenpc.system.service.ISysDictTypeService;
import com.shahenpc.system.service.represent.IRepresentActivityClaimService;
import com.shahenpc.system.service.represent.IRepresentActivityGroupService;
import com.shahenpc.system.service.represent.IRepresentWorkLogService;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shahenpc.system.service.represent.IRepresentActivityService;
import org.springframework.transaction.annotation.Transactional;

/**
 * 代表履职活动列Service业务层处理
 *
 * @author ruoyi
 * @date 2022-07-21
 */
@Service
public class RepresentActivityServiceImpl implements IRepresentActivityService {
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

    @Autowired
    private IRepresentActivityGroupService groupService;

    @Autowired
    private IRepresentActivityClaimService claimService;

    /**
     * 查询代表履职活动列
     *
     * @param activityId 代表履职活动列主键
     * @return 代表履职活动列
     */
    @Override
    public RepresentActivity selectRepresentActivityByActivityId(Long activityId) {
        return representActivityMapper.selectRepresentActivityByActivityId(activityId);
    }

    /**
     * 查询代表履职活动列列表
     *
     * @param representActivity 代表履职活动列
     * @return 代表履职活动列
     */
    @Override
    public List<RepresentActivity> selectRepresentActivityList(RepresentActivity representActivity) {
        return representActivityMapper.selectRepresentActivityList(representActivity);
    }

    @Override
    public List<RepresentActivity> selectClaimList(RepresentActivity representActivity) {
        return representActivityMapper.selectClaimList(representActivity);
    }

    /**
     * 新增代表履职活动列
     *
     * @param representActivity 代表履职活动列
     * @return 结果
     */
    @Override
    public int insertRepresentActivity(RepresentActivity representActivity) {
        representActivity.setCreateTime(DateUtils.getNowDate());
        return representActivityMapper.insertRepresentActivity(representActivity);
    }

    /**
     * 查询之前修改状态
     *
     * @param representActivity
     * @return
     */
    public int updateStatusBeforeSelectList(RepresentActivity representActivity) {
        return representActivityMapper.updateStatusBeforeSelectList(representActivity);
    }

    /**
     * 修改代表履职活动列
     *
     * @param representActivity 代表履职活动列
     * @return 结果
     */
    @Override
    public int updateRepresentActivity(RepresentActivity representActivity) {
        representActivity.setUpdateTime(DateUtils.getNowDate());
        return representActivityMapper.updateRepresentActivity(representActivity);
    }

    /**
     * 批量删除代表履职活动列
     *
     * @param activityIds 需要删除的代表履职活动列主键
     * @return 结果
     */
    @Override
    public int deleteRepresentActivityByActivityIds(Long[] activityIds) {
        return representActivityMapper.deleteRepresentActivityByActivityIds(activityIds);
    }

    /**
     * 删除代表履职活动列信息
     *
     * @param activityId 代表履职活动列主键
     * @return 结果
     */
    @Override
    public int deleteRepresentActivityByActivityId(Long activityId) {
        return representActivityMapper.deleteRepresentActivityByActivityId(activityId);
    }

    @Autowired
    private IRepresentWorkLogService representWorkLogService;

    /**
     * 新增代表履职活动/代表认领
     *
     * @param dto
     * @return
     */
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

        // 分组处理逻辑
        if (dto.getGroupList() != null && dto.getGroupList().size() > 0) {
            for (int i = 0; i < dto.getGroupList().size(); i++) {
                RepresentActivityGroup tempGroupEntity = new RepresentActivityGroup();
                tempGroupEntity.setGroupName(dto.getGroupList().get(i).getGroupName());
                tempGroupEntity.setActivityId(dto.getActivityId());
                tempGroupEntity.setCreateBy(dto.getCreateBy());
                Long resGroupId = groupService.insertRepresentActivityGroup(tempGroupEntity);

                // 新增反馈记录/认领记录
//                List<RepresentActivityRecord> RecordListData = new ArrayList<RepresentActivityRecord>();
                List<RepresentActivityClaim> claims = new ArrayList<RepresentActivityClaim>();
                for (int j = 0; j < dto.getGroupList().get(i).getUserIds().size(); j++) {

                    RepresentActivityClaim claim = new RepresentActivityClaim();
                    claim.setActivityId(dto.getActivityId());
                    claim.setUserId(dto.getGroupList().get(i).getUserIds().get(j));
                    claim.setCreateBy(dto.getCreateBy());
                    claim.setCreateTime(DateUtils.getNowDate());
                    claim.setActivityGroupId(resGroupId);
                    if (dto.getNpcClaim()) {
                        claim.setStatus(1);
                    } else {
                        claim.setStatus(2);
                    }
                    claims.add(claim);
                    //region // 废弃 新增记录逻辑
                    //                    RepresentActivityRecord tempRecordEntity = new RepresentActivityRecord();
//                    tempRecordEntity.setActivityId(dto.getActivityId());
//                    tempRecordEntity.setUserId(dto.getGroupList().get(i).getUserIds().get(j));
//                    tempRecordEntity.setCreateBy(dto.getCreateBy());
//                    tempRecordEntity.setStatus(1);
//                    tempRecordEntity.setCreateTime(DateUtils.getNowDate());
//                    tempRecordEntity.setActivityGroupId(resGroupId);
//                    if (dto.getNpcClaim()) {
//                        tempRecordEntity.setStatus(1);
//                    } else {
//                        tempRecordEntity.setStatus(2);
//                    }
//                    RecordListData.add(tempRecordEntity);
                    //endregion
                }
                //  representActivityRecordMapper.insertList(RecordListData);
                claimService.insertList(claims);

            }
        } else {
            List<RepresentActivityClaim> claims = new ArrayList<RepresentActivityClaim>();
            for (int j = 0; j < dto.getGroupUserList().size(); j++) {
                RepresentActivityClaim claim = new RepresentActivityClaim();
                claim.setActivityId(dto.getActivityId());
                claim.setCreateBy(dto.getCreateBy());
                claim.setCreateTime(DateUtils.getNowDate());
                claim.setUserId(dto.getGroupUserList().get(j).getUserId());
                if (dto.getNpcClaim()) {
                    claim.setStatus(1);
                } else {
                    claim.setStatus(2);
                }
                claims.add(claim);
            }
            claimService.insertList(claims);
            //region // 废弃 旧的记录逻辑
            /*List<RepresentActivityRecord> RecordDate = new ArrayList<RepresentActivityRecord>();
            for (RepresentActivityRecord item : dto.getRecord()) {
                item.setActivityId(dto.getActivityId());
                item.setCreateTime(DateUtils.getNowDate());
                item.setCreateBy(dto.getCreateBy());
                if (dto.getNpcClaim()) {
                    item.setStatus(1);
                } else {
                    item.setStatus(2);
                }
                RecordDate.add(item);
            }*/
//            representActivityRecordMapper.insertList(RecordDate);
            //endregion

        }
        representWorkLogService.insertRepresentWorkLog(log);

        RepresentActivity ac = new RepresentActivity();
        ac.setActivityId(dto.getActivityId());
        ac.setParticipateConut(dto.getGroupUserList().size());
        representActivityMapper.updateRepresentActivity(ac);
        return suss;
    }


    /**
     * 修改代表履职活动/代表认领
     *
     * @param dto
     * @return
     */
    @Override
    public int newUpdate(ActivityAddDto dto) {
        int a = representActivityMapper.updateRepresentActivity(dto);

        //region  Description
        //        RepresentActivityRecord recordDto = new RepresentActivityRecord();
//        recordDto.setActivityId(dto.getActivityId());
//        List<RepresentActivityRecord> oldRecordList = representActivityRecordMapper.selectRepresentActivityRecordList(recordDto).stream().filter(x -> x.getContent() != null).collect(Collectors.toList());
        //endregion

        RepresentActivityClaim claimDto = new RepresentActivityClaim();
        claimDto.setActivityId(dto.getActivityId());
        List<RepresentActivityClaim> oldRecordList = claimService.selectRepresentActivityClaimList(claimDto).stream().filter(x -> x.getStatus() == 2).collect(Collectors.toList());

        // 删除原有的分组以及 认领记录
        groupService.deleteByActivityId(dto.getActivityId());
        claimService.deleteByActivityId(dto.getActivityId());

        //region // 分组以及 认领记录内容处理
        List<RepresentActivityClaim> resList = new ArrayList<RepresentActivityClaim>();
        List<RepresentActivityClaim> newList = new ArrayList<RepresentActivityClaim>();
        if (dto.getGroupList() != null && dto.getGroupList().size() > 0) {
            for (int i = 0; i < dto.getGroupList().size(); i++) {
                RepresentActivityGroup tempGroupEntity = new RepresentActivityGroup();
                tempGroupEntity.setGroupName(dto.getGroupList().get(i).getGroupName());
                tempGroupEntity.setActivityId(dto.getActivityId());
                tempGroupEntity.setCreateBy(dto.getCreateBy());
                Long resGroupId = groupService.insertRepresentActivityGroup(tempGroupEntity);

//                List<RepresentActivityRecord> RecordListData = new ArrayList<RepresentActivityRecord>();
                List<RepresentActivityClaim> claims = new ArrayList<RepresentActivityClaim>();

                for (int j = 0; j < dto.getGroupList().get(i).getUserIds().size(); j++) {

//                    RepresentActivityRecord tempRecordEntity = new RepresentActivityRecord();
                    RepresentActivityClaim claim = new RepresentActivityClaim();

                    claim.setActivityId(dto.getActivityId());
                    claim.setUserId(dto.getGroupList().get(i).getUserIds().get(j));
                    claim.setCreateBy(dto.getCreateBy());
                    claim.setStatus(1);
                    claim.setCreateTime(DateUtils.getNowDate());
                    claim.setActivityGroupId(resGroupId);
                    if (dto.getNpcClaim()) {
                        claim.setStatus(1);
                    } else {
                        claim.setStatus(2);
                    }
                    claims.add(claim);
                }

                resList = newList(getContentRecordList(oldRecordList, claims));
                newList = newList(getAddRecordList(oldRecordList, claims));
                List<RepresentActivityClaim> resData = new ArrayList<RepresentActivityClaim>();
                resData.addAll(resList);
                resData.addAll(newList);
                resData = newList(resData);
                if (resData != null && resData.size() > 0) {
                    claimService.insertList(resData);
                }
            }

        } else {
            List<RepresentActivityClaim> recordDate = new ArrayList<RepresentActivityClaim>();
            for (RepresentActivityClaim item : dto.getGroupUserList()) {
                item.setActivityId(dto.getActivityId());
                item.setUpdateTime(DateUtils.getNowDate());
                item.setUpdateBy(dto.getUpdateBy());
                if (dto.getNpcClaim()) {
                    item.setStatus(1);
                } else {
                    item.setStatus(2);
                }
                recordDate.add(item);
            }
            resList = newList(getContentRecordList(oldRecordList, recordDate));
            newList = newList(getAddRecordList(oldRecordList, recordDate));
            List<RepresentActivityClaim> resData = new ArrayList<RepresentActivityClaim>();
            resData.addAll(resList);
            resData.addAll(newList);
            if (resData != null && resData.size() > 0) {
                claimService.insertList(resData);
            }

        }
        //endregion

        //region // old code
        //        List<RepresentActivityRecord> RecordDate = new ArrayList<RepresentActivityRecord>();
//        for (RepresentActivityRecord item : dto.getRecord()) {
//            item.setActivityId(dto.getActivityId());
//            item.setUpdateTime(DateUtils.getNowDate());
//            item.setUpdateBy(dto.getUpdateBy());
//            if (dto.getNpcClaim()) {
//                item.setStatus(1);
//            } else {
//                item.setStatus(2);
//            }
//            RecordDate.add(item);
//        }
//
//        representActivityRecordMapper.insertList(RecordDate);
        //endregion

        RepresentActivity ac = new RepresentActivity();
        ac.setActivityId(dto.getActivityId());
        ac.setParticipateConut(dto.getRecord().size());
        representActivityMapper.updateRepresentActivity(ac);
        return a;

    }

    /**
     * 获取新旧集合的交集数据
     * 获取需要保留的数据集并直接入库
     *
     * @param oldList
     * @return
     */
    private List<RepresentActivityClaim> getContentRecordList(List<RepresentActivityClaim> oldList, List<RepresentActivityClaim> newList) {

        // 获取oldList和newList的交集，并将交集中的数据保存到结果数据集中
        List<RepresentActivityClaim> resList = new ArrayList<RepresentActivityClaim>();
        for (RepresentActivityClaim oldItem : oldList) {
            for (RepresentActivityClaim newItem : newList) {
                if (oldItem.getUserId().equals(newItem.getUserId())) {
                    newItem.setStatus(oldItem.getStatus());
                    newItem.setCreateTime(oldItem.getCreateTime());
                    newItem.setCreateBy(oldItem.getCreateBy());
                    newItem.setUpdateTime(oldItem.getUpdateTime());
                    newItem.setUpdateBy(oldItem.getUpdateBy());
                    resList.add(newItem);
                }
            }
        }
        return resList;
    }


    //集合去重
    private List<RepresentActivityClaim> newList(List<RepresentActivityClaim> list) {
        return list.stream().collect(
                Collectors.collectingAndThen(
                        Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(o -> o.getActivityId() + ";" + o.getUserId()))), ArrayList::new)
        );
    }

    //region  获取新旧集合的补集数据

    /**
     * 获取新旧集合的补集数据
     * 删除后，需要直接入库的反馈/记录 内容
     *
     * @param oldList
     * @return
     */
    private List<RepresentActivityClaim> getAddRecordList(List<RepresentActivityClaim> oldList, List<RepresentActivityClaim> newList) {
        // 获取oldList 和 newList 的补集数据
        List<RepresentActivityClaim> resList = new ArrayList<RepresentActivityClaim>();
        for (RepresentActivityClaim newItem : newList) {
            boolean isExist = false;
            for (RepresentActivityClaim oldItem : oldList) {
                if (oldItem.getUserId().equals(newItem.getUserId()) && oldItem.getActivityGroupId().equals(newItem.getActivityGroupId())) {
                    isExist = true;
                }
            }
            if (!isExist) {
                resList.add(newItem);
            }
        }
        return resList;
    }
    //endregion


    @Override
    public ActivityDetailDto newDetail(Long activityId) {

        return representActivityMapper.newDetail(activityId);
    }

    @Override
    public ActivityFinishCountDto selectByFinishCount(Long userId) {
        ActivityFinishCountDto dto = representActivityMapper.selectByFinishCount(userId);
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
        dto.setTotalCount(dto.getActivityCount() + dto.getDoubleCount() + dto.getDiscoveryCount() + dto.getMotionCount() + dto.getExperienceCount());
        return dto;
    }

    @Autowired
    private ISysDictDataService dictDataService;

    @Override
    public List<ActivityPieDto> pie() {
        List<ActivityPieDto> dtoList = new ArrayList<>();
        List<RepresentActivity> alarBudg = representActivityMapper.selectRepresentActivityList(null);
        List<SysDictData> dictList = sysDictTypeService.selectDictDataByType("activity_categories");
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

    @Override
    public List<RepresentActivity> selectByUserId(RepresentActivity meeting) {
        return representActivityMapper.selectByUserId(meeting);
    }


}
