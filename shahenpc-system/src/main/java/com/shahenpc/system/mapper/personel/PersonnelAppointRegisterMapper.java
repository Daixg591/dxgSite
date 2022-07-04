package com.shahenpc.system.mapper.personel;

import java.util.List;
import com.shahenpc.system.domain.personel.PersonnelAppointRegister;

/**
 * 人事任免_任免记录Mapper接口
 * 
 * @author ruoyi
 * @date 2022-07-04
 */
public interface PersonnelAppointRegisterMapper 
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
    public List<PersonnelAppointRegister> selectPersonnelAppointRegisterList(PersonnelAppointRegister personnelAppointRegister);

    /**
     * 新增人事任免_任免记录
     * 
     * @param personnelAppointRegister 人事任免_任免记录
     * @return 结果
     */
    public int insertPersonnelAppointRegister(PersonnelAppointRegister personnelAppointRegister);

    /**
     * 修改人事任免_任免记录
     * 
     * @param personnelAppointRegister 人事任免_任免记录
     * @return 结果
     */
    public int updatePersonnelAppointRegister(PersonnelAppointRegister personnelAppointRegister);

    /**
     * 删除人事任免_任免记录
     * 
     * @param registerId 人事任免_任免记录主键
     * @return 结果
     */
    public int deletePersonnelAppointRegisterByRegisterId(Long registerId);

    /**
     * 批量删除人事任免_任免记录
     * 
     * @param registerIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deletePersonnelAppointRegisterByRegisterIds(Long[] registerIds);
}
