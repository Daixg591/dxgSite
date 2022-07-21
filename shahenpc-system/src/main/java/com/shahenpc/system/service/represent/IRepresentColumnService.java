package com.shahenpc.system.service.represent;

import java.util.List;
import com.shahenpc.system.domain.represent.RepresentColumn;
import com.shahenpc.system.domain.represent.dto.RepresentColumnDto;

/**
 * 信息发布栏目菜单Service接口
 * 
 * @author ruoyi
 * @date 2022-07-21
 */
public interface IRepresentColumnService 
{
    /**
     * 查询信息发布栏目菜单
     * 
     * @param columnId 信息发布栏目菜单主键
     * @return 信息发布栏目菜单
     */
    public RepresentColumn selectRepresentColumnByColumnId(Long columnId);

    /**
     * 查询信息发布栏目菜单列表
     * 
     * @param representColumn 信息发布栏目菜单
     * @return 信息发布栏目菜单集合
     */
    public List<RepresentColumn> selectRepresentColumnList(RepresentColumn representColumn);

    /**
     * 新增信息发布栏目菜单
     * 
     * @param representColumn 信息发布栏目菜单
     * @return 结果
     */
    public int insertRepresentColumn(RepresentColumn representColumn);

    /**
     * 修改信息发布栏目菜单
     * 
     * @param representColumn 信息发布栏目菜单
     * @return 结果
     */
    public int updateRepresentColumn(RepresentColumn representColumn);

    /**
     * 批量删除信息发布栏目菜单
     * 
     * @param columnIds 需要删除的信息发布栏目菜单主键集合
     * @return 结果
     */
    public int deleteRepresentColumnByColumnIds(Long[] columnIds);

    /**
     * 删除信息发布栏目菜单信息
     * 
     * @param columnId 信息发布栏目菜单主键
     * @return 结果
     */
    public int deleteRepresentColumnByColumnId(Long columnId);

    public List<RepresentColumnDto> selectByAdminList(RepresentColumn representColumn);
}
