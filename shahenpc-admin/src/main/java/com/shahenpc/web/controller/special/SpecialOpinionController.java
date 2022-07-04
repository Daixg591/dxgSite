package com.shahenpc.web.controller.special;

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
import com.shahenpc.system.domain.special.SpecialOpinion;
import com.shahenpc.system.service.special.ISpecialOpinionService;
import com.shahenpc.common.utils.poi.ExcelUtil;
import com.shahenpc.common.core.page.TableDataInfo;

/**
 * 【双联工作】Controller
 * 
 * @author ruoyi
 * @date 2022-07-01
 */
@Api(tags = "双联工作管理")
@RestController
@RequestMapping("/system/opinion")
public class SpecialOpinionController extends BaseController
{
    @Autowired
    private ISpecialOpinionService specialOpinionService;

    /**
     * 查询【请填写功能名称】列表
     */
    @ApiOperation("双联工作列表")
    @PreAuthorize("@ss.hasPermi('system:opinion:list')")
    @GetMapping("/list")
    public TableDataInfo list(SpecialOpinion specialOpinion)
    {
        startPage();
        List<SpecialOpinion> list = specialOpinionService.selectSpecialOpinionList(specialOpinion);
        return getDataTable(list);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('system:opinion:export')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SpecialOpinion specialOpinion)
    {
        List<SpecialOpinion> list = specialOpinionService.selectSpecialOpinionList(specialOpinion);
        ExcelUtil<SpecialOpinion> util = new ExcelUtil<SpecialOpinion>(SpecialOpinion.class);
        util.exportExcel(response, list, "【请填写功能名称】数据");
    }

    /**
     * 获取【请填写功能名称】详细信息
     */
    @ApiOperation("双联工作详情")
    @ApiImplicitParam(name ="opinionId",value = "双联工作Id",required = true, dataType = "Long", paramType = "path", dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermi('system:opinion:query')")
    @GetMapping(value = "/{opinionId}")
    public AjaxResult getInfo(@PathVariable("opinionId") Long opinionId)
    {
        return AjaxResult.success(specialOpinionService.selectSpecialOpinionByOpinionId(opinionId));
    }

    /**
     * 新增【请填写功能名称】
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
    @PreAuthorize("@ss.hasPermi('system:opinion:add')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SpecialOpinion specialOpinion)
    {
        return toAjax(specialOpinionService.insertSpecialOpinion(specialOpinion));
    }

    /**
     * 修改【请填写功能名称】
     */
    @ApiOperation("修改双联工作")
    @PreAuthorize("@ss.hasPermi('system:opinion:edit')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SpecialOpinion specialOpinion)
    {
        return toAjax(specialOpinionService.updateSpecialOpinion(specialOpinion));
    }

    /**
     * 删除【请填写功能名称】
     */
    @ApiOperation("删除双联工作")
    @PreAuthorize("@ss.hasPermi('system:opinion:remove')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
	@DeleteMapping("/{opinionIds}")
    public AjaxResult remove(@PathVariable Long[] opinionIds)
    {
        return toAjax(specialOpinionService.deleteSpecialOpinionByOpinionIds(opinionIds));
    }
}
