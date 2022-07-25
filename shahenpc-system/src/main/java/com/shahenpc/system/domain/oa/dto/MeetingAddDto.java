package com.shahenpc.system.domain.oa.dto;

import com.shahenpc.system.domain.oa.OaMeeting;
import com.shahenpc.system.domain.oa.OaMeetingPersonnel;
import lombok.Data;

import java.util.List;

@Data
public class MeetingAddDto extends OaMeeting {

    /**
    private List<OaMeetingPersonnel> personnel;*/
    private List<Long> personnel;
}
