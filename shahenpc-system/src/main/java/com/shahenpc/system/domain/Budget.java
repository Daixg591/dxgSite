package com.shahenpc.system.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.shahenpc.common.annotation.Excel;
import com.shahenpc.common.core.domain.BaseEntity;

/**
 * 预算对象 budget
 * 
 * @author ruoyi
 * @date 2022-07-01
 */
public class Budget extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 预算id */
    private Long budgetId;

    /** 关联类别表 */
    @Excel(name = "关联类别表")
    private Long categoryId;

    /** 收支类型 */
    @Excel(name = "收支类型")
    private Long collectzhiType;

    /** 标题 */
    @Excel(name = "标题")
    private String title;

    /** 金额 */
    @Excel(name = "金额")
    private BigDecimal amount;

    /** 状态 */
    @Excel(name = "状态")
    private Integer status;

    public void setBudgetId(Long budgetId) 
    {
        this.budgetId = budgetId;
    }

    public Long getBudgetId() 
    {
        return budgetId;
    }
    public void setCategoryId(Long categoryId) 
    {
        this.categoryId = categoryId;
    }

    public Long getCategoryId() 
    {
        return categoryId;
    }
    public void setCollectzhiType(Long collectzhiType) 
    {
        this.collectzhiType = collectzhiType;
    }

    public Long getCollectzhiType() 
    {
        return collectzhiType;
    }
    public void setTitle(String title) 
    {
        this.title = title;
    }

    public String getTitle() 
    {
        return title;
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

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("budgetId", getBudgetId())
            .append("categoryId", getCategoryId())
            .append("collectzhiType", getCollectzhiType())
            .append("title", getTitle())
            .append("amount", getAmount())
            .append("status", getStatus())
            .append("remark", getRemark())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("createBy", getCreateBy())
            .toString();
    }
}
