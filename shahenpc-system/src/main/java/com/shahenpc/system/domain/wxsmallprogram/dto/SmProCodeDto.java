package com.shahenpc.system.domain.wxsmallprogram.dto;

import lombok.Data;

/**
 * 微信小程序码获取参数实体类
 * @author Hardy
 * 2022-07-30
 */

@Data
public class SmProCodeDto {
    /**
     * 接口调用凭证
     */
    private String access_token;

    /**
     * 最大32个可见字符，只支持数字，大小写英文以及部分特殊字符
     */
    private String scene;

    /**
     * 页面 page，例如 pages/index/index，根路径前不要填加 /，不能携带参数（参数请放在 scene 字段里），如果不填写这个字段，默认跳主页面
     */
    private String page;

    /**
     * 检查 page 是否存在，为 true 时 page 必须是已经发布的小程序存在的页面（否则报错）；为 false 时允许小程序未发布或者 page 不存在， 但 page 有数量上限（60000个）请勿滥用
     */
    private Boolean check_path;

    /**
     * 要打开的小程序版本。正式版为 release，体验版为 trial，开发版为 develop
     */
    private String env_version;

    /**
     * 二维码的宽度，单位 px，最小 280px，最大 1280px
     */
    private Integer width;

    /**
     * 自动配置线条颜色，如果颜色依然是黑色，则说明不建议配置主色调，默认 false
     */
    private Boolean auto_color;

    /**
     * auto_color 为 false 时生效，使用 rgb 设置颜色 例如 {"r":"xxx","g":"xxx","b":"xxx"} 十进制表示
     */
    private Object line_color;

    /**
     * 是否需要透明底色，为 true 时，生成透明底色的小程序
     */
    private String is_hyaline;

}
