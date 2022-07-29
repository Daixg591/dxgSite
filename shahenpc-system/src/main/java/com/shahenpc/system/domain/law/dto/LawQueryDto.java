package com.shahenpc.system.domain.law.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author hardy
 * 法律助手查询参数实体类
 *
 */
@Data
public class LawQueryDto implements Serializable
{
    /**
     * 页码
     */
    private String page;

    /**
     * 每页显示数据条数
     */
    private String size;

    /**
     * 关键词
     */
    private String fgbt;

    /**
     * 法律类型  法律:flfg; 行政法规:xzfg; 监察法规:jcfg; 司法解释:sfjs; 地方性法规:dfxfg
     */
    private String type;

    /**
     * 搜索类型 标题：title; 正文:content
     */
    private String searchType;

    /**
     * 公布日期开始时间
     */
    private String gbrqStart;

    /**
     * 公布日期结束时间
     */
    private String gbrqEnd;

    /**
     * 施行日期开始时间
     */
    private String sxrqStart;

    /**
     * 施行日期结束时间
     */
    private String sxrqEnd;


}
