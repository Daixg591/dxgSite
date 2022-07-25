package com.shahenpc.system.domain.oa.dto;

import java.util.List;

import com.shahenpc.system.domain.oa.OaMeeting;
import com.shahenpc.system.domain.oa.OaMeetingRecord;
import com.shahenpc.system.domain.oa.OaMeetingSign;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class MeetingDetailDto extends OaMeeting{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<OaMeetingSign> sign;
    private List<OaMeetingRecord> record;
    private List<Long> personnel;
}
