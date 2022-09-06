package com.shahenpc.system.domain.standard.vo;

import com.shahenpc.system.domain.standard.StandardCensor;
import lombok.Data;

/**
 * @author Admin
 */
@Data
public class CensorUpdateVo  extends StandardCensor {

    private String[] approvalUserId;

    private String revert;

    private Long recordId;
}
