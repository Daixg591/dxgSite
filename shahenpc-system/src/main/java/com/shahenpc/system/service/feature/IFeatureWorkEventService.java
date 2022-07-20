package com.shahenpc.system.service.feature;

import java.util.List;
import com.shahenpc.system.domain.feature.FeatureWorkEvent;
import com.shahenpc.system.domain.feature.dto.FeatureCurveDto;
import com.shahenpc.system.domain.feature.dto.FeatureMonthDto;

/**
 * 特色工作-民生实事-环境保护-信访稳定-营商环境-乡村振兴Service接口
 * 
 * @author ruoyi
 * @date 2022-07-15
 */
public interface IFeatureWorkEventService 
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
     * 批量删除特色工作-民生实事-环境保护-信访稳定-营商环境-乡村振兴
     * 
     * @param eventIds 需要删除的特色工作-民生实事-环境保护-信访稳定-营商环境-乡村振兴主键集合
     * @return 结果
     */
    public int deleteFeatureWorkEventByEventIds(Long[] eventIds);

    /**
     * 删除特色工作-民生实事-环境保护-信访稳定-营商环境-乡村振兴信息
     * 
     * @param eventId 特色工作-民生实事-环境保护-信访稳定-营商环境-乡村振兴主键
     * @return 结果
     */
    public int deleteFeatureWorkEventByEventId(Long eventId);

    /**
     * 总数and 月数
     */
    public FeatureMonthDto getCount(Integer workType);

    /**
     *
     * @param workType
     * @return
     */
    public FeatureCurveDto monthCount(Integer workType);

    public String ringScale(Integer workType);
}
