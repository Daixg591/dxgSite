package com.shahenpc.system.service.oa.impl;

import java.util.*;
import java.util.stream.Collectors;

import com.shahenpc.common.core.domain.AjaxResult;
import com.shahenpc.common.core.domain.entity.SysDictData;
import com.shahenpc.common.utils.DateUtils;
import com.shahenpc.system.domain.oa.OaMeetingPersonnel;
import com.shahenpc.system.domain.oa.OaMeetingSign;
import com.shahenpc.system.domain.oa.dto.*;
import com.shahenpc.system.mapper.oa.OaMeetingPersonnelMapper;
import com.shahenpc.system.mapper.oa.OaMeetingRecordMapper;
import com.shahenpc.system.mapper.oa.OaMeetingSignMapper;
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
    @Autowired
    private OaMeetingPersonnelMapper oaMeetingPersonnelMapper;
    @Autowired
    private OaMeetingRecordMapper oaMeetingRecordMapper;
    @Autowired
    private OaMeetingSignMapper oaMeetingSignMapper;


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
        List<OaMeeting> list =  oaMeetingMapper.selectOaMeetingList(oaMeeting);
        for (OaMeeting item : list) {
            if (item.getStatus() != 0) {
                if (item.getStartTime().getTime() > DateUtils.getNowDate().getTime()) {
                    item.setStatus(1);
                    oaMeetingMapper.updateOaMeeting(item);
                }
                if (item.getStartTime().getTime() < DateUtils.getNowDate().getTime() && item.getEndTime().getTime() > DateUtils.getNowDate().getTime()) {
                    item.setStatus(2);
                    oaMeetingMapper.updateOaMeeting(item);
                }
                if (item.getEndTime().getTime() < DateUtils.getNowDate().getTime()) {
                    item.setStatus(3);
                    oaMeetingMapper.updateOaMeeting(item);
                }
            }
        }
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

    @Override
    public int newAdd(MeetingAddDto request) {
        request.setCreateTime(DateUtils.getNowDate());
        int success= oaMeetingMapper.insertOaMeeting(request);
        for (Long userId :request.getPersonnel()){
            OaMeetingPersonnel item = new OaMeetingPersonnel();
            item.setMeetingId(request.getMeetingId());
            item.setCreateTime(DateUtils.getNowDate());
            item.setUserId(userId);
           int personn = oaMeetingPersonnelMapper.insertOaMeetingPersonnel(item);
            OaMeetingSign sign = new OaMeetingSign();
            if(request.getIsSign() == 0){
                sign.setStatus(1);
            }
            sign.setPersonnelId((long)personn);
            sign.setCreateTime(DateUtils.getNowDate());
            sign.setMeetingId(request.getMeetingId());
            sign.setUserId(userId);
            oaMeetingSignMapper.insertOaMeetingSign(sign);
        }
        return success;
    }

    @Override
    public int newUpdate(MeetingAddDto request) {
        //先删除人员 然后在添加
        oaMeetingPersonnelMapper.deleteOaMeetingPersonnelByMeetingId(request.getMeetingId());
        oaMeetingSignMapper.deleteOaMeetingSignByMeetingId(request.getMeetingId());
        //修改会议
        request.setUpdateTime(DateUtils.getNowDate());
        int success= oaMeetingMapper.updateOaMeeting(request);
        for (Long userId :request.getPersonnel()){
            OaMeetingPersonnel item = new OaMeetingPersonnel();
            item.setMeetingId(request.getMeetingId());
            item.setCreateTime(DateUtils.getNowDate());
            item.setUserId(userId);
            int personn = oaMeetingPersonnelMapper.insertOaMeetingPersonnel(item);
            OaMeetingSign sign = new OaMeetingSign();
            if(request.getIsSign() == 0){
                sign.setStatus(1);
            }
            sign.setPersonnelId((long)personn);
            sign.setCreateTime(DateUtils.getNowDate());
            sign.setMeetingId(request.getMeetingId());
            sign.setUserId(userId);
            oaMeetingSignMapper.insertOaMeetingSign(sign);
        }
        return success;
    }

    @Override
    public MeetingDetailDto newDetail(Long meetingId) {
        MeetingDetailDto dto=oaMeetingMapper.newDetail(meetingId);
//        dto.setPersonnel(oaMeetingPersonnelMapper.selectByMeetingId(meetingId));
//        dto.setSign(oaMeetingSignMapper.selectByMeetingId(meetingId));
//        dto.setRecord(oaMeetingRecordMapper.selectByMeetingId(meetingId));
        return dto;
    }

    @Override
    public MeetingCountMinuteDto selectByCountMinute(Long userId) {
        MeetingCountMinuteDto dto = new MeetingCountMinuteDto();
        dto =oaMeetingMapper.selectByCountMinute(userId);
        dto.setMeetingList(oaMeetingMapper.selectByAppHomeList());
        return dto;
    }

    @Override
    public List<MeetingAppListDto> appList(OaMeeting oaMeeting) {
        return oaMeetingMapper.appList(oaMeeting);
    }

    @Override
    public AjaxResult sign(Long meetingId, Long userId) {
        OaMeetingSign sign = new OaMeetingSign();
        sign.setMeetingId(meetingId);
        sign.setUserId(userId);
        sign.setStatus(1);
        List<OaMeetingSign> sing = oaMeetingSignMapper.selectOaMeetingSignList(sign);
        if(sing.size() == 0){
            return AjaxResult.success(oaMeetingSignMapper.updateOaMeetingSign(sign));
        }else{
            return AjaxResult.error("您已签到，请勿重复操作！");
        }
    }

    @Override
    public AjaxResult signSuccess(Long meetingId, Long userId) {
        OaMeetingSign sign = new OaMeetingSign();
        sign.setMeetingId(meetingId);
        sign.setUserId(userId);
        return AjaxResult.success(oaMeetingSignMapper.selectByMeetingIdAndUserId(sign));
    }

    @Override
    public MeetingAppDetailDto appDetail(Long meetingId,Long userId) {
        return oaMeetingMapper.appDetail(meetingId,userId);
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
    public int deleteOaMeetingByMeetingIds(Long meetingIds)
    {
        if(oaMeetingMapper.deleteOaMeetingByMeetingIds(meetingIds)  > 0){
            oaMeetingRecordMapper.deleteOaMeetingRecordByMeetingId(meetingIds);
            oaMeetingSignMapper.deleteOaMeetingSignByMeetingId(meetingIds);
            oaMeetingPersonnelMapper.deleteOaMeetingPersonnelByMeetingId(meetingIds);
            return 1;
        }
        return 0;
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
