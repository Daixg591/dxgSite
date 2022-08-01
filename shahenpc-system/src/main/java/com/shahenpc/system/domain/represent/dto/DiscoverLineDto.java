package com.shahenpc.system.domain.represent.dto;

import lombok.Data;

import java.util.List;

@Data
public class DiscoverLineDto {
    private List<Integer> data;
    private List<String> label;
}
