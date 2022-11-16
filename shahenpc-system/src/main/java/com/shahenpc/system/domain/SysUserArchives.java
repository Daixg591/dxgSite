package com.shahenpc.system.domain;

import com.shahenpc.system.domain.oa.dto.MeetingUserIdListDto;
import com.shahenpc.system.domain.represent.dto.DiscoverUserIdDto;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.shahenpc.common.annotation.Excel;
import com.shahenpc.common.core.domain.BaseEntity;

import java.util.List;

/**
 * 代履职档案对象 sys_user_archives
 * 
 * @author ruoyi
 * @date 2022-10-21
 */
@Data
public class SysUserArchives extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long archivesId;

    /** 绑定user */
    @Excel(name = "绑定user")
    private Long userId;

    /** 培训情况 */
    @Excel(name = "培训情况")
    private String train;

    /** 出席情况 */
    @Excel(name = "出席情况")
    private String attend;

    /** 审议情况 */
    @Excel(name = "审议情况")
    private String consideration;

    /** 建议情况 */
    @Excel(name = "建议情况")
    private String proposal;

    /** 视察调研情况 */
    @Excel(name = "视察调研情况")
    private String inspection;

    /** 走访接访情况 */
    @Excel(name = "走访接访情况")
    private String visit;

    /** 代表发现情况 */
    @Excel(name = "代表发现情况")
    private String find;

    private List<MeetingUserIdListDto> meetingDto;

    private List<DiscoverUserIdDto> discoverDto;

    public void setArchivesId(Long archivesId) 
    {
        this.archivesId = archivesId;
    }

    public Long getArchivesId() 
    {
        return archivesId;
    }
    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }
    public void setTrain(String train) 
    {
        this.train = train;
    }

    public String getTrain() 
    {
        return train;
    }
    public void setAttend(String attend) 
    {
        this.attend = attend;
    }

    public String getAttend() 
    {
        return attend;
    }
    public void setConsideration(String consideration) 
    {
        this.consideration = consideration;
    }

    public String getConsideration() 
    {
        return consideration;
    }
    public void setProposal(String proposal) 
    {
        this.proposal = proposal;
    }

    public String getProposal() 
    {
        return proposal;
    }
    public void setInspection(String inspection) 
    {
        this.inspection = inspection;
    }

    public String getInspection() 
    {
        return inspection;
    }
    public void setVisit(String visit) 
    {
        this.visit = visit;
    }

    public String getVisit() 
    {
        return visit;
    }
    public void setFind(String find) 
    {
        this.find = find;
    }

    public String getFind() 
    {
        return find;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("archivesId", getArchivesId())
            .append("userId", getUserId())
            .append("train", getTrain())
            .append("attend", getAttend())
            .append("consideration", getConsideration())
            .append("proposal", getProposal())
            .append("inspection", getInspection())
            .append("visit", getVisit())
            .append("find", getFind())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
