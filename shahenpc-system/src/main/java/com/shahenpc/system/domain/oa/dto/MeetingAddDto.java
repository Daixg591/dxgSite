package com.shahenpc.system.domain.oa.dto;

import com.shahenpc.system.domain.oa.OaMeeting;
import com.shahenpc.system.domain.oa.OaMeetingPersonnel;
import com.shahenpc.system.domain.oa.OaMeetingSign;
import lombok.Data;

import java.util.List;

@Data
public class MeetingAddDto extends OaMeeting {

    private List<OaMeetingSign> personnel;
//    private List<Long> personnel;
}
