package com.shahenpc.system.domain.oa.dto;

import com.shahenpc.system.domain.oa.OaMeeting;
import lombok.Data;

import java.util.List;

@Data
public class MeetingCountMinuteDto {
    private Integer count;
    private Double minute;
    private List<MeetingAppListDto> meetingList;
}
