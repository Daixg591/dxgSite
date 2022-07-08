package com.shahenpc.system.service.impl.personel;

import java.util.List;
import com.shahenpc.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shahenpc.system.mapper.personel.PersonnelAppointNoticeMapper;
import com.shahenpc.system.domain.personel.PersonnelAppointNotice;
import com.shahenpc.system.service.personel.IPersonnelAppointNoticeService;

/**
 * 人事任免_任免通知Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-07-08
 */
@Service
public class PersonnelAppointNoticeServiceImpl implements IPersonnelAppointNoticeService 
{
    @Autowired
    private PersonnelAppointNoticeMapper personnelAppointNoticeMapper;

    /**
     * 查询人事任免_任免通知
     * 
     * @param noticeId 人事任免_任免通知主键
     * @return 人事任免_任免通知
     */
    @Override
    public PersonnelAppointNotice selectPersonnelAppointNoticeByNoticeId(Long noticeId)
    {
        return personnelAppointNoticeMapper.selectPersonnelAppointNoticeByNoticeId(noticeId);
    }

    /**
     * 查询人事任免_任免通知列表
     * 
     * @param personnelAppointNotice 人事任免_任免通知
     * @return 人事任免_任免通知
     */
    @Override
    public List<PersonnelAppointNotice> selectPersonnelAppointNoticeList(PersonnelAppointNotice personnelAppointNotice)
    {
        return personnelAppointNoticeMapper.selectPersonnelAppointNoticeList(personnelAppointNotice);
    }

    /**
     * 新增人事任免_任免通知
     * 
     * @param personnelAppointNotice 人事任免_任免通知
     * @return 结果
     */
    @Override
    public int insertPersonnelAppointNotice(PersonnelAppointNotice personnelAppointNotice)
    {
        personnelAppointNotice.setCreateTime(DateUtils.getNowDate());
        return personnelAppointNoticeMapper.insertPersonnelAppointNotice(personnelAppointNotice);
    }

    /**
     * 修改人事任免_任免通知
     * 
     * @param personnelAppointNotice 人事任免_任免通知
     * @return 结果
     */
    @Override
    public int updatePersonnelAppointNotice(PersonnelAppointNotice personnelAppointNotice)
    {
        personnelAppointNotice.setUpdateTime(DateUtils.getNowDate());
        return personnelAppointNoticeMapper.updatePersonnelAppointNotice(personnelAppointNotice);
    }

    /**
     * 批量删除人事任免_任免通知
     * 
     * @param noticeIds 需要删除的人事任免_任免通知主键
     * @return 结果
     */
    @Override
    public int deletePersonnelAppointNoticeByNoticeIds(Long[] noticeIds)
    {
        return personnelAppointNoticeMapper.deletePersonnelAppointNoticeByNoticeIds(noticeIds);
    }

    /**
     * 删除人事任免_任免通知信息
     * 
     * @param noticeId 人事任免_任免通知主键
     * @return 结果
     */
    @Override
    public int deletePersonnelAppointNoticeByNoticeId(Long noticeId)
    {
        return personnelAppointNoticeMapper.deletePersonnelAppointNoticeByNoticeId(noticeId);
    }
}
