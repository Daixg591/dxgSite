package com.shahenpc.system.domain.feature.vo;

import com.shahenpc.system.domain.feature.FeatureDoubleWork;
import com.shahenpc.system.domain.represent.RepresentDiscover;
import lombok.Data;

/**
 * @author Admin
 */
@Data
public class DoubleFallbackVo extends FeatureDoubleWork {
    private String revert;

    private String trackPicUrls;
}
