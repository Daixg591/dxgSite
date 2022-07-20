package com.shahenpc.system.domain.oa;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.shahenpc.common.annotation.Excel;
import com.shahenpc.common.core.domain.BaseEntity;

/**
 * 投票窗口对象 oa_vote
 * 
 * @author ruoyi
 * @date 2022-07-19
 */
public class OaVote extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private Long voteId;

    /**  */
    @Excel(name = "")
    private String title;

    /**  */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "", width = 30, dateFormat = "yyyy-MM-dd")
    private Date startTime;

    /**  */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "", width = 30, dateFormat = "yyyy-MM-dd")
    private Date endTime;

    /**  */
    @Excel(name = "")
    private String content;

    /** 封面 */
    @Excel(name = "封面")
    private String coverUrl;

    /**  */
    @Excel(name = "")
    private Integer status;

    /**  */
    @Excel(name = "")
    private Long total;

    /**  */
    @Excel(name = "")
    private Long voter;

    /**  */
    @Excel(name = "")
    private Long visit;

    /** 是否多选 */
    @Excel(name = "是否多选")
    private Integer isMany;

    /** 最少 */
    @Excel(name = "最少")
    private Long least;

    /** 最多 */
    @Excel(name = "最多")
    private Long biggest;

    public void setVoteId(Long voteId) 
    {
        this.voteId = voteId;
    }

    public Long getVoteId() 
    {
        return voteId;
    }
    public void setTitle(String title) 
    {
        this.title = title;
    }

    public String getTitle() 
    {
        return title;
    }
    public void setStartTime(Date startTime) 
    {
        this.startTime = startTime;
    }

    public Date getStartTime() 
    {
        return startTime;
    }
    public void setEndTime(Date endTime) 
    {
        this.endTime = endTime;
    }

    public Date getEndTime() 
    {
        return endTime;
    }
    public void setContent(String content) 
    {
        this.content = content;
    }

    public String getContent() 
    {
        return content;
    }
    public void setCoverUrl(String coverUrl) 
    {
        this.coverUrl = coverUrl;
    }

    public String getCoverUrl() 
    {
        return coverUrl;
    }
    public void setStatus(Integer status) 
    {
        this.status = status;
    }

    public Integer getStatus() 
    {
        return status;
    }
    public void setTotal(Long total) 
    {
        this.total = total;
    }

    public Long getTotal() 
    {
        return total;
    }
    public void setVoter(Long voter) 
    {
        this.voter = voter;
    }

    public Long getVoter() 
    {
        return voter;
    }
    public void setVisit(Long visit) 
    {
        this.visit = visit;
    }

    public Long getVisit() 
    {
        return visit;
    }
    public void setIsMany(Integer isMany) 
    {
        this.isMany = isMany;
    }

    public Integer getIsMany() 
    {
        return isMany;
    }
    public void setLeast(Long least) 
    {
        this.least = least;
    }

    public Long getLeast() 
    {
        return least;
    }
    public void setBiggest(Long biggest) 
    {
        this.biggest = biggest;
    }

    public Long getBiggest() 
    {
        return biggest;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("voteId", getVoteId())
            .append("title", getTitle())
            .append("remark", getRemark())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("createBy", getCreateBy())
            .append("startTime", getStartTime())
            .append("endTime", getEndTime())
            .append("content", getContent())
            .append("coverUrl", getCoverUrl())
            .append("status", getStatus())
            .append("total", getTotal())
            .append("voter", getVoter())
            .append("visit", getVisit())
            .append("isMany", getIsMany())
            .append("least", getLeast())
            .append("biggest", getBiggest())
            .toString();
    }
}
