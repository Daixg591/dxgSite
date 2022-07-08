package com.shahenpc.system.domain.personel;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.shahenpc.common.core.domain.entity.SysUser;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.shahenpc.common.annotation.Excel;
import com.shahenpc.common.core.domain.BaseEntity;

/**
 * 人事任免_评议结果对象 personnel_appoint_evalute_res
 * 
 * @author ruoyi
 * @date 2022-07-07
 */
public class PersonnelAppointEvaluteRes extends BaseEntity
{
    private static final long serialVersionUID = 1L;

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

    /** 评议结果Id */
    private Long resId;

    /** 被评议用户id */
    @Excel(name = "被评议用户id")
    private Long userId;

    /** 评议人姓名 */
    @Excel(name = "评议人姓名")
    private String subUserName;

    /** 评议结果 */
    @Excel(name = "评议结果")
    private String resCon;

    /** 删除标识 */
    private String delFlag;

    /** 任免记录Id */
    @Excel(name = "任免记录Id")
    private Long registerId;

    /** 附件地址 */
    @Excel(name = "附件地址")
    private String fileUrl;

    public void setResId(Long resId) 
    {
        this.resId = resId;
    }

    public Long getResId() 
    {
        return resId;
    }
    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }
    public void setSubUserName(String subUserName) 
    {
        this.subUserName = subUserName;
    }

    public String getSubUserName() 
    {
        return subUserName;
    }
    public void setResCon(String resCon) 
    {
        this.resCon = resCon;
    }

    public String getResCon() 
    {
        return resCon;
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
    public void setFileUrl(String fileUrl) 
    {
        this.fileUrl = fileUrl;
    }

    public String getFileUrl() 
    {
        return fileUrl;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("resId", getResId())
            .append("userId", getUserId())
            .append("subUserName", getSubUserName())
            .append("resCon", getResCon())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("delFlag", getDelFlag())
            .append("registerId", getRegisterId())
            .append("fileUrl", getFileUrl())
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
}
