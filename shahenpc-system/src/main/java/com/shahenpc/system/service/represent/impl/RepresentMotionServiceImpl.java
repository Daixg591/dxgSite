package com.shahenpc.system.service.represent.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.shahenpc.common.core.domain.entity.SysDictData;
import com.shahenpc.common.utils.DateUtils;
import com.shahenpc.system.domain.represent.dto.MotionPieDto;
import com.shahenpc.system.domain.represent.vo.MotionTaskVo;
import com.shahenpc.system.service.ISysDictTypeService;
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
    @Resource
    private ISysDictTypeService dictTypeService;
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

    /**
     * 批量删除工作-建议议案处理
     * 
     * @param motionIds 需要删除的工作-建议议案处理主键
     * @return 结果
     */
    @Override
    public int deleteRepresentMotionByMotionIds(Long[] motionIds)
    {
        return representMotionMapper.deleteRepresentMotionByMotionIds(motionIds);
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
     * @param representMotion
     * @return
     */
    @Override
    public RepresentMotion selectByWorkflowId(RepresentMotion representMotion) {

        return representMotionMapper.selectByWorkflowId(representMotion);
    }

    @Override
    public List<MotionPieDto> typePie(MotionTaskVo vo) {
        List<MotionPieDto> dto = new ArrayList<>();
        List<SysDictData> dictList = dictTypeService.selectDictDataByType("motion_type");
        RepresentMotion moting = new RepresentMotion();
        List<RepresentMotion> receiveTotal =representMotionMapper.selectRepresentMotionList(moting);
        for (int i = 0; i < dictList.size(); i++) {
            int finalI = i;
            int v = receiveTotal.stream().filter(p -> dictList.get(finalI).getDictValue().equals(p.getMotionType().toString()))
                    .collect(Collectors.toList()).size();
            MotionPieDto item = new MotionPieDto();
            item.setName(dictList.get(i).getDictLabel());
            item.setValue(v);
            dto.add(item);
        }
        return dto;
    }
}
