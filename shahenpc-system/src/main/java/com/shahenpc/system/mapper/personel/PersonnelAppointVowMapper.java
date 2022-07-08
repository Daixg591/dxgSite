package com.shahenpc.system.mapper.personel;

import java.util.List;
import com.shahenpc.system.domain.personel.PersonnelAppointVow;
import com.shahenpc.system.domain.personel.dto.PersonnelQueryDto;

/**
 * 人事任免_向宪法发誓Mapper接口
 * 
 * @author ruoyi
 * @date 2022-07-06
 */
public interface PersonnelAppointVowMapper 
{
    /**
     * 查询人事任免_向宪法发誓
     * 
     * @param registerId 人事任免_向宪法发誓主键
     * @return 人事任免_向宪法发誓
     */
    public PersonnelAppointVow selectPersonnelAppointVowByVowId(Long registerId);

    /**
     * 查询人事任免_向宪法发誓列表
     * 
     * @param personnelAppointVow 人事任免_向宪法发誓
     * @return 人事任免_向宪法发誓集合
     */
    public List<PersonnelAppointVow> selectPersonnelAppointVowList(PersonnelQueryDto personnelAppointVow);

    /**
     * 新增人事任免_向宪法发誓
     * 
     * @param personnelAppointVow 人事任免_向宪法发誓
     * @return 结果
     */
    public int insertPersonnelAppointVow(PersonnelAppointVow personnelAppointVow);

    /**
     * 修改人事任免_向宪法发誓
     * 
     * @param personnelAppointVow 人事任免_向宪法发誓
     * @return 结果
     */
    public int updatePersonnelAppointVow(PersonnelAppointVow personnelAppointVow);

    /**
     * 删除人事任免_向宪法发誓
     * 
     * @param vowId 人事任免_向宪法发誓主键
     * @return 结果
     */
    public int deletePersonnelAppointVowByVowId(Long vowId);

    /**
     * 批量删除人事任免_向宪法发誓
     * 
     * @param vowIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deletePersonnelAppointVowByVowIds(Long[] vowIds);
}
