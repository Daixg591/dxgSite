package com.shahenpc.app.controller.homepage;

import com.shahenpc.common.core.controller.BaseController;
import com.shahenpc.common.core.domain.AjaxResult;
import com.shahenpc.common.core.page.TableDataInfo;
import com.shahenpc.system.domain.oa.OaMeeting;
import com.shahenpc.system.domain.oa.dto.MeetingAppListDto;
import com.shahenpc.system.service.oa.IOaMeetingService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "app会议管理")
@RestController
@RequestMapping("/app/meeting")
public class AppMeetingController extends BaseController {

    @Autowired
    private IOaMeetingService oaMeetingService;

    @ApiOperation("总参会总分钟")
    @GetMapping("/totalMinute")
    public AjaxResult monthCount()
    {
        return AjaxResult.success(oaMeetingService.selectByCountMinute(getUserId()));
    }

    @ApiOperation("列表")
    @GetMapping("/list")
    public TableDataInfo list(OaMeeting oaMeeting)
    {
        startPage();
        List<MeetingAppListDto> list = oaMeetingService.appList(oaMeeting);
        return getDataTable(list);
    }

    @ApiOperation("详情")
    @GetMapping(value = "/{meetingId}")
    public AjaxResult getInfo(@PathVariable("meetingId") Long meetingId)
    {
        return AjaxResult.success(oaMeetingService.appDetail(meetingId));
    }

    @ApiOperation("签到")
    @GetMapping(value = "/sign/{meetingId}")
    public AjaxResult sign(@PathVariable("meetingId") Long meetingId)
    {
        return AjaxResult.success(oaMeetingService.sign(meetingId,getUserId()));
    }

    @ApiOperation("签到成功！")
    @GetMapping(value = "/sign/success/{meetingId}")
    public AjaxResult signSuccess(@PathVariable("meetingId") Long meetingId)
    {
        return AjaxResult.success(oaMeetingService.signSuccess(meetingId,getUserId()));
    }
}
