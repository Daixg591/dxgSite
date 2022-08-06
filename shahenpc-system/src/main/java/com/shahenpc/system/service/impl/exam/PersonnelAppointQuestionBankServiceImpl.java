package com.shahenpc.system.service.impl.exam;

import java.util.List;
import com.shahenpc.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shahenpc.system.mapper.exam.PersonnelAppointQuestionBankMapper;
import com.shahenpc.system.domain.exam.PersonnelAppointQuestionBank;
import com.shahenpc.system.service.exam.IPersonnelAppointQuestionBankService;

/**
 * 人事任免_法律知识考试_题库管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-07-27
 */
@Service
public class PersonnelAppointQuestionBankServiceImpl implements IPersonnelAppointQuestionBankService 
{
    @Autowired
    private PersonnelAppointQuestionBankMapper personnelAppointQuestionBankMapper;

    /**
     * 查询人事任免_法律知识考试_题库管理
     * 
     * @param questionBankId 人事任免_法律知识考试_题库管理主键
     * @return 人事任免_法律知识考试_题库管理
     */
    @Override
    public PersonnelAppointQuestionBank selectPersonnelAppointQuestionBankByQuestionBankId(Long questionBankId)
    {
        return personnelAppointQuestionBankMapper.selectPersonnelAppointQuestionBankByQuestionBankId(questionBankId);
    }

    /**
     * 查询人事任免_法律知识考试_题库管理列表
     * 
     * @param personnelAppointQuestionBank 人事任免_法律知识考试_题库管理
     * @return 人事任免_法律知识考试_题库管理
     */
    @Override
    public List<PersonnelAppointQuestionBank> selectPersonnelAppointQuestionBankList(PersonnelAppointQuestionBank personnelAppointQuestionBank)
    {
        return personnelAppointQuestionBankMapper.selectPersonnelAppointQuestionBankList(personnelAppointQuestionBank);
    }

    /**
     * 新增人事任免_法律知识考试_题库管理
     * 
     * @param personnelAppointQuestionBank 人事任免_法律知识考试_题库管理
     * @return 结果
     */
    @Override
    public int insertPersonnelAppointQuestionBank(PersonnelAppointQuestionBank personnelAppointQuestionBank)
    {
        personnelAppointQuestionBank.setCreateTime(DateUtils.getNowDate());
        return personnelAppointQuestionBankMapper.insertPersonnelAppointQuestionBank(personnelAppointQuestionBank);
    }

    /**
     * 修改人事任免_法律知识考试_题库管理
     * 
     * @param personnelAppointQuestionBank 人事任免_法律知识考试_题库管理
     * @return 结果
     */
    @Override
    public int updatePersonnelAppointQuestionBank(PersonnelAppointQuestionBank personnelAppointQuestionBank)
    {
        personnelAppointQuestionBank.setUpdateTime(DateUtils.getNowDate());
        return personnelAppointQuestionBankMapper.updatePersonnelAppointQuestionBank(personnelAppointQuestionBank);
    }

    /**
     * 批量删除人事任免_法律知识考试_题库管理
     * 
     * @param questionBankIds 需要删除的人事任免_法律知识考试_题库管理主键
     * @return 结果
     */
    @Override
    public int deletePersonnelAppointQuestionBankByQuestionBankIds(Long[] questionBankIds)
    {
        return personnelAppointQuestionBankMapper.deletePersonnelAppointQuestionBankByQuestionBankIds(questionBankIds);
    }

    /**
     * 删除人事任免_法律知识考试_题库管理信息
     * 
     * @param questionBankId 人事任免_法律知识考试_题库管理主键
     * @return 结果
     */
    @Override
    public int deletePersonnelAppointQuestionBankByQuestionBankId(Long questionBankId)
    {
        return personnelAppointQuestionBankMapper.deletePersonnelAppointQuestionBankByQuestionBankId(questionBankId);
    }
}
