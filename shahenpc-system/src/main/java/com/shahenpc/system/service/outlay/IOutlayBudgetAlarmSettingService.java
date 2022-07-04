package com.shahenpc.system.service.outlay;

import java.util.List;
import com.shahenpc.system.domain.outlay.OutlayBudgetAlarmSetting;

/**
 * 告警设置-规则Service接口
 * 
 * @author ruoyi
 * @date 2022-07-01
 */
public interface IOutlayBudgetAlarmSettingService 
{
    /**
     * 查询告警设置-规则
     * 
     * @param alarmId 告警设置-规则主键
     * @return 告警设置-规则
     */
    public OutlayBudgetAlarmSetting selectOutlayBudgetAlarmSettingByAlarmId(Long alarmId);

    /**
     * 查询告警设置-规则列表
     * 
     * @param outlayBudgetAlarmSetting 告警设置-规则
     * @return 告警设置-规则集合
     */
    public List<OutlayBudgetAlarmSetting> selectOutlayBudgetAlarmSettingList(OutlayBudgetAlarmSetting outlayBudgetAlarmSetting);

    /**
     * 新增告警设置-规则
     * 
     * @param outlayBudgetAlarmSetting 告警设置-规则
     * @return 结果
     */
    public int insertOutlayBudgetAlarmSetting(OutlayBudgetAlarmSetting outlayBudgetAlarmSetting);

    /**
     * 修改告警设置-规则
     * 
     * @param outlayBudgetAlarmSetting 告警设置-规则
     * @return 结果
     */
    public int updateOutlayBudgetAlarmSetting(OutlayBudgetAlarmSetting outlayBudgetAlarmSetting);

    /**
     * 批量删除告警设置-规则
     * 
     * @param alarmIds 需要删除的告警设置-规则主键集合
     * @return 结果
     */
    public int deleteOutlayBudgetAlarmSettingByAlarmIds(Long[] alarmIds);

    /**
     * 删除告警设置-规则信息
     * 
     * @param alarmId 告警设置-规则主键
     * @return 结果
     */
    public int deleteOutlayBudgetAlarmSettingByAlarmId(Long alarmId);
}
