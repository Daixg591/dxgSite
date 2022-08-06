package com.shahenpc.system.domain.exam.dto;

import lombok.Data;

import java.util.List;

/**
 * 大体记录参数实体类
 * @author Hardy
 * 2022-08-03
 */
@Data
public class AnswerLogDto {

    /**
     * 考试id
     */
    private Long examId;

    /**
     * 任免记录与考试绑定关系Id
     */
    private Long regExamId;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 答题记录集合
     */
    private List<AnswerDto> answerLog;
}
