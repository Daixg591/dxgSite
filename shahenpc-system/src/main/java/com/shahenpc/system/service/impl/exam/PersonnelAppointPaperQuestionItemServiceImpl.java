package com.shahenpc.system.service.impl.exam;

import java.util.List;
import com.shahenpc.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shahenpc.system.mapper.exam.PersonnelAppointPaperQuestionItemMapper;
import com.shahenpc.system.domain.exam.PersonnelAppointPaperQuestionItem;
import com.shahenpc.system.service.exam.IPersonnelAppointPaperQuestionItemService;

/**
 * 人事任免_法律知识考试_小题集合Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-07-27
 */
@Service
public class PersonnelAppointPaperQuestionItemServiceImpl implements IPersonnelAppointPaperQuestionItemService 
{
    @Autowired
    private PersonnelAppointPaperQuestionItemMapper personnelAppointPaperQuestionItemMapper;

    /**
     * 查询人事任免_法律知识考试_小题集合
     * 
     * @param quItemId 人事任免_法律知识考试_小题集合主键
     * @return 人事任免_法律知识考试_小题集合
     */
    @Override
    public PersonnelAppointPaperQuestionItem selectPersonnelAppointPaperQuestionItemByQuItemId(Long quItemId)
    {
        return personnelAppointPaperQuestionItemMapper.selectPersonnelAppointPaperQuestionItemByQuItemId(quItemId);
    }

    /**
     * 查询人事任免_法律知识考试_小题集合列表
     * 
     * @param personnelAppointPaperQuestionItem 人事任免_法律知识考试_小题集合
     * @return 人事任免_法律知识考试_小题集合
     */
    @Override
    public List<PersonnelAppointPaperQuestionItem> selectPersonnelAppointPaperQuestionItemList(PersonnelAppointPaperQuestionItem personnelAppointPaperQuestionItem)
    {
        return personnelAppointPaperQuestionItemMapper.selectPersonnelAppointPaperQuestionItemList(personnelAppointPaperQuestionItem);
    }

    /**
     * 新增人事任免_法律知识考试_小题集合
     * 
     * @param personnelAppointPaperQuestionItem 人事任免_法律知识考试_小题集合
     * @return 结果
     */
    @Override
    public int insertPersonnelAppointPaperQuestionItem(PersonnelAppointPaperQuestionItem personnelAppointPaperQuestionItem)
    {
        personnelAppointPaperQuestionItem.setCreateTime(DateUtils.getNowDate());
        return personnelAppointPaperQuestionItemMapper.insertPersonnelAppointPaperQuestionItem(personnelAppointPaperQuestionItem);
    }

    /**
     * 修改人事任免_法律知识考试_小题集合
     * 
     * @param personnelAppointPaperQuestionItem 人事任免_法律知识考试_小题集合
     * @return 结果
     */
    @Override
    public int updatePersonnelAppointPaperQuestionItem(PersonnelAppointPaperQuestionItem personnelAppointPaperQuestionItem)
    {
        personnelAppointPaperQuestionItem.setUpdateTime(DateUtils.getNowDate());
        return personnelAppointPaperQuestionItemMapper.updatePersonnelAppointPaperQuestionItem(personnelAppointPaperQuestionItem);
    }

    /**
     * 批量删除人事任免_法律知识考试_小题集合
     * 
     * @param quItemIds 需要删除的人事任免_法律知识考试_小题集合主键
     * @return 结果
     */
    @Override
    public int deletePersonnelAppointPaperQuestionItemByQuItemIds(Long[] quItemIds)
    {
        return personnelAppointPaperQuestionItemMapper.deletePersonnelAppointPaperQuestionItemByQuItemIds(quItemIds);
    }

    /**
     * 删除人事任免_法律知识考试_小题集合信息
     * 
     * @param quItemId 人事任免_法律知识考试_小题集合主键
     * @return 结果
     */
    @Override
    public int deletePersonnelAppointPaperQuestionItemByQuItemId(Long quItemId)
    {
        return personnelAppointPaperQuestionItemMapper.deletePersonnelAppointPaperQuestionItemByQuItemId(quItemId);
    }
}
