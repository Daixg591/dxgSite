package com.shahenpc.web.controller.standard;

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
import com.shahenpc.system.domain.standard.StandardCensorRecord;
import com.shahenpc.system.service.standard.IStandardCensorRecordService;
import com.shahenpc.common.utils.poi.ExcelUtil;
import com.shahenpc.common.core.page.TableDataInfo;

/**
 * 审查记录统计Controller
 * 
 * @author ruoyi
 * @date 2022-07-27
 */
@RestController
@RequestMapping("/standard/censor/record")
public class StandardCensorRecordController extends BaseController
{
    @Autowired
    private IStandardCensorRecordService standardCensorRecordService;

    /**
     * 查询审查记录统计列表
     */
    @PreAuthorize("@ss.hasPermi('system:record:list')")
    @GetMapping("/list")
    public TableDataInfo list(StandardCensorRecord standardCensorRecord)
    {
        startPage();
        List<StandardCensorRecord> list = standardCensorRecordService.selectStandardCensorRecordList(standardCensorRecord);
        return getDataTable(list);
    }

    /**
     * 导出审查记录统计列表
     */
    @PreAuthorize("@ss.hasPermi('system:record:export')")
    @Log(title = "审查记录统计", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, StandardCensorRecord standardCensorRecord)
    {
        List<StandardCensorRecord> list = standardCensorRecordService.selectStandardCensorRecordList(standardCensorRecord);
        ExcelUtil<StandardCensorRecord> util = new ExcelUtil<StandardCensorRecord>(StandardCensorRecord.class);
        util.exportExcel(response, list, "审查记录统计数据");
    }

    /**
     * 获取审查记录统计详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:record:query')")
    @GetMapping(value = "/{recordId}")
    public AjaxResult getInfo(@PathVariable("recordId") Long recordId)
    {
        return AjaxResult.success(standardCensorRecordService.selectStandardCensorRecordByRecordId(recordId));
    }

    /**
     * 新增审查记录统计
     */
    @PreAuthorize("@ss.hasPermi('system:record:add')")
    @Log(title = "审查记录统计", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody StandardCensorRecord standardCensorRecord)
    {
        return toAjax(standardCensorRecordService.insertStandardCensorRecord(standardCensorRecord));
    }

    /**
     * 修改审查记录统计
     */
    @PreAuthorize("@ss.hasPermi('system:record:edit')")
    @Log(title = "审查记录统计", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody StandardCensorRecord standardCensorRecord)
    {
        return toAjax(standardCensorRecordService.updateStandardCensorRecord(standardCensorRecord));
    }

    /**
     * 删除审查记录统计
     */
    @PreAuthorize("@ss.hasPermi('system:record:remove')")
    @Log(title = "审查记录统计", businessType = BusinessType.DELETE)
	@DeleteMapping("/{recordIds}")
    public AjaxResult remove(@PathVariable Long[] recordIds)
    {
        return toAjax(standardCensorRecordService.deleteStandardCensorRecordByRecordIds(recordIds));
    }
}
