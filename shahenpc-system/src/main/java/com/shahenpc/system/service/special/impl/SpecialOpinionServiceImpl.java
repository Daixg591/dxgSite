package com.shahenpc.system.service.special.impl;

import java.util.List;
import com.shahenpc.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shahenpc.system.mapper.special.SpecialOpinionMapper;
import com.shahenpc.system.domain.special.SpecialOpinion;
import com.shahenpc.system.service.special.ISpecialOpinionService;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-07-01
 */
@Service
public class SpecialOpinionServiceImpl implements ISpecialOpinionService 
{
    @Autowired
    private SpecialOpinionMapper specialOpinionMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param opinionId 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public SpecialOpinion selectSpecialOpinionByOpinionId(Long opinionId)
    {
        return specialOpinionMapper.selectSpecialOpinionByOpinionId(opinionId);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param specialOpinion 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<SpecialOpinion> selectSpecialOpinionList(SpecialOpinion specialOpinion)
    {
        return specialOpinionMapper.selectSpecialOpinionList(specialOpinion);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param specialOpinion 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertSpecialOpinion(SpecialOpinion specialOpinion)
    {
        specialOpinion.setCreateTime(DateUtils.getNowDate());
        return specialOpinionMapper.insertSpecialOpinion(specialOpinion);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param specialOpinion 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateSpecialOpinion(SpecialOpinion specialOpinion)
    {
        specialOpinion.setUpdateTime(DateUtils.getNowDate());
        return specialOpinionMapper.updateSpecialOpinion(specialOpinion);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param opinionIds 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteSpecialOpinionByOpinionIds(Long[] opinionIds)
    {
        return specialOpinionMapper.deleteSpecialOpinionByOpinionIds(opinionIds);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param opinionId 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteSpecialOpinionByOpinionId(Long opinionId)
    {
        return specialOpinionMapper.deleteSpecialOpinionByOpinionId(opinionId);
    }
}
