package com.shahenpc.system.domain.personel;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.shahenpc.common.annotation.Excel;
import com.shahenpc.common.core.domain.BaseEntity;

/**
 * 人事任免_议案提请对象 personnel_appoint_bill
 * 
 * @author ruoyi
 * @date 2022-07-04
 */
public class PersonnelAppointBill extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 议案提请id */
    private Long billId;

    /** 标题 */
    @Excel(name = "标题")
    private String billTitle;

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

    /** 任免记录id */
    @Excel(name = "任免记录id")
    private Long registerId;

    public void setBillId(Long billId) 
    {
        this.billId = billId;
    }

    public Long getBillId() 
    {
        return billId;
    }
    public void setBillTitle(String billTitle) 
    {
        this.billTitle = billTitle;
    }

    public String getBillTitle() 
    {
        return billTitle;
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
            .append("billId", getBillId())
            .append("billTitle", getBillTitle())
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
