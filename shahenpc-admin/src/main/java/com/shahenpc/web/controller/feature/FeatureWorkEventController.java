package com.shahenpc.web.controller.feature;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

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
import com.shahenpc.system.domain.feature.FeatureWorkEvent;
import com.shahenpc.system.service.feature.IFeatureWorkEventService;
import com.shahenpc.common.utils.poi.ExcelUtil;
import com.shahenpc.common.core.page.TableDataInfo;

/**
 * 特色工作-民生实事-环境保护-信访稳定-营商环境-乡村振兴Controller
 * 
 * @author ruoyi
 * @date 2022-07-15
 */
@Api(tags = "特色工作-各个事件")
@RestController
@RequestMapping("/feature/event")
public class FeatureWorkEventController extends BaseController
{
    @Autowired
    private IFeatureWorkEventService featureWorkEventService;

    /**
     * 查询特色工作-民生实事-环境保护-信访稳定-营商环境-乡村振兴列表
     */
    @ApiOperation("特色工作列表")
    @PreAuthorize("@ss.hasPermi('feature:event:list')")
    @GetMapping("/list")
    public TableDataInfo list(FeatureWorkEvent featureWorkEvent)
    {
        startPage();
        List<FeatureWorkEvent> list = featureWorkEventService.selectFeatureWorkEventList(featureWorkEvent);
        return getDataTable(list);
    }

    /**
     * 导出特色工作-民生实事-环境保护-信访稳定-营商环境-乡村振兴列表
     */
    @PreAuthorize("@ss.hasPermi('feature:event:export')")
    @Log(title = "特色工作-民生实事-环境保护-信访稳定-营商环境-乡村振兴", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, FeatureWorkEvent featureWorkEvent)
    {
        List<FeatureWorkEvent> list = featureWorkEventService.selectFeatureWorkEventList(featureWorkEvent);
        ExcelUtil<FeatureWorkEvent> util = new ExcelUtil<FeatureWorkEvent>(FeatureWorkEvent.class);
        util.exportExcel(response, list, "特色工作-民生实事-环境保护-信访稳定-营商环境-乡村振兴数据");
    }

    /**
     * 获取特色工作-民生实事-环境保护-信访稳定-营商环境-乡村振兴详细信息
     */
    @ApiOperation("民事实事详情")
    @ApiImplicitParam(name = "specialId",value = "实事Id", required = true, dataType = "int", paramType = "path", dataTypeClass = Integer.class)
    @PreAuthorize("@ss.hasPermi('feature:event:query')")
    @GetMapping(value = "/{eventId}")
    public AjaxResult getInfo(@PathVariable("eventId") Long eventId)
    {
        return AjaxResult.success(featureWorkEventService.selectFeatureWorkEventByEventId(eventId));
    }

    /**
     * 新增特色工作-民生实事-环境保护-信访稳定-营商环境-乡村振兴
     */
    @ApiOperation("新增民事实事")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "specialId",value = "实事Id", required = true, dataType = "Long", paramType = "path", dataTypeClass = Long.class),
            @ApiImplicitParam(name = "title",value = "标题", required = true, dataType = "String", paramType = "path", dataTypeClass = String.class),
            @ApiImplicitParam(name = "content",value = "内容", required = true, dataType = "String", paramType = "path", dataTypeClass = String.class),
    })
    @PreAuthorize("@ss.hasPermi('feature:event:add')")
    @Log(title = "特色工作-民生实事-环境保护-信访稳定-营商环境-乡村振兴", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody FeatureWorkEvent featureWorkEvent)
    {
        return toAjax(featureWorkEventService.insertFeatureWorkEvent(featureWorkEvent));
    }

    /**
     * 修改特色工作-民生实事-环境保护-信访稳定-营商环境-乡村振兴
     */
    @ApiOperation("修改民事实事")
    @PreAuthorize("@ss.hasPermi('feature:event:edit')")
    @Log(title = "特色工作-民生实事-环境保护-信访稳定-营商环境-乡村振兴", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody FeatureWorkEvent featureWorkEvent)
    {
        return toAjax(featureWorkEventService.updateFeatureWorkEvent(featureWorkEvent));
    }

    /**
     * 删除特色工作-民生实事-环境保护-信访稳定-营商环境-乡村振兴
     */
    @ApiOperation("删除民事实事")
    @PreAuthorize("@ss.hasPermi('feature:event:remove')")
    @Log(title = "特色工作-民生实事-环境保护-信访稳定-营商环境-乡村振兴", businessType = BusinessType.DELETE)
	@DeleteMapping("/{eventIds}")
    public AjaxResult remove(@PathVariable Long[] eventIds)
    {
        return toAjax(featureWorkEventService.deleteFeatureWorkEventByEventIds(eventIds));
    }

    @ApiOperation("累计记录and本月记录")
    @PreAuthorize("@ss.hasPermi('feature:event:count')")
    @GetMapping("/count")
    public AjaxResult count(@RequestParam Integer workType)
    {
        return AjaxResult.success(featureWorkEventService.getCount(workType));
    }

    @ApiOperation("曲线每月数量")
    @PreAuthorize("@ss.hasPermi('feature:month:count')")
    @GetMapping("/month/count")
    public AjaxResult monthCount(@RequestParam Integer workType)
    {
        return AjaxResult.success(featureWorkEventService.monthCount(workType));
    }

    @ApiOperation("环比")
    @PreAuthorize("@ss.hasPermi('feature:month:count')")
    @GetMapping("/ring/scale")
    public AjaxResult ringScale(@RequestParam Integer workType)
    {
        Object data = featureWorkEventService.ringScale(workType);
        return AjaxResult.success(data);
    }
}
