package com.shahenpc.system.mapper.budget;

import java.util.List;
import com.shahenpc.system.domain.budget.OutlayActual;
import com.shahenpc.system.domain.budget.dto.ActualListConutDto;
import com.shahenpc.system.domain.budget.dto.BudgetDto;
import com.shahenpc.system.domain.budget.dto.CountDto;
import com.shahenpc.system.domain.budget.dto.OutlayActualListDto;

/**
 * 实际支出Mapper接口
 * 
 * @author ruoyi
 * @date 2022-07-01
 */
public interface OutlayActualMapper 
{
    /**
     * 查询实际支出
     * 
     * @param actualId 实际支出主键
     * @return 实际支出
     */
    public OutlayActual selectOutlayActualByActualId(Long actualId);

    /**
     * 查询实际支出列表
     * 
     * @param outlayActual 实际支出
     * @return 实际支出集合
     */
    public List<OutlayActual> selectOutlayActualList(OutlayActual outlayActual);

    /**
     * 新增实际支出
     * 
     * @param outlayActual 实际支出
     * @return 结果
     */
    public int insertOutlayActual(OutlayActual outlayActual);

    /**
     * 修改实际支出
     * 
     * @param outlayActual 实际支出
     * @return 结果
     */
    public int updateOutlayActual(OutlayActual outlayActual);

    /**
     * 删除实际支出
     * 
     * @param actualId 实际支出主键
     * @return 结果
     */
    public int deleteOutlayActualByActualId(Long actualId);

    /**
     * 批量删除实际支出
     * 
     * @param actualIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteOutlayActualByActualIds(Long[] actualIds);

    public ActualListConutDto getListCount();

    public CountDto selectByCountAndMonth();

    public List<OutlayActualListDto> newList(BudgetDto requst);
}
