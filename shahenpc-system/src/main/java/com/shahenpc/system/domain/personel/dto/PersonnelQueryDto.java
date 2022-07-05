package com.shahenpc.system.domain.personel.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;


/**
 * @author hardy
 * 人事任免查询实体类
 */
@Data
public class PersonnelQueryDto implements Serializable
{
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
    private Date startTime;

    /**
     * 结束时间
     */
    private Date endTime;

    /**
     * 手机号码
     */
    private String phonenumber;
}
