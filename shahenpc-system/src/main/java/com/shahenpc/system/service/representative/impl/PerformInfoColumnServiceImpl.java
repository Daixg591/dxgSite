package com.shahenpc.system.service.representative.impl;

import java.util.List;
import com.shahenpc.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shahenpc.system.mapper.representative.PerformInfoColumnMapper;
import com.shahenpc.system.domain.representative.PerformInfoColumn;
import com.shahenpc.system.service.representative.IPerformInfoColumnService;

/**
 * 信息发布栏目菜单Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-07-08
 */
@Service
public class PerformInfoColumnServiceImpl implements IPerformInfoColumnService 
{
    @Autowired
    private PerformInfoColumnMapper performInfoColumnMapper;

    /**
     * 查询信息发布栏目菜单
     * 
     * @param columnId 信息发布栏目菜单主键
     * @return 信息发布栏目菜单
     */
    @Override
    public PerformInfoColumn selectPerformInfoColumnByColumnId(Long columnId)
    {
        return performInfoColumnMapper.selectPerformInfoColumnByColumnId(columnId);
    }

    /**
     * 查询信息发布栏目菜单列表
     * 
     * @param performInfoColumn 信息发布栏目菜单
     * @return 信息发布栏目菜单
     */
    @Override
    public List<PerformInfoColumn> selectPerformInfoColumnList(PerformInfoColumn performInfoColumn)
    {
        return performInfoColumnMapper.selectPerformInfoColumnList(performInfoColumn);
    }

    /**
     * 新增信息发布栏目菜单
     * 
     * @param performInfoColumn 信息发布栏目菜单
     * @return 结果
     */
    @Override
    public int insertPerformInfoColumn(PerformInfoColumn performInfoColumn)
    {
        performInfoColumn.setCreateTime(DateUtils.getNowDate());
        return performInfoColumnMapper.insertPerformInfoColumn(performInfoColumn);
    }

    /**
     * 修改信息发布栏目菜单
     * 
     * @param performInfoColumn 信息发布栏目菜单
     * @return 结果
     */
    @Override
    public int updatePerformInfoColumn(PerformInfoColumn performInfoColumn)
    {
        performInfoColumn.setUpdateTime(DateUtils.getNowDate());
        return performInfoColumnMapper.updatePerformInfoColumn(performInfoColumn);
    }

    /**
     * 批量删除信息发布栏目菜单
     * 
     * @param columnIds 需要删除的信息发布栏目菜单主键
     * @return 结果
     */
    @Override
    public int deletePerformInfoColumnByColumnIds(Long[] columnIds)
    {
        return performInfoColumnMapper.deletePerformInfoColumnByColumnIds(columnIds);
    }

    /**
     * 删除信息发布栏目菜单信息
     * 
     * @param columnId 信息发布栏目菜单主键
     * @return 结果
     */
    @Override
    public int deletePerformInfoColumnByColumnId(Long columnId)
    {
        return performInfoColumnMapper.deletePerformInfoColumnByColumnId(columnId);
    }
}
