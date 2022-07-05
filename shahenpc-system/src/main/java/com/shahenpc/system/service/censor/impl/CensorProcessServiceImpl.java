package com.shahenpc.system.service.censor.impl;

import java.util.List;
import com.shahenpc.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shahenpc.system.mapper.censor.CensorProcessMapper;
import com.shahenpc.system.domain.censor.CensorProcess;
import com.shahenpc.system.service.censor.ICensorProcessService;

/**
 * 审查流程Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-07-05
 */
@Service
public class CensorProcessServiceImpl implements ICensorProcessService 
{
    @Autowired
    private CensorProcessMapper censorProcessMapper;

    /**
     * 查询审查流程
     * 
     * @param processId 审查流程主键
     * @return 审查流程
     */
    @Override
    public CensorProcess selectCensorProcessByProcessId(Long processId)
    {
        return censorProcessMapper.selectCensorProcessByProcessId(processId);
    }

    /**
     * 查询审查流程列表
     * 
     * @param censorProcess 审查流程
     * @return 审查流程
     */
    @Override
    public List<CensorProcess> selectCensorProcessList(CensorProcess censorProcess)
    {
        return censorProcessMapper.selectCensorProcessList(censorProcess);
    }

    /**
     * 新增审查流程
     * 
     * @param censorProcess 审查流程
     * @return 结果
     */
    @Override
    public int insertCensorProcess(CensorProcess censorProcess)
    {
        censorProcess.setCreateTime(DateUtils.getNowDate());
        return censorProcessMapper.insertCensorProcess(censorProcess);
    }

    /**
     * 修改审查流程
     * 
     * @param censorProcess 审查流程
     * @return 结果
     */
    @Override
    public int updateCensorProcess(CensorProcess censorProcess)
    {
        censorProcess.setUpdateTime(DateUtils.getNowDate());
        return censorProcessMapper.updateCensorProcess(censorProcess);
    }

    /**
     * 批量删除审查流程
     * 
     * @param processIds 需要删除的审查流程主键
     * @return 结果
     */
    @Override
    public int deleteCensorProcessByProcessIds(Long[] processIds)
    {
        return censorProcessMapper.deleteCensorProcessByProcessIds(processIds);
    }

    /**
     * 删除审查流程信息
     * 
     * @param processId 审查流程主键
     * @return 结果
     */
    @Override
    public int deleteCensorProcessByProcessId(Long processId)
    {
        return censorProcessMapper.deleteCensorProcessByProcessId(processId);
    }

    @Override
    public CensorProcess selectCensorProcessByWorkflowId(String workflowId) {

        return censorProcessMapper.selectCensorProcessByWorkflowId(workflowId);
    }
}
