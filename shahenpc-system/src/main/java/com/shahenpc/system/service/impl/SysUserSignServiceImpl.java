package com.shahenpc.system.service.impl;

import java.util.List;

import com.shahenpc.common.utils.DateUtils;
import com.shahenpc.system.domain.represent.SignRankingDto;
import com.shahenpc.system.domain.represent.dto.DiscoverRankingDto;
import com.shahenpc.system.domain.represent.vo.SignTimeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shahenpc.system.mapper.sign.SysUserSignMapper;
import com.shahenpc.system.domain.sign.SysUserSign;
import com.shahenpc.system.service.sign.ISysUserSignService;

/**
 * 代签到Service业务层处理
 *
 * @author ruoyi
 * @date 2022-11-17
 */
@Service
public class SysUserSignServiceImpl implements ISysUserSignService {
    @Autowired
    private SysUserSignMapper sysUserSignMapper;

    /**
     * 查询代签到
     *
     * @param signId 代签到主键
     * @return 代签到
     */
    @Override
    public SysUserSign selectSysUserSignBySignId(Long signId) {
        return sysUserSignMapper.selectSysUserSignBySignId(signId);
    }

    /**
     * 查询代签到列表
     *
     * @param sysUserSign 代签到
     * @return 代签到
     */
    @Override
    public List<SysUserSign> selectSysUserSignList(SysUserSign sysUserSign) {
        return sysUserSignMapper.selectSysUserSignList(sysUserSign);
    }

    /**
     * 新增代签到
     *
     * @param sysUserSign 代签到
     * @return 结果
     */
    @Override
    public int insertSysUserSign(SysUserSign sysUserSign) {
        sysUserSign.setCreateTime(DateUtils.getNowDate());
        return sysUserSignMapper.insertSysUserSign(sysUserSign);
    }

    /**
     * 修改代签到
     *
     * @param sysUserSign 代签到
     * @return 结果
     */
    @Override
    public int updateSysUserSign(SysUserSign sysUserSign) {
        sysUserSign.setUpdateTime(DateUtils.getNowDate());
        return sysUserSignMapper.updateSysUserSign(sysUserSign);
    }

    /**
     * 批量删除代签到
     *
     * @param signIds 需要删除的代签到主键
     * @return 结果
     */
    @Override
    public int deleteSysUserSignBySignIds(Long[] signIds) {
        return sysUserSignMapper.deleteSysUserSignBySignIds(signIds);
    }

    /**
     * 删除代签到信息
     *
     * @param signId 代签到主键
     * @return 结果
     */
    @Override
    public int deleteSysUserSignBySignId(Long signId) {
        return sysUserSignMapper.deleteSysUserSignBySignId(signId);
    }

    /**
     * 判断今天是否签到
     * @param userId
     * @return
     */
    @Override
    public boolean isTodaySign(Long userId) {
        return sysUserSignMapper.isTodaySign(userId).size() > 0;
    }

    /**
     * 导出签到排名
     * @return
     */
    @Override
    public  List<SignRankingDto> selectByExportRanking(SignTimeDto dto){
        return sysUserSignMapper.selectByExportRanking(dto);
    }

    /**
     * 签到排名前10条数据统计
     * @return
     */
    public List<SignRankingDto> selectTopRanking(){
        return sysUserSignMapper.selectTopRanking();
    }

}
