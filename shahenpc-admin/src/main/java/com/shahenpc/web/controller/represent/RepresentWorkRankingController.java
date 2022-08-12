package com.shahenpc.web.controller.represent;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
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
import com.shahenpc.system.domain.represent.RepresentWorkRanking;
import com.shahenpc.system.service.represent.IRepresentWorkRankingService;
import com.shahenpc.common.utils.poi.ExcelUtil;
import com.shahenpc.common.core.page.TableDataInfo;

/**
 * 排行 以及 类型数  总数Controller
 * 
 * @author ruoyi
 * @date 2022-08-11
 */
@Component("rankingController")
@RestController
@RequestMapping("/represent/ranking")
public class RepresentWorkRankingController extends BaseController
{
    @Autowired
    private IRepresentWorkRankingService representWorkRankingService;

    /**
     * 查询排行 以及 类型数  总数列表
     */
    @PreAuthorize("@ss.hasPermi('represent:ranking:list')")
    @GetMapping("/list")
    public TableDataInfo list(RepresentWorkRanking representWorkRanking)
    {
        startPage();
        List<RepresentWorkRanking> list = representWorkRankingService.selectRepresentWorkRankingList(representWorkRanking);
        return getDataTable(list);
    }

    @PreAuthorize("@ss.hasPermi('represent:ranking:list')")
    @GetMapping("/my/ranking")
    public TableDataInfo ranking(RepresentWorkRanking representWorkRanking)
    {
        representWorkRanking.setUserId(getUserId());
        List<RepresentWorkRanking> list = representWorkRankingService.selectRepresentWorkRankingList(representWorkRanking);
        return getDataTable(list);
    }

    /**
     * 导出排行 以及 类型数  总数列表
     */
    @PreAuthorize("@ss.hasPermi('represent:ranking:export')")
    @Log(title = "排行 以及 类型数  总数", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, RepresentWorkRanking representWorkRanking)
    {
        List<RepresentWorkRanking> list = representWorkRankingService.selectRepresentWorkRankingList(representWorkRanking);
        ExcelUtil<RepresentWorkRanking> util = new ExcelUtil<RepresentWorkRanking>(RepresentWorkRanking.class);
        util.exportExcel(response, list, "排行 以及 类型数  总数数据");
    }

    /**
     * 获取排行 以及 类型数  总数详细信息
     */
    @PreAuthorize("@ss.hasPermi('represent:ranking:query')")
    @GetMapping(value = "/{rankingId}")
    public AjaxResult getInfo(@PathVariable("rankingId") Long rankingId)
    {
        return AjaxResult.success(representWorkRankingService.selectRepresentWorkRankingByRankingId(rankingId));
    }

    /**
     * 新增排行 以及 类型数  总数
     */
    @PreAuthorize("@ss.hasPermi('represent:ranking:add')")
    @Log(title = "排行 以及 类型数  总数", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody RepresentWorkRanking representWorkRanking)
    {
        return toAjax(representWorkRankingService.insertRepresentWorkRanking(representWorkRanking));
    }

    /**
     * 修改排行 以及 类型数  总数
     */
    @PreAuthorize("@ss.hasPermi('represent:ranking:edit')")
    @Log(title = "排行 以及 类型数  总数", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody RepresentWorkRanking representWorkRanking)
    {
        return toAjax(representWorkRankingService.updateRepresentWorkRanking(representWorkRanking));
    }

    /**
     * 删除排行 以及 类型数  总数
     */
    @PreAuthorize("@ss.hasPermi('represent:ranking:remove')")
    @Log(title = "排行 以及 类型数  总数", businessType = BusinessType.DELETE)
	@DeleteMapping("/{rankingIds}")
    public AjaxResult remove(@PathVariable Long[] rankingIds)
    {
        return toAjax(representWorkRankingService.deleteRepresentWorkRankingByRankingIds(rankingIds));
    }

    public AjaxResult timingAdd()
    {
        return toAjax(representWorkRankingService.timingAdd());
    }
}
