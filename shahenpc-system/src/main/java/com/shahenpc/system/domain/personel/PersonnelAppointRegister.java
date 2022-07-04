package com.shahenpc.system.domain.personel;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.shahenpc.common.core.domain.entity.SysUser;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.shahenpc.common.annotation.Excel;
import com.shahenpc.common.core.domain.BaseEntity;

/**
 * 人事任免_任免记录对象 personnel_appoint_register
 *
 * @author ruoyi
 * @date 2022-07-04
 */
public class PersonnelAppointRegister extends BaseEntity {
    private static final long serialVersionUID = 1L;

    private SysUser sysUser;


    /** 姓名 */
    private String nickName;

    /** 性别 */
    private String sex;

    /** 手机号 */
    private String phonenumber;

    /** 身份证号 */
    private String idCard;

    /**
     * 任免记录Id
     */
    private Long registerId;

    /**
     * 用户Id
     */
    @Excel(name = "用户Id")
    private Long userId;

    /**
     * 任免类型
     */
    @Excel(name = "任免类型")
    private String appointType;

    /**
     * 原职务
     */
    @Excel(name = "原职务")
    private String oldDuty;

    /**
     * 拟任/免职务
     */
    @Excel(name = "拟任/免职务")
    private String handleDuty;

    /**
     * 删除标识
     */
    private String delFlag;

    /**
     * 应到人数
     */
    @Excel(name = "应到人数")
    private Long comePersonCnt;

    /**
     * 监票人
     */
    @Excel(name = "监票人")
    private String scrutineer;

    /**
     * 计票人
     */
    @Excel(name = "计票人")
    private String pollClerk;

    /**
     * 文件集合
     */
    private String fileList;

    /** 任免时间 */
    private Date regTime;

    /**
     * 投票时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "投票时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date voteTime;

    public void setRegisterId(Long registerId) {
        this.registerId = registerId;
    }

    public Long getRegisterId() {
        return registerId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setAppointType(String appointType) {
        this.appointType = appointType;
    }

    public String getAppointType() {
        return appointType;
    }

    public void setOldDuty(String oldDuty) {
        this.oldDuty = oldDuty;
    }

    public String getOldDuty() {
        return oldDuty;
    }

    public void setHandleDuty(String handleDuty) {
        this.handleDuty = handleDuty;
    }

    public String getHandleDuty() {
        return handleDuty;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setComePersonCnt(Long comePersonCnt) {
        this.comePersonCnt = comePersonCnt;
    }

    public Long getComePersonCnt() {
        return comePersonCnt;
    }

    public void setScrutineer(String scrutineer) {
        this.scrutineer = scrutineer;
    }

    public String getScrutineer() {
        return scrutineer;
    }

    public void setPollClerk(String pollClerk) {
        this.pollClerk = pollClerk;
    }

    public String getPollClerk() {
        return pollClerk;
    }

    public void setVoteTime(Date voteTime) {
        this.voteTime = voteTime;
    }

    public Date getVoteTime() {
        return voteTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("registerId", getRegisterId())
                .append("userId", getUserId())
                .append("appointType", getAppointType())
                .append("oldDuty", getOldDuty())
                .append("handleDuty", getHandleDuty())
                .append("remark", getRemark())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .append("delFlag", getDelFlag())
                .append("comePersonCnt", getComePersonCnt())
                .append("scrutineer", getScrutineer())
                .append("pollClerk", getPollClerk())
                .append("voteTime", getVoteTime())
                .append("fileList", getFileList())
                .append("regTime", getRegTime())
                .append("sysUser", getSysUser())
                .append("nickName", getNickName())
                .append("sex", getSex())
                .append("phonenumber", getPhonenumber())
                .append("idCard", getIdCard())

                .toString();
    }


    public String getFileList() {
        return fileList;
    }

    public void setFileList(String fileList) {
        this.fileList = fileList;
    }

    public Date getRegTime() {
        return regTime;
    }

    public void setRegTime(Date regTime) {
        this.regTime = regTime;
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
}
