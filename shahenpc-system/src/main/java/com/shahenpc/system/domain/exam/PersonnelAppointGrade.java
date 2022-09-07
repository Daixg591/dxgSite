package com.shahenpc.system.domain.exam;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.shahenpc.common.annotation.Excel;
import com.shahenpc.common.core.domain.BaseEntity;

/**
 * 人事任免_法律知识考虑_成绩管理对象 personnel_appoint_grade
 *
 * @author ruoyi
 * @date 2022-07-27
 */
public class PersonnelAppointGrade extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 任免记录考试绑定id
     */
    private Long regExamId;

    /**
     * 任免记录id
     */
    private Long registerId;

    /**
     * 成绩id
     */
    private Long gradeId;

    /**
     * 用户id
     */
    @Excel(name = "用户id")
    private Long userId;

    /**
     * 考试id
     */
    @Excel(name = "考试id")
    private Long examId;

    /**
     * 考试得分
     */
    private Double score;

    /**
     * 删除标识
     */
    private String delFlag;

    public Long getRegisterId() {
        return registerId;
    }

    public void setRegisterId(Long registerId) {
        this.registerId = registerId;
    }

    public void setGradeId(Long gradeId) {
        this.gradeId = gradeId;
    }

    public Long getGradeId() {
        return gradeId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setExamId(Long examId) {
        this.examId = examId;
    }

    public Long getExamId() {
        return examId;
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
                .append("gradeId", getGradeId())
                .append("userId", getUserId())
                .append("examId", getExamId())
                .append("remark", getRemark())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .append("delFlag", getDelFlag())
                .append("score", getScore())
                .append("regExamId", getRegExamId())
                .toString();
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public Long getRegExamId() {
        return regExamId;
    }

    public void setRegExamId(Long regExamId) {
        this.regExamId = regExamId;
    }
}
