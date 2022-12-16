package com.shahenpc.web.controller.represent;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import io.lettuce.core.api.push.PushListener;
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
import com.shahenpc.system.domain.represent.RepresentActivityClaim;
import com.shahenpc.system.service.represent.IRepresentActivityClaimService;
import com.shahenpc.common.utils.poi.ExcelUtil;
import com.shahenpc.common.core.page.TableDataInfo;

/**
 * 【活动分组认领记录】Controller
 * 
 * @author ruoyi
 * @date 2022-12-15
 */
@RestController
@RequestMapping("/system/claim")
public class RepresentActivityClaimController extends BaseController
{
    @Autowired
    private IRepresentActivityClaimService representActivityClaimService;

    /**
     * 查询【活动分组认领记录】列表
     */
    @PreAuthorize("@ss.hasPermi('system:claim:list')")
    @GetMapping("/list")
    public TableDataInfo list(RepresentActivityClaim representActivityClaim)
    {
        startPage();
        List<RepresentActivityClaim> list = representActivityClaimService.selectRepresentActivityClaimList(representActivityClaim);
        return getDataTable(list);
    }

    /**
     * 导出【活动分组认领记录】列表
     */
    @PreAuthorize("@ss.hasPermi('system:claim:export')")
    @Log(title = "【活动分组认领记录】", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, RepresentActivityClaim representActivityClaim)
    {
        List<RepresentActivityClaim> list = representActivityClaimService.selectRepresentActivityClaimList(representActivityClaim);
        ExcelUtil<RepresentActivityClaim> util = new ExcelUtil<RepresentActivityClaim>(RepresentActivityClaim.class);
        util.exportExcel(response, list, "【活动分组认领记录】数据");
    }

    /**
     * 获取【活动分组认领记录】详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:claim:query')")
    @GetMapping(value = "/{claimId}")
    public AjaxResult getInfo(@PathVariable("claimId") Long claimId)
    {
        return AjaxResult.success(representActivityClaimService.selectRepresentActivityClaimByClaimId(claimId));
    }

    /**
     * 新增【活动分组认领记录】
     */
//    @PreAuthorize("@ss.hasPermi('system:claim:add')")
    @Log(title = "【活动分组认领记录】", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody RepresentActivityClaim representActivityClaim)
    {
        return toAjax(representActivityClaimService.insertRepresentActivityClaim(representActivityClaim));
    }

    /**
     * 修改【活动分组认领记录】
     */
    @PreAuthorize("@ss.hasPermi('system:claim:edit')")
    @Log(title = "【活动分组认领记录】", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody RepresentActivityClaim representActivityClaim)
    {
        return toAjax(representActivityClaimService.updateRepresentActivityClaim(representActivityClaim));
    }

    /**
     * 删除【活动分组认领记录】
     */
    @PreAuthorize("@ss.hasPermi('system:claim:remove')")
    @Log(title = "【活动分组认领记录】", businessType = BusinessType.DELETE)
	@DeleteMapping("/{claimIds}")
    public AjaxResult remove(@PathVariable Long[] claimIds)
    {
        return toAjax(representActivityClaimService.deleteRepresentActivityClaimByClaimIds(claimIds));
    }

//    @PreAuthorize("@ss.hasPermi('system:claim:edit')")
    @Log(title = "【活动分组认领记录】认领", businessType = BusinessType.UPDATE)
    @PutMapping("/npcClaim")
    public AjaxResult npcClaim(@RequestBody RepresentActivityClaim claim)
    {
        claim.setUserId(getUserId());
        System.out.println("*************************************************************************");
        System.out.println(claim);
        return toAjax(representActivityClaimService.npcClaim(claim));
    }
}
