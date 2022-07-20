package com.shahenpc.system.service.oa;

import java.util.List;
import com.shahenpc.system.domain.oa.OaMeeting;
import com.shahenpc.system.domain.oa.dto.MeetingCakeDto;
import com.shahenpc.system.domain.oa.dto.MeetingColumnarDto;

/**
 * 人大办公-会议管理Service接口
 * 
 * @author ruoyi
 * @date 2022-07-19
 */
public interface IOaMeetingService 
{
    /**
     * 查询人大办公-会议管理
     * 
     * @param meetingId 人大办公-会议管理主键
     * @return 人大办公-会议管理
     */
    public OaMeeting selectOaMeetingByMeetingId(Long meetingId);

    /**
     * 查询人大办公-会议管理列表
     * 
     * @param oaMeeting 人大办公-会议管理
     * @return 人大办公-会议管理集合
     */
    public List<OaMeeting> selectOaMeetingList(OaMeeting oaMeeting);

    /**
     * 新增人大办公-会议管理
     * 
     * @param oaMeeting 人大办公-会议管理
     * @return 结果
     */
    public int insertOaMeeting(OaMeeting oaMeeting);

    /**
     * 修改人大办公-会议管理
     * 
     * @param oaMeeting 人大办公-会议管理
     * @return 结果
     */
    public int updateOaMeeting(OaMeeting oaMeeting);

    /**
     * 批量删除人大办公-会议管理
     * 
     * @param meetingIds 需要删除的人大办公-会议管理主键集合
     * @return 结果
     */
    public int deleteOaMeetingByMeetingIds(Long[] meetingIds);

    /**
     * 删除人大办公-会议管理信息
     * 
     * @param meetingId 人大办公-会议管理主键
     * @return 结果
     */
    public int deleteOaMeetingByMeetingId(Long meetingId);

    /**
     * 饼图
     * @return
     */
    public List<MeetingCakeDto> MeetingCake();

    /**
     * 柱状
     */
    public MeetingColumnarDto columnarCount();
}
