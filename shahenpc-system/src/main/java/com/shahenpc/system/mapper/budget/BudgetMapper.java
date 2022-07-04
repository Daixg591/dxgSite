package com.shahenpc.system.mapper.budget;

import java.util.List;
import com.shahenpc.system.domain.Budget;

/**
 * 预算Mapper接口
 * 
 * @author ruoyi
 * @date 2022-07-01
 */
public interface BudgetMapper 
{
    /**
     * 查询预算
     * 
     * @param budgetId 预算主键
     * @return 预算
     */
    public Budget selectBudgetByBudgetId(Long budgetId);

    /**
     * 查询预算列表
     * 
     * @param budget 预算
     * @return 预算集合
     */
    public List<Budget> selectBudgetList(Budget budget);

    /**
     * 新增预算
     * 
     * @param budget 预算
     * @return 结果
     */
    public int insertBudget(Budget budget);

    /**
     * 修改预算
     * 
     * @param budget 预算
     * @return 结果
     */
    public int updateBudget(Budget budget);

    /**
     * 删除预算
     * 
     * @param budgetId 预算主键
     * @return 结果
     */
    public int deleteBudgetByBudgetId(Long budgetId);

    /**
     * 批量删除预算
     * 
     * @param budgetIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBudgetByBudgetIds(Long[] budgetIds);
}
