package com.shahenpc.system.domain.budget;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.shahenpc.common.annotation.Excel;
import com.shahenpc.common.core.domain.BaseEntity;

/**
 * 告警设置-规则对象 outlay_alarm_setting
 * 
 * @author ruoyi
 * @date 2022-07-04
 */
public class OutlayAlarmSetting extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long settingId;

    /**  */
    @Excel(name = "")
    private Integer budgetType;

    /**  */
    @Excel(name = "")
    private BigDecimal ratio;

    public void setSettingId(Long settingId) 
    {
        this.settingId = settingId;
    }

    public Long getSettingId() 
    {
        return settingId;
    }
    public void setBudgetType(Integer budgetType) 
    {
        this.budgetType = budgetType;
    }

    public Integer getBudgetType() 
    {
        return budgetType;
    }
    public void setRatio(BigDecimal ratio) 
    {
        this.ratio = ratio;
    }

    public BigDecimal getRatio() 
    {
        return ratio;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("settingId", getSettingId())
            .append("budgetType", getBudgetType())
            .append("ratio", getRatio())
            .append("remark", getRemark())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
