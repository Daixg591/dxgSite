package com.shahenpc.system.domain.wxsmallprogram.vo;

import lombok.Data;

/**
 * 小程序用户信息实体类
 * @author Hardy
 * 2022-08-08
 */

@Data
public class WxUserInfoVo {
    /**
     * 用户Id
     */
    private Long userId;

    /**
     * 用户姓名
     */
    private String nickName;

    /**
     * 擅长领域
     */
    private String goodAreaName;

    /**
     * 所属联络站名称
     */
    private String stationName;

    /**
     * 个人简介
     */
    private String personInfo;

    /**
     * 头像地址
     */
    private String avatar;
}
