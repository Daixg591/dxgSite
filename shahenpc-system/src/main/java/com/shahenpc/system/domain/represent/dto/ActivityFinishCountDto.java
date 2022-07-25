package com.shahenpc.system.domain.represent.dto;

import com.shahenpc.system.domain.represent.RepresentActivity;
import lombok.Data;

import java.util.List;

@Data
public class ActivityFinishCountDto {
    private Integer count;
    private Integer finishCount;
    private List<ActivityAppListDto> activityList;
}
