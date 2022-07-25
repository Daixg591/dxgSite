package com.shahenpc.common.utils.tencent;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class TencentLoginBean {
    private String openid;
    /**
     * 会话密钥
     */
    private String session_key;
    /**
     * 用户在开放平台的唯一标识符，在满足 UnionID 下发条件的情况下会返回
     */
    private String unionid;
}
