package com.shahenpc.system.domain.represent.dto;

import com.shahenpc.system.domain.represent.RepresentActivity;
import com.shahenpc.system.domain.represent.RepresentActivityRecord;
import lombok.Data;

import java.util.List;

@Data
public class ActivityAppListDto extends RepresentActivity {
    private String activityTypeName;
    private String statusName;
    private List<RepresentActivityRecord> record;
}
