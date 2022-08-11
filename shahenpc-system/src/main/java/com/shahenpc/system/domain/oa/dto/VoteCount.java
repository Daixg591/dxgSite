package com.shahenpc.system.domain.oa.dto;

import lombok.Data;

@Data
public class VoteCount {
    private Integer all;
    private Integer notstart;
    private Integer starting;
    private Integer complete;
}
