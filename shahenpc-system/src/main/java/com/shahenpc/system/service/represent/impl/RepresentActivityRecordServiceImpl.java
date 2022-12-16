package com.shahenpc.system.service.represent.impl;

import java.util.List;

import com.shahenpc.common.core.domain.AjaxResult;
import com.shahenpc.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shahenpc.system.mapper.represent.RepresentActivityRecordMapper;
import com.shahenpc.system.domain.represent.RepresentActivityRecord;
import com.shahenpc.system.service.represent.IRepresentActivityRecordService;

/**
 * 代-活动记录Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-07-21
 */
@Service
public class RepresentActivityRecordServiceImpl implements IRepresentActivityRecordService 
{
    @Autowired
    private RepresentActivityRecordMapper representActivityRecordMapper;

    /**
     * 查询代-活动记录
     * 
     * @param recordId 代-活动记录主键
     * @return 代-活动记录
     */
    @Override
    public RepresentActivityRecord selectRepresentActivityRecordByRecordId(Long recordId)
    {
        return representActivityRecordMapper.selectRepresentActivityRecordByRecordId(recordId);
    }

    /**
     * 查询代-活动记录列表
     * 
     * @param representActivityRecord 代-活动记录
     * @return 代-活动记录
     */
    @Override
    public List<RepresentActivityRecord> selectRepresentActivityRecordList(RepresentActivityRecord representActivityRecord)
    {
        return representActivityRecordMapper.selectRepresentActivityRecordList(representActivityRecord);
    }

    @Override
    public RepresentActivityRecord selectRepresentActivityRecord(RepresentActivityRecord representActivityRecord) {
        return representActivityRecordMapper.selectRepresentActivityRecord(representActivityRecord);
//        return null;
    }

    /**
     * 新增代-活动记录
     * 
     * @param representActivityRecord 代-活动记录
     * @return 结果
     */
    @Override
    public int insertRepresentActivityRecord(RepresentActivityRecord representActivityRecord)
    {
        representActivityRecord.setCreateTime(DateUtils.getNowDate());
        return representActivityRecordMapper.insertRepresentActivityRecord(representActivityRecord);
    }

    /**
     * 修改代-活动记录
     * 
     * @param representActivityRecord 代-活动记录
     * @return 结果
     */
    @Override
    public int updateRepresentActivityRecord(RepresentActivityRecord representActivityRecord)
    {
        representActivityRecord.setUpdateTime(DateUtils.getNowDate());
        return representActivityRecordMapper.updateRepresentActivityRecord(representActivityRecord);
    }

    //region // old 废弃
    @Override
    public AjaxResult updateMyStatus(RepresentActivityRecord representActivityRecord) {
//        int tempStatus=representActivityRecord.getStatus();
//        representActivityRecord.setStatus(null);
//        List<RepresentActivityRecord> record =representActivityRecordMapper.selectRepresentActivityRecordList(representActivityRecord);
//
//        if(record.size() != 0){
//            representActivityRecord.setUpdateTime(DateUtils.getNowDate());
//            representActivityRecord.setStatus(tempStatus);
//            return AjaxResult.success(representActivityRecordMapper.updateMyStatus(representActivityRecord));
//        }else{
//            return AjaxResult.error("活动不存在！");
//        }
        return null;
    }
    //endregion

    /**
     * 批量删除代-活动记录
     * 
     * @param recordIds 需要删除的代-活动记录主键
     * @return 结果
     */
    @Override
    public int deleteRepresentActivityRecordByRecordIds(Long[] recordIds)
    {
        return representActivityRecordMapper.deleteRepresentActivityRecordByRecordIds(recordIds);
    }

    /**
     * 删除代-活动记录信息
     * 
     * @param recordId 代-活动记录主键
     * @return 结果
     */
    @Override
    public int deleteRepresentActivityRecordByRecordId(Long recordId)
    {
        return representActivityRecordMapper.deleteRepresentActivityRecordByRecordId(recordId);
    }
}
