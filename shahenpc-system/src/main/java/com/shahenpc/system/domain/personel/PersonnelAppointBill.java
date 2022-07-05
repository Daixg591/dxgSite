package com.shahenpc.system.domain.personel;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.shahenpc.common.core.domain.entity.SysUser;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.shahenpc.common.annotation.Excel;
import com.shahenpc.common.core.domain.BaseEntity;

/**
 * 人事任免_议案提请对象 personnel_appoint_bill
 *
 * @author ruoyi
 * @date 2022-07-04
 */
public class PersonnelAppointBill extends BaseEntity {
    private static final long serialVersionUID = 1L;


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
    private String appointType;

    /**
     * 议案提请id
     */
    private Long billId;

    /**
     * 标题
     */
    @Excel(name = "标题")
    private String billTitle;

    /**
     * 详情
     */
    @Excel(name = "详情")
    private String details;

    /**
     * 用户id
     */
    @Excel(name = "用户id")
    private Long userId;

    /**
     * 文件集合
     */
    @Excel(name = "文件集合")
    private String fileList;

    /**
     * 删除标识
     */
    private String delFlag;

    /**
     * 任免记录id
     */
    @Excel(name = "任免记录id")
    private Long registerId;

    /** 任免记录详情 */
    @JsonIgnore
    private PersonnelAppointRegister regEntity;

    /** 人员详情 */
    @JsonIgnore
    private SysUser sysUser;



    public void setBillId(Long billId) {
        this.billId = billId;
    }

    public Long getBillId() {
        return billId;
    }

    public void setBillTitle(String billTitle) {
        this.billTitle = billTitle;
    }

    public String getBillTitle() {
        return billTitle;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getDetails() {
        return details;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setFileList(String fileList) {
        this.fileList = fileList;
    }

    public String getFileList() {
        return fileList;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setRegisterId(Long registerId) {
        this.registerId = registerId;
    }

    public Long getRegisterId() {
        return registerId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("billId", getBillId())
                .append("billTitle", getBillTitle())
                .append("details", getDetails())
                .append("userId", getUserId())
                .append("fileList", getFileList())
                .append("remark", getRemark())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .append("delFlag", getDelFlag())
                .append("registerId", getRegisterId())
                .append("regEntity", getRegEntity())
                .append("sysUser", getSysUser())
                .toString();
    }

    public PersonnelAppointRegister getRegEntity() {
        return regEntity;
    }

    public void setRegEntity(PersonnelAppointRegister regEntity) {
        this.regEntity = regEntity;
    }

    public SysUser getSysUser() {
        return sysUser;
    }

    public void setSysUser(SysUser sysUser) {
        this.sysUser = sysUser;
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
