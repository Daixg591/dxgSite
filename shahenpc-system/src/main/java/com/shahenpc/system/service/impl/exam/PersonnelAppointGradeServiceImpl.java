package com.shahenpc.system.service.impl.exam;

import java.util.List;
import com.shahenpc.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shahenpc.system.mapper.exam.PersonnelAppointGradeMapper;
import com.shahenpc.system.domain.exam.PersonnelAppointGrade;
import com.shahenpc.system.service.exam.IPersonnelAppointGradeService;

/**
 * 人事任免_法律知识考虑_成绩管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-07-27
 */
@Service
public class PersonnelAppointGradeServiceImpl implements IPersonnelAppointGradeService 
{
    @Autowired
    private PersonnelAppointGradeMapper personnelAppointGradeMapper;

    /**
     * 查询人事任免_法律知识考虑_成绩管理
     * 
     * @param gradeId 人事任免_法律知识考虑_成绩管理主键
     * @return 人事任免_法律知识考虑_成绩管理
     */
    @Override
    public PersonnelAppointGrade selectPersonnelAppointGradeByGradeId(Long gradeId)
    {
        return personnelAppointGradeMapper.selectPersonnelAppointGradeByGradeId(gradeId);
    }

    @Override
    public PersonnelAppointGrade selectGradeByRegId(Long registerId){
        return personnelAppointGradeMapper.selectGradeByRegId(registerId);
    }

    /**
     * 查询人事任免_法律知识考虑_成绩管理列表
     * 
     * @param personnelAppointGrade 人事任免_法律知识考虑_成绩管理
     * @return 人事任免_法律知识考虑_成绩管理
     */
    @Override
    public List<PersonnelAppointGrade> selectPersonnelAppointGradeList(PersonnelAppointGrade personnelAppointGrade)
    {
        return personnelAppointGradeMapper.selectPersonnelAppointGradeList(personnelAppointGrade);
    }

    /**
     * 新增人事任免_法律知识考虑_成绩管理
     * 
     * @param personnelAppointGrade 人事任免_法律知识考虑_成绩管理
     * @return 结果
     */
    @Override
    public int insertPersonnelAppointGrade(PersonnelAppointGrade personnelAppointGrade)
    {
        personnelAppointGrade.setCreateTime(DateUtils.getNowDate());
        return personnelAppointGradeMapper.insertPersonnelAppointGrade(personnelAppointGrade);
    }

    /**
     * 修改人事任免_法律知识考虑_成绩管理
     * 
     * @param personnelAppointGrade 人事任免_法律知识考虑_成绩管理
     * @return 结果
     */
    @Override
    public int updatePersonnelAppointGrade(PersonnelAppointGrade personnelAppointGrade)
    {
        personnelAppointGrade.setUpdateTime(DateUtils.getNowDate());
        return personnelAppointGradeMapper.updatePersonnelAppointGrade(personnelAppointGrade);
    }

    /**
     * 批量删除人事任免_法律知识考虑_成绩管理
     * 
     * @param gradeIds 需要删除的人事任免_法律知识考虑_成绩管理主键
     * @return 结果
     */
    @Override
    public int deletePersonnelAppointGradeByGradeIds(Long[] gradeIds)
    {
        return personnelAppointGradeMapper.deletePersonnelAppointGradeByGradeIds(gradeIds);
    }

    /**
     * 删除人事任免_法律知识考虑_成绩管理信息
     * 
     * @param gradeId 人事任免_法律知识考虑_成绩管理主键
     * @return 结果
     */
    @Override
    public int deletePersonnelAppointGradeByGradeId(Long gradeId)
    {
        return personnelAppointGradeMapper.deletePersonnelAppointGradeByGradeId(gradeId);
    }
}
