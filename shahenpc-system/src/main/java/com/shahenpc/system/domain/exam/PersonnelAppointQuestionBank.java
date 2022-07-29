package com.shahenpc.system.domain.exam;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.shahenpc.common.annotation.Excel;
import com.shahenpc.common.core.domain.BaseEntity;

/**
 * 人事任免_法律知识考试_题库管理对象 personnel_appoint_question_bank
 * 
 * @author ruoyi
 * @date 2022-07-27
 */
public class PersonnelAppointQuestionBank extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 题库id */
    private Long questionBankId;

    /** 题库名称 */
    @Excel(name = "题库名称")
    private String bankName;

    /** 题库描述 */
    @Excel(name = "题库描述")
    private String bankDescribe;

    /** 删除标识 */
    private String delFlag;

    public void setQuestionBankId(Long questionBankId) 
    {
        this.questionBankId = questionBankId;
    }

    public Long getQuestionBankId() 
    {
        return questionBankId;
    }
    public void setBankName(String bankName) 
    {
        this.bankName = bankName;
    }

    public String getBankName() 
    {
        return bankName;
    }
    public void setBankDescribe(String bankDescribe) 
    {
        this.bankDescribe = bankDescribe;
    }

    public String getBankDescribe() 
    {
        return bankDescribe;
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
            .append("questionBankId", getQuestionBankId())
            .append("bankName", getBankName())
            .append("bankDescribe", getBankDescribe())
            .append("remark", getRemark())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("delFlag", getDelFlag())
            .toString();
    }
}
