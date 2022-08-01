package com.shahenpc.system.service.feature.impl;

import java.util.*;
import java.util.stream.Collectors;

import com.shahenpc.common.utils.DateUtils;
import com.shahenpc.system.domain.feature.dto.FeatureLineDto;
import com.shahenpc.system.domain.feature.dto.FeatureMonthDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shahenpc.system.mapper.feature.FeatureWorkEventMapper;
import com.shahenpc.system.domain.feature.FeatureWorkEvent;
import com.shahenpc.system.service.feature.IFeatureWorkEventService;

/**
 * 特色工作-民生实事-环境保护-信访稳定-营商环境-乡村振兴Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-07-15
 */
@Service
public class FeatureWorkEventServiceImpl implements IFeatureWorkEventService 
{
    @Autowired
    private FeatureWorkEventMapper featureWorkEventMapper;

    /**
     * 查询特色工作-民生实事-环境保护-信访稳定-营商环境-乡村振兴
     * 
     * @param eventId 特色工作-民生实事-环境保护-信访稳定-营商环境-乡村振兴主键
     * @return 特色工作-民生实事-环境保护-信访稳定-营商环境-乡村振兴
     */
    @Override
    public FeatureWorkEvent selectFeatureWorkEventByEventId(Long eventId)
    {
        return featureWorkEventMapper.selectFeatureWorkEventByEventId(eventId);
    }

    /**
     * 查询特色工作-民生实事-环境保护-信访稳定-营商环境-乡村振兴列表
     * 
     * @param featureWorkEvent 特色工作-民生实事-环境保护-信访稳定-营商环境-乡村振兴
     * @return 特色工作-民生实事-环境保护-信访稳定-营商环境-乡村振兴
     */
    @Override
    public List<FeatureWorkEvent> selectFeatureWorkEventList(FeatureWorkEvent featureWorkEvent)
    {
        return featureWorkEventMapper.selectFeatureWorkEventList(featureWorkEvent);
    }

    /**
     * 新增特色工作-民生实事-环境保护-信访稳定-营商环境-乡村振兴
     * 
     * @param featureWorkEvent 特色工作-民生实事-环境保护-信访稳定-营商环境-乡村振兴
     * @return 结果
     */
    @Override
    public int insertFeatureWorkEvent(FeatureWorkEvent featureWorkEvent)
    {
        featureWorkEvent.setCreateTime(DateUtils.getNowDate());
        return featureWorkEventMapper.insertFeatureWorkEvent(featureWorkEvent);
    }

    /**
     * 修改特色工作-民生实事-环境保护-信访稳定-营商环境-乡村振兴
     * 
     * @param featureWorkEvent 特色工作-民生实事-环境保护-信访稳定-营商环境-乡村振兴
     * @return 结果
     */
    @Override
    public int updateFeatureWorkEvent(FeatureWorkEvent featureWorkEvent)
    {
        featureWorkEvent.setUpdateTime(DateUtils.getNowDate());
        return featureWorkEventMapper.updateFeatureWorkEvent(featureWorkEvent);
    }

    /**
     * 批量删除特色工作-民生实事-环境保护-信访稳定-营商环境-乡村振兴
     * 
     * @param eventIds 需要删除的特色工作-民生实事-环境保护-信访稳定-营商环境-乡村振兴主键
     * @return 结果
     */
    @Override
    public int deleteFeatureWorkEventByEventIds(Long[] eventIds)
    {
        return featureWorkEventMapper.deleteFeatureWorkEventByEventIds(eventIds);
    }

    /**
     * 删除特色工作-民生实事-环境保护-信访稳定-营商环境-乡村振兴信息
     * 
     * @param eventId 特色工作-民生实事-环境保护-信访稳定-营商环境-乡村振兴主键
     * @return 结果
     */
    @Override
    public int deleteFeatureWorkEventByEventId(Long eventId)
    {
        return featureWorkEventMapper.deleteFeatureWorkEventByEventId(eventId);
    }

    @Override
    public FeatureMonthDto getCount(Integer workType) {
        return featureWorkEventMapper.getCount(workType);
    }

    @Override
    public FeatureLineDto monthCount(Integer workType) {
        List<String> monthList = getNearSixMonth();
        FeatureLineDto res = new FeatureLineDto();
        res.setLabel(monthList);

        List<Integer> yList = new ArrayList<>();

        //获取最小日期
        Date minMonth = DateUtils.parseDate(monthList.get(monthList.size() - 1));
        FeatureWorkEvent dto = new FeatureWorkEvent();
        //dto.setCreateTime(minMonth);
        dto.setWorkType(workType);
        List<FeatureWorkEvent> nearlist = featureWorkEventMapper.selectFeatureWorkEventList(dto);
        for (int i = 0; i < monthList.size(); i++) {
            int finalI = i;
            dto.setCreateTime(DateUtils.parseDate(monthList.get(finalI)));
            String cntt = monthList.get(finalI);
            List<FeatureWorkEvent> nearlist1 = nearlist.stream().
                    filter(w -> DateUtils.dateTime(w.getCreateTime()).contains(cntt)).collect(Collectors.toList());
            yList.add(nearlist1.size());
        }
        res.setData(yList);
        Collections.reverse(res.getData());
        Collections.reverse(res.getLabel());
        return res;
    }

    @Override
    public String ringScale(Integer workType) {
        String sTime="";
        String eTime="";
        Calendar c = Calendar.getInstance();
        c.add(Calendar.MONTH, 1);
        c.add(Calendar.YEAR, -1);
        int year = c.get(Calendar.YEAR);
        sTime = year +"-1-1 00:00:00";
        int month2 = c.get(Calendar.MONTH);
        int day2 = c.get(Calendar.DAY_OF_MONTH);
        eTime = year+"-"+month2+"-"+day2+" 00:00:00";
        int lastYear =featureWorkEventMapper.selectByLastYear(sTime,eTime,workType);
        c.add(Calendar.YEAR, 1);
        int year2 = c.get(Calendar.YEAR);
        month2 = c.get(Calendar.MONTH);
        day2 = c.get(Calendar.DAY_OF_MONTH);
        sTime = year2+"-1-1 00:00:00";
        eTime = year2+"-"+month2+"-"+day2+" 00:00:00";
        int thisYear =featureWorkEventMapper.selectByLastYear(sTime,eTime,workType);
        //今年 - 去年 / 去年
        double dou = 0.00;
        if(lastYear != 0 && thisYear != 0){
            double thisYear1=thisYear;
            double lastYear1 =lastYear;
            dou = (thisYear1 -lastYear1) / lastYear1;
        }
        return String.format("%.2f",dou);
    }

    /**
     * 获取最近六个月份  ["2022-07","2022-06","2022-05"...]
     *
     * @return
     */
    public List<String> getNearSixMonth() {
        List<String> resultList = new ArrayList<String>();
        Calendar cal = Calendar.getInstance();
        //近六个月
        //要先+1,才能把本月的算进去
        cal.set(Calendar.MONTH, cal.get(Calendar.MONTH) + 1);
        for (int i = 0; i < 6; i++) {
            //逐次往前推1个月
            cal.set(Calendar.MONTH, cal.get(Calendar.MONTH) - 1);
            resultList.add(String.valueOf(cal.get(Calendar.YEAR))
                    + "-" + (cal.get(Calendar.MONTH) + 1 < 10 ? "0" +
                    (cal.get(Calendar.MONTH) + 1) : (cal.get(Calendar.MONTH) + 1)));
        }
        return resultList;
    }
}
