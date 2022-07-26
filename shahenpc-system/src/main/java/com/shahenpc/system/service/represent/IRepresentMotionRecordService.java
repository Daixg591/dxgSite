package com.shahenpc.system.service.represent;

import java.util.List;
import com.shahenpc.system.domain.represent.RepresentMotionRecord;

/**
 * 建议议案记录Service接口
 * 
 * @author ruoyi
 * @date 2022-07-26
 */
public interface IRepresentMotionRecordService 
{
    /**
     * 查询建议议案记录
     * 
     * @param recordId 建议议案记录主键
     * @return 建议议案记录
     */
    public RepresentMotionRecord selectRepresentMotionRecordByRecordId(Long recordId);

    /**
     * 查询建议议案记录列表
     * 
     * @param representMotionRecord 建议议案记录
     * @return 建议议案记录集合
     */
    public List<RepresentMotionRecord> selectRepresentMotionRecordList(RepresentMotionRecord representMotionRecord);

    /**
     * 新增建议议案记录
     * 
     * @param representMotionRecord 建议议案记录
     * @return 结果
     */
    public int insertRepresentMotionRecord(RepresentMotionRecord representMotionRecord);

    /**
     * 修改建议议案记录
     * 
     * @param representMotionRecord 建议议案记录
     * @return 结果
     */
    public int updateRepresentMotionRecord(RepresentMotionRecord representMotionRecord);

    /**
     * 批量删除建议议案记录
     * 
     * @param recordIds 需要删除的建议议案记录主键集合
     * @return 结果
     */
    public int deleteRepresentMotionRecordByRecordIds(Long[] recordIds);

    /**
     * 删除建议议案记录信息
     * 
     * @param recordId 建议议案记录主键
     * @return 结果
     */
    public int deleteRepresentMotionRecordByRecordId(Long recordId);
}
