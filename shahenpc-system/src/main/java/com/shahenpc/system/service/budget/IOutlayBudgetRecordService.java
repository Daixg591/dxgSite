package com.shahenpc.system.service.budget;

import com.shahenpc.system.domain.budget.OutlayBudgetRecord;

import java.util.List;

/**
 * 预算记录Service接口
 *
 * @author ruoyi
 * @date 2022-08-29
 */
public interface IOutlayBudgetRecordService {
    /**
     * 查询预算记录
     *
     * @param recordId 预算记录主键
     * @return 预算记录
     */
    public OutlayBudgetRecord selectOutlayBudgetRecordByRecordId(Long recordId);

    /**
     * 查询预算记录列表
     *
     * @param outlayBudgetRecord 预算记录
     * @return 预算记录集合
     */
    public List<OutlayBudgetRecord> selectOutlayBudgetRecordList(OutlayBudgetRecord outlayBudgetRecord);

    /**
     * 新增预算记录
     *
     * @param outlayBudgetRecord 预算记录
     * @return 结果
     */
    public int insertOutlayBudgetRecord(OutlayBudgetRecord outlayBudgetRecord);

    /**
     * 修改预算记录
     *
     * @param outlayBudgetRecord 预算记录
     * @return 结果
     */
    public int updateOutlayBudgetRecord(OutlayBudgetRecord outlayBudgetRecord);

    /**
     * 批量删除预算记录
     *
     * @param recordIds 需要删除的预算记录主键集合
     * @return 结果
     */
    public int deleteOutlayBudgetRecordByRecordIds(Long[] recordIds);

    /**
     * 删除预算记录信息
     *
     * @param recordId 预算记录主键
     * @return 结果
     */
    public int deleteOutlayBudgetRecordByRecordId(Long recordId);
}
