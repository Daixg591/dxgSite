package com.shahenpc.app.controller.system;

import com.shahenpc.common.core.controller.BaseController;
import com.shahenpc.common.core.domain.entity.SysUser;
import com.shahenpc.common.core.page.TableDataInfo;
import com.shahenpc.system.service.ISysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api( tags = "app用户管理")
@RestController
@RequestMapping("/app/system/user")
public class AppSysUserController extends BaseController {

    @Autowired
    private ISysUserService userService;
    /**
     * 获取用户列表
     */
    @ApiOperation("列表")
    @GetMapping("/list")
    public TableDataInfo list(SysUser user)
    {
        startPage();
        user.setIdentity("1");
        List<SysUser> list = userService.selectUserList(user);
        return getDataTable(list);
    }
}
