package com.shahenpc.system.domain.exam;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.shahenpc.common.annotation.Excel;
import com.shahenpc.common.core.domain.BaseEntity;

import java.util.List;

/**
 * 人事任免_法律知识考试_考试管理对象 personnel_appoint_exam
 *
 * @author ruoyi
 * @date 2022-07-27
 */
public class PersonnelAppointExam extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 根据Id集合查询
     */
    private Long[] ids;

    /**
     * 试卷试题信息
     */
    private PersonnelAppointExamPaper paper;

    /**
     * 考试id
     */
    private Long examId;

    /**
     * 考试名称
     */
    @Excel(name = "考试名称")
    private String examName;

    /**
     * 及格分
     */
    @Excel(name = "及格分")
    private Long passSocre;

    /**
     * 考试时长
     */
    @Excel(name = "考试时长")
    private Long duration;

    /**
     * 注意事项
     */
    @Excel(name = "注意事项")
    private String notice;

    /**
     * 考后感谢文字
     */
    @Excel(name = "考后感谢文字")
    private String thanksWords;

    /**
     * 试卷id
     */
    private Long paperId;

    /**
     * 删除标识
     */
    private String delFlag;

    public void setExamId(Long examId) {
        this.examId = examId;
    }

    public Long getExamId() {
        return examId;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    public String getExamName() {
        return examName;
    }

    public void setPassSocre(Long passSocre) {
        this.passSocre = passSocre;
    }

    public Long getPassSocre() {
        return passSocre;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public Long getDuration() {
        return duration;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }

    public String getNotice() {
        return notice;
    }

    public void setThanksWords(String thanksWords) {
        this.thanksWords = thanksWords;
    }

    public String getThanksWords() {
        return thanksWords;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public String getDelFlag() {
        return delFlag;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("examId", getExamId())
                .append("examName", getExamName())
                .append("passSocre", getPassSocre())
                .append("duration", getDuration())
                .append("notice", getNotice())
                .append("thanksWords", getThanksWords())
                .append("remark", getRemark())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .append("delFlag", getDelFlag())
                .append("paperId", getPaperId())
                .toString();
    }

    public Long getPaperId() {
        return paperId;
    }

    public void setPaperId(Long paperId) {
        this.paperId = paperId;
    }

    public PersonnelAppointExamPaper getPaper() {
        return paper;
    }

    public void setPaper(PersonnelAppointExamPaper paper) {
        this.paper = paper;
    }

    public Long[] getIds() {
        return ids;
    }

    public void setIds(Long[] ids) {
        this.ids = ids;
    }
}
