package com.shahenpc.system.domain.job;

import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.shahenpc.common.annotation.Excel;
import com.shahenpc.common.core.domain.BaseEntity;

/**
 * 工作-建议议案处理对象 job_motion
 * 
 * @author ruoyi
 * @date 2022-07-06
 */
@Data
public class JobMotion extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private Long motionId;

    /** 议案类型 */
    @Excel(name = "议案类型")
    private Integer motionType;

    /**  */
    @Excel(name = "")
    private String title;

    /**  */
    @Excel(name = "")
    private String content;

    /** 多个逗号分割 */
    @Excel(name = "多个逗号分割")
    private String suggestUserId;

    /** 状态 */
    @Excel(name = "状态")
    private Integer status;

    /** 关联 原 流程id */
    @Excel(name = "关联 原 流程id")
    private String workflowId;
    @Excel(name = "分割用户名字")
    private String suggestUserName;

    /** 发送id */
    @Excel(name = "发送id")
    private Long sendUserId;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String sendUserName;


    public void setMotionId(Long motionId) 
    {
        this.motionId = motionId;
    }

    public Long getMotionId() 
    {
        return motionId;
    }
    public void setMotionType(Integer motionType) 
    {
        this.motionType = motionType;
    }

    public Integer getMotionType() 
    {
        return motionType;
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
    public void setSuggestUserId(String suggestUserId) 
    {
        this.suggestUserId = suggestUserId;
    }

    public String getSuggestUserId() 
    {
        return suggestUserId;
    }
    public void setStatus(Integer status) 
    {
        this.status = status;
    }

    public Integer getStatus() 
    {
        return status;
    }
    public void setWorkflowId(String workflowId) 
    {
        this.workflowId = workflowId;
    }

    public String getWorkflowId() 
    {
        return workflowId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("motionId", getMotionId())
            .append("motionType", getMotionType())
            .append("title", getTitle())
            .append("content", getContent())
            .append("suggestUserId", getSuggestUserId())
            .append("status", getStatus())
            .append("remark", getRemark())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("workflowId", getWorkflowId())
            .toString();
    }
}
