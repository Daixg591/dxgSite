package com.shahenpc.system.domain.represent;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.shahenpc.common.annotation.Excel;
import com.shahenpc.common.core.domain.BaseEntity;

/**
 * 排行 以及 类型数  总数对象 represent_work_ranking
 * 
 * @author ruoyi
 * @date 2022-08-11
 */
public class RepresentWorkRanking extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long rankingId;

    /** 总数 */
    @Excel(name = "总数")
    private Integer total;

    /** 类型数 */
    @Excel(name = "类型数")
    private Integer typeCount;

    /** 关联用户id */
    @Excel(name = "关联用户id")
    private Long userId;

    /** 排名 */
    @Excel(name = "排名")
    private Integer ranking;

    public void setRankingId(Long rankingId) 
    {
        this.rankingId = rankingId;
    }

    public Long getRankingId()
    {
        return rankingId;
    }
    public void setTotal(Integer total)
    {
        this.total = total;
    }

    public Integer getTotal()
    {
        return total;
    }
    public void setTypeCount(Integer typeCount)
    {
        this.typeCount = typeCount;
    }

    public Integer getTypeCount()
    {
        return typeCount;
    }
    public void setUserId(Long userId)
    {
        this.userId = userId;
    }

    public Long getUserId()
    {
        return userId;
    }
    public void setRanking(Integer ranking)
    {
        this.ranking = ranking;
    }

    public Integer getRanking()
    {
        return ranking;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("rankingId", getRankingId())
            .append("remark", getRemark())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("total", getTotal())
            .append("typeCount", getTypeCount())
            .append("userId", getUserId())
            .append("ranking", getRanking())
            .toString();
    }
}
