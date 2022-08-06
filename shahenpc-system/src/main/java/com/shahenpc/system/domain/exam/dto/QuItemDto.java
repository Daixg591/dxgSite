package com.shahenpc.system.domain.exam.dto;

import lombok.Data;

/**
 * 试题信息
 *
 * @author Hardy
 * 2022-08-01
 */

@Data
public class QuItemDto {
    /**
     * 试题Id
     */
    private Long quId;

    /**
     * 试题分数
     */
    private Double score;

    /**
     * 试题类型
     */
    private String quType;
}
