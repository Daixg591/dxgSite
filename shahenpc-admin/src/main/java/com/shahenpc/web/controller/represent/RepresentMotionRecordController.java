package com.shahenpc.web.controller.represent;

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
import com.shahenpc.system.domain.represent.RepresentMotionRecord;
import com.shahenpc.system.service.represent.IRepresentMotionRecordService;
import com.shahenpc.common.utils.poi.ExcelUtil;
import com.shahenpc.common.core.page.TableDataInfo;

/**
 * 建议议案记录Controller
 * 
 * @author ruoyi
 * @date 2022-07-26
 */
@RestController
@RequestMapping("/system/record")
public class RepresentMotionRecordController extends BaseController
{
    @Autowired
    private IRepresentMotionRecordService representMotionRecordService;

    /**
     * 查询建议议案记录列表
     */
    @PreAuthorize("@ss.hasPermi('system:record:list')")
    @GetMapping("/list")
    public TableDataInfo list(RepresentMotionRecord representMotionRecord)
    {
        startPage();
        List<RepresentMotionRecord> list = representMotionRecordService.selectRepresentMotionRecordList(representMotionRecord);
        return getDataTable(list);
    }

    /**
     * 导出建议议案记录列表
     */
    @PreAuthorize("@ss.hasPermi('system:record:export')")
    @Log(title = "建议议案记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, RepresentMotionRecord representMotionRecord)
    {
        List<RepresentMotionRecord> list = representMotionRecordService.selectRepresentMotionRecordList(representMotionRecord);
        ExcelUtil<RepresentMotionRecord> util = new ExcelUtil<RepresentMotionRecord>(RepresentMotionRecord.class);
        util.exportExcel(response, list, "建议议案记录数据");
    }

    /**
     * 获取建议议案记录详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:record:query')")
    @GetMapping(value = "/{recordId}")
    public AjaxResult getInfo(@PathVariable("recordId") Long recordId)
    {
        return AjaxResult.success(representMotionRecordService.selectRepresentMotionRecordByRecordId(recordId));
    }

    /**
     * 新增建议议案记录
     */
    @PreAuthorize("@ss.hasPermi('system:record:add')")
    @Log(title = "建议议案记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody RepresentMotionRecord representMotionRecord)
    {
        return toAjax(representMotionRecordService.insertRepresentMotionRecord(representMotionRecord));
    }

    /**
     * 修改建议议案记录
     */
    @PreAuthorize("@ss.hasPermi('system:record:edit')")
    @Log(title = "建议议案记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody RepresentMotionRecord representMotionRecord)
    {
        return toAjax(representMotionRecordService.updateRepresentMotionRecord(representMotionRecord));
    }

    /**
     * 删除建议议案记录
     */
    @PreAuthorize("@ss.hasPermi('system:record:remove')")
    @Log(title = "建议议案记录", businessType = BusinessType.DELETE)
	@DeleteMapping("/{recordIds}")
    public AjaxResult remove(@PathVariable Long[] recordIds)
    {
        return toAjax(representMotionRecordService.deleteRepresentMotionRecordByRecordIds(recordIds));
    }
}
