package com.shahenpc.system.domain.standard.vo;

import com.shahenpc.system.domain.standard.StandardCensor;
import lombok.Data;

@Data
public class CensorUpdateVo  extends StandardCensor {

    private String[] receiveUserIds;
}
