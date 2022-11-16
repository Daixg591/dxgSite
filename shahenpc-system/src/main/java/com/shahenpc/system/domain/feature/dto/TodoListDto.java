package com.shahenpc.system.domain.feature.dto;

import com.shahenpc.system.domain.feature.FeatureDoubleWork;
import lombok.Data;

/**
 * @author Admin
 */
@Data
public class TodoListDto extends FeatureDoubleWork {
    private String doubleTypeName;
    private String processTypeName;
    private String statusName;

    private String receiveName;
    private String receivePhone;
    private String sendName;
    private String sendPhone;
}
