package com.shahenpc.system.domain.law.vo;

import lombok.Data;

import java.util.List;

/**
 * 热点资讯 Vo数据集
 *
 * @author Hardy
 * <p>
 * 2022-07-29
 */

@Data
public class HotNewsVo {

    /**
     * 新闻集合
     */
    private List<NewsItem> list;

    /**
     * 资讯数量
     */
    private Integer total;
}


@Data
class NewsItem {
    /**
     * 文章Id
     */
    private String id;

    /**
     * 标题
     */
    private String title;

    /**
     * 时间
     */
    private String focus_date;

    /**
     * 时间
     */
    private String url;

    /**
     * 封面图片
     */
    private String image;
    private String image2;
    private String image3;

    /**
     * 描述
     */
    private String brief;

    private String ext_field;

    /**
     * 关键词
     */
    private String keywords;
    private String count;

}