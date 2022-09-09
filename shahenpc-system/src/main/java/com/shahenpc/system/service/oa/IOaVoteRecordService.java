package com.shahenpc.system.service.oa;

import java.util.List;

import com.shahenpc.common.core.domain.AjaxResult;
import com.shahenpc.system.domain.oa.OaVoteRecord;
import com.shahenpc.system.domain.oa.vo.VoteRecordVo;

/**
 * 投票记录Service接口
 * 
 * @author ruoyi
 * @date 2022-09-05
 */
public interface IOaVoteRecordService
{
    /**
     * 查询投票记录
     * 
     * @param recordId 投票记录主键
     * @return 投票记录
     */
    public OaVoteRecord selectOvVoteRecordByRecordId(Long recordId);

    /**
     * 查询投票记录列表
     * 
     * @param ovVoteRecord 投票记录
     * @return 投票记录集合
     */
    public List<OaVoteRecord> selectOvVoteRecordList(OaVoteRecord ovVoteRecord);

    /**
     * 新增投票记录
     * 
     * @param ovVoteRecord 投票记录
     * @return 结果
     */
    public int insertOvVoteRecord(OaVoteRecord ovVoteRecord);

    /**
     * 投票记录
     * @return
     */
    public AjaxResult insertPlayerIds(VoteRecordVo requst);
    /**
     * 修改投票记录
     * 
     * @param ovVoteRecord 投票记录
     * @return 结果
     */
    public int updateOvVoteRecord(OaVoteRecord ovVoteRecord);

    /**
     * 批量删除投票记录
     * 
     * @param recordIds 需要删除的投票记录主键集合
     * @return 结果
     */
    public int deleteOvVoteRecordByRecordIds(Long[] recordIds);

    /**
     * 删除投票记录信息
     * 
     * @param recordId 投票记录主键
     * @return 结果
     */
    public int deleteOvVoteRecordByRecordId(Long recordId);
}
