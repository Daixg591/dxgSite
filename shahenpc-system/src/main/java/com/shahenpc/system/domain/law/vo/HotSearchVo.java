package com.shahenpc.system.domain.law.vo;

import lombok.Data;

/**
 * 热搜爬虫实体类
 *
 * @author Hardy
 * 2022-07-30
 */

@Data
public class HotSearchVo {
    /**
     * 图片
     */
    private String img;

    /**
     * 标题
     */
    private String title;

    /**
     * 内容
     */
    private String content;

    /**
     * 推荐图
     */
    private String url;

    /**
     * 热度指数
     */
    private String level;
}
