package com.shahenpc.system.domain.personel;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.shahenpc.common.annotation.Excel;
import com.shahenpc.common.core.domain.BaseEntity;

/**
 * 人事任免_述职报告对象 personnel_appoint_report
 * 
 * @author ruoyi
 * @date 2022-07-04
 */
public class PersonnelAppointReport extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 报告id */
    private Long reportId;

    /** 标题 */
    @Excel(name = "标题")
    private String reportTitle;

    /** 详情 */
    @Excel(name = "详情")
    private String details;

    /** 用户id */
    @Excel(name = "用户id")
    private Long userId;

    /** 文件集合 */
    @Excel(name = "文件集合")
    private String fileList;

    /** 删除标识 */
    private String delFlag;

    /** 任免记录Id */
    @Excel(name = "任免记录Id")
    private Long registerId;

    public void setReportId(Long reportId) 
    {
        this.reportId = reportId;
    }

    public Long getReportId() 
    {
        return reportId;
    }
    public void setReportTitle(String reportTitle) 
    {
        this.reportTitle = reportTitle;
    }

    public String getReportTitle() 
    {
        return reportTitle;
    }
    public void setDetails(String details) 
    {
        this.details = details;
    }

    public String getDetails() 
    {
        return details;
    }
    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }
    public void setFileList(String fileList) 
    {
        this.fileList = fileList;
    }

    public String getFileList() 
    {
        return fileList;
    }
    public void setDelFlag(String delFlag) 
    {
        this.delFlag = delFlag;
    }

    public String getDelFlag() 
    {
        return delFlag;
    }
    public void setRegisterId(Long registerId) 
    {
        this.registerId = registerId;
    }

    public Long getRegisterId() 
    {
        return registerId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("reportId", getReportId())
            .append("reportTitle", getReportTitle())
            .append("details", getDetails())
            .append("userId", getUserId())
            .append("fileList", getFileList())
            .append("remark", getRemark())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("delFlag", getDelFlag())
            .append("registerId", getRegisterId())
            .toString();
    }
}
