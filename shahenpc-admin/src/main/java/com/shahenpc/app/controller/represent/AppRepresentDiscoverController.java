package com.shahenpc.app.controller.represent;

import com.shahenpc.common.annotation.Log;
import com.shahenpc.common.core.controller.BaseController;
import com.shahenpc.common.core.domain.AjaxResult;
import com.shahenpc.common.core.page.TableDataInfo;
import com.shahenpc.common.enums.BusinessType;
import com.shahenpc.common.utils.poi.ExcelUtil;
import com.shahenpc.system.domain.represent.RepresentDiscover;
import com.shahenpc.system.domain.represent.dto.DiscoverAppListDto;
import com.shahenpc.system.domain.represent.vo.DiscoverUpdateVo;
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
    @PreAuthorize("@ss.hasPermi('discover:translate:all')")
    @GetMapping("/all/list")
    public TableDataInfo allList(RepresentDiscover representDiscover)
    {
        startPage();
        List<DiscoverAppListDto> list = representDiscoverService.appList(representDiscover);
        return getDataTable(list);
    }
    /**
     * 查询代-代发现列表
     */
    @ApiOperation("列表")
    @GetMapping("/list")
    public TableDataInfo list(RepresentDiscover representDiscover)
    {
        startPage();
        representDiscover.setSendUserId(getUserId());
        List<DiscoverAppListDto> list = representDiscoverService.appList(representDiscover);
        return getDataTable(list);
    }

    @ApiOperation("待办列表")
    @GetMapping("/todo/list")
    public TableDataInfo todoList(RepresentDiscover representDiscover)
    {
        representDiscover.setReceiveUserId(getUserId());
        startPage();
        List<DiscoverAppListDto> list = representDiscoverService.todoList(representDiscover);
        return getDataTable(list);
    }

    @ApiOperation("已办列表")
    @GetMapping("/done/list")
    public TableDataInfo doneList()
    {
        startPage();
        List<DiscoverAppListDto> list = representDiscoverService.doneList(getUserId());
        return getDataTable(list);
    }
    /**
     * 导出代-代发现列表
     */
    @ApiOperation("导出")
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
    @GetMapping(value = "/{discoverId}")
    public AjaxResult getInfo(@PathVariable("discoverId") Long discoverId)
    {
        return AjaxResult.success(representDiscoverService.appDetail(discoverId));
    }

    /**
     * 新增代-代发现
     */
    @ApiOperation("新增")
    @Log(title = "代-代发现", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody RepresentDiscover representDiscover)
    {
        representDiscover.setSendUserId(getUserId());
        representDiscover.setCreateBy(getNickName());
        representDiscover.setStationId(getContactStationId());
        System.out.println(getContactStationId());
        return representDiscoverService.insertRepresentDiscover(representDiscover);
    }

    /**
     * 修改代-代发现
     */
    @ApiOperation("新增")
    @Log(title = "代-代发现", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody DiscoverUpdateVo representDiscover)
    {
        representDiscover.setUpdateBy(getNickName());
        representDiscover.setUserId(getUserId());
        return representDiscoverService.updateRepresentDiscover(representDiscover);
    }

    /**
     * 删除代-代发现
     */
    @ApiOperation("删除")
    @Log(title = "代-代发现", businessType = BusinessType.DELETE)
	@DeleteMapping("/{discoverIds}")
    public AjaxResult remove(@PathVariable Long[] discoverIds)
    {
        return toAjax(representDiscoverService.deleteRepresentDiscoverByDiscoverIds(discoverIds));
    }
}
