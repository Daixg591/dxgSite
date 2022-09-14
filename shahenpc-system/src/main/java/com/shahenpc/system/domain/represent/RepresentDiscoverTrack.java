package com.shahenpc.system.domain.represent;

import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.shahenpc.common.annotation.Excel;
import com.shahenpc.common.core.domain.BaseEntity;

/**
 * 代发现-记录对象 represent_discover_track
 * 
 * @author ruoyi
 * @date 2022-09-09
 */
@Data
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

    /**  */
    @Excel(name = "")
    private String revert;

    /** 状态 */
    @Excel(name = "状态")
    private Integer status;

    /** 流程类型 */
    @Excel(name = "流程类型")
    private Integer processType;

    /** 多个照片 */
    @Excel(name = "多个照片")
    private String picUrls;

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
    public void setRevert(String revert) 
    {
        this.revert = revert;
    }

    public String getRevert() 
    {
        return revert;
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
            .append("trackId", getTrackId())
            .append("discoverId", getDiscoverId())
            .append("sendUserId", getSendUserId())
            .append("receiveUserId", getReceiveUserId())
            .append("remark", getRemark())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("createBy", getCreateBy())
            .append("revert", getRevert())
            .append("status", getStatus())
            .append("processType", getProcessType())
            .toString();
    }
}
