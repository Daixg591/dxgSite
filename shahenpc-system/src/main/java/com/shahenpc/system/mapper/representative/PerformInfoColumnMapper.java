package com.shahenpc.system.mapper.representative;

import java.util.List;
import com.shahenpc.system.domain.representative.PerformInfoColumn;

/**
 * 信息发布栏目菜单Mapper接口
 * 
 * @author ruoyi
 * @date 2022-07-08
 */
public interface PerformInfoColumnMapper 
{
    /**
     * 查询信息发布栏目菜单
     * 
     * @param columnId 信息发布栏目菜单主键
     * @return 信息发布栏目菜单
     */
    public PerformInfoColumn selectPerformInfoColumnByColumnId(Long columnId);

    /**
     * 查询信息发布栏目菜单列表
     * 
     * @param performInfoColumn 信息发布栏目菜单
     * @return 信息发布栏目菜单集合
     */
    public List<PerformInfoColumn> selectPerformInfoColumnList(PerformInfoColumn performInfoColumn);

    /**
     * 新增信息发布栏目菜单
     * 
     * @param performInfoColumn 信息发布栏目菜单
     * @return 结果
     */
    public int insertPerformInfoColumn(PerformInfoColumn performInfoColumn);

    /**
     * 修改信息发布栏目菜单
     * 
     * @param performInfoColumn 信息发布栏目菜单
     * @return 结果
     */
    public int updatePerformInfoColumn(PerformInfoColumn performInfoColumn);

    /**
     * 删除信息发布栏目菜单
     * 
     * @param columnId 信息发布栏目菜单主键
     * @return 结果
     */
    public int deletePerformInfoColumnByColumnId(Long columnId);

    /**
     * 批量删除信息发布栏目菜单
     * 
     * @param columnIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deletePerformInfoColumnByColumnIds(Long[] columnIds);
}
