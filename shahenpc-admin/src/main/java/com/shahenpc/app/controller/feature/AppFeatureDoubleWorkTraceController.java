package com.shahenpc.app.controller.feature;

import com.shahenpc.common.annotation.Log;
import com.shahenpc.common.core.controller.BaseController;
import com.shahenpc.common.core.domain.AjaxResult;
import com.shahenpc.common.core.page.TableDataInfo;
import com.shahenpc.common.enums.BusinessType;
import com.shahenpc.system.domain.feature.FeatureDoubleWorkTrace;
import com.shahenpc.system.domain.feature.dto.TraceListDto;
import com.shahenpc.system.service.feature.IFeatureDoubleWorkTraceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "App添加双联工作流")
@RestController
@RequestMapping("/app/feature/trace")
public class AppFeatureDoubleWorkTraceController extends BaseController {
    @Autowired
    private IFeatureDoubleWorkTraceService featureDoubleWorkTraceService;

    /**
     * 查询双连工作 聊天列表
     */
    @ApiOperation("双联工作追踪列表")
    @GetMapping("/list")
    public TableDataInfo list(FeatureDoubleWorkTrace featureDoubleWorkTrace)
    {
        startPage();
        List<TraceListDto> list = featureDoubleWorkTraceService.adminList(featureDoubleWorkTrace);
        return getDataTable(list);
    }

    /**
     * 获取双连工作 聊天详细信息
     */
    @ApiOperation("双联工作追踪详情")
    @GetMapping(value = "/{traceId}")
    public AjaxResult getInfo(@PathVariable("traceId") Long traceId)
    {
        return AjaxResult.success(featureDoubleWorkTraceService.selectFeatureDoubleWorkTraceByTraceId(traceId));
    }

    /**
     * 新增双连工作 聊天
     */
    @ApiOperation("新增双联工作追踪")
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
    @Log(title = "双连工作 聊天", businessType = BusinessType.DELETE)
    @DeleteMapping("/{traceIds}")
    public AjaxResult remove(@PathVariable Long[] traceIds)
    {
        return toAjax(featureDoubleWorkTraceService.deleteFeatureDoubleWorkTraceByTraceIds(traceIds));
    }
}
