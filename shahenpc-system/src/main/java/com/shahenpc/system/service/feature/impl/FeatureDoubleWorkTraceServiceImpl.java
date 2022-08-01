package com.shahenpc.system.service.feature.impl;

import java.util.List;
import com.shahenpc.common.utils.DateUtils;
import com.shahenpc.system.domain.feature.dto.TraceListDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shahenpc.system.mapper.feature.FeatureDoubleWorkTraceMapper;
import com.shahenpc.system.domain.feature.FeatureDoubleWorkTrace;
import com.shahenpc.system.service.feature.IFeatureDoubleWorkTraceService;

/**
 * 双连工作 聊天Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-07-13
 */
@Service
public class FeatureDoubleWorkTraceServiceImpl implements IFeatureDoubleWorkTraceService 
{
    @Autowired
    private FeatureDoubleWorkTraceMapper featureDoubleWorkTraceMapper;

    /**
     * 查询双连工作 聊天
     * 
     * @param traceId 双连工作 聊天主键
     * @return 双连工作 聊天
     */
    @Override
    public FeatureDoubleWorkTrace selectFeatureDoubleWorkTraceByTraceId(Long traceId)
    {
        return featureDoubleWorkTraceMapper.selectFeatureDoubleWorkTraceByTraceId(traceId);
    }

    /**
     * 查询双连工作 聊天列表
     * 
     * @param featureDoubleWorkTrace 双连工作 聊天
     * @return 双连工作 聊天
     */
    @Override
    public List<FeatureDoubleWorkTrace> selectFeatureDoubleWorkTraceList(FeatureDoubleWorkTrace featureDoubleWorkTrace)
    {
        return featureDoubleWorkTraceMapper.selectFeatureDoubleWorkTraceList(featureDoubleWorkTrace);
    }

    /**
     * 新增双连工作 聊天
     * 
     * @param featureDoubleWorkTrace 双连工作 聊天
     * @return 结果
     */
    @Override
    public int insertFeatureDoubleWorkTrace(FeatureDoubleWorkTrace featureDoubleWorkTrace)
    {
        featureDoubleWorkTrace.setCreateTime(DateUtils.getNowDate());
        return featureDoubleWorkTraceMapper.insertFeatureDoubleWorkTrace(featureDoubleWorkTrace);
    }

    /**
     * 修改双连工作 聊天
     * 
     * @param featureDoubleWorkTrace 双连工作 聊天
     * @return 结果
     */
    @Override
    public int updateFeatureDoubleWorkTrace(FeatureDoubleWorkTrace featureDoubleWorkTrace)
    {
        featureDoubleWorkTrace.setUpdateTime(DateUtils.getNowDate());
        return featureDoubleWorkTraceMapper.updateFeatureDoubleWorkTrace(featureDoubleWorkTrace);
    }

    /**
     * 批量删除双连工作 聊天
     * 
     * @param traceIds 需要删除的双连工作 聊天主键
     * @return 结果
     */
    @Override
    public int deleteFeatureDoubleWorkTraceByTraceIds(Long[] traceIds)
    {
        return featureDoubleWorkTraceMapper.deleteFeatureDoubleWorkTraceByTraceIds(traceIds);
    }

    /**
     * 删除双连工作 聊天信息
     * 
     * @param traceId 双连工作 聊天主键
     * @return 结果
     */
    @Override
    public int deleteFeatureDoubleWorkTraceByTraceId(Long traceId)
    {
        return featureDoubleWorkTraceMapper.deleteFeatureDoubleWorkTraceByTraceId(traceId);
    }


    @Override
    public List<TraceListDto> adminList(FeatureDoubleWorkTrace featureDoubleWorkTrace) {
        return featureDoubleWorkTraceMapper.adminList(featureDoubleWorkTrace);
    }
}
