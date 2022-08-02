package com.shahenpc.web.controller.exam;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.shahenpc.system.domain.exam.PersonnelAppointPaperBigQuestion;
import com.shahenpc.system.domain.exam.PersonnelAppointQuestion;
import com.shahenpc.system.service.exam.IPersonnelAppointPaperBigQuestionService;
import com.shahenpc.system.service.exam.IPersonnelAppointQuestionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
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
import com.shahenpc.system.domain.exam.PersonnelAppointExamPaper;
import com.shahenpc.system.service.exam.IPersonnelAppointExamPaperService;
import com.shahenpc.common.utils.poi.ExcelUtil;
import com.shahenpc.common.core.page.TableDataInfo;

/**
 * 人事任免_法律知识考虑_试卷管理Controller
 *
 * @author ruoyi
 * @date 2022-07-27
 */
@Api(tags = "考试_试卷管理")
@RestController
@RequestMapping("/exam/paper")
public class PersonnelAppointExamPaperController extends BaseController {
    @Autowired
    private IPersonnelAppointExamPaperService personnelAppointExamPaperService;

    /**
     * 查询人事任免_法律知识考虑_试卷管理列表
     */
    @ApiOperation("考试_试卷列表")
    @PreAuthorize("@ss.hasPermi('system:paper:list')")
    @GetMapping("/list")
    public TableDataInfo list(PersonnelAppointExamPaper personnelAppointExamPaper) {
        startPage();
        List<PersonnelAppointExamPaper> list = personnelAppointExamPaperService.selectPersonnelAppointExamPaperList(personnelAppointExamPaper);
        return getDataTable(list);
    }

    /**
     * 导出人事任免_法律知识考虑_试卷管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:paper:export')")
    @Log(title = "人事任免_法律知识考虑_试卷管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, PersonnelAppointExamPaper personnelAppointExamPaper) {
        List<PersonnelAppointExamPaper> list = personnelAppointExamPaperService.selectPersonnelAppointExamPaperList(personnelAppointExamPaper);
        ExcelUtil<PersonnelAppointExamPaper> util = new ExcelUtil<PersonnelAppointExamPaper>(PersonnelAppointExamPaper.class);
        util.exportExcel(response, list, "人事任免_法律知识考虑_试卷管理数据");
    }

    /**
     * 获取人事任免_法律知识考虑_试卷管理详细信息
     */
    @ApiOperation("考试_试卷详情")
    @PreAuthorize("@ss.hasPermi('system:paper:query')")
    @GetMapping(value = "/{examPaperId}")
    public AjaxResult getInfo(@PathVariable("examPaperId") Long examPaperId) {
        PersonnelAppointExamPaper entity = personnelAppointExamPaperService.selectPersonnelAppointExamPaperByExamPaperId(examPaperId);
        return AjaxResult.success(entity);
    }

    /**
     * 新增人事任免_法律知识考虑_试卷管理
     */
    @ApiOperation("考试_新增试卷")
    @PreAuthorize("@ss.hasPermi('system:paper:add')")
    @Log(title = "人事任免_法律知识考虑_试卷管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PersonnelAppointExamPaper personnelAppointExamPaper) {
        personnelAppointExamPaper.setCreateBy(getUsername());
        personnelAppointExamPaperService.insertPersonnelAppointExamPaper(personnelAppointExamPaper);
        return AjaxResult.success(personnelAppointExamPaper.getExamPaperId());
    }

    /**
     * 修改人事任免_法律知识考虑_试卷管理
     */
    @ApiOperation("考试_编辑试卷")
    @PreAuthorize("@ss.hasPermi('system:paper:edit')")
    @Log(title = "人事任免_法律知识考虑_试卷管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PersonnelAppointExamPaper personnelAppointExamPaper) {
        return toAjax(personnelAppointExamPaperService.updatePersonnelAppointExamPaper(personnelAppointExamPaper));
    }

    /**
     * 删除人事任免_法律知识考虑_试卷管理
     */
    @ApiOperation("考试_删除试卷")
    @PreAuthorize("@ss.hasPermi('system:paper:remove')")
    @Log(title = "人事任免_法律知识考虑_试卷管理", businessType = BusinessType.DELETE)
    @DeleteMapping("/{examPaperIds}")
    public AjaxResult remove(@PathVariable Long[] examPaperIds) {
        return toAjax(personnelAppointExamPaperService.deletePersonnelAppointExamPaperByExamPaperIds(examPaperIds));
    }
}
