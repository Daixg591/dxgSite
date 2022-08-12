package com.shahenpc.system.domain.feature.dto;

import com.shahenpc.system.domain.feature.FeatureDoubleWork;
import lombok.Data;

@Data
public class DoubleListDto extends FeatureDoubleWork {
    private String avatar;
    private String nickName;
    private String receivePhone;
    private String sendPhone;
}
