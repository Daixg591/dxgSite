package com.shahenpc.system.domain.feature;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.shahenpc.common.annotation.Excel;
import com.shahenpc.common.core.domain.BaseEntity;

/**
 * 双连工作 聊天对象 feature_double_work_trace
 * 
 * @author ruoyi
 * @date 2022-07-13
 */
public class FeatureDoubleWorkTrace extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 追踪ID */
    private Long traceId;

    /** 关联意见表 */
    @Excel(name = "关联意见表")
    private Long doubleId;

    /** 发送id */
    @Excel(name = "发送id")
    private Long sendUserId;

    /** 接收id */
    @Excel(name = "接收id")
    private Long receiveUserId;

    /** 1.待审核2.处理中 3.办结 4关闭 */
    @Excel(name = "1.待审核2.处理中 3.办结 4关闭")
    private Integer status;

    /** 回复 */
    @Excel(name = "回复")
    private String content;

    public void setTraceId(Long traceId) 
    {
        this.traceId = traceId;
    }

    public Long getTraceId() 
    {
        return traceId;
    }
    public void setDoubleId(Long doubleId) 
    {
        this.doubleId = doubleId;
    }

    public Long getDoubleId() 
    {
        return doubleId;
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
            .append("doubleId", getDoubleId())
            .append("sendUserId", getSendUserId())
            .append("receiveUserId", getReceiveUserId())
            .append("status", getStatus())
            .append("content", getContent())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
