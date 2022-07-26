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
import com.shahenpc.system.domain.represent.RepresentHomeAccess;
import com.shahenpc.system.service.represent.IRepresentHomeAccessService;
import com.shahenpc.common.utils.poi.ExcelUtil;
import com.shahenpc.common.core.page.TableDataInfo;

/**
 * 代之家访问Controller
 * 
 * @author ruoyi
 * @date 2022-07-21
 */
@Api(tags = "代表之家访问")
@RestController
@RequestMapping("/represent/access")
public class RepresentHomeAccessController extends BaseController
{
    @Autowired
    private IRepresentHomeAccessService representHomeAccessService;

    /**
     * 查询代之家访问列表
     */
    @ApiOperation("列表")
    @PreAuthorize("@ss.hasPermi('represent:access:list')")
    @GetMapping("/list")
    public TableDataInfo list(RepresentHomeAccess representHomeAccess)
    {
        startPage();
        List<RepresentHomeAccess> list = representHomeAccessService.selectRepresentHomeAccessList(representHomeAccess);
        return getDataTable(list);
    }

    /**
     * 导出代之家访问列表
     */
    @ApiOperation("导出")
    @PreAuthorize("@ss.hasPermi('represent:access:export')")
    @Log(title = "代之家访问", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, RepresentHomeAccess representHomeAccess)
    {
        List<RepresentHomeAccess> list = representHomeAccessService.selectRepresentHomeAccessList(representHomeAccess);
        ExcelUtil<RepresentHomeAccess> util = new ExcelUtil<RepresentHomeAccess>(RepresentHomeAccess.class);
        util.exportExcel(response, list, "代之家访问数据");
    }

    /**
     * 获取代之家访问详细信息
     */
    @ApiOperation("详情")
    @PreAuthorize("@ss.hasPermi('represent:access:query')")
    @GetMapping(value = "/{accessId}")
    public AjaxResult getInfo(@PathVariable("accessId") Long accessId)
    {
        return AjaxResult.success(representHomeAccessService.selectRepresentHomeAccessByAccessId(accessId));
    }

    /**
     * 新增代之家访问
     */
    @ApiOperation("新增")
    @PreAuthorize("@ss.hasPermi('represent:access:add')")
    @Log(title = "代之家访问", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody RepresentHomeAccess representHomeAccess)
    {
        return toAjax(representHomeAccessService.insertRepresentHomeAccess(representHomeAccess));
    }

    /**
     * 修改代之家访问
     */
    @ApiOperation("修改")
    @PreAuthorize("@ss.hasPermi('represent:access:edit')")
    @Log(title = "代之家访问", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody RepresentHomeAccess representHomeAccess)
    {
        return toAjax(representHomeAccessService.updateRepresentHomeAccess(representHomeAccess));
    }

    /**
     * 删除代之家访问
     */
    @ApiOperation("删除")
    @PreAuthorize("@ss.hasPermi('represent:access:remove')")
    @Log(title = "代之家访问", businessType = BusinessType.DELETE)
	@DeleteMapping("/{accessIds}")
    public AjaxResult remove(@PathVariable Long[] accessIds)
    {
        return toAjax(representHomeAccessService.deleteRepresentHomeAccessByAccessIds(accessIds));
    }

    @ApiOperation("访问总次数")
    @GetMapping("/visits/count")
    public AjaxResult visitsTotal()
    {
        return AjaxResult.success(representHomeAccessService.selectVisitsCount());
    }

    @ApiOperation("前三名排行")
    @GetMapping("/ranking/list")
    public TableDataInfo rankingList()
    {
        List<RepresentHomeAccess> list = representHomeAccessService.rankingList();
        return getDataTable(list);
    }
}
