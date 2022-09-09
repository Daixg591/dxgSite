package com.shahenpc.system.domain.standard.vo;

import com.shahenpc.common.core.domain.BaseEntity;
import lombok.Data;

/**
 * 通过
 * @author Admin
 */
@Data
public class CensorPassVo extends BaseEntity {
    //只修改记录状态
    private Long consorId;
    private Long userId;
    private Integer type;
    private Long recordId;

}
