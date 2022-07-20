package com.shahenpc.system.domain.oa;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.shahenpc.common.annotation.Excel;
import com.shahenpc.common.core.domain.BaseEntity;

/**
 * 会议人员对象 oa_meeting_personnel
 * 
 * @author ruoyi
 * @date 2022-07-19
 */
public class OaMeetingPersonnel extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private Long personnelId;

    /** 会议id */
    @Excel(name = "会议id")
    private Long meetingId;

    /**  */
    @Excel(name = "")
    private Long userId;

    /**  */
    @Excel(name = "")
    private Long deptId;

    /**  */
    @Excel(name = "")
    private Integer isSign;

    /**  */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "", width = 30, dateFormat = "yyyy-MM-dd")
    private Date signTime;

    public void setPersonnelId(Long personnelId) 
    {
        this.personnelId = personnelId;
    }

    public Long getPersonnelId() 
    {
        return personnelId;
    }
    public void setMeetingId(Long meetingId) 
    {
        this.meetingId = meetingId;
    }

    public Long getMeetingId() 
    {
        return meetingId;
    }
    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }
    public void setDeptId(Long deptId) 
    {
        this.deptId = deptId;
    }

    public Long getDeptId() 
    {
        return deptId;
    }
    public void setIsSign(Integer isSign) 
    {
        this.isSign = isSign;
    }

    public Integer getIsSign() 
    {
        return isSign;
    }
    public void setSignTime(Date signTime) 
    {
        this.signTime = signTime;
    }

    public Date getSignTime() 
    {
        return signTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("personnelId", getPersonnelId())
            .append("meetingId", getMeetingId())
            .append("userId", getUserId())
            .append("deptId", getDeptId())
            .append("isSign", getIsSign())
            .append("signTime", getSignTime())
            .append("remark", getRemark())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("createBy", getCreateBy())
            .toString();
    }
}
