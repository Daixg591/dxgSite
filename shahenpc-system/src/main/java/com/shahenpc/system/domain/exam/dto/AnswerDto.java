package com.shahenpc.system.domain.exam.dto;

import lombok.Data;

import java.util.List;

/**
 * 答题Item Dto实体类
 * @author Hardy
 * 2022-08-04
 */
@Data
public class AnswerDto {
    /**
     * 试题Id
     */
    private Long quId;

    /**
     * 答案Id集合
     */
    private List<Long> answerId;

    /***
     * 当前试题分值
     */
    private Double score;
}
