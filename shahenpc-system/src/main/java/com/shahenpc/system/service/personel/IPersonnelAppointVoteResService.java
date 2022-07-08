package com.shahenpc.system.service.personel;

import java.util.List;
import com.shahenpc.system.domain.personel.PersonnelAppointVoteRes;

/**
 * 人事任免_决结果Service接口
 * 
 * @author ruoyi
 * @date 2022-07-06
 */
public interface IPersonnelAppointVoteResService 
{
    /**
     * 查询人事任免_决结果
     * 
     * @param voteId 人事任免_决结果主键
     * @return 人事任免_决结果
     */
    public PersonnelAppointVoteRes selectPersonnelAppointVoteResByVoteId(Long voteId);

    /**
     * 查询人事任免_决结果列表
     * 
     * @param personnelAppointVoteRes 人事任免_决结果
     * @return 人事任免_决结果集合
     */
    public List<PersonnelAppointVoteRes> selectPersonnelAppointVoteResList(PersonnelAppointVoteRes personnelAppointVoteRes);

    /**
     * 新增人事任免_决结果
     * 
     * @param personnelAppointVoteRes 人事任免_决结果
     * @return 结果
     */
    public int insertPersonnelAppointVoteRes(PersonnelAppointVoteRes personnelAppointVoteRes);

    /**
     * 修改人事任免_决结果
     * 
     * @param personnelAppointVoteRes 人事任免_决结果
     * @return 结果
     */
    public int updatePersonnelAppointVoteRes(PersonnelAppointVoteRes personnelAppointVoteRes);

    /**
     * 批量删除人事任免_决结果
     * 
     * @param voteIds 需要删除的人事任免_决结果主键集合
     * @return 结果
     */
    public int deletePersonnelAppointVoteResByVoteIds(Long[] voteIds);

    /**
     * 删除人事任免_决结果信息
     * 
     * @param voteId 人事任免_决结果主键
     * @return 结果
     */
    public int deletePersonnelAppointVoteResByVoteId(Long voteId);
}
