package com.shahenpc.system.service.represent.impl;

import java.util.List;
import com.shahenpc.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shahenpc.system.mapper.represent.RepresentDiscoverTrackMapper;
import com.shahenpc.system.domain.represent.RepresentDiscoverTrack;
import com.shahenpc.system.service.represent.IRepresentDiscoverTrackService;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-07-30
 */
@Service
public class RepresentDiscoverTrackServiceImpl implements IRepresentDiscoverTrackService 
{
    @Autowired
    private RepresentDiscoverTrackMapper representDiscoverTrackMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param trackId 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public RepresentDiscoverTrack selectRepresentDiscoverTrackByTrackId(Long trackId)
    {
        return representDiscoverTrackMapper.selectRepresentDiscoverTrackByTrackId(trackId);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param representDiscoverTrack 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<RepresentDiscoverTrack> selectRepresentDiscoverTrackList(RepresentDiscoverTrack representDiscoverTrack)
    {
        return representDiscoverTrackMapper.selectRepresentDiscoverTrackList(representDiscoverTrack);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param representDiscoverTrack 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertRepresentDiscoverTrack(RepresentDiscoverTrack representDiscoverTrack)
    {
        representDiscoverTrack.setCreateTime(DateUtils.getNowDate());
        return representDiscoverTrackMapper.insertRepresentDiscoverTrack(representDiscoverTrack);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param representDiscoverTrack 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateRepresentDiscoverTrack(RepresentDiscoverTrack representDiscoverTrack)
    {
        representDiscoverTrack.setUpdateTime(DateUtils.getNowDate());
        return representDiscoverTrackMapper.updateRepresentDiscoverTrack(representDiscoverTrack);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param trackIds 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteRepresentDiscoverTrackByTrackIds(Long[] trackIds)
    {
        return representDiscoverTrackMapper.deleteRepresentDiscoverTrackByTrackIds(trackIds);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param trackId 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteRepresentDiscoverTrackByTrackId(Long trackId)
    {
        return representDiscoverTrackMapper.deleteRepresentDiscoverTrackByTrackId(trackId);
    }
}
