package com.shahenpc.system.service.represent;

import java.io.IOException;
import java.util.List;

import com.alibaba.fastjson2.JSONObject;
import com.shahenpc.system.domain.represent.RepresentHomeAccess;
import com.shahenpc.system.domain.represent.vo.VirtualVo;

/**
 * 代之家访问Service接口
 * 
 * @author ruoyi
 * @date 2022-07-21
 */
public interface IRepresentHomeAccessService 
{
    /**
     * 查询代之家访问
     * 
     * @param accessId 代之家访问主键
     * @return 代之家访问
     */
    public RepresentHomeAccess selectRepresentHomeAccessByAccessId(Long accessId);

    /**
     * 查询代之家访问列表
     * 
     * @param representHomeAccess 代之家访问
     * @return 代之家访问集合
     */
    public List<RepresentHomeAccess> selectRepresentHomeAccessList(RepresentHomeAccess representHomeAccess);

    /**
     * 新增代之家访问
     * 
     * @param representHomeAccess 代之家访问
     * @return 结果
     */
    public int insertRepresentHomeAccess(RepresentHomeAccess representHomeAccess);

    /**
     * 修改代之家访问
     * 
     * @param representHomeAccess 代之家访问
     * @return 结果
     */
    public int updateRepresentHomeAccess(RepresentHomeAccess representHomeAccess);

    /**
     * 批量删除代之家访问
     * 
     * @param accessIds 需要删除的代之家访问主键集合
     * @return 结果
     */
    public int deleteRepresentHomeAccessByAccessIds(Long[] accessIds);

    /**
     * 删除代之家访问信息
     * 
     * @param accessId 代之家访问主键
     * @return 结果
     */
    public int deleteRepresentHomeAccessByAccessId(Long accessId);

    public int selectVisitsCount();

    public List<RepresentHomeAccess> rankingList();


    public JSONObject createVirtualUser(VirtualVo vo) throws IOException;
}
