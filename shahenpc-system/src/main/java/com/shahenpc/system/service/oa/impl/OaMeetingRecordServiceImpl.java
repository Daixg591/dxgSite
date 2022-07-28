package com.shahenpc.system.service.oa.impl;

import java.util.List;
import com.shahenpc.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shahenpc.system.mapper.oa.OaMeetingRecordMapper;
import com.shahenpc.system.domain.oa.OaMeetingRecord;
import com.shahenpc.system.service.oa.IOaMeetingRecordService;

/**
 * 会议记录Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-07-19
 */
@Service
public class OaMeetingRecordServiceImpl implements IOaMeetingRecordService 
{
    @Autowired
    private OaMeetingRecordMapper oaMeetingRecordMapper;

    /**
     * 查询会议记录
     * 
     * @param recordId 会议记录主键
     * @return 会议记录
     */
    @Override
    public OaMeetingRecord selectOaMeetingRecordByRecordId(Long recordId)
    {
        return oaMeetingRecordMapper.selectOaMeetingRecordByRecordId(recordId);
    }

    /**
     * 查询会议记录列表
     * 
     * @param oaMeetingRecord 会议记录
     * @return 会议记录
     */
    @Override
    public List<OaMeetingRecord> selectOaMeetingRecordList(OaMeetingRecord oaMeetingRecord)
    {
        return oaMeetingRecordMapper.selectOaMeetingRecordList(oaMeetingRecord);
    }

    /**
     * 新增会议记录
     * 
     * @param oaMeetingRecord 会议记录
     * @return 结果
     */
    @Override
    public int insertOaMeetingRecord(OaMeetingRecord oaMeetingRecord)
    {
        oaMeetingRecord.setCreateTime(DateUtils.getNowDate());
        return oaMeetingRecordMapper.insertOaMeetingRecord(oaMeetingRecord);
    }

    /**
     * 修改会议记录
     * 
     * @param oaMeetingRecord 会议记录
     * @return 结果
     */
    @Override
    public int updateOaMeetingRecord(OaMeetingRecord oaMeetingRecord)
    {
        oaMeetingRecord.setUpdateTime(DateUtils.getNowDate());
        return oaMeetingRecordMapper.updateOaMeetingRecord(oaMeetingRecord);
    }

    /**
     * 批量删除会议记录
     * 
     * @param recordIds 需要删除的会议记录主键
     * @return 结果
     */
    @Override
    public int deleteOaMeetingRecordByRecordIds(Long[] recordIds)
    {
        return oaMeetingRecordMapper.deleteOaMeetingRecordByRecordIds(recordIds);
    }

    /**
     * 删除会议记录信息
     * 
     * @param recordId 会议记录主键
     * @return 结果
     */
    @Override
    public int deleteOaMeetingRecordByRecordId(Long recordId)
    {
        return oaMeetingRecordMapper.deleteOaMeetingRecordByRecordId(recordId);
    }
}