package com.shahenpc.system.domain.represent.dto;

import lombok.Data;

import java.util.List;

@Data
public class MotionLingDto {
    private List<Integer> data;
    private List<String> label;
}
