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
import com.shahenpc.system.domain.personel.PersonnelAppointBill;
import com.shahenpc.system.service.personel.IPersonnelAppointBillService;
import com.shahenpc.common.utils.poi.ExcelUtil;
import com.shahenpc.common.core.page.TableDataInfo;

/**
 * 人事任免_议案提请Controller
 * 
 * @author ruoyi
 * @date 2022-07-04
 */
@Api(tags = "人事任免_议案提请 Done √")
@RestController
@RequestMapping("/system/bill")
public class PersonnelAppointBillController extends BaseController
{
    @Autowired
    private IPersonnelAppointBillService personnelAppointBillService;

    /**
     * 查询人事任免_议案提请列表
     */
    @PreAuthorize("@ss.hasPermi('system:bill:list')")
    @GetMapping("/list")
    @ApiOperation("查询-议案提请")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "nickName", value = "人员姓名", dataType = "String", dataTypeClass = String.class),
            @ApiImplicitParam(name = "appointType", value = "任免类型", dataType = "Integer", dataTypeClass = String.class),
            @ApiImplicitParam(name = "keyWords", value = "关键词", dataType = "String", dataTypeClass = String.class),
            @ApiImplicitParam(name = "startTime", value = "开始时间", dataType = "String", dataTypeClass = Date.class),
            @ApiImplicitParam(name = "endTime", value = "结束时间", dataType = "String", dataTypeClass = Date.class)
    })
    public TableDataInfo list(PersonnelQueryDto personnelAppointBill)
    {
        startPage();
        List<PersonnelAppointBill> list = personnelAppointBillService.selectPersonnelAppointBillList(personnelAppointBill);
        return getDataTable(list);
    }

    /**
     * 导出人事任免_议案提请列表
     */
    @PreAuthorize("@ss.hasPermi('system:bill:export')")
    @Log(title = "人事任免_议案提请", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, PersonnelQueryDto personnelAppointBill)
    {
        List<PersonnelAppointBill> list = personnelAppointBillService.selectPersonnelAppointBillList(personnelAppointBill);
        ExcelUtil<PersonnelAppointBill> util = new ExcelUtil<PersonnelAppointBill>(PersonnelAppointBill.class);
        util.exportExcel(response, list, "人事任免_议案提请数据");
    }

    /**
     * 获取人事任免_议案提请详细信息
     */

    @ApiOperation("详情-议案提请")
    @PreAuthorize("@ss.hasPermi('system:bill:query')")
    @GetMapping(value = "/{registerId}")
    public AjaxResult getInfo(@PathVariable("registerId") Long registerId)
    {
        return AjaxResult.success(personnelAppointBillService.selectPersonnelAppointBillByBillId(registerId));
    }

    /**
     * 新增人事任免_议案提请
     */
    @ApiOperation("新增-议案提请")
    @PreAuthorize("@ss.hasPermi('system:bill:add')")
    @Log(title = "人事任免_议案提请", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PersonnelAppointBill personnelAppointBill)
    {
        personnelAppointBill.setCreateBy(getUsername());
        return toAjax(personnelAppointBillService.insertPersonnelAppointBill(personnelAppointBill));
    }

    /**
     * 修改人事任免_议案提请
     */
    @ApiOperation("更新-议案提请")
    @PreAuthorize("@ss.hasPermi('system:bill:edit')")
    @Log(title = "人事任免_议案提请", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PersonnelAppointBill personnelAppointBill)
    {
        personnelAppointBill.setUpdateBy(getUsername());
        return toAjax(personnelAppointBillService.updatePersonnelAppointBill(personnelAppointBill));
    }

    /**
     * 删除人事任免_议案提请
     */
    @ApiOperation("删除-议案提请")
    @PreAuthorize("@ss.hasPermi('system:bill:remove')")
    @Log(title = "人事任免_议案提请", businessType = BusinessType.DELETE)
	@DeleteMapping("/{registerIds}")
    public AjaxResult remove(@PathVariable Long[] registerIds)
    {
        return toAjax(personnelAppointBillService.deletePersonnelAppointBillByBillIds(registerIds));
    }
}
