package com.shahenpc.system.mapper.represent;

import java.util.List;
import com.shahenpc.system.domain.represent.JobMotion;

/**
 * 工作-建议议案处理Mapper接口
 *
 * @author ruoyi
 * @date 2022-07-06
 */
public interface JobMotionMapper
{
    /**
     * 查询工作-建议议案处理
     *
     * @param motionId 工作-建议议案处理主键
     * @return 工作-建议议案处理
     */
    public JobMotion selectJobMotionByMotionId(Long motionId);

    /**
     * 查询工作-建议议案处理列表
     *
     * @param jobMotion 工作-建议议案处理
     * @return 工作-建议议案处理集合
     */
    public List<JobMotion> selectJobMotionList(JobMotion jobMotion);

    /**
     * 新增工作-建议议案处理
     *
     * @param jobMotion 工作-建议议案处理
     * @return 结果
     */
    public int insertJobMotion(JobMotion jobMotion);

    /**
     * 修改工作-建议议案处理
     *
     * @param jobMotion 工作-建议议案处理
     * @return 结果
     */
    public int updateJobMotion(JobMotion jobMotion);

    /**
     * 删除工作-建议议案处理
     *
     * @param motionId 工作-建议议案处理主键
     * @return 结果
     */
    public int deleteJobMotionByMotionId(Long motionId);

    /**
     * 批量删除工作-建议议案处理
     *
     * @param motionIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteJobMotionByMotionIds(Long[] motionIds);

    public JobMotion selectByWorkflowId(String workflowId);
}
