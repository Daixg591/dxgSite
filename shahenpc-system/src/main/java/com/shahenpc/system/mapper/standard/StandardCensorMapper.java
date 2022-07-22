package com.shahenpc.system.mapper.standard;

import com.shahenpc.system.domain.standard.StandardCensor;

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
    public StandardCensor selectStandardCensorByProcessId(Long processId);

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
     * @param processId 审查流程主键
     * @return 结果
     */
    public int deleteStandardCensorByProcessId(Long processId);

    /**
     * 批量删除审查流程
     * 
     * @param processIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteStandardCensorByProcessIds(Long[] processIds);

    /**
     *
     * @param WorkflowId
     * @return
     */
    public StandardCensor selectCensorProcessByWorkflowId(String WorkflowId);
}
