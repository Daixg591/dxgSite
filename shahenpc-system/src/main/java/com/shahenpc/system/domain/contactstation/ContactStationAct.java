package com.shahenpc.system.domain.contactstation;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.shahenpc.common.annotation.Excel;
import com.shahenpc.common.core.domain.BaseEntity;

/**
 * 联络站活动对象 contact_station_act
 * 
 * @author ruoyi
 * @date 2022-08-09
 */
public class ContactStationAct extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 联络站活动id */
    private Long contactStationActId;

    /** 活动名称 */
    @Excel(name = "活动名称")
    private String actName;

    /** 活动副标题 */
    @Excel(name = "活动副标题")
    private String actSubhead;

    /** 地点 */
    @Excel(name = "地点")
    private String address;

    /** 封面图 */
    @Excel(name = "封面图")
    private String avator;

    /** 活动详情 */
    @Excel(name = "活动详情")
    private String details;

    /** 查看次数 */
    @Excel(name = "查看次数")
    private Long readNum;

    /** 所属联络站id */
    @Excel(name = "所属联络站id")
    private Long contactStationId;

    /** 活动类型 */
    @Excel(name = "活动类型")
    private String actType;

    /** 活动状态 */
    @Excel(name = "活动状态")
    private String actStatus;

    /** 删除标识 */
    private String delFlag;

    public void setContactStationActId(Long contactStationActId) 
    {
        this.contactStationActId = contactStationActId;
    }

    public Long getContactStationActId() 
    {
        return contactStationActId;
    }
    public void setActName(String actName) 
    {
        this.actName = actName;
    }

    public String getActName() 
    {
        return actName;
    }
    public void setActSubhead(String actSubhead) 
    {
        this.actSubhead = actSubhead;
    }

    public String getActSubhead() 
    {
        return actSubhead;
    }
    public void setAddress(String address) 
    {
        this.address = address;
    }

    public String getAddress() 
    {
        return address;
    }
    public void setAvator(String avator) 
    {
        this.avator = avator;
    }

    public String getAvator() 
    {
        return avator;
    }
    public void setDetails(String details) 
    {
        this.details = details;
    }

    public String getDetails() 
    {
        return details;
    }
    public void setReadNum(Long readNum) 
    {
        this.readNum = readNum;
    }

    public Long getReadNum() 
    {
        return readNum;
    }
    public void setContactStationId(Long contactStationId) 
    {
        this.contactStationId = contactStationId;
    }

    public Long getContactStationId() 
    {
        return contactStationId;
    }
    public void setActType(String actType) 
    {
        this.actType = actType;
    }

    public String getActType() 
    {
        return actType;
    }
    public void setActStatus(String actStatus) 
    {
        this.actStatus = actStatus;
    }

    public String getActStatus() 
    {
        return actStatus;
    }
    public void setDelFlag(String delFlag) 
    {
        this.delFlag = delFlag;
    }

    public String getDelFlag() 
    {
        return delFlag;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("contactStationActId", getContactStationActId())
            .append("actName", getActName())
            .append("actSubhead", getActSubhead())
            .append("address", getAddress())
            .append("avator", getAvator())
            .append("details", getDetails())
            .append("readNum", getReadNum())
            .append("contactStationId", getContactStationId())
            .append("actType", getActType())
            .append("actStatus", getActStatus())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("delFlag", getDelFlag())
            .append("remark", getRemark())
            .toString();
    }
}
