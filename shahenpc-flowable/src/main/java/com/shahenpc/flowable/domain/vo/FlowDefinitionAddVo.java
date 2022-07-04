package com.shahenpc.flowable.domain.vo;

import lombok.Data;

import java.util.Map;

/**
 * 添加流程 请求
 */
@Data
public class FlowDefinitionAddVo {

    private String procDefId;

    private Map<String, Object> variables;
}
