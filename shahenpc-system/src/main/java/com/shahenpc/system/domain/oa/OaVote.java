package com.shahenpc.system.domain.oa;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
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
@Data
public class OaVote extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private Long voteId;

    /**  */
    @Excel(name = "")
    private String title;

    /**  */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @Excel(name = "", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date startTime;

    /**  */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @Excel(name = "", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
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
    private Integer total;

    /**  */
    @Excel(name = "")
    private Integer voter;

    /**  */
    @Excel(name = "")
    private Integer visit;

    /** 是否多选 */
    @Excel(name = "是否多选")
    private Integer isMany;

    /** 最少 */
    @Excel(name = "最少")
    private Integer least;

    /** 最多 */
    @Excel(name = "最多")
    private Integer biggest;

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

    public void setIsMany(Integer isMany) 
    {
        this.isMany = isMany;
    }

    public Integer getIsMany() 
    {
        return isMany;
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
            .append("isMany", getIsMany())
            .toString();
    }
}
