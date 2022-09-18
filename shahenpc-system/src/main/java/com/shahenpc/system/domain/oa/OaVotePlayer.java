package com.shahenpc.system.domain.oa;

import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.shahenpc.common.annotation.Excel;
import com.shahenpc.common.core.domain.BaseEntity;

/**
 * 投票选手对象 oa_vote_player
 * 
 * @author ruoyi
 * @date 2022-07-19
 */
@Data
public class OaVotePlayer extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private Long playerId;

    /**  */
    @Excel(name = "")
    private Long voteId;

    /**  */
    @Excel(name = "")
    private String name;

    /**  */
    @Excel(name = "")
    private String avatarUrl;

    /** 内容 */
    @Excel(name = "内容")
    private String content;

    /** 投票数 */
    @Excel(name = "投票数")
    private Integer total;

    public void setPlayerId(Long playerId) 
    {
        this.playerId = playerId;
    }

    public Long getPlayerId() 
    {
        return playerId;
    }
    public void setVoteId(Long voteId) 
    {
        this.voteId = voteId;
    }

    public Long getVoteId() 
    {
        return voteId;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setAvatarUrl(String avatarUrl) 
    {
        this.avatarUrl = avatarUrl;
    }

    public String getAvatarUrl() 
    {
        return avatarUrl;
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
            .append("playerId", getPlayerId())
            .append("voteId", getVoteId())
            .append("remark", getRemark())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("createBy", getCreateBy())
            .append("name", getName())
            .append("avatarUrl", getAvatarUrl())
            .append("content", getContent())
            .append("total", getTotal())
            .toString();
    }
}
