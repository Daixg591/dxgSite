package com.shahenpc.system.domain.special;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.shahenpc.common.annotation.Excel;
import com.shahenpc.common.core.domain.BaseEntity;

/**
 * 特色工作对象 special_work
 * 
 * @author ruoyi
 * @date 2022-07-01
 */
public class SpecialWork extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private Long specialId;

    /** 标题 */
    @Excel(name = "标题")
    private String title;

    /** 内容 */
    @Excel(name = "内容")
    private String content;

    public void setSpecialId(Long specialId) 
    {
        this.specialId = specialId;
    }

    public Long getSpecialId() 
    {
        return specialId;
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

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("specialId", getSpecialId())
            .append("remark", getRemark())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("title", getTitle())
            .append("content", getContent())
            .toString();
    }
}
