package com.shahenpc.system.mapper.represent;

import com.shahenpc.system.domain.represent.RepresentMotion;

import java.util.List;

/**
 * 工作-建议议案处理Mapper接口
 * 
 * @author ruoyi
 * @date 2022-07-22
 */
public interface RepresentMotionMapper 
{
    /**
     * 查询工作-建议议案处理
     * 
     * @param motionId 工作-建议议案处理主键
     * @return 工作-建议议案处理
     */
    public RepresentMotion selectRepresentMotionByMotionId(Long motionId);

    /**
     * 查询工作-建议议案处理列表
     * 
     * @param representMotion 工作-建议议案处理
     * @return 工作-建议议案处理集合
     */
    public List<RepresentMotion> selectRepresentMotionList(RepresentMotion representMotion);

    /**
     * 新增工作-建议议案处理
     * 
     * @param representMotion 工作-建议议案处理
     * @return 结果
     */
    public int insertRepresentMotion(RepresentMotion representMotion);

    /**
     * 修改工作-建议议案处理
     * 
     * @param representMotion 工作-建议议案处理
     * @return 结果
     */
    public int updateRepresentMotion(RepresentMotion representMotion);

    /**
     * 删除工作-建议议案处理
     * 
     * @param motionId 工作-建议议案处理主键
     * @return 结果
     */
    public int deleteRepresentMotionByMotionId(Long motionId);

    /**
     * 批量删除工作-建议议案处理
     * 
     * @param motionIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteRepresentMotionByMotionIds(Long[] motionIds);

    /**
     *
     * @param workflowId
     * @return
     */
    public RepresentMotion selectByWorkflowId(String procinsId);

    public Integer getCount();
}
