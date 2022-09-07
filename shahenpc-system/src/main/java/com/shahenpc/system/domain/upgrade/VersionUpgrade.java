package com.shahenpc.system.domain.upgrade;

import com.shahenpc.common.annotation.Excel;
import com.shahenpc.common.core.domain.BaseEntity;
import lombok.Data;

/**
 * 【请填写功能名称】对象 version_upgrade
 *
 * @author ruoyi
 * @date 2022-06-22
 */
@Data
public class VersionUpgrade extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**  */
    private Long id;

    /** 客户端设备id 1安卓pad */
    @Excel(name = "客户端设备id 1安卓pad")
    private Integer appId;

    /** 大版本号id */
    @Excel(name = "大版本号id")
    private Integer versionId;

    /** 小版本号 */
    @Excel(name = "小版本号")
    private String versionMini;

    /** 版本标识 1.2 */
    @Excel(name = "版本标识 1.2")
    private String versionCode;

    /** 是否升级 1升级，0不升级，2强制升级 */
    @Excel(name = "是否升级 1升级，0不升级，2强制升级")
    private Integer type;

    /**  */
    @Excel(name = "")
    private String apkUrl;

    /** 升级提示 */
    @Excel(name = "升级提示")
    private String upgradePoint;

    /**  */
    @Excel(name = "")
    private Integer status;

    /** 1 安卓  2.大屏 */
    @Excel(name = "1 安卓  2.大屏")
    private Integer appType;
}
