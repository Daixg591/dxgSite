package com.shahenpc.web.controller.personel;

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
import com.shahenpc.system.domain.personel.PersonnelAppointEduLog;
import com.shahenpc.system.service.personel.IPersonnelAppointEduLogService;
import com.shahenpc.common.utils.poi.ExcelUtil;
import com.shahenpc.common.core.page.TableDataInfo;

/**
 * 人事任免_教育记录Controller
 * 
 * @author ruoyi
 * @date 2022-07-04
 */
@Api(tags = "用户信息_人员教育记录信息 Done √")
@RestController
@RequestMapping("/system/log")
public class PersonnelAppointEduLogController extends BaseController
{
    @Autowired
    private IPersonnelAppointEduLogService personnelAppointEduLogService;

    /**
     * 查询人事任免_教育记录列表
     */
    @ApiOperation("教育记录列表")
    @PreAuthorize("@ss.hasPermi('system:log:list')")
    @GetMapping("/list")
    public TableDataInfo list(PersonnelAppointEduLog personnelAppointEduLog)
    {
        startPage();
        List<PersonnelAppointEduLog> list = personnelAppointEduLogService.selectPersonnelAppointEduLogList(personnelAppointEduLog);
        return getDataTable(list);
    }

    /**
     * 导出人事任免_教育记录列表
     */
    @PreAuthorize("@ss.hasPermi('system:log:export')")
    @Log(title = "人事任免_教育记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, PersonnelAppointEduLog personnelAppointEduLog)
    {
        List<PersonnelAppointEduLog> list = personnelAppointEduLogService.selectPersonnelAppointEduLogList(personnelAppointEduLog);
        ExcelUtil<PersonnelAppointEduLog> util = new ExcelUtil<PersonnelAppointEduLog>(PersonnelAppointEduLog.class);
        util.exportExcel(response, list, "人事任免_教育记录数据");
    }

    /**
     * 获取人事任免_教育记录详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:log:query')")
    @GetMapping(value = "/{eduLogId}")
    public AjaxResult getInfo(@PathVariable("eduLogId") Long eduLogId)
    {
        return AjaxResult.success(personnelAppointEduLogService.selectPersonnelAppointEduLogByEduLogId(eduLogId));
    }

    /**
     * 新增人事任免_教育记录
     */
    @ApiOperation("新增人员教育记录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户id", dataType = "Integer", dataTypeClass = Integer.class),
            @ApiImplicitParam(name = "eduType", value = "教育类别", dataType = "String", dataTypeClass = String.class),
            @ApiImplicitParam(name = "school", value = "学校", dataType = "String", dataTypeClass = String.class),
            @ApiImplicitParam(name = "major", value = "专业", dataType = "String", dataTypeClass = String.class),
            @ApiImplicitParam(name = "timeRange", value = "时间段", dataType = "String", dataTypeClass = String.class),
            @ApiImplicitParam(name = "edu", value = "学历", dataType = "String", dataTypeClass = String.class)
    })
    @PreAuthorize("@ss.hasPermi('system:log:add')")
    @Log(title = "人事任免_教育记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PersonnelAppointEduLog personnelAppointEduLog)
    {
        personnelAppointEduLog.setCreateBy(getUsername());
        return toAjax(personnelAppointEduLogService.insertPersonnelAppointEduLog(personnelAppointEduLog));
    }

    /**
     * 修改人事任免_教育记录
     */
    @ApiOperation("更新人员教育记录")
    @PreAuthorize("@ss.hasPermi('system:log:edit')")
    @Log(title = "人事任免_教育记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PersonnelAppointEduLog personnelAppointEduLog)
    {
        personnelAppointEduLog.setUpdateBy(getUsername());
        return toAjax(personnelAppointEduLogService.updatePersonnelAppointEduLog(personnelAppointEduLog));
    }

    /**
     * 删除人事任免_教育记录
     */
    @PreAuthorize("@ss.hasPermi('system:log:remove')")
    @Log(title = "人事任免_教育记录", businessType = BusinessType.DELETE)
	@DeleteMapping("/{eduLogIds}")
    public AjaxResult remove(@PathVariable Long[] eduLogIds)
    {
        return toAjax(personnelAppointEduLogService.deletePersonnelAppointEduLogByEduLogIds(eduLogIds));
    }
}
