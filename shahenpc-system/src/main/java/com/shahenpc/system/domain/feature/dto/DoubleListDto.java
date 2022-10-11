package com.shahenpc.system.domain.feature.dto;

import com.shahenpc.system.domain.feature.FeatureDoubleWork;
import lombok.Data;

/**
 * @author Admin
 */
@Data
public class DoubleListDto extends FeatureDoubleWork {
    private String avatar;

    private String receivePhone;
    private String receiveName;
    private String sendName;
    private String sendPhone;
}
