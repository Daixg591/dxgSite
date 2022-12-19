package com.shahenpc.web.controller.represent;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.collections4.Get;
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
import com.shahenpc.system.domain.represent.RepresentActivityRecord;
import com.shahenpc.system.service.represent.IRepresentActivityRecordService;
import com.shahenpc.common.utils.poi.ExcelUtil;
import com.shahenpc.common.core.page.TableDataInfo;

/**
 * 代-活动记录Controller
 * 
 * @author ruoyi
 * @date 2022-07-21
 */
@Api(tags = "代表活动管理的记录")
@RestController
@RequestMapping("/represent/record")
public class RepresentActivityRecordController extends BaseController
{
    @Autowired
    private IRepresentActivityRecordService representActivityRecordService;

    /**
     * 查询代-活动记录列表
     */
    @ApiOperation("列表")
//    @PreAuthorize("@ss.hasPermi('represent:record:list')")
    @GetMapping("/list")
    public TableDataInfo list(RepresentActivityRecord representActivityRecord)
    {
        startPage();

        List<RepresentActivityRecord> list = representActivityRecordService.selectRepresentActivityRecordList(representActivityRecord);
        return getDataTable(list);
    }

    /**
     * 导出代-活动记录列表
     */
    @ApiOperation("导出")
//    @PreAuthorize("@ss.hasPermi('represent:record:export')")
    @Log(title = "代-活动记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, RepresentActivityRecord representActivityRecord)
    {
        List<RepresentActivityRecord> list = representActivityRecordService.selectRepresentActivityRecordList(representActivityRecord);
        ExcelUtil<RepresentActivityRecord> util = new ExcelUtil<RepresentActivityRecord>(RepresentActivityRecord.class);
        util.exportExcel(response, list, "代-活动记录数据");
    }

    /**
     * 获取代-活动记录详细信息
     */
    @ApiOperation("详情")
//    @PreAuthorize("@ss.hasPermi('represent:record:query')")
    @GetMapping(value = "/{recordId}")
    public AjaxResult getInfo(@PathVariable("recordId") Long recordId)
    {
        return AjaxResult.success(representActivityRecordService.selectRepresentActivityRecordByRecordId(recordId));
    }

    /**
     * 新增代-活动记录
     */
    @ApiOperation("新增")
//    @PreAuthorize("@ss.hasPermi('represent:record:add')")
    @Log(title = "代表活动记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody RepresentActivityRecord representActivityRecord)
    {
        representActivityRecord.setCreateBy(getNickName());
        representActivityRecord.setUserId(getUserId());
        representActivityRecordService.insertRepresentActivityRecord(representActivityRecord);

        return AjaxResult.success(representActivityRecord.getRecordId());
    }

    /**
     * 修改代-活动记录
     */
    @ApiOperation("修改")
//    @PreAuthorize("@ss.hasPermi('represent:record:edit')")
    @Log(title = "代-活动记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody RepresentActivityRecord representActivityRecord)
    {
        representActivityRecord.setUpdateBy(getNickName());
        return toAjax(representActivityRecordService.updateRepresentActivityRecord(representActivityRecord));
    }

    @ApiOperation("修改")
//    @PreAuthorize("@ss.hasPermi('represent:record:my:edit')")
    @Log(title = "代-活动记录", businessType = BusinessType.UPDATE)
    @PutMapping("/my/update")
    public AjaxResult myEdit(@RequestBody RepresentActivityRecord representActivityRecord)
    {
        representActivityRecord.setUserId(getUserId());
        representActivityRecord.setUpdateBy(getNickName());
        return representActivityRecordService.updateMyStatus(representActivityRecord);
    }
    /**
     * 删除代-活动记录
     */
    @ApiOperation("删除")
//    @PreAuthorize("@ss.hasPermi('represent:record:remove')")
    @Log(title = "代-活动记录", businessType = BusinessType.DELETE)
	@DeleteMapping("/{recordIds}")
    public AjaxResult remove(@PathVariable Long[] recordIds)
    {
        return toAjax(representActivityRecordService.deleteRepresentActivityRecordByRecordIds(recordIds));
    }
}
