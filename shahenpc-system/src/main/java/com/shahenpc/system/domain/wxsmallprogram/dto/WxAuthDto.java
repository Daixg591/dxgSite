package com.shahenpc.system.domain.wxsmallprogram.dto;

/**
 * @author hardy
 * 微信获取OpenId请求实体类
 *
 * 222-07-28
 */

public class WxAuthDto {
    /**
     * 小程序 appId
     */
    private String appid;

    /**
     * 小程序 appSecret
     */
    private String secret;

    /**
     * 登录时获取的 code
     */
    private String js_code;

    /**
     * 授权类型，此处只需填写 authorization_code
     */
    private String grant_type;

    /**
     * 填写 client_credential
     */

    public String getAppid() {
        return appid="wx67cf0baafa8ed699";
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getSecret() {
        return secret="854c1f03d1263aff18c8cd6bedf910b3";
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getJs_code() {
        return js_code;
    }

    public void setJs_code(String js_code) {
        this.js_code = js_code;
    }

    public String getGrant_type() {
        return grant_type;
//        return grant_type="authorization_code";
    }

    public void setGrant_type(String grant_type) {
        this.grant_type = grant_type;
    }
}
