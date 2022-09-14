package com.shahenpc.common.constant;

import io.jsonwebtoken.Claims;

/**
 * 通用常量信息
 * 
 * @author ruoyi
 */
public class Constants
{
    public static final Integer DISCOVER_PROCESS_TYPE_3=3;
    /**
     * 代表发现类型
     */
    public static final Integer DISCOVER_PROCESS_TYPE_2=2;
    /**
     * 代表发现类型
     */
    public static final Integer DISCOVER_PROCESS_TYPE_1=1;
    /**
     * 代表发现类型
     */
    public static final Integer DISCOVER_PROCESS_TYPE_0=0;
    /**
     * 代表发现状态 处理中
     */
    public static final Integer DISCOVER_STATUS_0=0;
    /**
     * 代表发现状态
     */
    public static final Integer DISCOVER_STATUS_1=1;
    /**
     * 代表发现状态
     */
    public static final Integer DISCOVER_STATUS_2=2;
    /**
     *
     */
    public static final Integer DISCOVER_STATUS_3=3;
    /**
     * 已退回
     */
    public static final Integer DISCOVER_STATUS_4=4;

    public static final Integer DOUBLE_PROCESS_TYPE_0=0;
    /**
     * 群众发送 到  人大代表 代表1
     */
    public static final Integer DOUBLE_PROCESS_TYPE_1=1;
    /**
     * 代表发送到 联络站 代表2
     */
    public static final Integer DOUBLE_PROCESS_TYPE_2=2;
    /**
     * 联络站 发送 到 总联络站 负责人 3
     */
    public static final Integer DOUBLE_PROCESS_TYPE_3=3;
    public static final Integer DOUBLE_PROCESS_TYPE_4 = 4;
    /**
     * 双联工作 类型 民生类
     */
    public static final Integer DOUBLE_TYPE_0 = 0;
    /**
     * 双联工作 类型 环保类
     */
    public static final Integer DOUBLE_TYPE_1 = 1;
    /**
     * 双联工作 类型  投诉举报类
     */
    public static final Integer DOUBLE_TYPE_2 = 2;
    /**
     * 双联工作 类型 咨询调解类
     */
    public static final Integer DOUBLE_TYPE_3 = 3;
    /**
     * 双联工作 类型 举报揭发类
     */
    public static final Integer DOUBLE_TYPE_4 = 4;

    /**
     * 双联工作 类型 举报 状态 待收集
     */
    public static final Integer DOUBLE_STATUS_0 = 0;

    /**
     * 双联工作 类型 举报 状态 已收集
     */
    public static final Integer DOUBLE_STATUS_1 = 1;
    /**
     * 双联工作 类型 举报 状态 已回复
     */
    public static final Integer DOUBLE_STATUS_2 = 2;
    /**
     * 双联工作 类型 举报 状态 群众已评价
     */
    public static final Integer DOUBLE_STATUS_3 = 3;
    /**
     * 双联工作 类型 举报 状态 忽略
     */
    public static final Integer DOUBLE_STATUS_4 = 4;

    /**
     * 申请人
     */
    public static final Integer CENSOR_TYPE_0 = 0;
    /**
     *接收
     */
    public static final Integer CENSOR_TYPE_1 = 1;
    /**
     * 受理
     */
    public static final Integer CENSOR_TYPE_2 = 2;
    /**
     * 分发
     */
    public static final Integer CENSOR_TYPE_3 = 3;
    /**
     * 审查
     */
    public static final Integer CENSOR_TYPE_4 = 4;
    /**
     * 反馈
     */
    public static final Integer CENSOR_TYPE_5 = 5;
    /**
     * 待处理
     */
    public static final Integer CENSOR_TYPE_STATUS_0=0;
    /**
     * 已通过
     */
    public static final Integer CENSOR_TYPE_STATUS_1=1;
    /**
     * 未通过
     */
    public static final Integer CENSOR_TYPE_STATUS_2=2;
    /**
     * 已退回
     */
    public static final Integer CENSOR_TYPE_STATUS_3=3;
    /**
     * UTF-8 字符集
     */
    public static final String UTF8 = "UTF-8";

    /**
     * GBK 字符集
     */
    public static final String GBK = "GBK";

    /**
     * http请求
     */
    public static final String HTTP = "http://";

    /**
     * https请求
     */
    public static final String HTTPS = "https://";

    /**
     * 通用成功标识
     */
    public static final String SUCCESS = "0";

    /**
     * 通用失败标识
     */
    public static final String FAIL = "1";

    /**
     * 登录成功
     */
    public static final String LOGIN_SUCCESS = "Success";

    /**
     * 注销
     */
    public static final String LOGOUT = "Logout";

    /**
     * 注册
     */
    public static final String REGISTER = "Register";

    /**
     * 登录失败
     */
    public static final String LOGIN_FAIL = "Error";
 
    /**
     * 验证码有效期（分钟）
     */
    public static final Integer CAPTCHA_EXPIRATION = 2;

    /**
     * 令牌
     */
    public static final String TOKEN = "token";

    /**
     * 令牌前缀
     */
    public static final String TOKEN_PREFIX = "Bearer ";

    /**
     * 令牌前缀
     */
    public static final String LOGIN_USER_KEY = "login_user_key";

    /**
     * 用户ID
     */
    public static final String JWT_USERID = "userid";

    /**
     * 用户名称
     */
    public static final String JWT_USERNAME = Claims.SUBJECT;

    /**
     * 用户头像
     */
    public static final String JWT_AVATAR = "avatar";

    /**
     * 创建时间
     */
    public static final String JWT_CREATED = "created";

    /**
     * 用户权限
     */
    public static final String JWT_AUTHORITIES = "authorities";

    /**
     * 资源映射路径 前缀
     */
    public static final String RESOURCE_PREFIX = "/profile";

    /**
     * RMI 远程方法调用
     */
    public static final String LOOKUP_RMI = "rmi:";

    /**
     * LDAP 远程方法调用
     */
    public static final String LOOKUP_LDAP = "ldap:";

    /**
     * LDAPS 远程方法调用
     */
    public static final String LOOKUP_LDAPS = "ldaps:";

    /**
     * 定时任务白名单配置（仅允许访问的包名，如其他需要可以自行添加）
     */
    public static final String[] JOB_WHITELIST_STR = { "com.shahenpc" };

    /**
     * 定时任务违规的字符
     */
    public static final String[] JOB_ERROR_STR = { "java.net.URL", "javax.naming.InitialContext", "org.yaml.snakeyaml",
            "org.springframework", "org.apache", "com.shahenpc.common.utils.file" };
}
