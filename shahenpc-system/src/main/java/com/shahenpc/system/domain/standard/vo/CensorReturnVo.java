package com.shahenpc.system.domain.standard.vo;

import com.shahenpc.common.core.domain.BaseEntity;
import lombok.Data;

/**
 * @author Admin
 */
@Data
public class CensorReturnVo extends BaseEntity{

    /**  */
    private Long censorId;

    private Integer type;

    private Long userId;

    private String revert;

}
