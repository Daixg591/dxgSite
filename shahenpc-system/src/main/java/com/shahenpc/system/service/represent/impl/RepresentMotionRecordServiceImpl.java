package com.shahenpc.system.service.represent.impl;

import java.util.List;
import com.shahenpc.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shahenpc.system.mapper.represent.RepresentMotionRecordMapper;
import com.shahenpc.system.domain.represent.RepresentMotionRecord;
import com.shahenpc.system.service.represent.IRepresentMotionRecordService;

/**
 * 建议议案记录Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-07-26
 */
@Service
public class RepresentMotionRecordServiceImpl implements IRepresentMotionRecordService 
{
    @Autowired
    private RepresentMotionRecordMapper representMotionRecordMapper;

    /**
     * 查询建议议案记录
     * 
     * @param recordId 建议议案记录主键
     * @return 建议议案记录
     */
    @Override
    public RepresentMotionRecord selectRepresentMotionRecordByRecordId(Long recordId)
    {
        return representMotionRecordMapper.selectRepresentMotionRecordByRecordId(recordId);
    }

    /**
     * 查询建议议案记录列表
     * 
     * @param representMotionRecord 建议议案记录
     * @return 建议议案记录
     */
    @Override
    public List<RepresentMotionRecord> selectRepresentMotionRecordList(RepresentMotionRecord representMotionRecord)
    {
        return representMotionRecordMapper.selectRepresentMotionRecordList(representMotionRecord);
    }

    /**
     * 新增建议议案记录
     * 
     * @param representMotionRecord 建议议案记录
     * @return 结果
     */
    @Override
    public int insertRepresentMotionRecord(RepresentMotionRecord representMotionRecord)
    {
        representMotionRecord.setCreateTime(DateUtils.getNowDate());
        return representMotionRecordMapper.insertRepresentMotionRecord(representMotionRecord);
    }

    /**
     * 修改建议议案记录
     * 
     * @param representMotionRecord 建议议案记录
     * @return 结果
     */
    @Override
    public int updateRepresentMotionRecord(RepresentMotionRecord representMotionRecord)
    {
        return representMotionRecordMapper.updateRepresentMotionRecord(representMotionRecord);
    }

    /**
     * 批量删除建议议案记录
     * 
     * @param recordIds 需要删除的建议议案记录主键
     * @return 结果
     */
    @Override
    public int deleteRepresentMotionRecordByRecordIds(Long[] recordIds)
    {
        return representMotionRecordMapper.deleteRepresentMotionRecordByRecordIds(recordIds);
    }

    /**
     * 删除建议议案记录信息
     * 
     * @param recordId 建议议案记录主键
     * @return 结果
     */
    @Override
    public int deleteRepresentMotionRecordByRecordId(Long recordId)
    {
        return representMotionRecordMapper.deleteRepresentMotionRecordByRecordId(recordId);
    }
}
