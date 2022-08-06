package com.shahenpc.system.service.impl.exam;

import java.util.List;
import com.shahenpc.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shahenpc.system.mapper.exam.PersonnelAppointExamLogMapper;
import com.shahenpc.system.domain.exam.PersonnelAppointExamLog;
import com.shahenpc.system.service.exam.IPersonnelAppointExamLogService;

/**
 * 人事任免_法律知识考试_答题记录Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-07-27
 */
@Service
public class PersonnelAppointExamLogServiceImpl implements IPersonnelAppointExamLogService 
{
    @Autowired
    private PersonnelAppointExamLogMapper personnelAppointExamLogMapper;

    /**
     * 查询人事任免_法律知识考试_答题记录
     * 
     * @param logId 人事任免_法律知识考试_答题记录主键
     * @return 人事任免_法律知识考试_答题记录
     */
    @Override
    public PersonnelAppointExamLog selectPersonnelAppointExamLogByLogId(Long logId)
    {
        return personnelAppointExamLogMapper.selectPersonnelAppointExamLogByLogId(logId);
    }

    /**
     * 查询人事任免_法律知识考试_答题记录列表
     * 
     * @param personnelAppointExamLog 人事任免_法律知识考试_答题记录
     * @return 人事任免_法律知识考试_答题记录
     */
    @Override
    public List<PersonnelAppointExamLog> selectPersonnelAppointExamLogList(PersonnelAppointExamLog personnelAppointExamLog)
    {
        return personnelAppointExamLogMapper.selectPersonnelAppointExamLogList(personnelAppointExamLog);
    }

    /**
     * 新增人事任免_法律知识考试_答题记录
     * 
     * @param personnelAppointExamLog 人事任免_法律知识考试_答题记录
     * @return 结果
     */
    @Override
    public int insertPersonnelAppointExamLog(PersonnelAppointExamLog personnelAppointExamLog)
    {
        personnelAppointExamLog.setCreateTime(DateUtils.getNowDate());
        return personnelAppointExamLogMapper.insertPersonnelAppointExamLog(personnelAppointExamLog);
    }

    /**
     * 修改人事任免_法律知识考试_答题记录
     * 
     * @param personnelAppointExamLog 人事任免_法律知识考试_答题记录
     * @return 结果
     */
    @Override
    public int updatePersonnelAppointExamLog(PersonnelAppointExamLog personnelAppointExamLog)
    {
        personnelAppointExamLog.setUpdateTime(DateUtils.getNowDate());
        return personnelAppointExamLogMapper.updatePersonnelAppointExamLog(personnelAppointExamLog);
    }

    /**
     * 批量删除人事任免_法律知识考试_答题记录
     * 
     * @param logIds 需要删除的人事任免_法律知识考试_答题记录主键
     * @return 结果
     */
    @Override
    public int deletePersonnelAppointExamLogByLogIds(Long[] logIds)
    {
        return personnelAppointExamLogMapper.deletePersonnelAppointExamLogByLogIds(logIds);
    }

    /**
     * 删除人事任免_法律知识考试_答题记录信息
     * 
     * @param logId 人事任免_法律知识考试_答题记录主键
     * @return 结果
     */
    @Override
    public int deletePersonnelAppointExamLogByLogId(Long logId)
    {
        return personnelAppointExamLogMapper.deletePersonnelAppointExamLogByLogId(logId);
    }
}
