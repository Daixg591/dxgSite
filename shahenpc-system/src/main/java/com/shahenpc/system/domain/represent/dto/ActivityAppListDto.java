package com.shahenpc.system.domain.represent.dto;

import com.shahenpc.system.domain.represent.RepresentActivity;
import lombok.Data;

@Data
public class ActivityAppListDto extends RepresentActivity {
    private String activityTypeName;
    private String statusName;
}
