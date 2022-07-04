package com.shahenpc.system.service.special.impl;

import java.util.List;
import com.shahenpc.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shahenpc.system.mapper.special.SpecialWorkMapper;
import com.shahenpc.system.domain.special.SpecialWork;
import com.shahenpc.system.service.special.ISpecialWorkService;

/**
 * 特色工作Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-07-01
 */
@Service
public class SpecialWorkServiceImpl implements ISpecialWorkService 
{
    @Autowired
    private SpecialWorkMapper specialWorkMapper;

    /**
     * 查询特色工作
     * 
     * @param specialId 特色工作主键
     * @return 特色工作
     */
    @Override
    public SpecialWork selectSpecialWorkBySpecialId(Long specialId)
    {
        return specialWorkMapper.selectSpecialWorkBySpecialId(specialId);
    }

    /**
     * 查询特色工作列表
     * 
     * @param specialWork 特色工作
     * @return 特色工作
     */
    @Override
    public List<SpecialWork> selectSpecialWorkList(SpecialWork specialWork)
    {
        return specialWorkMapper.selectSpecialWorkList(specialWork);
    }

    /**
     * 新增特色工作
     * 
     * @param specialWork 特色工作
     * @return 结果
     */
    @Override
    public int insertSpecialWork(SpecialWork specialWork)
    {
        specialWork.setCreateTime(DateUtils.getNowDate());
        return specialWorkMapper.insertSpecialWork(specialWork);
    }

    /**
     * 修改特色工作
     * 
     * @param specialWork 特色工作
     * @return 结果
     */
    @Override
    public int updateSpecialWork(SpecialWork specialWork)
    {
        specialWork.setUpdateTime(DateUtils.getNowDate());
        return specialWorkMapper.updateSpecialWork(specialWork);
    }

    /**
     * 批量删除特色工作
     * 
     * @param specialIds 需要删除的特色工作主键
     * @return 结果
     */
    @Override
    public int deleteSpecialWorkBySpecialIds(Long[] specialIds)
    {
        return specialWorkMapper.deleteSpecialWorkBySpecialIds(specialIds);
    }

    /**
     * 删除特色工作信息
     * 
     * @param specialId 特色工作主键
     * @return 结果
     */
    @Override
    public int deleteSpecialWorkBySpecialId(Long specialId)
    {
        return specialWorkMapper.deleteSpecialWorkBySpecialId(specialId);
    }
}
