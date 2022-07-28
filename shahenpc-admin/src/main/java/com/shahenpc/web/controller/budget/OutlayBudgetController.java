package com.shahenpc.web.controller.budget;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.shahenpc.system.domain.budget.dto.BudgetDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.shahenpc.common.annotation.Log;
import com.shahenpc.common.core.controller.BaseController;
import com.shahenpc.common.core.domain.AjaxResult;
import com.shahenpc.common.enums.BusinessType;
import com.shahenpc.system.domain.budget.OutlayBudget;
import com.shahenpc.system.service.budget.IOutlayBudgetService;
import com.shahenpc.common.utils.poi.ExcelUtil;
import com.shahenpc.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 预算Controller
 * 
 * @author ruoyi
 * @date 2022-07-01
 */
@Api(tags = "预算管理")
@RestController
@RequestMapping("/outlay/budget")
public class OutlayBudgetController extends BaseController
{
    @Autowired
    private IOutlayBudgetService outlayBudgetService;

    /**
     * 查询预算列表
     */
    @ApiOperation("累计记录and本月记录")
    @PreAuthorize("@ss.hasPermi('outlay:budget:count')")
    @GetMapping("/count")
    public AjaxResult getCount()
    {
        return AjaxResult.success(outlayBudgetService.getCount());
    }

    /**
     * 查询预算列表
     */
    @ApiOperation("预算支出列表")
    @PreAuthorize("@ss.hasPermi('outlay:budget:list')")
    @GetMapping("/list")
    public TableDataInfo list(BudgetDto request)
    {
        startPage();
        List<OutlayBudget> list = outlayBudgetService.newList(request);
        return getDataTable(list);
    }

    @ApiOperation("导出模板")
    @PreAuthorize("@ss.hasPermi('outlay:budget:export')")
    @Log(title = "预算", businessType = BusinessType.CLEAN)
    @PostMapping("/template")
    public void template(HttpServletResponse response)
    {
        List<OutlayBudget> list = null;
        ExcelUtil<OutlayBudget> util = new ExcelUtil<OutlayBudget>(OutlayBudget.class);
        util.importTemplateExcel(response,"预算模板");
    }
    /**
     * 导出预算列表
     */
    @ApiOperation("导出")
    @PreAuthorize("@ss.hasPermi('outlay:budget:export')")
    @Log(title = "预算", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, OutlayBudget outlayBudget)
    {
        List<OutlayBudget> list = outlayBudgetService.selectOutlayBudgetList(outlayBudget);
        ExcelUtil<OutlayBudget> util = new ExcelUtil<OutlayBudget>(OutlayBudget.class);
        util.exportExcel(response, list, "预算数据");
    }
    /**
     * 导入
     */
    @ApiOperation("导入")
    @PreAuthorize("@ss.hasPermi('outlay:budget:import')")
    @PostMapping("/importData")
    @ResponseBody
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception
    {
        ExcelUtil<OutlayBudget> util = new ExcelUtil<OutlayBudget>(OutlayBudget.class);
        List<OutlayBudget> studentList = util.importExcel(file.getInputStream());
        String operName = getUsername();
        String message = outlayBudgetService.importOutlayBudget(studentList, updateSupport,operName);
        return AjaxResult.success(message);
    }

    /**
     * 获取预算详细信息
     */
    @ApiOperation("预算支出详情")
    @ApiImplicitParam(name = "budgetId", value = "预计ID", required = true, dataType = "int", paramType = "path", dataTypeClass = Integer.class)
    @PreAuthorize("@ss.hasPermi('outlay:budget:query')")
    @GetMapping(value = "/{budgetId}")
    public AjaxResult getInfo(@PathVariable("budgetId") Long budgetId)
    {
        return AjaxResult.success(outlayBudgetService.selectOutlayBudgetByBudgetId(budgetId));
    }

    /**
     * 新增预算
     */
    @ApiOperation("新增预算支出")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "budgetId", value = "预支id", dataType = "Integer", dataTypeClass = Integer.class),
            @ApiImplicitParam(name = "alarmId", value = "预警id", dataType = "String", dataTypeClass = String.class),
            @ApiImplicitParam(name = "budgetType", value = "预支类型", dataType = "String", dataTypeClass = String.class),
            @ApiImplicitParam(name = "title", value = "标题", dataType = "String", dataTypeClass = String.class),
            @ApiImplicitParam(name = "year", value = "年份", dataType = "String", dataTypeClass = String.class),
            @ApiImplicitParam(name = "illustrate", value = "意见", dataType = "String", dataTypeClass = String.class),
            @ApiImplicitParam(name = "amount", value = "金额", dataType = "String", dataTypeClass = String.class),
            @ApiImplicitParam(name = "status", value = "状态", dataType = "Integer", dataTypeClass = String.class),
            @ApiImplicitParam(name = "proposedUserId", value = "提出人", dataType = "String", dataTypeClass = String.class),
            @ApiImplicitParam(name = "beyondRatio", value = "比例", dataType = "String", dataTypeClass = String.class)
    })
    @PreAuthorize("@ss.hasPermi('outlay:budget:add')")
    @Log(title = "预算", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody OutlayBudget outlayBudget)
    {
        outlayBudget.setCreateBy(getUsername());
        return toAjax(outlayBudgetService.insertOutlayBudget(outlayBudget));
    }

    /**
     * 修改预算
     */
    @ApiOperation("修改预支用户")
    @PreAuthorize("@ss.hasPermi('outlay:budget:edit')")
    @Log(title = "预算", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody OutlayBudget outlayBudget)
    {
        return toAjax(outlayBudgetService.updateOutlayBudget(outlayBudget));
    }

    /**
     * 删除预算
     */
    @ApiOperation("删除预支记录")
    @ApiImplicitParam(name = "budgetId", value = "预支id", required = true, dataType = "int", paramType = "path", dataTypeClass = Integer.class)
    @PreAuthorize("@ss.hasPermi('outlay:budget:remove')")
    @Log(title = "预算", businessType = BusinessType.DELETE)
	@DeleteMapping("/{budgetIds}")
    public AjaxResult remove(@PathVariable Long[] budgetIds)
    {
        return toAjax(outlayBudgetService.deleteOutlayBudgetByBudgetIds(budgetIds));
    }
}