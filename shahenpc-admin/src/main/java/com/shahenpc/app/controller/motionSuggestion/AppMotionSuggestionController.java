package com.shahenpc.app.controller.motionSuggestion;

import com.shahenpc.common.core.domain.AjaxResult;
import com.shahenpc.flowable.service.IFlowDefinitionService;
import com.shahenpc.system.domain.FlowProcDefDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Api( tags = "app建议议案")
@RestController
@RequestMapping("/app/motionSuggestion")
public class AppMotionSuggestionController {

    @Autowired
    private IFlowDefinitionService flowDefinitionService;

    /**
     * 添加
     * @param variables
     * @return
     */
    @ApiOperation(value = "启动流程实例")
    @PostMapping("/add")
    public AjaxResult add(@ApiParam(value = "变量集合,json对象") @RequestBody Map<String, Object> variables) {
        FlowProcDefDto dto=flowDefinitionService.detail("议案建议");
        return flowDefinitionService.addMotion(dto.getId(),variables);
    }


}
