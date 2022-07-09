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
import com.shahenpc.system.domain.personel.PersonnelAppointAppointment;
import com.shahenpc.system.service.personel.IPersonnelAppointAppointmentService;
import com.shahenpc.common.utils.poi.ExcelUtil;
import com.shahenpc.common.core.page.TableDataInfo;

/**
 * 人事任免_颁发任命书Controller
 * 
 * @author ruoyi
 * @date 2022-07-06
 */
@RestController
@RequestMapping("/system/appointment")
@Api(tags = "人事任免_颁发任命书_Done √")
public class PersonnelAppointAppointmentController extends BaseController
{
    @Autowired
    private IPersonnelAppointAppointmentService personnelAppointAppointmentService;

    /**
     * 查询人事任免_颁发任命书列表
     */
    @PreAuthorize("@ss.hasPermi('system:appointment:list')")
    @GetMapping("/list")
    @ApiOperation("查询-颁发任命书")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "nickName", value = "人员姓名", dataType = "String", dataTypeClass = String.class),
            @ApiImplicitParam(name = "appointType", value = "任免类型", dataType = "Integer", dataTypeClass = String.class),
            @ApiImplicitParam(name = "keyWords", value = "关键词", dataType = "String", dataTypeClass = String.class),
            @ApiImplicitParam(name = "startTime", value = "开始时间", dataType = "String", dataTypeClass = Date.class),
            @ApiImplicitParam(name = "endTime", value = "结束时间", dataType = "String", dataTypeClass = Date.class)
    })
    public TableDataInfo list(PersonnelQueryDto personnelAppointAppointment)
    {
        startPage();
        List<PersonnelAppointAppointment> list = personnelAppointAppointmentService.selectPersonnelAppointAppointmentList(personnelAppointAppointment);
        return getDataTable(list);
    }

    /**
     * 导出人事任免_颁发任命书列表
     */
    @PreAuthorize("@ss.hasPermi('system:appointment:export')")
    @Log(title = "人事任免_颁发任命书", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, PersonnelQueryDto personnelAppointAppointment)
    {
        List<PersonnelAppointAppointment> list = personnelAppointAppointmentService.selectPersonnelAppointAppointmentList(personnelAppointAppointment);
        ExcelUtil<PersonnelAppointAppointment> util = new ExcelUtil<PersonnelAppointAppointment>(PersonnelAppointAppointment.class);
        util.exportExcel(response, list, "人事任免_颁发任命书数据");
    }

    /**
     * 获取人事任免_颁发任命书详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:appointment:query')")
    @GetMapping(value = "/{registerId}")
    @ApiOperation("详情-颁发任命书")
    public AjaxResult getInfo(@PathVariable("registerId") Long registerId)
    {
        return AjaxResult.success(personnelAppointAppointmentService.selectPersonnelAppointAppointmentByAppointmentId(registerId));
    }

    /**
     * 新增人事任免_颁发任命书
     */
    @PreAuthorize("@ss.hasPermi('system:appointment:add')")
    @Log(title = "人事任免_颁发任命书", businessType = BusinessType.INSERT)
    @ApiOperation("新增-颁发任命书")
    @PostMapping
    public AjaxResult add(@RequestBody PersonnelAppointAppointment personnelAppointAppointment)
    {
        personnelAppointAppointment.setCreateBy(getUsername());
        return toAjax(personnelAppointAppointmentService.insertPersonnelAppointAppointment(personnelAppointAppointment));
    }

    /**
     * 修改人事任免_颁发任命书
     */
    @PreAuthorize("@ss.hasPermi('system:appointment:edit')")
    @Log(title = "人事任免_颁发任命书", businessType = BusinessType.UPDATE)
    @ApiOperation("更新-颁发任命书")
    @PutMapping
    public AjaxResult edit(@RequestBody PersonnelAppointAppointment personnelAppointAppointment)
    {
        personnelAppointAppointment.setUpdateBy(getUsername());
        return toAjax(personnelAppointAppointmentService.updatePersonnelAppointAppointment(personnelAppointAppointment));
    }

    /**
     * 删除人事任免_颁发任命书
     */
    @PreAuthorize("@ss.hasPermi('system:appointment:remove')")
    @Log(title = "人事任免_颁发任命书", businessType = BusinessType.DELETE)
    @ApiOperation("删除-颁发任命书")
	@DeleteMapping("/{registerids}")
    public AjaxResult remove(@PathVariable Long[] registerids)
    {
        return toAjax(personnelAppointAppointmentService.deletePersonnelAppointAppointmentByAppointmentIds(registerids));
    }


}
