package com.shahenpc.system.domain.represent.dto;

import com.shahenpc.system.domain.represent.RepresentDiscover;
import lombok.Data;

@Data
public class DiscoverAppListDto extends RepresentDiscover {
    private String sendUserName;
    private String receiveUserName;
    private String discoverTypeName;
    private String discoverStatusName;
}
