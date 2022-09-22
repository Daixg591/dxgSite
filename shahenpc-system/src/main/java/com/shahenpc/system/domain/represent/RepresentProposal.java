package com.shahenpc.system.domain.represent;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.shahenpc.common.annotation.Excel;
import com.shahenpc.common.core.domain.BaseEntity;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 代-建议对象 represent_proposal
 * 
 * @author ruoyi
 * @date 2022-09-20
 */
@Data
public class RepresentProposal extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long proposalId;

    /** 案号 */
    @Excel(name = "案号")
    private Integer number;

    /** 类型 */
    @Excel(name = "类型")
    private Long type;

    /** 标题 */
    @Excel(name = "标题")
    private String title;

    /** 建议人 */
    @Excel(name = "建议人")
    private String proposalName;

    /** 状态 */
    @Excel(name = "状态")
    private Long status;

    /** 满意率 */
    @Excel(name = "满意率")
    private Integer rate;

    /** 内容 */
    @Excel(name = "内容")
    private String content;

    /** 主办 */
    @Excel(name = "主办")
    private String lordDo;

    /** 会办 */
    @Excel(name = "会办")
    private String willDo;

    /** 答复内容 */
    @Excel(name = "答复内容")
    private String replyContent;

    /** 答复时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "答复时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date replyTime;

    public void setProposalId(Long proposalId)
    {
        this.proposalId = proposalId;
    }

    public Long getProposalId()
    {
        return proposalId;
    }
    public void setType(Long type)
    {
        this.type = type;
    }

    public Long getType() 
    {
        return type;
    }
    public void setTitle(String title) 
    {
        this.title = title;
    }

    public String getTitle() 
    {
        return title;
    }
    public void setProposalName(String proposalName) 
    {
        this.proposalName = proposalName;
    }

    public String getProposalName() 
    {
        return proposalName;
    }
    public void setStatus(Long status) 
    {
        this.status = status;
    }

    public Long getStatus() 
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
    public void setLordDo(String lordDo) 
    {
        this.lordDo = lordDo;
    }

    public String getLordDo() 
    {
        return lordDo;
    }
    public void setWillDo(String willDo) 
    {
        this.willDo = willDo;
    }

    public String getWillDo() 
    {
        return willDo;
    }
    public void setReplyContent(String replyContent) 
    {
        this.replyContent = replyContent;
    }

    public String getReplyContent() 
    {
        return replyContent;
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
            .append("proposalId", getProposalId())
            .append("number", getNumber())
            .append("type", getType())
            .append("title", getTitle())
            .append("proposalName", getProposalName())
            .append("status", getStatus())
            .append("rate", getRate())
            .append("content", getContent())
            .append("lordDo", getLordDo())
            .append("willDo", getWillDo())
            .append("replyContent", getReplyContent())
            .append("replyTime", getReplyTime())
            .append("remark", getRemark())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
