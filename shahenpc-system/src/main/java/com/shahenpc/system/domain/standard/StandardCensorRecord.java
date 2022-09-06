package com.shahenpc.system.domain.standard;

import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.shahenpc.common.annotation.Excel;
import com.shahenpc.common.core.domain.BaseEntity;

/**
 * 审查记录统计对象 standard_censor_record
 * 
 * @author ruoyi
 * @date 2022-07-27
 */
@Data
public class StandardCensorRecord extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private Long recordId;

    /** 关联id */
    @Excel(name = "关联id")
    private Long censorId;

    /** 流程id */
    @Excel(name = "流程id")
    private String procinsId;

    /** 模板id */
    @Excel(name = "模板id")
    private String deployId;

    /** 发件人 */
    @Excel(name = "发件人")
    private Long sendUserId;

    /** 收件人 */
    @Excel(name = "收件人")
    private Long receiveUserId;

    /** 内容 */
    @Excel(name = "内容")
    private String revert;

    /** 流程类型 */
    @Excel(name = "流程类型")
    private Integer type;

    /** 类型状态 */
    @Excel(name = "类型状态")
    private Integer status;


    public void setRecordId(Long recordId) 
    {
        this.recordId = recordId;
    }

    public Long getRecordId() 
    {
        return recordId;
    }
    public void setCensorId(Long censorId) 
    {
        this.censorId = censorId;
    }

    public Long getCensorId() 
    {
        return censorId;
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

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("recordId", getRecordId())
            .append("censorId", getCensorId())
            .append("procinsId", getProcinsId())
            .append("deployId", getDeployId())
            .append("status", getStatus())
            .append("remark", getRemark())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("sendUserId", getSendUserId())
            .append("receiveUserId", getReceiveUserId())
            .toString();
    }
}
