package com.shahenpc.system.domain.exam;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.shahenpc.common.annotation.Excel;
import com.shahenpc.common.core.domain.BaseEntity;

import java.util.List;

/**
 * 人事任免_法律知识考虑_试卷管理对象 personnel_appoint_exam_paper
 * 
 * @author ruoyi
 * @date 2022-07-27
 */
public class PersonnelAppointExamPaper extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**
     * 本试卷试题集合
     */
    private List<PersonnelAppointQuestion> quList;

    /** 试卷id */
    private Long examPaperId;

    /** 试卷名称 */
    @Excel(name = "试卷名称")
    private String examPaperName;

    /** 组卷方式 */
    @Excel(name = "组卷方式")
    private String makePaperType;

    /** 删除标识 */
    private String delFlag;

    public void setExamPaperId(Long examPaperId) 
    {
        this.examPaperId = examPaperId;
    }

    public Long getExamPaperId() 
    {
        return examPaperId;
    }
    public void setExamPaperName(String examPaperName) 
    {
        this.examPaperName = examPaperName;
    }

    public String getExamPaperName() 
    {
        return examPaperName;
    }
    public void setMakePaperType(String makePaperType) 
    {
        this.makePaperType = makePaperType;
    }

    public String getMakePaperType() 
    {
        return makePaperType;
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
            .append("examPaperId", getExamPaperId())
            .append("examPaperName", getExamPaperName())
            .append("makePaperType", getMakePaperType())
            .append("remark", getRemark())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("delFlag", getDelFlag())
            .toString();
    }

    public List<PersonnelAppointQuestion> getQuList() {
        return quList;
    }

    public void setQuList(List<PersonnelAppointQuestion> quList) {
        this.quList = quList;
    }
}
