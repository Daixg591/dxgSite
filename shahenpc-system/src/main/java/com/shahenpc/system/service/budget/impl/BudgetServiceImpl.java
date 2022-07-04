package com.shahenpc.system.service.budget.impl;

import java.util.List;
import com.shahenpc.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shahenpc.system.mapper.budget.BudgetMapper;
import com.shahenpc.system.domain.Budget;
import com.shahenpc.system.service.budget.IBudgetService;

/**
 * 预算Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-07-01
 */
@Service
public class BudgetServiceImpl implements IBudgetService 
{
    @Autowired
    private BudgetMapper budgetMapper;

    /**
     * 查询预算
     * 
     * @param budgetId 预算主键
     * @return 预算
     */
    @Override
    public Budget selectBudgetByBudgetId(Long budgetId)
    {
        return budgetMapper.selectBudgetByBudgetId(budgetId);
    }

    /**
     * 查询预算列表
     * 
     * @param budget 预算
     * @return 预算
     */
    @Override
    public List<Budget> selectBudgetList(Budget budget)
    {
        return budgetMapper.selectBudgetList(budget);
    }

    /**
     * 新增预算
     * 
     * @param budget 预算
     * @return 结果
     */
    @Override
    public int insertBudget(Budget budget)
    {
        budget.setCreateTime(DateUtils.getNowDate());
        return budgetMapper.insertBudget(budget);
    }

    /**
     * 修改预算
     * 
     * @param budget 预算
     * @return 结果
     */
    @Override
    public int updateBudget(Budget budget)
    {
        budget.setUpdateTime(DateUtils.getNowDate());
        return budgetMapper.updateBudget(budget);
    }

    /**
     * 批量删除预算
     * 
     * @param budgetIds 需要删除的预算主键
     * @return 结果
     */
    @Override
    public int deleteBudgetByBudgetIds(Long[] budgetIds)
    {
        return budgetMapper.deleteBudgetByBudgetIds(budgetIds);
    }

    /**
     * 删除预算信息
     * 
     * @param budgetId 预算主键
     * @return 结果
     */
    @Override
    public int deleteBudgetByBudgetId(Long budgetId)
    {
        return budgetMapper.deleteBudgetByBudgetId(budgetId);
    }
}
