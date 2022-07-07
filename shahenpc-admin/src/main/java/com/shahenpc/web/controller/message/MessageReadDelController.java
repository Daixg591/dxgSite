package com.shahenpc.web.controller.message;

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
import com.shahenpc.system.domain.message.MessageReadDel;
import com.shahenpc.system.service.message.IMessageReadDelService;
import com.shahenpc.common.utils.poi.ExcelUtil;
import com.shahenpc.common.core.page.TableDataInfo;

/**
 * 消息已读或者删除Controller
 * 
 * @author ruoyi
 * @date 2022-07-07
 */
@RestController
@RequestMapping("/system/del")
public class MessageReadDelController extends BaseController
{
    @Autowired
    private IMessageReadDelService messageReadDelService;

    /**
     * 查询消息已读或者删除列表
     */
    @PreAuthorize("@ss.hasPermi('system:del:list')")
    @GetMapping("/list")
    public TableDataInfo list(MessageReadDel messageReadDel)
    {
        startPage();
        List<MessageReadDel> list = messageReadDelService.selectMessageReadDelList(messageReadDel);
        return getDataTable(list);
    }

    /**
     * 导出消息已读或者删除列表
     */
    @PreAuthorize("@ss.hasPermi('system:del:export')")
    @Log(title = "消息已读或者删除", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, MessageReadDel messageReadDel)
    {
        List<MessageReadDel> list = messageReadDelService.selectMessageReadDelList(messageReadDel);
        ExcelUtil<MessageReadDel> util = new ExcelUtil<MessageReadDel>(MessageReadDel.class);
        util.exportExcel(response, list, "消息已读或者删除数据");
    }

    /**
     * 获取消息已读或者删除详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:del:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(messageReadDelService.selectMessageReadDelById(id));
    }

    /**
     * 新增消息已读或者删除
     */
    @PreAuthorize("@ss.hasPermi('system:del:add')")
    @Log(title = "消息已读或者删除", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody MessageReadDel messageReadDel)
    {
        return toAjax(messageReadDelService.insertMessageReadDel(messageReadDel));
    }

    /**
     * 修改消息已读或者删除
     */
    @PreAuthorize("@ss.hasPermi('system:del:edit')")
    @Log(title = "消息已读或者删除", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody MessageReadDel messageReadDel)
    {
        return toAjax(messageReadDelService.updateMessageReadDel(messageReadDel));
    }

    /**
     * 删除消息已读或者删除
     */
    @PreAuthorize("@ss.hasPermi('system:del:remove')")
    @Log(title = "消息已读或者删除", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(messageReadDelService.deleteMessageReadDelByIds(ids));
    }
}
