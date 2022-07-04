package com.shahenpc.web.controller.personel;

import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;

import com.shahenpc.common.core.domain.entity.SysUser;
import com.shahenpc.system.domain.BackVo.PersonalInfo;
import com.shahenpc.system.domain.personel.PersonnelAppointEduLog;
import com.shahenpc.system.service.ISysUserService;
import com.shahenpc.system.service.personel.IPersonnelAppointEduLogService;
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
import com.shahenpc.system.domain.personel.PersonnelAppointRegister;
import com.shahenpc.system.service.personel.IPersonnelAppointRegisterService;
import com.shahenpc.common.utils.poi.ExcelUtil;
import com.shahenpc.common.core.page.TableDataInfo;

/**
 * 人事任免_任免记录Controller
 * 
 * @author ruoyi
 * @date 2022-07-04
 */
@Api(tags="人事任免_信息登记")
@ApiOperation("人事任免_信息登记")
@RestController
@RequestMapping("/system/register")
public class PersonnelAppointRegisterController extends BaseController
{
    @Autowired
    private IPersonnelAppointRegisterService personnelAppointRegisterService;

    @Autowired
    private ISysUserService userService;

    @Autowired
    private IPersonnelAppointEduLogService eduLogService;

    /**
     * 查询人事任免_任免记录列表
     */

    @PreAuthorize("@ss.hasPermi('system:register:list')")
    @GetMapping("/list")
    @ApiOperation("任免列表")
    public TableDataInfo list(PersonnelAppointRegister personnelAppointRegister)
    {
        startPage();
        List<PersonnelAppointRegister> list = personnelAppointRegisterService.selectPersonnelAppointRegisterList(personnelAppointRegister);

        return getDataTable(list);
    }

    /**
     * 导出人事任免_任免记录列表
     */
    @PreAuthorize("@ss.hasPermi('system:register:export')")
    @ApiOperation("批量导出")
    @Log(title = "人事任免_任免记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, PersonnelAppointRegister personnelAppointRegister)
    {
        List<PersonnelAppointRegister> list = personnelAppointRegisterService.selectPersonnelAppointRegisterList(personnelAppointRegister);
        ExcelUtil<PersonnelAppointRegister> util = new ExcelUtil<PersonnelAppointRegister>(PersonnelAppointRegister.class);
        util.exportExcel(response, list, "人事任免_任免记录数据");
    }

    /**
     * 获取人事任免_任免记录详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:register:query')")
    @GetMapping(value = "/{registerId}")
    @ApiOperation("任免详情")
    public AjaxResult getInfo(@PathVariable("registerId") Long registerId)
    {
        PersonnelAppointRegister regEntity=personnelAppointRegisterService.selectPersonnelAppointRegisterByRegisterId(registerId);
        SysUser userEntity=userService.selectUserById(regEntity.getUserId());
        List<PersonnelAppointEduLog> eduList=eduLogService.selectPersonnelAppointEduLogList(null);

        PersonalInfo res=new PersonalInfo();
        res.setRegEntity(regEntity);
       regEntity.setSysUser(userEntity);
        res.setEduLogList(eduList);

        return AjaxResult.success(res);
    }

    /**
     * 新增人事任免_任免记录
     */
    @PreAuthorize("@ss.hasPermi('system:register:add')")
    @Log(title = "人事任免_任免记录", businessType = BusinessType.INSERT)
    @ApiOperation("新增任免")
    @PostMapping
    public AjaxResult add(@RequestBody PersonnelAppointRegister personnelAppointRegister)
    {
        return toAjax(personnelAppointRegisterService.insertPersonnelAppointRegister(personnelAppointRegister));
    }

    /**
     * 修改人事任免_任免记录
     */
    @ApiOperation("更新任免")
    @PreAuthorize("@ss.hasPermi('system:register:edit')")
    @Log(title = "人事任免_任免记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PersonnelAppointRegister personnelAppointRegister)
    {
        return toAjax(personnelAppointRegisterService.updatePersonnelAppointRegister(personnelAppointRegister));
    }

    /**
     * 删除人事任免_任免记录
     */
    @ApiOperation("删除任免")
    @PreAuthorize("@ss.hasPermi('system:register:remove')")
    @Log(title = "人事任免_任免记录", businessType = BusinessType.DELETE)
	@DeleteMapping("/{registerIds}")
    public AjaxResult remove(@PathVariable Long[] registerIds)
    {
        return toAjax(personnelAppointRegisterService.deletePersonnelAppointRegisterByRegisterIds(registerIds));
    }
}
