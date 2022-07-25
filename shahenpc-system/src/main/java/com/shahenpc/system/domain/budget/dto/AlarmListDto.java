package com.shahenpc.system.domain.budget.dto;

import com.shahenpc.system.domain.budget.OutlayAlarm;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class AlarmListDto extends OutlayAlarm {
    private String year;
    private Integer budgetType;
    private String title;
    private BigDecimal forecastAmount;
    private BigDecimal actualAmount;
    private String illustrate;
}
