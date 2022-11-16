package com.shahenpc.web.controller.system;

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
import com.shahenpc.system.domain.SysUserArchives;
import com.shahenpc.system.service.ISysUserArchivesService;
import com.shahenpc.common.utils.poi.ExcelUtil;
import com.shahenpc.common.core.page.TableDataInfo;

/**
 * 代履职档案Controller
 * 
 * @author ruoyi
 * @date 2022-10-21
 */
@Api(tags = "代表履职档案")
@RestController
@RequestMapping("/system/archives")
public class SysUserArchivesController extends BaseController
{
    @Autowired
    private ISysUserArchivesService sysUserArchivesService;

    /**
     * 查询代履职档案列表
     */
    @ApiOperation("查询")
    @PreAuthorize("@ss.hasPermi('system:archives:list')")
    @GetMapping("/list")
    public TableDataInfo list(SysUserArchives sysUserArchives)
    {
        startPage();
        List<SysUserArchives> list = sysUserArchivesService.selectSysUserArchivesList(sysUserArchives);
        return getDataTable(list);
    }
    /**
     * 获取代履职档案详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:archives:query')")
    @GetMapping(value = "/user/{userId}")
    public AjaxResult getUserInfo(@PathVariable("userId") Long userId)
    {
        return AjaxResult.success(sysUserArchivesService.selectSysUserArchivesByUserId(userId));
    }

    /**
     * 导出代履职档案列表
     */
    @PreAuthorize("@ss.hasPermi('system:archives:export')")
    @Log(title = "代履职档案", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SysUserArchives sysUserArchives)
    {
        List<SysUserArchives> list = sysUserArchivesService.selectSysUserArchivesList(sysUserArchives);
        ExcelUtil<SysUserArchives> util = new ExcelUtil<SysUserArchives>(SysUserArchives.class);
        util.exportExcel(response, list, "代履职档案数据");
    }

    /**
     * 获取代履职档案详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:archives:query')")
    @GetMapping(value = "/{archivesId}")
    public AjaxResult getInfo(@PathVariable("archivesId") Long archivesId)
    {
        return AjaxResult.success(sysUserArchivesService.selectSysUserArchivesByArchivesId(archivesId));
    }

    /**
     * 新增代履职档案
     */
    @PreAuthorize("@ss.hasPermi('system:archives:add')")
    @Log(title = "代履职档案", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysUserArchives sysUserArchives)
    {
        return toAjax(sysUserArchivesService.insertSysUserArchives(sysUserArchives));
    }

    /**
     * 修改代履职档案
     */
    @PreAuthorize("@ss.hasPermi('system:archives:edit')")
    @Log(title = "代履职档案", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysUserArchives sysUserArchives)
    {
        return toAjax(sysUserArchivesService.updateSysUserArchives(sysUserArchives));
    }

    /**
     * 删除代履职档案
     */
    @PreAuthorize("@ss.hasPermi('system:archives:remove')")
    @Log(title = "代履职档案", businessType = BusinessType.DELETE)
	@DeleteMapping("/{archivesIds}")
    public AjaxResult remove(@PathVariable Long[] archivesIds)
    {
        return toAjax(sysUserArchivesService.deleteSysUserArchivesByArchivesIds(archivesIds));
    }
}
