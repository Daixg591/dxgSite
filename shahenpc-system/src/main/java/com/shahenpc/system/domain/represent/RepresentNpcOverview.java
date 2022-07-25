package com.shahenpc.system.domain.represent;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.shahenpc.common.annotation.Excel;
import com.shahenpc.common.core.domain.BaseEntity;

/**
 * 人大概览 只存一条信息对象 represent_npc_overview
 * 
 * @author ruoyi
 * @date 2022-07-21
 */
public class RepresentNpcOverview extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private Long npcId;

    /**  */
    @Excel(name = "")
    private String picUrl;

    /**  */
    @Excel(name = "")
    private String content;

    /**  */
    @Excel(name = "")
    private Long directorId;

    /**  */
    @Excel(name = "")
    private Long deputyDirectorId;

    /**  */
    @Excel(name = "")
    private Long secretaryId;

    /**  */
    @Excel(name = "")
    private Long standingId;

    public void setNpcId(Long npcId) 
    {
        this.npcId = npcId;
    }

    public Long getNpcId() 
    {
        return npcId;
    }
    public void setPicUrl(String picUrl) 
    {
        this.picUrl = picUrl;
    }

    public String getPicUrl() 
    {
        return picUrl;
    }
    public void setContent(String content) 
    {
        this.content = content;
    }

    public String getContent() 
    {
        return content;
    }
    public void setDirectorId(Long directorId) 
    {
        this.directorId = directorId;
    }

    public Long getDirectorId() 
    {
        return directorId;
    }
    public void setDeputyDirectorId(Long deputyDirectorId) 
    {
        this.deputyDirectorId = deputyDirectorId;
    }

    public Long getDeputyDirectorId() 
    {
        return deputyDirectorId;
    }
    public void setSecretaryId(Long secretaryId) 
    {
        this.secretaryId = secretaryId;
    }

    public Long getSecretaryId() 
    {
        return secretaryId;
    }
    public void setStandingId(Long standingId) 
    {
        this.standingId = standingId;
    }

    public Long getStandingId() 
    {
        return standingId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("npcId", getNpcId())
            .append("picUrl", getPicUrl())
            .append("content", getContent())
            .append("remark", getRemark())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("directorId", getDirectorId())
            .append("deputyDirectorId", getDeputyDirectorId())
            .append("secretaryId", getSecretaryId())
            .append("standingId", getStandingId())
            .toString();
    }
}
