package com.shahenpc.system.service.exam;

import java.util.List;
import com.shahenpc.system.domain.exam.PersonnelAppointPaperQuestionItem;

/**
 * 人事任免_法律知识考试_小题集合Service接口
 * 
 * @author ruoyi
 * @date 2022-07-27
 */
public interface IPersonnelAppointPaperQuestionItemService 
{
    /**
     * 查询人事任免_法律知识考试_小题集合
     * 
     * @param quItemId 人事任免_法律知识考试_小题集合主键
     * @return 人事任免_法律知识考试_小题集合
     */
    public PersonnelAppointPaperQuestionItem selectPersonnelAppointPaperQuestionItemByQuItemId(Long quItemId);

    /**
     * 查询人事任免_法律知识考试_小题集合列表
     * 
     * @param personnelAppointPaperQuestionItem 人事任免_法律知识考试_小题集合
     * @return 人事任免_法律知识考试_小题集合集合
     */
    public List<PersonnelAppointPaperQuestionItem> selectPersonnelAppointPaperQuestionItemList(PersonnelAppointPaperQuestionItem personnelAppointPaperQuestionItem);

    /**
     * 新增人事任免_法律知识考试_小题集合
     * 
     * @param personnelAppointPaperQuestionItem 人事任免_法律知识考试_小题集合
     * @return 结果
     */
    public int insertPersonnelAppointPaperQuestionItem(PersonnelAppointPaperQuestionItem personnelAppointPaperQuestionItem);

    /**
     * 修改人事任免_法律知识考试_小题集合
     * 
     * @param personnelAppointPaperQuestionItem 人事任免_法律知识考试_小题集合
     * @return 结果
     */
    public int updatePersonnelAppointPaperQuestionItem(PersonnelAppointPaperQuestionItem personnelAppointPaperQuestionItem);

    /**
     * 批量删除人事任免_法律知识考试_小题集合
     * 
     * @param quItemIds 需要删除的人事任免_法律知识考试_小题集合主键集合
     * @return 结果
     */
    public int deletePersonnelAppointPaperQuestionItemByQuItemIds(Long[] quItemIds);

    /**
     * 删除人事任免_法律知识考试_小题集合信息
     * 
     * @param quItemId 人事任免_法律知识考试_小题集合主键
     * @return 结果
     */
    public int deletePersonnelAppointPaperQuestionItemByQuItemId(Long quItemId);
}
