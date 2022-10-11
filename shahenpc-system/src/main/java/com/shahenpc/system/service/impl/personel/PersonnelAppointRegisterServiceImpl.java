package com.shahenpc.system.service.impl.personel;

import java.util.List;

import com.shahenpc.common.core.domain.entity.SysUser;
import com.shahenpc.common.exception.ServiceException;
import com.shahenpc.common.utils.DateUtils;
import com.shahenpc.common.utils.SecurityUtils;
import com.shahenpc.common.utils.StringUtils;
import com.shahenpc.common.utils.bean.BeanValidators;
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

    @Override
    public String importUser(List<PersonnelAppointRegister> userList, Boolean isUpdateSupport, String operName) {
        if (StringUtils.isNull(userList) || userList.size() == 0)
        {
            throw new ServiceException("导入用户数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        if (failureNum > 0)
        {
            failureMsg.insert(0, "很抱歉，导入失败！共 " + failureNum + " 条数据格式不正确，错误如下：");
            throw new ServiceException(failureMsg.toString());
        }
        else
        {
            successMsg.insert(0, "恭喜您，数据已全部导入成功！共 " + successNum + " 条，数据如下：");
        }
        return successMsg.toString();
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
