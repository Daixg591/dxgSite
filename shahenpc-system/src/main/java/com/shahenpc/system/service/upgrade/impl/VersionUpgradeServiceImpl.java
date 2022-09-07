package com.shahenpc.system.service.upgrade.impl;

import com.shahenpc.common.utils.DateUtils;
import com.shahenpc.system.domain.upgrade.VersionUpgrade;
import com.shahenpc.system.mapper.upgrade.VersionUpgradeMapper;
import com.shahenpc.system.service.upgrade.IVersionUpgradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 【请填写功能名称】Service业务层处理
 *
 * @author ruoyi
 * @date 2022-06-22
 */
@Service
public class VersionUpgradeServiceImpl implements IVersionUpgradeService
{
    @Autowired
    private VersionUpgradeMapper versionUpgradeMapper;

    /**
     * 查询【请填写功能名称】
     *
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public VersionUpgrade selectVersionUpgradeById(Long id)
    {
        return versionUpgradeMapper.selectVersionUpgradeById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     *
     * @param versionUpgrade 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<VersionUpgrade> selectVersionUpgradeList(VersionUpgrade versionUpgrade)
    {
        return versionUpgradeMapper.selectVersionUpgradeList(versionUpgrade);
    }

    /**
     * 新增【请填写功能名称】
     *
     * @param versionUpgrade 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertVersionUpgrade(VersionUpgrade versionUpgrade)
    {
        versionUpgrade.setCreateTime(DateUtils.getNowDate());
        return versionUpgradeMapper.insertVersionUpgrade(versionUpgrade);
    }

    /**
     * 修改【请填写功能名称】
     *
     * @param versionUpgrade 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateVersionUpgrade(VersionUpgrade versionUpgrade)
    {
        versionUpgrade.setUpdateTime(DateUtils.getNowDate());
        return versionUpgradeMapper.updateVersionUpgrade(versionUpgrade);
    }

    /**
     * 批量删除【请填写功能名称】
     *
     * @param ids 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteVersionUpgradeByIds(Integer[] ids)
    {
        return versionUpgradeMapper.deleteVersionUpgradeByIds(ids);
    }

    /**
     * 删除【请填写功能名称】信息
     *
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteVersionUpgradeById(Long id)
    {
        return versionUpgradeMapper.deleteVersionUpgradeById(id);
    }


    @Override
    public VersionUpgrade getAppType(Integer appType) {
        return versionUpgradeMapper.getAppType(appType);
    }
}
