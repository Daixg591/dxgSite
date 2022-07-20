package com.shahenpc.web.controller.oa;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import io.swagger.annotations.Api;
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
import com.shahenpc.system.domain.oa.OaMeetingPersonnel;
import com.shahenpc.system.service.oa.IOaMeetingPersonnelService;
import com.shahenpc.common.utils.poi.ExcelUtil;
import com.shahenpc.common.core.page.TableDataInfo;

/**
 * 会议人员Controller
 * 
 * @author ruoyi
 * @date 2022-07-19
 */
@Api(tags = "会议管理人员表")
@RestController
@RequestMapping("/oa/personnel")
public class OaMeetingPersonnelController extends BaseController
{
    @Autowired
    private IOaMeetingPersonnelService oaMeetingPersonnelService;

    /**
     * 查询会议人员列表
     */
    @PreAuthorize("@ss.hasPermi('oa:personnel:list')")
    @GetMapping("/list")
    public TableDataInfo list(OaMeetingPersonnel oaMeetingPersonnel)
    {
        startPage();
        List<OaMeetingPersonnel> list = oaMeetingPersonnelService.selectOaMeetingPersonnelList(oaMeetingPersonnel);
        return getDataTable(list);
    }

    /**
     * 导出会议人员列表
     */
    @PreAuthorize("@ss.hasPermi('oa:personnel:export')")
    @Log(title = "会议人员", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, OaMeetingPersonnel oaMeetingPersonnel)
    {
        List<OaMeetingPersonnel> list = oaMeetingPersonnelService.selectOaMeetingPersonnelList(oaMeetingPersonnel);
        ExcelUtil<OaMeetingPersonnel> util = new ExcelUtil<OaMeetingPersonnel>(OaMeetingPersonnel.class);
        util.exportExcel(response, list, "会议人员数据");
    }

    /**
     * 获取会议人员详细信息
     */
    @PreAuthorize("@ss.hasPermi('oa:personnel:query')")
    @GetMapping(value = "/{personnelId}")
    public AjaxResult getInfo(@PathVariable("personnelId") Long personnelId)
    {
        return AjaxResult.success(oaMeetingPersonnelService.selectOaMeetingPersonnelByPersonnelId(personnelId));
    }

    /**
     * 新增会议人员
     */
    @PreAuthorize("@ss.hasPermi('oa:personnel:add')")
    @Log(title = "会议人员", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody OaMeetingPersonnel oaMeetingPersonnel)
    {
        return toAjax(oaMeetingPersonnelService.insertOaMeetingPersonnel(oaMeetingPersonnel));
    }

    /**
     * 修改会议人员
     */
    @PreAuthorize("@ss.hasPermi('oa:personnel:edit')")
    @Log(title = "会议人员", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody OaMeetingPersonnel oaMeetingPersonnel)
    {
        return toAjax(oaMeetingPersonnelService.updateOaMeetingPersonnel(oaMeetingPersonnel));
    }

    /**
     * 删除会议人员
     */
    @PreAuthorize("@ss.hasPermi('oa:personnel:remove')")
    @Log(title = "会议人员", businessType = BusinessType.DELETE)
	@DeleteMapping("/{personnelIds}")
    public AjaxResult remove(@PathVariable Long[] personnelIds)
    {
        return toAjax(oaMeetingPersonnelService.deleteOaMeetingPersonnelByPersonnelIds(personnelIds));
    }
}
