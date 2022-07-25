package com.shahenpc.system.domain.oa.dto;

import com.shahenpc.system.domain.oa.OaMeeting;
import lombok.Data;

@Data
public class MeetingAppListDto extends OaMeeting {
    private String meetingTypeName;
    private String statusName;
    private String isSignName;
}
