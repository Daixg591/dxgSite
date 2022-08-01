package com.shahenpc.system.service.represent;

import java.util.List;
import com.shahenpc.system.domain.represent.RepresentDiscoverTrack;

/**
 * 【请填写功能名称】Service接口
 * 
 * @author ruoyi
 * @date 2022-07-30
 */
public interface IRepresentDiscoverTrackService 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param trackId 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public RepresentDiscoverTrack selectRepresentDiscoverTrackByTrackId(Long trackId);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param representDiscoverTrack 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<RepresentDiscoverTrack> selectRepresentDiscoverTrackList(RepresentDiscoverTrack representDiscoverTrack);

    /**
     * 新增【请填写功能名称】
     * 
     * @param representDiscoverTrack 【请填写功能名称】
     * @return 结果
     */
    public int insertRepresentDiscoverTrack(RepresentDiscoverTrack representDiscoverTrack);

    /**
     * 修改【请填写功能名称】
     * 
     * @param representDiscoverTrack 【请填写功能名称】
     * @return 结果
     */
    public int updateRepresentDiscoverTrack(RepresentDiscoverTrack representDiscoverTrack);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param trackIds 需要删除的【请填写功能名称】主键集合
     * @return 结果
     */
    public int deleteRepresentDiscoverTrackByTrackIds(Long[] trackIds);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param trackId 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteRepresentDiscoverTrackByTrackId(Long trackId);
}
