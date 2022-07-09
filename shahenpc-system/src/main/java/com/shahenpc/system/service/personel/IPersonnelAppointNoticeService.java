package com.shahenpc.system.service.personel;

import java.util.List;
import com.shahenpc.system.domain.personel.PersonnelAppointNotice;

/**
 * 人事任免_任免通知Service接口
 * 
 * @author ruoyi
 * @date 2022-07-08
 */
public interface IPersonnelAppointNoticeService 
{
    /**
     * 查询人事任免_任免通知
     * 
     * @param noticeId 人事任免_任免通知主键
     * @return 人事任免_任免通知
     */
    public PersonnelAppointNotice selectPersonnelAppointNoticeByNoticeId(Long noticeId);

    public PersonnelAppointNotice selectDetailByNoticeId(Long noticeId);

    /**
     * 查询人事任免_任免通知列表
     * 
     * @param personnelAppointNotice 人事任免_任免通知
     * @return 人事任免_任免通知集合
     */
    public List<PersonnelAppointNotice> selectPersonnelAppointNoticeList(PersonnelAppointNotice personnelAppointNotice);

    /**
     * 新增人事任免_任免通知
     * 
     * @param personnelAppointNotice 人事任免_任免通知
     * @return 结果
     */
    public int insertPersonnelAppointNotice(PersonnelAppointNotice personnelAppointNotice);

    /**
     * 修改人事任免_任免通知
     * 
     * @param personnelAppointNotice 人事任免_任免通知
     * @return 结果
     */
    public int updatePersonnelAppointNotice(PersonnelAppointNotice personnelAppointNotice);

    /**
     * 批量删除人事任免_任免通知
     * 
     * @param noticeIds 需要删除的人事任免_任免通知主键集合
     * @return 结果
     */
    public int deletePersonnelAppointNoticeByNoticeIds(Long[] noticeIds);

    /**
     * 删除人事任免_任免通知信息
     * 
     * @param noticeId 人事任免_任免通知主键
     * @return 结果
     */
    public int deletePersonnelAppointNoticeByNoticeId(Long noticeId);
}
