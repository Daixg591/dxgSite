package com.shahenpc.system.domain.feature;

import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.shahenpc.common.annotation.Excel;
import com.shahenpc.common.core.domain.BaseEntity;

/**
 * 特色工作-民生实事-环境保护-信访稳定-营商环境-乡村振兴对象 feature_work_event
 * 
 * @author ruoyi
 * @date 2022-07-15
 */
@Data
public class FeatureWorkEvent extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private Long eventId;

    /** 标题 */
    @Excel(name = "标题")
    private String title;

    /** 内容 */
    @Excel(name = "内容")
    private String content;

    /** 工作类型 */
    @Excel(name = "工作类型")
    private Integer workType;

    private String fileUrl;

    public void setEventId(Long eventId) 
    {
        this.eventId = eventId;
    }

    public Long getEventId() 
    {
        return eventId;
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
    public void setWorkType(Integer workType) 
    {
        this.workType = workType;
    }

    public Integer getWorkType() 
    {
        return workType;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("eventId", getEventId())
            .append("title", getTitle())
            .append("content", getContent())
            .append("workType", getWorkType())
            .append("remark", getRemark())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
