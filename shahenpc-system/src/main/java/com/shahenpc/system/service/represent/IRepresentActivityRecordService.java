package com.shahenpc.system.service.represent;

import java.util.List;

import com.shahenpc.common.core.domain.AjaxResult;
import com.shahenpc.system.domain.represent.RepresentActivityRecord;

/**
 * 代-活动记录Service接口
 * 
 * @author ruoyi
 * @date 2022-07-21
 */
public interface IRepresentActivityRecordService 
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
     * @param representActivityRecord 代-活动记录
     * @return 代-活动记录集合
     */
    public List<RepresentActivityRecord> selectRepresentActivityRecordList(RepresentActivityRecord representActivityRecord);

    public RepresentActivityRecord selectRepresentActivityRecord(RepresentActivityRecord representActivityRecord);
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

    public AjaxResult updateMyStatus(RepresentActivityRecord representActivityRecord);
    /**
     * 批量删除代-活动记录
     * 
     * @param recordIds 需要删除的代-活动记录主键集合
     * @return 结果
     */
    public int deleteRepresentActivityRecordByRecordIds(Long[] recordIds);

    /**
     * 删除代-活动记录信息
     * 
     * @param recordId 代-活动记录主键
     * @return 结果
     */
    public int deleteRepresentActivityRecordByRecordId(Long recordId);
}
