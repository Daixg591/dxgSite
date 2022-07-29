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
import com.shahenpc.system.domain.exam.PersonnelAppointPaperBigQuestion;
import com.shahenpc.system.service.exam.IPersonnelAppointPaperBigQuestionService;
import com.shahenpc.common.utils.poi.ExcelUtil;
import com.shahenpc.common.core.page.TableDataInfo;

/**
 * 人事任免_法律知识考试_试卷大题对应Controller
 * 
 * @author ruoyi
 * @date 2022-07-27
 */
@RestController
@RequestMapping("/exam/bigqu")
public class PersonnelAppointPaperBigQuestionController extends BaseController
{
    @Autowired
    private IPersonnelAppointPaperBigQuestionService personnelAppointPaperBigQuestionService;

    /**
     * 查询人事任免_法律知识考试_试卷大题对应列表
     */
    @PreAuthorize("@ss.hasPermi('system:question:list')")
    @GetMapping("/list")
    public TableDataInfo list(PersonnelAppointPaperBigQuestion personnelAppointPaperBigQuestion)
    {
        startPage();
        List<PersonnelAppointPaperBigQuestion> list = personnelAppointPaperBigQuestionService.selectPersonnelAppointPaperBigQuestionList(personnelAppointPaperBigQuestion);
        return getDataTable(list);
    }

    /**
     * 导出人事任免_法律知识考试_试卷大题对应列表
     */
    @PreAuthorize("@ss.hasPermi('system:question:export')")
    @Log(title = "人事任免_法律知识考试_试卷大题对应", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, PersonnelAppointPaperBigQuestion personnelAppointPaperBigQuestion)
    {
        List<PersonnelAppointPaperBigQuestion> list = personnelAppointPaperBigQuestionService.selectPersonnelAppointPaperBigQuestionList(personnelAppointPaperBigQuestion);
        ExcelUtil<PersonnelAppointPaperBigQuestion> util = new ExcelUtil<PersonnelAppointPaperBigQuestion>(PersonnelAppointPaperBigQuestion.class);
        util.exportExcel(response, list, "人事任免_法律知识考试_试卷大题对应数据");
    }

    /**
     * 获取人事任免_法律知识考试_试卷大题对应详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:question:query')")
    @GetMapping(value = "/{bigQuestionId}")
    public AjaxResult getInfo(@PathVariable("bigQuestionId") Long bigQuestionId)
    {
        return AjaxResult.success(personnelAppointPaperBigQuestionService.selectPersonnelAppointPaperBigQuestionByBigQuestionId(bigQuestionId));
    }

    /**
     * 新增人事任免_法律知识考试_试卷大题对应
     */
    @PreAuthorize("@ss.hasPermi('system:question:add')")
    @Log(title = "人事任免_法律知识考试_试卷大题对应", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PersonnelAppointPaperBigQuestion personnelAppointPaperBigQuestion)
    {
        return toAjax(personnelAppointPaperBigQuestionService.insertPersonnelAppointPaperBigQuestion(personnelAppointPaperBigQuestion));
    }

    /**
     * 修改人事任免_法律知识考试_试卷大题对应
     */
    @PreAuthorize("@ss.hasPermi('system:question:edit')")
    @Log(title = "人事任免_法律知识考试_试卷大题对应", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PersonnelAppointPaperBigQuestion personnelAppointPaperBigQuestion)
    {
        return toAjax(personnelAppointPaperBigQuestionService.updatePersonnelAppointPaperBigQuestion(personnelAppointPaperBigQuestion));
    }

    /**
     * 删除人事任免_法律知识考试_试卷大题对应
     */
    @PreAuthorize("@ss.hasPermi('system:question:remove')")
    @Log(title = "人事任免_法律知识考试_试卷大题对应", businessType = BusinessType.DELETE)
	@DeleteMapping("/{bigQuestionIds}")
    public AjaxResult remove(@PathVariable Long[] bigQuestionIds)
    {
        return toAjax(personnelAppointPaperBigQuestionService.deletePersonnelAppointPaperBigQuestionByBigQuestionIds(bigQuestionIds));
    }
}
