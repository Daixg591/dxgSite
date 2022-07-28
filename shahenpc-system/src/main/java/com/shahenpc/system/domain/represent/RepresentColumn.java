package com.shahenpc.system.domain.represent;

import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.shahenpc.common.annotation.Excel;
import com.shahenpc.common.core.domain.BaseEntity;

/**
 * 信息发布栏目菜单对象 represent_column
 * 
 * @author ruoyi
 * @date 2022-07-21
 */
@Data
public class RepresentColumn extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 栏id */
    private Long columnId;

    /** 产品名称 */
    @Excel(name = "产品名称")
    private String name;

    /** 显示顺序 */
    @Excel(name = "显示顺序")
    private Integer orderNum;

    /** 状态状态（0正常 1停用） */
    @Excel(name = "状态状态", readConverterExp = "0=正常,1=停用")
    private String status;

    /** 栏目类型 */
    @Excel(name = "栏目类型")
    private Integer columnType;

    /** 是否手机显示 */
    @Excel(name = "是否手机显示")
    private Integer isAppShow;

    /** 是否手机显示 */
    @Excel(name = "是否手机显示")
    private Integer isWxShow;
    @Excel(name = "类型")
    private Integer category;

    public void setColumnId(Long columnId) 
    {
        this.columnId = columnId;
    }

    public Long getColumnId() 
    {
        return columnId;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setOrderNum(Integer orderNum) 
    {
        this.orderNum = orderNum;
    }

    public Integer getOrderNum() 
    {
        return orderNum;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }
    public void setColumnType(Integer columnType) 
    {
        this.columnType = columnType;
    }

    public Integer getColumnType() 
    {
        return columnType;
    }
    public void setIsAppShow(Integer isAppShow) 
    {
        this.isAppShow = isAppShow;
    }

    public Integer getIsAppShow() 
    {
        return isAppShow;
    }
    public void setIsWxShow(Integer isWxShow) 
    {
        this.isWxShow = isWxShow;
    }

    public Integer getIsWxShow() 
    {
        return isWxShow;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("columnId", getColumnId())
            .append("name", getName())
            .append("orderNum", getOrderNum())
            .append("status", getStatus())
            .append("remark", getRemark())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("createBy", getCreateBy())
            .append("columnType", getColumnType())
            .append("isAppShow", getIsAppShow())
            .append("isWxShow", getIsWxShow())
            .toString();
    }
}
