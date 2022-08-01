package com.shahenpc.web.controller.represent;

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
import com.shahenpc.system.domain.represent.RepresentDiscoverTrack;
import com.shahenpc.system.service.represent.IRepresentDiscoverTrackService;
import com.shahenpc.common.utils.poi.ExcelUtil;
import com.shahenpc.common.core.page.TableDataInfo;

/**
 * 【请填写功能名称】Controller
 * 
 * @author ruoyi
 * @date 2022-07-30
 */
@RestController
@RequestMapping("/represent/discover/track")
public class RepresentDiscoverTrackController extends BaseController
{
    @Autowired
    private IRepresentDiscoverTrackService representDiscoverTrackService;

    /**
     * 查询【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('system:track:list')")
    @GetMapping("/list")
    public TableDataInfo list(RepresentDiscoverTrack representDiscoverTrack)
    {
        startPage();
        List<RepresentDiscoverTrack> list = representDiscoverTrackService.selectRepresentDiscoverTrackList(representDiscoverTrack);
        return getDataTable(list);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('system:track:export')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, RepresentDiscoverTrack representDiscoverTrack)
    {
        List<RepresentDiscoverTrack> list = representDiscoverTrackService.selectRepresentDiscoverTrackList(representDiscoverTrack);
        ExcelUtil<RepresentDiscoverTrack> util = new ExcelUtil<RepresentDiscoverTrack>(RepresentDiscoverTrack.class);
        util.exportExcel(response, list, "【请填写功能名称】数据");
    }

    /**
     * 获取【请填写功能名称】详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:track:query')")
    @GetMapping(value = "/{trackId}")
    public AjaxResult getInfo(@PathVariable("trackId") Long trackId)
    {
        return AjaxResult.success(representDiscoverTrackService.selectRepresentDiscoverTrackByTrackId(trackId));
    }

    /**
     * 新增【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:track:add')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody RepresentDiscoverTrack representDiscoverTrack)
    {
        return toAjax(representDiscoverTrackService.insertRepresentDiscoverTrack(representDiscoverTrack));
    }

    /**
     * 修改【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:track:edit')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody RepresentDiscoverTrack representDiscoverTrack)
    {
        return toAjax(representDiscoverTrackService.updateRepresentDiscoverTrack(representDiscoverTrack));
    }

    /**
     * 删除【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:track:remove')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
	@DeleteMapping("/{trackIds}")
    public AjaxResult remove(@PathVariable Long[] trackIds)
    {
        return toAjax(representDiscoverTrackService.deleteRepresentDiscoverTrackByTrackIds(trackIds));
    }
}
