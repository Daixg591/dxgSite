package com.shahenpc.system.domain.represent.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.shahenpc.common.annotation.Excel;
import com.shahenpc.system.domain.represent.RepresentDiscover;
import lombok.Data;

import java.util.Date;

@Data
public class DiscoverListDto extends RepresentDiscover {
    private String receiveUserName;

    @Excel(name = "发现问题")
    private String discoverTypeName;
    @Excel(name = "所属乡镇办")
    private String accessName;
    @Excel(name = "代表姓名")
    private String sendUserName;
    @Excel(name = "上传时间",dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
}
