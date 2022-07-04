package com.shahenpc.web.controller.special;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
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
import com.shahenpc.system.domain.special.SpecialWork;
import com.shahenpc.system.service.special.ISpecialWorkService;
import com.shahenpc.common.utils.poi.ExcelUtil;
import com.shahenpc.common.core.page.TableDataInfo;

/**
 * 民事实事Controller
 * 
 * @author ruoyi
 * @date 2022-07-01
 */
@Api(tags = "民事实事管理")
@RestController
@RequestMapping("/system/work")
public class SpecialWorkController extends BaseController
{
    @Autowired
    private ISpecialWorkService specialWorkService;

    /**
     * 查询特色工作列表
     */
    @ApiOperation("民事实事列表")
    @PreAuthorize("@ss.hasPermi('system:work:list')")
    @GetMapping("/list")
    public TableDataInfo list(SpecialWork specialWork)
    {
        startPage();
        List<SpecialWork> list = specialWorkService.selectSpecialWorkList(specialWork);
        return getDataTable(list);
    }

    /**
     * 导出特色工作列表
     */
    @PreAuthorize("@ss.hasPermi('system:work:export')")
    @Log(title = "特色工作", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SpecialWork specialWork)
    {
        List<SpecialWork> list = specialWorkService.selectSpecialWorkList(specialWork);
        ExcelUtil<SpecialWork> util = new ExcelUtil<SpecialWork>(SpecialWork.class);
        util.exportExcel(response, list, "特色工作数据");
    }

    /**
     * 获取特色工作详细信息
     */
    @ApiOperation("民事实事详情")
    @ApiImplicitParam(name = "specialId",value = "实事Id", required = true, dataType = "int", paramType = "path", dataTypeClass = Integer.class)
    @PreAuthorize("@ss.hasPermi('system:work:query')")
    @GetMapping(value = "/{specialId}")
    public AjaxResult getInfo(@PathVariable("specialId") Long specialId)
    {
        return AjaxResult.success(specialWorkService.selectSpecialWorkBySpecialId(specialId));
    }

    /**
     * 新增特色工作
     */
    @ApiOperation("新增民事实事")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "specialId",value = "实事Id", required = true, dataType = "Long", paramType = "path", dataTypeClass = Long.class),
            @ApiImplicitParam(name = "title",value = "标题", required = true, dataType = "String", paramType = "path", dataTypeClass = String.class),
            @ApiImplicitParam(name = "content",value = "内容", required = true, dataType = "String", paramType = "path", dataTypeClass = String.class),
    })
    @PreAuthorize("@ss.hasPermi('system:work:add')")
    @Log(title = "特色工作", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SpecialWork specialWork)
    {
        specialWork.setCreateBy(getUsername());
        return toAjax(specialWorkService.insertSpecialWork(specialWork));
    }

    /**
     * 修改特色工作
     */
    @ApiOperation("修改民事实事")
    @PreAuthorize("@ss.hasPermi('system:work:edit')")
    @Log(title = "特色工作", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SpecialWork specialWork)
    {
        specialWork.setUpdateBy(getUsername());
        return toAjax(specialWorkService.updateSpecialWork(specialWork));
    }

    /**
     * 删除特色工作
     */
    @ApiOperation("删除民事实事")
    @PreAuthorize("@ss.hasPermi('system:work:remove')")
    @Log(title = "特色工作", businessType = BusinessType.DELETE)
	@DeleteMapping("/{specialIds}")
    public AjaxResult remove(@PathVariable Long[] specialIds)
    {
        return toAjax(specialWorkService.deleteSpecialWorkBySpecialIds(specialIds));
    }
}
