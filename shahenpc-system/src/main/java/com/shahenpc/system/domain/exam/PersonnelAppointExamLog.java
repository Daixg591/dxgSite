package com.shahenpc.system.domain.exam;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.shahenpc.common.annotation.Excel;
import com.shahenpc.common.core.domain.BaseEntity;

/**
 * 人事任免_法律知识考试_答题记录对象 personnel_appoint_exam_log
 *
 * @author ruoyi
 * @date 2022-07-27
 */
public class PersonnelAppointExamLog extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 答题记录id
     */
    private Long logId;

    /**
     * 试题id
     */
    @Excel(name = "试题id")
    private Long quId;

    /**
     * 所选答案id
     */
    private String answerId;

    /**
     * 主观题答案
     */
    @Excel(name = "主观题答案")
    private String answerCon;

    /**
     * 考试id
     */
    @Excel(name = "考试id")
    private Long examId;

    /**
     * 用户id
     */
    @Excel(name = "用户id")
    private Long userId;

    /**
     * 考试得分
     */
    @Excel(name = "试题得分")
    private Double score;

    /**
     * 任免记录与考试绑定关系Id
     */
    private Long regExamId;

    /**
     * 删除标识
     */
    private String delFlag;

    public void setLogId(Long logId) {
        this.logId = logId;
    }

    public Long getLogId() {
        return logId;
    }

    public void setQuId(Long quId) {
        this.quId = quId;
    }

    public Long getQuId() {
        return quId;
    }

    public void setAnswerId(String answerId) {
        this.answerId = answerId;
    }

    public String getAnswerId() {
        return answerId;
    }

    public void setAnswerCon(String answerCon) {
        this.answerCon = answerCon;
    }

    public String getAnswerCon() {
        return answerCon;
    }

    public void setExamId(Long examId) {
        this.examId = examId;
    }

    public Long getExamId() {
        return examId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getUserId() {
        return userId;
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
                .append("logId", getLogId())
                .append("quId", getQuId())
                .append("answerId", getAnswerId())
                .append("answerCon", getAnswerCon())
                .append("examId", getExamId())
                .append("userId", getUserId())
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
