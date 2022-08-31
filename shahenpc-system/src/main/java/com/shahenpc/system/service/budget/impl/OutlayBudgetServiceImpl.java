package com.shahenpc.system.service.budget.impl;

import java.util.List;

import com.shahenpc.common.exception.ServiceException;
import com.shahenpc.common.utils.DateUtils;
import com.shahenpc.common.utils.StringUtils;
import com.shahenpc.common.utils.bean.BeanValidators;
import com.shahenpc.system.domain.budget.OutlayBudgetRecord;
import com.shahenpc.system.domain.budget.dto.BudgetDto;
import com.shahenpc.system.domain.budget.dto.CountDto;
import com.shahenpc.system.mapper.budget.OutlayBudgetRecordMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shahenpc.system.mapper.budget.OutlayBudgetMapper;
import com.shahenpc.system.domain.budget.OutlayBudget;
import com.shahenpc.system.service.budget.IOutlayBudgetService;

import javax.validation.Validator;

/**
 * 预算Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-07-01
 */
@Service
public class OutlayBudgetServiceImpl implements IOutlayBudgetService 
{
    @Autowired
    private OutlayBudgetMapper outlayBudgetMapper;
    @Autowired
    protected Validator validator;
    @Autowired
    private OutlayBudgetRecordMapper outlayBudgetRecordMapper;
    private static final Logger log = LoggerFactory.getLogger(OutlayBudgetServiceImpl.class);
    /**
     * 查询预算
     * 
     * @param budgetId 预算主键
     * @return 预算
     */
    @Override
    public OutlayBudget selectOutlayBudgetByBudgetId(Long budgetId)
    {
        return outlayBudgetMapper.selectOutlayBudgetByBudgetId(budgetId);
    }

    /**
     * 查询预算列表
     * 
     * @param outlayBudget 预算
     * @return 预算
     */
    @Override
    public List<OutlayBudget> selectOutlayBudgetList(OutlayBudget outlayBudget)
    {
        return outlayBudgetMapper.selectOutlayBudgetList(outlayBudget);
    }

    /**
     * 新增预算
     * 
     * @param outlayBudget 预算
     * @return 结果
     */
    @Override
    public int insertOutlayBudget(OutlayBudget outlayBudget)
    {
        outlayBudget.setCreateTime(DateUtils.getNowDate());

        return outlayBudgetMapper.insertOutlayBudget(outlayBudget);
    }

    /**
     * 修改预算
     * 
     * @param outlayBudget 预算
     * @return 结果
     */
    @Override
    public int updateOutlayBudget(OutlayBudget outlayBudget)
    {
        outlayBudget.setUpdateTime(DateUtils.getNowDate());
        int update =  outlayBudgetMapper.updateOutlayBudget(outlayBudget);
        if( update != 0){
            OutlayBudgetRecord record =  new OutlayBudgetRecord();
            record.setBudgetId(outlayBudget.getBudgetId());
            record.setCreateBy(outlayBudget.getCreateBy());
            record.setCreateTime(DateUtils.getNowDate());
            record.setBeforeAmount(outlayBudget.getAmount());

            record.setChangeAmount(outlayBudget.getChangeAmount());
            record.setAfterAmount(outlayBudget.getAmount().add(outlayBudget.getChangeAmount()));

            outlayBudgetRecordMapper.insertOutlayBudgetRecord(record);
        }
        if(outlayBudget.getChangeAmount() != null){
            outlayBudget.setAfterAmount(outlayBudget.getAmount().add(outlayBudget.getChangeAmount()));
        }
        return outlayBudgetMapper.updateOutlayBudget(outlayBudget);
    }

    /**
     * 批量删除预算
     * 
     * @param budgetIds 需要删除的预算主键
     * @return 结果
     */
    @Override
    public int deleteOutlayBudgetByBudgetIds(Long[] budgetIds)
    {
        return outlayBudgetMapper.deleteOutlayBudgetByBudgetIds(budgetIds);
    }

    /**
     * 删除预算信息
     * 
     * @param budgetId 预算主键
     * @return 结果
     */
    @Override
    public int deleteOutlayBudgetByBudgetId(Long budgetId)
    {
        return outlayBudgetMapper.deleteOutlayBudgetByBudgetId(budgetId);
    }

    @Override
    public CountDto getCount() {
        return outlayBudgetMapper.selectByCountAndMonth();
    }

    @Override
    public String importOutlayBudget(List<OutlayBudget> outlayBudgetList, Boolean updateSupport, String operName) {
        if (StringUtils.isNull(outlayBudgetList) || outlayBudgetList.size() == 0)
        {
            throw new ServiceException("导入用户数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        for (OutlayBudget user : outlayBudgetList)
        {
            try
            {
                // 验证是否存在这个用户
                OutlayBudget u = outlayBudgetMapper.selectUserByProjectNumben(user.getProjectNumber());
                if (StringUtils.isNull(u))
                {
                    user.setCreateBy(operName);
                    this.insertOutlayBudget(user);
                    successNum++;
                }
                else if (updateSupport)
                {
                    BeanValidators.validateWithException(validator, user);
                    user.setUpdateBy(operName);
                    this.updateOutlayBudget(user);
                    successNum++;
                }
                else
                {
                    failureNum++;
                }
            }
            catch (Exception e)
            {
                failureNum++;
                String msg = "<br/>导入失败：";
                failureMsg.append(msg + e.getMessage());
                log.error(msg, e);
            }
        }
        return successMsg.toString();
    }

    @Override
    public List<OutlayBudget> newList(BudgetDto request) {
//        List<OutlayBudget> list= outlayBudgetMapper.newList(request);
//        for (OutlayBudget item:list){
//            if(item.getChangeAmount() != null){
//                OutlayBudget bu = new OutlayBudget();
//                bu.setBudgetId(item.getBudgetId());
//                bu.setAfterAmount(item.getAmount().subtract(item.getChangeAmount()));
//                outlayBudgetMapper.updateOutlayBudget(bu);
//            }
//        }
        return outlayBudgetMapper.newList(request);
    }

}
