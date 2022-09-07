package com.shahenpc.system.domain.feature;

import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.shahenpc.common.annotation.Excel;
import com.shahenpc.common.core.domain.BaseEntity;

/**
 * 双联工作对象 feature_double_work
 * 
 * @author ruoyi
 * @date 2022-07-13
 */
@Data
public class FeatureDoubleWork extends BaseEntity
{
    /**  */
    private Long doubleId;
    /**流程类型 1代表 2.联络站负责人3.联络站总负责人*/
    private Integer processType;
    /** 意见类型 */
    @Excel(name = "意见类型")
    private Long type;

    /**  */
    @Excel(name = "")
    private String title;

    /** 状态 */
    @Excel(name = "状态")
    private Integer status;

    /** 图片存储 */
    @Excel(name = "图片存储")
    private String picUrls;

    /** 内容 */
    @Excel(name = "内容")
    private String content;

    /** 接收人id */
    @Excel(name = "接收人id")
    private Long receiveUserId;

    /** 发送id */
    @Excel(name = "发送id")
    private Long sendUserId;

    /** 评价 */
    @Excel(name = "评价")
    private Integer rate;

    /** 通讯地点 */
    @Excel(name = "通讯地点")
    private String address;

    /** 经纬度逗号分割 */
    @Excel(name = "经纬度逗号分割")
    private String location;

}
