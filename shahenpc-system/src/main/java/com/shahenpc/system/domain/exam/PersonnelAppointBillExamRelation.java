package com.shahenpc.system.domain.exam;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.shahenpc.common.annotation.Excel;
import com.shahenpc.common.core.domain.BaseEntity;

/**
 * 任免记录考试关联对象 personnel_appoint_bill_exam_relation
 * 
 * @author ruoyi
 * @date 2022-08-02
 */
public class PersonnelAppointBillExamRelation extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 关联id */
    private Long regExamId;

    /** 任免记录Id */
    @Excel(name = "任免记录Id")
    private String registerId;

    /** 考试id */
    @Excel(name = "考试id")
    private String examId;

    /** 删除标识 */
    private String delFlag;

    public void setRegExamId(Long regExamId) 
    {
        this.regExamId = regExamId;
    }

    public Long getRegExamId() 
    {
        return regExamId;
    }
    public void setRegisterId(String registerId) 
    {
        this.registerId = registerId;
    }

    public String getRegisterId() 
    {
        return registerId;
    }
    public void setExamId(String examId) 
    {
        this.examId = examId;
    }

    public String getExamId() 
    {
        return examId;
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
            .append("regExamId", getRegExamId())
            .append("registerId", getRegisterId())
            .append("examId", getExamId())
            .append("remark", getRemark())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("delFlag", getDelFlag())
            .toString();
    }
}
