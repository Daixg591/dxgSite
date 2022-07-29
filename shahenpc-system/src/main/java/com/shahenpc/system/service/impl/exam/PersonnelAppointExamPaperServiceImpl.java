package com.shahenpc.system.service.impl.exam;

import java.util.List;
import com.shahenpc.common.utils.DateUtils;
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
public class PersonnelAppointExamPaperServiceImpl implements IPersonnelAppointExamPaperService 
{
    @Autowired
    private PersonnelAppointExamPaperMapper personnelAppointExamPaperMapper;

    /**
     * 查询人事任免_法律知识考虑_试卷管理
     * 
     * @param examPaperId 人事任免_法律知识考虑_试卷管理主键
     * @return 人事任免_法律知识考虑_试卷管理
     */
    @Override
    public PersonnelAppointExamPaper selectPersonnelAppointExamPaperByExamPaperId(Long examPaperId)
    {
        return personnelAppointExamPaperMapper.selectPersonnelAppointExamPaperByExamPaperId(examPaperId);
    }

    /**
     * 查询人事任免_法律知识考虑_试卷管理列表
     * 
     * @param personnelAppointExamPaper 人事任免_法律知识考虑_试卷管理
     * @return 人事任免_法律知识考虑_试卷管理
     */
    @Override
    public List<PersonnelAppointExamPaper> selectPersonnelAppointExamPaperList(PersonnelAppointExamPaper personnelAppointExamPaper)
    {
        return personnelAppointExamPaperMapper.selectPersonnelAppointExamPaperList(personnelAppointExamPaper);
    }

    /**
     * 新增人事任免_法律知识考虑_试卷管理
     * 
     * @param personnelAppointExamPaper 人事任免_法律知识考虑_试卷管理
     * @return 结果
     */
    @Override
    public int insertPersonnelAppointExamPaper(PersonnelAppointExamPaper personnelAppointExamPaper)
    {
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
    public int updatePersonnelAppointExamPaper(PersonnelAppointExamPaper personnelAppointExamPaper)
    {
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
    public int deletePersonnelAppointExamPaperByExamPaperIds(Long[] examPaperIds)
    {
        return personnelAppointExamPaperMapper.deletePersonnelAppointExamPaperByExamPaperIds(examPaperIds);
    }

    /**
     * 删除人事任免_法律知识考虑_试卷管理信息
     * 
     * @param examPaperId 人事任免_法律知识考虑_试卷管理主键
     * @return 结果
     */
    @Override
    public int deletePersonnelAppointExamPaperByExamPaperId(Long examPaperId)
    {
        return personnelAppointExamPaperMapper.deletePersonnelAppointExamPaperByExamPaperId(examPaperId);
    }
}
