package com.shahenpc.system.domain.standard;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.shahenpc.common.annotation.Excel;
import com.shahenpc.common.core.domain.BaseEntity;

/**
 * 审查流程对象 standard_censor
 * 
 * @author ruoyi
 * @date 2022-07-22
 */
public class StandardCensor extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private Long processId;

    /** 文件类型 */
    @Excel(name = "文件类型")
    private Integer fileType;

    /** 文件名 */
    @Excel(name = "文件名")
    private String fileName;

    /** 备案机构 */
    @Excel(name = "备案机构")
    private String recordAgencies;

    /** 备案编号 */
    @Excel(name = "备案编号")
    private String recordSerial;

    /** 报备机构 */
    @Excel(name = "报备机构")
    private String reportAgencies;

    /** 报备编号 */
    @Excel(name = "报备编号")
    private String reportSerial;

    /** 通过日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "通过日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date passDate;

    /** 通过机构 */
    @Excel(name = "通过机构")
    private String passAgencies;

    /** 公告日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "公告日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date bulletinDate;

    /** 实施日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "实施日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date enforceDate;

    /** 文件存储地址 */
    @Excel(name = "文件存储地址")
    private String fileUrl;

    /** 受理审批人id */
    @Excel(name = "受理审批人id")
    private Long acceptUserId;

    /** 受理审批人Name */
    @Excel(name = "受理审批人Name")
    private String acceptUserName;

    /**  */
    @Excel(name = "")
    private Long copyUserId;

    /**  */
    @Excel(name = "")
    private String copyUserName;

    /** 流程类型 */
    @Excel(name = "流程类型")
    private Integer processType;

    /** 关联 原 流程id */
    @Excel(name = "关联 原 流程id")
    private String workflowId;

    /** 流程位置 */
    @Excel(name = "流程位置")
    private String censorTache;

    /** 状态 */
    @Excel(name = "状态")
    private Integer status;

    public void setProcessId(Long processId) 
    {
        this.processId = processId;
    }

    public Long getProcessId() 
    {
        return processId;
    }
    public void setFileType(Integer fileType) 
    {
        this.fileType = fileType;
    }

    public Integer getFileType() 
    {
        return fileType;
    }
    public void setFileName(String fileName) 
    {
        this.fileName = fileName;
    }

    public String getFileName() 
    {
        return fileName;
    }
    public void setRecordAgencies(String recordAgencies) 
    {
        this.recordAgencies = recordAgencies;
    }

    public String getRecordAgencies() 
    {
        return recordAgencies;
    }
    public void setRecordSerial(String recordSerial) 
    {
        this.recordSerial = recordSerial;
    }

    public String getRecordSerial() 
    {
        return recordSerial;
    }
    public void setReportAgencies(String reportAgencies) 
    {
        this.reportAgencies = reportAgencies;
    }

    public String getReportAgencies() 
    {
        return reportAgencies;
    }
    public void setReportSerial(String reportSerial) 
    {
        this.reportSerial = reportSerial;
    }

    public String getReportSerial() 
    {
        return reportSerial;
    }
    public void setPassDate(Date passDate) 
    {
        this.passDate = passDate;
    }

    public Date getPassDate() 
    {
        return passDate;
    }
    public void setPassAgencies(String passAgencies) 
    {
        this.passAgencies = passAgencies;
    }

    public String getPassAgencies() 
    {
        return passAgencies;
    }
    public void setBulletinDate(Date bulletinDate) 
    {
        this.bulletinDate = bulletinDate;
    }

    public Date getBulletinDate() 
    {
        return bulletinDate;
    }
    public void setEnforceDate(Date enforceDate) 
    {
        this.enforceDate = enforceDate;
    }

    public Date getEnforceDate() 
    {
        return enforceDate;
    }
    public void setFileUrl(String fileUrl) 
    {
        this.fileUrl = fileUrl;
    }

    public String getFileUrl() 
    {
        return fileUrl;
    }
    public void setAcceptUserId(Long acceptUserId) 
    {
        this.acceptUserId = acceptUserId;
    }

    public Long getAcceptUserId() 
    {
        return acceptUserId;
    }
    public void setAcceptUserName(String acceptUserName) 
    {
        this.acceptUserName = acceptUserName;
    }

    public String getAcceptUserName() 
    {
        return acceptUserName;
    }
    public void setCopyUserId(Long copyUserId) 
    {
        this.copyUserId = copyUserId;
    }

    public Long getCopyUserId() 
    {
        return copyUserId;
    }
    public void setCopyUserName(String copyUserName) 
    {
        this.copyUserName = copyUserName;
    }

    public String getCopyUserName() 
    {
        return copyUserName;
    }
    public void setProcessType(Integer processType) 
    {
        this.processType = processType;
    }

    public Integer getProcessType() 
    {
        return processType;
    }
    public void setWorkflowId(String workflowId) 
    {
        this.workflowId = workflowId;
    }

    public String getWorkflowId() 
    {
        return workflowId;
    }
    public void setCensorTache(String censorTache) 
    {
        this.censorTache = censorTache;
    }

    public String getCensorTache() 
    {
        return censorTache;
    }
    public void setStatus(Integer status) 
    {
        this.status = status;
    }

    public Integer getStatus() 
    {
        return status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("processId", getProcessId())
            .append("fileType", getFileType())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .append("fileName", getFileName())
            .append("recordAgencies", getRecordAgencies())
            .append("recordSerial", getRecordSerial())
            .append("reportAgencies", getReportAgencies())
            .append("reportSerial", getReportSerial())
            .append("passDate", getPassDate())
            .append("passAgencies", getPassAgencies())
            .append("bulletinDate", getBulletinDate())
            .append("enforceDate", getEnforceDate())
            .append("fileUrl", getFileUrl())
            .append("acceptUserId", getAcceptUserId())
            .append("acceptUserName", getAcceptUserName())
            .append("copyUserId", getCopyUserId())
            .append("copyUserName", getCopyUserName())
            .append("processType", getProcessType())
            .append("workflowId", getWorkflowId())
            .append("censorTache", getCensorTache())
            .append("status", getStatus())
            .toString();
    }
}
