package com.shahenpc.web.controller.feature;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import io.swagger.annotations.Api;
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
import com.shahenpc.system.domain.feature.FeatureSensitiveWord;
import com.shahenpc.system.service.feature.IFeatureSensitiveWordService;
import com.shahenpc.common.utils.poi.ExcelUtil;
import com.shahenpc.common.core.page.TableDataInfo;

/**
 * 重点工作-敏感词管理Controller
 * 
 * @author ruoyi
 * @date 2022-08-10
 */
@Api(tags = "敏感词管理")
@RestController
@RequestMapping("/feature/sensitive")
public class FeatureSensitiveWordController extends BaseController
{
    @Autowired
    private IFeatureSensitiveWordService featureSensitiveWordService;

    /**
     * 查询重点工作-敏感词管理列表
     */
    @ApiOperation("列表")
    @PreAuthorize("@ss.hasPermi('feature:system:list')")
    @GetMapping("/list")
    public TableDataInfo list(FeatureSensitiveWord featureSensitiveWord)
    {
        startPage();
        List<FeatureSensitiveWord> list = featureSensitiveWordService.selectFeatureSensitiveWordList(featureSensitiveWord);
        return getDataTable(list);
    }

    /**
     * 导出重点工作-敏感词管理列表
     */
    @ApiOperation("导出")
    @PreAuthorize("@ss.hasPermi('feature:system:export')")
    @Log(title = "重点工作-敏感词管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, FeatureSensitiveWord featureSensitiveWord)
    {
        List<FeatureSensitiveWord> list = featureSensitiveWordService.selectFeatureSensitiveWordList(featureSensitiveWord);
        ExcelUtil<FeatureSensitiveWord> util = new ExcelUtil<FeatureSensitiveWord>(FeatureSensitiveWord.class);
        util.exportExcel(response, list, "重点工作-敏感词管理数据");
    }

    /**
     * 获取重点工作-敏感词管理详细信息
     */
    @ApiOperation("详情")
    @PreAuthorize("@ss.hasPermi('feature:system:query')")
    @GetMapping(value = "/{sensitiveId}")
    public AjaxResult getInfo(@PathVariable("sensitiveId") Long sensitiveId)
    {
        return AjaxResult.success(featureSensitiveWordService.selectFeatureSensitiveWordBySensitiveId(sensitiveId));
    }

    /**
     * 新增重点工作-敏感词管理
     */
    @ApiOperation("新增")
    @PreAuthorize("@ss.hasPermi('feature:system:add')")
    @Log(title = "重点工作-敏感词管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody FeatureSensitiveWord featureSensitiveWord)
    {
        featureSensitiveWord.setCreateBy(getNickName());
        return toAjax(featureSensitiveWordService.insertFeatureSensitiveWord(featureSensitiveWord));
    }

    /**
     * 修改重点工作-敏感词管理
     */
    @ApiOperation("修改")
    @PreAuthorize("@ss.hasPermi('feature:system:edit')")
    @Log(title = "重点工作-敏感词管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody FeatureSensitiveWord featureSensitiveWord)
    {
        featureSensitiveWord.setUpdateBy(getNickName());
        return toAjax(featureSensitiveWordService.updateFeatureSensitiveWord(featureSensitiveWord));
    }

    /**
     * 删除重点工作-敏感词管理
     */
    @ApiOperation("删除")
    @PreAuthorize("@ss.hasPermi('feature:system:remove')")
    @Log(title = "重点工作-敏感词管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{sensitiveIds}")
    public AjaxResult remove(@PathVariable Long[] sensitiveIds)
    {
        return toAjax(featureSensitiveWordService.deleteFeatureSensitiveWordBySensitiveIds(sensitiveIds));
    }
}
