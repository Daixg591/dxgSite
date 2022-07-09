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
import com.shahenpc.system.domain.personel.PersonnelAppointVow;
import com.shahenpc.system.service.personel.IPersonnelAppointVowService;
import com.shahenpc.common.utils.poi.ExcelUtil;
import com.shahenpc.common.core.page.TableDataInfo;

/**
 * 人事任免_向宪法发誓Controller
 * 
 * @author ruoyi
 * @date 2022-07-06
 */
@RestController
@RequestMapping("/system/vow")
@Api(tags = "人事任免_向宪法发誓 Done √")
public class PersonnelAppointVowController extends BaseController
{
    @Autowired
    private IPersonnelAppointVowService personnelAppointVowService;

    /**
     * 查询人事任免_向宪法发誓列表
     */
    @PreAuthorize("@ss.hasPermi('system:vow:list')")
    @GetMapping("/list")
    @ApiOperation("查询-宪法发誓")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "nickName", value = "人员姓名", dataType = "String", dataTypeClass = String.class),
            @ApiImplicitParam(name = "appointType", value = "任免类型", dataType = "Integer", dataTypeClass = String.class),
            @ApiImplicitParam(name = "keyWords", value = "关键词", dataType = "String", dataTypeClass = String.class),
            @ApiImplicitParam(name = "startTime", value = "开始时间", dataType = "String", dataTypeClass = Date.class),
            @ApiImplicitParam(name = "endTime", value = "结束时间", dataType = "String", dataTypeClass = Date.class),
            @ApiImplicitParam(name = "registerId", value = "任免记录Id", dataType = "Integer", dataTypeClass = Integer.class)
    })
    public TableDataInfo list(PersonnelQueryDto personnelAppointVow)
    {
        startPage();
        List<PersonnelAppointVow> list = personnelAppointVowService.selectPersonnelAppointVowList(personnelAppointVow);
        return getDataTable(list);
    }

    /**
     * 导出人事任免_向宪法发誓列表
     */
    @PreAuthorize("@ss.hasPermi('system:vow:export')")
    @Log(title = "人事任免_向宪法发誓", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, PersonnelQueryDto personnelAppointVow)
    {
        List<PersonnelAppointVow> list = personnelAppointVowService.selectPersonnelAppointVowList(personnelAppointVow);
        ExcelUtil<PersonnelAppointVow> util = new ExcelUtil<PersonnelAppointVow>(PersonnelAppointVow.class);
        util.exportExcel(response, list, "人事任免_向宪法发誓数据");
    }

    /**
     * 获取人事任免_向宪法发誓详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:vow:query')")
    @GetMapping(value = "/{registerId}")
    @ApiOperation("详情-向宪法发誓")
    public AjaxResult getInfo(@PathVariable("registerId") Long registerId)
    {
        return AjaxResult.success(personnelAppointVowService.selectPersonnelAppointVowByVowId(registerId));
    }

    /**
     * 新增人事任免_向宪法发誓
     */
    @PreAuthorize("@ss.hasPermi('system:vow:add')")
    @Log(title = "人事任免_向宪法发誓", businessType = BusinessType.INSERT)
    @ApiOperation("新增-向宪法发誓")
    @PostMapping
    public AjaxResult add(@RequestBody PersonnelAppointVow personnelAppointVow)
    {
        personnelAppointVow.setCreateBy(getUsername());
        return toAjax(personnelAppointVowService.insertPersonnelAppointVow(personnelAppointVow));
    }

    /**
     * 修改人事任免_向宪法发誓
     */
    @PreAuthorize("@ss.hasPermi('system:vow:edit')")
    @Log(title = "人事任免_向宪法发誓", businessType = BusinessType.UPDATE)
    @ApiOperation("更新-向宪法发誓")
    @PutMapping
    public AjaxResult edit(@RequestBody PersonnelAppointVow personnelAppointVow)
    {
        personnelAppointVow.setUpdateBy(getUsername());
        return toAjax(personnelAppointVowService.updatePersonnelAppointVow(personnelAppointVow));
    }

    /**
     * 删除人事任免_向宪法发誓
     */
    @PreAuthorize("@ss.hasPermi('system:vow:remove')")
    @Log(title = "人事任免_向宪法发誓", businessType = BusinessType.DELETE)
    @ApiOperation("删除-向宪法发誓")
	@DeleteMapping("/{vowIds}")
    public AjaxResult remove(@PathVariable Long[] vowIds)
    {
        return toAjax(personnelAppointVowService.deletePersonnelAppointVowByVowIds(vowIds));
    }
}
