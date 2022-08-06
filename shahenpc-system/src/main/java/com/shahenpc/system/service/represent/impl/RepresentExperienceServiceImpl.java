package com.shahenpc.system.service.represent.impl;

import java.util.List;
import com.shahenpc.common.utils.DateUtils;
import com.shahenpc.system.domain.represent.RepresentWorkLog;
import com.shahenpc.system.service.represent.IRepresentWorkLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shahenpc.system.mapper.represent.RepresentExperienceMapper;
import com.shahenpc.system.domain.represent.RepresentExperience;
import com.shahenpc.system.service.represent.IRepresentExperienceService;

/**
 * 代履职体会Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-07-26
 */
@Service
public class RepresentExperienceServiceImpl implements IRepresentExperienceService 
{
    @Autowired
    private RepresentExperienceMapper representExperienceMapper;

    /**
     * 查询代履职体会
     * 
     * @param experienceId 代履职体会主键
     * @return 代履职体会
     */
    @Override
    public RepresentExperience selectRepresentExperienceByExperienceId(Long experienceId)
    {
        return representExperienceMapper.selectRepresentExperienceByExperienceId(experienceId);
    }

    /**
     * 查询代履职体会列表
     * 
     * @param representExperience 代履职体会
     * @return 代履职体会
     */
    @Override
    public List<RepresentExperience> selectRepresentExperienceList(RepresentExperience representExperience)
    {
        return representExperienceMapper.selectRepresentExperienceList(representExperience);
    }

    /**
     * 新增代履职体会
     * 
     * @param representExperience 代履职体会
     * @return 结果
     */
    @Autowired
    private IRepresentWorkLogService representWorkLogService;

    @Override
    public int insertRepresentExperience(RepresentExperience representExperience)
    {representExperience.setCreateTime(DateUtils.getNowDate());
       int aa  =   representExperienceMapper.insertRepresentExperience(representExperience);
        RepresentWorkLog log = new RepresentWorkLog();
        log.setEventType(2);
        log.setEventId(representExperience.getExperienceId());
        log.setUserId(representExperience.getUserId());
        log.setRemark("履职体会！");
        representWorkLogService.insertRepresentWorkLog(log);
        return aa;
    }

    /**
     * 修改代履职体会
     * 
     * @param representExperience 代履职体会
     * @return 结果
     */
    @Override
    public int updateRepresentExperience(RepresentExperience representExperience)
    {
        representExperience.setUpdateTime(DateUtils.getNowDate());
        return representExperienceMapper.updateRepresentExperience(representExperience);
    }

    /**
     * 批量删除代履职体会
     * 
     * @param experienceIds 需要删除的代履职体会主键
     * @return 结果
     */
    @Override
    public int deleteRepresentExperienceByExperienceIds(Long[] experienceIds)
    {
        return representExperienceMapper.deleteRepresentExperienceByExperienceIds(experienceIds);
    }

    /**
     * 删除代履职体会信息
     * 
     * @param experienceId 代履职体会主键
     * @return 结果
     */
    @Override
    public int deleteRepresentExperienceByExperienceId(Long experienceId)
    {
        return representExperienceMapper.deleteRepresentExperienceByExperienceId(experienceId);
    }
}
