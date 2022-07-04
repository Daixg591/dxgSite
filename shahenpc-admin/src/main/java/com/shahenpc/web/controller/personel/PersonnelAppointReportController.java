package com.shahenpc.web.controller.personel;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
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

/**
 * 人事任免_述职报告Controller
 * 
 * @author ruoyi
 * @date 2022-07-04
 */
@RestController
@RequestMapping("/system/report")
public class PersonnelAppointReportController extends BaseController
{
    @Autowired
    private IPersonnelAppointReportService personnelAppointReportService;

    /**
     * 查询人事任免_述职报告列表
     */
    @PreAuthorize("@ss.hasPermi('system:report:list')")
    @GetMapping("/list")
    public TableDataInfo list(PersonnelAppointReport personnelAppointReport)
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
    public void export(HttpServletResponse response, PersonnelAppointReport personnelAppointReport)
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
    public AjaxResult getInfo(@PathVariable("reportId") Long reportId)
    {
        return AjaxResult.success(personnelAppointReportService.selectPersonnelAppointReportByReportId(reportId));
    }

    /**
     * 新增人事任免_述职报告
     */
    @PreAuthorize("@ss.hasPermi('system:report:add')")
    @Log(title = "人事任免_述职报告", businessType = BusinessType.INSERT)
    @PostMapping
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
    public AjaxResult edit(@RequestBody PersonnelAppointReport personnelAppointReport)
    {
        return toAjax(personnelAppointReportService.updatePersonnelAppointReport(personnelAppointReport));
    }

    /**
     * 删除人事任免_述职报告
     */
    @PreAuthorize("@ss.hasPermi('system:report:remove')")
    @Log(title = "人事任免_述职报告", businessType = BusinessType.DELETE)
	@DeleteMapping("/{reportIds}")
    public AjaxResult remove(@PathVariable Long[] reportIds)
    {
        return toAjax(personnelAppointReportService.deletePersonnelAppointReportByReportIds(reportIds));
    }
}
