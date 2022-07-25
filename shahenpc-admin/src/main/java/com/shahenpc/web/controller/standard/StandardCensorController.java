package com.shahenpc.web.controller.standard;

import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;

import com.shahenpc.flowable.domain.dto.FlowTaskDto;
import com.shahenpc.flowable.service.IFlowDefinitionService;
import com.shahenpc.flowable.service.IFlowTaskService;
import com.shahenpc.system.domain.FlowProcDefDto;
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

    @ApiOperation(value = "创建审批流程")
    @PreAuthorize("@ss.hasPermi('standard:censor:add')")
    @Log(title = "审查流程", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@ApiParam(value = "变量集合,json对象") @RequestBody Map<String, Object> variables) {
        FlowProcDefDto dto=flowDefinitionService.detail("审查流程");
        return flowDefinitionService.addCensor(dto.getId(),variables);
    }

    @ApiOperation(value = "我发起的流程", response = FlowTaskDto.class)
    @PreAuthorize("@ss.hasPermi('standard:censor:list')")
    @GetMapping(value = "/censor/myProcess")
    public AjaxResult censorMyProcess(@ApiParam(value = "当前页码", required = true) @RequestParam Integer pageNum,
                                   @ApiParam(value = "每页条数", required = true) @RequestParam Integer pageSize) {
        return flowTaskService.censorMyProcess(pageNum, pageSize,"审查流程");
    }
}
