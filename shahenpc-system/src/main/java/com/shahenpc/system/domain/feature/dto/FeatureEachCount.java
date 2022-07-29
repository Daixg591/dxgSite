package com.shahenpc.system.domain.feature.dto;

import lombok.Data;

@Data
public class FeatureEachCount {
    private Integer total;
    private Integer collectCount;
    private Integer processCount;
    //收集率
    private Double collectRate;
    //处理率
    private Double processRate;
}
