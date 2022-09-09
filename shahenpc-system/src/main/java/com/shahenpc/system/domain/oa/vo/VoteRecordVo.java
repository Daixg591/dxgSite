package com.shahenpc.system.domain.oa.vo;

import com.shahenpc.common.core.domain.BaseEntity;
import lombok.Data;

/**
 *
 * @author Admin
 */
@Data
public class VoteRecordVo{

    private Long voteId;

    private Long[] playerIds;

    private String code;

    private Long userId;
}
