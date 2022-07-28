package com.shahenpc.system.domain.represent.dto;

import lombok.Data;

@Data
public class PerformDutieRankingDto {
    private Long id;
    private Long userId;
    private Integer counts;
    private String avatar;
    private String nickName;
}
