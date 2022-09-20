package com.shahenpc.web.controller.represent;

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
import com.shahenpc.system.domain.represent.RepresentProposal;
import com.shahenpc.system.service.represent.IRepresentProposalService;
import com.shahenpc.common.utils.poi.ExcelUtil;
import com.shahenpc.common.core.page.TableDataInfo;

/**
 * 代-建议Controller
 * 
 * @author ruoyi
 * @date 2022-09-20
 */
@Api(tags = "代表建议Controller")
@RestController
@RequestMapping("/represent/proposal")
public class RepresentProposalController extends BaseController
{
    @Autowired
    private IRepresentProposalService representProposalService;

    /**
     * 查询代-建议列表
     */
    @ApiOperation("列表")
    @GetMapping("/list")
    public TableDataInfo list(RepresentProposal representProposal)
    {
        startPage();
        List<RepresentProposal> list = representProposalService.selectRepresentProposalList(representProposal);
        return getDataTable(list);
    }

    /**
     * 导出代-建议列表
     */
    @ApiOperation("导出")
    @PreAuthorize("@ss.hasPermi('represent:proposal:export')")
    @Log(title = "代-建议", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, RepresentProposal representProposal)
    {
        List<RepresentProposal> list = representProposalService.selectRepresentProposalList(representProposal);
        ExcelUtil<RepresentProposal> util = new ExcelUtil<RepresentProposal>(RepresentProposal.class);
        util.exportExcel(response, list, "代-建议数据");
    }

    /**
     * 获取代-建议详细信息
     */
    @ApiOperation("详情")
    @PreAuthorize("@ss.hasPermi('represent:proposal:query')")
    @GetMapping(value = "/{proposalId}")
    public AjaxResult getInfo(@PathVariable("proposalId") Long proposalId)
    {
        return AjaxResult.success(representProposalService.selectRepresentProposalByProposalId(proposalId));
    }

    /**
     * 新增代-建议
     */
    @ApiOperation("新增")
    @PreAuthorize("@ss.hasPermi('represent:proposal:add')")
    @Log(title = "代-建议", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody RepresentProposal representProposal)
    {
        return toAjax(representProposalService.insertRepresentProposal(representProposal));
    }

    /**
     * 修改代-建议
     */
    @ApiOperation("修改")
    @PreAuthorize("@ss.hasPermi('represent:proposal:edit')")
    @Log(title = "代-建议", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody RepresentProposal representProposal)
    {
        return toAjax(representProposalService.updateRepresentProposal(representProposal));
    }

    /**
     * 删除代-建议
     */
    @ApiOperation("删除")
    @PreAuthorize("@ss.hasPermi('represent:proposal:remove')")
    @Log(title = "代-建议", businessType = BusinessType.DELETE)
	@DeleteMapping("/{proposalIds}")
    public AjaxResult remove(@PathVariable Long[] proposalIds)
    {
        return toAjax(representProposalService.deleteRepresentProposalByProposalIds(proposalIds));
    }

    /**
     * 办结率
     * @return
     */
    @ApiOperation("办结率")
    @GetMapping("/conclude/ring")
    public AjaxResult concludeRing()
    {
        return AjaxResult.success(representProposalService.concludeRing());
    }

    /**
     * 满意率
     * @return
     */
    @ApiOperation("满意率")
    @GetMapping("/satisfied/ring")
    public AjaxResult satisfiedRing()
    {
        return AjaxResult.success(representProposalService.satisfiedRing());
    }




}
