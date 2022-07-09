package com.shahenpc.system.service.impl.personel;

import java.util.List;
import com.shahenpc.common.utils.DateUtils;
import com.shahenpc.system.domain.personel.PersonnelAppointBill;
import com.shahenpc.system.domain.personel.dto.PersonnelQueryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shahenpc.system.mapper.personel.PersonnelAppointEvaluteResMapper;
import com.shahenpc.system.domain.personel.PersonnelAppointEvaluteRes;
import com.shahenpc.system.service.personel.IPersonnelAppointEvaluteResService;

/**
 * 人事任免_评议结果Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-07-07
 */
@Service
public class PersonnelAppointEvaluteResServiceImpl implements IPersonnelAppointEvaluteResService 
{
    @Autowired
    private PersonnelAppointEvaluteResMapper personnelAppointEvaluteResMapper;

    /**
     * 查询人事任免_评议结果
     * 
     * @param resId 人事任免_评议结果主键
     * @return 人事任免_评议结果
     */
    @Override
    public PersonnelAppointEvaluteRes selectPersonnelAppointEvaluteResByResId(Long resId)
    {
        return personnelAppointEvaluteResMapper.selectPersonnelAppointEvaluteResByResId(resId);
    }

    /**
     * 查询人事任免_评议结果列表
     * 
     * @param personnelAppointEvaluteRes 人事任免_评议结果
     * @return 人事任免_评议结果
     */
    @Override
    public List<PersonnelAppointEvaluteRes> selectPersonnelAppointEvaluteResList(PersonnelQueryDto personnelAppointEvaluteRes)
    {
        List<PersonnelAppointEvaluteRes> list= personnelAppointEvaluteResMapper.selectPersonnelAppointEvaluteResList(personnelAppointEvaluteRes);
        for (PersonnelAppointEvaluteRes item : list) {
            item.setNickName(item.getSysUser().getNickName());
            item.setSex(item.getSysUser().getSex());
            item.setPhonenumber(item.getSysUser().getPhonenumber());
            item.setIdCard(item.getSysUser().getIdCard());
            item.setAppointType(item.getAppointType());
        }
        return list;
    }

    /**
     * 新增人事任免_评议结果
     * 
     * @param personnelAppointEvaluteRes 人事任免_评议结果
     * @return 结果
     */
    @Override
    public int insertPersonnelAppointEvaluteRes(PersonnelAppointEvaluteRes personnelAppointEvaluteRes)
    {
        personnelAppointEvaluteRes.setCreateTime(DateUtils.getNowDate());
        return personnelAppointEvaluteResMapper.insertPersonnelAppointEvaluteRes(personnelAppointEvaluteRes);
    }

    /**
     * 修改人事任免_评议结果
     * 
     * @param personnelAppointEvaluteRes 人事任免_评议结果
     * @return 结果
     */
    @Override
    public int updatePersonnelAppointEvaluteRes(PersonnelAppointEvaluteRes personnelAppointEvaluteRes)
    {
        personnelAppointEvaluteRes.setUpdateTime(DateUtils.getNowDate());
        return personnelAppointEvaluteResMapper.updatePersonnelAppointEvaluteRes(personnelAppointEvaluteRes);
    }

    /**
     * 批量删除人事任免_评议结果
     * 
     * @param resIds 需要删除的人事任免_评议结果主键
     * @return 结果
     */
    @Override
    public int deletePersonnelAppointEvaluteResByResIds(Long[] resIds)
    {
        return personnelAppointEvaluteResMapper.deletePersonnelAppointEvaluteResByResIds(resIds);
    }

    /**
     * 删除人事任免_评议结果信息
     * 
     * @param resId 人事任免_评议结果主键
     * @return 结果
     */
    @Override
    public int deletePersonnelAppointEvaluteResByResId(Long resId)
    {
        return personnelAppointEvaluteResMapper.deletePersonnelAppointEvaluteResByResId(resId);
    }
}
