package com.shahenpc.system.domain.wxsmallprogram.vo;

import lombok.Data;

import java.awt.image.BufferedImage;

/**
 * 小程序返回实体
 * @author Hardy
 * 2022-08-11
 */

@Data
public class WxQrcodeVo {
    /**
     * 小程序码Buffer
     */
    private BufferedImage buffer;

    /**
     * 失败时返回错误码
     */
    private Integer errcode;

    /**
     * 失败时返回错误信息
     */
    private String errmsg;

    private String contentType;

}
