package com.shahenpc.system.domain.oa;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.shahenpc.common.annotation.Excel;
import com.shahenpc.common.core.domain.BaseEntity;

/**
 * 人大办公-会议管理对象 oa_meeting
 *
 * @author ruoyi
 * @date 2022-07-19
 */
public class OaMeeting extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private Long meetingId;

    /** 标题 */
    @Excel(name = "标题")
    private String title;

    /** 类型 */
    @Excel(name = "类型")
    private Integer meetingType;

    /**  */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "", width = 30, dateFormat = "yyyy-MM-dd")
    private Date startTime;

    /**  */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "", width = 30, dateFormat = "yyyy-MM-dd")
    private Date endTime;

    /** 地点 */
    @Excel(name = "地点")
    private String address;

    /** 内容 */
    @Excel(name = "内容")
    private String content;

    /** 是否签到 */
    @Excel(name = "是否签到")
    private Integer isSign;

    /** 会议状态 */
    @Excel(name = "会议状态")
    private Integer status;

    public void setMeetingId(Long meetingId)
    {
        this.meetingId = meetingId;
    }

    public Long getMeetingId()
    {
        return meetingId;
    }
    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getTitle()
    {
        return title;
    }
    public void setMeetingType(Integer meetingType)
    {
        this.meetingType = meetingType;
    }

    public Integer getMeetingType()
    {
        return meetingType;
    }
    public void setStartTime(Date startTime)
    {
        this.startTime = startTime;
    }

    public Date getStartTime()
    {
        return startTime;
    }
    public void setEndTime(Date endTime)
    {
        this.endTime = endTime;
    }

    public Date getEndTime()
    {
        return endTime;
    }
    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getAddress()
    {
        return address;
    }
    public void setContent(String content)
    {
        this.content = content;
    }

    public String getContent()
    {
        return content;
    }
    public void setIsSign(Integer isSign)
    {
        this.isSign = isSign;
    }

    public Integer getIsSign()
    {
        return isSign;
    }
    public void setStatus(Integer status)
    {
        this.status = status;
    }

    public Integer getStatus()
    {
        return status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("meetingId", getMeetingId())
                .append("title", getTitle())
                .append("meetingType", getMeetingType())
                .append("startTime", getStartTime())
                .append("endTime", getEndTime())
                .append("address", getAddress())
                .append("content", getContent())
                .append("isSign", getIsSign())
                .append("status", getStatus())
                .append("remark", getRemark())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .append("createBy", getCreateBy())
                .toString();
    }
}
