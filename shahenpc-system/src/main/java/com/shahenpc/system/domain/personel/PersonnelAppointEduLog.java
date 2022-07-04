package com.shahenpc.system.domain.personel;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.shahenpc.common.annotation.Excel;
import com.shahenpc.common.core.domain.BaseEntity;

/**
 * 人事任免_教育记录对象 personnel_appoint_edu_log
 * 
 * @author ruoyi
 * @date 2022-07-04
 */
public class PersonnelAppointEduLog extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 教育记录Id */
    private Long eduLogId;

    /** 教育类别 */
    @Excel(name = "教育类别")
    private String eduType;

    /** 学校 */
    @Excel(name = "学校")
    private String school;

    /** 专业 */
    @Excel(name = "专业")
    private String major;

    /** 用户id */
    @Excel(name = "用户id")
    private Long userId;

    /** 删除标识 */
    private String delFlag;

    /** 时间段 */
    @Excel(name = "时间段")
    private String timeRange;

    /** 学历 */
    @Excel(name = "学历")
    private String edu;

    public void setEduLogId(Long eduLogId) 
    {
        this.eduLogId = eduLogId;
    }

    public Long getEduLogId() 
    {
        return eduLogId;
    }
    public void setEduType(String eduType) 
    {
        this.eduType = eduType;
    }

    public String getEduType() 
    {
        return eduType;
    }
    public void setSchool(String school) 
    {
        this.school = school;
    }

    public String getSchool() 
    {
        return school;
    }
    public void setMajor(String major) 
    {
        this.major = major;
    }

    public String getMajor() 
    {
        return major;
    }
    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }
    public void setDelFlag(String delFlag) 
    {
        this.delFlag = delFlag;
    }

    public String getDelFlag() 
    {
        return delFlag;
    }
    public void setTimeRange(String timeRange) 
    {
        this.timeRange = timeRange;
    }

    public String getTimeRange() 
    {
        return timeRange;
    }
    public void setEdu(String edu) 
    {
        this.edu = edu;
    }

    public String getEdu() 
    {
        return edu;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("eduLogId", getEduLogId())
            .append("eduType", getEduType())
            .append("school", getSchool())
            .append("major", getMajor())
            .append("userId", getUserId())
            .append("remark", getRemark())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("delFlag", getDelFlag())
            .append("timeRange", getTimeRange())
            .append("edu", getEdu())
            .toString();
    }
}
