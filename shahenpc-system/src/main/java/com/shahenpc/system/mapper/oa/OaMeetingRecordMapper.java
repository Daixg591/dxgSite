package com.shahenpc.system.mapper.oa;

import java.util.List;
import com.shahenpc.system.domain.oa.OaMeetingRecord;

/**
 * 会议记录Mapper接口
 * 
 * @author ruoyi
 * @date 2022-07-19
 */
public interface OaMeetingRecordMapper 
{
    /**
     * 查询会议记录
     * 
     * @param recordId 会议记录主键
     * @return 会议记录
     */
    public OaMeetingRecord selectOaMeetingRecordByRecordId(Long recordId);

    /**
     * 查询会议记录列表
     * 
     * @param oaMeetingRecord 会议记录
     * @return 会议记录集合
     */
    public List<OaMeetingRecord> selectOaMeetingRecordList(OaMeetingRecord oaMeetingRecord);

    /**
     * 新增会议记录
     * 
     * @param oaMeetingRecord 会议记录
     * @return 结果
     */
    public int insertOaMeetingRecord(OaMeetingRecord oaMeetingRecord);

    /**
     * 修改会议记录
     * 
     * @param oaMeetingRecord 会议记录
     * @return 结果
     */
    public int updateOaMeetingRecord(OaMeetingRecord oaMeetingRecord);

    /**
     * 删除会议记录
     * 
     * @param recordId 会议记录主键
     * @return 结果
     */
    public int deleteOaMeetingRecordByRecordId(Long recordId);

    /**
     * 批量删除会议记录
     * 
     * @param recordIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteOaMeetingRecordByRecordIds(Long[] recordIds);

    public List<OaMeetingRecord> selectByMeetingId(Long meetingId);

}
