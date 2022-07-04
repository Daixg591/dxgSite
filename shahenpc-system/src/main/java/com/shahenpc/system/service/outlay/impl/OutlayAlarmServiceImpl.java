package com.shahenpc.system.service.outlay.impl;

import java.util.List;
import com.shahenpc.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shahenpc.system.mapper.outlay.OutlayAlarmMapper;
import com.shahenpc.system.domain.outlay.OutlayAlarm;
import com.shahenpc.system.service.outlay.IOutlayAlarmService;

/**
 * 预警后存储数据Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-07-04
 */
@Service
public class OutlayAlarmServiceImpl implements IOutlayAlarmService 
{
    @Autowired
    private OutlayAlarmMapper outlayAlarmMapper;

    /**
     * 查询预警后存储数据
     * 
     * @param alarmId 预警后存储数据主键
     * @return 预警后存储数据
     */
    @Override
    public OutlayAlarm selectOutlayAlarmByAlarmId(Long alarmId)
    {
        return outlayAlarmMapper.selectOutlayAlarmByAlarmId(alarmId);
    }

    /**
     * 查询预警后存储数据列表
     * 
     * @param outlayAlarm 预警后存储数据
     * @return 预警后存储数据
     */
    @Override
    public List<OutlayAlarm> selectOutlayAlarmList(OutlayAlarm outlayAlarm)
    {
        return outlayAlarmMapper.selectOutlayAlarmList(outlayAlarm);
    }

    /**
     * 新增预警后存储数据
     * 
     * @param outlayAlarm 预警后存储数据
     * @return 结果
     */
    @Override
    public int insertOutlayAlarm(OutlayAlarm outlayAlarm)
    {
        outlayAlarm.setCreateTime(DateUtils.getNowDate());
        return outlayAlarmMapper.insertOutlayAlarm(outlayAlarm);
    }

    /**
     * 修改预警后存储数据
     * 
     * @param outlayAlarm 预警后存储数据
     * @return 结果
     */
    @Override
    public int updateOutlayAlarm(OutlayAlarm outlayAlarm)
    {
        outlayAlarm.setUpdateTime(DateUtils.getNowDate());
        return outlayAlarmMapper.updateOutlayAlarm(outlayAlarm);
    }

    /**
     * 批量删除预警后存储数据
     * 
     * @param alarmIds 需要删除的预警后存储数据主键
     * @return 结果
     */
    @Override
    public int deleteOutlayAlarmByAlarmIds(Long[] alarmIds)
    {
        return outlayAlarmMapper.deleteOutlayAlarmByAlarmIds(alarmIds);
    }

    /**
     * 删除预警后存储数据信息
     * 
     * @param alarmId 预警后存储数据主键
     * @return 结果
     */
    @Override
    public int deleteOutlayAlarmByAlarmId(Long alarmId)
    {
        return outlayAlarmMapper.deleteOutlayAlarmByAlarmId(alarmId);
    }
}
