package com.shahenpc.web.controller.feature;

import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
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
import com.shahenpc.system.domain.feature.FeatureDoubleWork;
import com.shahenpc.system.service.feature.IFeatureDoubleWorkService;
import com.shahenpc.common.utils.poi.ExcelUtil;
import com.shahenpc.common.core.page.TableDataInfo;

/**
 * 双联工作Controller
 * 
 * @author ruoyi
 * @date 2022-07-15
 */
@Api(tags = "双联工作")
@RestController
@RequestMapping("/feature/work")
public class FeatureDoubleWorkController extends BaseController
{
    @Autowired
    private IFeatureDoubleWorkService featureDoubleWorkService;

    /**
     * 查询双联工作列表
     */
    @ApiOperation("双联工作列表")
    @PreAuthorize("@ss.hasPermi('feature:work:list')")
    @GetMapping("/list")
    public TableDataInfo list(FeatureDoubleWork featureDoubleWork)
    {
        startPage();
        List<FeatureDoubleWork> list = featureDoubleWorkService.selectFeatureDoubleWorkList(featureDoubleWork);
        return getDataTable(list);
    }

    /**
     * 导出双联工作列表
     */
    @PreAuthorize("@ss.hasPermi('feature:work:export')")
    @Log(title = "双联工作", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, FeatureDoubleWork featureDoubleWork)
    {
        List<FeatureDoubleWork> list = featureDoubleWorkService.selectFeatureDoubleWorkList(featureDoubleWork);
        ExcelUtil<FeatureDoubleWork> util = new ExcelUtil<FeatureDoubleWork>(FeatureDoubleWork.class);
        util.exportExcel(response, list, "双联工作数据");
    }

    /**
     * 获取双联工作详细信息
     */
    @ApiOperation("双联工作详情")
    @ApiImplicitParam(name ="opinionId",value = "双联工作Id",required = true, dataType = "Long", paramType = "path", dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermi('feature:work:query')")
    @GetMapping(value = "/{doubleId}")
    public AjaxResult getInfo(@PathVariable("doubleId") Long doubleId)
    {
        return AjaxResult.success(featureDoubleWorkService.selectFeatureDoubleWorkByDoubleId(doubleId));
    }

    /**
     * 新增双联工作
     */
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
    @PreAuthorize("@ss.hasPermi('feature:work:add')")
    @Log(title = "双联工作", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody FeatureDoubleWork featureDoubleWork)
    {
        featureDoubleWork.setSubmitUserId(getUserId());
        return toAjax(featureDoubleWorkService.newAdd(featureDoubleWork));
    }

    /**
     * 修改双联工作
     */
    @ApiOperation("修改双联工作")
    @PreAuthorize("@ss.hasPermi('feature:work:edit')")
    @Log(title = "双联工作", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody FeatureDoubleWork featureDoubleWork)
    {
        return toAjax(featureDoubleWorkService.newUpdate(featureDoubleWork));
    }

    /**
     * 删除双联工作
     */
    @ApiOperation("删除双联工作")
    @PreAuthorize("@ss.hasPermi('feature:work:remove')")
    @Log(title = "双联工作", businessType = BusinessType.DELETE)
	@DeleteMapping("/{doubleIds}")
    public AjaxResult remove(@PathVariable Long[] doubleIds)
    {
        return toAjax(featureDoubleWorkService.deleteFeatureDoubleWorkByDoubleIds(doubleIds));
    }

    /**
     * 饼图
     * @return
     */
    @ApiOperation("瓶图展示")
    @GetMapping(value = "/cake")
    public AjaxResult cake()
    {
        return AjaxResult.success(featureDoubleWorkService.speCake());
    }

    @ApiOperation("各个总数比例")
    @GetMapping(value = "/each")
    public AjaxResult each()
    {
        return AjaxResult.success(featureDoubleWorkService.eachCount());
    }

    @ApiOperation("曲线")
    @GetMapping("/line")
    public AjaxResult line(){
        return AjaxResult.success(featureDoubleWorkService.line());
    }



    /**
     * 添加流程
    @ApiOperation("添加")
    @PreAuthorize("@ss.hasPermi('feature:work:add')")
    @Log(title = "双联工作", businessType = BusinessType.INSERT)
    @PostMapping("/new/add")
    public AjaxResult newAdd(@RequestBody FeatureDoubleWork featureDoubleWork)
    {
        featureDoubleWork.setSubmitUserId(getUserId());
        return toAjax(featureDoubleWorkService.newAdd(featureDoubleWork));
    } */

}
