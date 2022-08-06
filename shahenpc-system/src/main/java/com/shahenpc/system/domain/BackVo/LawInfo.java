package com.shahenpc.system.domain.BackVo;


import com.sun.org.apache.xpath.internal.operations.Bool;
import lombok.Data;

/**
 * 法律信息返回实体信息
 * @author Hardy
 * 2022-07-26
 */

public class LawInfo {

    private long timestamp;
    private boolean success;
    private String message;
    private int code;
    private LawResult result;
    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
    public long getTimestamp() {
        return timestamp;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
    public boolean getSuccess() {
        return success;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    public String getMessage() {
        return message;
    }

    public void setCode(int code) {
        this.code = code;
    }
    public int getCode() {
        return code;
    }

    public void setResult(LawResult result) {
        this.result = result;
    }
    public LawResult getResult() {
        return result;
    }
}
