package com.shahenpc.web.controller.perform;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
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
import com.shahenpc.system.domain.perform.PerformNpcOverview;
import com.shahenpc.system.service.perform.IPerformNpcOverviewService;
import com.shahenpc.common.utils.poi.ExcelUtil;
import com.shahenpc.common.core.page.TableDataInfo;

/**
 * 小程序-信息发布Controller
 * 
 * @author ruoyi
 * @date 2022-07-08
 */
@RestController
@RequestMapping("/system/overview")
public class PerformNpcOverviewController extends BaseController
{
    @Autowired
    private IPerformNpcOverviewService performNpcOverviewService;

    /**
     * 查询小程序-信息发布列表
     */
    @PreAuthorize("@ss.hasPermi('system:overview:list')")
    @GetMapping("/list")
    public TableDataInfo list(PerformNpcOverview performNpcOverview)
    {
        startPage();
        List<PerformNpcOverview> list = performNpcOverviewService.selectPerformNpcOverviewList(performNpcOverview);
        return getDataTable(list);
    }

    /**
     * 导出小程序-信息发布列表
     */
    @PreAuthorize("@ss.hasPermi('system:overview:export')")
    @Log(title = "小程序-信息发布", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, PerformNpcOverview performNpcOverview)
    {
        List<PerformNpcOverview> list = performNpcOverviewService.selectPerformNpcOverviewList(performNpcOverview);
        ExcelUtil<PerformNpcOverview> util = new ExcelUtil<PerformNpcOverview>(PerformNpcOverview.class);
        util.exportExcel(response, list, "小程序-信息发布数据");
    }

    /**
     * 获取小程序-信息发布详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:overview:query')")
    @GetMapping(value = "/{overviewId}")
    public AjaxResult getInfo(@PathVariable("overviewId") Long overviewId)
    {
        return AjaxResult.success(performNpcOverviewService.selectPerformNpcOverviewByOverviewId(overviewId));
    }

    /**
     * 新增小程序-信息发布
     */
    @PreAuthorize("@ss.hasPermi('system:overview:add')")
    @Log(title = "小程序-信息发布", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PerformNpcOverview performNpcOverview)
    {
        return toAjax(performNpcOverviewService.insertPerformNpcOverview(performNpcOverview));
    }

    /**
     * 修改小程序-信息发布
     */
    @PreAuthorize("@ss.hasPermi('system:overview:edit')")
    @Log(title = "小程序-信息发布", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PerformNpcOverview performNpcOverview)
    {
        return toAjax(performNpcOverviewService.updatePerformNpcOverview(performNpcOverview));
    }

    /**
     * 删除小程序-信息发布
     */
    @PreAuthorize("@ss.hasPermi('system:overview:remove')")
    @Log(title = "小程序-信息发布", businessType = BusinessType.DELETE)
	@DeleteMapping("/{overviewIds}")
    public AjaxResult remove(@PathVariable Long[] overviewIds)
    {
        return toAjax(performNpcOverviewService.deletePerformNpcOverviewByOverviewIds(overviewIds));
    }
}
