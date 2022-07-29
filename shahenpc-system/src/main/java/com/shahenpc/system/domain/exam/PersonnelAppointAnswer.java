package com.shahenpc.system.domain.exam;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.shahenpc.common.annotation.Excel;
import com.shahenpc.common.core.domain.BaseEntity;

/**
 * 人事任免_法律知识考试_答案管理对象 personnel_appoint_answer
 * 
 * @author ruoyi
 * @date 2022-07-27
 */
public class PersonnelAppointAnswer extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 答案Id */
    private Long answerId;

    /** 512 */
    @Excel(name = "512")
    private String itemImg;

    /** 选项内容 */
    @Excel(name = "选项内容")
    private String itemCon;

    /** 选项解析 */
    @Excel(name = "选项解析")
    private String itemAnalysis;

    /** 选项Tag */
    @Excel(name = "选项Tag")
    private String itemTag;

    /** 是否答案 */
    @Excel(name = "是否答案")
    private Integer isAnswer;

    /** 删除标识 */
    private String delFlag;

    public void setAnswerId(Long answerId) 
    {
        this.answerId = answerId;
    }

    public Long getAnswerId() 
    {
        return answerId;
    }
    public void setItemImg(String itemImg) 
    {
        this.itemImg = itemImg;
    }

    public String getItemImg() 
    {
        return itemImg;
    }
    public void setItemCon(String itemCon) 
    {
        this.itemCon = itemCon;
    }

    public String getItemCon() 
    {
        return itemCon;
    }
    public void setItemAnalysis(String itemAnalysis) 
    {
        this.itemAnalysis = itemAnalysis;
    }

    public String getItemAnalysis() 
    {
        return itemAnalysis;
    }
    public void setItemTag(String itemTag) 
    {
        this.itemTag = itemTag;
    }

    public String getItemTag() 
    {
        return itemTag;
    }
    public void setIsAnswer(Integer isAnswer) 
    {
        this.isAnswer = isAnswer;
    }

    public Integer getIsAnswer() 
    {
        return isAnswer;
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
            .append("answerId", getAnswerId())
            .append("itemImg", getItemImg())
            .append("itemCon", getItemCon())
            .append("itemAnalysis", getItemAnalysis())
            .append("itemTag", getItemTag())
            .append("isAnswer", getIsAnswer())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("delFlag", getDelFlag())
            .toString();
    }
}
