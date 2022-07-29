package com.shahenpc.system.mapper.exam;

import java.util.List;
import com.shahenpc.system.domain.exam.PersonnelAppointExamLog;

/**
 * 人事任免_法律知识考试_答题记录Mapper接口
 * 
 * @author ruoyi
 * @date 2022-07-27
 */
public interface PersonnelAppointExamLogMapper 
{
    /**
     * 查询人事任免_法律知识考试_答题记录
     * 
     * @param logId 人事任免_法律知识考试_答题记录主键
     * @return 人事任免_法律知识考试_答题记录
     */
    public PersonnelAppointExamLog selectPersonnelAppointExamLogByLogId(Long logId);

    /**
     * 查询人事任免_法律知识考试_答题记录列表
     * 
     * @param personnelAppointExamLog 人事任免_法律知识考试_答题记录
     * @return 人事任免_法律知识考试_答题记录集合
     */
    public List<PersonnelAppointExamLog> selectPersonnelAppointExamLogList(PersonnelAppointExamLog personnelAppointExamLog);

    /**
     * 新增人事任免_法律知识考试_答题记录
     * 
     * @param personnelAppointExamLog 人事任免_法律知识考试_答题记录
     * @return 结果
     */
    public int insertPersonnelAppointExamLog(PersonnelAppointExamLog personnelAppointExamLog);

    /**
     * 修改人事任免_法律知识考试_答题记录
     * 
     * @param personnelAppointExamLog 人事任免_法律知识考试_答题记录
     * @return 结果
     */
    public int updatePersonnelAppointExamLog(PersonnelAppointExamLog personnelAppointExamLog);

    /**
     * 删除人事任免_法律知识考试_答题记录
     * 
     * @param logId 人事任免_法律知识考试_答题记录主键
     * @return 结果
     */
    public int deletePersonnelAppointExamLogByLogId(Long logId);

    /**
     * 批量删除人事任免_法律知识考试_答题记录
     * 
     * @param logIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deletePersonnelAppointExamLogByLogIds(Long[] logIds);
}
