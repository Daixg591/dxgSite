package com.shahenpc.system.service.represent.impl;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson2.JSONObject;
import com.shahenpc.common.constant.Constants;
import com.shahenpc.common.utils.DateUtils;
import com.shahenpc.common.utils.http.HttpUtils;
import com.shahenpc.common.utils.sign.Sign;
import com.shahenpc.system.domain.represent.vo.VirtualVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shahenpc.system.mapper.represent.RepresentHomeAccessMapper;
import com.shahenpc.system.domain.represent.RepresentHomeAccess;
import com.shahenpc.system.service.represent.IRepresentHomeAccessService;

/**
 * 代之家访问Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-07-21
 */
@Service
public class RepresentHomeAccessServiceImpl implements IRepresentHomeAccessService 
{
    @Autowired
    private RepresentHomeAccessMapper representHomeAccessMapper;

    /**
     * 查询代之家访问
     * 
     * @param accessId 代之家访问主键
     * @return 代之家访问
     */
    @Override
    public RepresentHomeAccess selectRepresentHomeAccessByAccessId(Long accessId)
    {
        return representHomeAccessMapper.selectRepresentHomeAccessByAccessId(accessId);
    }

    /**
     * 查询代之家访问列表
     * 
     * @param representHomeAccess 代之家访问
     * @return 代之家访问
     */
    @Override
    public List<RepresentHomeAccess> selectRepresentHomeAccessList(RepresentHomeAccess representHomeAccess)
    {
        return representHomeAccessMapper.selectRepresentHomeAccessList(representHomeAccess);
    }

    /**
     * 新增代之家访问
     * 
     * @param representHomeAccess 代之家访问
     * @return 结果
     */
    @Override
    public int insertRepresentHomeAccess(RepresentHomeAccess representHomeAccess)
    {
        representHomeAccess.setCreateTime(DateUtils.getNowDate());
        return representHomeAccessMapper.insertRepresentHomeAccess(representHomeAccess);
    }

    /**
     * 修改代之家访问
     * 
     * @param representHomeAccess 代之家访问
     * @return 结果
     */
    @Override
    public int updateRepresentHomeAccess(RepresentHomeAccess representHomeAccess)
    {
        representHomeAccess.setUpdateTime(DateUtils.getNowDate());
        return representHomeAccessMapper.updateRepresentHomeAccess(representHomeAccess);
    }

    /**
     * 批量删除代之家访问
     * 
     * @param accessIds 需要删除的代之家访问主键
     * @return 结果
     */
    @Override
    public int deleteRepresentHomeAccessByAccessIds(Long[] accessIds)
    {
        return representHomeAccessMapper.deleteRepresentHomeAccessByAccessIds(accessIds);
    }

    /**
     * 删除代之家访问信息
     * 
     * @param accessId 代之家访问主键
     * @return 结果
     */
    @Override
    public int deleteRepresentHomeAccessByAccessId(Long accessId)
    {
        return representHomeAccessMapper.deleteRepresentHomeAccessByAccessId(accessId);
    }

    @Override
    public int selectVisitsCount() {
        return representHomeAccessMapper.selectVisitsCount();
    }

    @Override
    public List<RepresentHomeAccess> rankingList() {
        return representHomeAccessMapper.rankingList();
    }

    @Override
    public JSONObject createVirtualUser(VirtualVo vo) throws IOException {
        Map<String,String> parameters = new HashMap<String,String>();
        // HTTP 参数列表
        parameters.put("identity", Constants.IDENTITY);
        parameters.put("mobile",vo.getPhone());
        parameters.put("name",vo.getLeader());
        parameters.put("orgCode",Constants.ORG_CODE);
        parameters.put("isTrial",Constants.IS_TRIAL);
        parameters.put("timestamp",String.valueOf(DateUtils.getNowDate().getTime()));
        parameters.put("ECID",Constants.ECID);
        String sign = Sign.sign(Constants.KEY,parameters);
        parameters.put("sign",sign);
        JSONObject json = new JSONObject(parameters);
        String code =  HttpUtils.sendPostByVideo(Constants.YDIP+"/access/rest/v200/createVirtualUser",json.toString());
        String res = code.replaceAll("\\\\","");
        JSONObject jsonObject = JSONObject.parseObject(res);
        if(jsonObject.get("code").equals(200)){
            return jsonObject;
        }else {
            return jsonObject;
        }
    }
}
