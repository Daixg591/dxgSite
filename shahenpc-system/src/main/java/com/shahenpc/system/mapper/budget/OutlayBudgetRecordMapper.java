package com.shahenpc.system.mapper.budget;

import com.shahenpc.system.domain.budget.OutlayBudgetRecord;

import java.util.List;
/**
 * 预算记录Mapper接口
 *
 * @author ruoyi
 * @date 2022-08-29
 */
public interface OutlayBudgetRecordMapper {
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
     * 删除预算记录
     *
     * @param recordId 预算记录主键
     * @return 结果
     */
    public int deleteOutlayBudgetRecordByRecordId(Long recordId);

    /**
     * 批量删除预算记录
     *
     * @param recordIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteOutlayBudgetRecordByRecordIds(Long[] recordIds);

    /**
     * 最新一条
     * @return
     */
    public OutlayBudgetRecord selectByLatest();
}
