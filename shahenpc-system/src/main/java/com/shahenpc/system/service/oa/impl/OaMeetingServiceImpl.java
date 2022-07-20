package com.shahenpc.system.service.oa.impl;

import java.util.*;
import java.util.stream.Collectors;

import com.shahenpc.common.core.domain.entity.SysDictData;
import com.shahenpc.common.utils.DateUtils;
import com.shahenpc.system.domain.budget.dto.AlarmAndBudgetDto;
import com.shahenpc.system.domain.budget.dto.OutlayCakeDto;
import com.shahenpc.system.domain.feature.FeatureWorkEvent;
import com.shahenpc.system.domain.feature.dto.FeatureCurveDto;
import com.shahenpc.system.domain.oa.dto.MeetingCakeDto;
import com.shahenpc.system.domain.oa.dto.MeetingColumnarDto;
import com.shahenpc.system.service.ISysDictDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shahenpc.system.mapper.oa.OaMeetingMapper;
import com.shahenpc.system.domain.oa.OaMeeting;
import com.shahenpc.system.service.oa.IOaMeetingService;

/**
 * 人大办公-会议管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-07-19
 */
@Service
public class OaMeetingServiceImpl implements IOaMeetingService 
{
    @Autowired
    private OaMeetingMapper oaMeetingMapper;
    @Autowired
    private ISysDictDataService dictDataService;
    /**
     * 查询人大办公-会议管理
     * 
     * @param meetingId 人大办公-会议管理主键
     * @return 人大办公-会议管理
     */
    @Override
    public OaMeeting selectOaMeetingByMeetingId(Long meetingId)
    {
        return oaMeetingMapper.selectOaMeetingByMeetingId(meetingId);
    }

    /**
     * 查询人大办公-会议管理列表
     * 
     * @param oaMeeting 人大办公-会议管理
     * @return 人大办公-会议管理
     */
    @Override
    public List<OaMeeting> selectOaMeetingList(OaMeeting oaMeeting)
    {
        return oaMeetingMapper.selectOaMeetingList(oaMeeting);
    }

    /**
     * 新增人大办公-会议管理
     * 
     * @param oaMeeting 人大办公-会议管理
     * @return 结果
     */
    @Override
    public int insertOaMeeting(OaMeeting oaMeeting)
    {
        oaMeeting.setCreateTime(DateUtils.getNowDate());
        return oaMeetingMapper.insertOaMeeting(oaMeeting);
    }

    /**
     * 修改人大办公-会议管理
     * 
     * @param oaMeeting 人大办公-会议管理
     * @return 结果
     */
    @Override
    public int updateOaMeeting(OaMeeting oaMeeting)
    {
        oaMeeting.setUpdateTime(DateUtils.getNowDate());
        return oaMeetingMapper.updateOaMeeting(oaMeeting);
    }

    /**
     * 批量删除人大办公-会议管理
     * 
     * @param meetingIds 需要删除的人大办公-会议管理主键
     * @return 结果
     */
    @Override
    public int deleteOaMeetingByMeetingIds(Long[] meetingIds)
    {
        return oaMeetingMapper.deleteOaMeetingByMeetingIds(meetingIds);
    }

    /**
     * 删除人大办公-会议管理信息
     * 
     * @param meetingId 人大办公-会议管理主键
     * @return 结果
     */
    @Override
    public int deleteOaMeetingByMeetingId(Long meetingId)
    {
        return oaMeetingMapper.deleteOaMeetingByMeetingId(meetingId);
    }

    /**
     * 饼图
     * @return
     */
    @Override
    public List<MeetingCakeDto> MeetingCake() {
        List<MeetingCakeDto> dtoList = new ArrayList<>();
        OaMeeting oaMeeting = new OaMeeting();
        List<OaMeeting>  alarBudg=oaMeetingMapper.selectOaMeetingList(oaMeeting);
        SysDictData dictParam = new SysDictData();
        dictParam.setDictType("meeting_type");
        List<SysDictData> dictList = dictDataService.selectDictDataList(dictParam);
        for (int i = 0; i < dictList.size(); i++) {
            int finalI = i;
            String shu =  dictList.get(i).getDictValue();
            int v = alarBudg.stream().filter(p -> shu.equals(Integer.toString(p.getMeetingType()))).collect(Collectors.toList()).size();
            MeetingCakeDto item = new MeetingCakeDto();
            item.setName(dictList.get(i).getDictLabel());
            item.setValue(v);
            dtoList.add(item);
        }
        return dtoList;
    }

    @Override
    public MeetingColumnarDto columnarCount() {
        List<String> monthList = getNearSixMonth();
        MeetingColumnarDto res = new MeetingColumnarDto();
        res.setLabel(monthList);
        List<Integer> yList = new ArrayList<>();
        //获取最小日期
        Date minMonth = DateUtils.parseDate(monthList.get(monthList.size() - 1));
        OaMeeting dto = new OaMeeting();
        List<OaMeeting> nearlist = oaMeetingMapper.selectOaMeetingList(dto);
        for (int i = 0; i < monthList.size(); i++) {
            int finalI = i;
            dto.setCreateTime(DateUtils.parseDate(monthList.get(finalI)));
            String cntt = monthList.get(finalI);
            List<OaMeeting> nearlist1 = nearlist.stream().
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
