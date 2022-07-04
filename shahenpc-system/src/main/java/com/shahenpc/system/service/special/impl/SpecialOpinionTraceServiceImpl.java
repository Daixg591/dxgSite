package com.shahenpc.system.service.special.impl;

import java.util.List;
import com.shahenpc.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shahenpc.system.mapper.special.SpecialOpinionTraceMapper;
import com.shahenpc.system.domain.special.SpecialOpinionTrace;
import com.shahenpc.system.service.special.ISpecialOpinionTraceService;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-07-01
 */
@Service
public class SpecialOpinionTraceServiceImpl implements ISpecialOpinionTraceService 
{
    @Autowired
    private SpecialOpinionTraceMapper specialOpinionTraceMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param traceId 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public SpecialOpinionTrace selectSpecialOpinionTraceByTraceId(Long traceId)
    {
        return specialOpinionTraceMapper.selectSpecialOpinionTraceByTraceId(traceId);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param specialOpinionTrace 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<SpecialOpinionTrace> selectSpecialOpinionTraceList(SpecialOpinionTrace specialOpinionTrace)
    {
        return specialOpinionTraceMapper.selectSpecialOpinionTraceList(specialOpinionTrace);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param specialOpinionTrace 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertSpecialOpinionTrace(SpecialOpinionTrace specialOpinionTrace)
    {
        specialOpinionTrace.setCreateTime(DateUtils.getNowDate());
        return specialOpinionTraceMapper.insertSpecialOpinionTrace(specialOpinionTrace);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param specialOpinionTrace 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateSpecialOpinionTrace(SpecialOpinionTrace specialOpinionTrace)
    {
        specialOpinionTrace.setUpdateTime(DateUtils.getNowDate());
        return specialOpinionTraceMapper.updateSpecialOpinionTrace(specialOpinionTrace);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param traceIds 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteSpecialOpinionTraceByTraceIds(Long[] traceIds)
    {
        return specialOpinionTraceMapper.deleteSpecialOpinionTraceByTraceIds(traceIds);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param traceId 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteSpecialOpinionTraceByTraceId(Long traceId)
    {
        return specialOpinionTraceMapper.deleteSpecialOpinionTraceByTraceId(traceId);
    }
}
