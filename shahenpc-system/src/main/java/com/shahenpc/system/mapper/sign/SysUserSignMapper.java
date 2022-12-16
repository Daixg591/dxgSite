package com.shahenpc.system.mapper.sign;

import java.util.List;

import com.shahenpc.system.domain.represent.SignRankingDto;
import com.shahenpc.system.domain.represent.dto.DiscoverRankingDto;
import com.shahenpc.system.domain.represent.vo.SignTimeDto;
import com.shahenpc.system.domain.sign.SysUserSign;

/**
 * 代签到Mapper接口
 * 
 * @author ruoyi
 * @date 2022-11-17
 */
public interface SysUserSignMapper 
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
     * 删除代签到
     * 
     * @param signId 代签到主键
     * @return 结果
     */
    public int deleteSysUserSignBySignId(Long signId);

    /**
     * 批量删除代签到
     * 
     * @param signIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSysUserSignBySignIds(Long[] signIds);

    /**
     * 获取用户签到数据集
     * @param userId
     * @return
     */
    public List<Long> isTodaySign(Long userId);

    /**
     * 获取用户签到数据集
     * @param dto
     * @return
     */
    public List<SignRankingDto> selectByExportRanking(SignTimeDto dto);

    public List<SignRankingDto> selectTopRanking();
}
