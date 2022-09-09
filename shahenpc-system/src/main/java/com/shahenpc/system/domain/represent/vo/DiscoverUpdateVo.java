package com.shahenpc.system.domain.represent.vo;

import com.shahenpc.common.annotation.Excel;
import com.shahenpc.system.domain.represent.RepresentDiscover;
import lombok.Data;

@Data
public class DiscoverUpdateVo extends RepresentDiscover {

    private String revert;

    private Long userId;
}
