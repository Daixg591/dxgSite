package com.shahenpc.system.domain.represent;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.shahenpc.common.annotation.Excel;
import com.shahenpc.common.core.domain.BaseEntity;

import java.util.List;

/**
 * 【请填写功能名称】对象 represent_activity_group
 *
 * @author ruoyi
 * @date 2022-12-12
 */
public class RepresentActivityGroup extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 是否认领 true：认领；  false:未认领
     */
    private boolean groupClaimStatus;

    /**
     * id
     */
    private Long activityGroupId;

    /**
     * 当前分组数据集
     */
    private List<Long> userIds;

    /**
     * 父级活动id
     */
    @Excel(name = "父级活动id")
    private Long activityId;

    /**
     * 分组名称
     */
    @Excel(name = "分组名称")
    private String groupName;

    /**
     * 认领标识
     */
    private boolean isMine;

    public List<Long> getUserIds() {
        return userIds;
    }

    public void setUserIds(List<Long> userIds) {
        this.userIds = userIds;
    }

    public boolean isGroupClaimStatus() {
        return groupClaimStatus;
    }

    public void setGroupClaimStatus(boolean groupClaimStatus) {
        this.groupClaimStatus = groupClaimStatus;
    }

    public void setActivityGroupId(Long activityGroupId) {
        this.activityGroupId = activityGroupId;
    }

    public Long getActivityGroupId() {
        return activityGroupId;
    }

    public Long getActivityId() {
        return activityId;
    }

    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupName() {
        return groupName;
    }

    public boolean isMine() {
        return isMine;
    }

    public void setMine(boolean mine) {
        isMine = mine;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("activityGroupId", getActivityGroupId())
                .append("activityId", getActivityId())
                .append("groupName", getGroupName())
                .append("remark", getRemark())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .toString();
    }
}
