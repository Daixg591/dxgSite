package com.shahenpc.system.service.feature.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.shahenpc.common.core.domain.entity.SysDictData;
import com.shahenpc.common.utils.DateUtils;
import com.shahenpc.system.domain.feature.FeatureDoubleWorkTrace;
import com.shahenpc.system.domain.feature.dto.FeatureCakeDto;
import com.shahenpc.system.domain.feature.dto.FeatureEachCount;
import com.shahenpc.system.domain.feature.dto.FeatureMonthDto;
import com.shahenpc.system.mapper.feature.FeatureDoubleWorkTraceMapper;
import com.shahenpc.system.service.ISysDictDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shahenpc.system.mapper.feature.FeatureDoubleWorkMapper;
import com.shahenpc.system.domain.feature.FeatureDoubleWork;
import com.shahenpc.system.service.feature.IFeatureDoubleWorkService;

/**
 * 双联工作Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-07-13
 */
@Service
public class FeatureDoubleWorkServiceImpl implements IFeatureDoubleWorkService 
{
    @Autowired
    private FeatureDoubleWorkMapper featureDoubleWorkMapper;
    @Autowired
    private ISysDictDataService dictDataService;
    @Autowired
    private FeatureDoubleWorkTraceMapper featureDoubleWorkTraceMapper;
    /**
     * 查询双联工作
     * 
     * @param doubleId 双联工作主键
     * @return 双联工作
     */
    @Override
    public FeatureDoubleWork selectFeatureDoubleWorkByDoubleId(Long doubleId)
    {
        return featureDoubleWorkMapper.selectFeatureDoubleWorkByDoubleId(doubleId);
    }

    /**
     * 查询双联工作列表
     * 
     * @param featureDoubleWork 双联工作
     * @return 双联工作
     */
    @Override
    public List<FeatureDoubleWork> selectFeatureDoubleWorkList(FeatureDoubleWork featureDoubleWork)
    {
        return featureDoubleWorkMapper.selectFeatureDoubleWorkList(featureDoubleWork);
    }

    /**
     * 新增双联工作
     * 
     * @param featureDoubleWork 双联工作
     * @return 结果
     */
    @Override
    public int insertFeatureDoubleWork(FeatureDoubleWork featureDoubleWork)
    {
        featureDoubleWork.setCreateTime(DateUtils.getNowDate());
        return featureDoubleWorkMapper.insertFeatureDoubleWork(featureDoubleWork);
    }

    /**
     * 修改双联工作
     * 
     * @param featureDoubleWork 双联工作
     * @return 结果
     */
    @Override
    public int updateFeatureDoubleWork(FeatureDoubleWork featureDoubleWork)
    {
        featureDoubleWork.setUpdateTime(DateUtils.getNowDate());
        return featureDoubleWorkMapper.updateFeatureDoubleWork(featureDoubleWork);
    }

    /**
     * 批量删除双联工作
     * 
     * @param doubleIds 需要删除的双联工作主键
     * @return 结果
     */
    @Override
    public int deleteFeatureDoubleWorkByDoubleIds(Long[] doubleIds)
    {
        return featureDoubleWorkMapper.deleteFeatureDoubleWorkByDoubleIds(doubleIds);
    }

    /**
     * 删除双联工作信息
     * 
     * @param doubleId 双联工作主键
     * @return 结果
     */
    @Override
    public int deleteFeatureDoubleWorkByDoubleId(Long doubleId)
    {
        return featureDoubleWorkMapper.deleteFeatureDoubleWorkByDoubleId(doubleId);
    }

    @Override
    public List<FeatureCakeDto> speCake() {
        List<FeatureCakeDto> dtoList = new ArrayList<>();
        List<FeatureDoubleWork> alarBudg=featureDoubleWorkMapper.selectByCakeType();
        SysDictData dictParam = new SysDictData();
        dictParam.setDictType("opinion_type");
        List<SysDictData> dictList = dictDataService.selectDictDataList(dictParam);
        for (int i = 0; i < dictList.size(); i++) {
            int finalI = i;
            int v = alarBudg.stream().filter(p -> dictList.get(finalI).getDictValue().equals(p.getDoubleType()))
                    .collect(Collectors.toList()).size();
            FeatureCakeDto item = new FeatureCakeDto();
            item.setName(dictList.get(i).getDictLabel());
            item.setValue(v);
            dtoList.add(item);
        }
        return dtoList;
    }

    @Override
    public List<FeatureMonthDto> selectByMonth() {
        return featureDoubleWorkMapper.selectByMonth();
    }


    @Override
    public int newAdd(FeatureDoubleWork featureDoubleWork) {
        featureDoubleWork.setCreateTime(DateUtils.getNowDate());
        int a =  featureDoubleWorkMapper.insertFeatureDoubleWork(featureDoubleWork);
        FeatureDoubleWorkTrace featureDoubleWorkTrace = new FeatureDoubleWorkTrace();
        featureDoubleWorkTrace.setDoubleId(featureDoubleWork.getDoubleId());
        featureDoubleWorkTrace.setSendUserId(featureDoubleWork.getSubmitUserId());
        featureDoubleWorkTrace.setReceiveUserId(featureDoubleWork.getReceiveUserId());
        featureDoubleWorkTrace.setStatus(featureDoubleWork.getStatus());
        featureDoubleWorkTrace.setContent(featureDoubleWork.getContent());
        featureDoubleWorkTrace.setCreateTime(DateUtils.getNowDate());
        featureDoubleWorkTraceMapper.insertFeatureDoubleWorkTrace(featureDoubleWorkTrace);
        return a;
    }

    @Override
    public int newUpdate(FeatureDoubleWork featureDoubleWork) {
        featureDoubleWork.setUpdateTime(DateUtils.getNowDate());
        int a =  featureDoubleWorkMapper.updateFeatureDoubleWork(featureDoubleWork);
        FeatureDoubleWorkTrace featureDoubleWorkTrace = new FeatureDoubleWorkTrace();
        featureDoubleWorkTrace.setDoubleId(featureDoubleWork.getDoubleId());
        featureDoubleWorkTrace.setSendUserId(featureDoubleWork.getSubmitUserId());
        featureDoubleWorkTrace.setReceiveUserId(featureDoubleWork.getReceiveUserId());
        featureDoubleWorkTrace.setStatus(featureDoubleWork.getStatus());
        featureDoubleWorkTrace.setContent(featureDoubleWork.getContent());
        featureDoubleWorkTrace.setCreateTime(DateUtils.getNowDate());
        featureDoubleWorkTraceMapper.insertFeatureDoubleWorkTrace(featureDoubleWorkTrace);
        return a;
    }

    @Override
    public int appNewAdd(FeatureDoubleWork featureDoubleWork) {
        featureDoubleWork.setCreateTime(DateUtils.getNowDate());
        int a =  featureDoubleWorkMapper.insertFeatureDoubleWork(featureDoubleWork);
        FeatureDoubleWorkTrace featureDoubleWorkTrace = new FeatureDoubleWorkTrace();
        featureDoubleWorkTrace.setDoubleId(featureDoubleWork.getDoubleId());
        featureDoubleWorkTrace.setSendUserId(featureDoubleWork.getSubmitUserId());
        featureDoubleWorkTrace.setReceiveUserId(featureDoubleWork.getReceiveUserId());
        featureDoubleWorkTrace.setStatus(featureDoubleWork.getStatus());
        featureDoubleWorkTrace.setContent(featureDoubleWork.getContent());
        featureDoubleWorkTrace.setCreateTime(DateUtils.getNowDate());
        featureDoubleWorkTrace.setPicUrls(featureDoubleWork.getPicUrls());
        featureDoubleWorkTraceMapper.insertFeatureDoubleWorkTrace(featureDoubleWorkTrace);
        return a;
    }

    @Override
    public FeatureEachCount eachCount() {
        FeatureEachCount each =  featureDoubleWorkMapper.eachCount();
        if(each.getProcessed() != 0 && each.getProportion() != 0) {
            each.setProportion(each.getProcessed() / (each.getProcessed() + each.getProportion()));
        }
        each.setProportion(Double.valueOf(String.format("%.2f", each.getProportion())));
        return each;
    }


}
