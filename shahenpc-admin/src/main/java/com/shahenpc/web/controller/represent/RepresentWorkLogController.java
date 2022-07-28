package com.shahenpc.web.controller.represent;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.shahenpc.system.domain.represent.dto.PerformDutieRankingDto;
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
import com.shahenpc.system.domain.represent.RepresentWorkLog;
import com.shahenpc.system.service.represent.IRepresentWorkLogService;
import com.shahenpc.common.utils.poi.ExcelUtil;
import com.shahenpc.common.core.page.TableDataInfo;

/**
 * 代履职日志Controller
 * 
 * @author ruoyi
 * @date 2022-07-28
 */
@Api(tags = "履职日志")
@RestController
@RequestMapping("/work/log")
public class RepresentWorkLogController extends BaseController
{
    @Autowired
    private IRepresentWorkLogService representWorkLogService;

    /**
     * 查询代履职日志列表
     */
    @ApiOperation("列表")
    @PreAuthorize("@ss.hasPermi('work:log:list')")
    @GetMapping("/list")
    public TableDataInfo list(RepresentWorkLog representWorkLog)
    {
        startPage();
        List<RepresentWorkLog> list = representWorkLogService.selectRepresentWorkLogList(representWorkLog);
        return getDataTable(list);
    }

    /**
     * 导出代履职日志列表
     */
    @ApiOperation("导出")
    @PreAuthorize("@ss.hasPermi('work:log:export')")
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
    @ApiOperation("详情")
    @PreAuthorize("@ss.hasPermi('work:log:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(representWorkLogService.selectRepresentWorkLogById(id));
    }

    /**
     * 新增代履职日志
     */
    @ApiOperation("新增")
    @PreAuthorize("@ss.hasPermi('work:log:add')")
    @Log(title = "代履职日志", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody RepresentWorkLog representWorkLog)
    {
        return toAjax(representWorkLogService.insertRepresentWorkLog(representWorkLog));
    }

    /**
     * 修改代履职日志
     */
    @ApiOperation("修改")
    @PreAuthorize("@ss.hasPermi('work:log:edit')")
    @Log(title = "代履职日志", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody RepresentWorkLog representWorkLog)
    {
        return toAjax(representWorkLogService.updateRepresentWorkLog(representWorkLog));
    }

    /**
     * 删除代履职日志
     */
    @ApiOperation("删除")
    @PreAuthorize("@ss.hasPermi('work:log:remove')")
    @Log(title = "代履职日志", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(representWorkLogService.deleteRepresentWorkLogByIds(ids));
    }

    @ApiOperation("排行")
    @GetMapping("/ranking")
    public TableDataInfo ranking(){
        startPage();
        List<PerformDutieRankingDto> list=  representWorkLogService.ranking();
        return getDataTable(list);
    }
}
