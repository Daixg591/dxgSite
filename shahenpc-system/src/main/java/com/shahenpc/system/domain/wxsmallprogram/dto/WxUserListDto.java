package com.shahenpc.system.domain.wxsmallprogram.dto;


import lombok.Data;

/**
 * 小程序用户查询条件实体类
 * @author Hardy
 * 2022-08-09
 */

@Data
public class WxUserListDto {
    private String nickName;
    private String goodArea;
    private Long contactStationId;
}
