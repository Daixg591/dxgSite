package com.shahenpc.system.mapper;

import java.util.List;
import com.shahenpc.system.domain.SysUserArchives;

/**
 * 代履职档案Mapper接口
 * 
 * @author ruoyi
 * @date 2022-10-21
 */
public interface SysUserArchivesMapper 
{
    /**
     * 查询代履职档案
     * 
     * @param archivesId 代履职档案主键
     * @return 代履职档案
     */
    public SysUserArchives selectSysUserArchivesByArchivesId(Long archivesId);


    public SysUserArchives selectSysUserArchivesByUserId(Long archivesId);
    /**
     * 查询代履职档案列表
     * 
     * @param sysUserArchives 代履职档案
     * @return 代履职档案集合
     */
    public List<SysUserArchives> selectSysUserArchivesList(SysUserArchives sysUserArchives);

    /**
     * 新增代履职档案
     * 
     * @param sysUserArchives 代履职档案
     * @return 结果
     */
    public int insertSysUserArchives(SysUserArchives sysUserArchives);

    /**
     * 修改代履职档案
     * 
     * @param sysUserArchives 代履职档案
     * @return 结果
     */
    public int updateSysUserArchives(SysUserArchives sysUserArchives);

    /**
     * 删除代履职档案
     * 
     * @param archivesId 代履职档案主键
     * @return 结果
     */
    public int deleteSysUserArchivesByArchivesId(Long archivesId);

    /**
     * 批量删除代履职档案
     * 
     * @param archivesIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSysUserArchivesByArchivesIds(Long[] archivesIds);
}
