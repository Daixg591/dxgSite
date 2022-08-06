package com.shahenpc.system.service.exam;

import java.util.List;
import com.shahenpc.system.domain.exam.PersonnelAppointPaperBigQuestion;

/**
 * 人事任免_法律知识考试_试卷大题对应Service接口
 * 
 * @author ruoyi
 * @date 2022-07-27
 */
public interface IPersonnelAppointPaperBigQuestionService 
{
    /**
     * 查询人事任免_法律知识考试_试卷大题对应
     * 
     * @param bigQuestionId 人事任免_法律知识考试_试卷大题对应主键
     * @return 人事任免_法律知识考试_试卷大题对应
     */
    public PersonnelAppointPaperBigQuestion selectPersonnelAppointPaperBigQuestionByBigQuestionId(Long bigQuestionId);

    /**
     * 查询人事任免_法律知识考试_试卷大题对应列表
     * 
     * @param personnelAppointPaperBigQuestion 人事任免_法律知识考试_试卷大题对应
     * @return 人事任免_法律知识考试_试卷大题对应集合
     */
    public List<PersonnelAppointPaperBigQuestion> selectPersonnelAppointPaperBigQuestionList(PersonnelAppointPaperBigQuestion personnelAppointPaperBigQuestion);

    /**
     * 新增人事任免_法律知识考试_试卷大题对应
     * 
     * @param personnelAppointPaperBigQuestion 人事任免_法律知识考试_试卷大题对应
     * @return 结果
     */
    public int insertPersonnelAppointPaperBigQuestion(PersonnelAppointPaperBigQuestion personnelAppointPaperBigQuestion);

    /**
     * 修改人事任免_法律知识考试_试卷大题对应
     * 
     * @param personnelAppointPaperBigQuestion 人事任免_法律知识考试_试卷大题对应
     * @return 结果
     */
    public int updatePersonnelAppointPaperBigQuestion(PersonnelAppointPaperBigQuestion personnelAppointPaperBigQuestion);

    /**
     * 批量删除人事任免_法律知识考试_试卷大题对应
     * 
     * @param bigQuestionIds 需要删除的人事任免_法律知识考试_试卷大题对应主键集合
     * @return 结果
     */
    public int deletePersonnelAppointPaperBigQuestionByBigQuestionIds(Long[] bigQuestionIds);

    /**
     * 删除人事任免_法律知识考试_试卷大题对应信息
     * 
     * @param bigQuestionId 人事任免_法律知识考试_试卷大题对应主键
     * @return 结果
     */
    public int deletePersonnelAppointPaperBigQuestionByBigQuestionId(Long bigQuestionId);
}
