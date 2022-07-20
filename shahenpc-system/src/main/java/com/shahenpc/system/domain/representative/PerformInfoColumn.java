package com.shahenpc.system.domain.representative;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.shahenpc.common.annotation.Excel;
import com.shahenpc.common.core.domain.BaseEntity;

/**
 * 信息发布栏目菜单对象 perform_info_column
 * 
 * @author ruoyi
 * @date 2022-07-08
 */
public class PerformInfoColumn extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 栏id */
    private Long columnId;

    /** 父产品id */
    @Excel(name = "父产品id")
    private Long parentId;

    /** 产品名称 */
    @Excel(name = "产品名称")
    private String columnName;

    /** 显示顺序 */
    @Excel(name = "显示顺序")
    private Integer orderNum;

    /** 状态状态（0正常 1停用） */
    @Excel(name = "状态状态", readConverterExp = "0=正常,1=停用")
    private String status;

    /** 等级 */
    @Excel(name = "等级")
    private Long level;

    public void setColumnId(Long columnId) 
    {
        this.columnId = columnId;
    }

    public Long getColumnId() 
    {
        return columnId;
    }
    public void setParentId(Long parentId) 
    {
        this.parentId = parentId;
    }

    public Long getParentId() 
    {
        return parentId;
    }
    public void setColumnName(String columnName) 
    {
        this.columnName = columnName;
    }

    public String getColumnName() 
    {
        return columnName;
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
    public void setLevel(Long level) 
    {
        this.level = level;
    }

    public Long getLevel() 
    {
        return level;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("columnId", getColumnId())
            .append("parentId", getParentId())
            .append("columnName", getColumnName())
            .append("orderNum", getOrderNum())
            .append("status", getStatus())
            .append("level", getLevel())
            .append("remark", getRemark())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("createBy", getCreateBy())
            .toString();
    }
}
