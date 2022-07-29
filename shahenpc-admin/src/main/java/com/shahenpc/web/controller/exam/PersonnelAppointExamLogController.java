package com.shahenpc.web.controller.exam;

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
import com.shahenpc.system.domain.exam.PersonnelAppointExamLog;
import com.shahenpc.system.service.exam.IPersonnelAppointExamLogService;
import com.shahenpc.common.utils.poi.ExcelUtil;
import com.shahenpc.common.core.page.TableDataInfo;

/**
 * 人事任免_法律知识考试_答题记录Controller
 * 
 * @author ruoyi
 * @date 2022-07-27
 */
@RestController
@RequestMapping("/exam/log")
public class PersonnelAppointExamLogController extends BaseController
{
    @Autowired
    private IPersonnelAppointExamLogService personnelAppointExamLogService;

    /**
     * 查询人事任免_法律知识考试_答题记录列表
     */
    @PreAuthorize("@ss.hasPermi('system:log:list')")
    @GetMapping("/list")
    public TableDataInfo list(PersonnelAppointExamLog personnelAppointExamLog)
    {
        startPage();
        List<PersonnelAppointExamLog> list = personnelAppointExamLogService.selectPersonnelAppointExamLogList(personnelAppointExamLog);
        return getDataTable(list);
    }

    /**
     * 导出人事任免_法律知识考试_答题记录列表
     */
    @PreAuthorize("@ss.hasPermi('system:log:export')")
    @Log(title = "人事任免_法律知识考试_答题记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, PersonnelAppointExamLog personnelAppointExamLog)
    {
        List<PersonnelAppointExamLog> list = personnelAppointExamLogService.selectPersonnelAppointExamLogList(personnelAppointExamLog);
        ExcelUtil<PersonnelAppointExamLog> util = new ExcelUtil<PersonnelAppointExamLog>(PersonnelAppointExamLog.class);
        util.exportExcel(response, list, "人事任免_法律知识考试_答题记录数据");
    }

    /**
     * 获取人事任免_法律知识考试_答题记录详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:log:query')")
    @GetMapping(value = "/{logId}")
    public AjaxResult getInfo(@PathVariable("logId") Long logId)
    {
        return AjaxResult.success(personnelAppointExamLogService.selectPersonnelAppointExamLogByLogId(logId));
    }

    /**
     * 新增人事任免_法律知识考试_答题记录
     */
    @PreAuthorize("@ss.hasPermi('system:log:add')")
    @Log(title = "人事任免_法律知识考试_答题记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PersonnelAppointExamLog personnelAppointExamLog)
    {
        return toAjax(personnelAppointExamLogService.insertPersonnelAppointExamLog(personnelAppointExamLog));
    }

    /**
     * 修改人事任免_法律知识考试_答题记录
     */
    @PreAuthorize("@ss.hasPermi('system:log:edit')")
    @Log(title = "人事任免_法律知识考试_答题记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PersonnelAppointExamLog personnelAppointExamLog)
    {
        return toAjax(personnelAppointExamLogService.updatePersonnelAppointExamLog(personnelAppointExamLog));
    }

    /**
     * 删除人事任免_法律知识考试_答题记录
     */
    @PreAuthorize("@ss.hasPermi('system:log:remove')")
    @Log(title = "人事任免_法律知识考试_答题记录", businessType = BusinessType.DELETE)
	@DeleteMapping("/{logIds}")
    public AjaxResult remove(@PathVariable Long[] logIds)
    {
        return toAjax(personnelAppointExamLogService.deletePersonnelAppointExamLogByLogIds(logIds));
    }
}
