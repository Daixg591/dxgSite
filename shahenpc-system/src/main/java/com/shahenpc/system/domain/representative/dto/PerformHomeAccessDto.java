package com.shahenpc.system.domain.representative.dto;

import com.shahenpc.system.domain.representative.PerformHomeAccess;
import lombok.Data;

@Data
public class PerformHomeAccessDto extends PerformHomeAccess {
    //不传值 普通列表  传值1 让浏览数排行
    private Integer type;
}
