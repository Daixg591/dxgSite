package com.shahenpc.system.mapper.outlay;

import java.util.List;
import com.shahenpc.system.domain.outlay.OutlayBudget;

/**
 * 预算Mapper接口
 * 
 * @author ruoyi
 * @date 2022-07-01
 */
public interface OutlayBudgetMapper 
{
    /**
     * 查询预算
     * 
     * @param budgetId 预算主键
     * @return 预算
     */
    public OutlayBudget selectOutlayBudgetByBudgetId(Long budgetId);

    /**
     * 查询预算列表
     * 
     * @param outlayBudget 预算
     * @return 预算集合
     */
    public List<OutlayBudget> selectOutlayBudgetList(OutlayBudget outlayBudget);

    /**
     * 新增预算
     * 
     * @param outlayBudget 预算
     * @return 结果
     */
    public int insertOutlayBudget(OutlayBudget outlayBudget);

    /**
     * 修改预算
     * 
     * @param outlayBudget 预算
     * @return 结果
     */
    public int updateOutlayBudget(OutlayBudget outlayBudget);

    /**
     * 删除预算
     * 
     * @param budgetId 预算主键
     * @return 结果
     */
    public int deleteOutlayBudgetByBudgetId(Long budgetId);

    /**
     * 批量删除预算
     * 
     * @param budgetIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteOutlayBudgetByBudgetIds(Long[] budgetIds);
}
