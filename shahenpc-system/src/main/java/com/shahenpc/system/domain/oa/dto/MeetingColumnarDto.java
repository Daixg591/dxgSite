package com.shahenpc.system.domain.oa.dto;

import lombok.Data;

import java.util.List;

@Data
public class MeetingColumnarDto {
    private List<Integer> data;
    private List<String> label;
}
