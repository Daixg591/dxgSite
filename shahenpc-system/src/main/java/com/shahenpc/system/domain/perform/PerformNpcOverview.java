package com.shahenpc.system.domain.perform;

import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.shahenpc.common.annotation.Excel;
import com.shahenpc.common.core.domain.BaseEntity;

/**
 * 小程序-信息发布对象 perform_npc_overview
 * 
 * @author ruoyi
 * @date 2022-07-08
 */
@Data
public class PerformNpcOverview extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long overviewId;

    /** 类型 */
    @Excel(name = "类型")
    private Integer columnType;

    /** 主任ID */
    @Excel(name = "主任ID")
    private Long headUserId;

    /** 副主任ID */
    @Excel(name = "副主任ID")
    private String deputyHeadUserId;

    /** 秘书长 */
    @Excel(name = "秘书长")
    private Long secretaryUserId;

    /** 常委会人员 */
    @Excel(name = "常委会人员")
    private String standingUserId;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String agencyUrl;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String title;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String content;

    public void setOverviewId(Long overviewId) 
    {
        this.overviewId = overviewId;
    }

    public Long getOverviewId() 
    {
        return overviewId;
    }

    public void setHeadUserId(Long headUserId) 
    {
        this.headUserId = headUserId;
    }

    public Long getHeadUserId() 
    {
        return headUserId;
    }
    public void setDeputyHeadUserId(String deputyHeadUserId) 
    {
        this.deputyHeadUserId = deputyHeadUserId;
    }

    public String getDeputyHeadUserId() 
    {
        return deputyHeadUserId;
    }
    public void setSecretaryUserId(Long secretaryUserId) 
    {
        this.secretaryUserId = secretaryUserId;
    }

    public Long getSecretaryUserId() 
    {
        return secretaryUserId;
    }
    public void setStandingUserId(String standingUserId) 
    {
        this.standingUserId = standingUserId;
    }

    public String getStandingUserId() 
    {
        return standingUserId;
    }
    public void setAgencyUrl(String agencyUrl) 
    {
        this.agencyUrl = agencyUrl;
    }

    public String getAgencyUrl() 
    {
        return agencyUrl;
    }
    public void setTitle(String title) 
    {
        this.title = title;
    }

    public String getTitle() 
    {
        return title;
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
            .append("overviewId", getOverviewId())
            .append("headUserId", getHeadUserId())
            .append("deputyHeadUserId", getDeputyHeadUserId())
            .append("secretaryUserId", getSecretaryUserId())
            .append("standingUserId", getStandingUserId())
            .append("agencyUrl", getAgencyUrl())
            .append("title", getTitle())
            .append("content", getContent())
            .append("remark", getRemark())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("createBy", getCreateBy())
            .toString();
    }
}
