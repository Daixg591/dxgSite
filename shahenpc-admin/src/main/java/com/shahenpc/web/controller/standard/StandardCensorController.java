package com.shahenpc.web.controller.standard;

import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;

import com.shahenpc.flowable.domain.dto.FlowTaskDto;
import com.shahenpc.flowable.domain.vo.FlowTaskVo;
import com.shahenpc.flowable.service.IFlowDefinitionService;
import com.shahenpc.flowable.service.IFlowTaskService;
import com.shahenpc.system.domain.FlowProcDefDto;
import com.shahenpc.system.domain.represent.RepresentMotion;
import com.shahenpc.system.domain.represent.vo.MotionTaskVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.shahenpc.common.annotation.Log;
import com.shahenpc.common.core.controller.BaseController;
import com.shahenpc.common.core.domain.AjaxResult;
import com.shahenpc.common.enums.BusinessType;
import com.shahenpc.system.domain.standard.StandardCensor;
import com.shahenpc.system.service.standard.IStandardCensorService;
import com.shahenpc.common.utils.poi.ExcelUtil;
import com.shahenpc.common.core.page.TableDataInfo;

/**
 * 审查流程Controller
 * 
 * @author ruoyi
 * @date 2022-07-22
 */
@Api(tags = "审查流程")
@RestController
@RequestMapping("/standard/censor")
public class StandardCensorController extends BaseController
{
    @Autowired
    private IStandardCensorService standardCensorService;
    @Autowired
    private IFlowDefinitionService flowDefinitionService;
    @Autowired
    private IFlowTaskService flowTaskService;
    /**
     * 查询审查流程列表
     */
    @PreAuthorize("@ss.hasPermi('standard:censor:list')")
    @GetMapping("/list")
    public TableDataInfo list(StandardCensor standardCensor)
    {
        startPage();
        List<StandardCensor> list = standardCensorService.selectStandardCensorList(standardCensor);
        return getDataTable(list);
    }

    /**
     * 导出审查流程列表
     */
    @PreAuthorize("@ss.hasPermi('standard:censor:export')")
    @Log(title = "审查流程", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, StandardCensor standardCensor)
    {
        List<StandardCensor> list = standardCensorService.selectStandardCensorList(standardCensor);
        ExcelUtil<StandardCensor> util = new ExcelUtil<StandardCensor>(StandardCensor.class);
        util.exportExcel(response, list, "审查流程数据");
    }

    /**
     * 获取审查流程详细信息
     */
    @PreAuthorize("@ss.hasPermi('standard:censor:query')")
    @GetMapping(value = "/{processId}")
    public AjaxResult getInfo(@PathVariable("processId") Long processId)
    {
        return AjaxResult.success(standardCensorService.selectStandardCensorByProcessId(processId));
    }

    /**
     * 新增审查流程
     */
//    @PreAuthorize("@ss.hasPermi('standard:censor:add')")
//    @Log(title = "审查流程", businessType = BusinessType.INSERT)
//    @PostMapping
//    public AjaxResult add(@RequestBody StandardCensor standardCensor)
//    {
//        return toAjax(standardCensorService.insertStandardCensor(standardCensor));
//    }

    /**
     * 修改审查流程
     */
    @PreAuthorize("@ss.hasPermi('standard:censor:edit')")
    @Log(title = "审查流程", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody StandardCensor standardCensor)
    {
        return toAjax(standardCensorService.updateStandardCensor(standardCensor));
    }

    /**
     * 删除审查流程
     */
    @PreAuthorize("@ss.hasPermi('standard:censor:remove')")
    @Log(title = "审查流程", businessType = BusinessType.DELETE)
	@DeleteMapping("/{processIds}")
    public AjaxResult remove(@PathVariable Long[] processIds)
    {
        return toAjax(standardCensorService.deleteStandardCensorByProcessIds(processIds));
    }

    /**
     *  审查流程 以下
     * @param standardCensor
     * @return
     */
    @ApiOperation(value = "创建审查流程")
    @Log(title = "工作-审查流程", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody StandardCensor standardCensor) {
        FlowProcDefDto dto=flowDefinitionService.detail("审查流程");
        standardCensor.setCreateBy(getUsername());
        standardCensor.setSendUserId(getUserId());
        return flowDefinitionService.addCensor(standardCensor,dto.getId());
    }

    @ApiOperation(value = "我发起的流程列表", response = FlowTaskDto.class)
    @GetMapping(value = "/myProcess")
    public AjaxResult motionMyProcess(@ApiParam(value = "当前页码", required = true) @RequestParam Integer pageNum,
                                      @ApiParam(value = "每页条数", required = true) @RequestParam Integer pageSize) {
        return flowTaskService.censorMyProcess(pageNum, pageSize,"审查流程");
    }

    @ApiOperation(value = "流程历史流转记录", response = FlowTaskDto.class)
    @GetMapping(value = "/{censorId}")
    public AjaxResult flowRecord(@PathVariable("censorId") Long censorId) {
        StandardCensor censor= standardCensorService.selectStandardCensorByProcessId(censorId);
        return flowTaskService.censorFlowRecord(censor.getProcinsId(), censor.getDeployId());
    }

    @ApiOperation(value = "获取待办列表", response = FlowTaskDto.class)
    @GetMapping(value = "/todoList")
    public AjaxResult newTodoList(@ApiParam(value = "当前页码", required = true) @RequestParam Integer pageNum,
                                  @ApiParam(value = "每页条数", required = true) @RequestParam Integer pageSize,@ApiParam(value = "类型1.接收2.受理3.分发4.审查5.反馈", required = true) @RequestParam String type) {
        return flowTaskService.censorTodoList(pageNum, pageSize,type);
    }

    @ApiOperation(value = "获取已办任务", response = FlowTaskDto.class)
    @GetMapping(value = "/finishedList")
    public AjaxResult finishedList(@ApiParam(value = "当前页码", required = true) @RequestParam Integer pageNum,
                                   @ApiParam(value = "每页条数", required = true) @RequestParam Integer pageSize,
                                   @ApiParam(value = "各个工作流名称", required = true) @RequestParam String name) {
        return flowTaskService.censorFinishedList(pageNum, pageSize,name);
    }

    @ApiOperation(value = "审批任务")
    @PostMapping(value = "/complete")
    public AjaxResult complete(@RequestBody FlowTaskVo flowTaskVo) {
        return flowTaskService.censorComplete(flowTaskVo);
    }

    @ApiOperation(value = "驳回任务")
    @PostMapping(value = "/reject")
    public AjaxResult taskReject(@RequestBody FlowTaskVo flowTaskVo) {
        flowTaskService.censorTaskReject(flowTaskVo);
        return AjaxResult.success();
    }

    @ApiOperation(value = "退回任务")
    @PostMapping(value = "/return")
    public AjaxResult taskReturn(@RequestBody FlowTaskVo flowTaskVo) {
        flowTaskService.censorTaskReturn(flowTaskVo);
        return AjaxResult.success();
    }

    @ApiOperation("按月曲线")
    @GetMapping("/line")
    public AjaxResult line(MotionTaskVo vo){
        vo.setProcessName("审查流程");
        return  AjaxResult.success(flowTaskService.line(vo));
    }

    @ApiOperation("按类别饼图")
    @GetMapping("/pie")
    public AjaxResult pie(MotionTaskVo vo){
        vo.setProcessName("审查流程");
        return AjaxResult.success(flowTaskService.pie(vo));
    }

    @ApiOperation("落实率")
    @GetMapping("/ring")
    public AjaxResult ring(MotionTaskVo vo){
        vo.setProcessName("审查流程");
        return AjaxResult.success(flowTaskService.ring(vo));
    }
}