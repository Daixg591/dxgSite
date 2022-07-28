package com.shahenpc.system.service.represent;

import java.util.List;
import com.shahenpc.system.domain.represent.RepresentExperience;

/**
 * 代履职体会Service接口
 * 
 * @author ruoyi
 * @date 2022-07-26
 */
public interface IRepresentExperienceService 
{
    /**
     * 查询代履职体会
     * 
     * @param experienceId 代履职体会主键
     * @return 代履职体会
     */
    public RepresentExperience selectRepresentExperienceByExperienceId(Long experienceId);

    /**
     * 查询代履职体会列表
     * 
     * @param representExperience 代履职体会
     * @return 代履职体会集合
     */
    public List<RepresentExperience> selectRepresentExperienceList(RepresentExperience representExperience);

    /**
     * 新增代履职体会
     * 
     * @param representExperience 代履职体会
     * @return 结果
     */
    public int insertRepresentExperience(RepresentExperience representExperience);

    /**
     * 修改代履职体会
     * 
     * @param representExperience 代履职体会
     * @return 结果
     */
    public int updateRepresentExperience(RepresentExperience representExperience);

    /**
     * 批量删除代履职体会
     * 
     * @param experienceIds 需要删除的代履职体会主键集合
     * @return 结果
     */
    public int deleteRepresentExperienceByExperienceIds(Long[] experienceIds);

    /**
     * 删除代履职体会信息
     * 
     * @param experienceId 代履职体会主键
     * @return 结果
     */
    public int deleteRepresentExperienceByExperienceId(Long experienceId);
}
