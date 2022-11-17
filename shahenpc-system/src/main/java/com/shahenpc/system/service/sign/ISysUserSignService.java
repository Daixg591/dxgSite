package com.shahenpc.system.service.sign;

import java.util.List;
import com.shahenpc.system.domain.sign.SysUserSign;

/**
 * 代签到Service接口
 * 
 * @author ruoyi
 * @date 2022-11-17
 */
public interface ISysUserSignService 
{
    /**
     * 查询代签到
     * 
     * @param signId 代签到主键
     * @return 代签到
     */
    public SysUserSign selectSysUserSignBySignId(Long signId);

    /**
     * 查询代签到列表
     * 
     * @param sysUserSign 代签到
     * @return 代签到集合
     */
    public List<SysUserSign> selectSysUserSignList(SysUserSign sysUserSign);

    /**
     * 新增代签到
     * 
     * @param sysUserSign 代签到
     * @return 结果
     */
    public int insertSysUserSign(SysUserSign sysUserSign);

    /**
     * 修改代签到
     * 
     * @param sysUserSign 代签到
     * @return 结果
     */
    public int updateSysUserSign(SysUserSign sysUserSign);

    /**
     * 批量删除代签到
     * 
     * @param signIds 需要删除的代签到主键集合
     * @return 结果
     */
    public int deleteSysUserSignBySignIds(Long[] signIds);

    /**
     * 删除代签到信息
     * 
     * @param signId 代签到主键
     * @return 结果
     */
    public int deleteSysUserSignBySignId(Long signId);

    public boolean isTodaySign(Long userId);
}
