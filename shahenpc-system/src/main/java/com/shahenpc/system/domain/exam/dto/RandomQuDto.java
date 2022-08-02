package com.shahenpc.system.domain.exam.dto;

import lombok.Data;

/**
 * 随机选题试题库信息
 * @author Hardy
 * 2022-08-01
 */

@Data
public class RandomQuDto {

    /**
     * 题库Id
     */
    private Long bankId;

    /**
     * 选题数量
     */
    private int quCnt;
}
