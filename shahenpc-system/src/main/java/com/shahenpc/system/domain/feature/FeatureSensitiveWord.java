package com.shahenpc.system.domain.feature;

import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.shahenpc.common.annotation.Excel;
import com.shahenpc.common.core.domain.BaseEntity;

/**
 * 重点工作-敏感词管理对象 feature_sensitive_word
 * 
 * @author ruoyi
 * @date 2022-08-10
 */
@Data
public class FeatureSensitiveWord extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long sensitiveId;

    /** 敏感词  */
    @Excel(name = "敏感词")
    private String badword;
    /** 强哥想那个就那个 */
    @Excel(name = "强哥想那个就那个")
    private Long status;

    public void setSensitiveId(Long sensitiveId) 
    {
        this.sensitiveId = sensitiveId;
    }

    public Long getSensitiveId() 
    {
        return sensitiveId;
    }
    public void setBadword(String badword) 
    {
        this.badword = badword;
    }

    public String getBadword() 
    {
        return badword;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("sensitiveId", getSensitiveId())
            .append("badword", getBadword())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
