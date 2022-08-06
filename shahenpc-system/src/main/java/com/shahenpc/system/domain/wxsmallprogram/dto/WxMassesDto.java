package com.shahenpc.system.domain.wxsmallprogram.dto;

import lombok.Data;

/**
 * 微信群众信息注册实体
 * @author Hardy
 * 2022-07-29
 */


@Data
public class WxMassesDto {
    /**
     * 微信头像完整链接
     */
    private String avatarUrl;

    /**
     * 性别
     */
    private Integer gender;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 群众手机号
     */
    private String phoneNumber;

    /**
     * 用于获取用户OpenId的code
     */
    private String code;
}
