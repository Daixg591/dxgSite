package com.shahenpc.system.domain.represent;

import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.shahenpc.common.annotation.Excel;
import com.shahenpc.common.core.domain.BaseEntity;

/**
 * 代发现对象 represent_discover
 * 
 * @author ruoyi
 * @date 2022-09-09
 */
@Data
public class RepresentDiscover extends BaseEntity
{
    private static final long serialVersionUID = 1L;
    /** 联络站Id */
    @Excel(name = "联络站Id")
    private Long stationId;
    /**  */
    private Long discoverId;

    /**  */
    @Excel(name = "")
    private String title;

    /**  */
    @Excel(name = "")
    private String content;

    /** 发现类型 */
    @Excel(name = "发现类型")
    private Long discoverType;

    /** 通讯地点 */
    @Excel(name = "通讯地点")
    private String address;

    /** 经纬度逗号分割 */
    @Excel(name = "经纬度逗号分割")
    private String location;

    /** 回复 */
    @Excel(name = "回复")
    private String reply;

    /** 评价 */
    @Excel(name = "评价")
    private Long rate;

    /** 发送用户id 0-系统消息 */
    @Excel(name = "发送用户id 0-系统消息")
    private Long sendUserId;

    /** 接收人用户id 0-全部 */
    @Excel(name = "接收人用户id 0-全部")
    private Long receiveUserId;

    /** 状态 */
    @Excel(name = "状态")
    private Integer status;

    /** 流程类型 */
    @Excel(name = "流程类型")
    private Integer processType;

    /** 多个照片 */
    @Excel(name = "多个照片")
    private String picUrls;

    public void setDiscoverId(Long discoverId) 
    {
        this.discoverId = discoverId;
    }

    public Long getDiscoverId() 
    {
        return discoverId;
    }
    public void setTitle(String title) 
    {
        this.title = title;
    }

    public String getTitle() 
    {
        return title;
    }
    public void setContent(String content) 
    {
        this.content = content;
    }

    public String getContent() 
    {
        return content;
    }
    public void setDiscoverType(Long discoverType) 
    {
        this.discoverType = discoverType;
    }

    public Long getDiscoverType() 
    {
        return discoverType;
    }
    public void setAddress(String address) 
    {
        this.address = address;
    }

    public String getAddress() 
    {
        return address;
    }
    public void setLocation(String location) 
    {
        this.location = location;
    }

    public String getLocation() 
    {
        return location;
    }
    public void setReply(String reply) 
    {
        this.reply = reply;
    }

    public String getReply() 
    {
        return reply;
    }
    public void setRate(Long rate) 
    {
        this.rate = rate;
    }

    public Long getRate() 
    {
        return rate;
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
    public void setStatus(Integer status)
    {
        this.status = status;
    }

    public Integer getStatus()
    {
        return status;
    }
    public void setProcessType(Integer processType)
    {
        this.processType = processType;
    }

    public Integer getProcessType()
    {
        return processType;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("discoverId", getDiscoverId())
            .append("title", getTitle())
            .append("content", getContent())
            .append("discoverType", getDiscoverType())
            .append("remark", getRemark())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("createBy", getCreateBy())
            .append("address", getAddress())
            .append("location", getLocation())
            .append("reply", getReply())
            .append("rate", getRate())
            .append("sendUserId", getSendUserId())
            .append("receiveUserId", getReceiveUserId())
            .append("status", getStatus())
            .append("processType", getProcessType())
            .toString();
    }
}
