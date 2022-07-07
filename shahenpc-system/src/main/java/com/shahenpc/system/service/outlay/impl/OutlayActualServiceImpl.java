package com.shahenpc.system.service.outlay.impl;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.List;
import com.shahenpc.common.utils.DateUtils;
import com.shahenpc.system.domain.outlay.OutlayAlarm;
import com.shahenpc.system.domain.outlay.OutlayAlarmSetting;
import com.shahenpc.system.domain.outlay.OutlayBudget;
import com.shahenpc.system.domain.outlay.dto.ActualListConutDto;
import com.shahenpc.system.domain.outlay.dto.CountDto;
import com.shahenpc.system.mapper.outlay.OutlayAlarmMapper;
import com.shahenpc.system.mapper.outlay.OutlayAlarmSettingMapper;
import com.shahenpc.system.mapper.outlay.OutlayBudgetMapper;
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
    @Autowired
    private OutlayAlarmSettingMapper outlayAlarmSettingMapper;
    @Autowired
    private OutlayBudgetMapper outlayBudgetMapper;
    @Autowired
    private OutlayAlarmMapper outlayAlarmMapper;
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
        OutlayBudget budget=outlayBudgetMapper.selectOutlayBudgetByBudgetId(outlayActual.getBudgetId());
        OutlayAlarmSetting setting= outlayAlarmSettingMapper.selectByBudgetType(budget.getBudgetType());
        BigDecimal divide = budget.getAmount().divide(outlayActual.getAmount(), 2, BigDecimal.ROUND_HALF_UP);
        if(divide.compareTo(setting.getRatio()) == -1){
            //预支  和 实际 支出比例 小于 规则比例  就增加到
            OutlayAlarm alarm = new OutlayAlarm();
            alarm.setAlarmId(outlayActual.getActualId());
            alarm.setBudgetId(budget.getBudgetId());
            alarm.setSettingId(setting.getSettingId());
            alarm.setCause("实际支出 超出 预计支出 比例");
            alarm.setBeyondRatio(divide.subtract(setting.getRatio()).toString());
            outlayAlarmMapper.insertOutlayAlarm(alarm);
        }
        //查出 规则
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


    @Override
    public ActualListConutDto listCount() {
        return outlayActualMapper.getListCount();
    }

    @Override
    public CountDto getCount() {
        return outlayActualMapper.selectByCountAndMonth();
    }
}
