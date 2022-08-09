package com.shahenpc.system.domain.feature;

import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.shahenpc.common.annotation.Excel;
import com.shahenpc.common.core.domain.BaseEntity;

/**
 * 双联工作对象 feature_double_work
 * 
 * @author ruoyi
 * @date 2022-07-13
 */
@Data
public class FeatureDoubleWork extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long doubleId;

    /** 意见类型 */
    @Excel(name = "意见类型")
    private Integer doubleType;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String title;

    /** 状态 */
    @Excel(name = "状态")
    private Integer status;

    /** 内容 */
    @Excel(name = "内容")
    private String content;

    /** 图片存储 */
    @Excel(name = "图片存储")
    private String picUrls;

    /** 提交id */
    @Excel(name = "提交id")
    private Long submitUserId;

    /** 接收人id */
    @Excel(name = "接收人id")
    private Long receiveUserId;

    /** 是否已读 */
    @Excel(name = "是否已读")
    private Integer isRead;

    /** 评价 */
    @Excel(name = "评价")
    private Integer rate;

    /** 回复 */
    @Excel(name = "回复")
    private String reply;

    /** 通讯地点 */
    @Excel(name = "通讯地点")
    private String address;

    /** 经纬度逗号分割 */
    @Excel(name = "经纬度逗号分割")
    private String location;


    public void setDoubleId(Long doubleId) 
    {
        this.doubleId = doubleId;
    }

    public Long getDoubleId() 
    {
        return doubleId;
    }
    public void setDoubleType(Integer doubleType) 
    {
        this.doubleType = doubleType;
    }

    public Integer getDoubleType() 
    {
        return doubleType;
    }
    public void setTitle(String title) 
    {
        this.title = title;
    }

    public String getTitle() 
    {
        return title;
    }
    public void setStatus(Integer status) 
    {
        this.status = status;
    }

    public Integer getStatus() 
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

    public void setSubmitUserId(Long submitUserId) 
    {
        this.submitUserId = submitUserId;
    }

    public Long getSubmitUserId() 
    {
        return submitUserId;
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
            .append("doubleId", getDoubleId())
            .append("doubleType", getDoubleType())
            .append("title", getTitle())
            .append("status", getStatus())
            .append("content", getContent())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .append("submitUserId", getSubmitUserId())
            .append("receiveUserId", getReceiveUserId())
            .toString();
    }
}
