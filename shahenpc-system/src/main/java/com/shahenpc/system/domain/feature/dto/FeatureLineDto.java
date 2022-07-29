package com.shahenpc.system.domain.feature.dto;

import lombok.Data;

import java.util.List;

@Data
public class FeatureLineDto {
    private List<Integer> data;
    private List<String> label;
}
