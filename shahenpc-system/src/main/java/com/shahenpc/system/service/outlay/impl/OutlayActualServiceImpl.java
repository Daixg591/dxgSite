package com.shahenpc.system.service.outlay.impl;

import java.util.List;
import com.shahenpc.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shahenpc.system.mapper.outlay.OutlayActualMapper;
import com.shahenpc.system.domain.outlay.OutlayActual;
import com.shahenpc.system.service.outlay.IOutlayActualService;

/**
 * 实际支出Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-07-01
 */
@Service
public class OutlayActualServiceImpl implements IOutlayActualService 
{
    @Autowired
    private OutlayActualMapper outlayActualMapper;

    /**
     * 查询实际支出
     * 
     * @param actualId 实际支出主键
     * @return 实际支出
     */
    @Override
    public OutlayActual selectOutlayActualByActualId(Long actualId)
    {
        return outlayActualMapper.selectOutlayActualByActualId(actualId);
    }

    /**
     * 查询实际支出列表
     * 
     * @param outlayActual 实际支出
     * @return 实际支出
     */
    @Override
    public List<OutlayActual> selectOutlayActualList(OutlayActual outlayActual)
    {
        return outlayActualMapper.selectOutlayActualList(outlayActual);
    }

    /**
     * 新增实际支出
     * 
     * @param outlayActual 实际支出
     * @return 结果
     */
    @Override
    public int insertOutlayActual(OutlayActual outlayActual)
    {
        outlayActual.setCreateTime(DateUtils.getNowDate());
        return outlayActualMapper.insertOutlayActual(outlayActual);
    }

    /**
     * 修改实际支出
     * 
     * @param outlayActual 实际支出
     * @return 结果
     */
    @Override
    public int updateOutlayActual(OutlayActual outlayActual)
    {
        outlayActual.setUpdateTime(DateUtils.getNowDate());
        return outlayActualMapper.updateOutlayActual(outlayActual);
    }

    /**
     * 批量删除实际支出
     * 
     * @param actualIds 需要删除的实际支出主键
     * @return 结果
     */
    @Override
    public int deleteOutlayActualByActualIds(Long[] actualIds)
    {
        return outlayActualMapper.deleteOutlayActualByActualIds(actualIds);
    }

    /**
     * 删除实际支出信息
     * 
     * @param actualId 实际支出主键
     * @return 结果
     */
    @Override
    public int deleteOutlayActualByActualId(Long actualId)
    {
        return outlayActualMapper.deleteOutlayActualByActualId(actualId);
    }
}
