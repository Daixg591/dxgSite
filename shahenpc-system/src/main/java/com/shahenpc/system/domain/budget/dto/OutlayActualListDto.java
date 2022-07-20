package com.shahenpc.system.domain.budget.dto;

import com.shahenpc.system.domain.budget.OutlayActual;
import lombok.Data;

@Data
public class OutlayActualListDto extends OutlayActual {
    private String year;
    private String title;
}
