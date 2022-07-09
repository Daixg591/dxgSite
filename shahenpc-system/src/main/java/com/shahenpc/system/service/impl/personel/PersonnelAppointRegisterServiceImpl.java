package com.shahenpc.system.service.impl.personel;

import java.util.Comparator;
import java.util.List;
import com.shahenpc.common.utils.DateUtils;
import com.shahenpc.system.domain.personel.dto.PersonnelQueryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shahenpc.system.mapper.personel.PersonnelAppointRegisterMapper;
import com.shahenpc.system.domain.personel.PersonnelAppointRegister;
import com.shahenpc.system.service.personel.IPersonnelAppointRegisterService;

/**
 * 人事任免_任免记录Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-07-04
 */
@Service
public class PersonnelAppointRegisterServiceImpl implements IPersonnelAppointRegisterService 
{
    @Autowired
    private PersonnelAppointRegisterMapper personnelAppointRegisterMapper;

    /**
     * 查询人事任免_任免记录
     * 
     * @param registerId 人事任免_任免记录主键
     * @return 人事任免_任免记录
     */
    @Override
    public PersonnelAppointRegister selectPersonnelAppointRegisterByRegisterId(Long registerId)
    {
        return personnelAppointRegisterMapper.selectPersonnelAppointRegisterByRegisterId(registerId);
    }

    /**
     * 查询人事任免_任免记录列表
     * 
     * @param personnelAppointRegister 人事任免_任免记录
     * @return 人事任免_任免记录
     */
    @Override
    public List<PersonnelAppointRegister> selectPersonnelAppointRegisterList(PersonnelQueryDto personnelAppointRegister)
    {
        List<PersonnelAppointRegister> list=personnelAppointRegisterMapper.selectPersonnelAppointRegisterList(personnelAppointRegister);
        for (PersonnelAppointRegister item:list) {
            item.setNickName(item.getSysUser().getNickName());
            item.setSex(item.getSysUser().getSex());
            item.setPhonenumber(item.getSysUser().getPhonenumber());
            item.setIdCard(item.getSysUser().getIdCard());
            item.setAppointType(item.getAppointType());
        }
        return list;
    }

    /**
     * 新增人事任免_任免记录
     * 
     * @param personnelAppointRegister 人事任免_任免记录
     * @return 结果
     */
    @Override
    public Long insertPersonnelAppointRegister(PersonnelAppointRegister personnelAppointRegister)
    {
        personnelAppointRegister.setCreateTime(DateUtils.getNowDate());
        Long id=personnelAppointRegisterMapper.insertPersonnelAppointRegister(personnelAppointRegister);
        return id;
    }

    /**
     * 修改人事任免_任免记录
     * 
     * @param personnelAppointRegister 人事任免_任免记录
     * @return 结果
     */
    @Override
    public int updatePersonnelAppointRegister(PersonnelAppointRegister personnelAppointRegister)
    {
        personnelAppointRegister.setUpdateTime(DateUtils.getNowDate());
        return personnelAppointRegisterMapper.updatePersonnelAppointRegister(personnelAppointRegister);
    }

    /**
     * 批量删除人事任免_任免记录
     * 
     * @param registerIds 需要删除的人事任免_任免记录主键
     * @return 结果
     */
    @Override
    public int deletePersonnelAppointRegisterByRegisterIds(Long[] registerIds)
    {
        return personnelAppointRegisterMapper.deletePersonnelAppointRegisterByRegisterIds(registerIds);
    }

    /**
     * 删除人事任免_任免记录信息
     * 
     * @param registerId 人事任免_任免记录主键
     * @return 结果
     */
    @Override
    public int deletePersonnelAppointRegisterByRegisterId(Long registerId)
    {
        return personnelAppointRegisterMapper.deletePersonnelAppointRegisterByRegisterId(registerId);
    }
}
