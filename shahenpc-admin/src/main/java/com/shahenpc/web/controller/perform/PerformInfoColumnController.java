package com.shahenpc.web.controller.perform;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
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
import com.shahenpc.system.domain.perform.PerformInfoColumn;
import com.shahenpc.system.service.perform.IPerformInfoColumnService;
import com.shahenpc.common.utils.poi.ExcelUtil;
import com.shahenpc.common.core.page.TableDataInfo;

/**
 * 信息发布栏目菜单Controller
 * 
 * @author ruoyi
 * @date 2022-07-08
 */
@Api(tags = "信息发布管理")
@RestController
@RequestMapping("/perform/column")
public class PerformInfoColumnController extends BaseController
{
    @Autowired
    private IPerformInfoColumnService performInfoColumnService;

    /**
     * 查询信息发布栏目菜单列表
     */
    @ApiOperation("列表")
    @PreAuthorize("@ss.hasPermi('perform:column:list')")
    @GetMapping("/list")
    public AjaxResult list(PerformInfoColumn performInfoColumn)
    {
        List<PerformInfoColumn> list = performInfoColumnService.selectPerformInfoColumnList(performInfoColumn);
        return AjaxResult.success(list);
    }

    /**
     * 导出信息发布栏目菜单列表
     */
    @PreAuthorize("@ss.hasPermi('perform:column:export')")
    @Log(title = "信息发布栏目菜单", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, PerformInfoColumn performInfoColumn)
    {
        List<PerformInfoColumn> list = performInfoColumnService.selectPerformInfoColumnList(performInfoColumn);
        ExcelUtil<PerformInfoColumn> util = new ExcelUtil<PerformInfoColumn>(PerformInfoColumn.class);
        util.exportExcel(response, list, "信息发布栏目菜单数据");
    }

    /**
     * 获取信息发布栏目菜单详细信息
     */
    @ApiOperation("详情")
    @ApiImplicitParam(name = "columnId", value = "栏目Id", required = true, dataType = "Long", paramType = "path", dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermi('perform:column:query')")
    @GetMapping(value = "/{columnId}")
    public AjaxResult getInfo(@PathVariable("columnId") Long columnId)
    {
        return AjaxResult.success(performInfoColumnService.selectPerformInfoColumnByColumnId(columnId));
    }

    /**
     * 新增信息发布栏目菜单
     */
    @ApiOperation("新增")
    @PreAuthorize("@ss.hasPermi('perform:column:add')")
    @Log(title = "信息发布栏目菜单", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PerformInfoColumn performInfoColumn)
    {
        return toAjax(performInfoColumnService.insertPerformInfoColumn(performInfoColumn));
    }

    /**
     * 修改信息发布栏目菜单
     */
    @ApiOperation("新增")
    @PreAuthorize("@ss.hasPermi('perform:column:edit')")
    @Log(title = "信息发布栏目菜单", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PerformInfoColumn performInfoColumn)
    {
        return toAjax(performInfoColumnService.updatePerformInfoColumn(performInfoColumn));
    }

    /**
     * 删除信息发布栏目菜单
     */
    @ApiOperation("删除")
    @PreAuthorize("@ss.hasPermi('perform:column:remove')")
    @Log(title = "信息发布栏目菜单", businessType = BusinessType.DELETE)
    @DeleteMapping("/{columnIds}")
    public AjaxResult remove(@PathVariable Long[] columnIds)
    {
        return toAjax(performInfoColumnService.deletePerformInfoColumnByColumnIds(columnIds));
    }
}
