package com.shahenpc.system.mapper.exam;

import java.util.List;
import com.shahenpc.system.domain.exam.PersonnelAppointExam;

/**
 * 人事任免_法律知识考试_考试管理Mapper接口
 * 
 * @author ruoyi
 * @date 2022-07-27
 */
public interface PersonnelAppointExamMapper 
{
    /**
     * 查询人事任免_法律知识考试_考试管理
     * 
     * @param examId 人事任免_法律知识考试_考试管理主键
     * @return 人事任免_法律知识考试_考试管理
     */
    public PersonnelAppointExam selectPersonnelAppointExamByExamId(Long examId);

    /**
     * 查询人事任免_法律知识考试_考试管理列表
     * 
     * @param personnelAppointExam 人事任免_法律知识考试_考试管理
     * @return 人事任免_法律知识考试_考试管理集合
     */
    public List<PersonnelAppointExam> selectPersonnelAppointExamList(PersonnelAppointExam personnelAppointExam);

    /**
     * 新增人事任免_法律知识考试_考试管理
     * 
     * @param personnelAppointExam 人事任免_法律知识考试_考试管理
     * @return 结果
     */
    public int insertPersonnelAppointExam(PersonnelAppointExam personnelAppointExam);

    /**
     * 修改人事任免_法律知识考试_考试管理
     * 
     * @param personnelAppointExam 人事任免_法律知识考试_考试管理
     * @return 结果
     */
    public int updatePersonnelAppointExam(PersonnelAppointExam personnelAppointExam);

    /**
     * 删除人事任免_法律知识考试_考试管理
     * 
     * @param examId 人事任免_法律知识考试_考试管理主键
     * @return 结果
     */
    public int deletePersonnelAppointExamByExamId(Long examId);

    /**
     * 批量删除人事任免_法律知识考试_考试管理
     * 
     * @param examIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deletePersonnelAppointExamByExamIds(Long[] examIds);
}
