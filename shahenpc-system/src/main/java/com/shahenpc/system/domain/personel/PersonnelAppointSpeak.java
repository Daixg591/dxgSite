package com.shahenpc.system.domain.personel;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.shahenpc.common.annotation.Excel;
import com.shahenpc.common.core.domain.BaseEntity;

/**
 * 人事任免_拟任职发言对象 personnel_appoint_speak
 * 
 * @author ruoyi
 * @date 2022-07-04
 */
public class PersonnelAppointSpeak extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 发言id */
    private Long speakId;

    /** 标题 */
    @Excel(name = "标题")
    private String speakTitle;

    /** 详情 */
    @Excel(name = "详情")
    private String details;

    /** 用户id */
    @Excel(name = "用户id")
    private Long userId;

    /** 文件集合 */
    @Excel(name = "文件集合")
    private String fileList;

    /** 删除标识 */
    private String delFlag;

    public void setSpeakId(Long speakId) 
    {
        this.speakId = speakId;
    }

    public Long getSpeakId() 
    {
        return speakId;
    }
    public void setSpeakTitle(String speakTitle) 
    {
        this.speakTitle = speakTitle;
    }

    public String getSpeakTitle() 
    {
        return speakTitle;
    }
    public void setDetails(String details) 
    {
        this.details = details;
    }

    public String getDetails() 
    {
        return details;
    }
    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }
    public void setFileList(String fileList) 
    {
        this.fileList = fileList;
    }

    public String getFileList() 
    {
        return fileList;
    }
    public void setDelFlag(String delFlag) 
    {
        this.delFlag = delFlag;
    }

    public String getDelFlag() 
    {
        return delFlag;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("speakId", getSpeakId())
            .append("speakTitle", getSpeakTitle())
            .append("details", getDetails())
            .append("userId", getUserId())
            .append("fileList", getFileList())
            .append("remark", getRemark())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("delFlag", getDelFlag())
            .toString();
    }
}
