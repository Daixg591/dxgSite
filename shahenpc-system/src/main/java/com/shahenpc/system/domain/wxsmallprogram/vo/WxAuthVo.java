package com.shahenpc.system.domain.wxsmallprogram.vo;

import lombok.Data;

/**
 * @author hardy
 * 微信获取OpenId返回实体类
 *
 * 222-07-28
 */

@Data
public class WxAuthVo {
    /**
     * 用户唯一标识
     */
    private String openid;

    /**
     * 会话密钥
     */
    private String session_key;

    /**
     * 用户在开放平台的唯一标识符，若当前小程序已绑定到微信开放平台帐号下会返回
     */
    private String unionid;

    /**
     * 错误码
     */
    private Integer errcode;

    /**
     * 错误信息
     */
    private String errmsg;

}
