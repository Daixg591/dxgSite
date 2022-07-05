package com.shahenpc.system.mapper.censor;

import java.util.List;
import com.shahenpc.system.domain.censor.CensorProcess;

/**
 * 审查流程Mapper接口
 * 
 * @author ruoyi
 * @date 2022-07-05
 */
public interface CensorProcessMapper 
{
    /**
     * 查询审查流程
     * 
     * @param processId 审查流程主键
     * @return 审查流程
     */
    public CensorProcess selectCensorProcessByProcessId(Long processId);

    /**
     * 查询审查流程列表
     * 
     * @param censorProcess 审查流程
     * @return 审查流程集合
     */
    public List<CensorProcess> selectCensorProcessList(CensorProcess censorProcess);

    /**
     * 新增审查流程
     * 
     * @param censorProcess 审查流程
     * @return 结果
     */
    public int insertCensorProcess(CensorProcess censorProcess);

    /**
     * 修改审查流程
     * 
     * @param censorProcess 审查流程
     * @return 结果
     */
    public int updateCensorProcess(CensorProcess censorProcess);

    /**
     * 删除审查流程
     * 
     * @param processId 审查流程主键
     * @return 结果
     */
    public int deleteCensorProcessByProcessId(Long processId);

    /**
     * 批量删除审查流程
     * 
     * @param processIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCensorProcessByProcessIds(Long[] processIds);


    public CensorProcess selectCensorProcessByWorkflowId(String WorkflowId);
}
