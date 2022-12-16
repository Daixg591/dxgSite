package com.shahenpc.system.service.oa.impl;

import java.util.List;
import com.shahenpc.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shahenpc.system.mapper.contactstation.oa.OaMeetingPersonnelMapper;
import com.shahenpc.system.domain.oa.OaMeetingPersonnel;
import com.shahenpc.system.service.oa.IOaMeetingPersonnelService;

/**
 * 会议人员Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-07-19
 */
@Service
public class OaMeetingPersonnelServiceImpl implements IOaMeetingPersonnelService 
{
    @Autowired
    private OaMeetingPersonnelMapper oaMeetingPersonnelMapper;

    /**
     * 查询会议人员
     * 
     * @param personnelId 会议人员主键
     * @return 会议人员
     */
    @Override
    public OaMeetingPersonnel selectOaMeetingPersonnelByPersonnelId(Long personnelId)
    {
        return oaMeetingPersonnelMapper.selectOaMeetingPersonnelByPersonnelId(personnelId);
    }

    /**
     * 查询会议人员列表
     * 
     * @param oaMeetingPersonnel 会议人员
     * @return 会议人员
     */
    @Override
    public List<OaMeetingPersonnel> selectOaMeetingPersonnelList(OaMeetingPersonnel oaMeetingPersonnel)
    {
        return oaMeetingPersonnelMapper.selectOaMeetingPersonnelList(oaMeetingPersonnel);
    }

    /**
     * 新增会议人员
     * 
     * @param oaMeetingPersonnel 会议人员
     * @return 结果
     */
    @Override
    public int insertOaMeetingPersonnel(OaMeetingPersonnel oaMeetingPersonnel)
    {
        oaMeetingPersonnel.setCreateTime(DateUtils.getNowDate());
        return oaMeetingPersonnelMapper.insertOaMeetingPersonnel(oaMeetingPersonnel);
    }

    /**
     * 修改会议人员
     * 
     * @param oaMeetingPersonnel 会议人员
     * @return 结果
     */
    @Override
    public int updateOaMeetingPersonnel(OaMeetingPersonnel oaMeetingPersonnel)
    {
        oaMeetingPersonnel.setUpdateTime(DateUtils.getNowDate());
        return oaMeetingPersonnelMapper.updateOaMeetingPersonnel(oaMeetingPersonnel);
    }

    /**
     * 批量删除会议人员
     * 
     * @param personnelIds 需要删除的会议人员主键
     * @return 结果
     */
    @Override
    public int deleteOaMeetingPersonnelByPersonnelIds(Long[] personnelIds)
    {
        return oaMeetingPersonnelMapper.deleteOaMeetingPersonnelByPersonnelIds(personnelIds);
    }

    /**
     * 删除会议人员信息
     * 
     * @param personnelId 会议人员主键
     * @return 结果
     */
    @Override
    public int deleteOaMeetingPersonnelByPersonnelId(Long personnelId)
    {
        return oaMeetingPersonnelMapper.deleteOaMeetingPersonnelByPersonnelId(personnelId);
    }
}
