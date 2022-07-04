package com.shahenpc.system.service.outlay;

import java.util.List;
import com.shahenpc.system.domain.outlay.OutlayAlarm;

/**
 * 预警后存储数据Service接口
 * 
 * @author ruoyi
 * @date 2022-07-04
 */
public interface IOutlayAlarmService 
{
    /**
     * 查询预警后存储数据
     * 
     * @param alarmId 预警后存储数据主键
     * @return 预警后存储数据
     */
    public OutlayAlarm selectOutlayAlarmByAlarmId(Long alarmId);

    /**
     * 查询预警后存储数据列表
     * 
     * @param outlayAlarm 预警后存储数据
     * @return 预警后存储数据集合
     */
    public List<OutlayAlarm> selectOutlayAlarmList(OutlayAlarm outlayAlarm);

    /**
     * 新增预警后存储数据
     * 
     * @param outlayAlarm 预警后存储数据
     * @return 结果
     */
    public int insertOutlayAlarm(OutlayAlarm outlayAlarm);

    /**
     * 修改预警后存储数据
     * 
     * @param outlayAlarm 预警后存储数据
     * @return 结果
     */
    public int updateOutlayAlarm(OutlayAlarm outlayAlarm);

    /**
     * 批量删除预警后存储数据
     * 
     * @param alarmIds 需要删除的预警后存储数据主键集合
     * @return 结果
     */
    public int deleteOutlayAlarmByAlarmIds(Long[] alarmIds);

    /**
     * 删除预警后存储数据信息
     * 
     * @param alarmId 预警后存储数据主键
     * @return 结果
     */
    public int deleteOutlayAlarmByAlarmId(Long alarmId);
}
