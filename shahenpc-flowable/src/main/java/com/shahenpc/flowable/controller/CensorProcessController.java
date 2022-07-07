package com.shahenpc.flowable.controller;

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
import com.shahenpc.system.domain.censor.CensorProcess;
import com.shahenpc.system.service.censor.ICensorProcessService;
import com.shahenpc.common.utils.poi.ExcelUtil;
import com.shahenpc.common.core.page.TableDataInfo;

/**
 * 审查流程Controller
 * 
 * @author ruoyi
 * @date 2022-07-05
 */
@RestController
@RequestMapping("/system/process")
public class CensorProcessController extends BaseController
{
    @Autowired
    private ICensorProcessService censorProcessService;

    /**
     * 查询审查流程列表
     */
    @PreAuthorize("@ss.hasPermi('system:process:list')")
    @GetMapping("/list")
    public TableDataInfo list(CensorProcess censorProcess)
    {
        startPage();
        List<CensorProcess> list = censorProcessService.selectCensorProcessList(censorProcess);
        return getDataTable(list);
    }

    /**
     * 导出审查流程列表
     */
    @PreAuthorize("@ss.hasPermi('system:process:export')")
    @Log(title = "审查流程", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, CensorProcess censorProcess)
    {
        List<CensorProcess> list = censorProcessService.selectCensorProcessList(censorProcess);
        ExcelUtil<CensorProcess> util = new ExcelUtil<CensorProcess>(CensorProcess.class);
        util.exportExcel(response, list, "审查流程数据");
    }

    /**
     * 获取审查流程详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:process:query')")
    @GetMapping(value = "/{processId}")
    public AjaxResult getInfo(@PathVariable("processId") Long processId)
    {
        return AjaxResult.success(censorProcessService.selectCensorProcessByProcessId(processId));
    }

    /**
     * 新增审查流程
     */
    @PreAuthorize("@ss.hasPermi('system:process:add')")
    @Log(title = "审查流程", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CensorProcess censorProcess)
    {
        return toAjax(censorProcessService.insertCensorProcess(censorProcess));
    }

    /**
     * 修改审查流程
     */
    @PreAuthorize("@ss.hasPermi('system:process:edit')")
    @Log(title = "审查流程", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CensorProcess censorProcess)
    {
        return toAjax(censorProcessService.updateCensorProcess(censorProcess));
    }

    /**
     * 删除审查流程
     */
    @PreAuthorize("@ss.hasPermi('system:process:remove')")
    @Log(title = "审查流程", businessType = BusinessType.DELETE)
	@DeleteMapping("/{processIds}")
    public AjaxResult remove(@PathVariable Long[] processIds)
    {
        return toAjax(censorProcessService.deleteCensorProcessByProcessIds(processIds));
    }
}
