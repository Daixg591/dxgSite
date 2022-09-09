package com.shahenpc.system.mapper.upgrade;

import com.shahenpc.system.domain.upgrade.VersionUpgrade;

import java.util.List;


/**
 * 【请填写功能名称】Mapper接口
 *
 * @author ruoyi
 * @date 2022-06-22
 */
public interface VersionUpgradeMapper {
    /**
     * 查询【请填写功能名称】
     *
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public VersionUpgrade selectVersionUpgradeById(Long id);

    /**
     * 查询【请填写功能名称】列表
     *
     * @param versionUpgrade 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<VersionUpgrade> selectVersionUpgradeList(VersionUpgrade versionUpgrade);

    /**
     * 新增【请填写功能名称】
     *
     * @param versionUpgrade 【请填写功能名称】
     * @return 结果
     */
    public int insertVersionUpgrade(VersionUpgrade versionUpgrade);

    /**
     * 修改【请填写功能名称】
     *
     * @param versionUpgrade 【请填写功能名称】
     * @return 结果
     */
    public int updateVersionUpgrade(VersionUpgrade versionUpgrade);

    /**
     * 删除【请填写功能名称】
     *
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteVersionUpgradeById(Long id);

    /**
     * 批量删除【请填写功能名称】
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteVersionUpgradeByIds(Integer[] ids);

    public VersionUpgrade getAppType(Integer appType);
}
