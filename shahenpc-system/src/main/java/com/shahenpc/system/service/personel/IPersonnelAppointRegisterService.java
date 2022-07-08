package com.shahenpc.system.service.personel;

import java.util.List;
import com.shahenpc.system.domain.personel.PersonnelAppointRegister;
import com.shahenpc.system.domain.personel.dto.PersonnelQueryDto;

/**
 * 人事任免_任免记录Service接口
 * 
 * @author ruoyi
 * @date 2022-07-04
 */
public interface IPersonnelAppointRegisterService 
{
    /**
     * 查询人事任免_任免记录
     * 
     * @param registerId 人事任免_任免记录主键
     * @return 人事任免_任免记录
     */
    public PersonnelAppointRegister selectPersonnelAppointRegisterByRegisterId(Long registerId);

    /**
     * 查询人事任免_任免记录列表
     * 
     * @param personnelAppointRegister 人事任免_任免记录
     * @return 人事任免_任免记录集合
     */
    public List<PersonnelAppointRegister> selectPersonnelAppointRegisterList(PersonnelQueryDto personnelAppointRegister);

    /**
     * 新增人事任免_任免记录
     * 
     * @param personnelAppointRegister 人事任免_任免记录
     * @return 结果
     */
    public Long insertPersonnelAppointRegister(PersonnelAppointRegister personnelAppointRegister);

    /**
     * 修改人事任免_任免记录
     * 
     * @param personnelAppointRegister 人事任免_任免记录
     * @return 结果
     */
    public int updatePersonnelAppointRegister(PersonnelAppointRegister personnelAppointRegister);

    /**
     * 批量删除人事任免_任免记录
     * 
     * @param registerIds 需要删除的人事任免_任免记录主键集合
     * @return 结果
     */
    public int deletePersonnelAppointRegisterByRegisterIds(Long[] registerIds);

    /**
     * 删除人事任免_任免记录信息
     * 
     * @param registerId 人事任免_任免记录主键
     * @return 结果
     */
    public int deletePersonnelAppointRegisterByRegisterId(Long registerId);
}
