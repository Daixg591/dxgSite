package com.shahenpc.system.service.represent.impl;

import java.util.List;
import com.shahenpc.common.utils.DateUtils;
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
}
