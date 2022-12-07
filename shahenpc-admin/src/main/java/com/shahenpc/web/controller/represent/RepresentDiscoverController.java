package com.shahenpc.web.controller.represent;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.shahenpc.system.domain.represent.dto.DiscoverAppListDto;
import com.shahenpc.system.domain.represent.dto.DiscoverListDto;
import com.shahenpc.system.domain.represent.dto.DiscoverPieDto;
import com.shahenpc.system.domain.represent.dto.DiscoverRankingDto;
import com.shahenpc.system.domain.represent.vo.DiscoverFallbackVo;
import com.shahenpc.system.domain.represent.vo.DiscoverUpdateVo;
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
import com.shahenpc.system.domain.represent.RepresentDiscover;
import com.shahenpc.system.service.represent.IRepresentDiscoverService;
import com.shahenpc.common.utils.poi.ExcelUtil;
import com.shahenpc.common.core.page.TableDataInfo;

/**
 * 代-代发现Controller
 * 
 * @author ruoyi
 * @date 2022-07-28
 */
@Api(tags = "代表发现")
@RestController
@RequestMapping("/represent/discover")
public class RepresentDiscoverController extends BaseController
{
    @Autowired
    private IRepresentDiscoverService representDiscoverService;

    /**
     * 查询代-代发现列表
     */
    @GetMapping("/list")
    public TableDataInfo list(RepresentDiscover representDiscover)
    {
        startPage();
        List<DiscoverListDto> list = representDiscoverService.adminList(representDiscover);
        return getDataTable(list);
    }

    @PreAuthorize("@ss.hasPermi('discover:translate:list')")
    @GetMapping("/translate/list")
    public TableDataInfo translateList()
    {
        List<DiscoverAppListDto> list = representDiscoverService.translateList(getUserId());
        return getDataTable(list);
    }
    /**
     * 退回
     * @param fallbackVo
     * @return
     */
    @PostMapping("/fallback")
    public AjaxResult fallback(@RequestBody DiscoverFallbackVo fallbackVo)
    {
        fallbackVo.setUpdateBy(getNickName());
       return representDiscoverService.fallback(fallbackVo);
    }
    @ApiOperation("待办列表")
    @GetMapping("/todo/list")
    public TableDataInfo todoList(RepresentDiscover representDiscover)
    {
        representDiscover.setReceiveUserId(getUserId());
        startPage();
        List<DiscoverAppListDto> list = representDiscoverService.todoList(representDiscover);
        return getDataTable(list);
    }

    @ApiOperation("已办列表")
    @GetMapping("/done/list")
    public TableDataInfo doneList(RepresentDiscover representDiscover)
    {
        representDiscover.setReceiveUserId(getUserId());
        startPage();
        List<DiscoverAppListDto> list = representDiscoverService.doneList(getUserId());
        return getDataTable(list);
    }

    /**
     * 导出代-代发现列表
     */
    @ApiOperation("代表发现导出")
    @Log(title = "代-代发现", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, RepresentDiscover representDiscover)
    {
        List<DiscoverListDto> list = representDiscoverService.adminList(representDiscover);
        ExcelUtil<DiscoverListDto> util = new ExcelUtil<DiscoverListDto>(DiscoverListDto.class);
        util.exportExcel(response, list, "代-代发现数据");
    }

    /**
     * 获取代-代发现详细信息
     */
    @GetMapping(value = "/{discoverId}")
    public AjaxResult getInfo(@PathVariable("discoverId") Long discoverId)
    {
        return AjaxResult.success(representDiscoverService.detail(discoverId));
    }
    /**
     * 新增代-代发现
     */
    @Log(title = "代-代发现", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody RepresentDiscover representDiscover)
    {
        representDiscover.setSendUserId(getUserId());
        representDiscover.setUpdateBy(getUsername());
        representDiscover.setStationId(getContactStationId());
        return representDiscoverService.insertRepresentDiscover(representDiscover);
    }

    /**
     * 修改代-代发现
     */
    @Log(title = "代-代发现", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody DiscoverUpdateVo representDiscover)
    {
        representDiscover.setUpdateBy(getNickName());
        representDiscover.setUserId(getUserId());
        return representDiscoverService.updateRepresentDiscover(representDiscover);
    }

    /**
     * 删除代-代发现
     */
    @Log(title = "代-代发现", businessType = BusinessType.DELETE)
	@DeleteMapping("/{discoverIds}")
    public AjaxResult remove(@PathVariable Long[] discoverIds)
    {
        return toAjax(representDiscoverService.deleteRepresentDiscoverByDiscoverIds(discoverIds));
    }


    @ApiOperation("环数")
    @GetMapping("/ring")
    public AjaxResult ring(){
        return AjaxResult.success(representDiscoverService.ring());
    }

    @ApiOperation("曲线")
    @GetMapping("/line")
    public AjaxResult line(){
        return AjaxResult.success(representDiscoverService.line());
    }


    @ApiOperation("饼图")
    @GetMapping(value = "/pie")
    public AjaxResult cake()
    {
        return AjaxResult.success(representDiscoverService.pie());
    }

    @ApiOperation("状态饼图")
    @GetMapping(value = "/status/pie")
    public AjaxResult statusPie()
    {
        return AjaxResult.success(representDiscoverService.statusPie());
    }


    @ApiOperation("状态各个总数")
    @GetMapping(value = "/status/count")
    public AjaxResult statusCount()
    {
        return AjaxResult.success(representDiscoverService.selectByStatusCount());
    }

    @ApiOperation("漏斗")
    @GetMapping(value = "/funnel")
    public AjaxResult funnel()
    {
        return AjaxResult.success(representDiscoverService.funnel());
    }

    @ApiOperation("热力图")
    @GetMapping(value = "/heatmap")
    public AjaxResult heatmap() {
        return AjaxResult.success(representDiscoverService.heatmap());
    }


    /**
     * 代表发现排名 个人
     */
    @ApiOperation("排行")
    @GetMapping(value = "/ranking")
    public TableDataInfo Ranking()
    {
        startPage();
        List<DiscoverRankingDto> list = representDiscoverService.ranking();
        return getDataTable(list);
    }
    @ApiOperation("排行导出")
    @PostMapping(value = "/ranking/export")
    public void RankingExport(HttpServletResponse response, RepresentDiscover representDiscover)
    {
        List<DiscoverRankingDto> list = representDiscoverService.selectByExportRanking();
        ExcelUtil<DiscoverRankingDto> util = new ExcelUtil<DiscoverRankingDto>(DiscoverRankingDto.class);
        util.exportExcel(response, list, "代-代发现数据");
    }

    /**
     * 代表发现排名 个人
     */
    @ApiOperation("联络站排行")
    @GetMapping(value = "/contact/ranking")
    public AjaxResult contactRanking()
    {
        return AjaxResult.success(representDiscoverService.contactRanking());
    }

    @ApiOperation("联络站百分率排行")
    @GetMapping(value = "/contact/baifenlv/ranking")
    public AjaxResult contactBaiRanking()
    {
        return AjaxResult.success(representDiscoverService.contactBaiFenLvRanking());
    }


    @ApiOperation("一个率")
    @GetMapping(value = "/total/lv")
    public AjaxResult TotalLv()
    {
        return AjaxResult.success(representDiscoverService.selectByTotalLv());
    }
}
