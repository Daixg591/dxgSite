package com.shahenpc.system.service.impl.personel;

import java.util.List;
import com.shahenpc.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shahenpc.system.mapper.personel.PersonnelAppointEduLogMapper;
import com.shahenpc.system.domain.personel.PersonnelAppointEduLog;
import com.shahenpc.system.service.personel.IPersonnelAppointEduLogService;

/**
 * 人事任免_教育记录Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-07-04
 */
@Service
public class PersonnelAppointEduLogServiceImpl implements IPersonnelAppointEduLogService 
{
    @Autowired
    private PersonnelAppointEduLogMapper personnelAppointEduLogMapper;

    /**
     * 查询人事任免_教育记录
     * 
     * @param eduLogId 人事任免_教育记录主键
     * @return 人事任免_教育记录
     */
    @Override
    public PersonnelAppointEduLog selectPersonnelAppointEduLogByEduLogId(Long eduLogId)
    {
        return personnelAppointEduLogMapper.selectPersonnelAppointEduLogByEduLogId(eduLogId);
    }

    /**
     * 查询人事任免_教育记录列表
     * 
     * @param personnelAppointEduLog 人事任免_教育记录
     * @return 人事任免_教育记录
     */
    @Override
    public List<PersonnelAppointEduLog> selectPersonnelAppointEduLogList(PersonnelAppointEduLog personnelAppointEduLog)
    {
        return personnelAppointEduLogMapper.selectPersonnelAppointEduLogList(personnelAppointEduLog);
    }

    /**
     * 新增人事任免_教育记录
     * 
     * @param personnelAppointEduLog 人事任免_教育记录
     * @return 结果
     */
    @Override
    public int insertPersonnelAppointEduLog(PersonnelAppointEduLog personnelAppointEduLog)
    {
        personnelAppointEduLog.setCreateTime(DateUtils.getNowDate());
        return personnelAppointEduLogMapper.insertPersonnelAppointEduLog(personnelAppointEduLog);
    }

    /**
     * 修改人事任免_教育记录
     * 
     * @param personnelAppointEduLog 人事任免_教育记录
     * @return 结果
     */
    @Override
    public int updatePersonnelAppointEduLog(PersonnelAppointEduLog personnelAppointEduLog)
    {
        personnelAppointEduLog.setUpdateTime(DateUtils.getNowDate());
        return personnelAppointEduLogMapper.updatePersonnelAppointEduLog(personnelAppointEduLog);
    }

    /**
     * 批量删除人事任免_教育记录
     * 
     * @param eduLogIds 需要删除的人事任免_教育记录主键
     * @return 结果
     */
    @Override
    public int deletePersonnelAppointEduLogByEduLogIds(Long[] eduLogIds)
    {
        return personnelAppointEduLogMapper.deletePersonnelAppointEduLogByEduLogIds(eduLogIds);
    }

    /**
     * 删除人事任免_教育记录信息
     * 
     * @param eduLogId 人事任免_教育记录主键
     * @return 结果
     */
    @Override
    public int deletePersonnelAppointEduLogByEduLogId(Long eduLogId)
    {
        return personnelAppointEduLogMapper.deletePersonnelAppointEduLogByEduLogId(eduLogId);
    }
}
