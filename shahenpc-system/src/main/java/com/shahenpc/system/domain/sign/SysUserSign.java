package com.shahenpc.system.domain.sign;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.shahenpc.common.annotation.Excel;
import com.shahenpc.common.core.domain.BaseEntity;

/**
 * 代签到对象 sys_user_sign
 * 
 * @author ruoyi
 * @date 2022-11-17
 */
public class SysUserSign extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 签到id */
    private Long signId;

    /** 用户id */
    @Excel(name = "用户id")
    private Long userId;

    /** 删除标识 */
    private String delFlag;

    public void setSignId(Long signId) 
    {
        this.signId = signId;
    }

    public Long getSignId() 
    {
        return signId;
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

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("signId", getSignId())
            .append("userId", getUserId())
            .append("remark", getRemark())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("delFlag", getDelFlag())
            .toString();
    }
}
