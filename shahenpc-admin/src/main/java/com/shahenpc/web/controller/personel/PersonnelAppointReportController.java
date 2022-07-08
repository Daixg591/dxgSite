package com.shahenpc.web.controller.personel;

import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.shahenpc.system.domain.personel.dto.PersonnelQueryDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import net.sf.jsqlparser.statement.delete.Delete;
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
import com.shahenpc.system.domain.personel.PersonnelAppointReport;
import com.shahenpc.system.service.personel.IPersonnelAppointReportService;
import com.shahenpc.common.utils.poi.ExcelUtil;
import com.shahenpc.common.core.page.TableDataInfo;

import static net.sf.jsqlparser.parser.feature.Feature.delete;

/**
 * 人事任免_述职报告Controller
 * 
 * @author ruoyi
 * @date 2022-07-04
 */
@RestController
@RequestMapping("/system/report")
@Api(tags = "人事任免_述职报告 Done √")
public class PersonnelAppointReportController extends BaseController
{
    @Autowired
    private IPersonnelAppointReportService personnelAppointReportService;

    /**
     * 查询人事任免_述职报告列表
     */
    @ApiOperation("查询-述职报告")
    @PreAuthorize("@ss.hasPermi('system:report:list')")
    @GetMapping("/list")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "nickName", value = "人员姓名", dataType = "String", dataTypeClass = String.class),
            @ApiImplicitParam(name = "appointType", value = "任免类型", dataType = "Integer", dataTypeClass = String.class),
            @ApiImplicitParam(name = "keyWords", value = "关键词", dataType = "String", dataTypeClass = String.class),
            @ApiImplicitParam(name = "startTime", value = "开始时间", dataType = "String", dataTypeClass = Date.class),
            @ApiImplicitParam(name = "endTime", value = "结束时间", dataType = "String", dataTypeClass = Date.class)
    })
    public TableDataInfo list(PersonnelQueryDto personnelAppointReport)
    {
        startPage();
        List<PersonnelAppointReport> list = personnelAppointReportService.selectPersonnelAppointReportList(personnelAppointReport);
        return getDataTable(list);
    }

    /**
     * 导出人事任免_述职报告列表
     */
    @PreAuthorize("@ss.hasPermi('system:report:export')")
    @Log(title = "人事任免_述职报告", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, PersonnelQueryDto personnelAppointReport)
    {
        List<PersonnelAppointReport> list = personnelAppointReportService.selectPersonnelAppointReportList(personnelAppointReport);
        ExcelUtil<PersonnelAppointReport> util = new ExcelUtil<PersonnelAppointReport>(PersonnelAppointReport.class);
        util.exportExcel(response, list, "人事任免_述职报告数据");
    }

    /**
     * 获取人事任免_述职报告详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:report:query')")
    @GetMapping(value = "/{reportId}")
    @ApiOperation("详情-述职报告")
    public AjaxResult getInfo(@PathVariable("reportId") Long registerId)
    {
        PersonnelAppointReport resEntity=personnelAppointReportService.selectPersonnelAppointReportByReportId(registerId);
        return AjaxResult.success(resEntity);
    }

    /**
     * 新增人事任免_述职报告
     */
    @PreAuthorize("@ss.hasPermi('system:report:add')")
    @Log(title = "人事任免_述职报告", businessType = BusinessType.INSERT)
    @PostMapping
    @ApiOperation("新增-述职报告")
    public AjaxResult add(@RequestBody PersonnelAppointReport personnelAppointReport)
    {
        return toAjax(personnelAppointReportService.insertPersonnelAppointReport(personnelAppointReport));
    }

    /**
     * 修改人事任免_述职报告
     */
    @PreAuthorize("@ss.hasPermi('system:report:edit')")
    @Log(title = "人事任免_述职报告", businessType = BusinessType.UPDATE)
    @PutMapping
    @ApiOperation("更新-述职报告")
    public AjaxResult edit(@RequestBody PersonnelAppointReport personnelAppointReport)
    {
        return toAjax(personnelAppointReportService.updatePersonnelAppointReport(personnelAppointReport));
    }

    /**
     * 删除人事任免_述职报告
     */
    @PreAuthorize("@ss.hasPermi('system:report:remove')")
    @Log(title = "人事任免_述职报告", businessType = BusinessType.DELETE)
	@DeleteMapping("/{registerIds}")
    @ApiOperation("删除-述职报告")
    public AjaxResult remove(@PathVariable Long[] registerIds)
    {
        return toAjax(personnelAppointReportService.deletePersonnelAppointReportByReportIds(registerIds));
    }
}
