package com.shahenpc.system.domain.represent.dto;

import com.shahenpc.common.annotation.Excel;
import lombok.Data;

@Data
public class DiscoverRankingDto {
    @Excel(name = "姓名")
    private String nickName;
    @Excel(name = "手机号码")
    private String userName;
    @Excel(name = "职务")
    private String nowDuty;
    @Excel(name = "乡镇办")
    private String accessName;
    @Excel(name = "次")
    private Integer ranking;

}
