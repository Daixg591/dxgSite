package com.shahenpc.system.service.feature.impl;

import java.util.*;
import java.util.stream.Collectors;

import com.shahenpc.common.utils.DateUtils;
import com.shahenpc.system.domain.feature.dto.FeatureCakeDto;
import com.shahenpc.system.domain.feature.dto.FeatureCurveDto;
import com.shahenpc.system.domain.feature.dto.FeatureMonthDto;
import com.shahenpc.system.domain.personel.PersonnelAppointRegister;
import com.shahenpc.system.domain.personel.dto.PersonnelQueryDto;
import com.shahenpc.system.domain.personel.vo.TendencyChart;
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
    public FeatureCurveDto monthCount(Integer workType) {
        List<String> monthList = getNearSixMonth();
        FeatureCurveDto res = new FeatureCurveDto();
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
