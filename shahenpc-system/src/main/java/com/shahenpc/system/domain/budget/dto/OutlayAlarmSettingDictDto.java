package com.shahenpc.system.domain.budget.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class OutlayAlarmSettingDictDto {
    private String dictLabel;
    private String dictValue;
    private Long settingId;
    private BigDecimal ratio;
}
