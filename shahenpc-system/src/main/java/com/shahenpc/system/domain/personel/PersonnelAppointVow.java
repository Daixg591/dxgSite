package com.shahenpc.system.domain.personel;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.shahenpc.common.core.domain.entity.SysUser;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.shahenpc.common.annotation.Excel;
import com.shahenpc.common.core.domain.BaseEntity;

/**
 * 人事任免_向宪法发誓对象 personnel_appoint_vow
 *
 * @author ruoyi
 * @date 2022-07-06
 */
public class PersonnelAppointVow extends BaseEntity {
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
     * 用户详情
     */
    @JsonIgnore
    private SysUser sysUser;

    /**
     * 任免记录详情
     */
    @JsonIgnore
    private PersonnelAppointRegister regEntity;

    /**
     * 视频文件Url
     */
    private String fileUrl;

    /**
     * 文件Url
     */
    private String coverUrl;


    /**
     * 发誓id
     */
    private Long vowId;

    /**
     * 用户id
     */
    @Excel(name = "用户id")
    private Long userId;

    /**
     * 视频id集合
     */
    @Excel(name = "视频id集合")
    private String fileIds;

    /**
     * 删除标识
     */
    private String delFlag;

    /**
     * 任免记录Id
     */
    @Excel(name = "任免记录Id")
    private Long registerId;

    public void setVowId(Long vowId) {
        this.vowId = vowId;
    }

    public Long getVowId() {
        return vowId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setFileIds(String fileIds) {
        this.fileIds = fileIds;
    }

    public String getFileIds() {
        return fileIds;
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
                .append("vowId", getVowId())
                .append("userId", getUserId())
                .append("fileIds", getFileIds())
                .append("remark", getRemark())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .append("delFlag", getDelFlag())
                .append("registerId", getRegisterId())
                .append("fileUrl", getFileUrl())
                .append("coverUrl", getCoverUrl())
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

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String FileUrl) {
        this.fileUrl = FileUrl;
    }

    public String getCoverUrl() {
        return coverUrl;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
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
