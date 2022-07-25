package com.shahenpc.system.domain.budget.dto;

import lombok.Data;

import java.util.Date;

@Data
public class BudgetDto {
    private Integer budgetType;
    private String title;
    private Date startTime;
    private Date endTime;
    private String projectNumber;
}
