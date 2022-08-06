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
import com.shahenpc.system.domain.exam.PersonnelAppointBillExamRelation;
import com.shahenpc.system.service.exam.IPersonnelAppointBillExamRelationService;
import com.shahenpc.common.utils.poi.ExcelUtil;
import com.shahenpc.common.core.page.TableDataInfo;

/**
 * 任免记录考试关联Controller
 * 
 * @author ruoyi
 * @date 2022-08-02
 */
@Api(tags = "考试_任免记录绑定考试")
@RestController
@RequestMapping("/system/relation")
public class PersonnelAppointBillExamRelationController extends BaseController
{
    @Autowired
    private IPersonnelAppointBillExamRelationService personnelAppointBillExamRelationService;

    /**
     * 查询任免记录考试关联列表
     */
    @PreAuthorize("@ss.hasPermi('system:relation:list')")
    @GetMapping("/list")
    @ApiOperation("绑定记录列表")
    public TableDataInfo list(PersonnelAppointBillExamRelation personnelAppointBillExamRelation)
    {
        startPage();
        List<PersonnelAppointBillExamRelation> list = personnelAppointBillExamRelationService.selectPersonnelAppointBillExamRelationList(personnelAppointBillExamRelation);
        return getDataTable(list);
    }

    /**
     * 导出任免记录考试关联列表
     */
    @PreAuthorize("@ss.hasPermi('system:relation:export')")
    @Log(title = "任免记录考试关联", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, PersonnelAppointBillExamRelation personnelAppointBillExamRelation)
    {
        List<PersonnelAppointBillExamRelation> list = personnelAppointBillExamRelationService.selectPersonnelAppointBillExamRelationList(personnelAppointBillExamRelation);
        ExcelUtil<PersonnelAppointBillExamRelation> util = new ExcelUtil<PersonnelAppointBillExamRelation>(PersonnelAppointBillExamRelation.class);
        util.exportExcel(response, list, "任免记录考试关联数据");
    }

    /**
     * 获取任免记录考试关联详细信息
     */

    @PreAuthorize("@ss.hasPermi('system:relation:query')")
    @GetMapping(value = "/{regExamId}")
    public AjaxResult getInfo(@PathVariable("regExamId") Long regExamId)
    {
        return AjaxResult.success(personnelAppointBillExamRelationService.selectPersonnelAppointBillExamRelationByRegExamId(regExamId));
    }

    /**
     * 新增任免记录考试关联
     */
    @ApiOperation("新增关联")
    @PreAuthorize("@ss.hasPermi('system:relation:add')")
    @Log(title = "任免记录考试关联", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PersonnelAppointBillExamRelation personnelAppointBillExamRelation)
    {
        return toAjax(personnelAppointBillExamRelationService.insertPersonnelAppointBillExamRelation(personnelAppointBillExamRelation));
    }

    /**
     * 修改任免记录考试关联
     */
    @ApiOperation("修改关联")
    @PreAuthorize("@ss.hasPermi('system:relation:edit')")
    @Log(title = "任免记录考试关联", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PersonnelAppointBillExamRelation personnelAppointBillExamRelation)
    {
        return toAjax(personnelAppointBillExamRelationService.updatePersonnelAppointBillExamRelation(personnelAppointBillExamRelation));
    }

    /**
     * 删除任免记录考试关联
     */
    @ApiOperation("删除关联")
    @PreAuthorize("@ss.hasPermi('system:relation:remove')")
    @Log(title = "任免记录考试关联", businessType = BusinessType.DELETE)
	@DeleteMapping("/{regExamIds}")
    public AjaxResult remove(@PathVariable Long[] regExamIds)
    {
        return toAjax(personnelAppointBillExamRelationService.deletePersonnelAppointBillExamRelationByRegExamIds(regExamIds));
    }
}
