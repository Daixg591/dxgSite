package com.shahenpc.system.domain.wxsmallprogram.vo;


import lombok.Data;

/**
 * 获取微信手机号实体类
 * @author Hardy
 * 2022-07-29
 *
 */

@Data
public class WxPhoneVo {

    /**
     * 错误码
     */
    private Integer errcode;

    /**
     * 错误提示信息
     */
    private String errmsg;

    /**
     * 用户手机号信息
     */
    private WxPhoneEntity phone_info;
}
