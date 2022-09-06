package com.shahenpc.system.service.budget.impl;

import com.shahenpc.common.utils.DateUtils;
import com.shahenpc.system.domain.budget.OutlayBudgetRecord;
import com.shahenpc.system.mapper.budget.OutlayBudgetRecordMapper;
import com.shahenpc.system.service.budget.IOutlayBudgetRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 预算记录Service业务层处理
 *
 * @author ruoyi
 * @date 2022-08-29
 */
@Service
public class OutlayBudgetRecordServiceImpl implements IOutlayBudgetRecordService{

    @Autowired
    private OutlayBudgetRecordMapper outlayBudgetRecordMapper;

    /**
     * 查询预算记录
     *
     * @param recordId 预算记录主键
     * @return 预算记录
     */
    @Override
    public OutlayBudgetRecord selectOutlayBudgetRecordByRecordId(Long recordId)
    {
        return outlayBudgetRecordMapper.selectOutlayBudgetRecordByRecordId(recordId);
    }

    /**
     * 查询预算记录列表
     *
     * @param outlayBudgetRecord 预算记录
     * @return 预算记录
     */
    @Override
    public List<OutlayBudgetRecord> selectOutlayBudgetRecordList(OutlayBudgetRecord outlayBudgetRecord)
    {
        return outlayBudgetRecordMapper.selectOutlayBudgetRecordList(outlayBudgetRecord);
    }

    /**
     * 新增预算记录
     *
     * @param outlayBudgetRecord 预算记录
     * @return 结果
     */
    @Override
    public int insertOutlayBudgetRecord(OutlayBudgetRecord outlayBudgetRecord)
    {
        outlayBudgetRecord.setCreateTime(DateUtils.getNowDate());
        return outlayBudgetRecordMapper.insertOutlayBudgetRecord(outlayBudgetRecord);
    }

    /**
     * 修改预算记录
     *
     * @param outlayBudgetRecord 预算记录
     * @return 结果
     */
    @Override
    public int updateOutlayBudgetRecord(OutlayBudgetRecord outlayBudgetRecord)
    {
        outlayBudgetRecord.setUpdateTime(DateUtils.getNowDate());
        return outlayBudgetRecordMapper.updateOutlayBudgetRecord(outlayBudgetRecord);
    }

    /**
     * 批量删除预算记录
     *
     * @param recordIds 需要删除的预算记录主键
     * @return 结果
     */
    @Override
    public int deleteOutlayBudgetRecordByRecordIds(Long[] recordIds)
    {
        return outlayBudgetRecordMapper.deleteOutlayBudgetRecordByRecordIds(recordIds);
    }

    /**
     * 删除预算记录信息
     *
     * @param recordId 预算记录主键
     * @return 结果
     */
    @Override
    public int deleteOutlayBudgetRecordByRecordId(Long recordId)
    {
        return outlayBudgetRecordMapper.deleteOutlayBudgetRecordByRecordId(recordId);
    }

}
