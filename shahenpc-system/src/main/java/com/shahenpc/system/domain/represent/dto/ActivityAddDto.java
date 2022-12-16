package com.shahenpc.system.domain.represent.dto;

import com.shahenpc.system.domain.represent.RepresentActivity;
import com.shahenpc.system.domain.represent.RepresentActivityClaim;
import com.shahenpc.system.domain.represent.RepresentActivityGroup;
import com.shahenpc.system.domain.represent.RepresentActivityRecord;
import lombok.Data;

import java.util.List;

@Data
public class ActivityAddDto extends RepresentActivity {

    /**
     * 记录反馈集合
     */
    private List<RepresentActivityRecord> record;

    /**
     * 分组用户集合
     */
    private List<RepresentActivityClaim> groupUserList;

    /**
     * 分组信息集合
     */
    private List<RepresentActivityGroup> groupList;



}
