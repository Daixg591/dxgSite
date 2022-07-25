package com.shahenpc.mpWeixin.controller.system;

import com.shahenpc.common.constant.Constants;
import com.shahenpc.common.core.domain.AjaxResult;
import com.shahenpc.framework.web.service.SysLoginService;
import com.shahenpc.system.domain.dto.XcxLoginDto;
import com.shahenpc.system.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wx/user")
public class WxSysLoginController {
    @Autowired
    private ISysUserService userService;
    @Autowired
    private SysLoginService loginService;

    /** 小程序登录*/
    @RequestMapping("xcxLogin")
    public AjaxResult xcxLogin(@RequestBody XcxLoginDto requestParam) {
        AjaxResult ajax = AjaxResult.success();
        return AjaxResult.success(loginService.xcxLogin(requestParam));
    }
}
