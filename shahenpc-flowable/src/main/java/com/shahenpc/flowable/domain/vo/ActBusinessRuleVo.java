package com.shahenpc.flowable.domain.vo;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import com.shahenpc.flowable.domain.ActBusinessRuleParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.util.Date;
import java.util.List;

/**
 * 业务规则视图对象 act_business_rule
 *
 * @author gssong
 * @date 2021-12-16
 */
@Data
@ApiModel("业务规则视图对象")
@ExcelIgnoreUnannotated
public class ActBusinessRuleVo {
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @ExcelProperty(value = "主键")
    @ApiModelProperty("主键")
    private Long id;

    /**
     * bean名称
     */
    @ExcelProperty(value = "bean名称")
    @ApiModelProperty("bean名称")
    private String beanName;

    /**
     * 方法名
     */
    @ExcelProperty(value = "方法名")
    @ApiModelProperty("方法名")
    private String method;

    /**
     * 参数
     */
    @ExcelProperty(value = "参数")
    @ApiModelProperty(value = "参数")
    private String param;

    /**
     * 备注
     */
    @ExcelProperty(value = "备注")
    @ApiModelProperty("备注")
    private String remark;

    /**
     * 创建时间
     */
    @ExcelProperty(value = "创建时间")
    @ApiModelProperty("创建时间")
    private Date createTime;

    /**
     * 更新时间
     */
    @ExcelProperty(value = "更新时间")
    @ApiModelProperty("更新时间")
    private Date updateTime;

    /**
     * 创建人
     */
    @ExcelProperty(value = "创建人")
    @ApiModelProperty("创建人")
    private String createBy;

    /**
     * 更新人
     */
    @ExcelProperty(value = "更新人")
    @ApiModelProperty("更新人")
    private String updateBy;

    /**
     * 参数
     */
    @ApiModelProperty(value = "参数")
    private List<ActBusinessRuleParam> businessRuleParams;


}
