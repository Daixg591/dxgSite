package com.shahenpc.system.service.standard.impl;

import com.shahenpc.common.core.domain.entity.SysDictData;
import com.shahenpc.common.utils.DateUtils;
import com.shahenpc.system.domain.represent.RepresentMotion;
import com.shahenpc.system.domain.represent.dto.MotionPieDto;
import com.shahenpc.system.domain.represent.vo.MotionTaskVo;
import com.shahenpc.system.domain.standard.StandardCensor;
import com.shahenpc.system.mapper.standard.StandardCensorMapper;
import com.shahenpc.system.service.ISysDictTypeService;
import com.shahenpc.system.service.standard.IStandardCensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
    @Resource
    private ISysDictTypeService dictTypeService;
    /**
     * 查询审查流程
     * 
     * @param processId 审查流程主键
     * @return 审查流程
     */
    @Override
    public StandardCensor selectStandardCensorByProcessId(Long processId)
    {
        return standardCensorMapper.selectStandardCensorByCensorId(processId);
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
        return standardCensorMapper.deleteStandardCensorByCensorIds(processIds);
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
        return standardCensorMapper.deleteStandardCensorByCensorId(processId);
    }

    @Override
    public StandardCensor selectByProcessId(String processId) {

        return standardCensorMapper.selectByProcessId(processId);
    }


    @Override
    public List<MotionPieDto> typePie(MotionTaskVo vo) {
        List<MotionPieDto> dto = new ArrayList<>();
        List<SysDictData> dictList = dictTypeService.selectDictDataByType("censor_file_type");
        StandardCensor standardCenso = new StandardCensor();
        List<StandardCensor> receiveTotal =standardCensorMapper.selectStandardCensorList(standardCenso);
        for (int i = 0; i < dictList.size(); i++) {
            int finalI = i;
            int v = receiveTotal.stream().filter(p -> dictList.get(finalI).getDictValue().equals(p.getFileType().toString()))
                    .collect(Collectors.toList()).size();
            MotionPieDto item = new MotionPieDto();
            item.setName(dictList.get(i).getDictLabel());
            item.setValue(v);
            dto.add(item);
        }
        return dto;
    }


}
