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
import com.shahenpc.system.domain.oa.OaVotePlayer;
import com.shahenpc.system.service.oa.IOaVotePlayerService;
import com.shahenpc.common.utils.poi.ExcelUtil;
import com.shahenpc.common.core.page.TableDataInfo;

/**
 * 投票选手Controller
 * 
 * @author ruoyi
 * @date 2022-07-19
 */
@Api(tags = "投票选手管理")
@RestController
@RequestMapping("/oa/player")
public class OaVotePlayerController extends BaseController
{
    @Autowired
    private IOaVotePlayerService oaVotePlayerService;

    /**
     * 查询投票选手列表
     */
    @PreAuthorize("@ss.hasPermi('oa:player:list')")
    @GetMapping("/list")
    public TableDataInfo list(OaVotePlayer oaVotePlayer)
    {
        startPage();
        List<OaVotePlayer> list = oaVotePlayerService.selectOaVotePlayerList(oaVotePlayer);
        return getDataTable(list);
    }

    /**
     * 导出投票选手列表
     */
    @PreAuthorize("@ss.hasPermi('oa:player:export')")
    @Log(title = "投票选手", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, OaVotePlayer oaVotePlayer)
    {
        List<OaVotePlayer> list = oaVotePlayerService.selectOaVotePlayerList(oaVotePlayer);
        ExcelUtil<OaVotePlayer> util = new ExcelUtil<OaVotePlayer>(OaVotePlayer.class);
        util.exportExcel(response, list, "投票选手数据");
    }

    /**
     * 获取投票选手详细信息
     */
    @PreAuthorize("@ss.hasPermi('oa:player:query')")
    @GetMapping(value = "/{playerId}")
    public AjaxResult getInfo(@PathVariable("playerId") Long playerId)
    {
        return AjaxResult.success(oaVotePlayerService.selectOaVotePlayerByPlayerId(playerId));
    }

    /**
     * 新增投票选手
     */
    @PreAuthorize("@ss.hasPermi('oa:player:add')")
    @Log(title = "投票选手", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody OaVotePlayer oaVotePlayer)
    {
        return toAjax(oaVotePlayerService.insertOaVotePlayer(oaVotePlayer));
    }

    /**
     * 修改投票选手
     */
    @PreAuthorize("@ss.hasPermi('oa:player:edit')")
    @Log(title = "投票选手", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody OaVotePlayer oaVotePlayer)
    {
        return toAjax(oaVotePlayerService.updateOaVotePlayer(oaVotePlayer));
    }

    /**
     * 删除投票选手
     */
    @PreAuthorize("@ss.hasPermi('oa:player:remove')")
    @Log(title = "投票选手", businessType = BusinessType.DELETE)
	@DeleteMapping("/{playerIds}")
    public AjaxResult remove(@PathVariable Long[] playerIds)
    {
        return toAjax(oaVotePlayerService.deleteOaVotePlayerByPlayerIds(playerIds));
    }
}
