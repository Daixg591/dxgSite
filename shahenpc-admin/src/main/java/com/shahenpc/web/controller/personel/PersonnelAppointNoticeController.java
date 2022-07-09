package com.shahenpc.web.controller.personel;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;

import com.shahenpc.common.core.domain.entity.SysUser;
import com.shahenpc.system.service.ISysUserService;
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
import com.shahenpc.system.domain.personel.PersonnelAppointNotice;
import com.shahenpc.system.service.personel.IPersonnelAppointNoticeService;
import com.shahenpc.common.utils.poi.ExcelUtil;
import com.shahenpc.common.core.page.TableDataInfo;

import static com.shahenpc.common.utils.string.StringHelper.afterTextChanged;

/**
 * 人事任免_任免通知Controller
 *
 * @author ruoyi
 * @date 2022-07-08
 */
@RestController
@Api(tags = "人事任免_任免通知 Done √")
@RequestMapping("/system/inform")
public class PersonnelAppointNoticeController extends BaseController {
    @Autowired
    private IPersonnelAppointNoticeService personnelAppointNoticeService;

    @Autowired
    private ISysUserService userService;

    /**
     * 查询人事任免_任免通知列表
     */
    @ApiOperation("查询-任免通知")
    @PreAuthorize("@ss.hasPermi('system:inform:list')")
    @GetMapping("/list")
    public TableDataInfo list(PersonnelAppointNotice personnelAppointNotice) {
        startPage();
        List<PersonnelAppointNotice> list = personnelAppointNoticeService.selectPersonnelAppointNoticeList(personnelAppointNotice);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getCreateBy() != "" && list.get(i).getCreateBy() != null) {
                SysUser user = userService.selectUserByUserName(list.get(i).getCreateBy());
                if (user != null) {
                    list.get(i).setNickName(user.getNickName());
                } else {
                    list.get(i).setNickName("--");
                }
            } else {
                list.get(i).setNickName("--");
            }
        }
        return getDataTable(list);
    }

    /**
     * 导出人事任免_任免通知列表
     */
    @PreAuthorize("@ss.hasPermi('system:inform:export')")
    @Log(title = "人事任免_任免通知", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, PersonnelAppointNotice personnelAppointNotice) {
        List<PersonnelAppointNotice> list = personnelAppointNoticeService.selectPersonnelAppointNoticeList(personnelAppointNotice);
        ExcelUtil<PersonnelAppointNotice> util = new ExcelUtil<PersonnelAppointNotice>(PersonnelAppointNotice.class);
        util.exportExcel(response, list, "人事任免_任免通知数据");
    }

    /**
     * 获取人事任免_任免通知详细信息
     */
    @ApiOperation("详情-任免通知")
    @PreAuthorize("@ss.hasPermi('system:inform:query')")
    @GetMapping(value = "/{noticeId}")
    public AjaxResult getInfo(@PathVariable("noticeId") Long noticeId) {
        PersonnelAppointNotice entity = personnelAppointNoticeService.selectPersonnelAppointNoticeByNoticeId(noticeId);
        SysUser userEntity = userService.selectUserByUserName(entity.getCreateBy());
        if (userEntity != null) {
            entity.setNickName(userEntity.getNickName());
        } else {
            entity.setNickName("--");
        }

        return AjaxResult.success(entity);
    }

    /**
     * 新增人事任免_任免通知
     */
    @ApiOperation("新增-任免通知")
    @PreAuthorize("@ss.hasPermi('system:inform:add')")
    @Log(title = "人事任免_任免通知", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PersonnelAppointNotice personnelAppointNotice) {
        personnelAppointNotice.setCreateBy(getUsername());
        return toAjax(personnelAppointNoticeService.insertPersonnelAppointNotice(personnelAppointNotice));
    }

    /**
     * 修改人事任免_任免通知
     */
    @PreAuthorize("@ss.hasPermi('system:inform:edit')")
    @ApiOperation("更新-任免通知")
    @Log(title = "人事任免_任免通知", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PersonnelAppointNotice personnelAppointNotice) {
        personnelAppointNotice.setUpdateBy(getUsername());
        return toAjax(personnelAppointNoticeService.updatePersonnelAppointNotice(personnelAppointNotice));
    }

    /**
     * 删除人事任免_任免通知
     */
    @ApiOperation("删除-任免通知")
    @PreAuthorize("@ss.hasPermi('system:inform:remove')")
    @Log(title = "人事任免_任免通知", businessType = BusinessType.DELETE)
    @DeleteMapping("/{noticeIds}")
    public AjaxResult remove(@PathVariable Long[] noticeIds) {
        return toAjax(personnelAppointNoticeService.deletePersonnelAppointNoticeByNoticeIds(noticeIds));
    }

    /**
     * 分享次数添加-任免通知
     *
     * @param noticeId
     * @return
     */
    @ApiOperation("分享次数添加-任免通知")
    @GetMapping(value = "/chareCnt/{noticeId}")
    public AjaxResult shareCnt(@PathVariable("noticeId") Long noticeId) {
        PersonnelAppointNotice entity = personnelAppointNoticeService.selectDetailByNoticeId(noticeId);
        if (entity.getShareCnt() == null) {
            entity.setShareCnt(0);
        }
        entity.setShareCnt(entity.getShareCnt() + 1);
        personnelAppointNoticeService.updatePersonnelAppointNotice(entity);
        return AjaxResult.success();
    }

    @ApiOperation("通知统计数据-任免通知")
    @GetMapping(value = "/noticeTJ")
    public AjaxResult noticeTJ() {
        PersonnelAppointNotice param = new PersonnelAppointNotice();
        param.setType(1);

        List<PersonnelAppointNotice> list = personnelAppointNoticeService.selectPersonnelAppointNoticeList(param);
        Map<String, String> res = new HashMap<>();
        res.put("total", afterTextChanged(list.size()+""));
        Integer readCnt = 0;
        Integer shareCnt = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getReadCnt()==null){
                list.get(i).setReadCnt(0);
            }
            if (list.get(i).getShareCnt()==null){
                list.get(i).setShareCnt(0);
            }
            shareCnt += list.get(i).getShareCnt();
            readCnt += list.get(i).getReadCnt();
        }
        res.put("shareCnt", afterTextChanged(shareCnt.toString()));
        res.put("readCnt", afterTextChanged(readCnt.toString()));
        return AjaxResult.success(res);
    }

}
