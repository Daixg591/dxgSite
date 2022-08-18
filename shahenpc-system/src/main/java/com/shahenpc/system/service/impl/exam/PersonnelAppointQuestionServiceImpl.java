package com.shahenpc.system.service.impl.exam;

import com.shahenpc.common.utils.DateUtils;
import com.shahenpc.system.domain.exam.PersonnelAppointAnswer;
import com.shahenpc.system.domain.exam.PersonnelAppointQuestion;
import com.shahenpc.system.domain.exam.dto.RandomQuDto;
import com.shahenpc.system.mapper.exam.PersonnelAppointAnswerMapper;
import com.shahenpc.system.mapper.exam.PersonnelAppointQuestionMapper;
import com.shahenpc.system.service.exam.IPersonnelAppointQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Autowired
    private PersonnelAppointAnswerMapper answerMapper;

    /**
     * 查询人事任免_法律知识考试_试题管理
     * 
     * @param quId 人事任免_法律知识考试_试题管理主键
     * @return 人事任免_法律知识考试_试题管理
     */
    @Override
    public PersonnelAppointQuestion selectPersonnelAppointQuestionByQuId(Long quId)
    {
        PersonnelAppointQuestion entity=personnelAppointQuestionMapper.selectPersonnelAppointQuestionByQuId(quId);

        //region 试题答案获取
        PersonnelAppointAnswer answerParam=new PersonnelAppointAnswer();
        answerParam.setQuId(quId);
        List<PersonnelAppointAnswer> answerList=answerMapper.selectPersonnelAppointAnswerList(answerParam);
        entity.setAnswerList(answerList);
        //endregion

        return entity;
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

    /**
     * 根据随机组题参数,随机生成试卷的试题
     *
     * @param dto
     * @return
     */
    @Override
    public List<PersonnelAppointQuestion> selectRandomQuestionList(RandomQuDto dto) {
        return personnelAppointQuestionMapper.selectRandomQuestionList(dto);
    }
}
