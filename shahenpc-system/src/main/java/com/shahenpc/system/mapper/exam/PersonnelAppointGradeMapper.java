package com.shahenpc.system.mapper.exam;

import java.util.List;
import com.shahenpc.system.domain.exam.PersonnelAppointGrade;

/**
 * 人事任免_法律知识考虑_成绩管理Mapper接口
 * 
 * @author ruoyi
 * @date 2022-07-27
 */
public interface PersonnelAppointGradeMapper 
{
    /**
     * 查询人事任免_法律知识考虑_成绩管理
     * 
     * @param gradeId 人事任免_法律知识考虑_成绩管理主键
     * @return 人事任免_法律知识考虑_成绩管理
     */
    public PersonnelAppointGrade selectPersonnelAppointGradeByGradeId(Long gradeId);

    public PersonnelAppointGrade selectGradeByRegId(Long registerId);

    /**
     * 查询人事任免_法律知识考虑_成绩管理列表
     * 
     * @param personnelAppointGrade 人事任免_法律知识考虑_成绩管理
     * @return 人事任免_法律知识考虑_成绩管理集合
     */
    public List<PersonnelAppointGrade> selectPersonnelAppointGradeList(PersonnelAppointGrade personnelAppointGrade);

    public List<PersonnelAppointGrade> adminList(PersonnelAppointGrade personnelAppointGrade);
    /**
     * 新增人事任免_法律知识考虑_成绩管理
     * 
     * @param personnelAppointGrade 人事任免_法律知识考虑_成绩管理
     * @return 结果
     */
    public int insertPersonnelAppointGrade(PersonnelAppointGrade personnelAppointGrade);

    /**
     * 修改人事任免_法律知识考虑_成绩管理
     * 
     * @param personnelAppointGrade 人事任免_法律知识考虑_成绩管理
     * @return 结果
     */
    public int updatePersonnelAppointGrade(PersonnelAppointGrade personnelAppointGrade);

    /**
     * 删除人事任免_法律知识考虑_成绩管理
     * 
     * @param gradeId 人事任免_法律知识考虑_成绩管理主键
     * @return 结果
     */
    public int deletePersonnelAppointGradeByGradeId(Long gradeId);

    /**
     * 批量删除人事任免_法律知识考虑_成绩管理
     * 
     * @param gradeIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deletePersonnelAppointGradeByGradeIds(Long[] gradeIds);
}
