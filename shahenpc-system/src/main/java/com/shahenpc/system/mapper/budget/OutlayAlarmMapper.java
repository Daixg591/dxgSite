package com.shahenpc.system.mapper.budget;

import java.util.List;
import com.shahenpc.system.domain.budget.OutlayAlarm;
import com.shahenpc.system.domain.budget.dto.AlarmAndBudgetDto;
import com.shahenpc.system.domain.budget.dto.AlarmListDto;
import com.shahenpc.system.domain.budget.dto.BudgetDto;
import com.shahenpc.system.domain.budget.dto.QuarterAlarmDto;
import org.apache.ibatis.annotations.Param;

/**
 * 预警后存储数据Mapper接口
 * 
 * @author ruoyi
 * @date 2022-07-04
 */
public interface OutlayAlarmMapper 
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
     * 删除预警后存储数据
     * 
     * @param alarmId 预警后存储数据主键
     * @return 结果
     */
    public int deleteOutlayAlarmByAlarmId(Long alarmId);

    /**
     * 批量删除预警后存储数据
     * 
     * @param alarmIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteOutlayAlarmByAlarmIds(Long[] alarmIds);


    public List<AlarmAndBudgetDto> selectOutlayAlarmAndOutlayBudget(@Param("year") String year);

    public List<QuarterAlarmDto> selectByQuarter(@Param("budgetType") Integer budgetType,@Param("year") String year);

    public List<AlarmListDto> selectByList(BudgetDto requst);

    public AlarmListDto detail(Long alarmId);
}
