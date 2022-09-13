package com.shahenpc.system.service.budget.impl;

import java.math.BigDecimal;
import java.util.List;

import com.shahenpc.common.core.domain.AjaxResult;
import com.shahenpc.common.exception.ServiceException;
import com.shahenpc.common.utils.DateUtils;
import com.shahenpc.common.utils.StringUtils;
import com.shahenpc.common.utils.bean.BeanValidators;
import com.shahenpc.system.domain.budget.OutlayAlarm;
import com.shahenpc.system.domain.budget.OutlayBudget;
import com.shahenpc.system.domain.budget.dto.ActualListConutDto;
import com.shahenpc.system.domain.budget.dto.BudgetDto;
import com.shahenpc.system.domain.budget.dto.CountDto;
import com.shahenpc.system.domain.budget.dto.OutlayActualListDto;
import com.shahenpc.system.mapper.budget.OutlayAlarmMapper;
import com.shahenpc.system.mapper.budget.OutlayBudgetMapper;
import org.checkerframework.checker.units.qual.A;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shahenpc.system.mapper.budget.OutlayActualMapper;
import com.shahenpc.system.domain.budget.OutlayActual;
import com.shahenpc.system.service.budget.IOutlayActualService;

import javax.validation.Validator;

/**
 * 实际支出Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-07-01
 */
@Service
public class OutlayActualServiceImpl implements IOutlayActualService 
{
    @Autowired
    private OutlayActualMapper outlayActualMapper;
    @Autowired
    private OutlayBudgetMapper outlayBudgetMapper;
    @Autowired
    private OutlayAlarmMapper outlayAlarmMapper;
    @Autowired
    protected Validator validator;

    private static final Logger log = LoggerFactory.getLogger(OutlayActualServiceImpl.class);
    /**
     * 查询实际支出
     * 
     * @param actualId 实际支出主键
     * @return 实际支出
     */
    @Override
    public OutlayActual selectOutlayActualByActualId(Long actualId)
    {
        return outlayActualMapper.selectOutlayActualByActualId(actualId);
    }

    /**
     * 查询实际支出列表
     * 
     * @param outlayActual 实际支出
     * @return 实际支出
     */
    @Override
    public List<OutlayActual> selectOutlayActualList(OutlayActual outlayActual)
    {
        return outlayActualMapper.selectOutlayActualList(outlayActual);
    }

    /**
     * 新增实际支出
     * 
     * @param outlayActual 实际支出
     * @return 结果
     */
    @Override
    public AjaxResult insertOutlayActual(OutlayActual outlayActual)
    {
        outlayActual.setCreateTime(DateUtils.getNowDate());
        //查预计支出
        OutlayBudget budget=outlayBudgetMapper.selectUserByProjectNumben(outlayActual.getProjectNumber());
        if(budget != null) {
            //查找规则  预算执行金额
           /* if(budget.getAmount().compareTo(outlayActual.getAmount()) == -1){
                return AjaxResult.error("超出预算金额");
            }*/
                int success =  outlayActualMapper.insertOutlayActual(outlayActual);
                if((budget.getAmount().subtract(outlayActual.getAmount())).divide(budget.getAmount()).multiply(new BigDecimal(100)).compareTo(budget.getBeyondRatio()) == 1 ) {
                        OutlayAlarm alarm = new OutlayAlarm();
                        //实际id
                        alarm.setActualId(outlayActual.getActualId());
                        //预计id
                        alarm.setBudgetId(budget.getBudgetId());
                        //说明
                        alarm.setCause("实际支出 超出 预计支出 比例");
                        //预计设定 百分比
                        alarm.setSettingRatio(budget.getBeyondRatio());
                        //创建时间
                        alarm.setCreateTime(DateUtils.getNowDate());
                        //超出比例
                        BigDecimal Hundred = new BigDecimal(100);
                        alarm.setBeyondRatio((outlayActual.getAmount().subtract(budget.getAmount())).divide(budget.getAmount()).multiply( Hundred));
                        outlayAlarmMapper.insertOutlayAlarm(alarm);
                }
            //查出 规则
            return AjaxResult.success(success);
        }else{
            return AjaxResult.error("预算科目编码有误。");
        }
    }

    /**
     * 修改实际支出
     * 
     * @param outlayActual 实际支出
     * @return 结果
     */
    @Override
    public int updateOutlayActual(OutlayActual outlayActual)
    {
        outlayActual.setUpdateTime(DateUtils.getNowDate());
        return outlayActualMapper.updateOutlayActual(outlayActual);
    }

    /**
     * 批量删除实际支出
     * 
     * @param actualIds 需要删除的实际支出主键
     * @return 结果
     */
    @Override
    public int deleteOutlayActualByActualIds(Long[] actualIds)
    {
        return outlayActualMapper.deleteOutlayActualByActualIds(actualIds);
    }

    /**
     * 删除实际支出信息
     * 
     * @param actualId 实际支出主键
     * @return 结果
     */
    @Override
    public int deleteOutlayActualByActualId(Long actualId)
    {
        return outlayActualMapper.deleteOutlayActualByActualId(actualId);
    }


    @Override
    public ActualListConutDto listCount() {
        return outlayActualMapper.getListCount();
    }

    @Override
    public CountDto getCount() {
        return outlayActualMapper.selectByCountAndMonth();
    }

    @Override
    public String importOutlayActual(List<OutlayActual> outlayActualList, Boolean updateSupport, String operName) {
        if (StringUtils.isNull(outlayActualList) || outlayActualList.size() == 0)
        {
            throw new ServiceException("导入用户数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        for (OutlayActual user : outlayActualList)
        {
            try
            {
                // 验证是否存在这个用户
                OutlayBudget u = outlayBudgetMapper.selectUserByProjectNumben(user.getProjectNumber());
                if (StringUtils.isNull(u))
                {
                    user.setCreateBy(operName);
                    this.insertOutlayActual(user);
                    successNum++;
                }
                else if (updateSupport)
                {
                    BeanValidators.validateWithException(validator, user);
                    user.setUpdateBy(operName);
                    this.updateOutlayActual(user);
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


    @Override
    public List<OutlayActualListDto> newList(BudgetDto requst) {
        return outlayActualMapper.newList(requst);
    }
}
