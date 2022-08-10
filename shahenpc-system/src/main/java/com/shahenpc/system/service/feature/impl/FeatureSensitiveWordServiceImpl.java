package com.shahenpc.system.service.feature.impl;

import java.util.List;
import java.util.Set;

import com.shahenpc.common.utils.DateUtils;
import com.shahenpc.common.utils.SensitiveWordUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shahenpc.system.mapper.feature.FeatureSensitiveWordMapper;
import com.shahenpc.system.domain.feature.FeatureSensitiveWord;
import com.shahenpc.system.service.feature.IFeatureSensitiveWordService;

/**
 * 重点工作-敏感词管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-08-10
 */
@Service
public class FeatureSensitiveWordServiceImpl implements IFeatureSensitiveWordService 
{
    @Autowired
    private FeatureSensitiveWordMapper featureSensitiveWordMapper;

    /**
     * 查询重点工作-敏感词管理
     * 
     * @param sensitiveId 重点工作-敏感词管理主键
     * @return 重点工作-敏感词管理
     */
    @Override
    public FeatureSensitiveWord selectFeatureSensitiveWordBySensitiveId(Long sensitiveId)
    {
        return featureSensitiveWordMapper.selectFeatureSensitiveWordBySensitiveId(sensitiveId);
    }

    /**
     * 查询重点工作-敏感词管理列表
     * 
     * @param featureSensitiveWord 重点工作-敏感词管理
     * @return 重点工作-敏感词管理
     */
    @Override
    public List<FeatureSensitiveWord> selectFeatureSensitiveWordList(FeatureSensitiveWord featureSensitiveWord)
    {
        return featureSensitiveWordMapper.selectFeatureSensitiveWordList(featureSensitiveWord);
    }

    /**
     * 新增重点工作-敏感词管理
     * 
     * @param featureSensitiveWord 重点工作-敏感词管理
     * @return 结果
     */
    @Override
    public int insertFeatureSensitiveWord(FeatureSensitiveWord featureSensitiveWord)
    {
        featureSensitiveWord.setCreateTime(DateUtils.getNowDate());
        return featureSensitiveWordMapper.insertFeatureSensitiveWord(featureSensitiveWord);
    }

    /**
     * 修改重点工作-敏感词管理
     * 
     * @param featureSensitiveWord 重点工作-敏感词管理
     * @return 结果
     */
    @Override
    public int updateFeatureSensitiveWord(FeatureSensitiveWord featureSensitiveWord)
    {
        featureSensitiveWord.setUpdateTime(DateUtils.getNowDate());
        return featureSensitiveWordMapper.updateFeatureSensitiveWord(featureSensitiveWord);
    }

    /**
     * 批量删除重点工作-敏感词管理
     * 
     * @param sensitiveIds 需要删除的重点工作-敏感词管理主键
     * @return 结果
     */
    @Override
    public int deleteFeatureSensitiveWordBySensitiveIds(Long[] sensitiveIds)
    {
        return featureSensitiveWordMapper.deleteFeatureSensitiveWordBySensitiveIds(sensitiveIds);
    }

    /**
     * 删除重点工作-敏感词管理信息
     * 
     * @param sensitiveId 重点工作-敏感词管理主键
     * @return 结果
     */
    @Override
    public int deleteFeatureSensitiveWordBySensitiveId(Long sensitiveId)
    {
        return featureSensitiveWordMapper.deleteFeatureSensitiveWordBySensitiveId(sensitiveId);
    }

    @Override
    public Set<String> selectAll() {
        SensitiveWordUtil.init(featureSensitiveWordMapper.selectAll());
        return null;
    }
}
