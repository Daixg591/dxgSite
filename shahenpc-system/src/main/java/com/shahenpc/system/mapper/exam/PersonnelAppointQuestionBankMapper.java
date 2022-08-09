package com.shahenpc.system.mapper.exam;

import java.util.List;
import com.shahenpc.system.domain.exam.PersonnelAppointQuestionBank;

/**
 * 人事任免_法律知识考试_题库管理Mapper接口
 * 
 * @author ruoyi
 * @date 2022-07-27
 */
public interface PersonnelAppointQuestionBankMapper 
{
    /**
     * 查询人事任免_法律知识考试_题库管理
     * 
     * @param questionBankId 人事任免_法律知识考试_题库管理主键
     * @return 人事任免_法律知识考试_题库管理
     */
    public PersonnelAppointQuestionBank selectPersonnelAppointQuestionBankByQuestionBankId(Long questionBankId);

    /**
     * 查询人事任免_法律知识考试_题库管理列表
     * 
     * @param personnelAppointQuestionBank 人事任免_法律知识考试_题库管理
     * @return 人事任免_法律知识考试_题库管理集合
     */
    public List<PersonnelAppointQuestionBank> selectPersonnelAppointQuestionBankList(PersonnelAppointQuestionBank personnelAppointQuestionBank);

    /**
     * 新增人事任免_法律知识考试_题库管理
     * 
     * @param personnelAppointQuestionBank 人事任免_法律知识考试_题库管理
     * @return 结果
     */
    public int insertPersonnelAppointQuestionBank(PersonnelAppointQuestionBank personnelAppointQuestionBank);

    /**
     * 修改人事任免_法律知识考试_题库管理
     * 
     * @param personnelAppointQuestionBank 人事任免_法律知识考试_题库管理
     * @return 结果
     */
    public int updatePersonnelAppointQuestionBank(PersonnelAppointQuestionBank personnelAppointQuestionBank);

    /**
     * 删除人事任免_法律知识考试_题库管理
     * 
     * @param questionBankId 人事任免_法律知识考试_题库管理主键
     * @return 结果
     */
    public int deletePersonnelAppointQuestionBankByQuestionBankId(Long questionBankId);

    /**
     * 批量删除人事任免_法律知识考试_题库管理
     * 
     * @param questionBankIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deletePersonnelAppointQuestionBankByQuestionBankIds(Long[] questionBankIds);
}