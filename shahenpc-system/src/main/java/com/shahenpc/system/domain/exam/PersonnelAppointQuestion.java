package com.shahenpc.system.domain.exam;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.shahenpc.common.annotation.Excel;
import com.shahenpc.common.core.domain.BaseEntity;

import java.util.List;

/**
 * 人事任免_法律知识考试_试题管理对象 personnel_appoint_question
 * 
 * @author ruoyi
 * @date 2022-07-27
 */
public class PersonnelAppointQuestion extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 答案集合 */
    private List<PersonnelAppointAnswer> answerList;

    /** 试题Id */
    private Long quId;

    /** 试题类型 */
    @Excel(name = "试题类型")
    private String quType;

    /** 所属题库 */
    @Excel(name = "所属题库")
    private Long quBankId;

    /** 试题难度 */
    @Excel(name = "试题难度")
    private String level;

    /** 试题内容 */
    @Excel(name = "试题内容")
    private String quCon;

    /** 试题解析 */
    @Excel(name = "试题解析")
    private String analysis;

    /** 删除标识 */
    private String delFlag;


    public void setQuId(Long quId) 
    {
        this.quId = quId;
    }

    public Long getQuId() 
    {
        return quId;
    }
    public void setQuType(String quType) 
    {
        this.quType = quType;
    }

    public String getQuType() 
    {
        return quType;
    }
    public void setQuBankId(Long quBankId) 
    {
        this.quBankId = quBankId;
    }

    public Long getQuBankId() 
    {
        return quBankId;
    }
    public void setLevel(String level) 
    {
        this.level = level;
    }

    public String getLevel() 
    {
        return level;
    }
    public void setQuCon(String quCon) 
    {
        this.quCon = quCon;
    }

    public String getQuCon() 
    {
        return quCon;
    }
    public void setAnalysis(String analysis) 
    {
        this.analysis = analysis;
    }

    public String getAnalysis() 
    {
        return analysis;
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
            .append("quId", getQuId())
            .append("quType", getQuType())
            .append("quBankId", getQuBankId())
            .append("level", getLevel())
            .append("quCon", getQuCon())
            .append("analysis", getAnalysis())
            .append("remark", getRemark())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("delFlag", getDelFlag())
            .toString();
    }

    public List<PersonnelAppointAnswer> getAnswerList() {
        return answerList;
    }

    public void setAnswerList(List<PersonnelAppointAnswer> answerList) {
        this.answerList = answerList;
    }
}
