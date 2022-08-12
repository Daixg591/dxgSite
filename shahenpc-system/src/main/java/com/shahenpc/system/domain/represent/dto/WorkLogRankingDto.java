package com.shahenpc.system.domain.represent.dto;

import lombok.Data;

@Data
public class WorkLogRankingDto {
    private Integer total;
    private Integer typeCount;
    private Long userId;
    private Integer ranking;
}
