package com.shahenpc.system.domain.personel.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author Hardy
 * 人事任免统计信息实体类
 */
@Data
public class PersonelStatisticsVo implements Serializable {
    /**
     * 任免累计总次数
     */
    public Integer registerCnt;

    /**
     * 任命饼状图数据
     */
    public List<EchartItemVo> pieChart;

    /**
     * 趋势图数据
     */
    public TendencyChart tendencyChart;
}


