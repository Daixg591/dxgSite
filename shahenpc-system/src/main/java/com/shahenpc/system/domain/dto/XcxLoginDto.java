package com.shahenpc.system.domain.dto;

import lombok.Data;

@Data
public class XcxLoginDto {
    /** 小程序appid **/
    private String appid;

    /** wx.login 获取的code **/
    private String code;

    /** 邀请注册的用户id **/
    private Long recommendUserId;

    /**
     * 非敏感的用户信息
     */
    private String rawData;
    /**
     * 签名信息
     */
    private String signature;
    /**
     * 加密的数据
     */
    private String encryptedData;
    /**
     * 加密密钥
     */
    private String iv;

}
