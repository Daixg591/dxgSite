package com.shahenpc.system.domain.feature.dto;

import com.shahenpc.system.domain.feature.FeatureDoubleWorkTrace;
import lombok.Data;

@Data
public class TraceListDto extends FeatureDoubleWorkTrace {
    private String sendUserName;
    private String receiveUserName;
}
