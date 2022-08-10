package com.shahenpc.system.domain.oa;

import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.shahenpc.common.annotation.Excel;
import com.shahenpc.common.core.domain.BaseEntity;

/**
 * 会议记录对象 oa_meeting_record
 * 
 * @author ruoyi
 * @date 2022-07-19
 */
@Data
public class OaMeetingRecord extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private Long recordId;

    /** 会议id */
    @Excel(name = "会议id")
    private Long meetingId;

    /**  */
    @Excel(name = "")
    private Long userId;
    /**  */
    @Excel(name = "")
    private String title;
    /** 内容 */
    @Excel(name = "内容")
    private String content;

    public void setRecordId(Long recordId) 
    {
        this.recordId = recordId;
    }

    public Long getRecordId() 
    {
        return recordId;
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
    public void setContent(String content) 
    {
        this.content = content;
    }

    public String getContent() 
    {
        return content;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("recordId", getRecordId())
            .append("meetingId", getMeetingId())
            .append("userId", getUserId())
            .append("content", getContent())
            .append("remark", getRemark())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("createBy", getCreateBy())
            .toString();
    }
}
