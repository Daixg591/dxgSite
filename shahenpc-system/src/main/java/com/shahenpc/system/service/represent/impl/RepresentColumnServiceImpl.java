package com.shahenpc.system.service.represent.impl;

import java.util.List;
import com.shahenpc.common.utils.DateUtils;
import com.shahenpc.system.domain.represent.dto.RepresentColumnDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shahenpc.system.mapper.represent.RepresentColumnMapper;
import com.shahenpc.system.domain.represent.RepresentColumn;
import com.shahenpc.system.service.represent.IRepresentColumnService;

/**
 * 信息发布栏目菜单Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-07-21
 */
@Service
public class RepresentColumnServiceImpl implements IRepresentColumnService 
{
    @Autowired
    private RepresentColumnMapper representColumnMapper;

    /**
     * 查询信息发布栏目菜单
     * 
     * @param columnId 信息发布栏目菜单主键
     * @return 信息发布栏目菜单
     */
    @Override
    public RepresentColumn selectRepresentColumnByColumnId(Long columnId)
    {
        return representColumnMapper.selectRepresentColumnByColumnId(columnId);
    }

    /**
     * 查询信息发布栏目菜单列表
     * 
     * @param representColumn 信息发布栏目菜单
     * @return 信息发布栏目菜单
     */
    @Override
    public List<RepresentColumn> selectRepresentColumnList(RepresentColumn representColumn)
    {
        return representColumnMapper.selectRepresentColumnList(representColumn);
    }

    /**
     * 新增信息发布栏目菜单
     * 
     * @param representColumn 信息发布栏目菜单
     * @return 结果
     */
    @Override
    public int insertRepresentColumn(RepresentColumn representColumn)
    {
        representColumn.setCreateTime(DateUtils.getNowDate());
        return representColumnMapper.insertRepresentColumn(representColumn);
    }

    /**
     * 修改信息发布栏目菜单
     * 
     * @param representColumn 信息发布栏目菜单
     * @return 结果
     */
    @Override
    public int updateRepresentColumn(RepresentColumn representColumn)
    {
        representColumn.setUpdateTime(DateUtils.getNowDate());
        return representColumnMapper.updateRepresentColumn(representColumn);
    }

    /**
     * 批量删除信息发布栏目菜单
     * 
     * @param columnIds 需要删除的信息发布栏目菜单主键
     * @return 结果
     */
    @Override
    public int deleteRepresentColumnByColumnIds(Long[] columnIds)
    {
        return representColumnMapper.deleteRepresentColumnByColumnIds(columnIds);
    }

    /**
     * 删除信息发布栏目菜单信息
     * 
     * @param columnId 信息发布栏目菜单主键
     * @return 结果
     */
    @Override
    public int deleteRepresentColumnByColumnId(Long columnId)
    {
        return representColumnMapper.deleteRepresentColumnByColumnId(columnId);
    }

    @Override
    public List<RepresentColumnDto> selectByAdminList(RepresentColumn representColumn) {
        return representColumnMapper.selectByAdminList(representColumn);
    }
}
