package com.shahenpc.system.domain.represent;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.shahenpc.common.annotation.Excel;
import com.shahenpc.common.core.domain.BaseEntity;

/**
 * 代-代发现对象 represent_discover
 *
 * @author ruoyi
 * @date 2022-07-28
 */
public class RepresentDiscover extends BaseEntity
{
    private static final long serialVersionUID = 1L;

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

    /** 状态 */
    @Excel(name = "状态")
    private Long status;

    /** 回复 */
    @Excel(name = "回复")
    private String reply;

    /** 评价 */
    @Excel(name = "评价")
    private Long rate;

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
    public void setStatus(Long status)
    {
        this.status = status;
    }

    public Long getStatus()
    {
        return status;
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
                .append("status", getStatus())
                .append("reply", getReply())
                .append("rate", getRate())
                .toString();
    }
}
