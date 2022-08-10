package com.shahenpc.system.service.feature;

import java.util.List;
import java.util.Set;

import com.shahenpc.system.domain.feature.FeatureSensitiveWord;

/**
 * 重点工作-敏感词管理Service接口
 * 
 * @author ruoyi
 * @date 2022-08-10
 */
public interface IFeatureSensitiveWordService 
{
    /**
     * 查询重点工作-敏感词管理
     * 
     * @param sensitiveId 重点工作-敏感词管理主键
     * @return 重点工作-敏感词管理
     */
    public FeatureSensitiveWord selectFeatureSensitiveWordBySensitiveId(Long sensitiveId);

    /**
     * 查询重点工作-敏感词管理列表
     * 
     * @param featureSensitiveWord 重点工作-敏感词管理
     * @return 重点工作-敏感词管理集合
     */
    public List<FeatureSensitiveWord> selectFeatureSensitiveWordList(FeatureSensitiveWord featureSensitiveWord);

    /**
     * 新增重点工作-敏感词管理
     * 
     * @param featureSensitiveWord 重点工作-敏感词管理
     * @return 结果
     */
    public int insertFeatureSensitiveWord(FeatureSensitiveWord featureSensitiveWord);

    /**
     * 修改重点工作-敏感词管理
     * 
     * @param featureSensitiveWord 重点工作-敏感词管理
     * @return 结果
     */
    public int updateFeatureSensitiveWord(FeatureSensitiveWord featureSensitiveWord);

    /**
     * 批量删除重点工作-敏感词管理
     * 
     * @param sensitiveIds 需要删除的重点工作-敏感词管理主键集合
     * @return 结果
     */
    public int deleteFeatureSensitiveWordBySensitiveIds(Long[] sensitiveIds);

    /**
     * 删除重点工作-敏感词管理信息
     * 
     * @param sensitiveId 重点工作-敏感词管理主键
     * @return 结果
     */
    public int deleteFeatureSensitiveWordBySensitiveId(Long sensitiveId);


    public Set<String> selectAll();
}
