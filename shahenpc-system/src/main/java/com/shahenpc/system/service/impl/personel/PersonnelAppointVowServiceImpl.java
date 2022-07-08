package com.shahenpc.system.service.impl.personel;

import java.util.List;
import com.shahenpc.common.utils.DateUtils;
import com.shahenpc.system.domain.personel.dto.PersonnelQueryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shahenpc.system.mapper.personel.PersonnelAppointVowMapper;
import com.shahenpc.system.domain.personel.PersonnelAppointVow;
import com.shahenpc.system.service.personel.IPersonnelAppointVowService;

/**
 * 人事任免_向宪法发誓Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-07-06
 */
@Service
public class PersonnelAppointVowServiceImpl implements IPersonnelAppointVowService 
{
    @Autowired
    private PersonnelAppointVowMapper personnelAppointVowMapper;

    /**
     * 查询人事任免_向宪法发誓
     * 
     * @param registerId 人事任免_向宪法发誓主键
     * @return 人事任免_向宪法发誓
     */
    @Override
    public PersonnelAppointVow selectPersonnelAppointVowByVowId(Long registerId)
    {
        return personnelAppointVowMapper.selectPersonnelAppointVowByVowId(registerId);
    }

    /**
     * 查询人事任免_向宪法发誓列表
     * 
     * @param personnelAppointVow 人事任免_向宪法发誓
     * @return 人事任免_向宪法发誓
     */
    @Override
    public List<PersonnelAppointVow> selectPersonnelAppointVowList(PersonnelQueryDto personnelAppointVow)
    {
        return personnelAppointVowMapper.selectPersonnelAppointVowList(personnelAppointVow);
    }

    /**
     * 新增人事任免_向宪法发誓
     * 
     * @param personnelAppointVow 人事任免_向宪法发誓
     * @return 结果
     */
    @Override
    public int insertPersonnelAppointVow(PersonnelAppointVow personnelAppointVow)
    {
        personnelAppointVow.setCreateTime(DateUtils.getNowDate());
        return personnelAppointVowMapper.insertPersonnelAppointVow(personnelAppointVow);
    }

    /**
     * 修改人事任免_向宪法发誓
     * 
     * @param personnelAppointVow 人事任免_向宪法发誓
     * @return 结果
     */
    @Override
    public int updatePersonnelAppointVow(PersonnelAppointVow personnelAppointVow)
    {
        personnelAppointVow.setUpdateTime(DateUtils.getNowDate());
        return personnelAppointVowMapper.updatePersonnelAppointVow(personnelAppointVow);
    }

    /**
     * 批量删除人事任免_向宪法发誓
     * 
     * @param vowIds 需要删除的人事任免_向宪法发誓主键
     * @return 结果
     */
    @Override
    public int deletePersonnelAppointVowByVowIds(Long[] vowIds)
    {
        return personnelAppointVowMapper.deletePersonnelAppointVowByVowIds(vowIds);
    }

    /**
     * 删除人事任免_向宪法发誓信息
     * 
     * @param vowId 人事任免_向宪法发誓主键
     * @return 结果
     */
    @Override
    public int deletePersonnelAppointVowByVowId(Long vowId)
    {
        return personnelAppointVowMapper.deletePersonnelAppointVowByVowId(vowId);
    }
}
