package com.shahenpc.system.service.oa;

import java.util.List;
import com.shahenpc.system.domain.oa.OaMeetingSign;

/**
 * 会议签到记录Service接口
 * 
 * @author ruoyi
 * @date 2022-07-19
 */
public interface IOaMeetingSignService 
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
     * 批量删除会议签到记录
     * 
     * @param signIds 需要删除的会议签到记录主键集合
     * @return 结果
     */
    public int deleteOaMeetingSignBySignIds(Long[] signIds);

    /**
     * 删除会议签到记录信息
     * 
     * @param signId 会议签到记录主键
     * @return 结果
     */
    public int deleteOaMeetingSignBySignId(Long signId);
}
