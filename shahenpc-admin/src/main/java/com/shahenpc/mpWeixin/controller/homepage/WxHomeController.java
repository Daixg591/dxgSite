package com.shahenpc.mpWeixin.controller.homepage;

import com.shahenpc.common.core.controller.BaseController;
import com.shahenpc.common.core.domain.AjaxResult;
import com.shahenpc.common.core.page.TableDataInfo;
import com.shahenpc.system.domain.personel.PersonnelAppointNotice;
import com.shahenpc.system.domain.represent.RepresentColumn;
import com.shahenpc.system.service.personel.IPersonnelAppointNoticeService;
import com.shahenpc.system.service.represent.IRepresentColumnService;
import com.shahenpc.system.service.represent.IRepresentNpcOverviewService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "wx首页")
@RestController
@RequestMapping("/wx/home")
public class WxHomeController extends BaseController {

    @Autowired
    private IRepresentColumnService representColumnService;
    @Autowired
    private IRepresentNpcOverviewService representNpcOverviewService;
    @Autowired
    private IPersonnelAppointNoticeService personnelAppointNoticeService;

    /** 栏目列表*/
    @ApiOperation("栏目列表")
    @GetMapping("/column/list")
    public AjaxResult list(RepresentColumn representColumn)
    {
        startPage();
        representColumn.setColumnType(1);
        List<RepresentColumn> list = representColumnService.selectRepresentColumnList(representColumn);
        return AjaxResult.success(list);
    }

    /** 广告列表*/
    @ApiOperation("广告列表")
    @GetMapping("/ad/list")
    public TableDataInfo list(PersonnelAppointNotice performNpcOverview)
    {
        startPage();
        List<PersonnelAppointNotice> list = personnelAppointNoticeService.selectPersonnelAppointNoticeList(performNpcOverview);
        return getDataTable(list);
    }
    /** 轮播列表*/
    @ApiOperation("默认一条概览")
    @PreAuthorize("@ss.hasPermi('perform:overview:overview')")
    @GetMapping("/overview")
    public AjaxResult getOverview()
    {
        return AjaxResult.success(representNpcOverviewService.selectByOverview());
    }
}
