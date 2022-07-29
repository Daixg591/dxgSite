package com.shahenpc.system.domain.exam;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.shahenpc.common.annotation.Excel;
import com.shahenpc.common.core.domain.BaseEntity;

/**
 * 人事任免_法律知识考试_试卷大题对应对象 personnel_appoint_paper_big_question
 * 
 * @author ruoyi
 * @date 2022-07-27
 */
public class PersonnelAppointPaperBigQuestion extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 大题Id */
    private Long bigQuestionId;

    /** 试卷id */
    @Excel(name = "试卷id")
    private String examPaperId;

    /** 大题类型 */
    @Excel(name = "大题类型")
    private String questionType;

    /** 删除标识 */
    private String delFlag;

    public void setBigQuestionId(Long bigQuestionId) 
    {
        this.bigQuestionId = bigQuestionId;
    }

    public Long getBigQuestionId() 
    {
        return bigQuestionId;
    }
    public void setExamPaperId(String examPaperId) 
    {
        this.examPaperId = examPaperId;
    }

    public String getExamPaperId() 
    {
        return examPaperId;
    }
    public void setQuestionType(String questionType) 
    {
        this.questionType = questionType;
    }

    public String getQuestionType() 
    {
        return questionType;
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
            .append("bigQuestionId", getBigQuestionId())
            .append("examPaperId", getExamPaperId())
            .append("questionType", getQuestionType())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("delFlag", getDelFlag())
            .toString();
    }
}
