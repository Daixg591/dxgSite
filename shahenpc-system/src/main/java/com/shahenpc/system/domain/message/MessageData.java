package com.shahenpc.system.domain.message;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.shahenpc.common.annotation.Excel;
import com.shahenpc.common.core.domain.BaseEntity;

/**
 * 消息对象 message_data
 * 
 * @author ruoyi
 * @date 2022-07-07
 */
public class MessageData extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private Long id;

    /** 发送用户id 0-系统消息 */
    @Excel(name = "发送用户id 0-系统消息")
    private Long sendUserId;

    /** 接收人用户id 0-全部 */
    @Excel(name = "接收人用户id 0-全部")
    private Long receiveUserId;

    /** 1-系统消息 2-聊天消息 3.催办 */
    @Excel(name = "1-系统消息 2-聊天消息 3.催办")
    private Integer type;

    /** 消息头 */
    @Excel(name = "消息头")
    private String title;

    /** 消息内容 */
    @Excel(name = "消息内容")
    private String message;

    /** 消息跳转参数 */
    @Excel(name = "消息跳转参数")
    private String jumpParam;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
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
    public void setType(Integer type) 
    {
        this.type = type;
    }

    public Integer getType() 
    {
        return type;
    }
    public void setTitle(String title) 
    {
        this.title = title;
    }

    public String getTitle() 
    {
        return title;
    }
    public void setMessage(String message) 
    {
        this.message = message;
    }

    public String getMessage() 
    {
        return message;
    }
    public void setJumpParam(String jumpParam) 
    {
        this.jumpParam = jumpParam;
    }

    public String getJumpParam() 
    {
        return jumpParam;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("sendUserId", getSendUserId())
            .append("receiveUserId", getReceiveUserId())
            .append("type", getType())
            .append("title", getTitle())
            .append("message", getMessage())
            .append("jumpParam", getJumpParam())
            .append("remark", getRemark())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("createBy", getCreateBy())
            .toString();
    }
}
