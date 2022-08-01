package com.shahenpc.web.controller.represent;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.shahenpc.system.domain.represent.dto.DiscoverListDto;
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
import com.shahenpc.system.domain.represent.RepresentDiscover;
import com.shahenpc.system.service.represent.IRepresentDiscoverService;
import com.shahenpc.common.utils.poi.ExcelUtil;
import com.shahenpc.common.core.page.TableDataInfo;

/**
 * 代-代发现Controller
 * 
 * @author ruoyi
 * @date 2022-07-28
 */
@Api(tags = "代表发现")
@RestController
@RequestMapping("/represent/discover")
public class RepresentDiscoverController extends BaseController
{
    @Autowired
    private IRepresentDiscoverService representDiscoverService;

    /**
     * 查询代-代发现列表
     */
    @PreAuthorize("@ss.hasPermi('represent:discover:list')")
    @GetMapping("/list")
    public TableDataInfo list(RepresentDiscover representDiscover)
    {
        startPage();
        List<DiscoverListDto> list = representDiscoverService.adminList(representDiscover);
        return getDataTable(list);
    }

    /**
     * 导出代-代发现列表
     */
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
    @PreAuthorize("@ss.hasPermi('represent:discover:query')")
    @GetMapping(value = "/{discoverId}")
    public AjaxResult getInfo(@PathVariable("discoverId") Long discoverId)
    {
        return AjaxResult.success(representDiscoverService.detail(discoverId));
    }
    /**
     * 新增代-代发现
     */
    @PreAuthorize("@ss.hasPermi('represent:discover:add')")
    @Log(title = "代-代发现", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody RepresentDiscover representDiscover)
    {
        representDiscover.setSendUserId(getUserId());
        representDiscover.setUpdateBy(getUsername());
        return toAjax(representDiscoverService.insertRepresentDiscover(representDiscover));
    }

    /**
     * 修改代-代发现
     */
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
    @PreAuthorize("@ss.hasPermi('represent:discover:remove')")
    @Log(title = "代-代发现", businessType = BusinessType.DELETE)
	@DeleteMapping("/{discoverIds}")
    public AjaxResult remove(@PathVariable Long[] discoverIds)
    {
        return toAjax(representDiscoverService.deleteRepresentDiscoverByDiscoverIds(discoverIds));
    }


    @ApiOperation("环数")
    @GetMapping("/ring")
    public AjaxResult ring(){
        return AjaxResult.success(representDiscoverService.ring());
    }

    @ApiOperation("曲线")
    @GetMapping("/line")
    public AjaxResult line(){
        return AjaxResult.success(representDiscoverService.line());
    }


    @ApiOperation("饼图")
    @GetMapping(value = "/pie")
    public AjaxResult cake()
    {
        return AjaxResult.success(representDiscoverService.pie());
    }
}
