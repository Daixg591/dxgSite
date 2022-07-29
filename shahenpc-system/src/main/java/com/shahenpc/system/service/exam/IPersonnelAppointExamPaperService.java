package com.shahenpc.system.service.exam;

import java.util.List;
import com.shahenpc.system.domain.exam.PersonnelAppointExamPaper;

/**
 * 人事任免_法律知识考虑_试卷管理Service接口
 * 
 * @author ruoyi
 * @date 2022-07-27
 */
public interface IPersonnelAppointExamPaperService 
{
    /**
     * 查询人事任免_法律知识考虑_试卷管理
     * 
     * @param examPaperId 人事任免_法律知识考虑_试卷管理主键
     * @return 人事任免_法律知识考虑_试卷管理
     */
    public PersonnelAppointExamPaper selectPersonnelAppointExamPaperByExamPaperId(Long examPaperId);

    /**
     * 查询人事任免_法律知识考虑_试卷管理列表
     * 
     * @param personnelAppointExamPaper 人事任免_法律知识考虑_试卷管理
     * @return 人事任免_法律知识考虑_试卷管理集合
     */
    public List<PersonnelAppointExamPaper> selectPersonnelAppointExamPaperList(PersonnelAppointExamPaper personnelAppointExamPaper);

    /**
     * 新增人事任免_法律知识考虑_试卷管理
     * 
     * @param personnelAppointExamPaper 人事任免_法律知识考虑_试卷管理
     * @return 结果
     */
    public int insertPersonnelAppointExamPaper(PersonnelAppointExamPaper personnelAppointExamPaper);

    /**
     * 修改人事任免_法律知识考虑_试卷管理
     * 
     * @param personnelAppointExamPaper 人事任免_法律知识考虑_试卷管理
     * @return 结果
     */
    public int updatePersonnelAppointExamPaper(PersonnelAppointExamPaper personnelAppointExamPaper);

    /**
     * 批量删除人事任免_法律知识考虑_试卷管理
     * 
     * @param examPaperIds 需要删除的人事任免_法律知识考虑_试卷管理主键集合
     * @return 结果
     */
    public int deletePersonnelAppointExamPaperByExamPaperIds(Long[] examPaperIds);

    /**
     * 删除人事任免_法律知识考虑_试卷管理信息
     * 
     * @param examPaperId 人事任免_法律知识考虑_试卷管理主键
     * @return 结果
     */
    public int deletePersonnelAppointExamPaperByExamPaperId(Long examPaperId);
}
