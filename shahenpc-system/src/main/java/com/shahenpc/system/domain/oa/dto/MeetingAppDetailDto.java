package com.shahenpc.system.domain.oa.dto;

import com.shahenpc.system.domain.oa.OaMeeting;
import com.shahenpc.system.domain.oa.OaMeetingRecord;
import com.shahenpc.system.domain.oa.OaMeetingSign;
import lombok.Data;

import java.util.List;

@Data
public class MeetingAppDetailDto extends OaMeeting {
    private List<OaMeetingSign> sign;
    private List<OaMeetingRecord> record;
    private List<Long> personnel;
    private String meetingTypeName;
    private String statusName;
    private String isSignName;

    /**
     * 我是否签到
     */
    private Integer myIsSign;
}
