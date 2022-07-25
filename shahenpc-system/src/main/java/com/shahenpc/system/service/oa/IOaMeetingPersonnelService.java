package com.shahenpc.system.service.oa;

import java.util.List;
import com.shahenpc.system.domain.oa.OaMeetingPersonnel;

/**
 * 会议人员Service接口
 * 
 * @author ruoyi
 * @date 2022-07-19
 */
public interface IOaMeetingPersonnelService 
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
     * 批量删除会议人员
     * 
     * @param personnelIds 需要删除的会议人员主键集合
     * @return 结果
     */
    public int deleteOaMeetingPersonnelByPersonnelIds(Long[] personnelIds);

    /**
     * 删除会议人员信息
     * 
     * @param personnelId 会议人员主键
     * @return 结果
     */
    public int deleteOaMeetingPersonnelByPersonnelId(Long personnelId);
}
