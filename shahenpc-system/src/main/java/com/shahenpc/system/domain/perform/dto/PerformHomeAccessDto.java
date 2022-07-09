package com.shahenpc.system.domain.perform.dto;

import com.shahenpc.system.domain.perform.PerformHomeAccess;
import lombok.Data;

@Data
public class PerformHomeAccessDto extends PerformHomeAccess {
    //不传值 普通列表  传值1 让浏览数排行
    private Integer type;
}
