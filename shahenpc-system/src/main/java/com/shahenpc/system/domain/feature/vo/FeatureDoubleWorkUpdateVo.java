package com.shahenpc.system.domain.feature.vo;

import com.shahenpc.system.domain.feature.FeatureDoubleWork;
import lombok.Data;

/**
 * @author Admin
 */
@Data
public class FeatureDoubleWorkUpdateVo extends FeatureDoubleWork {

    private String revert;
    private Long userId;
    private String trackPicUrls;
}
