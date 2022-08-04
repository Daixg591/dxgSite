package com.shahenpc.system.domain.represent;

import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.shahenpc.common.annotation.Excel;
import com.shahenpc.common.core.domain.BaseEntity;

/**
 * 代履职体会对象 represent_experience
 * 
 * @author ruoyi
 * @date 2022-07-26
 */
@Data
public class RepresentExperience extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private Long experienceId;

    /** 标题 */
    @Excel(name = "标题")
    private String title;

    /**  */
    @Excel(name = "")
    private String content;

    /**  */
    @Excel(name = "")
    private String picUrl;

    private Long userId;

    public void setExperienceId(Long experienceId) 
    {
        this.experienceId = experienceId;
    }

    public Long getExperienceId() 
    {
        return experienceId;
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
    public void setPicUrl(String picUrl) 
    {
        this.picUrl = picUrl;
    }

    public String getPicUrl() 
    {
        return picUrl;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("experienceId", getExperienceId())
            .append("title", getTitle())
            .append("content", getContent())
            .append("picUrl", getPicUrl())
            .append("remark", getRemark())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("createBy", getCreateBy())
            .toString();
    }
}
