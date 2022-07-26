package com.shahenpc.system.domain.represent;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.shahenpc.common.annotation.Excel;
import com.shahenpc.common.core.domain.BaseEntity;

/**
 * 建议议案记录对象 represent_motion_record
 * 
 * @author ruoyi
 * @date 2022-07-26
 */
public class RepresentMotionRecord extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private Long recordId;

    /** 关联id */
    @Excel(name = "关联id")
    private Long motionId;

    /** 流程id */
    @Excel(name = "流程id")
    private String procinsId;

    /** 模板id */
    @Excel(name = "模板id")
    private String deployId;

    /**  */
    @Excel(name = "")
    private Long status;

    public void setRecordId(Long recordId) 
    {
        this.recordId = recordId;
    }

    public Long getRecordId() 
    {
        return recordId;
    }
    public void setMotionId(Long motionId) 
    {
        this.motionId = motionId;
    }

    public Long getMotionId() 
    {
        return motionId;
    }
    public void setProcinsId(String procinsId) 
    {
        this.procinsId = procinsId;
    }

    public String getProcinsId() 
    {
        return procinsId;
    }
    public void setDeployId(String deployId) 
    {
        this.deployId = deployId;
    }

    public String getDeployId() 
    {
        return deployId;
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
            .append("recordId", getRecordId())
            .append("motionId", getMotionId())
            .append("procinsId", getProcinsId())
            .append("deployId", getDeployId())
            .append("status", getStatus())
            .append("remark", getRemark())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .toString();
    }
}
