package com.shahenpc.system.service.perform;

import java.util.List;
import com.shahenpc.system.domain.perform.PerformHomeAccess;
import com.shahenpc.system.domain.perform.dto.PerformHomeAccessDto;

/**
 * 代之家访问Service接口
 * 
 * @author ruoyi
 * @date 2022-07-08
 */
public interface IPerformHomeAccessService 
{
    /**
     * 查询代之家访问
     * 
     * @param accessId 代之家访问主键
     * @return 代之家访问
     */
    public PerformHomeAccess selectPerformHomeAccessByAccessId(Long accessId);

    /**
     * 查询代之家访问列表
     * 
     * @param performHomeAccess 代之家访问
     * @return 代之家访问集合
     */
    public List<PerformHomeAccess> selectPerformHomeAccessList(PerformHomeAccessDto performHomeAccess);

    /**
     * 新增代之家访问
     * 
     * @param performHomeAccess 代之家访问
     * @return 结果
     */
    public int insertPerformHomeAccess(PerformHomeAccess performHomeAccess);

    /**
     * 修改代之家访问
     * 
     * @param performHomeAccess 代之家访问
     * @return 结果
     */
    public int updatePerformHomeAccess(PerformHomeAccess performHomeAccess);

    /**
     * 批量删除代之家访问
     * 
     * @param accessIds 需要删除的代之家访问主键集合
     * @return 结果
     */
    public int deletePerformHomeAccessByAccessIds(Long[] accessIds);

    /**
     * 删除代之家访问信息
     * 
     * @param accessId 代之家访问主键
     * @return 结果
     */
    public int deletePerformHomeAccessByAccessId(Long accessId);

    public int selectVisitsCount();
}
