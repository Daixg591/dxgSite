package com.shahenpc.web.controller.personel;

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
import com.shahenpc.system.domain.personel.PersonnelAppointSpeak;
import com.shahenpc.system.service.personel.IPersonnelAppointSpeakService;
import com.shahenpc.common.utils.poi.ExcelUtil;
import com.shahenpc.common.core.page.TableDataInfo;

/**
 * 人事任免_拟任职发言Controller
 * 
 * @author ruoyi
 * @date 2022-07-04
 */
@RestController
@RequestMapping("/system/speak")
public class PersonnelAppointSpeakController extends BaseController
{
    @Autowired
    private IPersonnelAppointSpeakService personnelAppointSpeakService;

    /**
     * 查询人事任免_拟任职发言列表
     */
    @PreAuthorize("@ss.hasPermi('system:speak:list')")
    @GetMapping("/list")
    public TableDataInfo list(PersonnelAppointSpeak personnelAppointSpeak)
    {
        startPage();
        List<PersonnelAppointSpeak> list = personnelAppointSpeakService.selectPersonnelAppointSpeakList(personnelAppointSpeak);
        return getDataTable(list);
    }

    /**
     * 导出人事任免_拟任职发言列表
     */
    @PreAuthorize("@ss.hasPermi('system:speak:export')")
    @Log(title = "人事任免_拟任职发言", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, PersonnelAppointSpeak personnelAppointSpeak)
    {
        List<PersonnelAppointSpeak> list = personnelAppointSpeakService.selectPersonnelAppointSpeakList(personnelAppointSpeak);
        ExcelUtil<PersonnelAppointSpeak> util = new ExcelUtil<PersonnelAppointSpeak>(PersonnelAppointSpeak.class);
        util.exportExcel(response, list, "人事任免_拟任职发言数据");
    }

    /**
     * 获取人事任免_拟任职发言详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:speak:query')")
    @GetMapping(value = "/{speakId}")
    public AjaxResult getInfo(@PathVariable("speakId") Long speakId)
    {
        return AjaxResult.success(personnelAppointSpeakService.selectPersonnelAppointSpeakBySpeakId(speakId));
    }

    /**
     * 新增人事任免_拟任职发言
     */
    @PreAuthorize("@ss.hasPermi('system:speak:add')")
    @Log(title = "人事任免_拟任职发言", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PersonnelAppointSpeak personnelAppointSpeak)
    {
        return toAjax(personnelAppointSpeakService.insertPersonnelAppointSpeak(personnelAppointSpeak));
    }

    /**
     * 修改人事任免_拟任职发言
     */
    @PreAuthorize("@ss.hasPermi('system:speak:edit')")
    @Log(title = "人事任免_拟任职发言", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PersonnelAppointSpeak personnelAppointSpeak)
    {
        return toAjax(personnelAppointSpeakService.updatePersonnelAppointSpeak(personnelAppointSpeak));
    }

    /**
     * 删除人事任免_拟任职发言
     */
    @PreAuthorize("@ss.hasPermi('system:speak:remove')")
    @Log(title = "人事任免_拟任职发言", businessType = BusinessType.DELETE)
	@DeleteMapping("/{speakIds}")
    public AjaxResult remove(@PathVariable Long[] speakIds)
    {
        return toAjax(personnelAppointSpeakService.deletePersonnelAppointSpeakBySpeakIds(speakIds));
    }
}
