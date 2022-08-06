package com.shahenpc.system.domain.BackVo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * 法律信息结果实体类
 * @author hardy
 * 2022-07-26
 */

public class LawResult {

    private String serverUrl;

    private String title;
    private String office;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date publish;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date expiry;
    private String status;
    private String level;
    private List<LawResultBody> body;
    private String dec;
    private String bbbs;
    private String otherFile;
    public void setTitle(String title) {
        this.title = title;
    }
    public String getTitle() {
        return title;
    }

    public void setOffice(String office) {
        this.office = office;
    }
    public String getOffice() {
        return office;
    }

    public void setPublish(Date publish) {
        this.publish = publish;
    }
    public Date getPublish() {
        return publish;
    }

    public void setExpiry(Date expiry) {
        this.expiry = expiry;
    }
    public Date getExpiry() {
        return expiry;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public String getStatus() {
        return status;
    }

    public void setLevel(String level) {
        this.level = level;
    }
    public String getLevel() {
        return level;
    }

    public void setBody(List<LawResultBody> body) {
        this.body = body;
    }
    public List<LawResultBody> getBody() {
        return body;
    }

    public void setDec(String dec) {
        this.dec = dec;
    }
    public String getDec() {
        return dec;
    }

    public void setBbbs(String bbbs) {
        this.bbbs = bbbs;
    }
    public String getBbbs() {
        return bbbs;
    }

    public void setOtherFile(String otherFile) {
        this.otherFile = otherFile;
    }
    public String getOtherFile() {
        return otherFile;
    }

    public String getServerUrl() {
        return serverUrl;
    }

    public void setServerUrl(String serverUrl) {
        this.serverUrl = serverUrl;
    }
}
