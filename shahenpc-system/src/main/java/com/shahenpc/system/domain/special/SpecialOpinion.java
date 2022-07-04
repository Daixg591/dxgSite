package com.shahenpc.system.domain.special;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.shahenpc.common.annotation.Excel;
import com.shahenpc.common.core.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 special_opinion
 * 
 * @author ruoyi
 * @date 2022-07-01
 */
public class SpecialOpinion extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private Long opinionId;

    /** 意见类型 */
    @Excel(name = "意见类型")
    private Integer opinionType;

    /** 内容 */
    @Excel(name = "内容")
    private String content;

    /** 提交id */
    @Excel(name = "提交id")
    private Long submitUserId;

    /** 提交昵称 */
    @Excel(name = "提交昵称")
    private String submitNickName;

    /** 手机号 */
    @Excel(name = "手机号")
    private String submitPhone;

    /** 接收人id */
    @Excel(name = "接收人id")
    private Long receiveUserId;

    /** 接收人名字 */
    @Excel(name = "接收人名字")
    private String receiveNickName;

    /** 接收人回复 */
    @Excel(name = "接收人回复")
    private String receiveReply;

    /** 状态 */
    @Excel(name = "状态")
    private String status;

    /** 回复时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "回复时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date replyTime;

    public void setOpinionId(Long opinionId) 
    {
        this.opinionId = opinionId;
    }

    public Long getOpinionId() 
    {
        return opinionId;
    }
    public void setOpinionType(Integer opinionType) 
    {
        this.opinionType = opinionType;
    }

    public Integer getOpinionType() 
    {
        return opinionType;
    }
    public void setContent(String content) 
    {
        this.content = content;
    }

    public String getContent() 
    {
        return content;
    }
    public void setSubmitUserId(Long submitUserId) 
    {
        this.submitUserId = submitUserId;
    }

    public Long getSubmitUserId() 
    {
        return submitUserId;
    }
    public void setSubmitNickName(String submitNickName) 
    {
        this.submitNickName = submitNickName;
    }

    public String getSubmitNickName() 
    {
        return submitNickName;
    }
    public void setSubmitPhone(String submitPhone) 
    {
        this.submitPhone = submitPhone;
    }

    public String getSubmitPhone() 
    {
        return submitPhone;
    }
    public void setReceiveUserId(Long receiveUserId) 
    {
        this.receiveUserId = receiveUserId;
    }

    public Long getReceiveUserId() 
    {
        return receiveUserId;
    }
    public void setReceiveNickName(String receiveNickName) 
    {
        this.receiveNickName = receiveNickName;
    }

    public String getReceiveNickName() 
    {
        return receiveNickName;
    }
    public void setReceiveReply(String receiveReply) 
    {
        this.receiveReply = receiveReply;
    }

    public String getReceiveReply() 
    {
        return receiveReply;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }
    public void setReplyTime(Date replyTime) 
    {
        this.replyTime = replyTime;
    }

    public Date getReplyTime() 
    {
        return replyTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("opinionId", getOpinionId())
            .append("opinionType", getOpinionType())
            .append("content", getContent())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .append("submitUserId", getSubmitUserId())
            .append("submitNickName", getSubmitNickName())
            .append("submitPhone", getSubmitPhone())
            .append("receiveUserId", getReceiveUserId())
            .append("receiveNickName", getReceiveNickName())
            .append("receiveReply", getReceiveReply())
            .append("status", getStatus())
            .append("replyTime", getReplyTime())
            .toString();
    }
}
