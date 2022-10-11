package com.shahenpc.system.domain.represent.dto;

import com.shahenpc.system.domain.represent.RepresentDiscover;
import lombok.Data;

import java.util.List;

@Data
public class DiscoverDetailDto extends RepresentDiscover {
    private String sendUserName;
    private String receiveUserName;
    private List<DiscoverTrackDetailListDto> track;

    private String processTypeName;

    private String statusName;

}
