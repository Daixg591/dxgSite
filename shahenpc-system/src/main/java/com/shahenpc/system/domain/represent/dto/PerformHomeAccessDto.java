package com.shahenpc.system.domain.represent.dto;

import com.shahenpc.system.domain.represent.RepresentHomeAccess;
import lombok.Data;

@Data
public class PerformHomeAccessDto extends RepresentHomeAccess{
    //不传值 普通列表  传值1 让浏览数排行
    private Integer type;
}
