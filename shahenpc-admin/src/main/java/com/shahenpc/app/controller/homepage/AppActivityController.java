package com.shahenpc.app.controller.homepage;

import com.shahenpc.common.core.controller.BaseController;
import com.shahenpc.common.core.domain.AjaxResult;
import com.shahenpc.common.core.page.TableDataInfo;
import com.shahenpc.system.domain.represent.RepresentActivity;
import com.shahenpc.system.domain.represent.dto.ActivityAppListDto;
import com.shahenpc.system.service.represent.IRepresentActivityService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "app活动管理")
@RestController
@RequestMapping("/app/activity")
public class AppActivityController extends BaseController {
    @Autowired
    private IRepresentActivityService representActivityService;

    @ApiOperation("参会完成数-会数")
    @GetMapping("/finishCount")
    public AjaxResult monthCount()
    {
        return AjaxResult.success(representActivityService.selectByFinishCount(getUserId()));
    }

    @ApiOperation("列表")
    @GetMapping("/list")
    public TableDataInfo list(RepresentActivity representActivity)
    {
        startPage();
        List<ActivityAppListDto> list = representActivityService.appList(representActivity);
        return getDataTable(list);
    }

    @ApiOperation("详情")
    @GetMapping(value = "/{activityId}")
    public AjaxResult getInfo(@PathVariable("activityId") Long activityId)
    {
        return AjaxResult.success(representActivityService.appDetail(activityId));
    }
}
