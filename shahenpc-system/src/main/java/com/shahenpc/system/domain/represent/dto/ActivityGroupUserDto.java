package com.shahenpc.system.domain.represent.dto;

import com.shahenpc.system.domain.represent.RepresentActivityGroup;
import lombok.Data;

import java.util.List;

@Data
public class ActivityGroupUserDto {
    /**
     * 分组id
     */
    private Long activityGroupId;

    /**
     * 需要认领的代表用户
     */
    private Long userId;
}
