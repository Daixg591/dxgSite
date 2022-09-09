package com.shahenpc.system.domain.feature;

import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.shahenpc.common.annotation.Excel;
import com.shahenpc.common.core.domain.BaseEntity;

/**
 * 双连工作 聊天对象 feature_double_work_trace
 * 
 * @author ruoyi
 * @date 2022-07-13
 */
@Data
public class FeatureDoubleWorkTrace extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 追踪ID */
    private Long traceId;

    /** 关联意见表 */
    @Excel(name = "关联意见表")
    private Long doubleId;

    /** 发送id */
    @Excel(name = "发送id")
    private Long sendUserId;

    /** 接收id */
    @Excel(name = "接收id")
    private Long receiveUserId;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Integer type;

    /** 0.待审核1.处理中 2.办结 3关闭 */
    @Excel(name = "0.待审核1.处理中 2.办结 3关闭")
    private Integer status;

    /** 图片存储 */
    @Excel(name = "图片存储")
    private String picUrls;

    /** 回复 */
    @Excel(name = "回复")
    private String revert;

    /** 流程类型 */
    @Excel(name = "流程类型")
    private Integer processType;

}
