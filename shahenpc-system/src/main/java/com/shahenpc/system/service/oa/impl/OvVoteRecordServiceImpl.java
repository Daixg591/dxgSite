package com.shahenpc.system.service.oa.impl;

import java.util.List;

import com.alibaba.fastjson2.JSON;
import com.shahenpc.common.utils.DateUtils;
import com.shahenpc.common.utils.StringUtils;
import com.shahenpc.common.utils.http.HttpUtils;
import com.shahenpc.system.domain.oa.vo.VoteRecordVo;
import com.shahenpc.system.domain.wxsmallprogram.dto.WxAuthDto;
import com.shahenpc.system.domain.wxsmallprogram.vo.WxAuthVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shahenpc.system.mapper.oa.OvVoteRecordMapper;
import com.shahenpc.system.domain.oa.OvVoteRecord;
import com.shahenpc.system.service.oa.IOvVoteRecordService;
import org.springframework.transaction.annotation.Transactional;

/**
 * 投票记录Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-09-05
 */
@Service
public class OvVoteRecordServiceImpl implements IOvVoteRecordService 
{
    @Autowired
    private OvVoteRecordMapper ovVoteRecordMapper;

    /**
     * 查询投票记录
     * 
     * @param recordId 投票记录主键
     * @return 投票记录
     */
    @Override
    public OvVoteRecord selectOvVoteRecordByRecordId(Long recordId)
    {
        return ovVoteRecordMapper.selectOvVoteRecordByRecordId(recordId);
    }

    /**
     * 查询投票记录列表
     * 
     * @param ovVoteRecord 投票记录
     * @return 投票记录
     */
    @Override
    public List<OvVoteRecord> selectOvVoteRecordList(OvVoteRecord ovVoteRecord)
    {
        return ovVoteRecordMapper.selectOvVoteRecordList(ovVoteRecord);
    }

    /**
     * 新增投票记录
     * 
     * @param ovVoteRecord 投票记录
     * @return 结果
     */
    @Override
    public int insertOvVoteRecord(OvVoteRecord ovVoteRecord)
    {
        ovVoteRecord.setCreateTime(DateUtils.getNowDate());
        return ovVoteRecordMapper.insertOvVoteRecord(ovVoteRecord);
    }

    @Override
    @Transactional
    public int insertPlayerIds(VoteRecordVo requst) {
        OvVoteRecord ovVoteRecord = new OvVoteRecord();
        int suss= 0;
        for(Long item:requst.getPlayerIds()){
            ovVoteRecord.setCreateTime(DateUtils.getNowDate());
            ovVoteRecord.setUserId(requst.getUserId());
            ovVoteRecord.setVoteId(requst.getVoteId());
            ovVoteRecord.setPlayerId(item);
            ovVoteRecord.setOpenId(getWxOpenId(requst.getCode()));
            suss = ovVoteRecordMapper.insertOvVoteRecord(ovVoteRecord);
        }
        return suss;
    }

    private String getWxOpenId(String code) {
        WxAuthDto dto = new WxAuthDto();
        dto.setJs_code(code);
        dto.setGrant_type("authorization_code");
        String param = getParamStr(dto);
        String res = HttpUtils.sendGet("https://api.weixin.qq.com/sns/jscode2session", param);
        WxAuthVo authVo = JSON.parseObject(JSON.parse(res).toString(), WxAuthVo.class);
        if (authVo != null) {
            return authVo.getOpenid();
        } else {
            return "";
        }
    }

    public String getParamStr(WxAuthDto dto) {
        String resParam = "appid=" + dto.getAppid() + "&secret=" + dto.getSecret()
                + "&grant_type=" + dto.getGrant_type();
        if (!StringUtils.isEmpty(dto.getJs_code())) {
            resParam += "&js_code=" + dto.getJs_code();
        }
        return resParam;
    }
    /**
     * 修改投票记录
     * 
     * @param ovVoteRecord 投票记录
     * @return 结果
     */
    @Override
    public int updateOvVoteRecord(OvVoteRecord ovVoteRecord)
    {
        ovVoteRecord.setUpdateTime(DateUtils.getNowDate());
        return ovVoteRecordMapper.updateOvVoteRecord(ovVoteRecord);
    }

    /**
     * 批量删除投票记录
     * 
     * @param recordIds 需要删除的投票记录主键
     * @return 结果
     */
    @Override
    public int deleteOvVoteRecordByRecordIds(Long[] recordIds)
    {
        return ovVoteRecordMapper.deleteOvVoteRecordByRecordIds(recordIds);
    }

    /**
     * 删除投票记录信息
     * 
     * @param recordId 投票记录主键
     * @return 结果
     */
    @Override
    public int deleteOvVoteRecordByRecordId(Long recordId)
    {
        return ovVoteRecordMapper.deleteOvVoteRecordByRecordId(recordId);
    }
}
