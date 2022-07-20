package com.shahenpc.web.controller.oa;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import io.swagger.annotations.Api;
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
import com.shahenpc.system.domain.oa.OaVote;
import com.shahenpc.system.service.oa.IOaVoteService;
import com.shahenpc.common.utils.poi.ExcelUtil;
import com.shahenpc.common.core.page.TableDataInfo;

/**
 * 投票窗口Controller
 * 
 * @author ruoyi
 * @date 2022-07-19
 */
@Api(tags = "投票管理")
@RestController
@RequestMapping("/oa/vote")
public class OaVoteController extends BaseController
{
    @Autowired
    private IOaVoteService oaVoteService;

    /**
     * 查询投票窗口列表
     */
    @PreAuthorize("@ss.hasPermi('oa:vote:list')")
    @GetMapping("/list")
    public TableDataInfo list(OaVote oaVote)
    {
        startPage();
        List<OaVote> list = oaVoteService.selectOaVoteList(oaVote);
        return getDataTable(list);
    }

    /**
     * 导出投票窗口列表
     */
    @PreAuthorize("@ss.hasPermi('oa:vote:export')")
    @Log(title = "投票窗口", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, OaVote oaVote)
    {
        List<OaVote> list = oaVoteService.selectOaVoteList(oaVote);
        ExcelUtil<OaVote> util = new ExcelUtil<OaVote>(OaVote.class);
        util.exportExcel(response, list, "投票窗口数据");
    }

    /**
     * 获取投票窗口详细信息
     */
    @PreAuthorize("@ss.hasPermi('oa:vote:query')")
    @GetMapping(value = "/{voteId}")
    public AjaxResult getInfo(@PathVariable("voteId") Long voteId)
    {
        return AjaxResult.success(oaVoteService.selectOaVoteByVoteId(voteId));
    }

    /**
     * 新增投票窗口
     */
    @PreAuthorize("@ss.hasPermi('oa:vote:add')")
    @Log(title = "投票窗口", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody OaVote oaVote)
    {
        return toAjax(oaVoteService.insertOaVote(oaVote));
    }

    /**
     * 修改投票窗口
     */
    @PreAuthorize("@ss.hasPermi('oa:vote:edit')")
    @Log(title = "投票窗口", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody OaVote oaVote)
    {
        return toAjax(oaVoteService.updateOaVote(oaVote));
    }

    /**
     * 删除投票窗口
     */
    @PreAuthorize("@ss.hasPermi('oa:vote:remove')")
    @Log(title = "投票窗口", businessType = BusinessType.DELETE)
	@DeleteMapping("/{voteIds}")
    public AjaxResult remove(@PathVariable Long[] voteIds)
    {
        return toAjax(oaVoteService.deleteOaVoteByVoteIds(voteIds));
    }
}
