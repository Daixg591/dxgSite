package com.shahenpc.system.domain.personel;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.shahenpc.common.annotation.Excel;
import com.shahenpc.common.core.domain.BaseEntity;

/**
 * 人事任免_决结果对象 personnel_appoint_vote_res
 * 
 * @author ruoyi
 * @date 2022-07-06
 */
public class PersonnelAppointVoteRes extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 表决id */
    private Long voteId;

    /** 用户id */
    @Excel(name = "用户id")
    private Long userId;

    /** 表决人姓名 */
    @Excel(name = "表决人姓名")
    private String voteName;

    /** 表决意见 */
    @Excel(name = "表决意见")
    private String voteState;

    /** 监票人 */
    @Excel(name = "监票人")
    private String scrutineer;

    /** 计票人 */
    @Excel(name = "计票人")
    private String tallyClerk;

    /** 投票时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "投票时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date voteTime;

    /** 删除标识 */
    private String delFlag;

    /** 任免记录Id */
    @Excel(name = "任免记录Id")
    private Long registerId;

    public void setVoteId(Long voteId) 
    {
        this.voteId = voteId;
    }

    public Long getVoteId() 
    {
        return voteId;
    }
    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }
    public void setVoteName(String voteName) 
    {
        this.voteName = voteName;
    }

    public String getVoteName() 
    {
        return voteName;
    }
    public void setVoteState(String voteState) 
    {
        this.voteState = voteState;
    }

    public String getVoteState() 
    {
        return voteState;
    }
    public void setScrutineer(String scrutineer) 
    {
        this.scrutineer = scrutineer;
    }

    public String getScrutineer() 
    {
        return scrutineer;
    }
    public void setTallyClerk(String tallyClerk) 
    {
        this.tallyClerk = tallyClerk;
    }

    public String getTallyClerk() 
    {
        return tallyClerk;
    }
    public void setVoteTime(Date voteTime) 
    {
        this.voteTime = voteTime;
    }

    public Date getVoteTime() 
    {
        return voteTime;
    }
    public void setDelFlag(String delFlag) 
    {
        this.delFlag = delFlag;
    }

    public String getDelFlag() 
    {
        return delFlag;
    }
    public void setRegisterId(Long registerId) 
    {
        this.registerId = registerId;
    }

    public Long getRegisterId() 
    {
        return registerId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("voteId", getVoteId())
            .append("userId", getUserId())
            .append("voteName", getVoteName())
            .append("voteState", getVoteState())
            .append("scrutineer", getScrutineer())
            .append("tallyClerk", getTallyClerk())
            .append("voteTime", getVoteTime())
            .append("remark", getRemark())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("delFlag", getDelFlag())
            .append("registerId", getRegisterId())
            .toString();
    }
}
