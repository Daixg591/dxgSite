package com.shahenpc.system.mapper.personel;

import java.util.List;
import com.shahenpc.system.domain.personel.PersonnelAppointEvaluteRes;
import com.shahenpc.system.domain.personel.dto.PersonnelQueryDto;

/**
 * 人事任免_评议结果Mapper接口
 * 
 * @author ruoyi
 * @date 2022-07-07
 */
public interface PersonnelAppointEvaluteResMapper 
{
    /**
     * 查询人事任免_评议结果
     * 
     * @param resId 人事任免_评议结果主键
     * @return 人事任免_评议结果
     */
    public PersonnelAppointEvaluteRes selectPersonnelAppointEvaluteResByResId(Long resId);

    /**
     * 查询人事任免_评议结果列表
     * 
     * @param personnelAppointEvaluteRes 人事任免_评议结果
     * @return 人事任免_评议结果集合
     */
    public List<PersonnelAppointEvaluteRes> selectPersonnelAppointEvaluteResList(PersonnelQueryDto personnelAppointEvaluteRes);

    /**
     * 新增人事任免_评议结果
     * 
     * @param personnelAppointEvaluteRes 人事任免_评议结果
     * @return 结果
     */
    public int insertPersonnelAppointEvaluteRes(PersonnelAppointEvaluteRes personnelAppointEvaluteRes);

    /**
     * 修改人事任免_评议结果
     * 
     * @param personnelAppointEvaluteRes 人事任免_评议结果
     * @return 结果
     */
    public int updatePersonnelAppointEvaluteRes(PersonnelAppointEvaluteRes personnelAppointEvaluteRes);

    /**
     * 删除人事任免_评议结果
     * 
     * @param resId 人事任免_评议结果主键
     * @return 结果
     */
    public int deletePersonnelAppointEvaluteResByResId(Long resId);

    /**
     * 批量删除人事任免_评议结果
     * 
     * @param resIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deletePersonnelAppointEvaluteResByResIds(Long[] resIds);
}
