package com.shahenpc.system.domain.dto;

import com.shahenpc.system.domain.oa.OaMeeting;
import com.shahenpc.system.domain.personel.PersonnelAppointNotice;
import com.shahenpc.system.domain.represent.RepresentDiscover;
import lombok.Data;

import java.util.List;

@Data
public class MyArchivesDto {
    /**
     * 培训学习情况
     */
    private List<PersonnelAppointNotice> study;
    /**
     * 出席会议情况
     */
    private List<OaMeeting> meeting;
    /**
     * 审议发言情况
     */
    //private List<> speak;
    /**
     * 提出建议情况
     */
    //private List<> proposal;
    /**
     * 视察调研情况
     */
    //private List<> survey;
    /**
     *走访接访情况
     */
    //private List<> visit;
    /**
     * 代表发现
     */
    private List<RepresentDiscover> discover;
}
