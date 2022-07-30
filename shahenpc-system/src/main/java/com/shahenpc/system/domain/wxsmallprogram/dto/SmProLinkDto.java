package com.shahenpc.system.domain.wxsmallprogram.dto;

import lombok.Data;

/**
 * 小程序投票链接请求实体类
 * @author Hardy
 *
 * 2022-07-30
 */
@Data
public class SmProLinkDto {
    /**
     * 接口调用凭证
     */
    private String access_token;

    /**
     * 通过 URL Link 进入的小程序页面路径，必须是已经发布的小程序存在的页面，不可携带 query 。path 为空时会跳转小程序主页
     */
    private String path;

    /**
     * 通过 URL Link 进入小程序时的query，最大1024个字符，只支持数字，大小写英文以及部分特殊字符：!#$&'()*+,/:;=?@-._~%
     */
    private String query;

    /**
     * 要打开的小程序版本。正式版为 "release"，体验版为"trial"，开发版为"develop"，仅在微信外打开时生效。
     */
    private String env_version;

    /**
     * 小程序 URL Link 失效类型，失效时间：0，失效间隔天数：1
     */
    private Integer expire_type;

    /**
     * 到期失效的 URL Link 的失效时间，为 Unix 时间戳。生成的到期失效 URL Link 在该时间前有效。最长有效期为30天。expire_type 为 0 必填
     */
    private Integer expire_time;

    /**
     * 到期失效的URL Link的失效间隔天数。生成的到期失效URL Link在该间隔时间到达前有效。最长间隔天数为30天。expire_type 为 1 必填
     */
    private Integer expire_interval;

    /**
     * 云开发静态网站自定义 H5 配置参数，可配置中转的云开发 H5 页面。不填默认用官方 H5 页面
     */
    private Object cloud_base;
}
