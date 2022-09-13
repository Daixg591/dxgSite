package com.shahenpc.system.service.represent.impl;

import java.util.List;
import com.shahenpc.common.utils.DateUtils;
import com.shahenpc.system.mapper.represent.RepresentMotionRecordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shahenpc.system.mapper.represent.RepresentMotionMapper;
import com.shahenpc.system.domain.represent.RepresentMotion;
import com.shahenpc.system.service.represent.IRepresentMotionService;

import javax.annotation.Resource;

/**
 * 工作-建议议案处理Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-07-22
 */
@Service
public class RepresentMotionServiceImpl implements IRepresentMotionService 
{
    @Autowired
    private RepresentMotionMapper representMotionMapper;

    /**
     * 查询工作-建议议案处理
     * 
     * @param motionId 工作-建议议案处理主键
     * @return 工作-建议议案处理
     */
    @Override
    public RepresentMotion selectRepresentMotionByMotionId(Long motionId)
    {
        return representMotionMapper.selectRepresentMotionByMotionId(motionId);
    }

    /**
     * 查询工作-建议议案处理列表
     * 
     * @param representMotion 工作-建议议案处理
     * @return 工作-建议议案处理
     */
    @Override
    public List<RepresentMotion> selectRepresentMotionList(RepresentMotion representMotion)
    {
        return representMotionMapper.selectRepresentMotionList(representMotion);
    }

    /**
     * 新增工作-建议议案处理
     * 
     * @param representMotion 工作-建议议案处理
     * @return 结果
     */
    @Override
    public int insertRepresentMotion(RepresentMotion representMotion)
    {
        representMotion.setCreateTime(DateUtils.getNowDate());
        return representMotionMapper.insertRepresentMotion(representMotion);
    }

    /**
     * 修改工作-建议议案处理
     * 
     * @param representMotion 工作-建议议案处理
     * @return 结果
     */
    @Override
    public int updateRepresentMotion(RepresentMotion representMotion)
    {
        representMotion.setUpdateTime(DateUtils.getNowDate());
        return representMotionMapper.updateRepresentMotion(representMotion);
    }

    @Autowired
    private RepresentMotionRecordMapper representMotionRecordMapper;
    /**
     * 批量删除工作-建议议案处理
     * 
     * @param motionIds 需要删除的工作-建议议案处理主键
     * @return 结果
     */
    @Override
    public int deleteRepresentMotionByMotionIds(Long[] motionIds)
    {
        if(representMotionMapper.deleteRepresentMotionByMotionIds(motionIds)>0){
            return representMotionRecordMapper.deleteRepresentMotionRecordByMotionIds(motionIds);
        }
        return 0;
    }

    /**
     * 删除工作-建议议案处理信息
     * 
     * @param motionId 工作-建议议案处理主键
     * @return 结果
     */
    @Override
    public int deleteRepresentMotionByMotionId(Long motionId)
    {
        return representMotionMapper.deleteRepresentMotionByMotionId(motionId);
    }

    /**
     *
     * @param
     * @return
     */
    @Override
    public RepresentMotion selectByWorkflowId(RepresentMotion representMotion) {

        return representMotionMapper.selectByWorkflowId(representMotion);
    }
}
