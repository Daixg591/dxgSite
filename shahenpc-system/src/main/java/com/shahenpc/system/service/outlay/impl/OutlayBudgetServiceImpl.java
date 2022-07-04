package com.shahenpc.system.service.outlay.impl;

import java.util.List;
import com.shahenpc.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shahenpc.system.mapper.outlay.OutlayBudgetMapper;
import com.shahenpc.system.domain.outlay.OutlayBudget;
import com.shahenpc.system.service.outlay.IOutlayBudgetService;

/**
 * 预算Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-07-01
 */
@Service
public class OutlayBudgetServiceImpl implements IOutlayBudgetService 
{
    @Autowired
    private OutlayBudgetMapper outlayBudgetMapper;

    /**
     * 查询预算
     * 
     * @param budgetId 预算主键
     * @return 预算
     */
    @Override
    public OutlayBudget selectOutlayBudgetByBudgetId(Long budgetId)
    {
        return outlayBudgetMapper.selectOutlayBudgetByBudgetId(budgetId);
    }

    /**
     * 查询预算列表
     * 
     * @param outlayBudget 预算
     * @return 预算
     */
    @Override
    public List<OutlayBudget> selectOutlayBudgetList(OutlayBudget outlayBudget)
    {
        return outlayBudgetMapper.selectOutlayBudgetList(outlayBudget);
    }

    /**
     * 新增预算
     * 
     * @param outlayBudget 预算
     * @return 结果
     */
    @Override
    public int insertOutlayBudget(OutlayBudget outlayBudget)
    {
        outlayBudget.setCreateTime(DateUtils.getNowDate());
        return outlayBudgetMapper.insertOutlayBudget(outlayBudget);
    }

    /**
     * 修改预算
     * 
     * @param outlayBudget 预算
     * @return 结果
     */
    @Override
    public int updateOutlayBudget(OutlayBudget outlayBudget)
    {
        outlayBudget.setUpdateTime(DateUtils.getNowDate());
        return outlayBudgetMapper.updateOutlayBudget(outlayBudget);
    }

    /**
     * 批量删除预算
     * 
     * @param budgetIds 需要删除的预算主键
     * @return 结果
     */
    @Override
    public int deleteOutlayBudgetByBudgetIds(Long[] budgetIds)
    {
        return outlayBudgetMapper.deleteOutlayBudgetByBudgetIds(budgetIds);
    }

    /**
     * 删除预算信息
     * 
     * @param budgetId 预算主键
     * @return 结果
     */
    @Override
    public int deleteOutlayBudgetByBudgetId(Long budgetId)
    {
        return outlayBudgetMapper.deleteOutlayBudgetByBudgetId(budgetId);
    }
}
