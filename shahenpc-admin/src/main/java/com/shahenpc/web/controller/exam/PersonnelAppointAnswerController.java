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
import com.shahenpc.system.domain.exam.PersonnelAppointAnswer;
import com.shahenpc.system.service.exam.IPersonnelAppointAnswerService;
import com.shahenpc.common.utils.poi.ExcelUtil;
import com.shahenpc.common.core.page.TableDataInfo;

/**
 * 人事任免_法律知识考试_答案管理Controller
 * 
 * @author ruoyi
 * @date 2022-07-27
 */
@RestController
@RequestMapping("/exam/answer")
public class PersonnelAppointAnswerController extends BaseController
{
    @Autowired
    private IPersonnelAppointAnswerService personnelAppointAnswerService;

    /**
     * 查询人事任免_法律知识考试_答案管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:answer:list')")
    @GetMapping("/list")
    public TableDataInfo list(PersonnelAppointAnswer personnelAppointAnswer)
    {
        startPage();
        List<PersonnelAppointAnswer> list = personnelAppointAnswerService.selectPersonnelAppointAnswerList(personnelAppointAnswer);
        return getDataTable(list);
    }

    /**
     * 导出人事任免_法律知识考试_答案管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:answer:export')")
    @Log(title = "人事任免_法律知识考试_答案管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, PersonnelAppointAnswer personnelAppointAnswer)
    {
        List<PersonnelAppointAnswer> list = personnelAppointAnswerService.selectPersonnelAppointAnswerList(personnelAppointAnswer);
        ExcelUtil<PersonnelAppointAnswer> util = new ExcelUtil<PersonnelAppointAnswer>(PersonnelAppointAnswer.class);
        util.exportExcel(response, list, "人事任免_法律知识考试_答案管理数据");
    }

    /**
     * 获取人事任免_法律知识考试_答案管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:answer:query')")
    @GetMapping(value = "/{answerId}")
    public AjaxResult getInfo(@PathVariable("answerId") Long answerId)
    {
        return AjaxResult.success(personnelAppointAnswerService.selectPersonnelAppointAnswerByAnswerId(answerId));
    }

    /**
     * 新增人事任免_法律知识考试_答案管理
     */
    @PreAuthorize("@ss.hasPermi('system:answer:add')")
    @Log(title = "人事任免_法律知识考试_答案管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PersonnelAppointAnswer personnelAppointAnswer)
    {
        return toAjax(personnelAppointAnswerService.insertPersonnelAppointAnswer(personnelAppointAnswer));
    }

    /**
     * 修改人事任免_法律知识考试_答案管理
     */
    @PreAuthorize("@ss.hasPermi('system:answer:edit')")
    @Log(title = "人事任免_法律知识考试_答案管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PersonnelAppointAnswer personnelAppointAnswer)
    {
        return toAjax(personnelAppointAnswerService.updatePersonnelAppointAnswer(personnelAppointAnswer));
    }

    /**
     * 删除人事任免_法律知识考试_答案管理
     */
    @PreAuthorize("@ss.hasPermi('system:answer:remove')")
    @Log(title = "人事任免_法律知识考试_答案管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{answerIds}")
    public AjaxResult remove(@PathVariable Long[] answerIds)
    {
        return toAjax(personnelAppointAnswerService.deletePersonnelAppointAnswerByAnswerIds(answerIds));
    }
}
