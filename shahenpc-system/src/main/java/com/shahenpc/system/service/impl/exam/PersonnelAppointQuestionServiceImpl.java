package com.shahenpc.system.service.impl.exam;

import java.util.List;
import com.shahenpc.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shahenpc.system.mapper.exam.PersonnelAppointQuestionMapper;
import com.shahenpc.system.domain.exam.PersonnelAppointQuestion;
import com.shahenpc.system.service.exam.IPersonnelAppointQuestionService;

/**
 * 人事任免_法律知识考试_试题管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-07-27
 */
@Service
public class PersonnelAppointQuestionServiceImpl implements IPersonnelAppointQuestionService 
{
    @Autowired
    private PersonnelAppointQuestionMapper personnelAppointQuestionMapper;

    /**
     * 查询人事任免_法律知识考试_试题管理
     * 
     * @param quId 人事任免_法律知识考试_试题管理主键
     * @return 人事任免_法律知识考试_试题管理
     */
    @Override
    public PersonnelAppointQuestion selectPersonnelAppointQuestionByQuId(Long quId)
    {
        return personnelAppointQuestionMapper.selectPersonnelAppointQuestionByQuId(quId);
    }

    /**
     * 查询人事任免_法律知识考试_试题管理列表
     * 
     * @param personnelAppointQuestion 人事任免_法律知识考试_试题管理
     * @return 人事任免_法律知识考试_试题管理
     */
    @Override
    public List<PersonnelAppointQuestion> selectPersonnelAppointQuestionList(PersonnelAppointQuestion personnelAppointQuestion)
    {
        return personnelAppointQuestionMapper.selectPersonnelAppointQuestionList(personnelAppointQuestion);
    }

    /**
     * 新增人事任免_法律知识考试_试题管理
     * 
     * @param personnelAppointQuestion 人事任免_法律知识考试_试题管理
     * @return 结果
     */
    @Override
    public int insertPersonnelAppointQuestion(PersonnelAppointQuestion personnelAppointQuestion)
    {
        personnelAppointQuestion.setCreateTime(DateUtils.getNowDate());
        return personnelAppointQuestionMapper.insertPersonnelAppointQuestion(personnelAppointQuestion);
    }

    /**
     * 修改人事任免_法律知识考试_试题管理
     * 
     * @param personnelAppointQuestion 人事任免_法律知识考试_试题管理
     * @return 结果
     */
    @Override
    public int updatePersonnelAppointQuestion(PersonnelAppointQuestion personnelAppointQuestion)
    {
        personnelAppointQuestion.setUpdateTime(DateUtils.getNowDate());
        return personnelAppointQuestionMapper.updatePersonnelAppointQuestion(personnelAppointQuestion);
    }

    /**
     * 批量删除人事任免_法律知识考试_试题管理
     * 
     * @param quIds 需要删除的人事任免_法律知识考试_试题管理主键
     * @return 结果
     */
    @Override
    public int deletePersonnelAppointQuestionByQuIds(Long[] quIds)
    {
        return personnelAppointQuestionMapper.deletePersonnelAppointQuestionByQuIds(quIds);
    }

    /**
     * 删除人事任免_法律知识考试_试题管理信息
     * 
     * @param quId 人事任免_法律知识考试_试题管理主键
     * @return 结果
     */
    @Override
    public int deletePersonnelAppointQuestionByQuId(Long quId)
    {
        return personnelAppointQuestionMapper.deletePersonnelAppointQuestionByQuId(quId);
    }
}
