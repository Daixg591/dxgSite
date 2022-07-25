package com.shahenpc.system.domain.feature.dto;

import lombok.Data;

import java.util.List;

@Data
public class FeatureCurveDto {
    private List<Integer> data;
    private List<String> label;
}
