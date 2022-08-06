package com.shahenpc.system.domain.wxsmallprogram.vo;

import lombok.Data;

/**
 * 微信手机号实体
 * @author Hardy
 * 2022-07-29
 */
@Data
public class WxPhoneEntity {
    /**
     * 用户绑定的手机号（国外手机号会有区号)
     */
    private String phoneNumber;
    /**
     * 没有区号的手机号
     */
    private String purePhoneNumber;
    /**
     * 区号
     */
    private String countryCode;
    /**
     * 数据水印
     */
    private wxPhoneWaterVo watermark;
}
