package com.shahenpc.web.controller.represent;

import com.shahenpc.common.annotation.Log;
import com.shahenpc.common.core.controller.BaseController;
import com.shahenpc.common.core.domain.AjaxResult;
import com.shahenpc.common.core.page.TableDataInfo;
import com.shahenpc.common.enums.BusinessType;
import com.shahenpc.common.utils.poi.ExcelUtil;
import com.shahenpc.flowable.domain.dto.FlowTaskDto;
import com.shahenpc.flowable.service.IFlowDefinitionService;
import com.shahenpc.flowable.service.IFlowTaskService;
import com.shahenpc.system.domain.FlowProcDefDto;
import com.shahenpc.system.domain.represent.RepresentMotion;
import com.shahenpc.system.service.represent.IRepresentMotionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

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
     */
    @PreAuthorize("@ss.hasPermi('represent:motion:query')")
    @GetMapping(value = "/{motionId}")
    public AjaxResult getInfo(@PathVariable("motionId") Long motionId)
    {
        return AjaxResult.success(representMotionService.selectRepresentMotionByMotionId(motionId));
    }

    /**
     * 新增工作-建议议案处理
     */
//    @PreAuthorize("@ss.hasPermi('represent:motion:add')")
//    @Log(title = "工作-建议议案处理", businessType = BusinessType.INSERT)
//    @PostMapping
//    public AjaxResult add(@RequestBody RepresentMotion representMotion)
//    {
//        return toAjax(representMotionService.insertRepresentMotion(representMotion));
//    }

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

    @ApiOperation(value = "创建建议议案")
    @PreAuthorize("@ss.hasPermi('represent:motion:add')")
    @Log(title = "工作-建议议案处理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@ApiParam(value = "变量集合,json对象") @RequestBody Map<String, Object> variables) {
        FlowProcDefDto dto=flowDefinitionService.detail("建议议案");
        return flowDefinitionService.addMotion(dto.getId(),variables);
    }

    /**
     * 建议议案
     * @param pageNum
     * @param pageSize
     * @return
     */
    @ApiOperation(value = "我发起的流程", response = FlowTaskDto.class)
    @PreAuthorize("@ss.hasPermi('represent:motion:list')")
    @GetMapping(value = "/motion/myProcess")
    public AjaxResult motionMyProcess(@ApiParam(value = "当前页码", required = true) @RequestParam Integer pageNum,
                                      @ApiParam(value = "每页条数", required = true) @RequestParam Integer pageSize) {
        return flowTaskService.motionMyProcess(pageNum, pageSize,"建议议案");
    }

}
