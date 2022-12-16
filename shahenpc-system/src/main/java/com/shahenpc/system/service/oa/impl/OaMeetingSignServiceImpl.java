package com.shahenpc.system.service.oa.impl;

import java.util.List;

import com.shahenpc.common.core.domain.AjaxResult;
import com.shahenpc.common.utils.DateUtils;
import com.shahenpc.system.domain.oa.OaMeetingPersonnel;
import com.shahenpc.system.mapper.contactstation.oa.OaMeetingPersonnelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shahenpc.system.mapper.contactstation.oa.OaMeetingSignMapper;
import com.shahenpc.system.domain.oa.OaMeetingSign;
import com.shahenpc.system.service.oa.IOaMeetingSignService;

/**
 * 会议签到记录Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-07-19
 */
@Service
public class OaMeetingSignServiceImpl implements IOaMeetingSignService 
{
    @Autowired
    private OaMeetingSignMapper oaMeetingSignMapper;
    @Autowired
    private OaMeetingPersonnelMapper oaMeetingPersonnelMapper;
    /**
     * 查询会议签到记录
     * 
     * @param signId 会议签到记录主键
     * @return 会议签到记录
     */
    @Override
    public OaMeetingSign selectOaMeetingSignBySignId(Long signId)
    {
        return oaMeetingSignMapper.selectOaMeetingSignBySignId(signId);
    }

    /**
     * 查询会议签到记录列表
     * 
     * @param oaMeetingSign 会议签到记录
     * @return 会议签到记录
     */
    @Override
    public List<OaMeetingSign> selectOaMeetingSignList(OaMeetingSign oaMeetingSign)
    {
        return oaMeetingSignMapper.selectOaMeetingSignList(oaMeetingSign);
    }

    /**
     * 新增会议签到记录
     * 
     * @param oaMeetingSign 会议签到记录
     * @return 结果
     */
    @Override
    public int insertOaMeetingSign(OaMeetingSign oaMeetingSign)
    {
        oaMeetingSign.setCreateTime(DateUtils.getNowDate());
        return oaMeetingSignMapper.insertOaMeetingSign(oaMeetingSign);
    }

    /**
     * 修改会议签到记录
     * 
     * @param oaMeetingSign 会议签到记录
     * @return 结果
     */
    @Override
    public int updateOaMeetingSign(OaMeetingSign oaMeetingSign)
    {
        oaMeetingSign.setUpdateTime(DateUtils.getNowDate());
        return oaMeetingSignMapper.updateOaMeetingSign(oaMeetingSign);
    }

    /**
     * 批量删除会议签到记录
     * 
     * @param signIds 需要删除的会议签到记录主键
     * @return 结果
     */
    @Override
    public int deleteOaMeetingSignBySignIds(Long[] signIds)
    {
        return oaMeetingSignMapper.deleteOaMeetingSignBySignIds(signIds);
    }

    /**
     * 删除会议签到记录信息
     * 
     * @param signId 会议签到记录主键
     * @return 结果
     */
    @Override
    public int deleteOaMeetingSignBySignId(Long signId)
    {
        return oaMeetingSignMapper.deleteOaMeetingSignBySignId(signId);
    }

    @Override
    public AjaxResult sign(Long meeting, Long userId) {
        OaMeetingSign signSvan = oaMeetingSignMapper.selectByMeetingIdAndUserIds(meeting,userId);
        if(signSvan != null){
            OaMeetingPersonnel personnel=oaMeetingPersonnelMapper.selectByMeetingIdAndUserId(meeting,userId);
            if(personnel != null){
                OaMeetingSign sign = new OaMeetingSign();
                sign.setUserId(userId);
                sign.setPersonnelId(personnel.getPersonnelId());
                sign.setMeetingId(meeting);
                sign.setCreateTime(DateUtils.getNowDate());
                return AjaxResult.success(oaMeetingSignMapper.insertOaMeetingSign(sign));
            }else{
                return AjaxResult.error("会议没有邀请您，请勿操作！");
            }
        }else {
           return AjaxResult.error("您已签到，请勿重复操作！");
        }
    }
}
