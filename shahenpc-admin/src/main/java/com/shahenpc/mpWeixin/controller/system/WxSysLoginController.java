package com.shahenpc.mpWeixin.controller.system;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.shahenpc.common.constant.Constants;
import com.shahenpc.common.core.domain.AjaxResult;
import com.shahenpc.common.core.domain.entity.SysUser;
import com.shahenpc.common.core.domain.model.LoginBody;
import com.shahenpc.common.core.domain.model.LoginUser;
import com.shahenpc.common.core.redis.RedisCache;
import com.shahenpc.common.utils.*;
import com.shahenpc.common.utils.http.HttpUtils;
import com.shahenpc.common.utils.ip.IpUtils;
import com.shahenpc.common.utils.sign.Base64;
import com.shahenpc.common.utils.sign.Md5Utils;
import com.shahenpc.framework.manager.AsyncManager;
import com.shahenpc.framework.manager.factory.AsyncFactory;
import com.shahenpc.framework.web.service.SysLoginService;
import com.shahenpc.framework.web.service.TokenService;
import com.shahenpc.system.domain.BackVo.LawInfo;
import com.shahenpc.system.domain.dto.XcxLoginDto;
import com.shahenpc.system.domain.wxsmallprogram.dto.SmProCodeDto;
import com.shahenpc.system.domain.wxsmallprogram.dto.SmProLinkDto;
import com.shahenpc.system.domain.wxsmallprogram.dto.WxAuthDto;
import com.shahenpc.system.domain.wxsmallprogram.dto.WxMassesDto;
import com.shahenpc.system.domain.wxsmallprogram.vo.WxAccessTokenVo;
import com.shahenpc.system.domain.wxsmallprogram.vo.WxAuthVo;
import com.shahenpc.system.domain.wxsmallprogram.vo.WxPhoneVo;
import com.shahenpc.system.service.ISysUserService;
import com.sun.org.apache.xerces.internal.parsers.DTDParser;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import liquibase.pro.packaged.T;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.flowable.idm.engine.impl.persistence.entity.UserEntity;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.util.FastByteArrayOutputStream;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.sql.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/wx/user")
@Api(tags = "小程序基础接口")
public class WxSysLoginController {
    @Autowired
    private ISysUserService userService;

    @Autowired
    private SysLoginService loginService;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private RedisCache redisCache;

    /**
     * 小程序登录
     */
    @RequestMapping("xcxLogin")
    public AjaxResult xcxLogin(@RequestBody XcxLoginDto requestParam) {
        AjaxResult ajax = AjaxResult.success();
        return AjaxResult.success(loginService.xcxLogin(requestParam));
    }

    //region // 微信小程序绑定登录

    /**
     * 微信小程序登录
     *
     * @param loginBody 登录信息
     * @return
     */
    @ApiOperation("微信小程序绑定登录")
    @PostMapping("/wxlogin")
    public AjaxResult wxLogin(@RequestBody LoginBody loginBody) {
        AjaxResult ajax = AjaxResult.success();
        SysUser userEntity = userService.selectUserByUserPhone(loginBody.getUsername(), "1");
        if (userEntity == null) {
            return AjaxResult.isEmpty("无此用户信息");
        }
        if (userEntity != null && StringUtils.isEmpty(userEntity.getOpenId())) {
            String wxOpenId = getWxOpenId(loginBody.getCode());
            userEntity.setOpenId(wxOpenId);
            loginBody.setPassword(userEntity.getPassword());
            userService.updateUser(userEntity);
        }
        LoginUser loginUser = (LoginUser) userDetailsService.loadUserByUsername(userEntity.getUserName());

        // 记录登录信息
        AsyncManager.me().execute(AsyncFactory.recordLogininfor(userEntity.getUserName(), Constants.LOGIN_SUCCESS,
                MessageUtils.message("user.login.success")));
        recordLoginInfo(loginUser.getUserId());
        String token = tokenService.createToken(loginUser);
        ajax.put(Constants.TOKEN, token);
        ajax.put("userInfo", userEntity);
        return ajax;
    }
    //endregion

    //region // 获取微信手机号

    /**
     * 获取微信手机号
     *
     * @param dto
     * @return
     */
    @ApiOperation("获取微信手机号")
    @PostMapping("/getwxphone")
    public AjaxResult getWxPhone(@RequestBody WxAuthDto dto) throws IOException {
        AjaxResult ajax = AjaxResult.success();
        String accessToken = getWxAccessToken();
        Map<String, Object> map = new HashMap<>(1);
        map.put("code", dto.getJs_code());
        String res = HttpUtils.SendPost("https://api.weixin.qq.com/wxa/business/getuserphonenumber" +
                "?access_token=" + accessToken, map);
        WxPhoneVo wxPhoneVo = JSON.parseObject(JSON.parse(res).toString(), WxPhoneVo.class);
        ajax.put("data", wxPhoneVo.getPhone_info().getPurePhoneNumber());
        return ajax;
    }
    //endregion

    //region // 群众注册登录微信小程序

    /**
     * 群众注册登录微信小程序
     *
     * @param dto
     * @return
     */
    @ApiOperation("群众注册登录微信小程序")
    @PostMapping("/massesreg")
    public AjaxResult massesRegister(@RequestBody WxMassesDto dto) {
        AjaxResult ajax = AjaxResult.success();

        //判断是否已经存在该手机用户
        SysUser exitUser = userService.selectUserByUserPhone(dto.getPhoneNumber(), "3");
        SysUser userEntity = new SysUser();
        String defaultPwd = "defaultpwd";
        // 不存在则将客户进新新增注册
        if (exitUser == null) {
            userEntity.setPhonenumber(dto.getPhoneNumber());
            userEntity.setPassword(SecurityUtils.encryptPassword(defaultPwd));
            userEntity.setIdentity("3");
            userEntity.setNickName(dto.getNickName());
            userEntity.setAvatar(dto.getAvatarUrl());
            // 微信openId
            userEntity.setOpenId(getWxOpenId(dto.getCode()));
            userEntity.setStatus("0");
            userEntity.setSex(dto.getGender() + "");
            userEntity.setUserName(dto.getPhoneNumber());
            userEntity.setDelFlag("0");
            userService.insertUser(userEntity);
            ajax.put("user", userEntity);
        } else {
            ajax.put("user", exitUser);
        }

        LoginUser loginUser = (LoginUser) userDetailsService.loadUserByUsername(dto.getPhoneNumber());
        // 记录登录信息
        AsyncManager.me().execute(AsyncFactory.recordLogininfor(dto.getPhoneNumber(), Constants.LOGIN_SUCCESS,
                MessageUtils.message("user.login.success")));
        recordLoginInfo(loginUser.getUserId());
        String token = tokenService.createToken(loginUser);
        ajax.put(Constants.TOKEN, token);
        return ajax;
    }
    //endregion

    //region  // 获取投票小程序码==> 待测试
    // todo-ht 获取投票小程序码==>发布后方可进行测试

    /**
     * 获取投票小程序码
     *
     * @param dto
     * @return
     * @throws IOException
     */
    @ApiOperation("获取投票小程序码")
    @PostMapping("/getvotecode")
    public AjaxResult getSmProCode(@RequestBody SmProCodeDto dto) throws IOException {
        AjaxResult ajax = AjaxResult.success();
        dto.setAccess_token(getWxAccessToken());
        dto.setAuto_color(Boolean.FALSE);
        Map<String, Object> map = new HashMap<>();
        map.put("scene", dto.getScene());
        map.put("page", dto.getPage());
        map.put("env_version", dto.getEnv_version());
        byte[] res = HttpUtils.SendPosts("https://api.weixin.qq.com/wxa/getwxacodeunlimit?access_token=" + dto.getAccess_token(), map);
        //byte[] result = res.getBytes();
//        result = res.toBy
        //二进制  转  base64
        return AjaxResult.success(Base64.encode(res));
    }

    //endregion

    //region // 获取投票小程序链接==> 待测试
    // todo-ht  获取投票小程序链接==>发布后方可进行测试

    /**
     * 获取投票小程序链接
     *
     * @param dto
     * @return
     * @throws IOException
     */
    @ApiOperation("获取投票小程序链接")
    @PostMapping("/getvotelink")
    public String getSmProLink(@RequestBody SmProLinkDto dto) throws IOException {
        dto.setAccess_token(getWxAccessToken());
        dto.setExpire_type(0);
        Map<String, Object> map = new HashMap<>();
        map.put("path", dto.getPath());
        map.put("query", dto.getQuery());
        map.put("env_version", dto.getEnv_version());
        map.put("expire_type", 0);
        String res = HttpUtils.SendPost("https://api.weixin.qq.com/wxa/generate_urllink?access_token=" + dto.getAccess_token(), map);
        return res;
    }
    //endregion

    //region // Tools

    //region 获取微信OpenId

    /**
     * 获取微信OpenId
     *
     * @return 微信OpenId字符串
     */
    public String getWxOpenId(String code) {
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
    //endregion

    //region // 获取微信AccessToken getWxAccessToken()

    /**
     * 获取微信AccessToken
     *
     * @return
     */
    public String getWxAccessToken() {

        WxAuthDto dto = new WxAuthDto();
        dto.setGrant_type("client_credential");
        String param = getParamStr(dto);
        WxAccessTokenVo redisToken = redisCache.getCacheObject("redisWxAccessToken2");
        if (redisToken == null) {
            String res = HttpUtils.sendGet("https://api.weixin.qq.com/cgi-bin/token", param);
            redisToken = JSON.parseObject(JSON.parse(res).toString(), WxAccessTokenVo.class);
            accessTokenSaveRids(redisToken);
        }
        return redisToken.getAccess_token();
    }
    //endregion

    /**
     * 微信accessToken存入Redis
     *
     * @param accessTokenVo
     */
    public void accessTokenSaveRids(WxAccessTokenVo accessTokenVo) {
        // 微信WxAccessTokenVo存入Redis
        redisCache.setCacheObject("redisWxAccessToken2", accessTokenVo,
                accessTokenVo.getExpires_in(), TimeUnit.SECONDS);
    }

    /**
     * 微信OpenId 参数组成
     *
     * @param dto
     * @return
     */
    public String getParamStr(WxAuthDto dto) {
        String resParam = "appid=" + dto.getAppid() + "&secret=" + dto.getSecret()
                + "&grant_type=" + dto.getGrant_type();
        if (!StringUtils.isEmpty(dto.getJs_code())) {
            resParam += "&js_code=" + dto.getJs_code();
        }
        return resParam;
    }

    /**
     * 记录登录信息
     *
     * @param userId 用户ID
     */
    public void recordLoginInfo(Long userId) {
        SysUser sysUser = new SysUser();
        sysUser.setUserId(userId);
        sysUser.setLoginIp(IpUtils.getIpAddr(ServletUtils.getRequest()));
        sysUser.setLoginDate(DateUtils.getNowDate());
        userService.updateUserProfile(sysUser);
    }

    //endregion

}
