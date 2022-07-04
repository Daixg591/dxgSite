package com.shahenpc.system.mapper.special;

import java.util.List;
import com.shahenpc.system.domain.special.SpecialWork;

/**
 * 特色工作Mapper接口
 * 
 * @author ruoyi
 * @date 2022-07-01
 */
public interface SpecialWorkMapper 
{
    /**
     * 查询特色工作
     * 
     * @param specialId 特色工作主键
     * @return 特色工作
     */
    public SpecialWork selectSpecialWorkBySpecialId(Long specialId);

    /**
     * 查询特色工作列表
     * 
     * @param specialWork 特色工作
     * @return 特色工作集合
     */
    public List<SpecialWork> selectSpecialWorkList(SpecialWork specialWork);

    /**
     * 新增特色工作
     * 
     * @param specialWork 特色工作
     * @return 结果
     */
    public int insertSpecialWork(SpecialWork specialWork);

    /**
     * 修改特色工作
     * 
     * @param specialWork 特色工作
     * @return 结果
     */
    public int updateSpecialWork(SpecialWork specialWork);

    /**
     * 删除特色工作
     * 
     * @param specialId 特色工作主键
     * @return 结果
     */
    public int deleteSpecialWorkBySpecialId(Long specialId);

    /**
     * 批量删除特色工作
     * 
     * @param specialIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSpecialWorkBySpecialIds(Long[] specialIds);
}
