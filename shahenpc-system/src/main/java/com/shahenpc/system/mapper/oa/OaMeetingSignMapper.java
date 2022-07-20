package com.shahenpc.system.mapper.oa;

import java.util.List;
import com.shahenpc.system.domain.oa.OaMeetingSign;

/**
 * 会议签到记录Mapper接口
 * 
 * @author ruoyi
 * @date 2022-07-19
 */
public interface OaMeetingSignMapper 
{
    /**
     * 查询会议签到记录
     * 
     * @param signId 会议签到记录主键
     * @return 会议签到记录
     */
    public OaMeetingSign selectOaMeetingSignBySignId(Long signId);

    /**
     * 查询会议签到记录列表
     * 
     * @param oaMeetingSign 会议签到记录
     * @return 会议签到记录集合
     */
    public List<OaMeetingSign> selectOaMeetingSignList(OaMeetingSign oaMeetingSign);

    /**
     * 新增会议签到记录
     * 
     * @param oaMeetingSign 会议签到记录
     * @return 结果
     */
    public int insertOaMeetingSign(OaMeetingSign oaMeetingSign);

    /**
     * 修改会议签到记录
     * 
     * @param oaMeetingSign 会议签到记录
     * @return 结果
     */
    public int updateOaMeetingSign(OaMeetingSign oaMeetingSign);

    /**
     * 删除会议签到记录
     * 
     * @param signId 会议签到记录主键
     * @return 结果
     */
    public int deleteOaMeetingSignBySignId(Long signId);

    /**
     * 批量删除会议签到记录
     * 
     * @param signIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteOaMeetingSignBySignIds(Long[] signIds);

    public List<OaMeetingSign> selectByMeetingId(Long meetingId);
}
