package com.shahenpc.system.service.budget.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.alibaba.fastjson2.JSONObject;
import com.shahenpc.common.core.domain.entity.SysDictData;
import com.shahenpc.common.utils.DateUtils;
import com.shahenpc.system.domain.budget.dto.AlarmAndBudgetDto;
import com.shahenpc.system.domain.budget.dto.OutlayCakeDto;
import com.shahenpc.system.domain.budget.dto.QuarterAlarmDto;
import com.shahenpc.system.service.ISysDictDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shahenpc.system.mapper.budget.OutlayAlarmMapper;
import com.shahenpc.system.domain.budget.OutlayAlarm;
import com.shahenpc.system.service.budget.IOutlayAlarmService;

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
    @Autowired
    private ISysDictDataService dictDataService;
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


    @Override
    public List<OutlayCakeDto> cakeList(String year) {
        List<OutlayCakeDto> dtoList = new ArrayList<>();
        List<AlarmAndBudgetDto>  alarBudg=outlayAlarmMapper.selectOutlayAlarmAndOutlayBudget(year);
        SysDictData dictParam = new SysDictData();
        dictParam.setDictType("budget_type");
        List<SysDictData> dictList = dictDataService.selectDictDataList(dictParam);
        for (int i = 0; i < dictList.size(); i++) {
            int finalI = i;
            int v = alarBudg.stream().filter(p -> dictList.get(finalI).getDictValue().equals(p.getBudgetType()))
                    .collect(Collectors.toList()).size();
            OutlayCakeDto item = new OutlayCakeDto();
            item.setName(dictList.get(i).getDictLabel());
            item.setValue(v);
            dtoList.add(item);
        }
        return dtoList;
    }

    @Override
    public Map quarter() {
        //分别查出来
        List<QuarterAlarmDto>  educate=outlayAlarmMapper.selectByQuarter(1);
        List<QuarterAlarmDto>  society=outlayAlarmMapper.selectByQuarter(2);
        List<QuarterAlarmDto>  construction=outlayAlarmMapper.selectByQuarter(3);
        List<QuarterAlarmDto>  technology=outlayAlarmMapper.selectByQuarter(4);
        JSONObject resPersonMap = new JSONObject();
        resPersonMap.put("educate", getLine(educate));
        resPersonMap.put("society", getLine(society));
        resPersonMap.put("construction", getLine(construction));
        resPersonMap.put("technology", getLine(technology));
        return resPersonMap;
    }


    private List<Integer> getLine(List<QuarterAlarmDto> list) {
        List<Integer> resList = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            resList.add(list.get(i).getCountTotal());
        }
        int tempI = resList.size();
        for (int i = 0; i < 4 - tempI; i++) {
            resList.add(0);
        }
        return resList;
    }
}
