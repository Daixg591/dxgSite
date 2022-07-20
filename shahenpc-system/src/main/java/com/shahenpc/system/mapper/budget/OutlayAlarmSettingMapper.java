package com.shahenpc.system.mapper.budget;

import java.util.List;
import com.shahenpc.system.domain.budget.OutlayAlarmSetting;
import com.shahenpc.system.domain.budget.dto.OutlayAlarmSettingDictDto;

/**
 * 告警设置-规则Mapper接口
 * 
 * @author ruoyi
 * @date 2022-07-04
 */
public interface OutlayAlarmSettingMapper 
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
     * 删除告警设置-规则
     * 
     * @param settingId 告警设置-规则主键
     * @return 结果
     */
    public int deleteOutlayAlarmSettingBySettingId(Long settingId);

    /**
     * 批量删除告警设置-规则
     * 
     * @param settingIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteOutlayAlarmSettingBySettingIds(Long[] settingIds);

    public OutlayAlarmSetting selectByBudgetType(Integer budgetType);

    public List<OutlayAlarmSettingDictDto> newList();
}
