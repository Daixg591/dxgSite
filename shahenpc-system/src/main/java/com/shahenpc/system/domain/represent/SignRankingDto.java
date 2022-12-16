package com.shahenpc.system.domain.represent;

import com.shahenpc.common.annotation.Excel;
import lombok.Data;

@Data
public class SignRankingDto {
    @Excel(name = "姓名")
    private String nickName;

//    @Excel(name = "联络站")
//    private String stationName;

    @Excel(name = "次数")
    private Integer ranking;
}
