package com.shahenpc.web.controller.oa;

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
import com.shahenpc.system.domain.oa.OaMeetingSign;
import com.shahenpc.system.service.oa.IOaMeetingSignService;
import com.shahenpc.common.utils.poi.ExcelUtil;
import com.shahenpc.common.core.page.TableDataInfo;

/**
 * 会议签到记录Controller
 * 
 * @author ruoyi
 * @date 2022-07-19
 */
@Api(tags = "会议签到管理")
@RestController
@RequestMapping("/oa/sign")
public class OaMeetingSignController extends BaseController
{
    @Autowired
    private IOaMeetingSignService oaMeetingSignService;

    /**
     * 查询会议签到记录列表
     */
    @ApiOperation("列表")
    @PreAuthorize("@ss.hasPermi('oa:sign:list')")
    @GetMapping("/list")
    public TableDataInfo list(OaMeetingSign oaMeetingSign)
    {
        startPage();
        List<OaMeetingSign> list = oaMeetingSignService.selectOaMeetingSignList(oaMeetingSign);
        return getDataTable(list);
    }

    /**
     * 导出会议签到记录列表
     */
    @ApiOperation("导出")
    @PreAuthorize("@ss.hasPermi('oa:sign:export')")
    @Log(title = "会议签到记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, OaMeetingSign oaMeetingSign)
    {
        List<OaMeetingSign> list = oaMeetingSignService.selectOaMeetingSignList(oaMeetingSign);
        ExcelUtil<OaMeetingSign> util = new ExcelUtil<OaMeetingSign>(OaMeetingSign.class);
        util.exportExcel(response, list, "会议签到记录数据");
    }

    /**
     * 获取会议签到记录详细信息
     */
    @ApiOperation("详情")
    @PreAuthorize("@ss.hasPermi('oa:sign:query')")
    @GetMapping(value = "/{signId}")
    public AjaxResult getInfo(@PathVariable("signId") Long signId)
    {
        return AjaxResult.success(oaMeetingSignService.selectOaMeetingSignBySignId(signId));
    }

    /**
     * 新增会议签到记录
     */
    @ApiOperation("新增")
    @PreAuthorize("@ss.hasPermi('oa:sign:add')")
    @Log(title = "会议签到记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody OaMeetingSign oaMeetingSign)
    {
        return toAjax(oaMeetingSignService.insertOaMeetingSign(oaMeetingSign));
    }

    /**
     * 修改会议签到记录
     */
    @ApiOperation("修改")
    @PreAuthorize("@ss.hasPermi('oa:sign:edit')")
    @Log(title = "会议签到记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody OaMeetingSign oaMeetingSign)
    {
        return toAjax(oaMeetingSignService.updateOaMeetingSign(oaMeetingSign));
    }

    /**
     * 删除会议签到记录
     */
    @ApiOperation("删除")
    @PreAuthorize("@ss.hasPermi('oa:sign:remove')")
    @Log(title = "会议签到记录", businessType = BusinessType.DELETE)
	@DeleteMapping("/{signIds}")
    public AjaxResult remove(@PathVariable Long[] signIds)
    {
        return toAjax(oaMeetingSignService.deleteOaMeetingSignBySignIds(signIds));
    }

    @ApiOperation("签到")
    @GetMapping("/sign/{meetingId}")
    public AjaxResult sign(@PathVariable("meetingId")Long meetingId)
    {
        return oaMeetingSignService.sign(meetingId,getUserId());
    }
}
