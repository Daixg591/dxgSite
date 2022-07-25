package com.shahenpc.system.mapper.oa;

import java.util.List;
import com.shahenpc.system.domain.oa.OaVote;

/**
 * 投票窗口Mapper接口
 * 
 * @author ruoyi
 * @date 2022-07-19
 */
public interface OaVoteMapper 
{
    /**
     * 查询投票窗口
     * 
     * @param voteId 投票窗口主键
     * @return 投票窗口
     */
    public OaVote selectOaVoteByVoteId(Long voteId);

    /**
     * 查询投票窗口列表
     * 
     * @param oaVote 投票窗口
     * @return 投票窗口集合
     */
    public List<OaVote> selectOaVoteList(OaVote oaVote);

    /**
     * 新增投票窗口
     * 
     * @param oaVote 投票窗口
     * @return 结果
     */
    public int insertOaVote(OaVote oaVote);

    /**
     * 修改投票窗口
     * 
     * @param oaVote 投票窗口
     * @return 结果
     */
    public int updateOaVote(OaVote oaVote);

    /**
     * 删除投票窗口
     * 
     * @param voteId 投票窗口主键
     * @return 结果
     */
    public int deleteOaVoteByVoteId(Long voteId);

    /**
     * 批量删除投票窗口
     * 
     * @param voteIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteOaVoteByVoteIds(Long[] voteIds);
}
