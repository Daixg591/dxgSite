package com.shahenpc.system.mapper.feature;

import java.util.List;
import com.shahenpc.system.domain.feature.FeatureWorkEvent;
import com.shahenpc.system.domain.feature.dto.FeatureCakeDto;
import com.shahenpc.system.domain.feature.dto.FeatureMonthDto;

/**
 * 特色工作-民生实事-环境保护-信访稳定-营商环境-乡村振兴Mapper接口
 * 
 * @author ruoyi
 * @date 2022-07-15
 */
public interface FeatureWorkEventMapper 
{
    /**
     * 查询特色工作-民生实事-环境保护-信访稳定-营商环境-乡村振兴
     * 
     * @param eventId 特色工作-民生实事-环境保护-信访稳定-营商环境-乡村振兴主键
     * @return 特色工作-民生实事-环境保护-信访稳定-营商环境-乡村振兴
     */
    public FeatureWorkEvent selectFeatureWorkEventByEventId(Long eventId);

    /**
     * 查询特色工作-民生实事-环境保护-信访稳定-营商环境-乡村振兴列表
     * 
     * @param featureWorkEvent 特色工作-民生实事-环境保护-信访稳定-营商环境-乡村振兴
     * @return 特色工作-民生实事-环境保护-信访稳定-营商环境-乡村振兴集合
     */
    public List<FeatureWorkEvent> selectFeatureWorkEventList(FeatureWorkEvent featureWorkEvent);

    /**
     * 新增特色工作-民生实事-环境保护-信访稳定-营商环境-乡村振兴
     * 
     * @param featureWorkEvent 特色工作-民生实事-环境保护-信访稳定-营商环境-乡村振兴
     * @return 结果
     */
    public int insertFeatureWorkEvent(FeatureWorkEvent featureWorkEvent);

    /**
     * 修改特色工作-民生实事-环境保护-信访稳定-营商环境-乡村振兴
     * 
     * @param featureWorkEvent 特色工作-民生实事-环境保护-信访稳定-营商环境-乡村振兴
     * @return 结果
     */
    public int updateFeatureWorkEvent(FeatureWorkEvent featureWorkEvent);

    /**
     * 删除特色工作-民生实事-环境保护-信访稳定-营商环境-乡村振兴
     * 
     * @param eventId 特色工作-民生实事-环境保护-信访稳定-营商环境-乡村振兴主键
     * @return 结果
     */
    public int deleteFeatureWorkEventByEventId(Long eventId);

    /**
     * 批量删除特色工作-民生实事-环境保护-信访稳定-营商环境-乡村振兴
     * 
     * @param eventIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteFeatureWorkEventByEventIds(Long[] eventIds);

    /**
     *
     */
    public FeatureMonthDto getCount(Integer workType);
    /**
     *
     */
    public FeatureCakeDto monthCount(Integer workType);
}
