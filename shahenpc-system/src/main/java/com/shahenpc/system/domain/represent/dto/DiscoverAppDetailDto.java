package com.shahenpc.system.domain.represent.dto;

import com.shahenpc.system.domain.represent.RepresentDiscover;
import com.shahenpc.system.domain.represent.RepresentDiscoverTrack;
import lombok.Data;

import java.util.List;

@Data
public class DiscoverAppDetailDto extends RepresentDiscover {
    private String sendUserName;
    private String receiveUserName;
    private String discoverTypeName;
    private String discoverStatusName;

    private List<RepresentDiscoverTrack> track;
}
