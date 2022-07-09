package com.shahenpc.web.controller.personel;

import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.shahenpc.system.domain.personel.dto.PersonnelQueryDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
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
import com.shahenpc.system.domain.personel.PersonnelAppointEvaluteRes;
import com.shahenpc.system.service.personel.IPersonnelAppointEvaluteResService;
import com.shahenpc.common.utils.poi.ExcelUtil;
import com.shahenpc.common.core.page.TableDataInfo;

/**
 * 人事任免_评议结果Controller
 * 
 * @author ruoyi
 * @date 2022-07-07
 */
@RestController
@RequestMapping("/system/appointmentRes")
@Api(tags = "人事任免_评议结果 Done √")
public class PersonnelAppointEvaluteResController extends BaseController
{
    @Autowired
    private IPersonnelAppointEvaluteResService personnelAppointEvaluteResService;

    /**
     * 查询人事任免_评议结果列表
     */
    @PreAuthorize("@ss.hasPermi('system:appointmentRes:list')")
    @GetMapping("/list")
    @ApiOperation("查询-评议结果")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "nickName", value = "人员姓名", dataType = "String", dataTypeClass = String.class),
            @ApiImplicitParam(name = "appointType", value = "任免类型", dataType = "Integer", dataTypeClass = String.class),
            @ApiImplicitParam(name = "keyWords", value = "关键词", dataType = "String", dataTypeClass = String.class),
            @ApiImplicitParam(name = "startTime", value = "开始时间", dataType = "String", dataTypeClass = Date.class),
            @ApiImplicitParam(name = "endTime", value = "结束时间", dataType = "String", dataTypeClass = Date.class),
            @ApiImplicitParam(name = "registerId", value = "任免记录Id", dataType = "Integer", dataTypeClass = Integer.class)
    })
    public TableDataInfo list(PersonnelQueryDto personnelAppointEvaluteRes)
    {
        startPage();
        List<PersonnelAppointEvaluteRes> list = personnelAppointEvaluteResService.selectPersonnelAppointEvaluteResList(personnelAppointEvaluteRes);
        return getDataTable(list);
    }

    /**
     * 导出人事任免_评议结果列表
     */
    @PreAuthorize("@ss.hasPermi('system:appointmentRes:export')")
    @Log(title = "人事任免_评议结果", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, PersonnelQueryDto personnelAppointEvaluteRes)
    {
        List<PersonnelAppointEvaluteRes> list = personnelAppointEvaluteResService.selectPersonnelAppointEvaluteResList(personnelAppointEvaluteRes);
        ExcelUtil<PersonnelAppointEvaluteRes> util = new ExcelUtil<PersonnelAppointEvaluteRes>(PersonnelAppointEvaluteRes.class);
        util.exportExcel(response, list, "人事任免_评议结果数据");
    }

    /**
     * 获取人事任免_评议结果详细信息
     */
    @ApiOperation("详情-评议结果")
    @PreAuthorize("@ss.hasPermi('system:appointmentRes:query')")
    @GetMapping(value = "/{resId}")
    public AjaxResult getInfo(@PathVariable("resId") Long resId)
    {
        return AjaxResult.success(personnelAppointEvaluteResService.selectPersonnelAppointEvaluteResByResId(resId));
    }

    /**
     * 新增人事任免_评议结果
     */
    @PreAuthorize("@ss.hasPermi('system:appointmentRes:add')")
    @ApiOperation("新增-评议结果")
    @Log(title = "人事任免_评议结果", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PersonnelAppointEvaluteRes personnelAppointEvaluteRes)
    {
        personnelAppointEvaluteRes.setCreateBy(getUsername());
        return toAjax(personnelAppointEvaluteResService.insertPersonnelAppointEvaluteRes(personnelAppointEvaluteRes));
    }

    /**
     * 修改人事任免_评议结果
     */
    @PreAuthorize("@ss.hasPermi('system:appointmentRes:edit')")
    @ApiOperation("更新-评议结果")
    @Log(title = "人事任免_评议结果", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PersonnelAppointEvaluteRes personnelAppointEvaluteRes)
    {
        personnelAppointEvaluteRes.setUpdateBy(getUsername());
        return toAjax(personnelAppointEvaluteResService.updatePersonnelAppointEvaluteRes(personnelAppointEvaluteRes));
    }

    /**
     * 删除人事任免_评议结果
     */
    @PreAuthorize("@ss.hasPermi('system:appointmentRes:remove')")
    @Log(title = "人事任免_评议结果", businessType = BusinessType.DELETE)
    @ApiOperation("删除-评议结果")
	@DeleteMapping("/{resIds}")
    public AjaxResult remove(@PathVariable Long[] resIds)
    {
        return toAjax(personnelAppointEvaluteResService.deletePersonnelAppointEvaluteResByResIds(resIds));
    }
}
