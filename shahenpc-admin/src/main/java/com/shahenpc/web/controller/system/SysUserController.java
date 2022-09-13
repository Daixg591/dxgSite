package com.shahenpc.web.controller.system;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletResponse;

import com.shahenpc.system.domain.represent.RepresentHomeAccess;
import com.shahenpc.system.domain.wxsmallprogram.vo.WxUserInfoVo;
import com.shahenpc.system.service.*;
import com.shahenpc.system.service.represent.IRepresentHomeAccessService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.shahenpc.common.annotation.Log;
import com.shahenpc.common.constant.UserConstants;
import com.shahenpc.common.core.controller.BaseController;
import com.shahenpc.common.core.domain.AjaxResult;
import com.shahenpc.common.core.domain.entity.SysRole;
import com.shahenpc.common.core.domain.entity.SysUser;
import com.shahenpc.common.core.page.TableDataInfo;
import com.shahenpc.common.enums.BusinessType;
import com.shahenpc.common.utils.SecurityUtils;
import com.shahenpc.common.utils.StringUtils;
import com.shahenpc.common.utils.poi.ExcelUtil;

/**
 * 用户信息
 *
 * @author ruoyi
 */
@Api(tags = "用户管理")
@RestController
@RequestMapping("/system/user")
public class SysUserController extends BaseController {
    @Autowired
    private ISysUserService userService;

    @Autowired
    private ISysRoleService roleService;

    @Autowired
    private ISysPostService postService;

    @Autowired
    private ISysConfigService configService;

    @Autowired
    private ISysDictDataService dictDataService;

    @Autowired
    private IRepresentHomeAccessService homeAccessService;

    /**
     * 获取用户列表
     */
    @PreAuthorize("@ss.hasPermi('system:user:list')")
    @GetMapping("/list")
    public TableDataInfo list(SysUser user) {
        startPage();
        List<SysUser> list = userService.selectUserList(user);
        return getDataTable(list);
    }

    @GetMapping("/deputy/list")
    public TableDataInfo wxList(SysUser user) {
        startPage();
        user.setIdentity("1");
        List<SysUser> list = userService.selectUserList(user);
        return getDataTable(list);
    }


    @Log(title = "用户管理", businessType = BusinessType.EXPORT)
    @PreAuthorize("@ss.hasPermi('system:user:export')")
    @PostMapping("/export")
    public void export(HttpServletResponse response, SysUser user) {
        List<SysUser> list = userService.selectUserList(user);
        ExcelUtil<SysUser> util = new ExcelUtil<SysUser>(SysUser.class);
        util.exportExcel(response, list, "用户数据");
    }

    @Log(title = "用户管理", businessType = BusinessType.IMPORT)
    @PreAuthorize("@ss.hasPermi('system:user:import')")
    @PostMapping("/importData")
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception {
        ExcelUtil<SysUser> util = new ExcelUtil<SysUser>(SysUser.class);
        List<SysUser> userList = util.importExcel(file.getInputStream());
        for (int i = 0; i < userList.size(); i++) {
            if (StringUtils.isEmpty(userList.get(i).getUserName()) || StringUtils.isNull(userList.get(i).getUserName())) {
                userList.get(i).setUserName(userList.get(i).getPhonenumber());
            }
        }
        String operName = getUsername();
        String message = userService.importUser(userList, updateSupport, operName);
        return AjaxResult.success(message);
    }

    @PostMapping("/importTemplate")
    public void importTemplate(HttpServletResponse response) {
        ExcelUtil<SysUser> util = new ExcelUtil<SysUser>(SysUser.class);
        util.importTemplateExcel(response, "用户数据");
    }

    /**
     * 根据用户编号获取详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:user:query')")
    @GetMapping(value = {"/", "/{userId}"})
    public AjaxResult getInfo(@PathVariable(value = "userId", required = false) Long userId) {
        userService.checkUserDataScope(userId);
        AjaxResult ajax = AjaxResult.success();
        List<SysRole> roles = roleService.selectRoleAll();
        ajax.put("roles", SysUser.isAdmin(userId) ? roles : roles.stream().filter(r -> !r.isAdmin()).collect(Collectors.toList()));
        ajax.put("posts", postService.selectPostAll());
        if (StringUtils.isNotNull(userId)) {
            SysUser sysUser = userService.selectUserById(userId);
            ajax.put(AjaxResult.DATA_TAG, sysUser);
            ajax.put("postIds", postService.selectPostListByUserId(userId));
            ajax.put("roleIds", sysUser.getRoles().stream().map(SysRole::getRoleId).collect(Collectors.toList()));
        }
        return ajax;
    }

    /**
     * 小程序获取用户基础信息
     *
     * @param userId
     * @return
     */
    @GetMapping(value = "/getWxUser/{userId}")
    public AjaxResult getUser(@PathVariable(value = "userId", required = false) Long userId) {
        WxUserInfoVo resInfo = new WxUserInfoVo();

        if (StringUtils.isNotNull(userId)) {
            SysUser sysUser = userService.selectUserById(userId);
            resInfo.setUserId(sysUser.getUserId());
            resInfo.setNickName(sysUser.getNickName());
            resInfo.setPersonInfo(sysUser.getResume());
            resInfo.setAvatar(sysUser.getAvatar());
            resInfo.setGoodAreaName(dictDataService.selectDictLabel("double_type", sysUser.getGoodArea()));
            if (sysUser.getContactStationId()!=null ) {
                RepresentHomeAccess homeAccess = homeAccessService.selectRepresentHomeAccessByAccessId(sysUser.getContactStationId());
                resInfo.setStationName(homeAccess.getTitle());
            }
            else {
                resInfo.setStationName("暂无信息");
            }
        }
        return AjaxResult.success(resInfo);
    }

    /**
     * 小程序获取人大信息列表(用户信息处理,不返所有信息)
     *
     * @param user
     * @return
     */
    @GetMapping(value = "/getWxUser/list")
    public TableDataInfo getUserList(SysUser user) {
        startPage();
        List<WxUserInfoVo> list= userService.selectXcxList(user);
        /*user.setIdentity("1");
        List<SysUser> list = userService.selectRandUserList(user);
        List<WxUserInfoVo> res = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            WxUserInfoVo item = new WxUserInfoVo();
            item.setUserId(list.get(i).getUserId());
            item.setNickName(list.get(i).getNickName());
            item.setPersonInfo(list.get(i).getResume());
            item.setAvatar(list.get(i).getAvatar());
            item.setGoodAreaName(dictDataService.selectDictLabel("double_type", list.get(i).getGoodArea()));
            if (list.get(i).getContactStationId()!=null ) {
                RepresentHomeAccess homeAccess = homeAccessService.selectRepresentHomeAccessByAccessId(list.get(i).getContactStationId());
                item.setStationName(homeAccess.getTitle());
            }
            else {
                item.setStationName("暂无信息");
            }
//            item.setStationName("暂无信息");

            res.add(item);
        }*/
        return getDataTable(list);
    }


    /**
     * 新增用户
     */
    @PreAuthorize("@ss.hasPermi('system:user:add')")
    @Log(title = "用户管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@Validated @RequestBody SysUser user) {
        if (UserConstants.NOT_UNIQUE.equals(userService.checkUserNameUnique(user.getUserName()))) {
            return AjaxResult.error("新增用户'" + user.getUserName() + "'失败，登录账号已存在");
        } else if (StringUtils.isNotEmpty(user.getPhonenumber())
                && UserConstants.NOT_UNIQUE.equals(userService.checkPhoneUnique(user))) {
            return AjaxResult.error("新增用户'" + user.getUserName() + "'失败，手机号码已存在");
        } else if (StringUtils.isNotEmpty(user.getEmail())
                && UserConstants.NOT_UNIQUE.equals(userService.checkEmailUnique(user))) {
            return AjaxResult.error("新增用户'" + user.getUserName() + "'失败，邮箱账号已存在");
        }
        user.setCreateBy(getUsername());
        if (user.getPassword() == "" || user.getPassword() == null) {
            //.selectConfigByKey("sys.user.initPassword");
            user.setPassword(SecurityUtils.encryptPassword(user.getPhonenumber().substring(user.getPhonenumber().length() - 6)));
        } else {
            user.setPassword(SecurityUtils.encryptPassword(user.getPassword()));
        }
        return toAjax(userService.insertUser(user));
    }

    /**
     * 修改用户
     */
    @PreAuthorize("@ss.hasPermi('system:user:edit')")
    @Log(title = "用户管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@Validated @RequestBody SysUser user) {
        userService.checkUserAllowed(user);
        userService.checkUserDataScope(user.getUserId());
//        if (StringUtils.isNotEmpty(user.getPhonenumber())
//                && UserConstants.NOT_UNIQUE.equals(userService.checkPhoneUnique(user))) {
//            return AjaxResult.error("修改用户'" + user.getUserName() + "'失败，手机号码已存在");
//        } else if (StringUtils.isNotEmpty(user.getEmail())
//                && UserConstants.NOT_UNIQUE.equals(userService.checkEmailUnique(user))) {
//            return AjaxResult.error("修改用户'" + user.getUserName() + "'失败，邮箱账号已存在");
//        }
        user.setUpdateBy(getUsername());
        return toAjax(userService.updateUser(user));
    }

    /**
     * 删除用户
     */
    @PreAuthorize("@ss.hasPermi('system:user:remove')")
    @Log(title = "用户管理", businessType = BusinessType.DELETE)
    @DeleteMapping("/{userIds}")
    public AjaxResult remove(@PathVariable Long[] userIds) {
        if (ArrayUtils.contains(userIds, getUserId())) {
            return error("当前用户不能删除");
        }
        return toAjax(userService.deleteUserByIds(userIds));
    }

    /**
     * 重置密码
     */
    @PreAuthorize("@ss.hasPermi('system:user:resetPwd')")
    @Log(title = "用户管理", businessType = BusinessType.UPDATE)
    @PutMapping("/resetPwd")
    public AjaxResult resetPwd(@RequestBody SysUser user) {
        userService.checkUserAllowed(user);
        userService.checkUserDataScope(user.getUserId());
        user.setPassword(SecurityUtils.encryptPassword(user.getPassword()));
        user.setUpdateBy(getUsername());
        return toAjax(userService.resetPwd(user));
    }

    /**
     * 状态修改
     */
    @PreAuthorize("@ss.hasPermi('system:user:edit')")
    @Log(title = "用户管理", businessType = BusinessType.UPDATE)
    @PutMapping("/changeStatus")
    public AjaxResult changeStatus(@RequestBody SysUser user) {
        userService.checkUserAllowed(user);
        userService.checkUserDataScope(user.getUserId());
        user.setUpdateBy(getUsername());
        return toAjax(userService.updateUserStatus(user));
    }

    /**
     * 根据用户编号获取授权角色
     */
    @PreAuthorize("@ss.hasPermi('system:user:query')")
    @GetMapping("/authRole/{userId}")
    public AjaxResult authRole(@PathVariable("userId") Long userId) {
        AjaxResult ajax = AjaxResult.success();
        SysUser user = userService.selectUserById(userId);
        List<SysRole> roles = roleService.selectRolesByUserId(userId);
        ajax.put("user", user);
        ajax.put("roles", SysUser.isAdmin(userId) ? roles : roles.stream().filter(r -> !r.isAdmin()).collect(Collectors.toList()));
        return ajax;
    }

    /**
     * 用户授权角色
     */
    @PreAuthorize("@ss.hasPermi('system:user:edit')")
    @Log(title = "用户管理", businessType = BusinessType.GRANT)
    @PutMapping("/authRole")
    public AjaxResult insertAuthRole(Long userId, Long[] roleIds) {
        userService.checkUserDataScope(userId);
        userService.insertUserAuth(userId, roleIds);
        return success();
    }

    /**
     * 人大常委 下拉 用户列表  用于审批流程
     */
    @ApiOperation("人大常委人员下拉")
    @PreAuthorize("@ss.hasPermi('system:user:list')")
    @GetMapping("/npc/list")
    public TableDataInfo NpcList(SysUser user) {
        startPage();
        List<SysUser> list = userService.selectUserList(user);
        return getDataTable(list);
    }


    /**
     * 人大代表性别分布
     */
    @ApiOperation("性别饼图")
    @GetMapping("/gender/cake/{identity}")
    public AjaxResult genderCake(@PathVariable("identity") String identity) {
        return AjaxResult.success(userService.genderCake(identity));
    }

    /**
     * 人大代表年龄分布
     */
    @ApiOperation("年龄饼图")
    @GetMapping("/age/cake/{identity}")
    public AjaxResult ageCake(@PathVariable("identity") String identity) {

        return AjaxResult.success(userService.ageCake(identity));
    }

    /**
     * 人大代表学历分布
     */
    @ApiOperation("学历饼图")
    @GetMapping("/degree/cake/{identity}")
    public AjaxResult degreeCake(@PathVariable("identity") String identity) {

        return AjaxResult.success(userService.degreeCake(identity));
    }


    @PreAuthorize("@ss.hasPermi('system:user:edit')")
    @Log(title = "用户管理", businessType = BusinessType.UPDATE)
    @PutMapping("/update")
    public AjaxResult update(@RequestBody SysUser user) {
        //user.setStatus("1");
        return toAjax(userService.updateUser(user));
    }
}
