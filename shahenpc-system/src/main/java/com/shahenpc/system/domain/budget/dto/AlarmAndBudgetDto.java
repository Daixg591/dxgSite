package com.shahenpc.system.domain.budget.dto;

import lombok.Data;

import java.util.Date;

@Data
public class AlarmAndBudgetDto {
    private Integer budgetType;
    private Long alarmId;
    private Date createTime;
}
