package com.shahenpc.system.service.outlay.impl;

import java.util.List;
import com.shahenpc.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shahenpc.system.mapper.outlay.OutlayAlarmSettingMapper;
import com.shahenpc.system.domain.outlay.OutlayAlarmSetting;
import com.shahenpc.system.service.outlay.IOutlayAlarmSettingService;

/**
 * 告警设置-规则Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-07-04
 */
@Service
public class OutlayAlarmSettingServiceImpl implements IOutlayAlarmSettingService 
{
    @Autowired
    private OutlayAlarmSettingMapper outlayAlarmSettingMapper;

    /**
     * 查询告警设置-规则
     * 
     * @param settingId 告警设置-规则主键
     * @return 告警设置-规则
     */
    @Override
    public OutlayAlarmSetting selectOutlayAlarmSettingBySettingId(Long settingId)
    {
        return outlayAlarmSettingMapper.selectOutlayAlarmSettingBySettingId(settingId);
    }

    /**
     * 查询告警设置-规则列表
     * 
     * @param outlayAlarmSetting 告警设置-规则
     * @return 告警设置-规则
     */
    @Override
    public List<OutlayAlarmSetting> selectOutlayAlarmSettingList(OutlayAlarmSetting outlayAlarmSetting)
    {
        return outlayAlarmSettingMapper.selectOutlayAlarmSettingList(outlayAlarmSetting);
    }

    /**
     * 新增告警设置-规则
     * 
     * @param outlayAlarmSetting 告警设置-规则
     * @return 结果
     */
    @Override
    public int insertOutlayAlarmSetting(OutlayAlarmSetting outlayAlarmSetting)
    {
        outlayAlarmSetting.setCreateTime(DateUtils.getNowDate());
        return outlayAlarmSettingMapper.insertOutlayAlarmSetting(outlayAlarmSetting);
    }

    /**
     * 修改告警设置-规则
     * 
     * @param outlayAlarmSetting 告警设置-规则
     * @return 结果
     */
    @Override
    public int updateOutlayAlarmSetting(OutlayAlarmSetting outlayAlarmSetting)
    {
        outlayAlarmSetting.setUpdateTime(DateUtils.getNowDate());
        return outlayAlarmSettingMapper.updateOutlayAlarmSetting(outlayAlarmSetting);
    }

    /**
     * 批量删除告警设置-规则
     * 
     * @param settingIds 需要删除的告警设置-规则主键
     * @return 结果
     */
    @Override
    public int deleteOutlayAlarmSettingBySettingIds(Long[] settingIds)
    {
        return outlayAlarmSettingMapper.deleteOutlayAlarmSettingBySettingIds(settingIds);
    }

    /**
     * 删除告警设置-规则信息
     * 
     * @param settingId 告警设置-规则主键
     * @return 结果
     */
    @Override
    public int deleteOutlayAlarmSettingBySettingId(Long settingId)
    {
        return outlayAlarmSettingMapper.deleteOutlayAlarmSettingBySettingId(settingId);
    }
}
