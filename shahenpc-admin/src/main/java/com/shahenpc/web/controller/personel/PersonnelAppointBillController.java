package com.shahenpc.web.controller.personel;

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
    public TableDataInfo list(PersonnelAppointBill personnelAppointBill)
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
    public void export(HttpServletResponse response, PersonnelAppointBill personnelAppointBill)
    {
        List<PersonnelAppointBill> list = personnelAppointBillService.selectPersonnelAppointBillList(personnelAppointBill);
        ExcelUtil<PersonnelAppointBill> util = new ExcelUtil<PersonnelAppointBill>(PersonnelAppointBill.class);
        util.exportExcel(response, list, "人事任免_议案提请数据");
    }

    /**
     * 获取人事任免_议案提请详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:bill:query')")
    @GetMapping(value = "/{billId}")
    public AjaxResult getInfo(@PathVariable("billId") Long billId)
    {
        return AjaxResult.success(personnelAppointBillService.selectPersonnelAppointBillByBillId(billId));
    }

    /**
     * 新增人事任免_议案提请
     */
    @PreAuthorize("@ss.hasPermi('system:bill:add')")
    @Log(title = "人事任免_议案提请", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PersonnelAppointBill personnelAppointBill)
    {
        return toAjax(personnelAppointBillService.insertPersonnelAppointBill(personnelAppointBill));
    }

    /**
     * 修改人事任免_议案提请
     */
    @PreAuthorize("@ss.hasPermi('system:bill:edit')")
    @Log(title = "人事任免_议案提请", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PersonnelAppointBill personnelAppointBill)
    {
        return toAjax(personnelAppointBillService.updatePersonnelAppointBill(personnelAppointBill));
    }

    /**
     * 删除人事任免_议案提请
     */
    @PreAuthorize("@ss.hasPermi('system:bill:remove')")
    @Log(title = "人事任免_议案提请", businessType = BusinessType.DELETE)
	@DeleteMapping("/{billIds}")
    public AjaxResult remove(@PathVariable Long[] billIds)
    {
        return toAjax(personnelAppointBillService.deletePersonnelAppointBillByBillIds(billIds));
    }
}
