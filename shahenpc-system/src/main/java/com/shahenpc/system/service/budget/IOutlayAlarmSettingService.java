package com.shahenpc.system.service.budget;

import java.util.List;
import com.shahenpc.system.domain.budget.OutlayAlarmSetting;

/**
 * 告警设置-规则Service接口
 * 
 * @author ruoyi
 * @date 2022-07-04
 */
public interface IOutlayAlarmSettingService 
{
    /**
     * 查询告警设置-规则
     * 
     * @param settingId 告警设置-规则主键
     * @return 告警设置-规则
     */
    public OutlayAlarmSetting selectOutlayAlarmSettingBySettingId(Long settingId);

    /**
     * 查询告警设置-规则列表
     * 
     * @param outlayAlarmSetting 告警设置-规则
     * @return 告警设置-规则集合
     */
    public List<OutlayAlarmSetting> selectOutlayAlarmSettingList(OutlayAlarmSetting outlayAlarmSetting);

    /**
     * 新增告警设置-规则
     * 
     * @param outlayAlarmSetting 告警设置-规则
     * @return 结果
     */
    public int insertOutlayAlarmSetting(OutlayAlarmSetting outlayAlarmSetting);

    /**
     * 修改告警设置-规则
     * 
     * @param outlayAlarmSetting 告警设置-规则
     * @return 结果
     */
    public int updateOutlayAlarmSetting(OutlayAlarmSetting outlayAlarmSetting);

    /**
     * 批量删除告警设置-规则
     * 
     * @param settingIds 需要删除的告警设置-规则主键集合
     * @return 结果
     */
    public int deleteOutlayAlarmSettingBySettingIds(Long[] settingIds);

    /**
     * 删除告警设置-规则信息
     * 
     * @param settingId 告警设置-规则主键
     * @return 结果
     */
    public int deleteOutlayAlarmSettingBySettingId(Long settingId);
}
