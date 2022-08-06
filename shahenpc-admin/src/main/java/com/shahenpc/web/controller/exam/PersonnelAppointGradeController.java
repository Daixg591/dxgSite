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
import com.shahenpc.system.domain.exam.PersonnelAppointGrade;
import com.shahenpc.system.service.exam.IPersonnelAppointGradeService;
import com.shahenpc.common.utils.poi.ExcelUtil;
import com.shahenpc.common.core.page.TableDataInfo;

/**
 * 人事任免_法律知识考虑_成绩管理Controller
 * 
 * @author ruoyi
 * @date 2022-07-27
 */
@RestController
@RequestMapping("/exam/grade")
public class PersonnelAppointGradeController extends BaseController
{
    @Autowired
    private IPersonnelAppointGradeService personnelAppointGradeService;

    /**
     * 查询人事任免_法律知识考虑_成绩管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:grade:list')")
    @GetMapping("/list")
    public TableDataInfo list(PersonnelAppointGrade personnelAppointGrade)
    {
        startPage();
        List<PersonnelAppointGrade> list = personnelAppointGradeService.selectPersonnelAppointGradeList(personnelAppointGrade);
        return getDataTable(list);
    }

    /**
     * 导出人事任免_法律知识考虑_成绩管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:grade:export')")
    @Log(title = "人事任免_法律知识考虑_成绩管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, PersonnelAppointGrade personnelAppointGrade)
    {
        List<PersonnelAppointGrade> list = personnelAppointGradeService.selectPersonnelAppointGradeList(personnelAppointGrade);
        ExcelUtil<PersonnelAppointGrade> util = new ExcelUtil<PersonnelAppointGrade>(PersonnelAppointGrade.class);
        util.exportExcel(response, list, "人事任免_法律知识考虑_成绩管理数据");
    }

    /**
     * 获取人事任免_法律知识考虑_成绩管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:grade:query')")
    @GetMapping(value = "/{gradeId}")
    public AjaxResult getInfo(@PathVariable("gradeId") Long gradeId)
    {
        return AjaxResult.success(personnelAppointGradeService.selectPersonnelAppointGradeByGradeId(gradeId));
    }

    /**
     * 新增人事任免_法律知识考虑_成绩管理
     */
    @PreAuthorize("@ss.hasPermi('system:grade:add')")
    @Log(title = "人事任免_法律知识考虑_成绩管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PersonnelAppointGrade personnelAppointGrade)
    {
        return toAjax(personnelAppointGradeService.insertPersonnelAppointGrade(personnelAppointGrade));
    }

    /**
     * 修改人事任免_法律知识考虑_成绩管理
     */
    @PreAuthorize("@ss.hasPermi('system:grade:edit')")
    @Log(title = "人事任免_法律知识考虑_成绩管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PersonnelAppointGrade personnelAppointGrade)
    {
        return toAjax(personnelAppointGradeService.updatePersonnelAppointGrade(personnelAppointGrade));
    }

    /**
     * 删除人事任免_法律知识考虑_成绩管理
     */
    @PreAuthorize("@ss.hasPermi('system:grade:remove')")
    @Log(title = "人事任免_法律知识考虑_成绩管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{gradeIds}")
    public AjaxResult remove(@PathVariable Long[] gradeIds)
    {
        return toAjax(personnelAppointGradeService.deletePersonnelAppointGradeByGradeIds(gradeIds));
    }
}
