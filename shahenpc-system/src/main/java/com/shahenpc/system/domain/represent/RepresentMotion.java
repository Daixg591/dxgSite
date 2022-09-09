package com.shahenpc.system.domain.represent;

import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.shahenpc.common.annotation.Excel;
import com.shahenpc.common.core.domain.BaseEntity;

/**
 * 工作-建议议案处理对象 represent_motion
 * 
 * @author ruoyi
 * @date 2022-07-22
 */
@Data
public class RepresentMotion extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private Long motionId;

    /** 1议案  2.建议 */
    @Excel(name = "1议案  2.建议")
    private Integer categoryType;


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

    /** 逗号分割用户-用户 */
    @Excel(name = "逗号分割用户-用户")
    private String suggestUserName;

    /** 状态 */
    @Excel(name = "状态")
    private Integer status;

    /** 发送id */
    @Excel(name = "发送id")
    private Long sendUserId;

    /**  */
    @Excel(name = "")
    private String sendUserName;

    /**  */
    @Excel(name = "")
    private Long approvalUserId;

    /** 流程id */
    @Excel(name = "流程id")
    private String procinsId;

    /** 模板id */
    @Excel(name = "模板id")
    private String deployId;

    /** 环节名字 */
    @Excel(name = "环节名字")
    private String linkName;

    /** 环节状态 */
    @Excel(name = "环节状态")
    private String linkStatus;

    /** 通讯地点 */
    @Excel(name = "通讯地点")
    private String address;

    /** 评价 */
    @Excel(name = "评价")
    private Integer rate;

    /** 电话 */
    @Excel(name = "电话")
    private String phone;

    private String taskName;

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
    public void setSuggestUserName(String suggestUserName) 
    {
        this.suggestUserName = suggestUserName;
    }

    public String getSuggestUserName() 
    {
        return suggestUserName;
    }
    public void setStatus(Integer status) 
    {
        this.status = status;
    }

    public Integer getStatus() 
    {
        return status;
    }
    public void setSendUserId(Long sendUserId)
    {
        this.sendUserId = sendUserId;
    }

    public Long getSendUserId() 
    {
        return sendUserId;
    }
    public void setSendUserName(String sendUserName) 
    {
        this.sendUserName = sendUserName;
    }

    public String getSendUserName() 
    {
        return sendUserName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("motionId", getMotionId())
            .append("motionType", getMotionType())
            .append("title", getTitle())
            .append("content", getContent())
            .append("suggestUserId", getSuggestUserId())
            .append("suggestUserName", getSuggestUserName())
            .append("status", getStatus())
            .append("remark", getRemark())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("sendUserId", getSendUserId())
            .append("sendUserName", getSendUserName())
            .toString();
    }
}
