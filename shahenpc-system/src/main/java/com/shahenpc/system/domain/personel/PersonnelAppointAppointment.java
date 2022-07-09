package com.shahenpc.system.domain.personel;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.shahenpc.common.core.domain.entity.SysUser;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.shahenpc.common.annotation.Excel;
import com.shahenpc.common.core.domain.BaseEntity;

/**
 * 人事任免_颁发任命书对象 personnel_appoint_appointment
 * 
 * @author ruoyi
 * @date 2022-07-06
 */
public class PersonnelAppointAppointment extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**
     * 用户详情
     */
    @JsonIgnore
    private SysUser sysUser;

    private String nickName;
    private String sex;
    private String phonenumber;
    private String idCard;
    private String appointType;


    /**
     * 任免记录详情
     */
    @JsonIgnore
    private PersonnelAppointRegister regEntity;

    /** 任命书id */
    private Long appointmentId;

    /** 用户id */
    @Excel(name = "用户id")
    private Long userId;

    /** 任命书链接 */
    @Excel(name = "任命书链接")
    private String bookUrl;

    /** 删除标识 */
    private String delFlag;

    /** 任免记录Id */
    @Excel(name = "任免记录Id")
    private Long registerId;

    public void setAppointmentId(Long appointmentId) 
    {
        this.appointmentId = appointmentId;
    }

    public Long getAppointmentId() 
    {
        return appointmentId;
    }
    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }
    public void setBookUrl(String bookUrl) 
    {
        this.bookUrl = bookUrl;
    }

    public String getBookUrl() 
    {
        return bookUrl;
    }
    public void setDelFlag(String delFlag) 
    {
        this.delFlag = delFlag;
    }

    public String getDelFlag() 
    {
        return delFlag;
    }
    public void setRegisterId(Long registerId) 
    {
        this.registerId = registerId;
    }

    public Long getRegisterId() 
    {
        return registerId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("appointmentId", getAppointmentId())
            .append("userId", getUserId())
            .append("bookUrl", getBookUrl())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("delFlag", getDelFlag())
            .append("registerId", getRegisterId())
            .toString();
    }

    public SysUser getSysUser() {
        return sysUser;
    }

    public void setSysUser(SysUser sysUser) {
        this.sysUser = sysUser;
    }

    public PersonnelAppointRegister getRegEntity() {
        return regEntity;
    }

    public void setRegEntity(PersonnelAppointRegister regEntity) {
        this.regEntity = regEntity;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getAppointType() {
        return appointType;
    }

    public void setAppointType(String appointType) {
        this.appointType = appointType;
    }
}
