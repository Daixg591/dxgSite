package com.shahenpc.web.controller.represent;

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
import com.shahenpc.system.domain.represent.RepresentNpcOverview;
import com.shahenpc.system.service.represent.IRepresentNpcOverviewService;
import com.shahenpc.common.utils.poi.ExcelUtil;
import com.shahenpc.common.core.page.TableDataInfo;

/**
 * 人大概览 只存一条信息Controller
 * 
 * @author ruoyi
 * @date 2022-07-21
 */
@Api(tags = "人大概览管理")
@RestController
@RequestMapping("/represent/overview")
public class RepresentNpcOverviewController extends BaseController
{
    @Autowired
    private IRepresentNpcOverviewService representNpcOverviewService;

    /**
     * 查询人大概览 只存一条信息列表
     */
    @ApiOperation("列表")
    @PreAuthorize("@ss.hasPermi('represent:overview:list')")
    @GetMapping("/list")
    public TableDataInfo list(RepresentNpcOverview representNpcOverview)
    {
        startPage();
        List<RepresentNpcOverview> list = representNpcOverviewService.selectRepresentNpcOverviewList(representNpcOverview);
        return getDataTable(list);
    }

    /**
     * 导出人大概览 只存一条信息列表
     */
    @ApiOperation("导出")
    @PreAuthorize("@ss.hasPermi('represent:overview:export')")
    @Log(title = "人大概览 只存一条信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, RepresentNpcOverview representNpcOverview)
    {
        List<RepresentNpcOverview> list = representNpcOverviewService.selectRepresentNpcOverviewList(representNpcOverview);
        ExcelUtil<RepresentNpcOverview> util = new ExcelUtil<RepresentNpcOverview>(RepresentNpcOverview.class);
        util.exportExcel(response, list, "人大概览 只存一条信息数据");
    }

    /**
     * 获取人大概览 只存一条信息详细信息
     */
    @ApiOperation("详情")
    @PreAuthorize("@ss.hasPermi('represent:overview:query')")
    @GetMapping(value = "/{npcId}")
    public AjaxResult getInfo(@PathVariable("npcId") Long npcId)
    {
        return AjaxResult.success(representNpcOverviewService.selectRepresentNpcOverviewByNpcId(npcId));
    }

    /**
     * 新增人大概览 只存一条信息
     */
    @ApiOperation("新增")
    @PreAuthorize("@ss.hasPermi('represent:overview:add')")
    @Log(title = "人大概览 只存一条信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody RepresentNpcOverview representNpcOverview)
    {
        return toAjax(representNpcOverviewService.insertRepresentNpcOverview(representNpcOverview));
    }

    /**
     * 修改人大概览 只存一条信息
     */
    @ApiOperation("修改")
    @PreAuthorize("@ss.hasPermi('represent:overview:edit')")
    @Log(title = "人大概览 只存一条信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody RepresentNpcOverview representNpcOverview)
    {
        return toAjax(representNpcOverviewService.updateRepresentNpcOverview(representNpcOverview));
    }

    /**
     * 删除人大概览 只存一条信息
     */
    @ApiOperation("删除")
    @PreAuthorize("@ss.hasPermi('represent:overview:remove')")
    @Log(title = "人大概览 只存一条信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{npcIds}")
    public AjaxResult remove(@PathVariable Long[] npcIds)
    {
        return toAjax(representNpcOverviewService.deleteRepresentNpcOverviewByNpcIds(npcIds));
    }

    @ApiOperation("默认一条概览")
    @PreAuthorize("@ss.hasPermi('represent:overview:overview')")
    @GetMapping("/overview")
    public AjaxResult getOverview()
    {
        return AjaxResult.success(representNpcOverviewService.selectByOverview());
    }
}
