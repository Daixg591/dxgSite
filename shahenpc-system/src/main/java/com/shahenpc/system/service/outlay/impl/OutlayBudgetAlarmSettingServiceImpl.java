package com.shahenpc.system.service.outlay.impl;

import java.util.List;
import com.shahenpc.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shahenpc.system.mapper.outlay.OutlayBudgetAlarmSettingMapper;
import com.shahenpc.system.domain.outlay.OutlayBudgetAlarmSetting;
import com.shahenpc.system.service.outlay.IOutlayBudgetAlarmSettingService;

/**
 * 告警设置-规则Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-07-01
 */
@Service
public class OutlayBudgetAlarmSettingServiceImpl implements IOutlayBudgetAlarmSettingService 
{
    @Autowired
    private OutlayBudgetAlarmSettingMapper outlayBudgetAlarmSettingMapper;

    /**
     * 查询告警设置-规则
     * 
     * @param alarmId 告警设置-规则主键
     * @return 告警设置-规则
     */
    @Override
    public OutlayBudgetAlarmSetting selectOutlayBudgetAlarmSettingByAlarmId(Long alarmId)
    {
        return outlayBudgetAlarmSettingMapper.selectOutlayBudgetAlarmSettingByAlarmId(alarmId);
    }

    /**
     * 查询告警设置-规则列表
     * 
     * @param outlayBudgetAlarmSetting 告警设置-规则
     * @return 告警设置-规则
     */
    @Override
    public List<OutlayBudgetAlarmSetting> selectOutlayBudgetAlarmSettingList(OutlayBudgetAlarmSetting outlayBudgetAlarmSetting)
    {
        return outlayBudgetAlarmSettingMapper.selectOutlayBudgetAlarmSettingList(outlayBudgetAlarmSetting);
    }

    /**
     * 新增告警设置-规则
     * 
     * @param outlayBudgetAlarmSetting 告警设置-规则
     * @return 结果
     */
    @Override
    public int insertOutlayBudgetAlarmSetting(OutlayBudgetAlarmSetting outlayBudgetAlarmSetting)
    {
        outlayBudgetAlarmSetting.setCreateTime(DateUtils.getNowDate());
        return outlayBudgetAlarmSettingMapper.insertOutlayBudgetAlarmSetting(outlayBudgetAlarmSetting);
    }

    /**
     * 修改告警设置-规则
     * 
     * @param outlayBudgetAlarmSetting 告警设置-规则
     * @return 结果
     */
    @Override
    public int updateOutlayBudgetAlarmSetting(OutlayBudgetAlarmSetting outlayBudgetAlarmSetting)
    {
        outlayBudgetAlarmSetting.setUpdateTime(DateUtils.getNowDate());
        return outlayBudgetAlarmSettingMapper.updateOutlayBudgetAlarmSetting(outlayBudgetAlarmSetting);
    }

    /**
     * 批量删除告警设置-规则
     * 
     * @param alarmIds 需要删除的告警设置-规则主键
     * @return 结果
     */
    @Override
    public int deleteOutlayBudgetAlarmSettingByAlarmIds(Long[] alarmIds)
    {
        return outlayBudgetAlarmSettingMapper.deleteOutlayBudgetAlarmSettingByAlarmIds(alarmIds);
    }

    /**
     * 删除告警设置-规则信息
     * 
     * @param alarmId 告警设置-规则主键
     * @return 结果
     */
    @Override
    public int deleteOutlayBudgetAlarmSettingByAlarmId(Long alarmId)
    {
        return outlayBudgetAlarmSettingMapper.deleteOutlayBudgetAlarmSettingByAlarmId(alarmId);
    }
}
