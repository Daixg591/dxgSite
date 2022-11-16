package com.shahenpc.system.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.alibaba.fastjson2.JSON;
import com.shahenpc.common.core.domain.AjaxResult;
import com.shahenpc.common.utils.DateUtils;
import com.shahenpc.system.domain.oa.dto.MeetingUserIdListDto;
import com.shahenpc.system.domain.represent.dto.DiscoverUserIdDto;
import com.shahenpc.system.mapper.oa.OaMeetingMapper;
import com.shahenpc.system.mapper.oa.OaMeetingSignMapper;
import com.shahenpc.system.mapper.represent.RepresentDiscoverMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shahenpc.system.mapper.SysUserArchivesMapper;
import com.shahenpc.system.domain.SysUserArchives;
import com.shahenpc.system.service.ISysUserArchivesService;

/**
 * 代履职档案Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-10-21
 */
@Service
public class SysUserArchivesServiceImpl implements ISysUserArchivesService 
{
    @Autowired
    private SysUserArchivesMapper sysUserArchivesMapper;
    @Autowired
    private OaMeetingMapper oaMeetingMapper;
    @Autowired
    private RepresentDiscoverMapper representDiscoverMapper;
    @Autowired
    private OaMeetingSignMapper oaMeetingSignMapper;
    /**
     * 查询代履职档案
     * 
     * @param archivesId 代履职档案主键
     * @return 代履职档案
     */
    @Override
    public SysUserArchives selectSysUserArchivesByArchivesId(Long archivesId)
    {
        return sysUserArchivesMapper.selectSysUserArchivesByArchivesId(archivesId);
    }

    @Override
    public SysUserArchives selectSysUserArchivesByUserId(Long userId) {
        SysUserArchives archiv =  sysUserArchivesMapper.selectSysUserArchivesByUserId(userId);
        if(archiv == null){
            SysUserArchives archiv1 = new SysUserArchives();
            archiv1.setUserId(userId);
            archiv1.setCreateTime(DateUtils.getNowDate());
            List<MeetingUserIdListDto> meetingDto=oaMeetingSignMapper.selectByUserId(userId);
            List<DiscoverUserIdDto> discover=representDiscoverMapper.selectByReceiveUserId(userId);
//            archiv1.setAttend(JSON.toJSONString(meetingDto));
//            archiv1.setFind(JSON.toJSONString(discover));
            if(sysUserArchivesMapper.insertSysUserArchives(archiv1)> 0 ){
                SysUserArchives arc= sysUserArchivesMapper.selectSysUserArchivesByUserId(userId);
                arc.setMeetingDto(meetingDto);
                arc.setDiscoverDto(discover);
                return arc;
            }
        }
        List<MeetingUserIdListDto> meetingDto=oaMeetingSignMapper.selectByUserId(userId);
        List<DiscoverUserIdDto> discover=representDiscoverMapper.selectByReceiveUserId(userId);
        archiv.setMeetingDto(meetingDto);
        archiv.setDiscoverDto(discover);
        return archiv;
    }

    /**
     * 查询代履职档案列表
     * 
     * @param sysUserArchives 代履职档案
     * @return 代履职档案
     */
    @Override
    public List<SysUserArchives> selectSysUserArchivesList(SysUserArchives sysUserArchives)
    {
        return sysUserArchivesMapper.selectSysUserArchivesList(sysUserArchives);
    }

    /**
     * 新增代履职档案
     * 
     * @param sysUserArchives 代履职档案
     * @return 结果
     */
    @Override
    public int insertSysUserArchives(SysUserArchives sysUserArchives)
    {
        sysUserArchives.setCreateTime(DateUtils.getNowDate());
        return sysUserArchivesMapper.insertSysUserArchives(sysUserArchives);
    }

    /**
     * 修改代履职档案
     * 
     * @param sysUserArchives 代履职档案
     * @return 结果
     */
    @Override
    public int updateSysUserArchives(SysUserArchives sysUserArchives)
    {
        sysUserArchives.setUpdateTime(DateUtils.getNowDate());
        return sysUserArchivesMapper.updateSysUserArchives(sysUserArchives);
    }

    /**
     * 批量删除代履职档案
     * 
     * @param archivesIds 需要删除的代履职档案主键
     * @return 结果
     */
    @Override
    public int deleteSysUserArchivesByArchivesIds(Long[] archivesIds)
    {
        return sysUserArchivesMapper.deleteSysUserArchivesByArchivesIds(archivesIds);
    }

    /**
     * 删除代履职档案信息
     * 
     * @param archivesId 代履职档案主键
     * @return 结果
     */
    @Override
    public int deleteSysUserArchivesByArchivesId(Long archivesId)
    {
        return sysUserArchivesMapper.deleteSysUserArchivesByArchivesId(archivesId);
    }
}
