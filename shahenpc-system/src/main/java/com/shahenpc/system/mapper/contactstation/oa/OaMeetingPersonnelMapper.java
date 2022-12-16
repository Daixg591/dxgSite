package com.shahenpc.system.mapper.contactstation.oa;

import java.util.List;
import com.shahenpc.system.domain.oa.OaMeetingPersonnel;
import org.apache.ibatis.annotations.Param;

/**
 * 会议人员Mapper接口
 * 
 * @author ruoyi
 * @date 2022-07-19
 */
public interface OaMeetingPersonnelMapper 
{
    /**
     * 查询会议人员
     * 
     * @param personnelId 会议人员主键
     * @return 会议人员
     */
    public OaMeetingPersonnel selectOaMeetingPersonnelByPersonnelId(Long personnelId);

    /**
     * 查询会议人员列表
     * 
     * @param oaMeetingPersonnel 会议人员
     * @return 会议人员集合
     */
    public List<OaMeetingPersonnel> selectOaMeetingPersonnelList(OaMeetingPersonnel oaMeetingPersonnel);

    /**
     * 新增会议人员
     * 
     * @param oaMeetingPersonnel 会议人员
     * @return 结果
     */
    public int insertOaMeetingPersonnel(OaMeetingPersonnel oaMeetingPersonnel);

    /**
     * 修改会议人员
     * 
     * @param oaMeetingPersonnel 会议人员
     * @return 结果
     */
    public int updateOaMeetingPersonnel(OaMeetingPersonnel oaMeetingPersonnel);

    /**
     * 删除会议人员
     * 
     * @param personnelId 会议人员主键
     * @return 结果
     */
    public int deleteOaMeetingPersonnelByPersonnelId(Long personnelId);

    public int deleteOaMeetingPersonnelByMeetingId(Long meetingId);
    /**
     * 批量删除会议人员
     * 
     * @param personnelIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteOaMeetingPersonnelByPersonnelIds(Long[] personnelIds);

    public List<Long> selectByMeetingId(Long meetingId);

    public OaMeetingPersonnel selectByMeetingIdAndUserId(@Param("meetingId") Long meetingId, @Param("userId") Long userId);
}
