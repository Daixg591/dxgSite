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
import com.shahenpc.system.domain.exam.PersonnelAppointPaperQuestionItem;
import com.shahenpc.system.service.exam.IPersonnelAppointPaperQuestionItemService;
import com.shahenpc.common.utils.poi.ExcelUtil;
import com.shahenpc.common.core.page.TableDataInfo;

/**
 * 人事任免_法律知识考试_小题集合Controller
 * 
 * @author ruoyi
 * @date 2022-07-27
 */
@RestController
@RequestMapping("/exam/quitem")
public class PersonnelAppointPaperQuestionItemController extends BaseController
{
    @Autowired
    private IPersonnelAppointPaperQuestionItemService personnelAppointPaperQuestionItemService;

    /**
     * 查询人事任免_法律知识考试_小题集合列表
     */
    @PreAuthorize("@ss.hasPermi('system:item:list')")
    @GetMapping("/list")
    public TableDataInfo list(PersonnelAppointPaperQuestionItem personnelAppointPaperQuestionItem)
    {
        startPage();
        List<PersonnelAppointPaperQuestionItem> list = personnelAppointPaperQuestionItemService.selectPersonnelAppointPaperQuestionItemList(personnelAppointPaperQuestionItem);
        return getDataTable(list);
    }

    /**
     * 导出人事任免_法律知识考试_小题集合列表
     */
    @PreAuthorize("@ss.hasPermi('system:item:export')")
    @Log(title = "人事任免_法律知识考试_小题集合", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, PersonnelAppointPaperQuestionItem personnelAppointPaperQuestionItem)
    {
        List<PersonnelAppointPaperQuestionItem> list = personnelAppointPaperQuestionItemService.selectPersonnelAppointPaperQuestionItemList(personnelAppointPaperQuestionItem);
        ExcelUtil<PersonnelAppointPaperQuestionItem> util = new ExcelUtil<PersonnelAppointPaperQuestionItem>(PersonnelAppointPaperQuestionItem.class);
        util.exportExcel(response, list, "人事任免_法律知识考试_小题集合数据");
    }

    /**
     * 获取人事任免_法律知识考试_小题集合详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:item:query')")
    @GetMapping(value = "/{quItemId}")
    public AjaxResult getInfo(@PathVariable("quItemId") Long quItemId)
    {
        return AjaxResult.success(personnelAppointPaperQuestionItemService.selectPersonnelAppointPaperQuestionItemByQuItemId(quItemId));
    }

    /**
     * 新增人事任免_法律知识考试_小题集合
     */
    @PreAuthorize("@ss.hasPermi('system:item:add')")
    @Log(title = "人事任免_法律知识考试_小题集合", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PersonnelAppointPaperQuestionItem personnelAppointPaperQuestionItem)
    {
        return toAjax(personnelAppointPaperQuestionItemService.insertPersonnelAppointPaperQuestionItem(personnelAppointPaperQuestionItem));
    }

    /**
     * 修改人事任免_法律知识考试_小题集合
     */
    @PreAuthorize("@ss.hasPermi('system:item:edit')")
    @Log(title = "人事任免_法律知识考试_小题集合", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PersonnelAppointPaperQuestionItem personnelAppointPaperQuestionItem)
    {
        return toAjax(personnelAppointPaperQuestionItemService.updatePersonnelAppointPaperQuestionItem(personnelAppointPaperQuestionItem));
    }

    /**
     * 删除人事任免_法律知识考试_小题集合
     */
    @PreAuthorize("@ss.hasPermi('system:item:remove')")
    @Log(title = "人事任免_法律知识考试_小题集合", businessType = BusinessType.DELETE)
	@DeleteMapping("/{quItemIds}")
    public AjaxResult remove(@PathVariable Long[] quItemIds)
    {
        return toAjax(personnelAppointPaperQuestionItemService.deletePersonnelAppointPaperQuestionItemByQuItemIds(quItemIds));
    }
}
