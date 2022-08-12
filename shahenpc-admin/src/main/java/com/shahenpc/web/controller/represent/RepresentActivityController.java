package com.shahenpc.web.controller.represent;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.shahenpc.flowable.service.IFlowTaskService;
import com.shahenpc.system.domain.represent.dto.ActivityAddDto;
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
import com.shahenpc.system.domain.represent.RepresentActivity;
import com.shahenpc.system.service.represent.IRepresentActivityService;
import com.shahenpc.common.utils.poi.ExcelUtil;
import com.shahenpc.common.core.page.TableDataInfo;

/**
 * 代-活动列Controller
 * 
 * @author ruoyi
 * @date 2022-07-21
 */
@Api(tags = "代表活动管理")
@RestController
@RequestMapping("/represent/activity")
public class RepresentActivityController extends BaseController
{
    @Autowired
    private IRepresentActivityService representActivityService;
    @Autowired
    private IFlowTaskService flowTaskService;
    /**
     * 查询代-活动列列表
     */
    @ApiOperation("列表")
    @PreAuthorize("@ss.hasPermi('represent:activity:list')")
    @GetMapping("/list")
    public TableDataInfo list(RepresentActivity representActivity)
    {
        startPage();
        List<RepresentActivity> list = representActivityService.selectRepresentActivityList(representActivity);
        return getDataTable(list);
    }

    /**
     * 导出代-活动列列表
     */
    @ApiOperation("导出")
    @PreAuthorize("@ss.hasPermi('represent:activity:export')")
    @Log(title = "代-活动列", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, RepresentActivity representActivity)
    {
        List<RepresentActivity> list = representActivityService.selectRepresentActivityList(representActivity);
        ExcelUtil<RepresentActivity> util = new ExcelUtil<RepresentActivity>(RepresentActivity.class);
        util.exportExcel(response, list, "代-活动列数据");
    }

    /**
     * 获取代-活动列详细信息
     */
    @ApiOperation("详情")
    @PreAuthorize("@ss.hasPermi('represent:activity:query')")
    @GetMapping(value = "/{activityId}")
    public AjaxResult getInfo(@PathVariable("activityId") Long activityId)
    {
        return AjaxResult.success(representActivityService.newDetail(activityId));
    }

    /**
     * 新增代-活动列
    @ApiOperation("新增")
    @PreAuthorize("@ss.hasPermi('represent:activity:add')")
    @Log(title = "代-活动列", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody RepresentActivity representActivity)
    {
        return toAjax(representActivityService.insertRepresentActivity(representActivity));
    }*/

    /**
     * 修改代-活动列
     */
    @ApiOperation("修改")
    @PreAuthorize("@ss.hasPermi('represent:activity:edit')")
    @Log(title = "代-活动列", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ActivityAddDto representActivity)
    {
        return toAjax(representActivityService.newUpdate(representActivity));
    }

    /**
     * 删除代-活动列
     */
    @ApiOperation("删除")
    @PreAuthorize("@ss.hasPermi('represent:activity:remove')")
    @Log(title = "代-活动列", businessType = BusinessType.DELETE)
	@DeleteMapping("/{activityIds}")
    public AjaxResult remove(@PathVariable Long[] activityIds)
    {
        return toAjax(representActivityService.deleteRepresentActivityByActivityIds(activityIds));
    }

    @ApiOperation("履职统计")
    @GetMapping("/count")
    public AjaxResult totalConut(){
        return AjaxResult.success(representActivityService.totalConut());
    }


    @ApiOperation("新增")
    @PreAuthorize("@ss.hasPermi('represent:activity:add')")
    @Log(title = "代-活动列", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ActivityAddDto representActivity)
    {
        representActivity.setSendUserId(getUserId());
        return toAjax(representActivityService.newAdd(representActivity));
    }


    @ApiOperation("分类饼图")
    @GetMapping(value = "/pie")
    public AjaxResult cake() {
        return AjaxResult.success(representActivityService.pie());
    }

}
