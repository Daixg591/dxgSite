package com.shahenpc.system.domain.represent.dto;

import com.shahenpc.system.domain.represent.RepresentWorkLog;
import lombok.Data;

@Data
public class WorkLogListDto extends RepresentWorkLog {

    private String eventTypeName;
}
