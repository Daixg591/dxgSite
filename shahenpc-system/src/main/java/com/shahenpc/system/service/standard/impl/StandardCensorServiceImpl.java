package com.shahenpc.system.service.standard.impl;

import com.shahenpc.common.utils.DateUtils;
import com.shahenpc.system.domain.standard.StandardCensor;
import com.shahenpc.system.mapper.standard.StandardCensorMapper;
import com.shahenpc.system.service.standard.IStandardCensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 审查流程Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-07-22
 */
@Service
public class StandardCensorServiceImpl implements IStandardCensorService 
{
    @Autowired
    private StandardCensorMapper standardCensorMapper;
    /**
     * 查询审查流程
     * 
     * @param processId 审查流程主键
     * @return 审查流程
     */
    @Override
    public StandardCensor selectStandardCensorByProcessId(Long processId)
    {
        return standardCensorMapper.selectStandardCensorByProcessId(processId);
    }

    /**
     * 查询审查流程列表
     * 
     * @param standardCensor 审查流程
     * @return 审查流程
     */
    @Override
    public List<StandardCensor> selectStandardCensorList(StandardCensor standardCensor)
    {
        return standardCensorMapper.selectStandardCensorList(standardCensor);
    }

    /**
     * 新增审查流程
     * 
     * @param standardCensor 审查流程
     * @return 结果
     */
    @Override
    public int insertStandardCensor(StandardCensor standardCensor)
    {
        standardCensor.setCreateTime(DateUtils.getNowDate());
        return standardCensorMapper.insertStandardCensor(standardCensor);
    }

    /**
     * 修改审查流程
     * 
     * @param standardCensor 审查流程
     * @return 结果
     */
    @Override
    public int updateStandardCensor(StandardCensor standardCensor)
    {
        standardCensor.setUpdateTime(DateUtils.getNowDate());
        return standardCensorMapper.updateStandardCensor(standardCensor);
    }

    /**
     * 批量删除审查流程
     * 
     * @param processIds 需要删除的审查流程主键
     * @return 结果
     */
    @Override
    public int deleteStandardCensorByProcessIds(Long[] processIds)
    {
        return standardCensorMapper.deleteStandardCensorByProcessIds(processIds);
    }

    /**
     * 删除审查流程信息
     * 
     * @param processId 审查流程主键
     * @return 结果
     */
    @Override
    public int deleteStandardCensorByProcessId(Long processId)
    {
        return standardCensorMapper.deleteStandardCensorByProcessId(processId);
    }

    /**
     *
     * @param workflowId
     * @return
     */
    @Override
    public StandardCensor selectCensorProcessByWorkflowId(String workflowId) {

        return standardCensorMapper.selectCensorProcessByWorkflowId(workflowId);
    }

}
