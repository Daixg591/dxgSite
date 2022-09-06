package com.shahenpc.system.domain.budget;

import com.shahenpc.common.annotation.Excel;
import com.shahenpc.common.core.domain.BaseEntity;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.math.BigDecimal;

/**
 * 预算记录对象 outlay_budget_record
 *
 * @author ruoyi
 * @date 2022-08-29
 */
@Data
public class OutlayBudgetRecord extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**  */
    private Long recordId;

    /**  */
    @Excel(name = "")
    private Long budgetId;

    /** 调整前 */
    @Excel(name = "调整前")
    private BigDecimal beforeAmount;

    /** 调整后 */
    @Excel(name = "调整后")
    private BigDecimal afterAmount;

    @Excel(name = "改变金额数")
    private BigDecimal changeAmount;

    public void setRecordId(Long recordId)
    {
        this.recordId = recordId;
    }

    public Long getRecordId()
    {
        return recordId;
    }
    public void setBudgetId(Long budgetId)
    {
        this.budgetId = budgetId;
    }

    public Long getBudgetId()
    {
        return budgetId;
    }
    public void setBeforeAmount(BigDecimal beforeAmount)
    {
        this.beforeAmount = beforeAmount;
    }

    public BigDecimal getBeforeAmount()
    {
        return beforeAmount;
    }
    public void setAfterAmount(BigDecimal afterAmount)
    {
        this.afterAmount = afterAmount;
    }

    public BigDecimal getAfterAmount()
    {
        return afterAmount;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("recordId", getRecordId())
                .append("budgetId", getBudgetId())
                .append("remark", getRemark())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .append("createBy", getCreateBy())
                .append("beforeAmount", getBeforeAmount())
                .append("afterAmount", getAfterAmount())
                .toString();
    }
}
