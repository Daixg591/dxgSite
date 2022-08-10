package com.shahenpc.web.controller.oa;

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
import com.shahenpc.system.domain.oa.OaMeetingRecord;
import com.shahenpc.system.service.oa.IOaMeetingRecordService;
import com.shahenpc.common.utils.poi.ExcelUtil;
import com.shahenpc.common.core.page.TableDataInfo;

/**
 * 会议记录Controller
 * 
 * @author ruoyi
 * @date 2022-07-19
 */
@Api(tags = "会议记录表")
@RestController
@RequestMapping("/oa/record")
public class OaMeetingRecordController extends BaseController
{
    @Autowired
    private IOaMeetingRecordService oaMeetingRecordService;

    /**
     * 查询会议记录列表
     */
    @ApiOperation("列表")
    @PreAuthorize("@ss.hasPermi('oa:record:list')")
    @GetMapping("/list")
    public TableDataInfo list(OaMeetingRecord oaMeetingRecord)
    {
        startPage();
        List<OaMeetingRecord> list = oaMeetingRecordService.selectOaMeetingRecordList(oaMeetingRecord);
        return getDataTable(list);
    }

    /**
     * 导出会议记录列表
     */
    @ApiOperation("导出")
    @PreAuthorize("@ss.hasPermi('oa:record:export')")
    @Log(title = "会议记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, OaMeetingRecord oaMeetingRecord)
    {
        List<OaMeetingRecord> list = oaMeetingRecordService.selectOaMeetingRecordList(oaMeetingRecord);
        ExcelUtil<OaMeetingRecord> util = new ExcelUtil<OaMeetingRecord>(OaMeetingRecord.class);
        util.exportExcel(response, list, "会议记录数据");
    }

    /**
     * 获取会议记录详细信息
     */
    @ApiOperation("详情")
    @PreAuthorize("@ss.hasPermi('oa:record:query')")
    @GetMapping(value = "/{recordId}")
    public AjaxResult getInfo(@PathVariable("recordId") Long recordId)
    {
        return AjaxResult.success(oaMeetingRecordService.selectOaMeetingRecordByRecordId(recordId));
    }

    /**
     * 新增会议记录
     */
    @ApiOperation("新增")
    @PreAuthorize("@ss.hasPermi('oa:record:add')")
    @Log(title = "会议记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody OaMeetingRecord oaMeetingRecord)
    {
        oaMeetingRecord.setUserId(getUserId());
        oaMeetingRecord.setCreateBy(getNickName());
        return oaMeetingRecordService.adminAdd(oaMeetingRecord);
    }

    /**
     * 修改会议记录
     */
    @ApiOperation("修改")
    @PreAuthorize("@ss.hasPermi('oa:record:edit')")
    @Log(title = "会议记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody OaMeetingRecord oaMeetingRecord)
    {
        return toAjax(oaMeetingRecordService.updateOaMeetingRecord(oaMeetingRecord));
    }

    /**
     * 删除会议记录
     */
    @ApiOperation("删除")
    @PreAuthorize("@ss.hasPermi('oa:record:remove')")
    @Log(title = "会议记录", businessType = BusinessType.DELETE)
	@DeleteMapping("/{recordIds}")
    public AjaxResult remove(@PathVariable Long[] recordIds)
    {
        return toAjax(oaMeetingRecordService.deleteOaMeetingRecordByRecordIds(recordIds));
    }
}
