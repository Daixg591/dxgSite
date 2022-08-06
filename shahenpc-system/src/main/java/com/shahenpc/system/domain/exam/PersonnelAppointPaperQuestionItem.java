package com.shahenpc.system.domain.exam;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.shahenpc.common.annotation.Excel;
import com.shahenpc.common.core.domain.BaseEntity;

/**
 * 人事任免_法律知识考试_小题集合对象 personnel_appoint_paper_question_item
 * 
 * @author ruoyi
 * @date 2022-07-27
 */
public class PersonnelAppointPaperQuestionItem extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 对应关系id */
    private Long quItemId;

    /** 大题Id */
    @Excel(name = "大题Id")
    private Long bigQuestionId;

    /** 试题Id */
    @Excel(name = "试题Id")
    private Long quId;

    public void setQuItemId(Long quItemId) 
    {
        this.quItemId = quItemId;
    }

    public Long getQuItemId() 
    {
        return quItemId;
    }
    public void setBigQuestionId(Long bigQuestionId) 
    {
        this.bigQuestionId = bigQuestionId;
    }

    public Long getBigQuestionId() 
    {
        return bigQuestionId;
    }
    public void setQuId(Long quId) 
    {
        this.quId = quId;
    }

    public Long getQuId() 
    {
        return quId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("quItemId", getQuItemId())
            .append("bigQuestionId", getBigQuestionId())
            .append("quId", getQuId())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
