package com.shahenpc.web.controller.oa;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson2.JSON;
import com.shahenpc.common.utils.StringUtils;
import com.shahenpc.common.utils.http.HttpUtils;
import com.shahenpc.system.domain.wxsmallprogram.dto.WxAuthDto;
import com.shahenpc.system.domain.wxsmallprogram.vo.WxAuthVo;
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
import com.shahenpc.system.domain.oa.OvVoteRecord;
import com.shahenpc.system.service.oa.IOvVoteRecordService;
import com.shahenpc.common.utils.poi.ExcelUtil;
import com.shahenpc.common.core.page.TableDataInfo;

/**
 * 投票记录Controller
 * 
 * @author ruoyi
 * @date 2022-09-05
 */
@RestController
@RequestMapping("/oa/vote/record")
public class OvVoteRecordController extends BaseController
{
    @Autowired
    private IOvVoteRecordService ovVoteRecordService;

    /**
     * 查询投票记录列表
     */
    @PreAuthorize("@ss.hasPermi('vote:record:list')")
    @GetMapping("/list")
    public TableDataInfo list(OvVoteRecord ovVoteRecord)
    {
        startPage();
        List<OvVoteRecord> list = ovVoteRecordService.selectOvVoteRecordList(ovVoteRecord);
        return getDataTable(list);
    }

    /**
     * 导出投票记录列表
     */
    @PreAuthorize("@ss.hasPermi('vote:record:export')")
    @Log(title = "投票记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, OvVoteRecord ovVoteRecord)
    {
        List<OvVoteRecord> list = ovVoteRecordService.selectOvVoteRecordList(ovVoteRecord);
        ExcelUtil<OvVoteRecord> util = new ExcelUtil<OvVoteRecord>(OvVoteRecord.class);
        util.exportExcel(response, list, "投票记录数据");
    }

    /**
     * 获取投票记录详细信息
     */
    @PreAuthorize("@ss.hasPermi('vote:record:query')")
    @GetMapping(value = "/{recordId}")
    public AjaxResult getInfo(@PathVariable("recordId") Long recordId)
    {
        return AjaxResult.success(ovVoteRecordService.selectOvVoteRecordByRecordId(recordId));
    }

    /**
     * 新增投票记录
     */
    @Log(title = "投票记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody List<OvVoteRecord> ovVoteRecord,@RequestBody String code)
    {
        for (OvVoteRecord item:ovVoteRecord) {
            item.setUserId(getUserId());
            item.setCreateBy(getNickName());
            item.setOpenId(getWxOpenId(code));
            return toAjax(ovVoteRecordService.insertOvVoteRecord(item));
        }
        return AjaxResult.error();
    }

    private String getWxOpenId(String code) {
        WxAuthDto dto = new WxAuthDto();
        dto.setJs_code(code);
        dto.setGrant_type("authorization_code");
        String param = getParamStr(dto);
        String res = HttpUtils.sendGet("https://api.weixin.qq.com/sns/jscode2session", param);
        WxAuthVo authVo = JSON.parseObject(JSON.parse(res).toString(), WxAuthVo.class);
        if (authVo != null) {
            return authVo.getOpenid();
        } else {
            return "";
        }
    }

    public String getParamStr(WxAuthDto dto) {
        String resParam = "appid=" + dto.getAppid() + "&secret=" + dto.getSecret()
                + "&grant_type=" + dto.getGrant_type();
        if (!StringUtils.isEmpty(dto.getJs_code())) {
            resParam += "&js_code=" + dto.getJs_code();
        }
        return resParam;
    }


    /**
     * 修改投票记录
     */
    @PreAuthorize("@ss.hasPermi('vote:record:edit')")
    @Log(title = "投票记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody OvVoteRecord ovVoteRecord)
    {
        return toAjax(ovVoteRecordService.updateOvVoteRecord(ovVoteRecord));
    }

    /**
     * 删除投票记录
     */
    @PreAuthorize("@ss.hasPermi('vote:record:remove')")
    @Log(title = "投票记录", businessType = BusinessType.DELETE)
	@DeleteMapping("/{recordIds}")
    public AjaxResult remove(@PathVariable Long[] recordIds)
    {
        return toAjax(ovVoteRecordService.deleteOvVoteRecordByRecordIds(recordIds));
    }
}
