package com.shahenpc.mpWeixin.controller.represent;

import com.shahenpc.common.annotation.Log;
import com.shahenpc.common.core.domain.AjaxResult;
import com.shahenpc.system.service.represent.IRepresentNpcOverviewService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "Wx概览")
@RestController
@RequestMapping("/wx/represent/overview")
public class WxRepresentNpcOverviewController {
    @Autowired
    private IRepresentNpcOverviewService representNpcOverviewService;

    //  /wx/feature/work/overview
    @ApiOperation("概览")
    @Log(title = "概览")
    @GetMapping("/overview")
    public AjaxResult countAndranking()
    {
        return AjaxResult.success(representNpcOverviewService.selectByWxOverview());
    }
}
