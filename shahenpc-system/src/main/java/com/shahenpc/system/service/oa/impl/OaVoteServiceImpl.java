package com.shahenpc.system.service.oa.impl;

import java.util.List;

import com.shahenpc.common.core.controller.BaseController;
import com.shahenpc.common.utils.DateUtils;
import com.shahenpc.system.domain.oa.OaVotePlayer;
import com.shahenpc.system.domain.oa.dto.VoteCount;
import com.shahenpc.system.mapper.oa.OaVotePlayerMapper;
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
public class OaVoteServiceImpl extends BaseController implements IOaVoteService
{
    @Autowired
    private OaVoteMapper oaVoteMapper;
    @Autowired
    private OaVotePlayerMapper oaVotePlayerMapper;
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
        List<OaVote>  list= oaVoteMapper.selectOaVoteList(oaVote);
        for (OaVote item: list){
            Long star= item.getStartTime().getTime();
            Long dang = DateUtils.getNowDate().getTime();
            Long end = item.getEndTime().getTime();
            if(dang < star){
                item.setStatus(0);
            }else if(dang >= star && dang <= end){
                item.setStatus(1);
            }else if(end< dang){
                item.setStatus(2);
            }
            OaVotePlayer pl = new OaVotePlayer();
            pl.setVoteId(item.getVoteId());
            item.setVoter(oaVotePlayerMapper.selectOaVotePlayerList(pl).size());
            oaVoteMapper.updateOaVote(item);
        }
        startPage();
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
        Long dang = oaVote.getCreateTime().getTime();
        Long end =  oaVote.getEndTime().getTime();
        Long star  = oaVote.getStartTime().getTime();
        if(dang < star){
            oaVote.setStatus(0);
        }else if(dang >= star && dang <= end){
            oaVote.setStatus(1);
        }else if(end< dang){
            oaVote.setStatus(2);
        }
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
        Long dang = DateUtils.getNowDate().getTime();
        Long end =  oaVote.getEndTime().getTime();
        Long star  = oaVote.getStartTime().getTime();
        if(dang < star){
            oaVote.setStatus(0);
        }else if(dang >= star && dang <= end){
            oaVote.setStatus(1);
        }else if(end< dang){
            oaVote.setStatus(2);
        }
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

    @Override
    public VoteCount selectByCount() {
        return oaVoteMapper.selectCount();
    }
}
