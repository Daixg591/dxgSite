package com.shahenpc.mpWeixin.controller.feature;

import com.shahenpc.common.annotation.Log;
import com.shahenpc.common.core.controller.BaseController;
import com.shahenpc.common.core.domain.AjaxResult;
import com.shahenpc.system.service.feature.IFeatureDoubleWorkService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "Wx添加双联工作")
@RestController
@RequestMapping("/wx/feature/work")
public class WxFeatureDoubleWorkController extends BaseController{

    @Autowired
    private IFeatureDoubleWorkService featureDoubleWorkService;
    /**总数-排名*/
    @ApiOperation("展示")
    @Log(title = "双联工作")
    @GetMapping("/countran")
    public AjaxResult countAndranking()
    {
        return AjaxResult.success(featureDoubleWorkService.countAndranking(getUserId()));
    }
}
