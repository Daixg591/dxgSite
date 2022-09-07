package com.shahenpc.web.controller.upgrade;

import com.shahenpc.common.annotation.Log;
import com.shahenpc.common.core.controller.BaseController;
import com.shahenpc.common.core.domain.AjaxResult;
import com.shahenpc.common.core.page.TableDataInfo;
import com.shahenpc.common.enums.BusinessType;
import com.shahenpc.common.utils.poi.ExcelUtil;
import com.shahenpc.system.domain.upgrade.VersionUpgrade;
import com.shahenpc.system.service.upgrade.IVersionUpgradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 【请填写功能名称】Controller
 * 
 * @author ruoyi
 * @date 2022-06-22
 */
@RestController
@RequestMapping("/system/upgrade")
public class VersionUpgradeController extends BaseController
{
    @Autowired
    private IVersionUpgradeService versionUpgradeService;

    /**
     * 查询【请填写功能名称】列表 /system/upgrade/liset
     */
//    @PreAuthorize("@ss.hasPermi('system:upgrade:list')")
    @GetMapping("/list")
    public TableDataInfo list(VersionUpgrade versionUpgrade)
    {
        startPage();
        List<VersionUpgrade> list = versionUpgradeService.selectVersionUpgradeList(versionUpgrade);
        return getDataTable(list);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('system:upgrade:export')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, VersionUpgrade versionUpgrade)
    {
        List<VersionUpgrade> list = versionUpgradeService.selectVersionUpgradeList(versionUpgrade);
        ExcelUtil<VersionUpgrade> util = new ExcelUtil<VersionUpgrade>(VersionUpgrade.class);
        util.exportExcel(response, list, "【请填写功能名称】数据");
    }

    /**
     * 获取【请填写功能名称】详细信息
     */
    //@PreAuthorize("@ss.hasPermi('system:upgrade:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(versionUpgradeService.selectVersionUpgradeById(id));
    }

    /**
     * 新增【请填写功能名称】
     */
    //@PreAuthorize("@ss.hasPermi('system:upgrade:add')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody VersionUpgrade versionUpgrade)
    {
        return toAjax(versionUpgradeService.insertVersionUpgrade(versionUpgrade));
    }

    /**
     * 修改【请填写功能名称】
     */
    //@PreAuthorize("@ss.hasPermi('system:upgrade:edit')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody VersionUpgrade versionUpgrade)
    {
        return toAjax(versionUpgradeService.updateVersionUpgrade(versionUpgrade));
    }

    /**
     * 删除【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:upgrade:remove')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Integer[] ids)
    {
        return toAjax(versionUpgradeService.deleteVersionUpgradeByIds(ids));
    }


    /**
     * 查询【请填写功能名称】列表
     */
    //@PreAuthorize("@ss.hasPermi('list:upgrade:list')")
    @GetMapping("/liset")
    public AjaxResult ltest(VersionUpgrade versionUpgrade)
    {
        return AjaxResult.success(versionUpgradeService.getAppType(versionUpgrade.getAppType()));
    }
}
