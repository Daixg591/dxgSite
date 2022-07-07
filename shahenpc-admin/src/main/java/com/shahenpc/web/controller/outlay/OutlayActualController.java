package com.shahenpc.web.controller.outlay;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.shahenpc.common.annotation.Log;
import com.shahenpc.common.core.controller.BaseController;
import com.shahenpc.common.core.domain.AjaxResult;
import com.shahenpc.common.enums.BusinessType;
import com.shahenpc.system.domain.outlay.OutlayActual;
import com.shahenpc.system.service.outlay.IOutlayActualService;
import com.shahenpc.common.utils.poi.ExcelUtil;
import com.shahenpc.common.core.page.TableDataInfo;

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
    public TableDataInfo list(OutlayActual outlayActual)
    {
        startPage();
        List<OutlayActual> list = outlayActualService.selectOutlayActualList(outlayActual);
        return getDataTable(list);
    }

    /**
     * 导出实际支出列表
     */
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
}
