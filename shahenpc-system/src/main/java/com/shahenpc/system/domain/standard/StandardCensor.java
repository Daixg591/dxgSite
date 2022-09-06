package com.shahenpc.system.domain.standard;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
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
@Data
public class StandardCensor extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private Long censorId;

    /** 报备标题 */
    @Excel(name = "报备标题")
    private String reportTitle;

    /** 报备类型 */
    @Excel(name = "报备类型")
    private Integer reportType;

    /** 文件名字 */
    @Excel(name = "文件名字")
    private String fileName;

    /** 文件性质 */
    @Excel(name = "文件性质")
    private String fileNature;

    /** 报备文号 */
    @Excel(name = "报备文号")
    private String reportWen;

    /** 报备机关 */
    @Excel(name = "报备机关")
    private String reportOrgan;

    /** 通过机关 */
    @Excel(name = "通过机关")
    private String passOrgan;

    /** 备案机关 */
    @Excel(name = "备案机关")
    private String recordOrgan;

    /** 公布日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "公布日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date announcedTime;

    /** 制发日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "制发日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date hairdressingTime;

    /** 施行日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "施行日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date administerTime;

    /** 备案日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "备案日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date recordTime;

    /** 联系人 */
    @Excel(name = "联系人")
    private String contactName;

    /** 联系电话 */
    @Excel(name = "联系电话")
    private String contactPhone;

    /** 文件存储地址 */
    @Excel(name = "文件存储地址")
    private String fileList;

    /** 流程类型 */
    @Excel(name = "流程类型")
    private Integer type;

    /** 类型状态 */
    @Excel(name = "类型状态")
    private Integer status;


    /** 流程类型 */
    @Excel(name = "流程类型")
    private Integer processType;

    /** 流程位置 */
    @Excel(name = "流程位置")
    private String censorTache;

    /** 发文机关 */
    @Excel(name = "发文机关")
    private Long approvalUserId;

    /** 流程id */
    @Excel(name = "流程id")
    private String procinsId;

    /** 模板id */
    @Excel(name = "模板id")
    private String deployId;

    /** 发送id */
    @Excel(name = "发送id")
    private Long sendUserId;

    /** 地点 */
    @Excel(name = "地点")
    private String address;

    /**  */
    @Excel(name = "")
    private Long rate;

    /** 备案报告 */
    @Excel(name = "备案报告")
    private String recordReport;

    /** 正式文本 */
    @Excel(name = "正式文本")
    private String formalText;

    /** 制定说明 */
    @Excel(name = "制定说明")
    private String formulateExplain;

    /** 相关法律法规依据 */
    @Excel(name = "相关法律法规依据")
    private String basis;

    /** 其他 */
    @Excel(name = "其他")
    private String other;

    /** 失效时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "失效时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date lapseTime;


    /** 收件人 */
    @Excel(name = "收件人")
    private String receiveUserId;

    public void setCensorId(Long censorId)
    {
        this.censorId = censorId;
    }

    public Long getCensorId()
    {
        return censorId;
    }
    public void setReportTitle(String reportTitle)
    {
        this.reportTitle = reportTitle;
    }

    public String getReportTitle()
    {
        return reportTitle;
    }
    public void setReportType(Integer reportType)
    {
        this.reportType = reportType;
    }

    public Integer getReportType()
    {
        return reportType;
    }
    public void setFileName(String fileName)
    {
        this.fileName = fileName;
    }

    public String getFileName()
    {
        return fileName;
    }
    public void setFileNature(String fileNature)
    {
        this.fileNature = fileNature;
    }

    public String getFileNature()
    {
        return fileNature;
    }
    public void setReportWen(String reportWen)
    {
        this.reportWen = reportWen;
    }

    public String getReportWen()
    {
        return reportWen;
    }
    public void setReportOrgan(String reportOrgan)
    {
        this.reportOrgan = reportOrgan;
    }

    public String getReportOrgan()
    {
        return reportOrgan;
    }
    public void setPassOrgan(String passOrgan)
    {
        this.passOrgan = passOrgan;
    }

    public String getPassOrgan()
    {
        return passOrgan;
    }
    public void setRecordOrgan(String recordOrgan)
    {
        this.recordOrgan = recordOrgan;
    }

    public String getRecordOrgan()
    {
        return recordOrgan;
    }
    public void setAnnouncedTime(Date announcedTime)
    {
        this.announcedTime = announcedTime;
    }

    public Date getAnnouncedTime()
    {
        return announcedTime;
    }
    public void setHairdressingTime(Date hairdressingTime)
    {
        this.hairdressingTime = hairdressingTime;
    }

    public Date getHairdressingTime()
    {
        return hairdressingTime;
    }
    public void setAdministerTime(Date administerTime)
    {
        this.administerTime = administerTime;
    }

    public Date getAdministerTime()
    {
        return administerTime;
    }
    public void setRecordTime(Date recordTime)
    {
        this.recordTime = recordTime;
    }

    public Date getRecordTime()
    {
        return recordTime;
    }
    public void setContactName(String contactName)
    {
        this.contactName = contactName;
    }

    public String getContactName()
    {
        return contactName;
    }
    public void setContactPhone(String contactPhone)
    {
        this.contactPhone = contactPhone;
    }

    public String getContactPhone()
    {
        return contactPhone;
    }
    public void setFileList(String fileList)
    {
        this.fileList = fileList;
    }


    public void setProcessType(Integer processType)
    {
        this.processType = processType;
    }

    public Integer getProcessType()
    {
        return processType;
    }
    public void setCensorTache(String censorTache)
    {
        this.censorTache = censorTache;
    }

    public String getCensorTache()
    {
        return censorTache;
    }
    public void setApprovalUserId(Long approvalUserId)
    {
        this.approvalUserId = approvalUserId;
    }

    public Long getApprovalUserId()
    {
        return approvalUserId;
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
    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getAddress()
    {
        return address;
    }
    public void setRate(Long rate)
    {
        this.rate = rate;
    }

    public Long getRate()
    {
        return rate;
    }
    public void setRecordReport(String recordReport)
    {
        this.recordReport = recordReport;
    }

    public String getRecordReport()
    {
        return recordReport;
    }
    public void setFormalText(String formalText)
    {
        this.formalText = formalText;
    }

    public String getFormalText()
    {
        return formalText;
    }
    public void setFormulateExplain(String formulateExplain)
    {
        this.formulateExplain = formulateExplain;
    }

    public String getFormulateExplain()
    {
        return formulateExplain;
    }
    public void setBasis(String basis)
    {
        this.basis = basis;
    }

    public String getBasis()
    {
        return basis;
    }
    public void setOther(String other)
    {
        this.other = other;
    }

    public String getOther()
    {
        return other;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("censorId", getCensorId())
                .append("reportTitle", getReportTitle())
                .append("reportType", getReportType())
                .append("fileName", getFileName())
                .append("fileNature", getFileNature())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .append("remark", getRemark())
                .append("reportWen", getReportWen())
                .append("reportOrgan", getReportOrgan())
                .append("passOrgan", getPassOrgan())
                .append("recordOrgan", getRecordOrgan())
                .append("announcedTime", getAnnouncedTime())
                .append("hairdressingTime", getHairdressingTime())
                .append("administerTime", getAdministerTime())
                .append("recordTime", getRecordTime())
                .append("contactName", getContactName())
                .append("contactPhone", getContactPhone())
                .append("fileList", getFileList())
                .append("status", getStatus())
                .append("processType", getProcessType())
                .append("censorTache", getCensorTache())
                .append("approvalUserId", getApprovalUserId())
                .append("procinsId", getProcinsId())
                .append("deployId", getDeployId())
                .append("sendUserId", getSendUserId())
                .append("address", getAddress())
                .append("rate", getRate())
                .append("recordReport", getRecordReport())
                .append("formalText", getFormalText())
                .append("formulateExplain", getFormulateExplain())
                .append("basis", getBasis())
                .append("other", getOther())
                .toString();
    }
}
