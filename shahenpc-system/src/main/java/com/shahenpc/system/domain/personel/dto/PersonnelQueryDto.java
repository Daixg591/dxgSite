package com.shahenpc.system.domain.personel.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;


/**
 * @author hardy
 * 人事任免查询实体类
 */
@Data
public class PersonnelQueryDto implements Serializable
{



    private String idCard;
    /**
     * 姓名
     */
    private String nickName;

    /**
     * 任免类型
     */
    private String appointType;

    /**
     * 热词
     */
    private String keyWords;

    /**
     * 开始时间
     */
    @DateTimeFormat(style = "yyyy-MM-dd")
    @JsonFormat(pattern ="yyyy-MM-dd",timezone = "GMT+8",shape = JsonFormat.Shape.STRING)
    private Date startTime;

    /**
     * 结束时间
     */
    @DateTimeFormat(style = "yyyy-MM-dd")
    @JsonFormat(pattern ="yyyy-MM-dd",timezone = "GMT+8",shape = JsonFormat.Shape.STRING)
    private Date endTime;

    /**
     * 手机号码
     */
    private String phonenumber;

    /**
     * 用户Id
     */
    private String userId;

    /**
     * 任免记录Id
     */
    private Long registerId;

    /**
     * 最小月份
     */
    private Date minMonth;

    /**
     * 指定月份
     */
    private Date currentData;
}
