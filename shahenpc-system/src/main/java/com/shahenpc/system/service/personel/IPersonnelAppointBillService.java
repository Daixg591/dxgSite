package com.shahenpc.system.service.personel;

import java.util.List;
import com.shahenpc.system.domain.personel.PersonnelAppointBill;

/**
 * 人事任免_议案提请Service接口
 * 
 * @author ruoyi
 * @date 2022-07-04
 */
public interface IPersonnelAppointBillService 
{
    /**
     * 查询人事任免_议案提请
     * 
     * @param billId 人事任免_议案提请主键
     * @return 人事任免_议案提请
     */
    public PersonnelAppointBill selectPersonnelAppointBillByBillId(Long billId);

    /**
     * 查询人事任免_议案提请列表
     * 
     * @param personnelAppointBill 人事任免_议案提请
     * @return 人事任免_议案提请集合
     */
    public List<PersonnelAppointBill> selectPersonnelAppointBillList(PersonnelAppointBill personnelAppointBill);

    /**
     * 新增人事任免_议案提请
     * 
     * @param personnelAppointBill 人事任免_议案提请
     * @return 结果
     */
    public int insertPersonnelAppointBill(PersonnelAppointBill personnelAppointBill);

    /**
     * 修改人事任免_议案提请
     * 
     * @param personnelAppointBill 人事任免_议案提请
     * @return 结果
     */
    public int updatePersonnelAppointBill(PersonnelAppointBill personnelAppointBill);

    /**
     * 批量删除人事任免_议案提请
     * 
     * @param billIds 需要删除的人事任免_议案提请主键集合
     * @return 结果
     */
    public int deletePersonnelAppointBillByBillIds(Long[] billIds);

    /**
     * 删除人事任免_议案提请信息
     * 
     * @param billId 人事任免_议案提请主键
     * @return 结果
     */
    public int deletePersonnelAppointBillByBillId(Long billId);
}
