package com.shahenpc.system.service.outlay;

import java.util.List;
import com.shahenpc.system.domain.outlay.OutlayActual;
import com.shahenpc.system.domain.outlay.dto.ActualListConutDto;
import com.shahenpc.system.domain.outlay.dto.CountDto;

/**
 * 实际支出Service接口
 * 
 * @author ruoyi
 * @date 2022-07-01
 */
public interface IOutlayActualService 
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
     * 批量删除实际支出
     * 
     * @param actualIds 需要删除的实际支出主键集合
     * @return 结果
     */
    public int deleteOutlayActualByActualIds(Long[] actualIds);

    /**
     * 删除实际支出信息
     * 
     * @param actualId 实际支出主键
     * @return 结果
     */
    public int deleteOutlayActualByActualId(Long actualId);

    public ActualListConutDto listCount();

    public CountDto getCount();
}
