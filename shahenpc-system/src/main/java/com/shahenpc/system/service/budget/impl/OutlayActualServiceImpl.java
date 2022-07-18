package com.shahenpc.system.service.budget.impl;

import java.math.BigDecimal;
import java.util.List;

import com.shahenpc.common.exception.ServiceException;
import com.shahenpc.common.utils.DateUtils;
import com.shahenpc.common.utils.StringUtils;
import com.shahenpc.common.utils.bean.BeanValidators;
import com.shahenpc.system.domain.budget.OutlayAlarm;
import com.shahenpc.system.domain.budget.OutlayAlarmSetting;
import com.shahenpc.system.domain.budget.OutlayBudget;
import com.shahenpc.system.domain.budget.dto.ActualListConutDto;
import com.shahenpc.system.domain.budget.dto.CountDto;
import com.shahenpc.system.mapper.budget.OutlayAlarmMapper;
import com.shahenpc.system.mapper.budget.OutlayAlarmSettingMapper;
import com.shahenpc.system.mapper.budget.OutlayBudgetMapper;
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
    private OutlayAlarmSettingMapper outlayAlarmSettingMapper;
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
    public int insertOutlayActual(OutlayActual outlayActual)
    {
        outlayActual.setCreateTime(DateUtils.getNowDate());
        OutlayBudget budget=outlayBudgetMapper.selectOutlayBudgetByBudgetId(outlayActual.getBudgetId());
        OutlayAlarmSetting setting= outlayAlarmSettingMapper.selectByBudgetType(budget.getBudgetType());
        BigDecimal divide = budget.getAmount().divide(outlayActual.getAmount(), 2, BigDecimal.ROUND_HALF_UP);
        if(divide.compareTo(setting.getRatio()) == -1){
            //预支  和 实际 支出比例 小于 规则比例  就增加到
            OutlayAlarm alarm = new OutlayAlarm();
            alarm.setAlarmId(outlayActual.getActualId());
            alarm.setBudgetId(budget.getBudgetId());
            alarm.setSettingId(setting.getSettingId());
            alarm.setCause("实际支出 超出 预计支出 比例");
            alarm.setBeyondRatio(divide.subtract(setting.getRatio()).toString());
            outlayAlarmMapper.insertOutlayAlarm(alarm);
        }
        //查出 规则
        return outlayActualMapper.insertOutlayActual(outlayActual);
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
}
