package com.shahenpc.web.controller.represent;

import com.shahenpc.common.annotation.Log;
import com.shahenpc.common.core.controller.BaseController;
import com.shahenpc.common.core.domain.AjaxResult;
import com.shahenpc.common.core.page.TableDataInfo;
import com.shahenpc.common.enums.BusinessType;
import com.shahenpc.common.utils.poi.ExcelUtil;
import com.shahenpc.flowable.domain.dto.FlowTaskDto;
import com.shahenpc.flowable.domain.vo.FlowTaskVo;
import com.shahenpc.flowable.service.IFlowDefinitionService;
import com.shahenpc.flowable.service.IFlowTaskService;
import com.shahenpc.system.domain.FlowProcDefDto;
import com.shahenpc.system.domain.represent.RepresentMotion;
import com.shahenpc.system.domain.represent.vo.MotionTaskVo;
import com.shahenpc.system.service.represent.IRepresentMotionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 工作-建议议案处理Controller
 * 
 * @author ruoyi
 * @date 2022-07-22
 */
@Api(tags = "议案建议")
@RestController
@RequestMapping("/represent/motion")
public class RepresentMotionController extends BaseController
{
    @Autowired
    private IRepresentMotionService representMotionService;
    @Autowired
    private IFlowDefinitionService flowDefinitionService;
    @Autowired
    private IFlowTaskService flowTaskService;
    /**
     * 查询工作-建议议案处理列表
     */
    @PreAuthorize("@ss.hasPermi('represent:motion:list')")
    @GetMapping("/list")
    public TableDataInfo list(RepresentMotion representMotion)
    {
        startPage();
        List<RepresentMotion> list = representMotionService.selectRepresentMotionList(representMotion);
        return getDataTable(list);
    }

    /**
     * 导出工作-建议议案处理列表
     */
    @PreAuthorize("@ss.hasPermi('represent:motion:export')")
    @Log(title = "工作-建议议案处理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, RepresentMotion representMotion)
    {
        List<RepresentMotion> list = representMotionService.selectRepresentMotionList(representMotion);
        ExcelUtil<RepresentMotion> util = new ExcelUtil<RepresentMotion>(RepresentMotion.class);
        util.exportExcel(response, list, "工作-建议议案处理数据");
    }

    /**
     * 获取工作-建议议案处理详细信息
    @PreAuthorize("@ss.hasPermi('represent:motion:query')")
    @GetMapping(value = "/{motionId}")
    public AjaxResult getInfo(@PathVariable("motionId") Long motionId)
    {
        return AjaxResult.success(representMotionService.selectRepresentMotionByMotionId(motionId));
    }*/

    /**
     * 新增工作-建议议案处理
    @PreAuthorize("@ss.hasPermi('represent:motion:add')")
    @Log(title = "工作-建议议案处理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody RepresentMotion representMotion)
    {
        return toAjax(representMotionService.insertRepresentMotion(representMotion));
    }*/

    /**
     * 修改工作-建议议案处理
     */
    @PreAuthorize("@ss.hasPermi('represent:motion:edit')")
    @Log(title = "工作-建议议案处理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody RepresentMotion representMotion)
    {
        return toAjax(representMotionService.updateRepresentMotion(representMotion));
    }

    /**
     * 删除工作-建议议案处理
     */
    @PreAuthorize("@ss.hasPermi('represent:motion:remove')")
    @Log(title = "工作-建议议案处理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{motionIds}")
    public AjaxResult remove(@PathVariable Long[] motionIds)
    {
        return toAjax(representMotionService.deleteRepresentMotionByMotionIds(motionIds));
    }



    @ApiOperation(value = "催办")
    @PostMapping(value = "/remind")
    public AjaxResult remind(@RequestBody FlowTaskVo flowTaskVo) {
        flowTaskVo.setUserId(getUserId().toString());
        flowTaskService.motionRemind(flowTaskVo);
        return AjaxResult.success();
    }

    @ApiOperation(value = "督办列表", response = FlowTaskDto.class)
    @GetMapping(value = "/superviseList")
    public AjaxResult newTodoList(@ApiParam(value = "当前页码", required = true) @RequestParam Integer pageNum,
                                  @ApiParam(value = "每页条数", required = true) @RequestParam Integer pageSize) {
        return flowTaskService.motionSuperviseList(pageNum, pageSize);
    }

    @ApiOperation(value = "创建建议议案")
    @Log(title = "工作-建议议案处理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody RepresentMotion representMotion) {
        FlowProcDefDto dto=flowDefinitionService.detail("建议议案");
        representMotion.setCreateBy(getUsername());
        representMotion.setSendUserId(getUserId());
        return flowDefinitionService.addMotion(representMotion,dto.getId());
    }

    @ApiOperation(value = "我发起的流程列表", response = FlowTaskDto.class)
    @GetMapping(value = "/myProcess")
    public AjaxResult motionMyProcess(@ApiParam(value = "当前页码", required = true) @RequestParam Integer pageNum,
                                      @ApiParam(value = "每页条数", required = true) @RequestParam Integer pageSize,
                                      RepresentMotion representMotion) {
        return flowTaskService.motionMyProcess(pageNum, pageSize,"建议议案",representMotion);
    }

    @ApiOperation(value = "流程历史流转记录", response = FlowTaskDto.class)
    @GetMapping(value = "/{motionId}")
    public AjaxResult flowRecord(@PathVariable("motionId") Long motionId) {
        RepresentMotion motion= representMotionService.selectRepresentMotionByMotionId(motionId);
        return flowTaskService.motionFlowRecord(motion.getProcinsId(), motion.getDeployId());
    }

    @ApiOperation(value = "获取待办列表", response = FlowTaskDto.class)
    @GetMapping(value = "/todoList")
    public AjaxResult newTodoList(@ApiParam(value = "当前页码", required = true) @RequestParam Integer pageNum,
                                  @ApiParam(value = "每页条数", required = true) @RequestParam Integer pageSize,@ApiParam(value = "类型1.接收2.受理3.分发4.审查5.反馈", required = true) @RequestParam String type) {
        return flowTaskService.motionTodoList(pageNum, pageSize,type);
    }


    @ApiOperation(value = "获取已办任务", response = FlowTaskDto.class)
    @GetMapping(value = "/finishedList")
    public AjaxResult finishedList(@ApiParam(value = "当前页码", required = true) @RequestParam Integer pageNum,
                                   @ApiParam(value = "每页条数", required = true) @RequestParam Integer pageSize,
                                   @ApiParam(value = "各个工作流名称", required = true) @RequestParam String name) {
        return flowTaskService.motionFinishedList(pageNum, pageSize,"建议议案");
    }

    @ApiOperation(value = "审批任务")
    @PostMapping(value = "/complete")
    public AjaxResult complete(@RequestBody FlowTaskVo flowTaskVo) {
        return flowTaskService.motionComplete(flowTaskVo);
    }

    @ApiOperation(value = "驳回任务")
    @PostMapping(value = "/reject")
    public AjaxResult taskReject(@RequestBody FlowTaskVo flowTaskVo) {
        flowTaskService.motionTaskReject(flowTaskVo);
        return AjaxResult.success();
    }

    @ApiOperation(value = "退回任务")
    @PostMapping(value = "/return")
    public AjaxResult taskReturn(@RequestBody FlowTaskVo flowTaskVo) {
        flowTaskService.motionTaskReturn(flowTaskVo);
        return AjaxResult.success();
    }

    @ApiOperation("按月曲线")
    @GetMapping("/line")
    public AjaxResult line(MotionTaskVo vo){
        vo.setProcessName("建议议案");
        return  AjaxResult.success(flowTaskService.line(vo));
    }

    @ApiOperation("类型饼图")
    @GetMapping("/pie")
    public AjaxResult pie(MotionTaskVo vo){
        vo.setProcessName("建议议案");
        return AjaxResult.success(representMotionService.typePie(vo));
    }

    @ApiOperation("状态饼图")
    @GetMapping("/status/pie")
    public AjaxResult statusPie(MotionTaskVo vo){
        vo.setProcessName("建议议案");
        return AjaxResult.success(flowTaskService.motionPie(vo));
    }

    @ApiOperation("落实率")
    @GetMapping("/ring")
    public AjaxResult ring(MotionTaskVo vo){
        vo.setProcessName("建议议案");
        return AjaxResult.success(flowTaskService.ring(vo));
    }

//    @ApiOperation("按类别饼图")
//    @GetMapping("/bar")
//    public AjaxResult bar(MotionTaskVo vo){
//        vo.setProcessName("建议议案");
//        return AjaxResult.success(flowTaskService.bar(vo));
//    }

}
