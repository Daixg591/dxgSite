package com.shahenpc.framework.web.service;

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.bean.WxMaJscode2SessionResult;
import cn.binarywang.wx.miniapp.bean.WxMaPhoneNumberInfo;
import cn.binarywang.wx.miniapp.bean.WxMaUserInfo;
import com.shahenpc.common.constant.CacheConstants;
import com.shahenpc.common.constant.Constants;
import com.shahenpc.common.constant.UserConstants;
import com.shahenpc.common.core.domain.AjaxResult;
import com.shahenpc.common.core.domain.entity.SysUser;
import com.shahenpc.common.core.domain.model.LoginUser;
import com.shahenpc.common.core.redis.RedisCache;
import com.shahenpc.common.exception.ServiceException;
import com.shahenpc.common.exception.user.CaptchaException;
import com.shahenpc.common.exception.user.CaptchaExpireException;
import com.shahenpc.common.exception.user.UserPasswordNotMatchException;
import com.shahenpc.common.utils.*;
import com.shahenpc.common.utils.ip.IpUtils;
import com.shahenpc.common.utils.tencent.TencentLoginBean;
import com.shahenpc.common.utils.tencent.WxMaConfiguration;
import com.shahenpc.common.utils.tencent.WxMaProperties;
import com.shahenpc.framework.manager.AsyncManager;
import com.shahenpc.framework.manager.factory.AsyncFactory;
import com.shahenpc.system.domain.dto.XcxLoginDto;
import com.shahenpc.system.service.ISysConfigService;
import com.shahenpc.system.service.ISysUserService;
import me.chanjar.weixin.common.error.WxErrorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * 登录校验方法
 * 
 * @author ruoyi
 */
@Component
public class SysLoginService
{
    @Autowired
    private TokenService tokenService;

    @Resource
    private AuthenticationManager authenticationManager;

    @Autowired
    private RedisCache redisCache;
    
    @Autowired
    private ISysUserService userService;

    @Autowired
    private ISysConfigService configService;

    /**
     * 登录验证
     * 
     * @param username 用户名
     * @param password 密码
     * @param code 验证码
     * @param uuid 唯一标识
     * @return 结果
     */
    public String login(String username, String password, String code, String uuid)
    {
        boolean captchaOnOff = configService.selectCaptchaOnOff();
        // 验证码开关
        if (captchaOnOff)
        {
            validateCaptcha(username, code, uuid);
        }
        // 用户验证
        Authentication authentication = null;
        try
        {
            // 该方法会去调用UserDetailsServiceImpl.loadUserByUsername
            authentication = authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(username, password));
        }
        catch (Exception e)
        {
            if (e instanceof BadCredentialsException)
            {
                AsyncManager.me().execute(AsyncFactory.recordLogininfor(username, Constants.LOGIN_FAIL, MessageUtils.message("user.password.not.match")));
                throw new UserPasswordNotMatchException();
            }
            else
            {
                AsyncManager.me().execute(AsyncFactory.recordLogininfor(username, Constants.LOGIN_FAIL, e.getMessage()));
                throw new ServiceException(e.getMessage());
            }
        }
        AsyncManager.me().execute(AsyncFactory.recordLogininfor(username, Constants.LOGIN_SUCCESS, MessageUtils.message("user.login.success")));
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        recordLoginInfo(loginUser.getUserId());
        // 生成token
        return tokenService.createToken(loginUser);
    }
    /**
     * 登录验证
     *
     * @param username 用户名
     * @param password 密码
     * @param uuid 唯一标识
     * @return 结果
     */
    public String appLogin(String username, String password, String uuid)
    {
        //boolean captchaOnOff = configService.selectCaptchaOnOff();
        // 验证码开关
//        if (captchaOnOff)
//        {
            //appValidateCaptcha(username, uuid);
//        }
        // 用户验证
        Authentication authentication = null;
        try
        {
            // 该方法会去调用UserDetailsServiceImpl.loadUserByUsername
            authentication = authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(username, password));
        }
        catch (Exception e)
        {
            if (e instanceof BadCredentialsException)
            {
                AsyncManager.me().execute(AsyncFactory.recordLogininfor(username, Constants.LOGIN_FAIL, MessageUtils.message("user.password.not.match")));
                throw new UserPasswordNotMatchException();
            }
            else
            {
                AsyncManager.me().execute(AsyncFactory.recordLogininfor(username, Constants.LOGIN_FAIL, e.getMessage()));
                throw new ServiceException(e.getMessage());
            }
        }
        AsyncManager.me().execute(AsyncFactory.recordLogininfor(username, Constants.LOGIN_SUCCESS, MessageUtils.message("user.login.success")));
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        recordLoginInfo(loginUser.getUserId());
        // 生成token
        return tokenService.createToken(loginUser);
    }
    /**
     * 校验验证码
     *
     * @param username 用户名
     * @param uuid 唯一标识
     * @return 结果
     */
    public void appValidateCaptcha(String username,String uuid)
    {
        String verifyKey = CacheConstants.CAPTCHA_CODE_KEY + StringUtils.nvl(uuid, "");
        String captcha = redisCache.getCacheObject(verifyKey);
        redisCache.deleteObject(verifyKey);
        if (captcha == null)
        {
            AsyncManager.me().execute(AsyncFactory.recordLogininfor(username, Constants.LOGIN_FAIL, MessageUtils.message("user.jcaptcha.expire")));
            throw new CaptchaExpireException();
        }
    }
    /**
     * 校验验证码
     * 
     * @param username 用户名
     * @param code 验证码
     * @param uuid 唯一标识
     * @return 结果
     */
    public void validateCaptcha(String username, String code, String uuid)
    {
        String verifyKey = CacheConstants.CAPTCHA_CODE_KEY + StringUtils.nvl(uuid, "");
        String captcha = redisCache.getCacheObject(verifyKey);
        redisCache.deleteObject(verifyKey);
        if (captcha == null)
        {
            AsyncManager.me().execute(AsyncFactory.recordLogininfor(username, Constants.LOGIN_FAIL, MessageUtils.message("user.jcaptcha.expire")));
            throw new CaptchaExpireException();
        }
        if (!code.equalsIgnoreCase(captcha))
        {
            AsyncManager.me().execute(AsyncFactory.recordLogininfor(username, Constants.LOGIN_FAIL, MessageUtils.message("user.jcaptcha.error")));
            throw new CaptchaException();
        }
    }

    /**
     * 记录登录信息
     *
     * @param userId 用户ID
     */
    public void recordLoginInfo(Long userId)
    {
        SysUser sysUser = new SysUser();
        sysUser.setUserId(userId);
        sysUser.setLoginIp(IpUtils.getIpAddr(ServletUtils.getRequest()));
        sysUser.setLoginDate(DateUtils.getNowDate());
        userService.updateUserProfile(sysUser);
    }
    @Autowired
    private WxMaProperties wxMaProperties;
    @Autowired
    private ISysConfigService sysConfigService;
    @Transactional
    public AjaxResult xcxLogin(XcxLoginDto requestParam){
//        if (StringUtils.isBlank(requestParam.getCode())) {
//            return AjaxResult.error("code不能为空");
//        }
//        String appid = wxMaProperties.getConfigs().get(0).getAppid();
//        final WxMaService wxService = WxMaConfiguration.getMaService(appid);
//        try {
//            // code换取session
//            WxMaJscode2SessionResult session = wxService.getUserService().getSessionInfo(requestParam.getCode());
//            //log.info("code换取session：{}", session);
//            // 用户信息校验
//            if (!wxService.getUserService().checkUserInfo(session.getSessionKey(), requestParam.getRawData(), requestParam.getSignature())) {
//                return AjaxResult.error("用户信息校验失败");
//            }
//            // 解密用户信息
//            WxMaUserInfo userInfo = wxService.getUserService().getUserInfo(session.getSessionKey(), requestParam.getEncryptedData(), requestParam.getIv());
//            //log.info("解密用户信息：{}", userInfo);
//            // 获取用户绑定手机号信息
//            WxMaPhoneNumberInfo phoneNoInfo = wxService.getUserService().getPhoneNoInfo(session.getSessionKey(), requestParam.getEncryptedData(), requestParam.getIv());
//            //log.info("获取用户绑定手机号信息：{}", phoneNoInfo);
//
//            // =============================== 处理业务
//            // 根据openId查询是否存在这个用户
//            SysUser user1 = new SysUser();
//            user1.setOpenId(session.getOpenid());
//            user1.setPhonenumber(phoneNoInfo.getPhoneNumber());
//            List<SysUser> list = userService.selectUserList(user1);
//            AjaxResult ajax = AjaxResult.success();
//            if (CollectionUtils.isEmpty(list)) {
//                // 添加新用户
//                String defaultPassword = sysConfigService.selectConfigByKey("sys.user.initPassword");
//                SysUser user = new SysUser();
//
//                        .setNickName(u).setOpenId(session.getOpenid())
//                        .setNickName(userInfo.getNickName()).setDeptId(0L).setPassword(defaultPassword).setPhonenumber(phoneNoInfo.getPhoneNumber()).setAvatar(userInfo.getAvatarUrl());
//                //handleUseSex(userInfo, user);
//                if (UserConstants.NOT_UNIQUE.equals(userService.checkUserNameUnique(user.getUserName()))) {
//                    return AjaxResult.error("手机号已被注册");
//                } else if (Validator.isNotEmpty(user.getPhonenumber()) && UserConstants.NOT_UNIQUE.equals(userService.checkPhoneUnique(user))) {
//                    return AjaxResult.error("手机号已被使用");
//                }
//                user.setCreateBy(SecurityUtils.getUsername());
//                user.setPassword(SecurityUtils.encryptPassword(user.getPassword()));
//                // 默认给角色用户
//                user.setRoleIds(new Long[]{1L});
//                userService.insertUser(user);
//                String token = loginService.login(user.getUserName(), defaultPassword);
//                ajax.put(Constants.TOKEN, token);
//                return ajax;
//            } else if (list.size() == 1) {
//                // 更新用户信息
//                SysUser sysUser = list.get(0);
//                sysUser.setNickName(userInfo.getNickName());
//                sysUser.setAvatar(userInfo.getAvatarUrl());
//                //handleUseSex(userInfo, sysUser);
//                sysUser.setOpenId(session.getOpenid());
//                userService.updateById(sysUser);
//                SysUser user = userService.selectUserByUserName(sysUser.getUserName());
//                LoginUser loginUser = new LoginUser(user, permissionService.getMenuPermission(user));
//                String token = tokenService.createToken(loginUser);
//                ajax.put(Constants.TOKEN, token);
//                return ajax;
//            } else {
//                return AjaxResult.error("用户信息异常，存在多个openId或电话号码");
//            }
//        } catch (WxErrorException e) {
//            //log.error(e.toString());
//            return AjaxResult.error(e.getError().getErrorMsg());
//        }
        return null;
    }
}
