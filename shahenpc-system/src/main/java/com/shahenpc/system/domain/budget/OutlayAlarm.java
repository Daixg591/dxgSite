package com.shahenpc.system.domain.budget;

import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.shahenpc.common.annotation.Excel;
import com.shahenpc.common.core.domain.BaseEntity;

import java.math.BigDecimal;

/**
 * 预警后存储数据对象 outlay_alarm
 * 
 * @author ruoyi
 * @date 2022-07-04
 */
@Data
public class OutlayAlarm extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private Long alarmId;

    /**  */
    @Excel(name = "")
    private Long actualId;

    /**  */
    @Excel(name = "")
    private Long budgetId;

    /** 预警id */
    @Excel(name = "预警id")
    private Long settingId;
    /** 预警比例 */
    @Excel(name = "预警比例")
    private BigDecimal settingRatio;
    /** 预警原因 */
    @Excel(name = "预警原因")
    private String cause;

    /** 超出比例存储 */
    @Excel(name = "超出比例存储")
    private BigDecimal beyondRatio;

    public void setAlarmId(Long alarmId) 
    {
        this.alarmId = alarmId;
    }

    public Long getAlarmId() 
    {
        return alarmId;
    }
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
    public void setSettingId(Long settingId) 
    {
        this.settingId = settingId;
    }

    public Long getSettingId() 
    {
        return settingId;
    }
    public void setCause(String cause) 
    {
        this.cause = cause;
    }

    public String getCause() 
    {
        return cause;
    }
    public void setBeyondRatio(BigDecimal beyondRatio)
    {
        this.beyondRatio = beyondRatio;
    }

    public BigDecimal getBeyondRatio()
    {
        return beyondRatio;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("alarmId", getAlarmId())
            .append("actualId", getActualId())
            .append("budgetId", getBudgetId())
            .append("settingId", getSettingId())
            .append("cause", getCause())
            .append("beyondRatio", getBeyondRatio())
            .append("remark", getRemark())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("createBy", getCreateBy())
            .toString();
    }
}
