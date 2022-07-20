package com.shahenpc.system.domain.oa;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.shahenpc.common.annotation.Excel;
import com.shahenpc.common.core.domain.BaseEntity;

/**
 * 会议签到记录对象 oa_meeting_sign
 * 
 * @author ruoyi
 * @date 2022-07-19
 */
public class OaMeetingSign extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private Long signId;

    /** 会议id */
    @Excel(name = "会议id")
    private Long meetingId;

    /** 人员id */
    @Excel(name = "人员id")
    private Long personnelId;

    /**  */
    @Excel(name = "")
    private Long userId;

    public void setSignId(Long signId) 
    {
        this.signId = signId;
    }

    public Long getSignId() 
    {
        return signId;
    }
    public void setMeetingId(Long meetingId) 
    {
        this.meetingId = meetingId;
    }

    public Long getMeetingId() 
    {
        return meetingId;
    }
    public void setPersonnelId(Long personnelId) 
    {
        this.personnelId = personnelId;
    }

    public Long getPersonnelId() 
    {
        return personnelId;
    }
    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("signId", getSignId())
            .append("meetingId", getMeetingId())
            .append("personnelId", getPersonnelId())
            .append("userId", getUserId())
            .append("remark", getRemark())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("createBy", getCreateBy())
            .toString();
    }
}
