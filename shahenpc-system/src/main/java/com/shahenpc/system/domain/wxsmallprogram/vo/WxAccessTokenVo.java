package com.shahenpc.system.domain.wxsmallprogram.vo;

import lombok.Data;

/**
 * @author  hardy
 * 获取微信AccessToken返回实体类
 */
@Data
public class WxAccessTokenVo {
    /**
     * 获取到的凭证
     */
    private String access_token;
    /**
     * 凭证有效时间，单位：秒。目前是7200秒之内的值。
     */
    private Integer expires_in;
    /**
     * 错误码
     */
    private Integer errcode;
    /**
     * 错误信息
     */
    private String errmsg;
}
