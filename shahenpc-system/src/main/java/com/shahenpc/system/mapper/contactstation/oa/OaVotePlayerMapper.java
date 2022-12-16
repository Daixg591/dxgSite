package com.shahenpc.system.mapper.contactstation.oa;

import java.util.List;
import com.shahenpc.system.domain.oa.OaVotePlayer;

/**
 * 投票选手Mapper接口
 * 
 * @author ruoyi
 * @date 2022-07-19
 */
public interface OaVotePlayerMapper 
{
    /**
     * 查询投票选手
     * 
     * @param playerId 投票选手主键
     * @return 投票选手
     */
    public OaVotePlayer selectOaVotePlayerByPlayerId(Long playerId);

    /**
     * 查询投票选手列表
     * 
     * @param oaVotePlayer 投票选手
     * @return 投票选手集合
     */
    public List<OaVotePlayer> selectOaVotePlayerList(OaVotePlayer oaVotePlayer);

    /**
     * 新增投票选手
     * 
     * @param oaVotePlayer 投票选手
     * @return 结果
     */
    public int insertOaVotePlayer(OaVotePlayer oaVotePlayer);

    /**
     * 修改投票选手
     * 
     * @param oaVotePlayer 投票选手
     * @return 结果
     */
    public int updateOaVotePlayer(OaVotePlayer oaVotePlayer);

    /**
     * 删除投票选手
     * 
     * @param playerId 投票选手主键
     * @return 结果
     */
    public int deleteOaVotePlayerByPlayerId(Long playerId);

    /**
     * 批量删除投票选手
     * 
     * @param playerIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteOaVotePlayerByPlayerIds(Long[] playerIds);
}
