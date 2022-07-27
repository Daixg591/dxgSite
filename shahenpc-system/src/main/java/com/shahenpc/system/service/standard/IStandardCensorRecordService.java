package com.shahenpc.system.service.standard;

import java.util.List;
import com.shahenpc.system.domain.standard.StandardCensorRecord;

/**
 * 审查记录统计Service接口
 * 
 * @author ruoyi
 * @date 2022-07-27
 */
public interface IStandardCensorRecordService 
{
    /**
     * 查询审查记录统计
     * 
     * @param recordId 审查记录统计主键
     * @return 审查记录统计
     */
    public StandardCensorRecord selectStandardCensorRecordByRecordId(Long recordId);

    /**
     * 查询审查记录统计列表
     * 
     * @param standardCensorRecord 审查记录统计
     * @return 审查记录统计集合
     */
    public List<StandardCensorRecord> selectStandardCensorRecordList(StandardCensorRecord standardCensorRecord);

    /**
     * 新增审查记录统计
     * 
     * @param standardCensorRecord 审查记录统计
     * @return 结果
     */
    public int insertStandardCensorRecord(StandardCensorRecord standardCensorRecord);

    /**
     * 修改审查记录统计
     * 
     * @param standardCensorRecord 审查记录统计
     * @return 结果
     */
    public int updateStandardCensorRecord(StandardCensorRecord standardCensorRecord);

    /**
     * 批量删除审查记录统计
     * 
     * @param recordIds 需要删除的审查记录统计主键集合
     * @return 结果
     */
    public int deleteStandardCensorRecordByRecordIds(Long[] recordIds);

    /**
     * 删除审查记录统计信息
     * 
     * @param recordId 审查记录统计主键
     * @return 结果
     */
    public int deleteStandardCensorRecordByRecordId(Long recordId);
}
