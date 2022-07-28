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
import com.shahenpc.system.domain.represent.RepresentExperience;
import com.shahenpc.system.service.represent.IRepresentExperienceService;
import com.shahenpc.common.utils.poi.ExcelUtil;
import com.shahenpc.common.core.page.TableDataInfo;

/**
 * 代履职体会Controller
 * 
 * @author ruoyi
 * @date 2022-07-26
 */
@Api(tags = "代表履职体会")
@RestController
@RequestMapping("/represent/experience")
public class RepresentExperienceController extends BaseController
{
    @Autowired
    private IRepresentExperienceService representExperienceService;

    /**
     * 查询代履职体会列表
     */
    @ApiOperation("列表")
    @PreAuthorize("@ss.hasPermi('represent:experience:list')")
    @GetMapping("/list")
    public TableDataInfo list(RepresentExperience representExperience)
    {
        startPage();
        List<RepresentExperience> list = representExperienceService.selectRepresentExperienceList(representExperience);
        return getDataTable(list);
    }

    /**
     * 导出代履职体会列表
     */
    @ApiOperation("导出")
    @PreAuthorize("@ss.hasPermi('represent:experience:export')")
    @Log(title = "代履职体会", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, RepresentExperience representExperience)
    {
        List<RepresentExperience> list = representExperienceService.selectRepresentExperienceList(representExperience);
        ExcelUtil<RepresentExperience> util = new ExcelUtil<RepresentExperience>(RepresentExperience.class);
        util.exportExcel(response, list, "代履职体会数据");
    }

    /**
     * 获取代履职体会详细信息
     */
    @ApiOperation("详情")
    @PreAuthorize("@ss.hasPermi('represent:experience:query')")
    @GetMapping(value = "/{experienceId}")
    public AjaxResult getInfo(@PathVariable("experienceId") Long experienceId)
    {
        return AjaxResult.success(representExperienceService.selectRepresentExperienceByExperienceId(experienceId));
    }

    /**
     * 新增代履职体会
     */
    @ApiOperation("新增")
    @PreAuthorize("@ss.hasPermi('represent:experience:add')")
    @Log(title = "代履职体会", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody RepresentExperience representExperience)
    {
        return toAjax(representExperienceService.insertRepresentExperience(representExperience));
    }

    /**
     * 修改代履职体会
     */
    @ApiOperation("修改")
    @PreAuthorize("@ss.hasPermi('represent:experience:edit')")
    @Log(title = "代履职体会", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody RepresentExperience representExperience)
    {
        return toAjax(representExperienceService.updateRepresentExperience(representExperience));
    }

    /**
     * 删除代履职体会
     */
    @ApiOperation("删除")
    @PreAuthorize("@ss.hasPermi('represent:experience:remove')")
    @Log(title = "代履职体会", businessType = BusinessType.DELETE)
	@DeleteMapping("/{experienceIds}")
    public AjaxResult remove(@PathVariable Long[] experienceIds)
    {
        return toAjax(representExperienceService.deleteRepresentExperienceByExperienceIds(experienceIds));
    }
}
