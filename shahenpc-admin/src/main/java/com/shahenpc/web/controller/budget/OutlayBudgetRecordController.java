package com.shahenpc.web.controller.budget;

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
import com.shahenpc.system.domain.budget.OutlayBudgetRecord;
import com.shahenpc.system.service.budget.IOutlayBudgetRecordService;
import com.shahenpc.common.utils.poi.ExcelUtil;
import com.shahenpc.common.core.page.TableDataInfo;

/**
 * 预算记录Controller
 * 
 * @author ruoyi
 * @date 2022-08-29
 */
@RestController
@RequestMapping("/outlay/budget/record")
public class OutlayBudgetRecordController extends BaseController
{
    @Autowired
    private IOutlayBudgetRecordService outlayBudgetRecordService;

    /**
     * 查询预算记录列表
     */
    @PreAuthorize("@ss.hasPermi('budget:record:list')")
    @GetMapping("/list")
    public TableDataInfo list(OutlayBudgetRecord outlayBudgetRecord)
    {
        startPage();
        List<OutlayBudgetRecord> list = outlayBudgetRecordService.selectOutlayBudgetRecordList(outlayBudgetRecord);
        return getDataTable(list);
    }

    /**
     * 导出预算记录列表
     */
    @PreAuthorize("@ss.hasPermi('budget:record:export')")
    @Log(title = "预算记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, OutlayBudgetRecord outlayBudgetRecord)
    {
        List<OutlayBudgetRecord> list = outlayBudgetRecordService.selectOutlayBudgetRecordList(outlayBudgetRecord);
        ExcelUtil<OutlayBudgetRecord> util = new ExcelUtil<OutlayBudgetRecord>(OutlayBudgetRecord.class);
        util.exportExcel(response, list, "预算记录数据");
    }

    /**
     * 获取预算记录详细信息
     */
    @PreAuthorize("@ss.hasPermi('budget:record:query')")
    @GetMapping(value = "/{recordId}")
    public AjaxResult getInfo(@PathVariable("recordId") Long recordId)
    {
        return AjaxResult.success(outlayBudgetRecordService.selectOutlayBudgetRecordByRecordId(recordId));
    }

    /**
     * 新增预算记录
     */
    @PreAuthorize("@ss.hasPermi('budget:record:add')")
    @Log(title = "预算记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody OutlayBudgetRecord outlayBudgetRecord)
    {
        outlayBudgetRecord.setCreateBy(getNickName());
        return toAjax(outlayBudgetRecordService.insertOutlayBudgetRecord(outlayBudgetRecord));
    }

    /**
     * 修改预算记录
     */
    @PreAuthorize("@ss.hasPermi('budget:record:edit')")
    @Log(title = "预算记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody OutlayBudgetRecord outlayBudgetRecord)
    {
        outlayBudgetRecord.setUpdateBy(getNickName());
        return toAjax(outlayBudgetRecordService.updateOutlayBudgetRecord(outlayBudgetRecord));
    }

    /**
     * 删除预算记录
     */
    @PreAuthorize("@ss.hasPermi('budget:record:remove')")
    @Log(title = "预算记录", businessType = BusinessType.DELETE)
	@DeleteMapping("/{recordIds}")
    public AjaxResult remove(@PathVariable Long[] recordIds)
    {
        return toAjax(outlayBudgetRecordService.deleteOutlayBudgetRecordByRecordIds(recordIds));
    }
}
