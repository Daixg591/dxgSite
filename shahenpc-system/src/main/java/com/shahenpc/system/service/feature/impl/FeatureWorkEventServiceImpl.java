package com.shahenpc.system.service.feature.impl;

import java.util.List;
import com.shahenpc.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shahenpc.system.mapper.feature.FeatureWorkEventMapper;
import com.shahenpc.system.domain.feature.FeatureWorkEvent;
import com.shahenpc.system.service.feature.IFeatureWorkEventService;

/**
 * 特色工作-民生实事-环境保护-信访稳定-营商环境-乡村振兴Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-07-15
 */
@Service
public class FeatureWorkEventServiceImpl implements IFeatureWorkEventService 
{
    @Autowired
    private FeatureWorkEventMapper featureWorkEventMapper;

    /**
     * 查询特色工作-民生实事-环境保护-信访稳定-营商环境-乡村振兴
     * 
     * @param eventId 特色工作-民生实事-环境保护-信访稳定-营商环境-乡村振兴主键
     * @return 特色工作-民生实事-环境保护-信访稳定-营商环境-乡村振兴
     */
    @Override
    public FeatureWorkEvent selectFeatureWorkEventByEventId(Long eventId)
    {
        return featureWorkEventMapper.selectFeatureWorkEventByEventId(eventId);
    }

    /**
     * 查询特色工作-民生实事-环境保护-信访稳定-营商环境-乡村振兴列表
     * 
     * @param featureWorkEvent 特色工作-民生实事-环境保护-信访稳定-营商环境-乡村振兴
     * @return 特色工作-民生实事-环境保护-信访稳定-营商环境-乡村振兴
     */
    @Override
    public List<FeatureWorkEvent> selectFeatureWorkEventList(FeatureWorkEvent featureWorkEvent)
    {
        return featureWorkEventMapper.selectFeatureWorkEventList(featureWorkEvent);
    }

    /**
     * 新增特色工作-民生实事-环境保护-信访稳定-营商环境-乡村振兴
     * 
     * @param featureWorkEvent 特色工作-民生实事-环境保护-信访稳定-营商环境-乡村振兴
     * @return 结果
     */
    @Override
    public int insertFeatureWorkEvent(FeatureWorkEvent featureWorkEvent)
    {
        featureWorkEvent.setCreateTime(DateUtils.getNowDate());
        return featureWorkEventMapper.insertFeatureWorkEvent(featureWorkEvent);
    }

    /**
     * 修改特色工作-民生实事-环境保护-信访稳定-营商环境-乡村振兴
     * 
     * @param featureWorkEvent 特色工作-民生实事-环境保护-信访稳定-营商环境-乡村振兴
     * @return 结果
     */
    @Override
    public int updateFeatureWorkEvent(FeatureWorkEvent featureWorkEvent)
    {
        featureWorkEvent.setUpdateTime(DateUtils.getNowDate());
        return featureWorkEventMapper.updateFeatureWorkEvent(featureWorkEvent);
    }

    /**
     * 批量删除特色工作-民生实事-环境保护-信访稳定-营商环境-乡村振兴
     * 
     * @param eventIds 需要删除的特色工作-民生实事-环境保护-信访稳定-营商环境-乡村振兴主键
     * @return 结果
     */
    @Override
    public int deleteFeatureWorkEventByEventIds(Long[] eventIds)
    {
        return featureWorkEventMapper.deleteFeatureWorkEventByEventIds(eventIds);
    }

    /**
     * 删除特色工作-民生实事-环境保护-信访稳定-营商环境-乡村振兴信息
     * 
     * @param eventId 特色工作-民生实事-环境保护-信访稳定-营商环境-乡村振兴主键
     * @return 结果
     */
    @Override
    public int deleteFeatureWorkEventByEventId(Long eventId)
    {
        return featureWorkEventMapper.deleteFeatureWorkEventByEventId(eventId);
    }
}
