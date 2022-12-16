package com.shahenpc.system.service.oa.impl;

import java.util.List;

import com.alibaba.fastjson2.JSON;
import com.shahenpc.common.core.domain.AjaxResult;
import com.shahenpc.common.utils.DateUtils;
import com.shahenpc.common.utils.StringUtils;
import com.shahenpc.common.utils.http.HttpUtils;
import com.shahenpc.system.domain.oa.OaVotePlayer;
import com.shahenpc.system.domain.oa.vo.VoteRecordVo;
import com.shahenpc.system.domain.wxsmallprogram.dto.WxAuthDto;
import com.shahenpc.system.domain.wxsmallprogram.vo.WxAuthVo;
import com.shahenpc.system.mapper.contactstation.oa.OaVotePlayerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shahenpc.system.mapper.contactstation.oa.OaVoteRecordMapper;
import com.shahenpc.system.domain.oa.OaVoteRecord;
import com.shahenpc.system.service.oa.IOaVoteRecordService;
import org.springframework.transaction.annotation.Transactional;

/**
 * 投票记录Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-09-05
 */
@Service
public class OaVoteRecordServiceImpl implements IOaVoteRecordService
{
    @Autowired
    private OaVoteRecordMapper ovVoteRecordMapper;
    @Autowired
    private OaVotePlayerMapper oaVotePlayerMapper;
    /**
     * 查询投票记录
     * 
     * @param recordId 投票记录主键
     * @return 投票记录
     */
    @Override
    public OaVoteRecord selectOvVoteRecordByRecordId(Long recordId)
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
    public List<OaVoteRecord> selectOvVoteRecordList(OaVoteRecord ovVoteRecord)
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
    public int insertOvVoteRecord(OaVoteRecord ovVoteRecord)
    {
        ovVoteRecord.setCreateTime(DateUtils.getNowDate());
        return ovVoteRecordMapper.insertOvVoteRecord(ovVoteRecord);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public AjaxResult insertPlayerIds(VoteRecordVo requst) {
        OaVoteRecord ovVoteRecord = new OaVoteRecord();
            ovVoteRecord.setCreateTime(DateUtils.getNowDate());
//          ovVoteRecord.setUserId(requst.getUserId());
            ovVoteRecord.setVoteId(requst.getVoteId());
            ovVoteRecord.setOpenId(getWxOpenId(requst.getCode()));
            List<OaVoteRecord> list = ovVoteRecordMapper.selectOvVoteRecordList(ovVoteRecord);
            if(list.size() == 0){
                if(requst.getPlayerIds().length == 0){
                    return AjaxResult.error("请选择投票人员！");
                }
                for(Long item:requst.getPlayerIds()){
                    ovVoteRecord.setPlayerId(item);
                    if(ovVoteRecordMapper.insertOvVoteRecord(ovVoteRecord) <= 0){
                        return AjaxResult.error("");
                    }
                    //修改
                    OaVotePlayer pla= oaVotePlayerMapper.selectOaVotePlayerByPlayerId(item);
                    pla.setTotal(pla.getTotal()+1);
                    if(oaVotePlayerMapper.updateOaVotePlayer(pla)<= 0 ){
                        return AjaxResult.error("");
                    }
            }
        }else{
                return AjaxResult.error("您已投票，不可重复投票。");
            }
        return AjaxResult.success();
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
    public int updateOvVoteRecord(OaVoteRecord ovVoteRecord)
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
