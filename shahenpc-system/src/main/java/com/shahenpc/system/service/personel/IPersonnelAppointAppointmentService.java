package com.shahenpc.system.service.personel;

import java.util.List;
import com.shahenpc.system.domain.personel.PersonnelAppointAppointment;
import com.shahenpc.system.domain.personel.dto.PersonnelQueryDto;

/**
 * 人事任免_颁发任命书Service接口
 * 
 * @author ruoyi
 * @date 2022-07-06
 */
public interface IPersonnelAppointAppointmentService 
{
    /**
     * 查询人事任免_颁发任命书
     * 
     * @param appointmentId 人事任免_颁发任命书主键
     * @return 人事任免_颁发任命书
     */
    public PersonnelAppointAppointment selectPersonnelAppointAppointmentByAppointmentId(Long appointmentId);

    /**
     * 查询人事任免_颁发任命书列表
     * 
     * @param personnelAppointAppointment 人事任免_颁发任命书
     * @return 人事任免_颁发任命书集合
     */
    public List<PersonnelAppointAppointment> selectPersonnelAppointAppointmentList(PersonnelQueryDto personnelAppointAppointment);

    /**
     * 新增人事任免_颁发任命书
     * 
     * @param personnelAppointAppointment 人事任免_颁发任命书
     * @return 结果
     */
    public int insertPersonnelAppointAppointment(PersonnelAppointAppointment personnelAppointAppointment);

    /**
     * 修改人事任免_颁发任命书
     * 
     * @param personnelAppointAppointment 人事任免_颁发任命书
     * @return 结果
     */
    public int updatePersonnelAppointAppointment(PersonnelAppointAppointment personnelAppointAppointment);

    /**
     * 批量删除人事任免_颁发任命书
     * 
     * @param registerids 需要删除的人事任免_颁发任命书主键集合
     * @return 结果
     */
    public int deletePersonnelAppointAppointmentByAppointmentIds(Long[] registerids);

    /**
     * 删除人事任免_颁发任命书信息
     * 
     * @param appointmentId 人事任免_颁发任命书主键
     * @return 结果
     */
    public int deletePersonnelAppointAppointmentByAppointmentId(Long appointmentId);
}
