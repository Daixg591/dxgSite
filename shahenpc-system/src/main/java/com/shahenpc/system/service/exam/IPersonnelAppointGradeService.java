package com.shahenpc.system.service.exam;

import java.util.List;
import com.shahenpc.system.domain.exam.PersonnelAppointGrade;

/**
 * 人事任免_法律知识考虑_成绩管理Service接口
 * 
 * @author ruoyi
 * @date 2022-07-27
 */
public interface IPersonnelAppointGradeService 
{
    /**
     * 查询人事任免_法律知识考虑_成绩管理
     * 
     * @param gradeId 人事任免_法律知识考虑_成绩管理主键
     * @return 人事任免_法律知识考虑_成绩管理
     */
    public PersonnelAppointGrade selectPersonnelAppointGradeByGradeId(Long gradeId);

    /**
     * 查询人事任免_法律知识考虑_成绩管理列表
     * 
     * @param personnelAppointGrade 人事任免_法律知识考虑_成绩管理
     * @return 人事任免_法律知识考虑_成绩管理集合
     */
    public List<PersonnelAppointGrade> selectPersonnelAppointGradeList(PersonnelAppointGrade personnelAppointGrade);

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
     * 批量删除人事任免_法律知识考虑_成绩管理
     * 
     * @param gradeIds 需要删除的人事任免_法律知识考虑_成绩管理主键集合
     * @return 结果
     */
    public int deletePersonnelAppointGradeByGradeIds(Long[] gradeIds);

    /**
     * 删除人事任免_法律知识考虑_成绩管理信息
     * 
     * @param gradeId 人事任免_法律知识考虑_成绩管理主键
     * @return 结果
     */
    public int deletePersonnelAppointGradeByGradeId(Long gradeId);
}
