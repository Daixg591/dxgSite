package com.shahenpc.web.controller.feature;

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
import com.shahenpc.system.domain.feature.FeatureDoubleWorkTrace;
import com.shahenpc.system.service.feature.IFeatureDoubleWorkTraceService;
import com.shahenpc.common.utils.poi.ExcelUtil;
import com.shahenpc.common.core.page.TableDataInfo;

/**
 * 双连工作 聊天Controller
 * 
 * @author ruoyi
 * @date 2022-07-15
 */
@Api(tags = "双联工作追踪")
@RestController
@RequestMapping("/feature/trace")
public class FeatureDoubleWorkTraceController extends BaseController
{
    @Autowired
    private IFeatureDoubleWorkTraceService featureDoubleWorkTraceService;

    /**
     * 查询双连工作 聊天列表
     */
    @ApiOperation("双联工作追踪列表")
    @PreAuthorize("@ss.hasPermi('feature:trace:list')")
    @GetMapping("/list")
    public TableDataInfo list(FeatureDoubleWorkTrace featureDoubleWorkTrace)
    {
        startPage();
        List<FeatureDoubleWorkTrace> list = featureDoubleWorkTraceService.selectFeatureDoubleWorkTraceList(featureDoubleWorkTrace);
        return getDataTable(list);
    }

    /**
     * 导出双连工作 聊天列表
     */
    @PreAuthorize("@ss.hasPermi('feature:trace:export')")
    @Log(title = "双连工作 聊天", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, FeatureDoubleWorkTrace featureDoubleWorkTrace)
    {
        List<FeatureDoubleWorkTrace> list = featureDoubleWorkTraceService.selectFeatureDoubleWorkTraceList(featureDoubleWorkTrace);
        ExcelUtil<FeatureDoubleWorkTrace> util = new ExcelUtil<FeatureDoubleWorkTrace>(FeatureDoubleWorkTrace.class);
        util.exportExcel(response, list, "双连工作 聊天数据");
    }

    /**
     * 获取双连工作 聊天详细信息
     */
    @ApiOperation("双联工作追踪详情")
    @PreAuthorize("@ss.hasPermi('feature:trace:query')")
    @GetMapping(value = "/{traceId}")
    public AjaxResult getInfo(@PathVariable("traceId") Long traceId)
    {
        return AjaxResult.success(featureDoubleWorkTraceService.selectFeatureDoubleWorkTraceByTraceId(traceId));
    }

    /**
     * 新增双连工作 聊天
     */
    @ApiOperation("新增双联工作追踪")
    @PreAuthorize("@ss.hasPermi('feature:trace:add')")
    @Log(title = "双连工作 聊天", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody FeatureDoubleWorkTrace featureDoubleWorkTrace)
    {
        return toAjax(featureDoubleWorkTraceService.insertFeatureDoubleWorkTrace(featureDoubleWorkTrace));
    }

    /**
     * 修改双连工作 聊天
     */
    @ApiOperation("修改双联工作追踪")
    @PreAuthorize("@ss.hasPermi('feature:trace:edit')")
    @Log(title = "双连工作 聊天", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody FeatureDoubleWorkTrace featureDoubleWorkTrace)
    {
        return toAjax(featureDoubleWorkTraceService.updateFeatureDoubleWorkTrace(featureDoubleWorkTrace));
    }

    /**
     * 删除双连工作 聊天
     */
    @ApiOperation("删除双联工作追踪")
    @PreAuthorize("@ss.hasPermi('feature:trace:remove')")
    @Log(title = "双连工作 聊天", businessType = BusinessType.DELETE)
	@DeleteMapping("/{traceIds}")
    public AjaxResult remove(@PathVariable Long[] traceIds)
    {
        return toAjax(featureDoubleWorkTraceService.deleteFeatureDoubleWorkTraceByTraceIds(traceIds));
    }
}
