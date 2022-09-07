package com.shahenpc.system.domain.feature.vo;

import com.shahenpc.system.domain.feature.FeatureDoubleWork;
import lombok.Data;

@Data
public class FeatureDoubleWorkUpdateVo extends FeatureDoubleWork {

    private String revert;
}
