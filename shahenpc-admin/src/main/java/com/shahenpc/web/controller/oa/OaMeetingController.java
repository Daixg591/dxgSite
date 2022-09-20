package com.shahenpc.web.controller.oa;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.shahenpc.system.domain.oa.dto.MeetingAddDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.shahenpc.common.annotation.Log;
import com.shahenpc.common.core.controller.BaseController;
import com.shahenpc.common.core.domain.AjaxResult;
import com.shahenpc.common.enums.BusinessType;
import com.shahenpc.system.domain.oa.OaMeeting;
import com.shahenpc.system.service.oa.IOaMeetingService;
import com.shahenpc.common.utils.poi.ExcelUtil;
import com.shahenpc.common.core.page.TableDataInfo;

/**
 * 人大办公-会议管理Controller
 * 
 * @author ruoyi
 * @date 2022-07-19
 */
@Api(tags = "会议管理")
@RestController
@RequestMapping("/oa/meeting")
public class OaMeetingController extends BaseController
{
    @Autowired
    private IOaMeetingService oaMeetingService;

    /**
     * 查询人大办公-会议管理列表
     */
    @ApiOperation("列表")
    @PreAuthorize("@ss.hasPermi('oa:meeting:list')")
    @GetMapping("/list")
    public TableDataInfo list(OaMeeting oaMeeting)
    {
        startPage();
        List<OaMeeting> list = oaMeetingService.selectOaMeetingList(oaMeeting);
        return getDataTable(list);
    }

    /**
     * 导出人大办公-会议管理列表
     */
    @ApiOperation("导出")
    @PreAuthorize("@ss.hasPermi('oa:meeting:export')")
    @Log(title = "人大办公-会议管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, OaMeeting oaMeeting)
    {
        List<OaMeeting> list = oaMeetingService.selectOaMeetingList(oaMeeting);
        ExcelUtil<OaMeeting> util = new ExcelUtil<OaMeeting>(OaMeeting.class);
        util.exportExcel(response, list, "人大办公-会议管理数据");
    }

    /**
     * 获取人大办公-会议管理详细信息
     */
    @ApiOperation("详情")
    @PreAuthorize("@ss.hasPermi('oa:meeting:query')")
    @GetMapping(value = "/{meetingId}")
    public AjaxResult getInfo(@PathVariable("meetingId") Long meetingId)
    {
        return AjaxResult.success(oaMeetingService.newDetail(meetingId));
    }

    /**
     * 新增人大办公-会议管理
     */
    @ApiOperation("新增")
    @PreAuthorize("@ss.hasPermi('oa:meeting:add')")
    @Log(title = "人大办公-会议管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody MeetingAddDto oaMeeting)
    {
        oaMeeting.setCreateBy(getNickName());
        return toAjax(oaMeetingService.newAdd(oaMeeting));
    }

    /**
     * 修改人大办公-会议管理
     */
    @ApiOperation("修改")
    @PreAuthorize("@ss.hasPermi('oa:meeting:edit')")
    @Log(title = "人大办公-会议管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody MeetingAddDto oaMeeting)
    {
        oaMeeting.setCreateBy(getNickName());
        return toAjax(oaMeetingService.newUpdate(oaMeeting));
    }

    /**
     * 删除人大办公-会议管理
     */
    @ApiOperation("删除")
    @PreAuthorize("@ss.hasPermi('oa:meeting:remove')")
    @Log(title = "人大办公-会议管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{meetingIds}")
    public AjaxResult remove(@PathVariable Long meetingIds)
    {
        return toAjax(oaMeetingService.deleteOaMeetingByMeetingIds(meetingIds));
    }

    /**
     *
     * @param
     * @return
     */
    @ApiOperation("饼图")
    @GetMapping("/cake")
    public AjaxResult getCake()
    {
        return AjaxResult.success(oaMeetingService.MeetingCake());
    }

    /**
     *
     * @param
     * @return
     */
    @ApiOperation("柱状每月数量")
    @GetMapping("/columnar/count")
    public AjaxResult monthCount()
    {
        return AjaxResult.success(oaMeetingService.columnarCount());
    }
}
