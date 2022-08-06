package com.shahenpc.system.service.impl.exam;

import java.util.List;
import com.shahenpc.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shahenpc.system.mapper.exam.PersonnelAppointAnswerMapper;
import com.shahenpc.system.domain.exam.PersonnelAppointAnswer;
import com.shahenpc.system.service.exam.IPersonnelAppointAnswerService;

/**
 * 人事任免_法律知识考试_答案管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-07-27
 */
@Service
public class PersonnelAppointAnswerServiceImpl implements IPersonnelAppointAnswerService 
{
    @Autowired
    private PersonnelAppointAnswerMapper personnelAppointAnswerMapper;

    /**
     * 查询人事任免_法律知识考试_答案管理
     * 
     * @param answerId 人事任免_法律知识考试_答案管理主键
     * @return 人事任免_法律知识考试_答案管理
     */
    @Override
    public PersonnelAppointAnswer selectPersonnelAppointAnswerByAnswerId(Long answerId)
    {
        return personnelAppointAnswerMapper.selectPersonnelAppointAnswerByAnswerId(answerId);
    }

    /**
     * 查询人事任免_法律知识考试_答案管理列表
     * 
     * @param personnelAppointAnswer 人事任免_法律知识考试_答案管理
     * @return 人事任免_法律知识考试_答案管理
     */
    @Override
    public List<PersonnelAppointAnswer> selectPersonnelAppointAnswerList(PersonnelAppointAnswer personnelAppointAnswer)
    {
        return personnelAppointAnswerMapper.selectPersonnelAppointAnswerList(personnelAppointAnswer);
    }

    /**
     * 新增人事任免_法律知识考试_答案管理
     * 
     * @param personnelAppointAnswer 人事任免_法律知识考试_答案管理
     * @return 结果
     */
    @Override
    public int insertPersonnelAppointAnswer(PersonnelAppointAnswer personnelAppointAnswer)
    {
        personnelAppointAnswer.setCreateTime(DateUtils.getNowDate());
        return personnelAppointAnswerMapper.insertPersonnelAppointAnswer(personnelAppointAnswer);
    }

    /**
     * 修改人事任免_法律知识考试_答案管理
     * 
     * @param personnelAppointAnswer 人事任免_法律知识考试_答案管理
     * @return 结果
     */
    @Override
    public int updatePersonnelAppointAnswer(PersonnelAppointAnswer personnelAppointAnswer)
    {
        personnelAppointAnswer.setUpdateTime(DateUtils.getNowDate());
        return personnelAppointAnswerMapper.updatePersonnelAppointAnswer(personnelAppointAnswer);
    }

    /**
     * 批量删除人事任免_法律知识考试_答案管理
     * 
     * @param answerIds 需要删除的人事任免_法律知识考试_答案管理主键
     * @return 结果
     */
    @Override
    public int deletePersonnelAppointAnswerByAnswerIds(Long[] answerIds)
    {
        return personnelAppointAnswerMapper.deletePersonnelAppointAnswerByAnswerIds(answerIds);
    }

    /**
     * 删除人事任免_法律知识考试_答案管理信息
     * 
     * @param answerId 人事任免_法律知识考试_答案管理主键
     * @return 结果
     */
    @Override
    public int deletePersonnelAppointAnswerByAnswerId(Long answerId)
    {
        return personnelAppointAnswerMapper.deletePersonnelAppointAnswerByAnswerId(answerId);
    }
}
