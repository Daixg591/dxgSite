package com.shahenpc.system.service.outlay;

import java.util.List;
import com.shahenpc.system.domain.outlay.OutlayBudget;
import com.shahenpc.system.domain.outlay.dto.CountDto;

/**
 * 预算Service接口
 * 
 * @author ruoyi
 * @date 2022-07-01
 */
public interface IOutlayBudgetService 
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
     * 批量删除预算
     * 
     * @param budgetIds 需要删除的预算主键集合
     * @return 结果
     */
    public int deleteOutlayBudgetByBudgetIds(Long[] budgetIds);

    /**
     * 删除预算信息
     * 
     * @param budgetId 预算主键
     * @return 结果
     */
    public int deleteOutlayBudgetByBudgetId(Long budgetId);

    public CountDto getCount();
}
