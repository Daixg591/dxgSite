package com.shahenpc.web.controller.budget;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.shahenpc.system.domain.budget.dto.AlarmListDto;
import com.shahenpc.system.domain.budget.dto.BudgetDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.shahenpc.common.annotation.Log;
import com.shahenpc.common.core.controller.BaseController;
import com.shahenpc.common.core.domain.AjaxResult;
import com.shahenpc.common.enums.BusinessType;
import com.shahenpc.system.domain.budget.OutlayAlarm;
import com.shahenpc.system.service.budget.IOutlayAlarmService;
import com.shahenpc.common.utils.poi.ExcelUtil;
import com.shahenpc.common.core.page.TableDataInfo;

/**
 * 预警后存储数据Controller
 * @author ruoyi
 * @date 2022-07-04
 */
@Api(tags = "预警后存储表信息")
@RestController
@RequestMapping("/outlay/alarm")
public class OutlayAlarmController extends BaseController
{
    @Autowired
    private IOutlayAlarmService outlayAlarmService;

    @ApiOperation("预算占比")
    @PreAuthorize("@ss.hasPermi('outlay:alarm:list')")
    @GetMapping("/cake/scale")
    public AjaxResult cakeScale(@RequestParam String year)
    {
        return AjaxResult.success(outlayAlarmService.cakeList(year));
    }


    @ApiOperation("季度四个柱子")
    @GetMapping("/quarter")
    public AjaxResult quarterColumnar(@RequestParam String year)
    {
        return AjaxResult.success(outlayAlarmService.quarter(year));
    }
    /**
     * 查询预警后存储数据列表
     */
    @ApiOperation("预警后的列表")
    @PreAuthorize("@ss.hasPermi('outlay:alarm:list')")
    @GetMapping("/list")
    public TableDataInfo list(BudgetDto requst)
    {
        startPage();
        List<AlarmListDto> list = outlayAlarmService.selectByList(requst);
        return getDataTable(list);
    }

    /**
     * 导出预警后存储数据列表
     */
    @PreAuthorize("@ss.hasPermi('outlay:alarm:export')")
    @Log(title = "预警后存储数据", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, OutlayAlarm outlayAlarm)
    {
        List<OutlayAlarm> list = outlayAlarmService.selectOutlayAlarmList(outlayAlarm);
        ExcelUtil<OutlayAlarm> util = new ExcelUtil<OutlayAlarm>(OutlayAlarm.class);
        util.exportExcel(response, list, "预警后存储数据数据");
    }

    /**
     * 获取预警后存储数据详细信息
     */
    @PreAuthorize("@ss.hasPermi('outlay:alarm:query')")
    @GetMapping(value = "/{alarmId}")
    public AjaxResult getInfo(@PathVariable("alarmId") Long alarmId)
    {
        return AjaxResult.success(outlayAlarmService.detail(alarmId));
    }

    /**
     * 新增预警后存储数据
     */
    @PreAuthorize("@ss.hasPermi('outlay:alarm:add')")
    @Log(title = "预警后存储数据", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody OutlayAlarm outlayAlarm)
    {
        outlayAlarm.setCreateBy(getNickName());
        return toAjax(outlayAlarmService.insertOutlayAlarm(outlayAlarm));
    }

    /**
     * 修改预警后存储数据
     */
    @PreAuthorize("@ss.hasPermi('outlay:alarm:edit')")
    @Log(title = "预警后存储数据", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody OutlayAlarm outlayAlarm)
    {
        outlayAlarm.setCreateBy(getNickName());
        return toAjax(outlayAlarmService.updateOutlayAlarm(outlayAlarm));
    }

    /**
     * 删除预警后存储数据
     */
    @PreAuthorize("@ss.hasPermi('outlay:alarm:remove')")
    @Log(title = "预警后存储数据", businessType = BusinessType.DELETE)
	@DeleteMapping("/{alarmIds}")
    public AjaxResult remove(@PathVariable Long[] alarmIds)
    {
        return toAjax(outlayAlarmService.deleteOutlayAlarmByAlarmIds(alarmIds));
    }
}
