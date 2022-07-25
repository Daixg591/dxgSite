//package com.shahenpc.common.utils.tencent;
//
//import com.shahenpc.common.core.redis.RedisCache;
//import com.shahenpc.common.utils.json.JSONTools;
//import org.apache.commons.lang3.StringUtils;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.scheduling.annotation.Async;
//import org.springframework.scheduling.annotation.AsyncResult;
//import org.springframework.scheduling.annotation.EnableAsync;
//import org.springframework.stereotype.Component;
//
//import java.util.HashMap;
//import java.util.Map;
//import java.util.concurrent.Future;
//
//@Component
//@EnableAsync
//public class TencentUtils {
//    private static Logger LOG = LoggerFactory.getLogger(TencentUtils.class);
//
//    @Autowired
//    private RedisCache redisService;
//
//    public static final int ACCESS_TOKEN_REDIS_DB = 2;
//
//    @Autowired
//    private SysResourceAccontMapper resourceAccontMapper;
//
//    /**
//     * @作者：陳曉鬆 @时间：2020年6月29日 上午11:34:04 @版本：V1.0 @description：-> 获取资源信息失败
//     */
//    public TenConfigBean getConfig(String appId) {
//        String configKey = "CONFIG_" + appId.toUpperCase();
//        String config = (String) redisService.get(ACCESS_TOKEN_REDIS_DB, configKey);
//        TenConfigBean configBean = null;
//        if (!StringUtils.isEmpty(config)) {
//            configBean = JSONTools.jsonStr2obj(config, TenConfigBean.class);
//        } else {
//            configBean = resourceAccontMapper.selectByAppId(appId);
//            if (configBean != null) {
//                redisService.set(ACCESS_TOKEN_REDIS_DB, configKey, JSONTools.obj2json(configBean), 30 * 60);
//            }
//        }
//        if (configBean == null) {
//            //throw new ProRunTimeException(ErrCode.FAIL.getReturnCode(), "获取资源信息失败");
//        }
//        return configBean;
//    }
//
//    /**
//     * 获取token
//     *
//     * @param appId
//     *            小程序appId
//     * @return 返回为null网络异常
//     */
//    public String getToken(String appId) throws ProAffairException {
//        String tokenKey = appId + "_access_token";
//        String token = (String) redisService.get(ACCESS_TOKEN_REDIS_DB, tokenKey);
//        if (!StringUtils.isEmpty(token)) {
//            return token;
//        }
//        TenConfigBean mTenConfigBean = getConfig(appId);
//
//        String url;
//        if (mTenConfigBean.type == 1 || mTenConfigBean.type == 2) {
//            url = "https://api.weixin.qq.com/cgi-bin/token";
//        } else {
//            url = "https://api.q.qq.com/api/getToken";
//        }
//        Map<String, Object> map = new HashMap<>();
//        map.put("appid", appId);
//        map.put("secret", mTenConfigBean.secret);
//        map.put("grant_type", "client_credential");
//        String mValue = HttpClientTools.get(url + "?", null, map);
//        TencentTokenBean mTencentTokenBean = JSONTools.jsonStr2obj(mValue, TencentTokenBean.class);
//        if (mTencentTokenBean == null || mTencentTokenBean.getErrcode() != 0) {
//            throw new ProRunTimeException("获取token失败：" + mValue);
//        }
//        // 少存10分钟
//        redisService.set(ACCESS_TOKEN_REDIS_DB, tokenKey, mTencentTokenBean.getAccess_token(), mTencentTokenBean.getExpires_in() - 1000);
//        return mTencentTokenBean.getAccess_token();
//    }
//
//    /**
//     * 获取用户openId
//     *
//     * @param appId
//     *            小程序appId
//     * @param code
//     *            登录凭证code 前端登录获取
//     * @return 返回为null网络异常
//     */
//    public TencentLoginBean getOpenId(String appId, String code){
//        String url;
//        TenConfigBean mTenConfigBean = getConfig(appId);
//        if (mTenConfigBean.type == 1) {
//            url = "https://api.weixin.qq.com/sns/jscode2session";
//        } else {
//            url = "https://api.q.qq.com/sns/jscode2session";
//        }
//        Map<String, Object> map = new HashMap<>();
//        map.put("appid", appId);
//        map.put("secret", mTenConfigBean.secret);
//        map.put("js_code", code);
//        map.put("grant_type", "authorization_code");
//        String responseBody = HttpClientTools.get(url + "?", null, map);
//        return JSONTools.jsonStr2obj(responseBody, TencentLoginBean.class);
//    }
//
//    /**
//     * 获取用户openId
//     *
//     * @param appId
//     *            小程序appId
//     * @param code
//     *            登录凭证code 前端登录获取
//     * @return 返回为null网络异常
//     */
//    public WechatAccessToken getH5OpenId(String appId, String code) throws ProAffairException {
//        String url = "https://api.weixin.qq.com/sns/oauth2/access_token";
//        TenConfigBean mTenConfigBean = getConfig(appId);
//        Map<String, Object> map = new HashMap<>();
//        map.put("appid", appId);
//        map.put("secret", mTenConfigBean.secret);
//        map.put("code", code);
//        map.put("grant_type", "authorization_code");
//        String responseBody = HttpClientTools.get(url + "?", null, map);
//        LOG.info("-腾讯-getH5OpenId->{}", responseBody);
//        return JSONTools.jsonStr2obj(responseBody, WechatAccessToken.class);
//    }
//
//    /**
//     * @作者：陳曉鬆 @时间：2020年9月10日 上午9:15:25 @版本：V1.0 @description：-> 查询是否关注公众号
//     */
//    public Boolean isSubscribePublicNumber(String appId, String openId) throws ProAffairException {
//        String url = "https://api.weixin.qq.com/cgi-bin/user/info?access_token=" + getToken(appId) + "&openid=" + openId + "&lang=zh_CN";
//        String response = HttpClientTools.get(url, null, null);
//        if (org.springframework.util.StringUtils.isEmpty(response)) {
//            return false;
//        }
//        Map<String, Object> map = JSONTools.convertJsonStrToMap(response);
//        if (map == null) {
//            LOG.error("-腾讯-判断是否关注公众号-解析返回值失败：{}", response);
//            return false;
//        }
//        Object subscribe = map.get("subscribe");
//        if (org.springframework.util.StringUtils.isEmpty(subscribe)) {
//            LOG.error("-腾讯-判断是否关注公众号-返回值没有判断是否关注的字段：{}", response);
//            return false;
//        }
//        if (0 == Integer.parseInt(subscribe.toString())) {
//            LOG.error("-腾讯-判断是否关注公众号-该用户未关注公众号：{}", response);
//            return false;
//        }
//        return true;
//    }
//
//    /**
//     * @作者：陳曉鬆 @时间：2020年5月15日 下午2:34:08 @版本：V1.0 @description：-> 公众号获取用户信息
//     */
//    public WechatUserInfo getWechatUserInfo(String accToken, String openId) throws ProAffairException {
//        try {
//            String url = "https://api.weixin.qq.com/sns/userinfo?access_token=" + accToken + "&openid=" + openId + "&lang=zh_CN";
//            String responseBody = HttpClientTools.get(url, null, null);
//            return JSONTools.jsonStr2obj(responseBody, WechatUserInfo.class);
//        } catch (Exception e) {
//            return null;
//        }
//    }
//
//    /**
//     * 异步发送订阅消息
//     **/
//    @Async
//    public Future<String> sendWinLuckMessage(String appId, String openId, Map<String, Object> param) throws ProException {
//        // 获取token
//        String accToken = getToken(appId);
//        if (StringUtils.isEmpty(accToken)) {
//            throw new ProValiDataException(ErrCode.FAIL.getReturnCode(), "获取TOKEN失败！");
//        }
//        // 发送订阅消息
//        param.put("access_token", accToken);
//        String sendUrl = null;
//        if (PublicMethod.isNumber(appId)) {// QQ
//            sendUrl = "https://api.q.qq.com/api/json/subscribe/SendSubscriptionMessage?access_token=" + accToken;
//        } else {
//            sendUrl = "https://api.weixin.qq.com/cgi-bin/message/subscribe/send?access_token=" + accToken;
//        }
//        String response = HttpClientTools.post(sendUrl, null, null, JSONTools.obj2json(param));
//        return new AsyncResult<String>(response);
//    }
//
//    /**
//     * @作者：陳曉鬆 @时间：2020年5月11日 上午10:16:13 @版本：V1.0 @description：-> 前端JsSdk签名
//     */
//    public String getJsSdkTicketToken(String appId) throws ProException {
//        String tokenKey = appId + "_ticket_token";
//        String token = (String) redisService.get(ACCESS_TOKEN_REDIS_DB, tokenKey);
//        if (!StringUtils.isEmpty(token)) {
//            return token;
//        }
//        String jsapiUrl = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=" + getToken(appId) + "&type=jsapi";
//        String jsapiResponse = HttpClientTools.get(jsapiUrl, null, null);
//        if (StringUtils.isEmpty(jsapiResponse)) {
//            throw new ProValiDataException(ErrCode.FAIL.getReturnCode(), "获取JSSDK的ticket签名失败");
//        }
//        Map<String, Object> map = JSONTools.convertJsonStrToMap(jsapiResponse);
//        if (map == null || !"ok".equals(map.get("errmsg"))) {
//            throw new ProValiDataException(ErrCode.FAIL.getReturnCode(), "获取JSSDK的ticket签名失败:" + jsapiResponse);
//        }
//        redisService.set(ACCESS_TOKEN_REDIS_DB, tokenKey, map.get("ticket").toString(), Integer.parseInt(map.get("expires_in").toString()) - 1000);
//        return map.get("ticket").toString();
//    }
//
//    /**
//     * 支付过后获取Unionid
//     **/
//    public String getUnionid(String appId, String openId, String transactionId) throws ProException {
//        String unionid = null;
//        // 获取token
//        String accToken = getToken(appId);
//        if (StringUtils.isEmpty(accToken)) {
//            return unionid;
//        }
//        String url = null;
//        TenConfigBean mTenConfigBean = getConfig(appId);
//        if (mTenConfigBean.type == 1) {
//            url = "https://api.weixin.qq.com/wxa/getpaidunionid?access_token=" + accToken + "&openid=" + openId + "&transaction_id=" + transactionId;
//        }
//        if (!StringUtils.isEmpty(url)) {
//            String response = HttpClientTools.get(url, null, null);
//            if (!StringUtils.isEmpty(response)) {
//                Map<String, Object> resp = JSONTools.convertJsonStrToMap(response);
//                if (resp != null && !org.springframework.util.StringUtils.isEmpty(resp.get("unionid"))) {
//                    return resp.get("unionid").toString();
//                }
//            }
//        }
//        return unionid;
//    }
//}
