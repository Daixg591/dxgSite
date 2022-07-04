package com.shahenpc.system.service.personel;

import java.util.List;
import com.shahenpc.system.domain.personel.PersonnelAppointSpeak;

/**
 * 人事任免_拟任职发言Service接口
 * 
 * @author ruoyi
 * @date 2022-07-04
 */
public interface IPersonnelAppointSpeakService 
{
    /**
     * 查询人事任免_拟任职发言
     * 
     * @param speakId 人事任免_拟任职发言主键
     * @return 人事任免_拟任职发言
     */
    public PersonnelAppointSpeak selectPersonnelAppointSpeakBySpeakId(Long speakId);

    /**
     * 查询人事任免_拟任职发言列表
     * 
     * @param personnelAppointSpeak 人事任免_拟任职发言
     * @return 人事任免_拟任职发言集合
     */
    public List<PersonnelAppointSpeak> selectPersonnelAppointSpeakList(PersonnelAppointSpeak personnelAppointSpeak);

    /**
     * 新增人事任免_拟任职发言
     * 
     * @param personnelAppointSpeak 人事任免_拟任职发言
     * @return 结果
     */
    public int insertPersonnelAppointSpeak(PersonnelAppointSpeak personnelAppointSpeak);

    /**
     * 修改人事任免_拟任职发言
     * 
     * @param personnelAppointSpeak 人事任免_拟任职发言
     * @return 结果
     */
    public int updatePersonnelAppointSpeak(PersonnelAppointSpeak personnelAppointSpeak);

    /**
     * 批量删除人事任免_拟任职发言
     * 
     * @param speakIds 需要删除的人事任免_拟任职发言主键集合
     * @return 结果
     */
    public int deletePersonnelAppointSpeakBySpeakIds(Long[] speakIds);

    /**
     * 删除人事任免_拟任职发言信息
     * 
     * @param speakId 人事任免_拟任职发言主键
     * @return 结果
     */
    public int deletePersonnelAppointSpeakBySpeakId(Long speakId);
}
