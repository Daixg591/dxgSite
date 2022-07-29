package com.shahenpc.system.domain.law.dto;

/**
 * 抖音授权码参数
 * @author Hardy
 * 2022-07-29
 */


public class DyAuthCodeDto {
    /**
     * 应用唯一标识
     */
    private String client_key;

    /**
     * 写死为'code'即可
     */
    private String response_type;

    /**
     * 应用授权作用域,多个授权作用域以英文逗号（,）分隔
     */
    private String scope;

    /**
     * 应用授权可选作用域,多个授权作用域以英文逗号（,） 分隔，每一个授权作用域后需要加上一个是否默认勾选的参数，1为默认勾选，0为默认不勾选
     * 示例: optionalScope=friend_relation,1,message,0
     */
    private String optionalScope;

    /**
     * 授权成功后的回调地址，必须以http/https开头。
     */
    private String redirect_uri;

    /**
     * 用于保持请求和回调的状态
     */
    private String state;

    public String getClient_key() {
        return client_key="awizmp3d1r1vyj3v";
    }

    public void setClient_key(String client_key) {
        this.client_key = client_key;
    }

    public String getResponse_type() {
        return response_type;
    }

    public void setResponse_type(String response_type) {
        this.response_type = response_type;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getOptionalScope() {
        return optionalScope;
    }

    public void setOptionalScope(String optionalScope) {
        this.optionalScope = optionalScope;
    }

    public String getRedirect_uri() {
        return redirect_uri;
    }

    public void setRedirect_uri(String redirect_uri) {
        this.redirect_uri = redirect_uri;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
