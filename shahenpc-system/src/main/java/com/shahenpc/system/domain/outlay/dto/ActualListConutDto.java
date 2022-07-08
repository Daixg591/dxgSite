package com.shahenpc.system.domain.outlay.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ActualListConutDto {

    private BigDecimal actualFees;

    private Integer actualPen;

    private BigDecimal budgetFees;

    private Integer budgetPen;
}