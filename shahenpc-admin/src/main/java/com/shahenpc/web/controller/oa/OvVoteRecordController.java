package com.shahenpc.web.controller.oa;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.shahenpc.system.domain.oa.vo.VoteRecordVo;
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
import com.shahenpc.system.domain.oa.OaVoteRecord;
import com.shahenpc.system.service.oa.IOaVoteRecordService;
import com.shahenpc.common.utils.poi.ExcelUtil;
import com.shahenpc.common.core.page.TableDataInfo;

/**
 * 投票记录Controller
 * 
 * @author ruoyi
 * @date 2022-09-05
 */
@RestController
@RequestMapping("/oa/vote/record")
public class OvVoteRecordController extends BaseController
{
    @Autowired
    private IOaVoteRecordService ovVoteRecordService;

    /**
     * 查询投票记录列表
     */
//    @PreAuthorize("@ss.hasPermi('vote:record:list')")
    @GetMapping("/list")
    public TableDataInfo list(OaVoteRecord ovVoteRecord)
    {
        startPage();
        List<OaVoteRecord> list = ovVoteRecordService.selectOvVoteRecordList(ovVoteRecord);
        return getDataTable(list);
    }

    /**
     * 导出投票记录列表
     */
    @PreAuthorize("@ss.hasPermi('vote:record:export')")
    @Log(title = "投票记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, OaVoteRecord ovVoteRecord)
    {
        List<OaVoteRecord> list = ovVoteRecordService.selectOvVoteRecordList(ovVoteRecord);
        ExcelUtil<OaVoteRecord> util = new ExcelUtil<OaVoteRecord>(OaVoteRecord.class);
        util.exportExcel(response, list, "投票记录数据");
    }

    /**
     * 获取投票记录详细信息
     */
//    @PreAuthorize("@ss.hasPermi('vote:record:query')")
    @GetMapping(value = "/{recordId}")
    public AjaxResult getInfo(@PathVariable("recordId") Long recordId)
    {
        return AjaxResult.success(ovVoteRecordService.selectOvVoteRecordByRecordId(recordId));
    }

    /**
     * 新增投票记录
     */
    @Log(title = "投票记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody VoteRecordVo requst)
    {
//        requst.setUserId(getUserId());
        return ovVoteRecordService.insertPlayerIds(requst);
    }




    /**
     * 修改投票记录
     */
//    @PreAuthorize("@ss.hasPermi('vote:record:edit')")
    @Log(title = "投票记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody OaVoteRecord ovVoteRecord)
    {
        return toAjax(ovVoteRecordService.updateOvVoteRecord(ovVoteRecord));
    }

    /**
     * 删除投票记录
     */
    @PreAuthorize("@ss.hasPermi('vote:record:remove')")
    @Log(title = "投票记录", businessType = BusinessType.DELETE)
	@DeleteMapping("/{recordIds}")
    public AjaxResult remove(@PathVariable Long[] recordIds)
    {
        return toAjax(ovVoteRecordService.deleteOvVoteRecordByRecordIds(recordIds));
    }
}
