package com.shahenpc.web.controller.represent;

import com.shahenpc.common.annotation.Log;
import com.shahenpc.common.core.controller.BaseController;
import com.shahenpc.common.core.domain.AjaxResult;
import com.shahenpc.common.core.page.TableDataInfo;
import com.shahenpc.common.enums.BusinessType;
import com.shahenpc.common.utils.poi.ExcelUtil;
import com.shahenpc.flowable.service.IFlowTaskService;
import com.shahenpc.system.domain.represent.RepresentActivity;
import com.shahenpc.system.domain.represent.RepresentActivityClaim;
import com.shahenpc.system.domain.represent.RepresentActivityGroup;
import com.shahenpc.system.domain.represent.RepresentActivityRecord;
import com.shahenpc.system.domain.represent.dto.ActivityAddDto;
import com.shahenpc.system.domain.represent.dto.ActivityDetailDto;
import com.shahenpc.system.domain.represent.dto.ActivityGroupUserDto;
import com.shahenpc.system.service.ISysDictDataService;
import com.shahenpc.system.service.ISysUserService;
import com.shahenpc.system.service.represent.IRepresentActivityClaimService;
import com.shahenpc.system.service.represent.IRepresentActivityGroupService;
import com.shahenpc.system.service.represent.IRepresentActivityRecordService;
import com.shahenpc.system.service.represent.IRepresentActivityService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 代-活动列Controller
 *
 * @author ruoyi
 * @date 2022-07-21
 */
@Api(tags = "履职活动管理")
@RestController
@RequestMapping("/represent/activity")
public class RepresentActivityController extends BaseController {
    @Autowired
    private IRepresentActivityService representActivityService;

    @Autowired
    private IFlowTaskService flowTaskService;

    @Autowired
    private IRepresentActivityRecordService representActivityRecordService;

    @Autowired
    private IRepresentActivityGroupService groupService;

    @Autowired
    private ISysDictDataService dictDataService;

    @Autowired
    private IRepresentActivityClaimService claimService;

    @Autowired
    private ISysUserService userService;

    /**
     * 查询代-活动列列表
     */
    @ApiOperation("列表")
    @PreAuthorize("@ss.hasPermi('represent:activity:list')")
    @GetMapping("/list")
    public TableDataInfo list(RepresentActivity representActivity) {
        startPage();
        representActivity.setNpcClaim(false);
        representActivityService.updateStatusBeforeSelectList(representActivity);
        List<RepresentActivity> list = representActivityService.selectRepresentActivityList(representActivity);
        for (RepresentActivity activity : list) {

            RepresentActivityClaim claimDto = new RepresentActivityClaim();
            claimDto.setActivityId(activity.getActivityId());
            claimDto.setUserId(getLoginUser().getUser().getUserId());
            RepresentActivityClaim claimEntity = claimService.selectRepresentActivityClaim(claimDto);
            if (claimEntity == null) {
                activity.setClaim(null);
            } else activity.setClaim(claimEntity.getStatus() == 2);
        }
        return getDataTable(list);
    }

    @ApiOperation("我的列表")
    @GetMapping("/my/list")
    public TableDataInfo myList(RepresentActivity representActivity) {
        startPage();
        representActivity.setUserId(getUserId());
        List<RepresentActivity> list = representActivityService.selectByUserId(representActivity);
        for (RepresentActivity activity : list) {

            RepresentActivityClaim claimDto = new RepresentActivityClaim();
            claimDto.setActivityId(activity.getActivityId());
            claimDto.setUserId(getLoginUser().getUser().getUserId());
            RepresentActivityClaim claimEntity = claimService.selectRepresentActivityClaim(claimDto);
            if (claimEntity == null) {
                activity.setClaim(null);
            } else activity.setClaim(claimEntity.getStatus() == 2);
        }
        return getDataTable(list);
    }


    @ApiOperation("代表认领列表")
    @PreAuthorize("@ss.hasPermi('represent:activity:list')")
    @GetMapping("/claimList")
    public TableDataInfo claimList(RepresentActivity representActivity) {
        startPage();
        List<RepresentActivity> list = representActivityService.selectRepresentActivityList(representActivity);
        for (RepresentActivity activity : list) {
            RepresentActivityRecord logDto = new RepresentActivityRecord();
            logDto.setActivityId(activity.getActivityId());
            logDto.setUserId(getLoginUser().getUser().getUserId());
            RepresentActivityRecord logList = representActivityRecordService.selectRepresentActivityRecord(logDto);
//            if (logList == null) {
//                activity.setClaim(null);
//            } else if (logList.getStatus() == 2) {
//                activity.setClaim(true);
//            } else {
//                activity.setClaim(false);
//            }
        }
        return getDataTable(list);
    }


    /**
     * 导出代表活动列列表
     */
    @ApiOperation("导出")
    @PreAuthorize("@ss.hasPermi('represent:activity:export')")
    @Log(title = "代-活动列", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, RepresentActivity representActivity) {
        List<RepresentActivity> list = representActivityService.selectRepresentActivityList(representActivity);
        ExcelUtil<RepresentActivity> util = new ExcelUtil<RepresentActivity>(RepresentActivity.class);
        util.exportExcel(response, list, "代-活动列数据");
    }

    /**
     * 获取代-活动列详细信息
     */
    @ApiOperation("详情")
    @PreAuthorize("@ss.hasPermi('represent:activity:query')")
    @GetMapping(value = "/{activityId}")
    public AjaxResult getInfo(@PathVariable("activityId") Long activityId) {
        ActivityDetailDto dto = representActivityService.newDetail(activityId);
        dto.setActivityTypeName(dictDataService.selectDictLabel("activity_categories", dto.getActivityType().toString()));

        //region // 废弃记录逻辑
        //        RepresentActivityRecord logDto = new RepresentActivityRecord();
        //        logDto.setActivityId(dto.getActivityId());
        //        logDto.setUserId(getUserId());
        //endregion

        // 返回各用户分组以及分组人数 --》1 查询所有的分组--》2 根据Id查询当前Id下的分组 --》3 根据分组Id查询分组人数集合
        RepresentActivityGroup groupDto = new RepresentActivityGroup();
        groupDto.setActivityId(activityId);
        List<RepresentActivityGroup> groups = groupService.selectRepresentActivityGroupList(groupDto);

        RepresentActivityClaim claimDto = new RepresentActivityClaim();
        claimDto.setActivityId(activityId);
        List<RepresentActivityClaim> claimList = claimService.selectClaimList(claimDto);

        dto.setGroupUserList(claimList);
        if (groups != null && groups.size() > 0) {
            for (RepresentActivityGroup group : groups) {
                List<Long> userIds = new ArrayList<>();

                for (RepresentActivityClaim claim : claimList.stream().filter(x -> x.getActivityGroupId().equals(group.getActivityGroupId())).collect(Collectors.toList())) {
                    userIds.add(claim.getUserId());
                }
                group.setGroupClaimStatus(isClaim(activityId, group.getActivityGroupId()));
                group.setUserIds(userIds);
                group.setMine(false);
                if (group.getUserIds() != null && group.getUserIds().size() > 0) {
                    group.setMine(group.getUserIds().contains(getUserId()));
                }
            }
            dto.setGroupList(groups);
        }

        claimDto.setUserId(getUserId());
        List<RepresentActivityClaim> tempList = claimService.selectRepresentActivityClaimList(claimDto);
        if (tempList.size() == 0) {
            dto.setClaim(null);
        } else dto.setClaim(tempList.stream().anyMatch(x -> x.getStatus() == 2));

        return AjaxResult.success(dto);
    }


    /**
     * 修改履职活动
     */
    @ApiOperation("修改")
    @PreAuthorize("@ss.hasPermi('represent:activity:edit')")
    @Log(title = "代-活动列", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ActivityAddDto representActivity) {
        representActivity.setUpdateBy(getNickName());
        return toAjax(representActivityService.newUpdate(representActivity));
    }

    /**
     * 删除代-活动列
     */
    @ApiOperation("删除")
    @PreAuthorize("@ss.hasPermi('represent:activity:remove')")
    @Log(title = "代-活动列", businessType = BusinessType.DELETE)
    @DeleteMapping("/{activityIds}")
    public AjaxResult remove(@PathVariable Long[] activityIds) {
        return toAjax(representActivityService.deleteRepresentActivityByActivityIds(activityIds));
    }

    @ApiOperation("履职统计")
    @GetMapping("/count")
    public AjaxResult totalConut() {
        return AjaxResult.success(representActivityService.totalConut());
    }


    @ApiOperation("新增")
    @PreAuthorize("@ss.hasPermi('represent:activity:add')")
    @Log(title = "代-活动列", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ActivityAddDto representActivity) {
        representActivity.setSendUserId(getUserId());
        representActivity.setCreateBy(getNickName());
        return toAjax(representActivityService.newAdd(representActivity));
    }


    @ApiOperation("分类饼图")
    @GetMapping(value = "/pie")
    public AjaxResult cake() {
        return AjaxResult.success(representActivityService.pie());
    }


    /**
     *  判断用户是否已认领的私有方法
     * @param activityId  活动id
     * @param groupId 分组id
     * @return true已认领，false未认领
     */
    private boolean isClaim(Long activityId, Long groupId) {
        RepresentActivityClaim claimDto = new RepresentActivityClaim();
        if (activityId != null) claimDto.setActivityId(activityId);
        if (groupId != null) claimDto.setActivityGroupId(groupId);
        claimDto.setStatus(2);
        claimDto.setUserId(getUserId());
        List<RepresentActivityClaim> tempList = claimService.selectRepresentActivityClaimList(claimDto);
        return tempList.size() > 0;
    }


}
