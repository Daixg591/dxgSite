package com.shahenpc.web.controller.contactstation;

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
import com.shahenpc.system.domain.contactstation.ContactStationAct;
import com.shahenpc.system.service.contactstation.IContactStationActService;
import com.shahenpc.common.utils.poi.ExcelUtil;
import com.shahenpc.common.core.page.TableDataInfo;

/**
 * 联络站活动Controller
 * 
 * @author ruoyi
 * @date 2022-08-09
 */
@Api(tags = "联络站活动管理")
@RestController
@RequestMapping("/system/act")
public class ContactStationActController extends BaseController
{
    @Autowired
    private IContactStationActService contactStationActService;

    /**
     * 查询联络站活动列表
     */
    @ApiOperation("联络站活动_列表")
//    @PreAuthorize("@ss.hasPermi('system:act:list')")
    @GetMapping("/list")
    public TableDataInfo list(ContactStationAct contactStationAct)
    {
        startPage();
        List<ContactStationAct> list = contactStationActService.selectContactStationActList(contactStationAct);
        return getDataTable(list);
    }

    /**
     * 导出联络站活动列表
     */
    @PreAuthorize("@ss.hasPermi('system:act:export')")
    @Log(title = "联络站活动", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ContactStationAct contactStationAct)
    {
        List<ContactStationAct> list = contactStationActService.selectContactStationActList(contactStationAct);
        ExcelUtil<ContactStationAct> util = new ExcelUtil<ContactStationAct>(ContactStationAct.class);
        util.exportExcel(response, list, "联络站活动数据");
    }

    /**
     * 获取联络站活动详细信息
     */
    @ApiOperation("联络站活动_详情")
    @PreAuthorize("@ss.hasPermi('system:act:query')")
    @GetMapping(value = "/{contactStationActId}")
    public AjaxResult getInfo(@PathVariable("contactStationActId") Long contactStationActId)
    {
        return AjaxResult.success(contactStationActService.selectContactStationActByContactStationActId(contactStationActId));
    }

    /**
     * 新增联络站活动
     */
    @ApiOperation("联络站活动_新增")
    @PreAuthorize("@ss.hasPermi('system:act:add')")
    @Log(title = "联络站活动", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ContactStationAct contactStationAct)
    {
        return toAjax(contactStationActService.insertContactStationAct(contactStationAct));
    }

    /**
     * 修改联络站活动
     */
    @ApiOperation("联络站活动_编辑")
    @PreAuthorize("@ss.hasPermi('system:act:edit')")
    @Log(title = "联络站活动", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ContactStationAct contactStationAct)
    {
        return toAjax(contactStationActService.updateContactStationAct(contactStationAct));
    }

    /**
     * 删除联络站活动
     */
    @ApiOperation("联络站活动_删除")
    @PreAuthorize("@ss.hasPermi('system:act:remove')")
    @Log(title = "联络站活动", businessType = BusinessType.DELETE)
	@DeleteMapping("/{contactStationActIds}")
    public AjaxResult remove(@PathVariable Long[] contactStationActIds)
    {
        return toAjax(contactStationActService.deleteContactStationActByContactStationActIds(contactStationActIds));
    }
}
