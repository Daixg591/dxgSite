package com.shahenpc.system.domain.represent.dto;

import com.shahenpc.system.domain.represent.RepresentNpcOverview;
import lombok.Data;

import java.util.List;

@Data
public class NpcOverviewWxDto extends RepresentNpcOverview {

    private List<String> secretaryName;
    private List<String> standingName;
    private List<String> directorName;
    private List<String> deputyName;
}
