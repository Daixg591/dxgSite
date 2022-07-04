package com.shahenpc.system.service.personel;

import java.util.List;
import com.shahenpc.system.domain.personel.PersonnelAppointEduLog;

/**
 * 人事任免_教育记录Service接口
 * 
 * @author ruoyi
 * @date 2022-07-04
 */
public interface IPersonnelAppointEduLogService 
{
    /**
     * 查询人事任免_教育记录
     * 
     * @param eduLogId 人事任免_教育记录主键
     * @return 人事任免_教育记录
     */
    public PersonnelAppointEduLog selectPersonnelAppointEduLogByEduLogId(Long eduLogId);

    /**
     * 查询人事任免_教育记录列表
     * 
     * @param personnelAppointEduLog 人事任免_教育记录
     * @return 人事任免_教育记录集合
     */
    public List<PersonnelAppointEduLog> selectPersonnelAppointEduLogList(PersonnelAppointEduLog personnelAppointEduLog);

    /**
     * 新增人事任免_教育记录
     * 
     * @param personnelAppointEduLog 人事任免_教育记录
     * @return 结果
     */
    public int insertPersonnelAppointEduLog(PersonnelAppointEduLog personnelAppointEduLog);

    /**
     * 修改人事任免_教育记录
     * 
     * @param personnelAppointEduLog 人事任免_教育记录
     * @return 结果
     */
    public int updatePersonnelAppointEduLog(PersonnelAppointEduLog personnelAppointEduLog);

    /**
     * 批量删除人事任免_教育记录
     * 
     * @param eduLogIds 需要删除的人事任免_教育记录主键集合
     * @return 结果
     */
    public int deletePersonnelAppointEduLogByEduLogIds(Long[] eduLogIds);

    /**
     * 删除人事任免_教育记录信息
     * 
     * @param eduLogId 人事任免_教育记录主键
     * @return 结果
     */
    public int deletePersonnelAppointEduLogByEduLogId(Long eduLogId);
}
