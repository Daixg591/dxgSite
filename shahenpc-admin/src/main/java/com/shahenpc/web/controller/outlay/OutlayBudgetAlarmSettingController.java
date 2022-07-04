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
import com.shahenpc.system.domain.outlay.OutlayBudgetAlarmSetting;
import com.shahenpc.system.service.outlay.IOutlayBudgetAlarmSettingService;
import com.shahenpc.common.utils.poi.ExcelUtil;
import com.shahenpc.common.core.page.TableDataInfo;

/**
 * 告警设置-规则Controller
 * 
 * @author ruoyi
 * @date 2022-07-01
 */
@Api(tags = "预算告警管理")
@RestController
@RequestMapping("/system/setting")
public class OutlayBudgetAlarmSettingController extends BaseController
{
    @Autowired
    private IOutlayBudgetAlarmSettingService outlayBudgetAlarmSettingService;

    /**
     * 查询告警设置-规则列表
     */
    @ApiOperation("告警规则列表")
    @PreAuthorize("@ss.hasPermi('system:setting:list')")
    @GetMapping("/list")
    public TableDataInfo list(OutlayBudgetAlarmSetting outlayBudgetAlarmSetting)
    {
        startPage();
        List<OutlayBudgetAlarmSetting> list = outlayBudgetAlarmSettingService.selectOutlayBudgetAlarmSettingList(outlayBudgetAlarmSetting);
        return getDataTable(list);
    }

    /**
     * 导出告警设置-规则列表
     */

    @PreAuthorize("@ss.hasPermi('system:setting:export')")
    @Log(title = "告警设置-规则", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, OutlayBudgetAlarmSetting outlayBudgetAlarmSetting)
    {
        List<OutlayBudgetAlarmSetting> list = outlayBudgetAlarmSettingService.selectOutlayBudgetAlarmSettingList(outlayBudgetAlarmSetting);
        ExcelUtil<OutlayBudgetAlarmSetting> util = new ExcelUtil<OutlayBudgetAlarmSetting>(OutlayBudgetAlarmSetting.class);
        util.exportExcel(response, list, "告警设置-规则数据");
    }

    /**
     * 获取告警设置-规则详细信息
     */
    @ApiOperation("告警规则详情")
    @ApiImplicitParam(name = "alarmId", value = "告警ID", required = true, dataType = "int", paramType = "path", dataTypeClass = Integer.class)
    @PreAuthorize("@ss.hasPermi('system:setting:query')")
    @GetMapping(value = "/{alarmId}")
    public AjaxResult getInfo(@PathVariable("alarmId") Long alarmId)
    {
        return AjaxResult.success(outlayBudgetAlarmSettingService.selectOutlayBudgetAlarmSettingByAlarmId(alarmId));
    }

    /**
     * 新增告警设置-规则
     */
    @ApiOperation("添加告警规则")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "alarmId", value = "告警id", dataType = "Integer", dataTypeClass = Integer.class),
            @ApiImplicitParam(name = "budgetType", value = "预支类型", dataType = "Integer", dataTypeClass = Integer.class),
            @ApiImplicitParam(name = "ratio", value = "比例", dataType = "String", dataTypeClass = String.class),
    })
    @PreAuthorize("@ss.hasPermi('system:setting:add')")
    @Log(title = "告警设置-规则", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody OutlayBudgetAlarmSetting outlayBudgetAlarmSetting)
    {
        return toAjax(outlayBudgetAlarmSettingService.insertOutlayBudgetAlarmSetting(outlayBudgetAlarmSetting));
    }

    /**
     * 修改告警设置-规则
     */
    @ApiOperation("修改告警规则")
    @PreAuthorize("@ss.hasPermi('system:setting:edit')")
    @Log(title = "告警设置-规则", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody OutlayBudgetAlarmSetting outlayBudgetAlarmSetting)
    {
        return toAjax(outlayBudgetAlarmSettingService.updateOutlayBudgetAlarmSetting(outlayBudgetAlarmSetting));
    }

    /**
     * 删除告警设置-规则
     */
    @ApiOperation("删除告警规则")
    @PreAuthorize("@ss.hasPermi('system:setting:remove')")
    @Log(title = "告警设置-规则", businessType = BusinessType.DELETE)
	@DeleteMapping("/{alarmIds}")
    public AjaxResult remove(@PathVariable Long[] alarmIds)
    {
        return toAjax(outlayBudgetAlarmSettingService.deleteOutlayBudgetAlarmSettingByAlarmIds(alarmIds));
    }
}
