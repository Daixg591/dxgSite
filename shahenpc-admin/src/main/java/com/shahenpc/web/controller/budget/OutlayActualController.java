package com.shahenpc.web.controller.budget;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.shahenpc.system.domain.budget.OutlayBudget;
import com.shahenpc.system.domain.budget.dto.BudgetDto;
import com.shahenpc.system.domain.budget.dto.OutlayActualListDto;
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
import com.shahenpc.system.domain.budget.OutlayActual;
import com.shahenpc.system.service.budget.IOutlayActualService;
import com.shahenpc.common.utils.poi.ExcelUtil;
import com.shahenpc.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 实际支出Controller
 * 
 * @author ruoyi
 * @date 2022-07-01
 */
@Api(tags = "实际支出管理")
@RestController
@RequestMapping("/outlay/actual")
public class OutlayActualController extends BaseController
{
    @Autowired
    private IOutlayActualService outlayActualService;

    /**
     *
     * @param
     * @return
     */
    @ApiOperation("费用总和展示")
    @PreAuthorize("@ss.hasPermi('outlay:actual:count')")
    @GetMapping("/list/count")
    public AjaxResult count()
    {
        return AjaxResult.success(outlayActualService.listCount());
    }

    @ApiOperation("累计记录and本月记录")
    @PreAuthorize("@ss.hasPermi('outlay:actual:count')")
    @GetMapping("/count")
    public AjaxResult getCount()
    {
        return AjaxResult.success(outlayActualService.getCount());
    }
    /**
     * 查询实际支出列表
     */
    @ApiOperation("实际支出列表")
    @PreAuthorize("@ss.hasPermi('outlay:actual:list')")
    @GetMapping("/list")
    public TableDataInfo list(BudgetDto request)
    {
        startPage();
        List<OutlayActualListDto> list = outlayActualService.newList(request);
        return getDataTable(list);
    }

    /**
     * 导出实际支出列表
     */
    @ApiOperation("导出")
    @PreAuthorize("@ss.hasPermi('outlay:actual:export')")
    @Log(title = "实际支出", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, OutlayActual outlayActual)
    {
        List<OutlayActual> list = outlayActualService.selectOutlayActualList(outlayActual);
        ExcelUtil<OutlayActual> util = new ExcelUtil<OutlayActual>(OutlayActual.class);
        util.exportExcel(response, list, "实际支出数据");
    }
    /**
     * 导入
     */
    @ApiOperation("导入")
    @PreAuthorize("@ss.hasPermi('outlay:actual:import')")
    @PostMapping("/importData")
    @ResponseBody
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception
    {
        ExcelUtil<OutlayActual> util = new ExcelUtil<OutlayActual>(OutlayActual.class);
        List<OutlayActual> studentList = util.importExcel(file.getInputStream());
        String operName = getUsername();
        String message = outlayActualService.importOutlayActual(studentList, updateSupport,operName);
        return AjaxResult.success(message);
    }

    /**
     * 获取实际支出详细信息
     */
    @ApiOperation("实际支出详情")
    @ApiImplicitParam(name = "actualId", value = "支出ID", required = true, dataType = "int", paramType = "path", dataTypeClass = Integer.class)
    @PreAuthorize("@ss.hasPermi('outlay:actual:query')")
    @GetMapping(value = "/{actualId}")
    public AjaxResult getInfo(@PathVariable("actualId") Long actualId)
    {
        return AjaxResult.success(outlayActualService.selectOutlayActualByActualId(actualId));
    }

    /**
     * 新增实际支出
     */
    @ApiOperation("新增实际支出")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "actualId", value = "支出ID", required = true, dataType = "int", paramType = "path", dataTypeClass = Integer.class),
            @ApiImplicitParam(name = "budgetId", value = "预支出ID", required = true, dataType = "int", paramType = "path", dataTypeClass = Integer.class),
            @ApiImplicitParam(name = "amount", value = "金额", required = true, dataType = "int", paramType = "path", dataTypeClass = Integer.class),
            @ApiImplicitParam(name = "superviseUserId", value = "监督Id", required = true, dataType = "int", paramType = "path", dataTypeClass = Integer.class)
    })
    @PreAuthorize("@ss.hasPermi('outlay:actual:add')")
    @Log(title = "实际支出", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody OutlayActual outlayActual)
    {
        outlayActual.setCreateBy(getUsername());
        return toAjax(outlayActualService.insertOutlayActual(outlayActual));
    }

    /**
     * 修改实际支出
     */
    @ApiOperation("修改实际支出")
    @PreAuthorize("@ss.hasPermi('outlay:actual:edit')")
    @Log(title = "实际支出", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody OutlayActual outlayActual)
    {
        outlayActual.setCreateBy(getUsername());
        return toAjax(outlayActualService.updateOutlayActual(outlayActual));
    }

    /**
     * 删除实际支出
     */
    @ApiOperation("删除实际支出")
    @PreAuthorize("@ss.hasPermi('outlay:actual:remove')")
    @Log(title = "实际支出", businessType = BusinessType.DELETE)
	@DeleteMapping("/{actualIds}")
    public AjaxResult remove(@PathVariable Long[] actualIds)
    {
        return toAjax(outlayActualService.deleteOutlayActualByActualIds(actualIds));
    }

    /**
     * 查询实际支出列表

    @ApiOperation("实际支出列表")
    @PreAuthorize("@ss.hasPermi('outlay:actual:list')")
    @GetMapping("/new/list")
    public TableDataInfo newList(OutlayActual outlayActual)
    {
        startPage();
        List<OutlayActualListDto> list = outlayActualService.newList(outlayActual);
        return getDataTable(list);
    }
     */
}
