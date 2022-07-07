package com.shahenpc.system.service.job.impl;

import java.util.List;
import com.shahenpc.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shahenpc.system.mapper.job.JobMotionMapper;
import com.shahenpc.system.domain.job.JobMotion;
import com.shahenpc.system.service.job.IJobMotionService;

/**
 * 工作-建议议案处理Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-07-06
 */
@Service
public class JobMotionServiceImpl implements IJobMotionService 
{
    @Autowired
    private JobMotionMapper jobMotionMapper;

    /**
     * 查询工作-建议议案处理
     * 
     * @param motionId 工作-建议议案处理主键
     * @return 工作-建议议案处理
     */
    @Override
    public JobMotion selectJobMotionByMotionId(Long motionId)
    {
        return jobMotionMapper.selectJobMotionByMotionId(motionId);
    }

    /**
     * 查询工作-建议议案处理列表
     * 
     * @param jobMotion 工作-建议议案处理
     * @return 工作-建议议案处理
     */
    @Override
    public List<JobMotion> selectJobMotionList(JobMotion jobMotion)
    {
        return jobMotionMapper.selectJobMotionList(jobMotion);
    }

    /**
     * 新增工作-建议议案处理
     * 
     * @param jobMotion 工作-建议议案处理
     * @return 结果
     */
    @Override
    public int insertJobMotion(JobMotion jobMotion)
    {
        jobMotion.setCreateTime(DateUtils.getNowDate());
        return jobMotionMapper.insertJobMotion(jobMotion);
    }

    /**
     * 修改工作-建议议案处理
     * 
     * @param jobMotion 工作-建议议案处理
     * @return 结果
     */
    @Override
    public int updateJobMotion(JobMotion jobMotion)
    {
        jobMotion.setUpdateTime(DateUtils.getNowDate());
        return jobMotionMapper.updateJobMotion(jobMotion);
    }

    /**
     * 批量删除工作-建议议案处理
     * 
     * @param motionIds 需要删除的工作-建议议案处理主键
     * @return 结果
     */
    @Override
    public int deleteJobMotionByMotionIds(Long[] motionIds)
    {
        return jobMotionMapper.deleteJobMotionByMotionIds(motionIds);
    }

    /**
     * 删除工作-建议议案处理信息
     * 
     * @param motionId 工作-建议议案处理主键
     * @return 结果
     */
    @Override
    public int deleteJobMotionByMotionId(Long motionId)
    {
        return jobMotionMapper.deleteJobMotionByMotionId(motionId);
    }

    @Override
    public JobMotion selectByWorkflowId(String workflowId) {

        return jobMotionMapper.selectByWorkflowId(workflowId);
    }
}
