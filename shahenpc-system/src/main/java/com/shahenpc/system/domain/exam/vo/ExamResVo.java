package com.shahenpc.system.domain.exam.vo;

import lombok.Data;

/**
 * 考试结果实体类
 * @author Hardy
 *
 * 2022-08-06
 */

@Data
public class ExamResVo {

    /**
     * 考试得分
     */
    private Double score;

    /**
     * 考试完成感谢语
     */
    private String thanksWords;
}
