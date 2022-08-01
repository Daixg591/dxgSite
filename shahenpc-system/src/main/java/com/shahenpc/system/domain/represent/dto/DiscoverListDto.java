package com.shahenpc.system.domain.represent.dto;

import com.shahenpc.system.domain.represent.RepresentDiscover;
import lombok.Data;

@Data
public class DiscoverListDto extends RepresentDiscover {
    private String sendUserName;
    private String receiveUserName;
}
