package com.shahenpc.web.controller.representative;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.shahenpc.system.domain.representative.dto.PerformHomeAccessDto;
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
import com.shahenpc.system.domain.representative.PerformHomeAccess;
import com.shahenpc.system.service.representative.IPerformHomeAccessService;
import com.shahenpc.common.utils.poi.ExcelUtil;
import com.shahenpc.common.core.page.TableDataInfo;

/**
 * 代之家访问Controller
 * 
 * @author ruoyi
 * @date 2022-07-08
 */
@Api(tags = "代表之家访问")
@RestController
@RequestMapping("/perform/access")
public class PerformHomeAccessController extends BaseController
{
    @Autowired
    private IPerformHomeAccessService performHomeAccessService;

    /**
     * 查询代之家访问列表
     */
    @ApiOperation("列表")
    @PreAuthorize("@ss.hasPermi('perform:access:list')")
    @GetMapping("/list")
    public TableDataInfo list(PerformHomeAccessDto performHomeAccess)
    {
        startPage();
        List<PerformHomeAccess> list = performHomeAccessService.selectPerformHomeAccessList(performHomeAccess);
        return getDataTable(list);
    }

    /**
     * 导出代之家访问列表
     */
    @PreAuthorize("@ss.hasPermi('perform:access:export')")
    @Log(title = "代之家访问", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, PerformHomeAccessDto performHomeAccess)
    {
        List<PerformHomeAccess> list = performHomeAccessService.selectPerformHomeAccessList(performHomeAccess);
        ExcelUtil<PerformHomeAccess> util = new ExcelUtil<PerformHomeAccess>(PerformHomeAccess.class);
        util.exportExcel(response, list, "代之家访问数据");
    }

    /**
     * 获取代之家访问详细信息
     */
    @ApiOperation("详情")
    @PreAuthorize("@ss.hasPermi('perform:access:query')")
    @GetMapping(value = "/{accessId}")
    public AjaxResult getInfo(@PathVariable("accessId") Long accessId)
    {
        return AjaxResult.success(performHomeAccessService.selectPerformHomeAccessByAccessId(accessId));
    }

    /**
     * 新增代之家访问
     */
    @ApiOperation("新增")
    @PreAuthorize("@ss.hasPermi('perform:access:add')")
    @Log(title = "代之家访问", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PerformHomeAccess performHomeAccess)
    {
        return toAjax(performHomeAccessService.insertPerformHomeAccess(performHomeAccess));
    }

    /**
     * 修改代之家访问
     */
    @ApiOperation("修改")
    @PreAuthorize("@ss.hasPermi('perform:access:edit')")
    @Log(title = "代之家访问", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PerformHomeAccess performHomeAccess)
    {
        return toAjax(performHomeAccessService.updatePerformHomeAccess(performHomeAccess));
    }

    /**
     * 删除代之家访问
     */
    @ApiOperation("删除")
    @PreAuthorize("@ss.hasPermi('perform:access:remove')")
    @Log(title = "代之家访问", businessType = BusinessType.DELETE)
	@DeleteMapping("/{accessIds}")
    public AjaxResult remove(@PathVariable Long[] accessIds)
    {
        return toAjax(performHomeAccessService.deletePerformHomeAccessByAccessIds(accessIds));
    }

    @ApiOperation("访问总次数")
    @PreAuthorize("@ss.hasPermi('perform:access:list')")
    @GetMapping("/visits/total")
    public AjaxResult visitsTotal()
    {
        return AjaxResult.success(performHomeAccessService.selectVisitsCount());
    }

}
