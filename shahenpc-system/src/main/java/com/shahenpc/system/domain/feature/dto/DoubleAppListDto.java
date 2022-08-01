package com.shahenpc.system.domain.feature.dto;

import com.shahenpc.system.domain.feature.FeatureDoubleWork;
import lombok.Data;

@Data
public class DoubleAppListDto extends FeatureDoubleWork {
    private String doubleTypeName;
    private String doubleStatusName;
    private String sendUserName;
    private String receiveUserName;
}
