package com.shahenpc.web.controller.exam;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import io.swagger.annotations.Api;
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
import com.shahenpc.system.domain.exam.PersonnelAppointExam;
import com.shahenpc.system.service.exam.IPersonnelAppointExamService;
import com.shahenpc.common.utils.poi.ExcelUtil;
import com.shahenpc.common.core.page.TableDataInfo;

/**
 * 人事任免_法律知识考试_考试管理Controller
 *
 * @author ruoyi
 * @date 2022-07-27
 */
@RestController
@Api(tags = "考试_信息管理")
@RequestMapping("/exam/examDo")
public class PersonnelAppointExamController extends BaseController {
    @Autowired
    private IPersonnelAppointExamService personnelAppointExamService;

    /**
     * 查询人事任免_法律知识考试_考试管理列表
     */
    @ApiOperation("列表")
    @PreAuthorize("@ss.hasPermi('system:exam:list')")
    @GetMapping("/list")
    public TableDataInfo list(PersonnelAppointExam personnelAppointExam) {
        startPage();
        List<PersonnelAppointExam> list = personnelAppointExamService.selectPersonnelAppointExamList(personnelAppointExam);
        return getDataTable(list);
    }


    /**
     * 导出人事任免_法律知识考试_考试管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:exam:export')")
    @Log(title = "人事任免_法律知识考试_考试管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, PersonnelAppointExam personnelAppointExam) {
        List<PersonnelAppointExam> list = personnelAppointExamService.selectPersonnelAppointExamList(personnelAppointExam);
        ExcelUtil<PersonnelAppointExam> util = new ExcelUtil<PersonnelAppointExam>(PersonnelAppointExam.class);
        util.exportExcel(response, list, "人事任免_法律知识考试_考试管理数据");
    }


    /**
     * 获取人事任免_法律知识考试_考试管理详细信息
     */
    @ApiOperation("详情")
    @PreAuthorize("@ss.hasPermi('system:exam:query')")
    @GetMapping(value = "/{examId}")
    public AjaxResult getInfo(@PathVariable("examId") Long examId) {
        PersonnelAppointExam entity = personnelAppointExamService.selectPersonnelAppointExamByExamId(examId);
        return AjaxResult.success(entity);
    }


    /**
     * 新增人事任免_法律知识考试_考试管理
     */
    @ApiOperation("新增")
    @PreAuthorize("@ss.hasPermi('system:exam:add')")
    @Log(title = "人事任免_法律知识考试_考试管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PersonnelAppointExam personnelAppointExam) {
        return toAjax(personnelAppointExamService.insertPersonnelAppointExam(personnelAppointExam));
    }

    /**
     * 修改人事任免_法律知识考试_考试管理
     */
    @ApiOperation("编辑")
    @PreAuthorize("@ss.hasPermi('system:exam:edit')")
    @Log(title = "人事任免_法律知识考试_考试管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PersonnelAppointExam personnelAppointExam) {
        return toAjax(personnelAppointExamService.updatePersonnelAppointExam(personnelAppointExam));
    }

    /**
     * 删除人事任免_法律知识考试_考试管理
     */
    @ApiOperation("删除")
    @PreAuthorize("@ss.hasPermi('system:exam:remove')")
    @Log(title = "人事任免_法律知识考试_考试管理", businessType = BusinessType.DELETE)
    @DeleteMapping("/{examIds}")
    public AjaxResult remove(@PathVariable Long[] examIds) {
        return toAjax(personnelAppointExamService.deletePersonnelAppointExamByExamIds(examIds));
    }
}
