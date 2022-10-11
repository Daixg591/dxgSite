package com.shahenpc.system.domain.represent.dto;

import com.shahenpc.system.domain.represent.RepresentDiscoverTrack;
import lombok.Data;

/**
 * @author Admin
 */
@Data
public class DiscoverTrackDetailListDto extends RepresentDiscoverTrack {
    private String sendUserName;
    private String receiveUserName;
    private String processTypeName;
    private String discoverStatusName;
    private String sendAccessName;
    private String receiveAccessName;
    private String receiceDeptName;
}
