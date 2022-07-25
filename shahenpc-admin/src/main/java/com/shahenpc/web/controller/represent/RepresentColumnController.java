package com.shahenpc.web.controller.represent;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.shahenpc.system.domain.represent.dto.RepresentColumnDto;
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
import com.shahenpc.system.domain.represent.RepresentColumn;
import com.shahenpc.system.service.represent.IRepresentColumnService;
import com.shahenpc.common.utils.poi.ExcelUtil;
import com.shahenpc.common.core.page.TableDataInfo;

/**
 * 信息发布栏目菜单Controller
 * 
 * @author ruoyi
 * @date 2022-07-21
 */
@Api(tags = "栏目管理")
@RestController
@RequestMapping("/represent/column")
public class RepresentColumnController extends BaseController
{
    @Autowired
    private IRepresentColumnService representColumnService;

    /**
     * 查询信息发布栏目菜单列表
     */
    @ApiOperation("列表")
    @PreAuthorize("@ss.hasPermi('represent:column:list')")
    @GetMapping("/list")
    public TableDataInfo list(RepresentColumn representColumn)
    {
        //startPage();
        List<RepresentColumnDto> list = representColumnService.selectByAdminList(representColumn);
        return getDataTable(list);
    }

    /**
     * 导出信息发布栏目菜单列表
     */
    @ApiOperation("导出")
    @PreAuthorize("@ss.hasPermi('represent:column:export')")
    @Log(title = "信息发布栏目菜单", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, RepresentColumn representColumn)
    {
        List<RepresentColumn> list = representColumnService.selectRepresentColumnList(representColumn);
        ExcelUtil<RepresentColumn> util = new ExcelUtil<RepresentColumn>(RepresentColumn.class);
        util.exportExcel(response, list, "信息发布栏目菜单数据");
    }

    /**
     * 获取信息发布栏目菜单详细信息
     */
    @ApiOperation("详情")
    @PreAuthorize("@ss.hasPermi('represent:column:query')")
    @GetMapping(value = "/{columnId}")
    public AjaxResult getInfo(@PathVariable("columnId") Long columnId)
    {
        return AjaxResult.success(representColumnService.selectRepresentColumnByColumnId(columnId));
    }

    /**
     * 新增信息发布栏目菜单
     */
    @ApiOperation("新增")
    @PreAuthorize("@ss.hasPermi('represent:column:add')")
    @Log(title = "信息发布栏目菜单", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody RepresentColumn representColumn)
    {
        return toAjax(representColumnService.insertRepresentColumn(representColumn));
    }

    /**
     * 修改信息发布栏目菜单
     */
    @ApiOperation("修改")
    @PreAuthorize("@ss.hasPermi('represent:column:edit')")
    @Log(title = "信息发布栏目菜单", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody RepresentColumn representColumn)
    {
        return toAjax(representColumnService.updateRepresentColumn(representColumn));
    }

    /**
     * 删除信息发布栏目菜单
     */
    @ApiOperation("删除")
    @PreAuthorize("@ss.hasPermi('represent:column:remove')")
    @Log(title = "信息发布栏目菜单", businessType = BusinessType.DELETE)
	@DeleteMapping("/{columnIds}")
    public AjaxResult remove(@PathVariable Long[] columnIds)
    {
        return toAjax(representColumnService.deleteRepresentColumnByColumnIds(columnIds));
    }
}
