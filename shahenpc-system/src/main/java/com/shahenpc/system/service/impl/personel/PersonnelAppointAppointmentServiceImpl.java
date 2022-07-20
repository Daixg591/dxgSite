package com.shahenpc.system.service.impl.personel;

import java.util.List;
import com.shahenpc.common.utils.DateUtils;
import com.shahenpc.system.domain.personel.dto.PersonnelQueryDto;
import com.shahenpc.system.mapper.personel.PersonnelAppointAppointmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shahenpc.system.domain.personel.PersonnelAppointAppointment;
import com.shahenpc.system.service.personel.IPersonnelAppointAppointmentService;

/**
 * 人事任免_颁发任命书Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-07-06
 */
@Service
public class PersonnelAppointAppointmentServiceImpl implements IPersonnelAppointAppointmentService 
{
    @Autowired
    private PersonnelAppointAppointmentMapper personnelAppointAppointmentMapper;

    /**
     * 查询人事任免_颁发任命书
     * 
     * @param appointmentId 人事任免_颁发任命书主键
     * @return 人事任免_颁发任命书
     */
    @Override
    public PersonnelAppointAppointment selectPersonnelAppointAppointmentByAppointmentId(Long appointmentId)
    {
        return personnelAppointAppointmentMapper.selectPersonnelAppointAppointmentByAppointmentId(appointmentId);
    }

    /**
     * 查询人事任免_颁发任命书列表
     * 
     * @param personnelAppointAppointment 人事任免_颁发任命书
     * @return 人事任免_颁发任命书
     */
    @Override
    public List<PersonnelAppointAppointment> selectPersonnelAppointAppointmentList(PersonnelQueryDto personnelAppointAppointment)
    {
        List<PersonnelAppointAppointment> list=personnelAppointAppointmentMapper.selectPersonnelAppointAppointmentList(personnelAppointAppointment);
        for (PersonnelAppointAppointment item : list) {
            item.setNickName(item.getSysUser().getNickName());
            item.setSex(item.getSysUser().getSex());
            item.setPhonenumber(item.getSysUser().getPhonenumber());
            item.setIdCard(item.getSysUser().getIdCard());
            item.setAppointType(item.getAppointType());
        }
        return list;
    }

    /**
     * 新增人事任免_颁发任命书
     * 
     * @param personnelAppointAppointment 人事任免_颁发任命书
     * @return 结果
     */
    @Override
    public int insertPersonnelAppointAppointment(PersonnelAppointAppointment personnelAppointAppointment)
    {
        personnelAppointAppointment.setCreateTime(DateUtils.getNowDate());
        return personnelAppointAppointmentMapper.insertPersonnelAppointAppointment(personnelAppointAppointment);
    }

    /**
     * 修改人事任免_颁发任命书
     * 
     * @param personnelAppointAppointment 人事任免_颁发任命书
     * @return 结果
     */
    @Override
    public int updatePersonnelAppointAppointment(PersonnelAppointAppointment personnelAppointAppointment)
    {
        personnelAppointAppointment.setUpdateTime(DateUtils.getNowDate());
        return personnelAppointAppointmentMapper.updatePersonnelAppointAppointment(personnelAppointAppointment);
    }

    /**
     * 批量删除人事任免_颁发任命书
     * 
     * @param registerids 需要删除的人事任免_颁发任命书主键
     * @return 结果
     */
    @Override
    public int deletePersonnelAppointAppointmentByAppointmentIds(Long[] registerids)
    {
        return personnelAppointAppointmentMapper.deletePersonnelAppointAppointmentByAppointmentIds(registerids);
    }

    /**
     * 删除人事任免_颁发任命书信息
     * 
     * @param appointmentId 人事任免_颁发任命书主键
     * @return 结果
     */
    @Override
    public int deletePersonnelAppointAppointmentByAppointmentId(Long appointmentId)
    {
        return personnelAppointAppointmentMapper.deletePersonnelAppointAppointmentByAppointmentId(appointmentId);
    }
}
