package com.shahenpc.system.mapper.oa;

import java.util.List;
import com.shahenpc.system.domain.oa.OaMeeting;
import com.shahenpc.system.domain.oa.dto.MeetingDetailDto;

/**
 * 人大办公-会议管理Mapper接口
 * 
 * @author ruoyi
 * @date 2022-07-19
 */
public interface OaMeetingMapper 
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
     * 删除人大办公-会议管理
     * 
     * @param meetingId 人大办公-会议管理主键
     * @return 结果
     */
    public int deleteOaMeetingByMeetingId(Long meetingId);

    /**
     * 批量删除人大办公-会议管理
     * 
     * @param meetingIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteOaMeetingByMeetingIds(Long[] meetingIds);

    public MeetingDetailDto newDetail(Long meetingId);
}
