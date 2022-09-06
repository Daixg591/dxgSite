package com.shahenpc.system.mapper.oa;

import java.util.List;
import com.shahenpc.system.domain.oa.OvVoteRecord;

/**
 * 投票记录Mapper接口
 * 
 * @author ruoyi
 * @date 2022-09-05
 */
public interface OvVoteRecordMapper 
{
    /**
     * 查询投票记录
     * 
     * @param recordId 投票记录主键
     * @return 投票记录
     */
    public OvVoteRecord selectOvVoteRecordByRecordId(Long recordId);

    /**
     * 查询投票记录列表
     * 
     * @param ovVoteRecord 投票记录
     * @return 投票记录集合
     */
    public List<OvVoteRecord> selectOvVoteRecordList(OvVoteRecord ovVoteRecord);

    /**
     * 新增投票记录
     * 
     * @param ovVoteRecord 投票记录
     * @return 结果
     */
    public int insertOvVoteRecord(OvVoteRecord ovVoteRecord);

    /**
     * 修改投票记录
     * 
     * @param ovVoteRecord 投票记录
     * @return 结果
     */
    public int updateOvVoteRecord(OvVoteRecord ovVoteRecord);

    /**
     * 删除投票记录
     * 
     * @param recordId 投票记录主键
     * @return 结果
     */
    public int deleteOvVoteRecordByRecordId(Long recordId);

    /**
     * 批量删除投票记录
     * 
     * @param recordIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteOvVoteRecordByRecordIds(Long[] recordIds);
}
