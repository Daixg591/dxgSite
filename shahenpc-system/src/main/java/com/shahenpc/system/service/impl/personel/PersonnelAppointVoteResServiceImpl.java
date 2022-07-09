package com.shahenpc.system.service.impl.personel;

import java.util.List;
import com.shahenpc.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shahenpc.system.mapper.personel.PersonnelAppointVoteResMapper;
import com.shahenpc.system.domain.personel.PersonnelAppointVoteRes;
import com.shahenpc.system.service.personel.IPersonnelAppointVoteResService;

/**
 * 人事任免_决结果Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-07-06
 */
@Service
public class PersonnelAppointVoteResServiceImpl implements IPersonnelAppointVoteResService 
{
    @Autowired
    private PersonnelAppointVoteResMapper personnelAppointVoteResMapper;

    /**
     * 查询人事任免_决结果
     * 
     * @param voteId 人事任免_决结果主键
     * @return 人事任免_决结果
     */
    @Override
    public PersonnelAppointVoteRes selectPersonnelAppointVoteResByVoteId(Long voteId)
    {
        return personnelAppointVoteResMapper.selectPersonnelAppointVoteResByVoteId(voteId);
    }

    /**
     * 查询人事任免_决结果列表
     * 
     * @param personnelAppointVoteRes 人事任免_决结果
     * @return 人事任免_决结果
     */
    @Override
    public List<PersonnelAppointVoteRes> selectPersonnelAppointVoteResList(PersonnelAppointVoteRes personnelAppointVoteRes)
    {

        return personnelAppointVoteResMapper.selectPersonnelAppointVoteResList(personnelAppointVoteRes);
    }

    /**
     * 新增人事任免_决结果
     * 
     * @param personnelAppointVoteRes 人事任免_决结果
     * @return 结果
     */
    @Override
    public int insertPersonnelAppointVoteRes(PersonnelAppointVoteRes personnelAppointVoteRes)
    {
        personnelAppointVoteRes.setCreateTime(DateUtils.getNowDate());
        return personnelAppointVoteResMapper.insertPersonnelAppointVoteRes(personnelAppointVoteRes);
    }

    /**
     * 修改人事任免_决结果
     * 
     * @param personnelAppointVoteRes 人事任免_决结果
     * @return 结果
     */
    @Override
    public int updatePersonnelAppointVoteRes(PersonnelAppointVoteRes personnelAppointVoteRes)
    {
        personnelAppointVoteRes.setUpdateTime(DateUtils.getNowDate());
        return personnelAppointVoteResMapper.updatePersonnelAppointVoteRes(personnelAppointVoteRes);
    }

    /**
     * 批量删除人事任免_决结果
     * 
     * @param voteIds 需要删除的人事任免_决结果主键
     * @return 结果
     */
    @Override
    public int deletePersonnelAppointVoteResByVoteIds(Long[] voteIds)
    {
        return personnelAppointVoteResMapper.deletePersonnelAppointVoteResByVoteIds(voteIds);
    }

    /**
     * 删除人事任免_决结果信息
     * 
     * @param voteId 人事任免_决结果主键
     * @return 结果
     */
    @Override
    public int deletePersonnelAppointVoteResByVoteId(Long voteId)
    {
        return personnelAppointVoteResMapper.deletePersonnelAppointVoteResByVoteId(voteId);
    }
}
