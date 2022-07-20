package com.shahenpc.system.service.oa.impl;

import java.util.List;
import com.shahenpc.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shahenpc.system.mapper.oa.OaVotePlayerMapper;
import com.shahenpc.system.domain.oa.OaVotePlayer;
import com.shahenpc.system.service.oa.IOaVotePlayerService;

/**
 * 投票选手Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-07-19
 */
@Service
public class OaVotePlayerServiceImpl implements IOaVotePlayerService 
{
    @Autowired
    private OaVotePlayerMapper oaVotePlayerMapper;

    /**
     * 查询投票选手
     * 
     * @param playerId 投票选手主键
     * @return 投票选手
     */
    @Override
    public OaVotePlayer selectOaVotePlayerByPlayerId(Long playerId)
    {
        return oaVotePlayerMapper.selectOaVotePlayerByPlayerId(playerId);
    }

    /**
     * 查询投票选手列表
     * 
     * @param oaVotePlayer 投票选手
     * @return 投票选手
     */
    @Override
    public List<OaVotePlayer> selectOaVotePlayerList(OaVotePlayer oaVotePlayer)
    {
        return oaVotePlayerMapper.selectOaVotePlayerList(oaVotePlayer);
    }

    /**
     * 新增投票选手
     * 
     * @param oaVotePlayer 投票选手
     * @return 结果
     */
    @Override
    public int insertOaVotePlayer(OaVotePlayer oaVotePlayer)
    {
        oaVotePlayer.setCreateTime(DateUtils.getNowDate());
        return oaVotePlayerMapper.insertOaVotePlayer(oaVotePlayer);
    }

    /**
     * 修改投票选手
     * 
     * @param oaVotePlayer 投票选手
     * @return 结果
     */
    @Override
    public int updateOaVotePlayer(OaVotePlayer oaVotePlayer)
    {
        oaVotePlayer.setUpdateTime(DateUtils.getNowDate());
        return oaVotePlayerMapper.updateOaVotePlayer(oaVotePlayer);
    }

    /**
     * 批量删除投票选手
     * 
     * @param playerIds 需要删除的投票选手主键
     * @return 结果
     */
    @Override
    public int deleteOaVotePlayerByPlayerIds(Long[] playerIds)
    {
        return oaVotePlayerMapper.deleteOaVotePlayerByPlayerIds(playerIds);
    }

    /**
     * 删除投票选手信息
     * 
     * @param playerId 投票选手主键
     * @return 结果
     */
    @Override
    public int deleteOaVotePlayerByPlayerId(Long playerId)
    {
        return oaVotePlayerMapper.deleteOaVotePlayerByPlayerId(playerId);
    }
}
