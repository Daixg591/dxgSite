package com.shahenpc.system.service.impl.exam;

import java.util.List;
import com.shahenpc.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shahenpc.system.mapper.exam.PersonnelAppointPaperBigQuestionMapper;
import com.shahenpc.system.domain.exam.PersonnelAppointPaperBigQuestion;
import com.shahenpc.system.service.exam.IPersonnelAppointPaperBigQuestionService;

/**
 * 人事任免_法律知识考试_试卷大题对应Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-07-27
 */
@Service
public class PersonnelAppointPaperBigQuestionServiceImpl implements IPersonnelAppointPaperBigQuestionService 
{
    @Autowired
    private PersonnelAppointPaperBigQuestionMapper personnelAppointPaperBigQuestionMapper;

    /**
     * 查询人事任免_法律知识考试_试卷大题对应
     * 
     * @param bigQuestionId 人事任免_法律知识考试_试卷大题对应主键
     * @return 人事任免_法律知识考试_试卷大题对应
     */
    @Override
    public PersonnelAppointPaperBigQuestion selectPersonnelAppointPaperBigQuestionByBigQuestionId(Long bigQuestionId)
    {
        return personnelAppointPaperBigQuestionMapper.selectPersonnelAppointPaperBigQuestionByBigQuestionId(bigQuestionId);
    }

    /**
     * 查询人事任免_法律知识考试_试卷大题对应列表
     * 
     * @param personnelAppointPaperBigQuestion 人事任免_法律知识考试_试卷大题对应
     * @return 人事任免_法律知识考试_试卷大题对应
     */
    @Override
    public List<PersonnelAppointPaperBigQuestion> selectPersonnelAppointPaperBigQuestionList(PersonnelAppointPaperBigQuestion personnelAppointPaperBigQuestion)
    {
        return personnelAppointPaperBigQuestionMapper.selectPersonnelAppointPaperBigQuestionList(personnelAppointPaperBigQuestion);
    }

    /**
     * 新增人事任免_法律知识考试_试卷大题对应
     * 
     * @param personnelAppointPaperBigQuestion 人事任免_法律知识考试_试卷大题对应
     * @return 结果
     */
    @Override
    public int insertPersonnelAppointPaperBigQuestion(PersonnelAppointPaperBigQuestion personnelAppointPaperBigQuestion)
    {
        personnelAppointPaperBigQuestion.setCreateTime(DateUtils.getNowDate());
        return personnelAppointPaperBigQuestionMapper.insertPersonnelAppointPaperBigQuestion(personnelAppointPaperBigQuestion);
    }

    /**
     * 修改人事任免_法律知识考试_试卷大题对应
     * 
     * @param personnelAppointPaperBigQuestion 人事任免_法律知识考试_试卷大题对应
     * @return 结果
     */
    @Override
    public int updatePersonnelAppointPaperBigQuestion(PersonnelAppointPaperBigQuestion personnelAppointPaperBigQuestion)
    {
        personnelAppointPaperBigQuestion.setUpdateTime(DateUtils.getNowDate());
        return personnelAppointPaperBigQuestionMapper.updatePersonnelAppointPaperBigQuestion(personnelAppointPaperBigQuestion);
    }

    /**
     * 批量删除人事任免_法律知识考试_试卷大题对应
     * 
     * @param bigQuestionIds 需要删除的人事任免_法律知识考试_试卷大题对应主键
     * @return 结果
     */
    @Override
    public int deletePersonnelAppointPaperBigQuestionByBigQuestionIds(Long[] bigQuestionIds)
    {
        return personnelAppointPaperBigQuestionMapper.deletePersonnelAppointPaperBigQuestionByBigQuestionIds(bigQuestionIds);
    }

    /**
     * 删除人事任免_法律知识考试_试卷大题对应信息
     * 
     * @param bigQuestionId 人事任免_法律知识考试_试卷大题对应主键
     * @return 结果
     */
    @Override
    public int deletePersonnelAppointPaperBigQuestionByBigQuestionId(Long bigQuestionId)
    {
        return personnelAppointPaperBigQuestionMapper.deletePersonnelAppointPaperBigQuestionByBigQuestionId(bigQuestionId);
    }
}
