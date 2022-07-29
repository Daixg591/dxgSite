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
import com.shahenpc.system.domain.exam.PersonnelAppointQuestion;
import com.shahenpc.system.service.exam.IPersonnelAppointQuestionService;
import com.shahenpc.common.utils.poi.ExcelUtil;
import com.shahenpc.common.core.page.TableDataInfo;

/**
 * 人事任免_法律知识考试_试题管理Controller
 * 
 * @author ruoyi
 * @date 2022-07-27
 */
@RestController
@RequestMapping("/exam/smallqu")
public class PersonnelAppointQuestionController extends BaseController
{
    @Autowired
    private IPersonnelAppointQuestionService personnelAppointQuestionService;

    /**
     * 查询人事任免_法律知识考试_试题管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:question:list')")
    @GetMapping("/list")
    public TableDataInfo list(PersonnelAppointQuestion personnelAppointQuestion)
    {
        startPage();
        List<PersonnelAppointQuestion> list = personnelAppointQuestionService.selectPersonnelAppointQuestionList(personnelAppointQuestion);
        return getDataTable(list);
    }

    /**
     * 导出人事任免_法律知识考试_试题管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:question:export')")
    @Log(title = "人事任免_法律知识考试_试题管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, PersonnelAppointQuestion personnelAppointQuestion)
    {
        List<PersonnelAppointQuestion> list = personnelAppointQuestionService.selectPersonnelAppointQuestionList(personnelAppointQuestion);
        ExcelUtil<PersonnelAppointQuestion> util = new ExcelUtil<PersonnelAppointQuestion>(PersonnelAppointQuestion.class);
        util.exportExcel(response, list, "人事任免_法律知识考试_试题管理数据");
    }

    /**
     * 获取人事任免_法律知识考试_试题管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:question:query')")
    @GetMapping(value = "/{quId}")
    public AjaxResult getInfo(@PathVariable("quId") Long quId)
    {
        return AjaxResult.success(personnelAppointQuestionService.selectPersonnelAppointQuestionByQuId(quId));
    }

    /**
     * 新增人事任免_法律知识考试_试题管理
     */
    @PreAuthorize("@ss.hasPermi('system:question:add')")
    @Log(title = "人事任免_法律知识考试_试题管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PersonnelAppointQuestion personnelAppointQuestion)
    {
        return toAjax(personnelAppointQuestionService.insertPersonnelAppointQuestion(personnelAppointQuestion));
    }

    /**
     * 修改人事任免_法律知识考试_试题管理
     */
    @PreAuthorize("@ss.hasPermi('system:question:edit')")
    @Log(title = "人事任免_法律知识考试_试题管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PersonnelAppointQuestion personnelAppointQuestion)
    {
        return toAjax(personnelAppointQuestionService.updatePersonnelAppointQuestion(personnelAppointQuestion));
    }

    /**
     * 删除人事任免_法律知识考试_试题管理
     */
    @PreAuthorize("@ss.hasPermi('system:question:remove')")
    @Log(title = "人事任免_法律知识考试_试题管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{quIds}")
    public AjaxResult remove(@PathVariable Long[] quIds)
    {
        return toAjax(personnelAppointQuestionService.deletePersonnelAppointQuestionByQuIds(quIds));
    }
}
