package com.shahenpc.system.service.impl.personel;

import java.util.List;
import com.shahenpc.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shahenpc.system.mapper.personel.PersonnelAppointBillMapper;
import com.shahenpc.system.domain.personel.PersonnelAppointBill;
import com.shahenpc.system.service.personel.IPersonnelAppointBillService;

/**
 * 人事任免_议案提请Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-07-04
 */
@Service
public class PersonnelAppointBillServiceImpl implements IPersonnelAppointBillService 
{
    @Autowired
    private PersonnelAppointBillMapper personnelAppointBillMapper;

    /**
     * 查询人事任免_议案提请
     * 
     * @param billId 人事任免_议案提请主键
     * @return 人事任免_议案提请
     */
    @Override
    public PersonnelAppointBill selectPersonnelAppointBillByBillId(Long billId)
    {
        return personnelAppointBillMapper.selectPersonnelAppointBillByBillId(billId);
    }

    /**
     * 查询人事任免_议案提请列表
     * 
     * @param personnelAppointBill 人事任免_议案提请
     * @return 人事任免_议案提请
     */
    @Override
    public List<PersonnelAppointBill> selectPersonnelAppointBillList(PersonnelAppointBill personnelAppointBill)
    {
        return personnelAppointBillMapper.selectPersonnelAppointBillList(personnelAppointBill);
    }

    /**
     * 新增人事任免_议案提请
     * 
     * @param personnelAppointBill 人事任免_议案提请
     * @return 结果
     */
    @Override
    public int insertPersonnelAppointBill(PersonnelAppointBill personnelAppointBill)
    {
        personnelAppointBill.setCreateTime(DateUtils.getNowDate());
        return personnelAppointBillMapper.insertPersonnelAppointBill(personnelAppointBill);
    }

    /**
     * 修改人事任免_议案提请
     * 
     * @param personnelAppointBill 人事任免_议案提请
     * @return 结果
     */
    @Override
    public int updatePersonnelAppointBill(PersonnelAppointBill personnelAppointBill)
    {
        personnelAppointBill.setUpdateTime(DateUtils.getNowDate());
        return personnelAppointBillMapper.updatePersonnelAppointBill(personnelAppointBill);
    }

    /**
     * 批量删除人事任免_议案提请
     * 
     * @param billIds 需要删除的人事任免_议案提请主键
     * @return 结果
     */
    @Override
    public int deletePersonnelAppointBillByBillIds(Long[] billIds)
    {
        return personnelAppointBillMapper.deletePersonnelAppointBillByBillIds(billIds);
    }

    /**
     * 删除人事任免_议案提请信息
     * 
     * @param billId 人事任免_议案提请主键
     * @return 结果
     */
    @Override
    public int deletePersonnelAppointBillByBillId(Long billId)
    {
        return personnelAppointBillMapper.deletePersonnelAppointBillByBillId(billId);
    }
}
