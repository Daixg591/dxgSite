package com.shahenpc.system.domain.represent;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.shahenpc.common.annotation.Excel;
import com.shahenpc.common.core.domain.BaseEntity;

/**
 * 代-活动列对象 represent_activity
 * 
 * @author ruoyi
 * @date 2022-07-21
 */
@Data
public class RepresentActivity extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    private RepresentActivityRecord records;



    /** 是否认领 */
    private boolean isClaim;

    /**  */
    private Long activityId;

    /** 活动类型 */
    @Excel(name = "活动类型")
    private Integer activityType;

    /** 标题 */
    @Excel(name = "标题")
    private String title;

    /** 开始 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "开始", width = 30, dateFormat = "yyyy-MM-dd")
    private Date startTime;

    /** 结束 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "结束", width = 30, dateFormat = "yyyy-MM-dd")
    private Date endTime;

    /** 地点 */
    @Excel(name = "地点")
    private String address;

    /** 状态 */
    @Excel(name = "状态")
    private Integer status;

    /** 参会人员 */
    @Excel(name = "参会人员")
    private Integer participateConut;

    /**  */
    @Excel(name = "")
    private String content;

    private Long sendUserId;

    /** 代表认领标识 */
    private Boolean npcClaim;

    /** 公开标识 */
    private String openFlag;

    /** 用户Id */
    private Long userId;

    public void setActivityId(Long activityId) 
    {
        this.activityId = activityId;
    }

    public Long getActivityId() 
    {
        return activityId;
    }
    public void setActivityType(Integer activityType) 
    {
        this.activityType = activityType;
    }

    public Integer getActivityType() 
    {
        return activityType;
    }
    public void setTitle(String title) 
    {
        this.title = title;
    }

    public String getTitle() 
    {
        return title;
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
    public void setStatus(Integer status) 
    {
        this.status = status;
    }

    public Integer getStatus() 
    {
        return status;
    }
    public void setParticipateConut(Integer participateConut)
    {
        this.participateConut = participateConut;
    }

    public Integer getParticipateConut()
    {
        return participateConut;
    }
    public void setContent(String content) 
    {
        this.content = content;
    }

    public String getContent() 
    {
        return content;
    }

    public boolean getClaim() {
        return isClaim;
    }

    public void setClaim(boolean claim) {
        isClaim = claim;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("activityId", getActivityId())
            .append("activityType", getActivityType())
            .append("remark", getRemark())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("createBy", getCreateBy())
            .append("title", getTitle())
            .append("startTime", getStartTime())
            .append("endTime", getEndTime())
            .append("address", getAddress())
            .append("status", getStatus())
            .append("participateConut", getParticipateConut())
            .append("content", getContent())
            .toString();
    }
}
