package com.shahenpc.system.mapper.feature;

import java.util.List;
import com.shahenpc.system.domain.feature.FeatureDoubleWorkTrace;

/**
 * 双连工作 聊天Mapper接口
 * 
 * @author ruoyi
 * @date 2022-07-13
 */
public interface FeatureDoubleWorkTraceMapper 
{
    /**
     * 查询双连工作 聊天
     * 
     * @param traceId 双连工作 聊天主键
     * @return 双连工作 聊天
     */
    public FeatureDoubleWorkTrace selectFeatureDoubleWorkTraceByTraceId(Long traceId);

    /**
     * 查询双连工作 聊天列表
     * 
     * @param featureDoubleWorkTrace 双连工作 聊天
     * @return 双连工作 聊天集合
     */
    public List<FeatureDoubleWorkTrace> selectFeatureDoubleWorkTraceList(FeatureDoubleWorkTrace featureDoubleWorkTrace);

    /**
     * 新增双连工作 聊天
     * 
     * @param featureDoubleWorkTrace 双连工作 聊天
     * @return 结果
     */
    public int insertFeatureDoubleWorkTrace(FeatureDoubleWorkTrace featureDoubleWorkTrace);

    /**
     * 修改双连工作 聊天
     * 
     * @param featureDoubleWorkTrace 双连工作 聊天
     * @return 结果
     */
    public int updateFeatureDoubleWorkTrace(FeatureDoubleWorkTrace featureDoubleWorkTrace);

    /**
     * 删除双连工作 聊天
     * 
     * @param traceId 双连工作 聊天主键
     * @return 结果
     */
    public int deleteFeatureDoubleWorkTraceByTraceId(Long traceId);

    /**
     * 批量删除双连工作 聊天
     * 
     * @param traceIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteFeatureDoubleWorkTraceByTraceIds(Long[] traceIds);
}
