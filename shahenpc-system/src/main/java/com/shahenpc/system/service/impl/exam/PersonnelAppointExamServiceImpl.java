package com.shahenpc.system.service.impl.exam;

import java.util.ArrayList;
import java.util.List;

import com.shahenpc.common.utils.DateUtils;
import com.shahenpc.system.domain.exam.PersonnelAppointExamPaper;
import com.shahenpc.system.domain.exam.PersonnelAppointPaperBigQuestion;
import com.shahenpc.system.domain.exam.PersonnelAppointQuestion;
import com.shahenpc.system.mapper.exam.PersonnelAppointExamPaperMapper;
import com.shahenpc.system.mapper.exam.PersonnelAppointPaperBigQuestionMapper;
import com.shahenpc.system.mapper.exam.PersonnelAppointQuestionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shahenpc.system.mapper.exam.PersonnelAppointExamMapper;
import com.shahenpc.system.domain.exam.PersonnelAppointExam;
import com.shahenpc.system.service.exam.IPersonnelAppointExamService;

/**
 * 人事任免_法律知识考试_考试管理Service业务层处理
 *
 * @author ruoyi
 * @date 2022-07-27
 */
@Service
public class PersonnelAppointExamServiceImpl implements IPersonnelAppointExamService {
    @Autowired
    private PersonnelAppointExamMapper personnelAppointExamMapper;

    @Autowired
    private PersonnelAppointPaperBigQuestionMapper paperQuMapper;

    @Autowired
    private PersonnelAppointExamPaperMapper paperMapper;

    @Autowired
    private PersonnelAppointQuestionMapper quMapper;

    /**
     * 查询人事任免_法律知识考试_考试管理
     *
     * @param examId 人事任免_法律知识考试_考试管理主键
     * @return 人事任免_法律知识考试_考试管理
     */
    @Override
    public PersonnelAppointExam selectPersonnelAppointExamByExamId(Long examId) {
        PersonnelAppointExam entity = personnelAppointExamMapper.selectPersonnelAppointExamByExamId(examId);
        if (entity != null) {
            PersonnelAppointExamPaper paperEntity = paperMapper.selectPersonnelAppointExamPaperByExamPaperId(entity.getPaperId());
            PersonnelAppointPaperBigQuestion paperQuParam = new PersonnelAppointPaperBigQuestion();
            paperQuParam.setExamPaperId(paperEntity.getExamPaperId());
            List<PersonnelAppointPaperBigQuestion> paperQuList = paperQuMapper.selectPersonnelAppointPaperBigQuestionList(paperQuParam);

            List<PersonnelAppointQuestion> tempList = new ArrayList<>();
            // 试卷试题对应关系数据集
            for (int i = 0; i < paperQuList.size(); i++) {
                PersonnelAppointQuestion quEntity = quMapper.selectPersonnelAppointQuestionByQuId(paperQuList.get(i).getQuId());
                tempList.add(quEntity);
            }
            paperEntity.setQuList(tempList);
            entity.setPaper(paperEntity);
        }
        return entity;
    }

    /**
     * 查询人事任免_法律知识考试_考试管理列表
     *
     * @param personnelAppointExam 人事任免_法律知识考试_考试管理
     * @return 人事任免_法律知识考试_考试管理
     */
    @Override
    public List<PersonnelAppointExam> selectPersonnelAppointExamList(PersonnelAppointExam personnelAppointExam) {
        return personnelAppointExamMapper.selectPersonnelAppointExamList(personnelAppointExam);
    }

    /**
     * 新增人事任免_法律知识考试_考试管理
     *
     * @param personnelAppointExam 人事任免_法律知识考试_考试管理
     * @return 结果
     */
    @Override
    public int insertPersonnelAppointExam(PersonnelAppointExam personnelAppointExam) {
        personnelAppointExam.setCreateTime(DateUtils.getNowDate());
        return personnelAppointExamMapper.insertPersonnelAppointExam(personnelAppointExam);
    }

    /**
     * 修改人事任免_法律知识考试_考试管理
     *
     * @param personnelAppointExam 人事任免_法律知识考试_考试管理
     * @return 结果
     */
    @Override
    public int updatePersonnelAppointExam(PersonnelAppointExam personnelAppointExam) {
        personnelAppointExam.setUpdateTime(DateUtils.getNowDate());
        return personnelAppointExamMapper.updatePersonnelAppointExam(personnelAppointExam);
    }

    /**
     * 批量删除人事任免_法律知识考试_考试管理
     *
     * @param examIds 需要删除的人事任免_法律知识考试_考试管理主键
     * @return 结果
     */
    @Override
    public int deletePersonnelAppointExamByExamIds(Long[] examIds) {
        return personnelAppointExamMapper.deletePersonnelAppointExamByExamIds(examIds);
    }

    /**
     * 删除人事任免_法律知识考试_考试管理信息
     *
     * @param examId 人事任免_法律知识考试_考试管理主键
     * @return 结果
     */
    @Override
    public int deletePersonnelAppointExamByExamId(Long examId) {
        return personnelAppointExamMapper.deletePersonnelAppointExamByExamId(examId);
    }
}
