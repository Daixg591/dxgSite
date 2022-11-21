package com.shahenpc.system.mapper.represent;

import com.shahenpc.system.domain.represent.RepresentActivityRecord;

import java.util.List;

/**
 * 代-活动记录Mapper接口
 * 
 * @author ruoyi
 * @date 2022-07-21
 */
public interface RepresentActivityRecordMapper 
{
    /**
     * 查询代-活动记录
     * 
     * @param recordId 代-活动记录主键
     * @return 代-活动记录
     */
    public RepresentActivityRecord selectRepresentActivityRecordByRecordId(Long recordId);

    /**
     * 查询代-活动记录列表
     * 
     * @param representActivityRecord 代-活动记录`
     * @return 代-活动记录集合
     */
    public List<RepresentActivityRecord> selectRepresentActivityRecordList(RepresentActivityRecord representActivityRecord);

    /**
     * 新增代-活动记录
     * 
     * @param representActivityRecord 代-活动记录
     * @return 结果
     */
    public int insertRepresentActivityRecord(RepresentActivityRecord representActivityRecord);

    /**
     * 修改代-活动记录
     * 
     * @param representActivityRecord 代-活动记录
     * @return 结果
     */
    public int updateRepresentActivityRecord(RepresentActivityRecord representActivityRecord);

    /**
     * 删除代-活动记录
     * 
     * @param recordId 代-活动记录主键
     * @return 结果
     */
    public int deleteRepresentActivityRecordByRecordId(Long recordId);

    /**
     * 批量删除代-活动记录
     * 
     * @param recordIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteRepresentActivityRecordByRecordIds(Long[] recordIds);

    public int delectByActivityId(Long activityId);
}
