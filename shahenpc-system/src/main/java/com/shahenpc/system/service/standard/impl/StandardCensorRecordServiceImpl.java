package com.shahenpc.system.service.standard.impl;

import java.util.List;
import com.shahenpc.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shahenpc.system.mapper.standard.StandardCensorRecordMapper;
import com.shahenpc.system.domain.standard.StandardCensorRecord;
import com.shahenpc.system.service.standard.IStandardCensorRecordService;

/**
 * 审查记录统计Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-07-27
 */
@Service
public class StandardCensorRecordServiceImpl implements IStandardCensorRecordService 
{
    @Autowired
    private StandardCensorRecordMapper standardCensorRecordMapper;

    /**
     * 查询审查记录统计
     * 
     * @param recordId 审查记录统计主键
     * @return 审查记录统计
     */
    @Override
    public StandardCensorRecord selectStandardCensorRecordByRecordId(Long recordId)
    {
        return standardCensorRecordMapper.selectStandardCensorRecordByRecordId(recordId);
    }

    /**
     * 查询审查记录统计列表
     * 
     * @param standardCensorRecord 审查记录统计
     * @return 审查记录统计
     */
    @Override
    public List<StandardCensorRecord> selectStandardCensorRecordList(StandardCensorRecord standardCensorRecord)
    {
        return standardCensorRecordMapper.selectStandardCensorRecordList(standardCensorRecord);
    }

    /**
     * 新增审查记录统计
     * 
     * @param standardCensorRecord 审查记录统计
     * @return 结果
     */
    @Override
    public int insertStandardCensorRecord(StandardCensorRecord standardCensorRecord)
    {
        standardCensorRecord.setCreateTime(DateUtils.getNowDate());
        return standardCensorRecordMapper.insertStandardCensorRecord(standardCensorRecord);
    }

    /**
     * 修改审查记录统计
     * 
     * @param standardCensorRecord 审查记录统计
     * @return 结果
     */
    @Override
    public int updateStandardCensorRecord(StandardCensorRecord standardCensorRecord)
    {
        return standardCensorRecordMapper.updateStandardCensorRecord(standardCensorRecord);
    }

    /**
     * 批量删除审查记录统计
     * 
     * @param recordIds 需要删除的审查记录统计主键
     * @return 结果
     */
    @Override
    public int deleteStandardCensorRecordByRecordIds(Long[] recordIds)
    {
        return standardCensorRecordMapper.deleteStandardCensorRecordByRecordIds(recordIds);
    }

    /**
     * 删除审查记录统计信息
     * 
     * @param recordId 审查记录统计主键
     * @return 结果
     */
    @Override
    public int deleteStandardCensorRecordByRecordId(Long recordId)
    {
        return standardCensorRecordMapper.deleteStandardCensorRecordByRecordId(recordId);
    }
}
