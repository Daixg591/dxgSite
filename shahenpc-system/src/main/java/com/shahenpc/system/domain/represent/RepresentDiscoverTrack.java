package com.shahenpc.system.domain.represent;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.shahenpc.common.annotation.Excel;
import com.shahenpc.common.core.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 represent_discover_track
 * 
 * @author ruoyi
 * @date 2022-07-30
 */
public class RepresentDiscoverTrack extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private Long trackId;

    /** 发现id */
    @Excel(name = "发现id")
    private Long discoverId;

    /** 发送用户id 0-系统消息 */
    @Excel(name = "发送用户id 0-系统消息")
    private Long sendUserId;

    /** 接收人用户id 0-全部 */
    @Excel(name = "接收人用户id 0-全部")
    private Long receiveUserId;

    /** 内容 */
    @Excel(name = "内容")
    private String content;

    /** 状态 */
    @Excel(name = "状态")
    private Long status;

    public void setTrackId(Long trackId) 
    {
        this.trackId = trackId;
    }

    public Long getTrackId() 
    {
        return trackId;
    }
    public void setDiscoverId(Long discoverId) 
    {
        this.discoverId = discoverId;
    }

    public Long getDiscoverId() 
    {
        return discoverId;
    }
    public void setSendUserId(Long sendUserId) 
    {
        this.sendUserId = sendUserId;
    }

    public Long getSendUserId() 
    {
        return sendUserId;
    }
    public void setReceiveUserId(Long receiveUserId) 
    {
        this.receiveUserId = receiveUserId;
    }

    public Long getReceiveUserId() 
    {
        return receiveUserId;
    }
    public void setContent(String content) 
    {
        this.content = content;
    }

    public String getContent() 
    {
        return content;
    }
    public void setStatus(Long status) 
    {
        this.status = status;
    }

    public Long getStatus() 
    {
        return status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("trackId", getTrackId())
            .append("discoverId", getDiscoverId())
            .append("sendUserId", getSendUserId())
            .append("receiveUserId", getReceiveUserId())
            .append("content", getContent())
            .append("status", getStatus())
            .append("remark", getRemark())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("createBy", getCreateBy())
            .toString();
    }
}
