package com.shahenpc.web.controller.sign;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.shahenpc.system.domain.represent.RepresentDiscover;
import com.shahenpc.system.domain.represent.SignRankingDto;
import com.shahenpc.system.domain.represent.dto.DiscoverRankingDto;
import com.shahenpc.system.domain.represent.vo.SignTimeDto;
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
import com.shahenpc.system.domain.sign.SysUserSign;
import com.shahenpc.system.service.sign.ISysUserSignService;
import com.shahenpc.common.utils.poi.ExcelUtil;
import com.shahenpc.common.core.page.TableDataInfo;

/**
 * 代表签到Controller
 *
 * @author ruoyi
 * @date 2022-11-17
 */
@Api(tags = "代表签到")
@RestController
@RequestMapping("/system/sign")
public class SysUserSignController extends BaseController {
    @Autowired
    private ISysUserSignService sysUserSignService;

    /**
     * 查询代表签到列表
     */
    @PreAuthorize("@ss.hasPermi('system:sign:list')")
    @GetMapping("/list")
    public TableDataInfo list(SysUserSign sysUserSign) {
        startPage();
        List<SysUserSign> list = sysUserSignService.selectSysUserSignList(sysUserSign);
        return getDataTable(list);
    }

    /**
     * 导出代表签到列表
     */
    @PreAuthorize("@ss.hasPermi('system:sign:export')")
    @Log(title = "代表签到", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SysUserSign sysUserSign) {
        List<SysUserSign> list = sysUserSignService.selectSysUserSignList(sysUserSign);
        ExcelUtil<SysUserSign> util = new ExcelUtil<SysUserSign>(SysUserSign.class);
        util.exportExcel(response, list, "代表签到数据");
    }

    /**
     * 获取代表签到详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:sign:query')")
    @GetMapping(value = "/{signId}")
    public AjaxResult getInfo(@PathVariable("signId") Long signId) {
        return AjaxResult.success(sysUserSignService.selectSysUserSignBySignId(signId));
    }


    /**
     * todo-ht 判断代表是否签到
     * 判断用户今日是否签到
     */
    @ApiOperation("判断用户今日是否签到")
//    @PreAuthorize("@ss.hasPermi('system:sign:queryToday')")
    @GetMapping(value = "/todaySign")
    public AjaxResult getTodayInfo() {
        return AjaxResult.success(isTodaySign(getUserId()));
    }

    /**
     * 新增代表签到
     */
    @ApiOperation("新增代表签到")
//    @PreAuthorize("@ss.hasPermi('system:sign:add')")
    @Log(title = "代表签到", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add() {
        if (isTodaySign(getUserId())) {
            return AjaxResult.error("今日已签到！");
        }
        SysUserSign entity = new SysUserSign();
        entity.setUserId(getUserId());
        return toAjax(sysUserSignService.insertSysUserSign(entity));
    }

    /**
     * 修改代表签到
     */
    @ApiOperation("修改代表签到")
    @PreAuthorize("@ss.hasPermi('system:sign:edit')")
    @Log(title = "代表签到", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysUserSign sysUserSign) {
        return toAjax(sysUserSignService.updateSysUserSign(sysUserSign));
    }

    /**
     * 删除代表签到
     */
    @PreAuthorize("@ss.hasPermi('system:sign:remove')")
    @Log(title = "代表签到", businessType = BusinessType.DELETE)
    @DeleteMapping("/{signIds}")
    public AjaxResult remove(@PathVariable Long[] signIds) {
        return toAjax(sysUserSignService.deleteSysUserSignBySignIds(signIds));
    }

    /**
     * 判断用户是否签到
     *
     * @param userId 用户ID
     * @return true 已签到 false 未签到
     */
    private boolean isTodaySign(Long userId) {
        return sysUserSignService.isTodaySign(userId);
    }


    @ApiOperation("排行导出")
    @PostMapping(value = "/ranking/export")
    public void RankingExport(HttpServletResponse response, SignTimeDto dto)
    {
        List<SignRankingDto> list = sysUserSignService.selectByExportRanking(dto);
        ExcelUtil<SignRankingDto> util = new ExcelUtil<SignRankingDto>(SignRankingDto.class);
        //新增时间判断
        util.exportExcel(response, list, "本周代表签到次数统计");
    }

    /**
     * 代表签到前十名
     * @return
     */
    @ApiOperation("代表签到前十名")
    @GetMapping(value = "/tops")
    public List<SignRankingDto> selectByExportRanking()
    {
        return sysUserSignService.selectTopRanking();
    }

}
