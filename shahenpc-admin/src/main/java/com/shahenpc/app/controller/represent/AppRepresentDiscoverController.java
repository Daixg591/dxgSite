package com.shahenpc.app.controller.represent;

import com.shahenpc.common.annotation.Log;
import com.shahenpc.common.core.controller.BaseController;
import com.shahenpc.common.core.domain.AjaxResult;
import com.shahenpc.common.core.page.TableDataInfo;
import com.shahenpc.common.enums.BusinessType;
import com.shahenpc.common.utils.poi.ExcelUtil;
import com.shahenpc.system.domain.represent.RepresentDiscover;
import com.shahenpc.system.domain.represent.dto.DiscoverAppListDto;
import com.shahenpc.system.service.represent.IRepresentDiscoverService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 代表发现Controller
 * 
 * @author ruoyi
 * @date 2022-07-28
 */
@Api(tags = "app代表发现")
@RestController
@RequestMapping("/app/represent/discover")
public class AppRepresentDiscoverController extends BaseController
{
    @Autowired
    private IRepresentDiscoverService representDiscoverService;

    /**
     * 查询代-代发现列表
     */
    @ApiOperation("列表")
    @PreAuthorize("@ss.hasPermi('represent:discover:list')")
    @GetMapping("/list")
    public TableDataInfo list(RepresentDiscover representDiscover)
    {
        startPage();
        List<DiscoverAppListDto> list = representDiscoverService.appList(representDiscover);
        return getDataTable(list);
    }

    /**
     * 导出代-代发现列表
     */
    @ApiOperation("导出")
    @PreAuthorize("@ss.hasPermi('represent:discover:export')")
    @Log(title = "代-代发现", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, RepresentDiscover representDiscover)
    {
        List<RepresentDiscover> list = representDiscoverService.selectRepresentDiscoverList(representDiscover);
        ExcelUtil<RepresentDiscover> util = new ExcelUtil<RepresentDiscover>(RepresentDiscover.class);
        util.exportExcel(response, list, "代-代发现数据");
    }

    /**
     * 获取代-代发现详细信息
     */
    @ApiOperation("详情")
    @PreAuthorize("@ss.hasPermi('represent:discover:query')")
    @GetMapping(value = "/{discoverId}")
    public AjaxResult getInfo(@PathVariable("discoverId") Long discoverId)
    {
        return AjaxResult.success(representDiscoverService.appDetail(discoverId));
    }

    /**
     * 新增代-代发现
     */
    @ApiOperation("新增")
    @PreAuthorize("@ss.hasPermi('represent:discover:add')")
    @Log(title = "代-代发现", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody RepresentDiscover representDiscover)
    {
        representDiscover.setSendUserId(getUserId());
        return toAjax(representDiscoverService.insertRepresentDiscover(representDiscover));
    }

    /**
     * 修改代-代发现
     */
    @ApiOperation("新增")
    @PreAuthorize("@ss.hasPermi('represent:discover:edit')")
    @Log(title = "代-代发现", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody RepresentDiscover representDiscover)
    {
        return toAjax(representDiscoverService.updateRepresentDiscover(representDiscover));
    }

    /**
     * 删除代-代发现
     */
    @ApiOperation("删除")
    @PreAuthorize("@ss.hasPermi('represent:discover:remove')")
    @Log(title = "代-代发现", businessType = BusinessType.DELETE)
	@DeleteMapping("/{discoverIds}")
    public AjaxResult remove(@PathVariable Long[] discoverIds)
    {
        return toAjax(representDiscoverService.deleteRepresentDiscoverByDiscoverIds(discoverIds));
    }
}
