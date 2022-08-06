package com.shahenpc.system.domain.BackVo;

import lombok.Data;

/**
 * 法律信息Body实体类
 * @author hardy
 * 2022-07-26
 */
public class LawResultBody {

    private String type;
    private String path;
    private String addr;
    private String url;
    private String mobile;
    private String qr;
    public void setType(String type) {
        this.type = type;
    }
    public String getType() {
        return type;
    }

    public void setPath(String path) {
        this.path = path;
    }
    public String getPath() {
        return path;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }
    public String getAddr() {
        return addr;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    public String getUrl() {
        return url;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
    public String getMobile() {
        return mobile;
    }

    public void setQr(String qr) {
        this.qr = qr;
    }
    public String getQr() {
        return qr;
    }

}
