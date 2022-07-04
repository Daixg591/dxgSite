package com.shahenpc.system.domain.special;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.shahenpc.common.annotation.Excel;
import com.shahenpc.common.core.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 special_opinion_trace
 * 
 * @author ruoyi
 * @date 2022-07-01
 */
public class SpecialOpinionTrace extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 追踪ID */
    private Long traceId;

    /** 关联意见表 */
    @Excel(name = "关联意见表")
    private Long opinionId;

    /** 发送id */
    @Excel(name = "发送id")
    private Long sendUserId;

    /** 接收id */
    @Excel(name = "接收id")
    private Long receiveUserId;

    /** 内容 */
    @Excel(name = "内容")
    private String content;

    public void setTraceId(Long traceId) 
    {
        this.traceId = traceId;
    }

    public Long getTraceId() 
    {
        return traceId;
    }
    public void setOpinionId(Long opinionId) 
    {
        this.opinionId = opinionId;
    }

    public Long getOpinionId() 
    {
        return opinionId;
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

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("traceId", getTraceId())
            .append("opinionId", getOpinionId())
            .append("sendUserId", getSendUserId())
            .append("receiveUserId", getReceiveUserId())
            .append("content", getContent())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
