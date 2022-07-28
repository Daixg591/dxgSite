package com.shahenpc.system.domain.represent;

import com.alibaba.fastjson2.JSON;
import lombok.Data;
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
@Data
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

    /** 主任 */
    @Excel(name = "主任")
    private String directorId;

    /** 副主任 */
    @Excel(name = "副主任")
    private String deputyDirectorId;

    /** 秘书 */
    @Excel(name = "秘书")
    private String secretaryId;

    /** 常委 */
    @Excel(name = "常委")
    private String standingId;

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
            .toString();
    }
}
