package com.shahenpc.common.core.domain.model;

import com.shahenpc.common.annotation.Excel;

import java.io.Serializable;

public class BaseUserEntity implements Serializable {
    /**
     * 姓名
     */
    @Excel(name = "姓名")
    private String nickName;

    /**
     * 性别
     */
    @Excel(name = "性別", readConverterExp = "0=男,1=女,2=未知")
    private String sex;

    /**
     * 手机号
     */
    @Excel(name = "手机号")
    private String phonenumber;

    /**
     * 身份证号
     */
    @Excel(name = "身份证号")
    private String idCard;

    /**
     * 任免类型
     */
    @Excel(name = "任免类型", readConverterExp = "1=选举,2=任免,3=罢免,4=推选,5=决定任免,6=决定人选," +
            "7=通过人选,8=决定代理人选,9=批准任免,10=补充任命,11=接受辞职,12=撤销职务")
    private String appointType;
}
