package com.shahenpc.system.service.exam;

import java.util.List;
import com.shahenpc.system.domain.exam.PersonnelAppointQuestion;
import com.shahenpc.system.domain.exam.dto.RandomQuDto;

/**
 * 人事任免_法律知识考试_试题管理Service接口
 * 
 * @author ruoyi
 * @date 2022-07-27
 */
public interface IPersonnelAppointQuestionService 
{
    /**
     * 查询人事任免_法律知识考试_试题管理
     * 
     * @param quId 人事任免_法律知识考试_试题管理主键
     * @return 人事任免_法律知识考试_试题管理
     */
    public PersonnelAppointQuestion selectPersonnelAppointQuestionByQuId(Long quId);

    /**
     * 查询人事任免_法律知识考试_试题管理列表
     * 
     * @param personnelAppointQuestion 人事任免_法律知识考试_试题管理
     * @return 人事任免_法律知识考试_试题管理集合
     */
    public List<PersonnelAppointQuestion> selectPersonnelAppointQuestionList(PersonnelAppointQuestion personnelAppointQuestion);

    /**
     * 新增人事任免_法律知识考试_试题管理
     * 
     * @param personnelAppointQuestion 人事任免_法律知识考试_试题管理
     * @return 结果
     */
    public int insertPersonnelAppointQuestion(PersonnelAppointQuestion personnelAppointQuestion);

    /**
     * 修改人事任免_法律知识考试_试题管理
     * 
     * @param personnelAppointQuestion 人事任免_法律知识考试_试题管理
     * @return 结果
     */
    public int updatePersonnelAppointQuestion(PersonnelAppointQuestion personnelAppointQuestion);

    /**
     * 批量删除人事任免_法律知识考试_试题管理
     * 
     * @param quIds 需要删除的人事任免_法律知识考试_试题管理主键集合
     * @return 结果
     */
    public int deletePersonnelAppointQuestionByQuIds(Long[] quIds);

    /**
     * 删除人事任免_法律知识考试_试题管理信息
     * 
     * @param quId 人事任免_法律知识考试_试题管理主键
     * @return 结果
     */
    public int deletePersonnelAppointQuestionByQuId(Long quId);


    /**
     * 根据随机组题参数,随机生成试卷的试题
     *
     * @param dto
     * @return
     */
    public List<PersonnelAppointQuestion> selectRandomQuestionList(RandomQuDto dto);
}
