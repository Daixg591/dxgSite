package com.shahenpc.system.mapper.exam;

import java.util.List;
import com.shahenpc.system.domain.exam.PersonnelAppointBillExamRelation;

/**
 * 任免记录考试关联Mapper接口
 * 
 * @author ruoyi
 * @date 2022-08-02
 */
public interface PersonnelAppointBillExamRelationMapper 
{
    /**
     * 查询任免记录考试关联
     * 
     * @param regExamId 任免记录考试关联主键
     * @return 任免记录考试关联
     */
    public PersonnelAppointBillExamRelation selectPersonnelAppointBillExamRelationByRegExamId(Long regExamId);

    /**
     * 查询任免记录考试关联列表
     * 
     * @param personnelAppointBillExamRelation 任免记录考试关联
     * @return 任免记录考试关联集合
     */
    public List<PersonnelAppointBillExamRelation> selectPersonnelAppointBillExamRelationList(PersonnelAppointBillExamRelation personnelAppointBillExamRelation);

    /**
     * 新增任免记录考试关联
     * 
     * @param personnelAppointBillExamRelation 任免记录考试关联
     * @return 结果
     */
    public int insertPersonnelAppointBillExamRelation(PersonnelAppointBillExamRelation personnelAppointBillExamRelation);

    /**
     * 修改任免记录考试关联
     * 
     * @param personnelAppointBillExamRelation 任免记录考试关联
     * @return 结果
     */
    public int updatePersonnelAppointBillExamRelation(PersonnelAppointBillExamRelation personnelAppointBillExamRelation);

    /**
     * 删除任免记录考试关联
     * 
     * @param regExamId 任免记录考试关联主键
     * @return 结果
     */
    public int deletePersonnelAppointBillExamRelationByRegExamId(Long regExamId);

    /**
     * 批量删除任免记录考试关联
     * 
     * @param regExamIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deletePersonnelAppointBillExamRelationByRegExamIds(Long[] regExamIds);
}