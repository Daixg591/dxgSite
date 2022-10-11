package com.shahenpc.system.mapper.standard;

import com.shahenpc.system.domain.standard.StandardCensor;
import com.shahenpc.system.domain.standard.dto.CemsorDetailDto;
import com.shahenpc.system.domain.standard.dto.TotalAndStatyDto;

import java.util.List;

/**
 * 审查流程Mapper接口
 * 
 * @author ruoyi
 * @date 2022-07-22
 */
public interface StandardCensorMapper 
{
    /**
     * 查询审查流程
     * 
     * @param processId 审查流程主键
     * @return 审查流程
     */
    public StandardCensor selectStandardCensorByCensorId(Long censorIds);

    /**
     * 查询审查流程列表
     * 
     * @param standardCensor 审查流程
     * @return 审查流程集合
     */
    public List<StandardCensor> selectStandardCensorList(StandardCensor standardCensor);

    /**
     * 新增审查流程
     * 
     * @param standardCensor 审查流程
     * @return 结果
     */
    public int insertStandardCensor(StandardCensor standardCensor);

    /**
     * 修改审查流程
     * 
     * @param standardCensor 审查流程
     * @return 结果
     */
    public int updateStandardCensor(StandardCensor standardCensor);

    /**
     * 删除审查流程
     * 
     * @param censorId 审查流程主键
     * @return 结果
     */
    public int deleteStandardCensorByCensorId(Long censorId);

    /**
     * 批量删除审查流程
     * 
     * @param censorIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteStandardCensorByCensorIds(Long[] censorIds);


    public StandardCensor selectByProcessId(String processId);


    public CemsorDetailDto selectByCensorId(Long cemsorId);

    public List<StandardCensor> selectByTodoList(StandardCensor request);

    public List<StandardCensor> selectByDoneList(Long userId);

    public TotalAndStatyDto selectByTotalAndStay();

    public List<StandardCensor> selectByTypeList(Integer type);
}
