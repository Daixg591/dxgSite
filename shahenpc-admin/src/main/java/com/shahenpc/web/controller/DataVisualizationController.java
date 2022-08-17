package com.shahenpc.web.controller;

import com.shahenpc.common.core.controller.BaseController;
import com.shahenpc.common.core.domain.AjaxResult;
import com.shahenpc.common.core.page.TableDataInfo;
import com.shahenpc.system.domain.represent.RepresentHomeAccess;
import com.shahenpc.system.domain.represent.vo.MotionTaskVo;
import com.shahenpc.system.service.ISysUserService;
import com.shahenpc.system.service.represent.IRepresentHomeAccessService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "大数据可视化页面控制台")
@RestController
@RequestMapping("/data/visualization")
public class DataVisualizationController extends BaseController {

    @Autowired
    private ISysUserService sysUserService;
    @Autowired
    private IRepresentHomeAccessService representHomeAccessService;

    @ApiOperation("头部数量")
    @GetMapping("/count")
    public AjaxResult count(){
        return AjaxResult.success(sysUserService.count());
    }

    @ApiOperation("代表之家列表")
    @GetMapping("/access/list")
    public TableDataInfo list(RepresentHomeAccess representHomeAccess)
    {
        startPage();
        List<RepresentHomeAccess> list = representHomeAccessService.selectRepresentHomeAccessList(representHomeAccess);
        return getDataTable(list);
    }

}
