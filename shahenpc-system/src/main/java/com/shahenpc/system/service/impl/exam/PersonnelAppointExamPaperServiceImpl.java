package com.shahenpc.system.service.impl.exam;

import java.util.ArrayList;
import java.util.List;

import com.shahenpc.common.utils.DateUtils;
import com.shahenpc.system.domain.exam.PersonnelAppointPaperBigQuestion;
import com.shahenpc.system.domain.exam.PersonnelAppointQuestion;
import com.shahenpc.system.domain.exam.dto.RandomQuDto;
import com.shahenpc.system.mapper.exam.PersonnelAppointPaperBigQuestionMapper;
import com.shahenpc.system.mapper.exam.PersonnelAppointQuestionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shahenpc.system.mapper.exam.PersonnelAppointExamPaperMapper;
import com.shahenpc.system.domain.exam.PersonnelAppointExamPaper;
import com.shahenpc.system.service.exam.IPersonnelAppointExamPaperService;

/**
 * 人事任免_法律知识考虑_试卷管理Service业务层处理
 *
 * @author ruoyi
 * @date 2022-07-27
 */
@Service
public class PersonnelAppointExamPaperServiceImpl implements IPersonnelAppointExamPaperService {
    @Autowired
    private PersonnelAppointExamPaperMapper personnelAppointExamPaperMapper;

    @Autowired
    private PersonnelAppointPaperBigQuestionMapper paperQuMapper;

    @Autowired
    private PersonnelAppointQuestionMapper quMapper;

    /**
     * 查询人事任免_法律知识考虑_试卷管理
     *
     * @param examPaperId 人事任免_法律知识考虑_试卷管理主键
     * @return 人事任免_法律知识考虑_试卷管理
     */
    @Override
    public PersonnelAppointExamPaper selectPersonnelAppointExamPaperByExamPaperId(Long examPaperId) {
        PersonnelAppointExamPaper entity = personnelAppointExamPaperMapper.selectPersonnelAppointExamPaperByExamPaperId(examPaperId);
        PersonnelAppointPaperBigQuestion paperQuParam = new PersonnelAppointPaperBigQuestion();
        paperQuParam.setExamPaperId(entity.getExamPaperId());
        List<PersonnelAppointPaperBigQuestion> paperQuList = paperQuMapper.selectPersonnelAppointPaperBigQuestionList(paperQuParam);

        List<PersonnelAppointQuestion> tempList = new ArrayList<>();
        // 试卷试题对应关系数据集
        for (int i = 0; i < paperQuList.size(); i++) {
            PersonnelAppointQuestion quEntity = quMapper.selectPersonnelAppointQuestionByQuId(paperQuList.get(i).getBigQuestionId());
            tempList.add(quEntity);
        }
        entity.setQuList(tempList);
        return entity;
    }

    /**
     * 查询人事任免_法律知识考虑_试卷管理列表
     *
     * @param personnelAppointExamPaper 人事任免_法律知识考虑_试卷管理
     * @return 人事任免_法律知识考虑_试卷管理
     */
    @Override
    public List<PersonnelAppointExamPaper> selectPersonnelAppointExamPaperList(PersonnelAppointExamPaper personnelAppointExamPaper) {
        return personnelAppointExamPaperMapper.selectPersonnelAppointExamPaperList(personnelAppointExamPaper);
    }

    /**
     * 新增人事任免_法律知识考虑_试卷管理
     *
     * @param personnelAppointExamPaper 人事任免_法律知识考虑_试卷管理
     * @return 结果
     */
    @Override
    public int insertPersonnelAppointExamPaper(PersonnelAppointExamPaper personnelAppointExamPaper) {
        personnelAppointExamPaper.setCreateTime(DateUtils.getNowDate());
        return personnelAppointExamPaperMapper.insertPersonnelAppointExamPaper(personnelAppointExamPaper);
    }

    /**
     * 修改人事任免_法律知识考虑_试卷管理
     *
     * @param personnelAppointExamPaper 人事任免_法律知识考虑_试卷管理
     * @return 结果
     */
    @Override
    public int updatePersonnelAppointExamPaper(PersonnelAppointExamPaper personnelAppointExamPaper) {
        personnelAppointExamPaper.setUpdateTime(DateUtils.getNowDate());
        return personnelAppointExamPaperMapper.updatePersonnelAppointExamPaper(personnelAppointExamPaper);
    }

    /**
     * 批量删除人事任免_法律知识考虑_试卷管理
     *
     * @param examPaperIds 需要删除的人事任免_法律知识考虑_试卷管理主键
     * @return 结果
     */
    @Override
    public int deletePersonnelAppointExamPaperByExamPaperIds(Long[] examPaperIds) {
        return personnelAppointExamPaperMapper.deletePersonnelAppointExamPaperByExamPaperIds(examPaperIds);
    }

    /**
     * 删除人事任免_法律知识考虑_试卷管理信息
     *
     * @param examPaperId 人事任免_法律知识考虑_试卷管理主键
     * @return 结果
     */
    @Override
    public int deletePersonnelAppointExamPaperByExamPaperId(Long examPaperId) {
        return personnelAppointExamPaperMapper.deletePersonnelAppointExamPaperByExamPaperId(examPaperId);
    }

    /**
     * 根据随机组题参数,随机生成试卷的试题
     *
     * @param dto
     * @return
     */
    @Override
    public List<PersonnelAppointQuestion> selectRandomQuestionList(RandomQuDto dto) {
        return personnelAppointExamPaperMapper.selectRandomQuestionList(dto);
    }
}
