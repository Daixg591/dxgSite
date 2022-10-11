package com.shahenpc.system.domain.feature.dto;

import com.shahenpc.system.domain.feature.FeatureDoubleWorkTrace;
import lombok.Data;

/**
 * @author Admin
 */
@Data
public class TraceDouBleDto extends FeatureDoubleWorkTrace {
    private String receiveName;
    private String processTypeName;
    private String statusName;
    private String receiceDeptName;
}
