package com.shahenpc.system.service.impl.exam;

import java.util.List;
import com.shahenpc.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shahenpc.system.mapper.exam.PersonnelAppointBillExamRelationMapper;
import com.shahenpc.system.domain.exam.PersonnelAppointBillExamRelation;
import com.shahenpc.system.service.exam.IPersonnelAppointBillExamRelationService;

/**
 * 任免记录考试关联Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-08-02
 */
@Service
public class PersonnelAppointBillExamRelationServiceImpl implements IPersonnelAppointBillExamRelationService 
{
    @Autowired
    private PersonnelAppointBillExamRelationMapper personnelAppointBillExamRelationMapper;

    /**
     * 查询任免记录考试关联
     * 
     * @param regExamId 任免记录考试关联主键
     * @return 任免记录考试关联
     */
    @Override
    public PersonnelAppointBillExamRelation selectPersonnelAppointBillExamRelationByRegExamId(Long regExamId)
    {
        return personnelAppointBillExamRelationMapper.selectPersonnelAppointBillExamRelationByRegExamId(regExamId);
    }

    /**
     * 查询任免记录考试关联列表
     * 
     * @param personnelAppointBillExamRelation 任免记录考试关联
     * @return 任免记录考试关联
     */
    @Override
    public List<PersonnelAppointBillExamRelation> selectPersonnelAppointBillExamRelationList(PersonnelAppointBillExamRelation personnelAppointBillExamRelation)
    {
        return personnelAppointBillExamRelationMapper.selectPersonnelAppointBillExamRelationList(personnelAppointBillExamRelation);
    }

    /**
     * 新增任免记录考试关联
     * 
     * @param personnelAppointBillExamRelation 任免记录考试关联
     * @return 结果
     */
    @Override
    public int insertPersonnelAppointBillExamRelation(PersonnelAppointBillExamRelation personnelAppointBillExamRelation)
    {
        personnelAppointBillExamRelation.setCreateTime(DateUtils.getNowDate());
        return personnelAppointBillExamRelationMapper.insertPersonnelAppointBillExamRelation(personnelAppointBillExamRelation);
    }

    /**
     * 修改任免记录考试关联
     * 
     * @param personnelAppointBillExamRelation 任免记录考试关联
     * @return 结果
     */
    @Override
    public int updatePersonnelAppointBillExamRelation(PersonnelAppointBillExamRelation personnelAppointBillExamRelation)
    {
        personnelAppointBillExamRelation.setUpdateTime(DateUtils.getNowDate());
        return personnelAppointBillExamRelationMapper.updatePersonnelAppointBillExamRelation(personnelAppointBillExamRelation);
    }

    /**
     * 批量删除任免记录考试关联
     * 
     * @param regExamIds 需要删除的任免记录考试关联主键
     * @return 结果
     */
    @Override
    public int deletePersonnelAppointBillExamRelationByRegExamIds(Long[] regExamIds)
    {
        return personnelAppointBillExamRelationMapper.deletePersonnelAppointBillExamRelationByRegExamIds(regExamIds);
    }

    /**
     * 删除任免记录考试关联信息
     * 
     * @param regExamId 任免记录考试关联主键
     * @return 结果
     */
    @Override
    public int deletePersonnelAppointBillExamRelationByRegExamId(Long regExamId)
    {
        return personnelAppointBillExamRelationMapper.deletePersonnelAppointBillExamRelationByRegExamId(regExamId);
    }
}
