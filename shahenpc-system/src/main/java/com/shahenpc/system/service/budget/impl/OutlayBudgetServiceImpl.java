package com.shahenpc.system.service.budget.impl;

import java.util.List;

import com.shahenpc.common.exception.ServiceException;
import com.shahenpc.common.utils.DateUtils;
import com.shahenpc.common.utils.StringUtils;
import com.shahenpc.common.utils.bean.BeanValidators;
import com.shahenpc.system.domain.budget.dto.CountDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shahenpc.system.mapper.budget.OutlayBudgetMapper;
import com.shahenpc.system.domain.budget.OutlayBudget;
import com.shahenpc.system.service.budget.IOutlayBudgetService;
import org.springframework.transaction.annotation.Transactional;

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
        if (failureNum > 0)
        {
            failureMsg.insert(0, "很抱歉，导入失败！共 " + failureNum + " 条数据格式不正确，错误如下：");
            throw new ServiceException(failureMsg.toString());
        }
        else
        {
            successMsg.insert(0, "恭喜您，数据已全部导入成功！共 " + successNum + " 条，数据如下：");
        }
        return successMsg.toString();
    }

}
