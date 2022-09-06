package com.shahenpc.system.domain.represent;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.shahenpc.common.annotation.Excel;
import com.shahenpc.common.core.domain.BaseEntity;

/**
 * 代之家访问对象 represent_home_access
 * 
 * @author ruoyi
 * @date 2022-07-21
 */
public class RepresentHomeAccess extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private Long accessId;

    /** 标题 */
    @Excel(name = "标题")
    private String title;

    /** 省 直辖市code */
    @Excel(name = "省 直辖市code")
    private String provinceCode;

    /** 省直辖昵称 */
    @Excel(name = "省直辖昵称")
    private String provinceName;

    /** 城市code */
    @Excel(name = "城市code")
    private String cityCode;

    /** 城市名称 */
    @Excel(name = "城市名称")
    private String cityName;

    /** 县、区 code代码 */
    @Excel(name = "县、区 code代码")
    private String areaCode;

    /** 县 区 昵称 */
    @Excel(name = "县 区 昵称")
    private String areaName;

    /**  */
    @Excel(name = "")
    private String latitude;

    /**  */
    @Excel(name = "")
    private String longitude;

    /** 详情地址 */
    @Excel(name = "详情地址")
    private String address;

    /** 简历 */
    @Excel(name = "简历")
    private String content;

    /**  */
    @Excel(name = "")
    private String picUrl;

    /** 浏览数 */
    @Excel(name = "浏览数")
    private Long browseNumber;

    /**
     * 简称
     */
    private String shortName;

    /**
     * 云视讯账号
     */
    private String ysxMobile;

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getYsxMobile() {
        return ysxMobile;
    }

    public void setYsxMobile(String ysxMobile) {
        this.ysxMobile = ysxMobile;
    }

    public String getYsxPwd() {
        return ysxPwd;
    }

    public void setYsxPwd(String ysxPwd) {
        this.ysxPwd = ysxPwd;
    }

    /**
     * 云视讯密码
     */
    private String ysxPwd;

    public void setAccessId(Long accessId) 
    {
        this.accessId = accessId;
    }

    public Long getAccessId() 
    {
        return accessId;
    }
    public void setTitle(String title) 
    {
        this.title = title;
    }

    public String getTitle() 
    {
        return title;
    }
    public void setProvinceCode(String provinceCode) 
    {
        this.provinceCode = provinceCode;
    }

    public String getProvinceCode() 
    {
        return provinceCode;
    }
    public void setProvinceName(String provinceName) 
    {
        this.provinceName = provinceName;
    }

    public String getProvinceName() 
    {
        return provinceName;
    }
    public void setCityCode(String cityCode) 
    {
        this.cityCode = cityCode;
    }

    public String getCityCode() 
    {
        return cityCode;
    }
    public void setCityName(String cityName) 
    {
        this.cityName = cityName;
    }

    public String getCityName() 
    {
        return cityName;
    }
    public void setAreaCode(String areaCode) 
    {
        this.areaCode = areaCode;
    }

    public String getAreaCode() 
    {
        return areaCode;
    }
    public void setAreaName(String areaName) 
    {
        this.areaName = areaName;
    }

    public String getAreaName() 
    {
        return areaName;
    }
    public void setLatitude(String latitude) 
    {
        this.latitude = latitude;
    }

    public String getLatitude() 
    {
        return latitude;
    }
    public void setLongitude(String longitude) 
    {
        this.longitude = longitude;
    }

    public String getLongitude() 
    {
        return longitude;
    }
    public void setAddress(String address) 
    {
        this.address = address;
    }

    public String getAddress() 
    {
        return address;
    }
    public void setContent(String content) 
    {
        this.content = content;
    }

    public String getContent() 
    {
        return content;
    }
    public void setPicUrl(String picUrl) 
    {
        this.picUrl = picUrl;
    }

    public String getPicUrl() 
    {
        return picUrl;
    }
    public void setBrowseNumber(Long browseNumber) 
    {
        this.browseNumber = browseNumber;
    }

    public Long getBrowseNumber() 
    {
        return browseNumber;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("accessId", getAccessId())
            .append("title", getTitle())
            .append("provinceCode", getProvinceCode())
            .append("provinceName", getProvinceName())
            .append("cityCode", getCityCode())
            .append("cityName", getCityName())
            .append("areaCode", getAreaCode())
            .append("areaName", getAreaName())
            .append("latitude", getLatitude())
            .append("longitude", getLongitude())
            .append("address", getAddress())
            .append("content", getContent())
            .append("picUrl", getPicUrl())
            .append("browseNumber", getBrowseNumber())
            .append("remark", getRemark())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("createBy", getCreateBy())
            .toString();
    }
}
