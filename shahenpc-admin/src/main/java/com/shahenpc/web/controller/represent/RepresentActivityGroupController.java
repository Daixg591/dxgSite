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
import com.shahenpc.system.domain.represent.RepresentActivityGroup;
import com.shahenpc.system.service.represent.IRepresentActivityGroupService;
import com.shahenpc.common.utils.poi.ExcelUtil;
import com.shahenpc.common.core.page.TableDataInfo;

/**
 * 【代表认领/活动分组】Controller
 *
 * @author ruoyi
 * @date 2022-12-12
 */
@RestController
@RequestMapping("/represent/group")
public class RepresentActivityGroupController extends BaseController {
    @Autowired
    private IRepresentActivityGroupService representActivityGroupService;

    /**
     * 查询【代表认领/活动分组】列表
     */
    @PreAuthorize("@ss.hasPermi('system:group:list')")
    @GetMapping("/list")
    public TableDataInfo list(RepresentActivityGroup representActivityGroup) {
        startPage();
        List<RepresentActivityGroup> list = representActivityGroupService.selectRepresentActivityGroupList(representActivityGroup);
        return getDataTable(list);
    }

    /**
     * 导出【代表认领/活动分组】列表
     */
    @PreAuthorize("@ss.hasPermi('system:group:export')")
    @Log(title = "【代表认领/活动分组】", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, RepresentActivityGroup representActivityGroup) {
        List<RepresentActivityGroup> list = representActivityGroupService.selectRepresentActivityGroupList(representActivityGroup);
        ExcelUtil<RepresentActivityGroup> util = new ExcelUtil<RepresentActivityGroup>(RepresentActivityGroup.class);
        util.exportExcel(response, list, "【代表认领/活动分组】数据");
    }

    /**
     * 获取【代表认领/活动分组】详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:group:query')")
    @GetMapping(value = "/{activityGroupId}")
    public AjaxResult getInfo(@PathVariable("activityGroupId") Long activityGroupId) {
        return AjaxResult.success(representActivityGroupService.selectRepresentActivityGroupByActivityGroupId(activityGroupId));
    }

    /**
     * 新增【代表认领/活动分组】
     */
    @PreAuthorize("@ss.hasPermi('system:group:add')")
    @Log(title = "【代表认领/活动分组】", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody RepresentActivityGroup representActivityGroup) {
        representActivityGroup.setCreateBy(getLoginUser().getNickName());
        return AjaxResult.success(representActivityGroupService.insertRepresentActivityGroup(representActivityGroup));
    }

    /**
     * 修改【代表认领/活动分组】
     */
    @PreAuthorize("@ss.hasPermi('system:group:edit')")
    @Log(title = "【代表认领/活动分组】", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody RepresentActivityGroup representActivityGroup) {
        return toAjax(representActivityGroupService.updateRepresentActivityGroup(representActivityGroup));
    }

    /**
     * 删除【代表认领/活动分组】
     */
    @PreAuthorize("@ss.hasPermi('system:group:remove')")
    @Log(title = "【代表认领/活动分组】", businessType = BusinessType.DELETE)
    @DeleteMapping("/{activityGroupIds}")
    public AjaxResult remove(@PathVariable Long[] activityGroupIds) {
        return toAjax(representActivityGroupService.deleteRepresentActivityGroupByActivityGroupIds(activityGroupIds));
    }
}
