package com.shahenpc.system.domain.law.dto;

import lombok.Data;

@Data
public class lawAidesListRequest {
    private String title;
    private Integer retrievalRange;
    private Integer retrievalManner;
    private String publishStartDate;
    private String publishEndDate;
    private Integer Timeliness;
    private Integer formulateOrgan;
}
