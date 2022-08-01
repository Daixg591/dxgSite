package com.shahenpc.app.controller.represent;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.shahenpc.system.domain.represent.dto.WorkLogListDto;
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
import com.shahenpc.system.domain.represent.RepresentWorkLog;
import com.shahenpc.system.service.represent.IRepresentWorkLogService;
import com.shahenpc.common.utils.poi.ExcelUtil;
import com.shahenpc.common.core.page.TableDataInfo;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "app工作日志")
@RestController
@RequestMapping("/app/represent/work/log")
public class AppRepresentWorkLogController extends BaseController{

    @Autowired
    private IRepresentWorkLogService representWorkLogService;

    /**
     * 查询代履职日志列表
     */
    @PreAuthorize("@ss.hasPermi('system:log:list')")
    @GetMapping("/list")
    public TableDataInfo list(RepresentWorkLog representWorkLog)
    {
        startPage();
        representWorkLog.setUserId(getUserId());
        List<WorkLogListDto> list = representWorkLogService.appList(representWorkLog);
        return getDataTable(list);
    }

    /**
     * 导出代履职日志列表
     */
    @PreAuthorize("@ss.hasPermi('system:log:export')")
    @Log(title = "代履职日志", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, RepresentWorkLog representWorkLog)
    {
        List<RepresentWorkLog> list = representWorkLogService.selectRepresentWorkLogList(representWorkLog);
        ExcelUtil<RepresentWorkLog> util = new ExcelUtil<RepresentWorkLog>(RepresentWorkLog.class);
        util.exportExcel(response, list, "代履职日志数据");
    }

    /**
     * 获取代履职日志详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:log:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(representWorkLogService.selectRepresentWorkLogById(id));
    }

    /**
     * 新增代履职日志
     */
    @PreAuthorize("@ss.hasPermi('system:log:add')")
    @Log(title = "代履职日志", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody RepresentWorkLog representWorkLog)
    {
        return toAjax(representWorkLogService.insertRepresentWorkLog(representWorkLog));
    }

    /**
     * 修改代履职日志
     */
    @PreAuthorize("@ss.hasPermi('system:log:edit')")
    @Log(title = "代履职日志", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody RepresentWorkLog representWorkLog)
    {
        return toAjax(representWorkLogService.updateRepresentWorkLog(representWorkLog));
    }

    /**
     * 删除代履职日志
     */
    @PreAuthorize("@ss.hasPermi('system:log:remove')")
    @Log(title = "代履职日志", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(representWorkLogService.deleteRepresentWorkLogByIds(ids));
    }
}
