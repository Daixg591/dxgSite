package com.shahenpc.system.mapper.represent;

import java.util.List;
import com.shahenpc.system.domain.represent.RepresentHomeAccess;

/**
 * 代之家访问Mapper接口
 * 
 * @author ruoyi
 * @date 2022-07-21
 */
public interface RepresentHomeAccessMapper 
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
     * 删除代之家访问
     * 
     * @param accessId 代之家访问主键
     * @return 结果
     */
    public int deleteRepresentHomeAccessByAccessId(Long accessId);

    /**
     * 批量删除代之家访问
     * 
     * @param accessIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteRepresentHomeAccessByAccessIds(Long[] accessIds);
    /**
     * 访问次数
     * @return
     */
    public int selectVisitsCount();

    public List<RepresentHomeAccess> rankingList();

    public RepresentHomeAccess selectByLevel();

    public RepresentHomeAccess selectByUserId(Long userId);
}
