package com.shahenpc.system.domain.represent;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.shahenpc.common.annotation.Excel;
import com.shahenpc.common.core.domain.BaseEntity;

/**
 * 【活动分组认领记录】对象 represent_activity_claim
 * 
 * @author ruoyi
 * @date 2022-12-15
 */
@Data
public class RepresentActivityClaim extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    @TableField(exist = false)
    private String groupName;

    /** 用户姓名 */
    @TableField(exist = false)
    private String nickName;

    /** 签到id */
    private Long claimId;

    /** 活动分组id */
    @Excel(name = "活动分组id")
    private Long activityGroupId;

    /** 状态（1：认领   0：未认领） */
    @Excel(name = "状态", readConverterExp = "1=认领,2=未认领")
    private int status;

    /** 用户id */
    @Excel(name = "用户id")
    private Long userId;

    /** 活动id */
    @Excel(name = "活动id")
    private Long activityId;

    public void setClaimId(Long claimId)
    {
        this.claimId = claimId;
    }

    public Long getClaimId()
    {
        return claimId;
    }
    public void setActivityGroupId(Long activityGroupId)
    {
        this.activityGroupId = activityGroupId;
    }

    public Long getActivityGroupId()
    {
        return activityGroupId;
    }
    public void setStatus(int status)
    {
        this.status = status;
    }

    public int getStatus()
    {
        return status;
    }
    public void setUserId(Long userId)
    {
        this.userId = userId;
    }

    public Long getUserId()
    {
        return userId;
    }
    public void setActivityId(Long activityId)
    {
        this.activityId = activityId;
    }

    public Long getActivityId()
    {
        return activityId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("claimId", getClaimId())
                .append("activityGroupId", getActivityGroupId())
                .append("status", getStatus())
                .append("userId", getUserId())
                .append("activityId", getActivityId())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .append("remark", getRemark())
                .toString();
    }
}
