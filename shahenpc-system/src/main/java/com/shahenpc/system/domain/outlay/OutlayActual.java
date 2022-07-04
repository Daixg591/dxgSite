package com.shahenpc.system.domain.outlay;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.shahenpc.common.annotation.Excel;
import com.shahenpc.common.core.domain.BaseEntity;

/**
 * 实际支出对象 outlay_actual
 * 
 * @author ruoyi
 * @date 2022-07-01
 */
public class OutlayActual extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private Long actualId;

    /** 预支出 */
    @Excel(name = "预支出")
    private Long budgetId;

    /** 金额 */
    @Excel(name = "金额")
    private BigDecimal amount;

    /** 监督id */
    @Excel(name = "监督id")
    private Long superviseUserId;

    public void setActualId(Long actualId) 
    {
        this.actualId = actualId;
    }

    public Long getActualId() 
    {
        return actualId;
    }
    public void setBudgetId(Long budgetId) 
    {
        this.budgetId = budgetId;
    }

    public Long getBudgetId() 
    {
        return budgetId;
    }
    public void setAmount(BigDecimal amount) 
    {
        this.amount = amount;
    }

    public BigDecimal getAmount() 
    {
        return amount;
    }
    public void setSuperviseUserId(Long superviseUserId) 
    {
        this.superviseUserId = superviseUserId;
    }

    public Long getSuperviseUserId() 
    {
        return superviseUserId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("actualId", getActualId())
            .append("budgetId", getBudgetId())
            .append("amount", getAmount())
            .append("superviseUserId", getSuperviseUserId())
            .append("remark", getRemark())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("createBy", getCreateBy())
            .toString();
    }
}
