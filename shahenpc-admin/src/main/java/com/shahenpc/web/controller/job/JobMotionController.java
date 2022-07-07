package com.shahenpc.web.controller.job;

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
import com.shahenpc.system.domain.job.JobMotion;
import com.shahenpc.system.service.job.IJobMotionService;
import com.shahenpc.common.utils.poi.ExcelUtil;
import com.shahenpc.common.core.page.TableDataInfo;

/**
 * 工作-建议议案处理Controller
 * 
 * @author ruoyi
 * @date 2022-07-06
 */
@RestController
@RequestMapping("/system/motion")
public class JobMotionController extends BaseController
{
    @Autowired
    private IJobMotionService jobMotionService;

    /**
     * 查询工作-建议议案处理列表
     */
    @PreAuthorize("@ss.hasPermi('system:motion:list')")
    @GetMapping("/list")
    public TableDataInfo list(JobMotion jobMotion)
    {
        startPage();
        List<JobMotion> list = jobMotionService.selectJobMotionList(jobMotion);
        return getDataTable(list);
    }

    /**
     * 导出工作-建议议案处理列表
     */
    @PreAuthorize("@ss.hasPermi('system:motion:export')")
    @Log(title = "工作-建议议案处理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, JobMotion jobMotion)
    {
        List<JobMotion> list = jobMotionService.selectJobMotionList(jobMotion);
        ExcelUtil<JobMotion> util = new ExcelUtil<JobMotion>(JobMotion.class);
        util.exportExcel(response, list, "工作-建议议案处理数据");
    }

    /**
     * 获取工作-建议议案处理详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:motion:query')")
    @GetMapping(value = "/{motionId}")
    public AjaxResult getInfo(@PathVariable("motionId") Long motionId)
    {
        return AjaxResult.success(jobMotionService.selectJobMotionByMotionId(motionId));
    }

    /**
     * 新增工作-建议议案处理
     */
    @PreAuthorize("@ss.hasPermi('system:motion:add')")
    @Log(title = "工作-建议议案处理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody JobMotion jobMotion)
    {
        return toAjax(jobMotionService.insertJobMotion(jobMotion));
    }

    /**
     * 修改工作-建议议案处理
     */
    @PreAuthorize("@ss.hasPermi('system:motion:edit')")
    @Log(title = "工作-建议议案处理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody JobMotion jobMotion)
    {
        return toAjax(jobMotionService.updateJobMotion(jobMotion));
    }

    /**
     * 删除工作-建议议案处理
     */
    @PreAuthorize("@ss.hasPermi('system:motion:remove')")
    @Log(title = "工作-建议议案处理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{motionIds}")
    public AjaxResult remove(@PathVariable Long[] motionIds)
    {
        return toAjax(jobMotionService.deleteJobMotionByMotionIds(motionIds));
    }
}
