package com.shahenpc.system.service.perform.impl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import com.shahenpc.common.utils.DateUtils;
import com.shahenpc.system.domain.perform.dto.PerformHomeAccessDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shahenpc.system.mapper.perform.PerformHomeAccessMapper;
import com.shahenpc.system.domain.perform.PerformHomeAccess;
import com.shahenpc.system.service.perform.IPerformHomeAccessService;

/**
 * 代之家访问Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-07-08
 */
@Service
public class PerformHomeAccessServiceImpl implements IPerformHomeAccessService 
{
    @Autowired
    private PerformHomeAccessMapper performHomeAccessMapper;

    /**
     * 查询代之家访问
     * 
     * @param accessId 代之家访问主键
     * @return 代之家访问
     */
    @Override
    public PerformHomeAccess selectPerformHomeAccessByAccessId(Long accessId)
    {
        return performHomeAccessMapper.selectPerformHomeAccessByAccessId(accessId);
    }

    /**
     * 查询代之家访问列表
     * 
     * @param performHomeAccess 代之家访问
     * @return 代之家访问
     */
    @Override
    public List<PerformHomeAccess> selectPerformHomeAccessList(PerformHomeAccessDto performHomeAccess)
    {
        List<PerformHomeAccess> list = null;
        list =performHomeAccessMapper.selectPerformHomeAccessList(performHomeAccess);
         if(performHomeAccess.getType() == 1){
             list = (List<PerformHomeAccess>) list.stream().sorted(Comparator.comparing(PerformHomeAccess :: getBrowseNumber));
         }
        return list;
    }

    /**
     * 新增代之家访问
     * 
     * @param performHomeAccess 代之家访问
     * @return 结果
     */
    @Override
    public int insertPerformHomeAccess(PerformHomeAccess performHomeAccess)
    {
        performHomeAccess.setCreateTime(DateUtils.getNowDate());
        return performHomeAccessMapper.insertPerformHomeAccess(performHomeAccess);
    }

    /**
     * 修改代之家访问
     * 
     * @param performHomeAccess 代之家访问
     * @return 结果
     */
    @Override
    public int updatePerformHomeAccess(PerformHomeAccess performHomeAccess)
    {
        performHomeAccess.setUpdateTime(DateUtils.getNowDate());
        return performHomeAccessMapper.updatePerformHomeAccess(performHomeAccess);
    }

    /**
     * 批量删除代之家访问
     * 
     * @param accessIds 需要删除的代之家访问主键
     * @return 结果
     */
    @Override
    public int deletePerformHomeAccessByAccessIds(Long[] accessIds)
    {
        return performHomeAccessMapper.deletePerformHomeAccessByAccessIds(accessIds);
    }

    /**
     * 删除代之家访问信息
     * 
     * @param accessId 代之家访问主键
     * @return 结果
     */
    @Override
    public int deletePerformHomeAccessByAccessId(Long accessId)
    {
        return performHomeAccessMapper.deletePerformHomeAccessByAccessId(accessId);
    }

    @Override
    public int selectVisitsCount() {
        return performHomeAccessMapper.selectVisitsCount();
    }
}
