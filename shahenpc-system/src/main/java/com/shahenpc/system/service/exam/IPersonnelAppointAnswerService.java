package com.shahenpc.system.service.exam;

import java.util.List;
import com.shahenpc.system.domain.exam.PersonnelAppointAnswer;

/**
 * 人事任免_法律知识考试_答案管理Service接口
 * 
 * @author ruoyi
 * @date 2022-07-27
 */
public interface IPersonnelAppointAnswerService 
{
    /**
     * 查询人事任免_法律知识考试_答案管理
     * 
     * @param answerId 人事任免_法律知识考试_答案管理主键
     * @return 人事任免_法律知识考试_答案管理
     */
    public PersonnelAppointAnswer selectPersonnelAppointAnswerByAnswerId(Long answerId);

    /**
     * 查询人事任免_法律知识考试_答案管理列表
     * 
     * @param personnelAppointAnswer 人事任免_法律知识考试_答案管理
     * @return 人事任免_法律知识考试_答案管理集合
     */
    public List<PersonnelAppointAnswer> selectPersonnelAppointAnswerList(PersonnelAppointAnswer personnelAppointAnswer);

    /**
     * 新增人事任免_法律知识考试_答案管理
     * 
     * @param personnelAppointAnswer 人事任免_法律知识考试_答案管理
     * @return 结果
     */
    public int insertPersonnelAppointAnswer(PersonnelAppointAnswer personnelAppointAnswer);

    /**
     * 修改人事任免_法律知识考试_答案管理
     * 
     * @param personnelAppointAnswer 人事任免_法律知识考试_答案管理
     * @return 结果
     */
    public int updatePersonnelAppointAnswer(PersonnelAppointAnswer personnelAppointAnswer);

    /**
     * 批量删除人事任免_法律知识考试_答案管理
     * 
     * @param answerIds 需要删除的人事任免_法律知识考试_答案管理主键集合
     * @return 结果
     */
    public int deletePersonnelAppointAnswerByAnswerIds(Long[] answerIds);

    /**
     * 删除人事任免_法律知识考试_答案管理信息
     * 
     * @param answerId 人事任免_法律知识考试_答案管理主键
     * @return 结果
     */
    public int deletePersonnelAppointAnswerByAnswerId(Long answerId);
}
