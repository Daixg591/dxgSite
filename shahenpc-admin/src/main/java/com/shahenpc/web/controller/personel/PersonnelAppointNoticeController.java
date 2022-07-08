package com.shahenpc.web.controller.personel;

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
import com.shahenpc.system.domain.personel.PersonnelAppointNotice;
import com.shahenpc.system.service.personel.IPersonnelAppointNoticeService;
import com.shahenpc.common.utils.poi.ExcelUtil;
import com.shahenpc.common.core.page.TableDataInfo;

/**
 * 人事任免_任免通知Controller
 * 
 * @author ruoyi
 * @date 2022-07-08
 */
@RestController
@Api(tags = "人事任免_任免通知 Done √")
@RequestMapping("/system/inform")
public class PersonnelAppointNoticeController extends BaseController
{
    @Autowired
    private IPersonnelAppointNoticeService personnelAppointNoticeService;

    /**
     * 查询人事任免_任免通知列表
     */
    @ApiOperation("查询-任免通知")
    @PreAuthorize("@ss.hasPermi('system:inform:list')")
    @GetMapping("/list")
    public TableDataInfo list(PersonnelAppointNotice personnelAppointNotice)
    {
        startPage();
        List<PersonnelAppointNotice> list = personnelAppointNoticeService.selectPersonnelAppointNoticeList(personnelAppointNotice);
        return getDataTable(list);
    }

    /**
     * 导出人事任免_任免通知列表
     */
    @PreAuthorize("@ss.hasPermi('system:inform:export')")
    @Log(title = "人事任免_任免通知", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, PersonnelAppointNotice personnelAppointNotice)
    {
        List<PersonnelAppointNotice> list = personnelAppointNoticeService.selectPersonnelAppointNoticeList(personnelAppointNotice);
        ExcelUtil<PersonnelAppointNotice> util = new ExcelUtil<PersonnelAppointNotice>(PersonnelAppointNotice.class);
        util.exportExcel(response, list, "人事任免_任免通知数据");
    }

    /**
     * 获取人事任免_任免通知详细信息
     */
    @ApiOperation("详情-任免通知")
    @PreAuthorize("@ss.hasPermi('system:inform:query')")
    @GetMapping(value = "/{noticeId}")
    public AjaxResult getInfo(@PathVariable("noticeId") Long noticeId)
    {
        return AjaxResult.success(personnelAppointNoticeService.selectPersonnelAppointNoticeByNoticeId(noticeId));
    }

    /**
     * 新增人事任免_任免通知
     */
    @ApiOperation("新增-任免通知")
    @PreAuthorize("@ss.hasPermi('system:inform:add')")
    @Log(title = "人事任免_任免通知", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PersonnelAppointNotice personnelAppointNotice)
    {
        return toAjax(personnelAppointNoticeService.insertPersonnelAppointNotice(personnelAppointNotice));
    }

    /**
     * 修改人事任免_任免通知
     */
    @PreAuthorize("@ss.hasPermi('system:inform:edit')")
    @ApiOperation("更新-任免通知")
    @Log(title = "人事任免_任免通知", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PersonnelAppointNotice personnelAppointNotice)
    {
        return toAjax(personnelAppointNoticeService.updatePersonnelAppointNotice(personnelAppointNotice));
    }

    /**
     * 删除人事任免_任免通知
     */
    @ApiOperation("删除-任免通知")
    @PreAuthorize("@ss.hasPermi('system:inform:remove')")
    @Log(title = "人事任免_任免通知", businessType = BusinessType.DELETE)
	@DeleteMapping("/{noticeIds}")
    public AjaxResult remove(@PathVariable Long[] noticeIds)
    {
        return toAjax(personnelAppointNoticeService.deletePersonnelAppointNoticeByNoticeIds(noticeIds));
    }
}
