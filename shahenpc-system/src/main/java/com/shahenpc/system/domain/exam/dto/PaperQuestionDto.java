package com.shahenpc.system.domain.exam.dto;

import lombok.Data;

import java.util.List;

/**
 * 添加试题参数类
 *
 * @author Hardy
 * 2022-08-01
 */

@Data
public class PaperQuestionDto {
    /**
     * 试卷Id
     */
    private Long paperID;

    /**
     * 试题集合
     */
    private List<QuItemDto> quList;

    /**
     * 随机组题信息
     */
    private List<RandomQuDto> randomInfo;


}


