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
import com.shahenpc.system.domain.message.MessageData;
import com.shahenpc.system.service.message.IMessageDataService;
import com.shahenpc.common.utils.poi.ExcelUtil;
import com.shahenpc.common.core.page.TableDataInfo;

/**
 * 消息Controller
 * 
 * @author ruoyi
 * @date 2022-07-07
 */
@RestController
@RequestMapping("/system/data")
public class MessageDataController extends BaseController
{
    @Autowired
    private IMessageDataService messageDataService;

    /**
     * 查询消息列表
     */
    @PreAuthorize("@ss.hasPermi('system:data:list')")
    @GetMapping("/list")
    public TableDataInfo list(MessageData messageData)
    {
        startPage();
        List<MessageData> list = messageDataService.selectMessageDataList(messageData);
        return getDataTable(list);
    }

    /**
     * 导出消息列表
     */
    @PreAuthorize("@ss.hasPermi('system:data:export')")
    @Log(title = "消息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, MessageData messageData)
    {
        List<MessageData> list = messageDataService.selectMessageDataList(messageData);
        ExcelUtil<MessageData> util = new ExcelUtil<MessageData>(MessageData.class);
        util.exportExcel(response, list, "消息数据");
    }

    /**
     * 获取消息详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:data:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(messageDataService.selectMessageDataById(id));
    }

    /**
     * 新增消息
     */
    @PreAuthorize("@ss.hasPermi('system:data:add')")
    @Log(title = "消息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody MessageData messageData)
    {
        return toAjax(messageDataService.insertMessageData(messageData));
    }

    /**
     * 修改消息
     */
    @PreAuthorize("@ss.hasPermi('system:data:edit')")
    @Log(title = "消息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody MessageData messageData)
    {
        return toAjax(messageDataService.updateMessageData(messageData));
    }

    /**
     * 删除消息
     */
    @PreAuthorize("@ss.hasPermi('system:data:remove')")
    @Log(title = "消息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(messageDataService.deleteMessageDataByIds(ids));
    }
}
