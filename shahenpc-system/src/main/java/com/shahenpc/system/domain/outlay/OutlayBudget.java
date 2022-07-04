package com.shahenpc.system.domain.outlay;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.shahenpc.common.annotation.Excel;
import com.shahenpc.common.core.domain.BaseEntity;

/**
 * 预算对象 outlay_budget
 * 
 * @author ruoyi
 * @date 2022-07-01
 */
public class OutlayBudget extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 预算id */
    private Long budgetId;

    /** 告警id */
    @Excel(name = "告警id")
    private Long alarmId;

    /** 收支类型 */
    @Excel(name = "收支类型")
    private Long budgetType;

    /** 标题 */
    @Excel(name = "标题")
    private String title;

    /** 年份 */
    @Excel(name = "年份")
    private String year;

    /** 说明 */
    @Excel(name = "说明")
    private String illustrate;

    /** 金额 */
    @Excel(name = "金额")
    private BigDecimal amount;

    /** 状态 */
    @Excel(name = "状态")
    private Integer status;

    /** 提报人 */
    @Excel(name = "提报人")
    private Long proposedUserId;

    /** 超出比例 */
    @Excel(name = "超出比例")
    private String beyondRatio;

    public void setBudgetId(Long budgetId) 
    {
        this.budgetId = budgetId;
    }

    public Long getBudgetId() 
    {
        return budgetId;
    }
    public void setAlarmId(Long alarmId) 
    {
        this.alarmId = alarmId;
    }

    public Long getAlarmId() 
    {
        return alarmId;
    }
    public void setBudgetType(Long budgetType) 
    {
        this.budgetType = budgetType;
    }

    public Long getBudgetType() 
    {
        return budgetType;
    }
    public void setTitle(String title) 
    {
        this.title = title;
    }

    public String getTitle() 
    {
        return title;
    }
    public void setYear(String year) 
    {
        this.year = year;
    }

    public String getYear() 
    {
        return year;
    }
    public void setIllustrate(String illustrate) 
    {
        this.illustrate = illustrate;
    }

    public String getIllustrate() 
    {
        return illustrate;
    }
    public void setAmount(BigDecimal amount) 
    {
        this.amount = amount;
    }

    public BigDecimal getAmount() 
    {
        return amount;
    }
    public void setStatus(Integer status) 
    {
        this.status = status;
    }

    public Integer getStatus() 
    {
        return status;
    }
    public void setProposedUserId(Long proposedUserId) 
    {
        this.proposedUserId = proposedUserId;
    }

    public Long getProposedUserId() 
    {
        return proposedUserId;
    }
    public void setBeyondRatio(String beyondRatio) 
    {
        this.beyondRatio = beyondRatio;
    }

    public String getBeyondRatio() 
    {
        return beyondRatio;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("budgetId", getBudgetId())
            .append("alarmId", getAlarmId())
            .append("budgetType", getBudgetType())
            .append("title", getTitle())
            .append("year", getYear())
            .append("illustrate", getIllustrate())
            .append("amount", getAmount())
            .append("status", getStatus())
            .append("remark", getRemark())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("createBy", getCreateBy())
            .append("proposedUserId", getProposedUserId())
            .append("beyondRatio", getBeyondRatio())
            .toString();
    }
}
