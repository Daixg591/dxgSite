package com.shahenpc.system.service.represent;

import java.util.List;
import com.shahenpc.system.domain.represent.RepresentDiscover;

/**
 * 代-代发现Service接口
 * 
 * @author ruoyi
 * @date 2022-07-28
 */
public interface IRepresentDiscoverService 
{
    /**
     * 查询代-代发现
     * 
     * @param discoverId 代-代发现主键
     * @return 代-代发现
     */
    public RepresentDiscover selectRepresentDiscoverByDiscoverId(Long discoverId);

    /**
     * 查询代-代发现列表
     * 
     * @param representDiscover 代-代发现
     * @return 代-代发现集合
     */
    public List<RepresentDiscover> selectRepresentDiscoverList(RepresentDiscover representDiscover);

    /**
     * 新增代-代发现
     * 
     * @param representDiscover 代-代发现
     * @return 结果
     */
    public int insertRepresentDiscover(RepresentDiscover representDiscover);

    /**
     * 修改代-代发现
     * 
     * @param representDiscover 代-代发现
     * @return 结果
     */
    public int updateRepresentDiscover(RepresentDiscover representDiscover);

    /**
     * 批量删除代-代发现
     * 
     * @param discoverIds 需要删除的代-代发现主键集合
     * @return 结果
     */
    public int deleteRepresentDiscoverByDiscoverIds(Long[] discoverIds);

    /**
     * 删除代-代发现信息
     * 
     * @param discoverId 代-代发现主键
     * @return 结果
     */
    public int deleteRepresentDiscoverByDiscoverId(Long discoverId);
}