package com.shahenpc.flowable.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.shahenpc.common.core.domain.BaseEntity;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@TableName("act_business_status")
@ApiModel("业务状态实体对象")
public class ActBusinessStatus extends BaseEntity {
    private static final long serialVersionUID=1L;

    /**
     * ID
     */
    @TableId(value = "id")
    private String id;

    /**
     * 业务ID
     */
    private String businessKey;

    /**
     * 流程实例ID
     */
    private String processInstanceId;

    /**
     * 状态
     */
    private String status;

    /**
     * 全类名
     */
    private String classFullName;

    /**
     * 挂起流程原因
     */
    private String suspendedReason;
}
