package com.shahenpc.system.domain.standard.vo;

import com.shahenpc.system.domain.standard.StandardCensor;
import lombok.Data;

@Data
public class CensorAddVo extends StandardCensor {

    private String[] approvalUserId;

}
