package com.shahenpc.system.mapper.special;

import java.util.List;
import com.shahenpc.system.domain.special.SpecialOpinionTrace;

/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author ruoyi
 * @date 2022-07-01
 */
public interface SpecialOpinionTraceMapper 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param traceId 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public SpecialOpinionTrace selectSpecialOpinionTraceByTraceId(Long traceId);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param specialOpinionTrace 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<SpecialOpinionTrace> selectSpecialOpinionTraceList(SpecialOpinionTrace specialOpinionTrace);

    /**
     * 新增【请填写功能名称】
     * 
     * @param specialOpinionTrace 【请填写功能名称】
     * @return 结果
     */
    public int insertSpecialOpinionTrace(SpecialOpinionTrace specialOpinionTrace);

    /**
     * 修改【请填写功能名称】
     * 
     * @param specialOpinionTrace 【请填写功能名称】
     * @return 结果
     */
    public int updateSpecialOpinionTrace(SpecialOpinionTrace specialOpinionTrace);

    /**
     * 删除【请填写功能名称】
     * 
     * @param traceId 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteSpecialOpinionTraceByTraceId(Long traceId);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param traceIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSpecialOpinionTraceByTraceIds(Long[] traceIds);
}
