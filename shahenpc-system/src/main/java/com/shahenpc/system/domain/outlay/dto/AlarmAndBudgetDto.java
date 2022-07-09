package com.shahenpc.system.domain.outlay.dto;

import lombok.Data;

import java.util.Date;

@Data
public class AlarmAndBudgetDto {
    private Integer budgetType;
    private Long alarmId;
    private Date createTime;
}
