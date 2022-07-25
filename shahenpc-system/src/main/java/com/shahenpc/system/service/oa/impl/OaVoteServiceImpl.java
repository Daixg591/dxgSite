package com.shahenpc.system.service.oa.impl;

import java.util.List;
import com.shahenpc.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shahenpc.system.mapper.oa.OaVoteMapper;
import com.shahenpc.system.domain.oa.OaVote;
import com.shahenpc.system.service.oa.IOaVoteService;

/**
 * 投票窗口Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-07-19
 */
@Service
public class OaVoteServiceImpl implements IOaVoteService 
{
    @Autowired
    private OaVoteMapper oaVoteMapper;

    /**
     * 查询投票窗口
     * 
     * @param voteId 投票窗口主键
     * @return 投票窗口
     */
    @Override
    public OaVote selectOaVoteByVoteId(Long voteId)
    {
        return oaVoteMapper.selectOaVoteByVoteId(voteId);
    }

    /**
     * 查询投票窗口列表
     * 
     * @param oaVote 投票窗口
     * @return 投票窗口
     */
    @Override
    public List<OaVote> selectOaVoteList(OaVote oaVote)
    {
        return oaVoteMapper.selectOaVoteList(oaVote);
    }

    /**
     * 新增投票窗口
     * 
     * @param oaVote 投票窗口
     * @return 结果
     */
    @Override
    public int insertOaVote(OaVote oaVote)
    {
        oaVote.setCreateTime(DateUtils.getNowDate());
        return oaVoteMapper.insertOaVote(oaVote);
    }

    /**
     * 修改投票窗口
     * 
     * @param oaVote 投票窗口
     * @return 结果
     */
    @Override
    public int updateOaVote(OaVote oaVote)
    {
        oaVote.setUpdateTime(DateUtils.getNowDate());
        return oaVoteMapper.updateOaVote(oaVote);
    }

    /**
     * 批量删除投票窗口
     * 
     * @param voteIds 需要删除的投票窗口主键
     * @return 结果
     */
    @Override
    public int deleteOaVoteByVoteIds(Long[] voteIds)
    {
        return oaVoteMapper.deleteOaVoteByVoteIds(voteIds);
    }

    /**
     * 删除投票窗口信息
     * 
     * @param voteId 投票窗口主键
     * @return 结果
     */
    @Override
    public int deleteOaVoteByVoteId(Long voteId)
    {
        return oaVoteMapper.deleteOaVoteByVoteId(voteId);
    }
}
