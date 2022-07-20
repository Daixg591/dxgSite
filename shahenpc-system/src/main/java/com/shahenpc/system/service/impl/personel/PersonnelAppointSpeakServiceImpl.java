package com.shahenpc.system.service.impl.personel;

import java.util.List;
import com.shahenpc.common.utils.DateUtils;
import com.shahenpc.system.domain.personel.dto.PersonnelQueryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shahenpc.system.mapper.personel.PersonnelAppointSpeakMapper;
import com.shahenpc.system.domain.personel.PersonnelAppointSpeak;
import com.shahenpc.system.service.personel.IPersonnelAppointSpeakService;

/**
 * 人事任免_拟任职发言Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-07-04
 */
@Service
public class PersonnelAppointSpeakServiceImpl implements IPersonnelAppointSpeakService 
{
    @Autowired
    private PersonnelAppointSpeakMapper personnelAppointSpeakMapper;

    /**
     * 查询人事任免_拟任职发言
     * 
     * @param registerId 人事任免_拟任职发言主键
     * @return 人事任免_拟任职发言
     */
    @Override
    public PersonnelAppointSpeak selectPersonnelAppointSpeakBySpeakId(Long registerId)
    {
        return personnelAppointSpeakMapper.selectPersonnelAppointSpeakBySpeakId(registerId);
    }

    /**
     * 查询人事任免_拟任职发言列表
     * 
     * @param personnelAppointSpeak 人事任免_拟任职发言
     * @return 人事任免_拟任职发言
     */
    @Override
    public List<PersonnelAppointSpeak> selectPersonnelAppointSpeakList(PersonnelQueryDto personnelAppointSpeak)
    {
        List<PersonnelAppointSpeak> list=personnelAppointSpeakMapper.selectPersonnelAppointSpeakList(personnelAppointSpeak);
        for (PersonnelAppointSpeak item : list) {
            item.setNickName(item.getSysUser().getNickName());
            item.setSex(item.getSysUser().getSex());
            item.setPhonenumber(item.getSysUser().getPhonenumber());
            item.setIdCard(item.getSysUser().getIdCard());
            item.setAppointType(item.getAppointType());
        }
        return list;
    }

    /**
     * 新增人事任免_拟任职发言
     * 
     * @param personnelAppointSpeak 人事任免_拟任职发言
     * @return 结果
     */
    @Override
    public int insertPersonnelAppointSpeak(PersonnelAppointSpeak personnelAppointSpeak)
    {
        personnelAppointSpeak.setCreateTime(DateUtils.getNowDate());
        return personnelAppointSpeakMapper.insertPersonnelAppointSpeak(personnelAppointSpeak);
    }

    /**
     * 修改人事任免_拟任职发言
     * 
     * @param personnelAppointSpeak 人事任免_拟任职发言
     * @return 结果
     */
    @Override
    public int updatePersonnelAppointSpeak(PersonnelAppointSpeak personnelAppointSpeak)
    {
        personnelAppointSpeak.setUpdateTime(DateUtils.getNowDate());
        return personnelAppointSpeakMapper.updatePersonnelAppointSpeak(personnelAppointSpeak);
    }

    /**
     * 批量删除人事任免_拟任职发言
     * 
     * @param registerIds 需要删除的人事任免_拟任职发言主键
     * @return 结果
     */
    @Override
    public int deletePersonnelAppointSpeakBySpeakIds(Long[] registerIds)
    {
        return personnelAppointSpeakMapper.deletePersonnelAppointSpeakBySpeakIds(registerIds);
    }

    /**
     * 删除人事任免_拟任职发言信息
     * 
     * @param speakId 人事任免_拟任职发言主键
     * @return 结果
     */
    @Override
    public int deletePersonnelAppointSpeakBySpeakId(Long speakId)
    {
        return personnelAppointSpeakMapper.deletePersonnelAppointSpeakBySpeakId(speakId);
    }
}
