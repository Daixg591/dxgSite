package com.shahenpc.system.domain.feature.dto;

import com.shahenpc.system.domain.feature.FeatureDoubleWork;
import lombok.Data;

import java.util.List;

@Data
public class DoubleDetatilDto extends FeatureDoubleWork {

    private List<TraceDouBleDto> trace;
}
