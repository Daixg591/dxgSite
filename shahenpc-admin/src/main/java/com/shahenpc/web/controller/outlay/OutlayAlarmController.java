package com.shahenpc.web.controller.outlay;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import io.swagger.annotations.Api;
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
import com.shahenpc.system.domain.outlay.OutlayAlarm;
import com.shahenpc.system.service.outlay.IOutlayAlarmService;
import com.shahenpc.common.utils.poi.ExcelUtil;
import com.shahenpc.common.core.page.TableDataInfo;

/**
 * 预警后存储数据Controller
 * 
 * @author ruoyi
 * @date 2022-07-04
 */
@Api(tags = "预警后存储表信息")
@RestController
@RequestMapping("/system/alarm")
public class OutlayAlarmController extends BaseController
{
    @Autowired
    private IOutlayAlarmService outlayAlarmService;

    /**
     * 查询预警后存储数据列表
     */
    @PreAuthorize("@ss.hasPermi('system:alarm:list')")
    @GetMapping("/list")
    public TableDataInfo list(OutlayAlarm outlayAlarm)
    {
        startPage();
        List<OutlayAlarm> list = outlayAlarmService.selectOutlayAlarmList(outlayAlarm);
        return getDataTable(list);
    }

    /**
     * 导出预警后存储数据列表
     */
    @PreAuthorize("@ss.hasPermi('system:alarm:export')")
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
    @PreAuthorize("@ss.hasPermi('system:alarm:query')")
    @GetMapping(value = "/{alarmId}")
    public AjaxResult getInfo(@PathVariable("alarmId") Long alarmId)
    {
        return AjaxResult.success(outlayAlarmService.selectOutlayAlarmByAlarmId(alarmId));
    }

    /**
     * 新增预警后存储数据
     */
    @PreAuthorize("@ss.hasPermi('system:alarm:add')")
    @Log(title = "预警后存储数据", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody OutlayAlarm outlayAlarm)
    {
        return toAjax(outlayAlarmService.insertOutlayAlarm(outlayAlarm));
    }

    /**
     * 修改预警后存储数据
     */
    @PreAuthorize("@ss.hasPermi('system:alarm:edit')")
    @Log(title = "预警后存储数据", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody OutlayAlarm outlayAlarm)
    {
        return toAjax(outlayAlarmService.updateOutlayAlarm(outlayAlarm));
    }

    /**
     * 删除预警后存储数据
     */
    @PreAuthorize("@ss.hasPermi('system:alarm:remove')")
    @Log(title = "预警后存储数据", businessType = BusinessType.DELETE)
	@DeleteMapping("/{alarmIds}")
    public AjaxResult remove(@PathVariable Long[] alarmIds)
    {
        return toAjax(outlayAlarmService.deleteOutlayAlarmByAlarmIds(alarmIds));
    }
}
