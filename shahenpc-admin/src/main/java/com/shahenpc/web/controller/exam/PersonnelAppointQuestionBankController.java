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
import com.shahenpc.system.domain.exam.PersonnelAppointQuestionBank;
import com.shahenpc.system.service.exam.IPersonnelAppointQuestionBankService;
import com.shahenpc.common.utils.poi.ExcelUtil;
import com.shahenpc.common.core.page.TableDataInfo;

/**
 * 人事任免_法律知识考试_题库管理Controller
 * 
 * @author ruoyi
 * @date 2022-07-27
 */
@RestController
@RequestMapping("/exam/bank")
public class PersonnelAppointQuestionBankController extends BaseController
{
    @Autowired
    private IPersonnelAppointQuestionBankService personnelAppointQuestionBankService;

    /**
     * 查询人事任免_法律知识考试_题库管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:bank:list')")
    @GetMapping("/list")
    public TableDataInfo list(PersonnelAppointQuestionBank personnelAppointQuestionBank)
    {
        startPage();
        List<PersonnelAppointQuestionBank> list = personnelAppointQuestionBankService.selectPersonnelAppointQuestionBankList(personnelAppointQuestionBank);
        return getDataTable(list);
    }

    /**
     * 导出人事任免_法律知识考试_题库管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:bank:export')")
    @Log(title = "人事任免_法律知识考试_题库管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, PersonnelAppointQuestionBank personnelAppointQuestionBank)
    {
        List<PersonnelAppointQuestionBank> list = personnelAppointQuestionBankService.selectPersonnelAppointQuestionBankList(personnelAppointQuestionBank);
        ExcelUtil<PersonnelAppointQuestionBank> util = new ExcelUtil<PersonnelAppointQuestionBank>(PersonnelAppointQuestionBank.class);
        util.exportExcel(response, list, "人事任免_法律知识考试_题库管理数据");
    }

    /**
     * 获取人事任免_法律知识考试_题库管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:bank:query')")
    @GetMapping(value = "/{questionBankId}")
    public AjaxResult getInfo(@PathVariable("questionBankId") Long questionBankId)
    {
        return AjaxResult.success(personnelAppointQuestionBankService.selectPersonnelAppointQuestionBankByQuestionBankId(questionBankId));
    }

    /**
     * 新增人事任免_法律知识考试_题库管理
     */
    @PreAuthorize("@ss.hasPermi('system:bank:add')")
    @Log(title = "人事任免_法律知识考试_题库管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PersonnelAppointQuestionBank personnelAppointQuestionBank)
    {
        return toAjax(personnelAppointQuestionBankService.insertPersonnelAppointQuestionBank(personnelAppointQuestionBank));
    }

    /**
     * 修改人事任免_法律知识考试_题库管理
     */
    @PreAuthorize("@ss.hasPermi('system:bank:edit')")
    @Log(title = "人事任免_法律知识考试_题库管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PersonnelAppointQuestionBank personnelAppointQuestionBank)
    {
        return toAjax(personnelAppointQuestionBankService.updatePersonnelAppointQuestionBank(personnelAppointQuestionBank));
    }

    /**
     * 删除人事任免_法律知识考试_题库管理
     */
    @PreAuthorize("@ss.hasPermi('system:bank:remove')")
    @Log(title = "人事任免_法律知识考试_题库管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{questionBankIds}")
    public AjaxResult remove(@PathVariable Long[] questionBankIds)
    {
        return toAjax(personnelAppointQuestionBankService.deletePersonnelAppointQuestionBankByQuestionBankIds(questionBankIds));
    }
}
