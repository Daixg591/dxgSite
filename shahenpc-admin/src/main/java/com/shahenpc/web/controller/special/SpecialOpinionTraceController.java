package com.shahenpc.web.controller.special;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import io.swagger.annotations.Api;
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
import com.shahenpc.system.domain.special.SpecialOpinionTrace;
import com.shahenpc.system.service.special.ISpecialOpinionTraceService;
import com.shahenpc.common.utils.poi.ExcelUtil;
import com.shahenpc.common.core.page.TableDataInfo;

/**
 * 【双联工作】Controller
 * 
 * @author ruoyi
 * @date 2022-07-01
 */
@Api(tags = "双联工作追踪管理")
@RestController
@RequestMapping("/system/trace")
public class SpecialOpinionTraceController extends BaseController
{
    @Autowired
    private ISpecialOpinionTraceService specialOpinionTraceService;

    /**
     * 查询【请填写功能名称】列表
     */
    @ApiOperation("双联工作追踪列表")
    @PreAuthorize("@ss.hasPermi('system:trace:list')")
    @GetMapping("/list")
    public TableDataInfo list(SpecialOpinionTrace specialOpinionTrace)
    {
        startPage();
        List<SpecialOpinionTrace> list = specialOpinionTraceService.selectSpecialOpinionTraceList(specialOpinionTrace);
        return getDataTable(list);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('system:trace:export')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SpecialOpinionTrace specialOpinionTrace)
    {
        List<SpecialOpinionTrace> list = specialOpinionTraceService.selectSpecialOpinionTraceList(specialOpinionTrace);
        ExcelUtil<SpecialOpinionTrace> util = new ExcelUtil<SpecialOpinionTrace>(SpecialOpinionTrace.class);
        util.exportExcel(response, list, "【请填写功能名称】数据");
    }

    /**
     * 获取【请填写功能名称】详细信息
     */
    @ApiOperation("双联工作追踪详情")
    @PreAuthorize("@ss.hasPermi('system:trace:query')")
    @GetMapping(value = "/{traceId}")
    public AjaxResult getInfo(@PathVariable("traceId") Long traceId)
    {
        return AjaxResult.success(specialOpinionTraceService.selectSpecialOpinionTraceByTraceId(traceId));
    }

    /**
     * 新增【请填写功能名称】
     */
    @ApiOperation("新增双联工作追踪")
    @PreAuthorize("@ss.hasPermi('system:trace:add')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SpecialOpinionTrace specialOpinionTrace)
    {
        return toAjax(specialOpinionTraceService.insertSpecialOpinionTrace(specialOpinionTrace));
    }

    /**
     * 修改【请填写功能名称】
     */
    @ApiOperation("修改双联工作追踪")
    @PreAuthorize("@ss.hasPermi('system:trace:edit')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SpecialOpinionTrace specialOpinionTrace)
    {
        return toAjax(specialOpinionTraceService.updateSpecialOpinionTrace(specialOpinionTrace));
    }

    /**
     * 删除【请填写功能名称】
     */
    @ApiOperation("删除双联工作追踪")
    @PreAuthorize("@ss.hasPermi('system:trace:remove')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
	@DeleteMapping("/{traceIds}")
    public AjaxResult remove(@PathVariable Long[] traceIds)
    {
        return toAjax(specialOpinionTraceService.deleteSpecialOpinionTraceByTraceIds(traceIds));
    }
}
