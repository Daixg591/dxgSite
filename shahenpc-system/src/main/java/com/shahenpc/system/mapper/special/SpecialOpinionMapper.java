package com.shahenpc.system.mapper.special;

import java.util.List;
import com.shahenpc.system.domain.special.SpecialOpinion;

/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author ruoyi
 * @date 2022-07-01
 */
public interface SpecialOpinionMapper 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param opinionId 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public SpecialOpinion selectSpecialOpinionByOpinionId(Long opinionId);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param specialOpinion 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<SpecialOpinion> selectSpecialOpinionList(SpecialOpinion specialOpinion);

    /**
     * 新增【请填写功能名称】
     * 
     * @param specialOpinion 【请填写功能名称】
     * @return 结果
     */
    public int insertSpecialOpinion(SpecialOpinion specialOpinion);

    /**
     * 修改【请填写功能名称】
     * 
     * @param specialOpinion 【请填写功能名称】
     * @return 结果
     */
    public int updateSpecialOpinion(SpecialOpinion specialOpinion);

    /**
     * 删除【请填写功能名称】
     * 
     * @param opinionId 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteSpecialOpinionByOpinionId(Long opinionId);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param opinionIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSpecialOpinionByOpinionIds(Long[] opinionIds);
}
