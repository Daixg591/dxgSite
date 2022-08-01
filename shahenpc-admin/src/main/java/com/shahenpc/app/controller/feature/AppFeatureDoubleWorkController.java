package com.shahenpc.app.controller.feature;

import com.shahenpc.common.annotation.Log;
import com.shahenpc.common.core.controller.BaseController;
import com.shahenpc.common.core.domain.AjaxResult;
import com.shahenpc.common.core.page.TableDataInfo;
import com.shahenpc.common.enums.BusinessType;
import com.shahenpc.system.domain.feature.FeatureDoubleWork;
import com.shahenpc.system.domain.feature.dto.DoubleAppListDto;
import com.shahenpc.system.service.feature.IFeatureDoubleWorkService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * app 双联工作
 */
@Api(tags = "App添加双联工作")
@RestController
@RequestMapping("/app/feature/work")
public class AppFeatureDoubleWorkController extends BaseController {

    @Autowired
    private IFeatureDoubleWorkService featureDoubleWorkService;
    //添加
    @ApiOperation("增加双联工作")
    @ApiImplicitParams({
            @ApiImplicitParam(name ="opinionId",value = "双联工作Id",required = true, dataType = "int", paramType = "path", dataTypeClass = Integer.class),
            @ApiImplicitParam(name ="opinionType",value = "意见类型",required = true, dataType = "int", paramType = "path", dataTypeClass = Integer.class),
            @ApiImplicitParam(name ="content",value = "内容",required = true, dataType = "String", paramType = "path", dataTypeClass = String.class),
            @ApiImplicitParam(name ="submitUserId",value = "提交人",required = true, dataType = "int", paramType = "path", dataTypeClass = Integer.class),
            @ApiImplicitParam(name ="submitNickName",value = "提交人",required = true, dataType = "String", paramType = "path", dataTypeClass = String.class),
            @ApiImplicitParam(name ="submitPhone",value = "手机号",required = true, dataType = "String", paramType = "path", dataTypeClass = String.class),
            @ApiImplicitParam(name ="receiveUserId",value = "接收人",required = true, dataType = "int", paramType = "path", dataTypeClass = Integer.class),
            @ApiImplicitParam(name ="receiveNickName",value = "接收人",required = true, dataType = "String", paramType = "path", dataTypeClass = String.class),
            @ApiImplicitParam(name ="receiveReply",value = "回复",required = true, dataType = "String", paramType = "path", dataTypeClass = String.class),
            @ApiImplicitParam(name ="status",value = "状态",required = true, dataType = "int", paramType = "path", dataTypeClass = Integer.class),
            @ApiImplicitParam(name ="replyTime",value = "回复时间",required = true, dataType = "Date", paramType = "path", dataTypeClass = Date.class)
    })
    @Log(title = "双联工作", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody FeatureDoubleWork featureDoubleWork)
    {
        featureDoubleWork.setCreateBy(getUsername());
        featureDoubleWork.setSubmitUserId(getUserId());
        return toAjax(featureDoubleWorkService.newAdd(featureDoubleWork));
    }

    /**
     * 我发送的
     * @param featureDoubleWork
     * @return
     */
    @ApiOperation("双联工作列表")
    @GetMapping("/my/list")
    public TableDataInfo myList(FeatureDoubleWork featureDoubleWork)
    {
        startPage();
        if(featureDoubleWork.getStatus() == 0){
            featureDoubleWork.setStatus(null);
        }
        featureDoubleWork.setSubmitUserId(getUserId());
        List<DoubleAppListDto> list = featureDoubleWorkService.appList(featureDoubleWork);
        return getDataTable(list);
    }
    /**
     * 我审核的
     */
    @ApiOperation("双联工作列表")
    @GetMapping("/audit/list")
    public TableDataInfo auditList(FeatureDoubleWork featureDoubleWork)
    {
        startPage();
        if(featureDoubleWork.getStatus() == 0){
            featureDoubleWork.setStatus(null);
        }
        featureDoubleWork.setReceiveUserId(getUserId());
        List<FeatureDoubleWork> list = featureDoubleWorkService.selectFeatureDoubleWorkList(featureDoubleWork);
        return getDataTable(list);
    }
    /**
     * 修改双联工作
     */
    @ApiOperation("修改双联工作")
    @Log(title = "双联工作", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody FeatureDoubleWork featureDoubleWork)
    {
        return toAjax(featureDoubleWorkService.newUpdate(featureDoubleWork));
    }
}
