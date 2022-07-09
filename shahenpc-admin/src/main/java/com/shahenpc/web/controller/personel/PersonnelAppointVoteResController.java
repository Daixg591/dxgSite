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
import com.shahenpc.system.domain.personel.PersonnelAppointVoteRes;
import com.shahenpc.system.service.personel.IPersonnelAppointVoteResService;
import com.shahenpc.common.utils.poi.ExcelUtil;
import com.shahenpc.common.core.page.TableDataInfo;

/**
 * 人事任免_表决结果Controller
 * 
 * @author ruoyi
 * @date 2022-07-06
 */

@RestController
@RequestMapping("/system/res")
public class PersonnelAppointVoteResController extends BaseController
{
    @Autowired
    private IPersonnelAppointVoteResService personnelAppointVoteResService;

    /**
     * 查询人事任免_表决结果列表
     */
    @PreAuthorize("@ss.hasPermi('system:res:list')")
    @GetMapping("/list")
    public TableDataInfo list(PersonnelAppointVoteRes personnelAppointVoteRes)
    {
        startPage();
        List<PersonnelAppointVoteRes> list = personnelAppointVoteResService.selectPersonnelAppointVoteResList(personnelAppointVoteRes);
        return getDataTable(list);
    }

    /**
     * 导出人事任免_表决结果列表
     */
    @PreAuthorize("@ss.hasPermi('system:res:export')")
    @Log(title = "人事任免_表决结果", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, PersonnelAppointVoteRes personnelAppointVoteRes)
    {
        List<PersonnelAppointVoteRes> list = personnelAppointVoteResService.selectPersonnelAppointVoteResList(personnelAppointVoteRes);
        ExcelUtil<PersonnelAppointVoteRes> util = new ExcelUtil<PersonnelAppointVoteRes>(PersonnelAppointVoteRes.class);
        util.exportExcel(response, list, "人事任免_表决结果数据");
    }

    /**
     * 获取人事任免_表决结果详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:res:query')")
    @GetMapping(value = "/{voteId}")
    public AjaxResult getInfo(@PathVariable("voteId") Long voteId)
    {
        return AjaxResult.success(personnelAppointVoteResService.selectPersonnelAppointVoteResByVoteId(voteId));
    }

    /**
     * 新增人事任免_表决结果
     */
    @PreAuthorize("@ss.hasPermi('system:res:add')")
    @Log(title = "人事任免_表决结果", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PersonnelAppointVoteRes personnelAppointVoteRes)
    {
        personnelAppointVoteRes.setCreateBy(getUsername());
        return toAjax(personnelAppointVoteResService.insertPersonnelAppointVoteRes(personnelAppointVoteRes));
    }

    /**
     * 修改人事任免_决表结果
     */
    @PreAuthorize("@ss.hasPermi('system:res:edit')")
    @Log(title = "人事任免_表决结果", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PersonnelAppointVoteRes personnelAppointVoteRes)
    {
        personnelAppointVoteRes.setUpdateBy(getUsername());
        return toAjax(personnelAppointVoteResService.updatePersonnelAppointVoteRes(personnelAppointVoteRes));
    }

    /**
     * 删除人事任免_表决结果
     */
    @PreAuthorize("@ss.hasPermi('system:res:remove')")
    @Log(title = "人事任免_表决结果", businessType = BusinessType.DELETE)
	@DeleteMapping("/{voteIds}")
    public AjaxResult remove(@PathVariable Long[] voteIds)
    {
        return toAjax(personnelAppointVoteResService.deletePersonnelAppointVoteResByVoteIds(voteIds));
    }
}
