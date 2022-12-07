package com.shahenpc.system.service.represent.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.annotation.TableName;
import com.shahenpc.common.constant.Constants;
import com.shahenpc.common.core.controller.BaseController;
import com.shahenpc.common.core.domain.AjaxResult;
import com.shahenpc.common.core.domain.entity.SysDictData;
import com.shahenpc.common.core.domain.entity.SysUser;
import com.shahenpc.common.utils.DateUtils;
import com.shahenpc.system.domain.feature.FeatureDoubleWork;
import com.shahenpc.system.domain.feature.dto.FeatureCakeDto;
import com.shahenpc.system.domain.feature.dto.FeatureLineDto;
import com.shahenpc.system.domain.represent.RepresentDiscoverTrack;
import com.shahenpc.system.domain.represent.RepresentHomeAccess;
import com.shahenpc.system.domain.represent.RepresentWorkLog;
import com.shahenpc.system.domain.represent.dto.*;
import com.shahenpc.system.domain.represent.vo.DiscoverFallbackVo;
import com.shahenpc.system.domain.represent.vo.DiscoverUpdateVo;
import com.shahenpc.system.mapper.SysUserMapper;
import com.shahenpc.system.mapper.represent.RepresentDiscoverTrackMapper;
import com.shahenpc.system.mapper.represent.RepresentHomeAccessMapper;
import com.shahenpc.system.service.ISysDictDataService;
import com.shahenpc.system.service.ISysDictTypeService;
import com.shahenpc.system.service.represent.IRepresentWorkLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shahenpc.system.mapper.represent.RepresentDiscoverMapper;
import com.shahenpc.system.domain.represent.RepresentDiscover;
import com.shahenpc.system.service.represent.IRepresentDiscoverService;
import org.springframework.transaction.annotation.Transactional;

/**
 * 代-代发现Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-07-28
 */
@Service
public class RepresentDiscoverServiceImpl extends BaseController implements IRepresentDiscoverService
{
    @Autowired
    private RepresentDiscoverMapper representDiscoverMapper;
    @Autowired
    private RepresentDiscoverTrackMapper representDiscoverTrackMapper;
    @Autowired
    private IRepresentWorkLogService representWorkLogService;
    @Autowired
    private SysUserMapper sysUserMapper;
    @Autowired
    private RepresentHomeAccessMapper representHomeAccessMapper;


    /**
     * 查询代-代发现
     * @param discoverId 代-代发现主键
     * @return 代-代发现
     */
    @Override
    public RepresentDiscover selectRepresentDiscoverByDiscoverId(Long discoverId)
    {
        return representDiscoverMapper.selectRepresentDiscoverByDiscoverId(discoverId);
    }

    /**
     * 查询代-代发现列表
     * 
     * @param representDiscover 代-代发现
     * @return 代-代发现
     */
    @Override
    public List<RepresentDiscover> selectRepresentDiscoverList(RepresentDiscover representDiscover)
    {
        return representDiscoverMapper.selectRepresentDiscoverList(representDiscover);
    }


    /**
     * 新增代-代发现
     * 
     * @param representDiscover 代-代发现
     * @return 结果
     */
    @Override
    @Transactional
    public AjaxResult insertRepresentDiscover(RepresentDiscover representDiscover)
    {
        representDiscover.setCreateTime(DateUtils.getNowDate());
        SysUser user=sysUserMapper.selectUserById(representDiscover.getSendUserId());
        RepresentHomeAccess access= representHomeAccessMapper.selectRepresentHomeAccessByAccessId(user.getContactStationId());
        if(access.getUserId() != null){
            representDiscover.setReceiveUserId(access.getUserId());
            representDiscover.setStationId(access.getAccessId());
        }else{
            return AjaxResult.error("联络站未添加负责人");
        }
        if(representDiscoverMapper.insertRepresentDiscover(representDiscover) > 0){
            RepresentWorkLog log = new RepresentWorkLog();
            log.setEventType(4);
            log.setEventId(representDiscover.getDiscoverId());
            log.setUserId(representDiscover.getSendUserId());
            log.setRemark("代表发现！");
            if(representWorkLogService.insertRepresentWorkLog(log) < 0){
                return AjaxResult.error("添加代表发现日志失败！");
            }
            RepresentDiscoverTrack track = new RepresentDiscoverTrack();
            track.setSendUserId(representDiscover.getSendUserId());
            track.setReceiveUserId(representDiscover.getReceiveUserId());
            track.setCreateTime(DateUtils.getNowDate());
            track.setDiscoverId(representDiscover.getDiscoverId());
            track.setStatus(representDiscover.getStatus());
           if(representDiscoverTrackMapper.insertRepresentDiscoverTrack(track)<0){
               return AjaxResult.error("添加代表发现记录失败！");
           }
           return AjaxResult.success();
        }
        return AjaxResult.error();
    }

    /**
     * 修改代-代发现
     * 
     * @param representDiscover 代-代发现
     * @return 结果
     */
    @Override
    @Transactional
    public AjaxResult updateRepresentDiscover(DiscoverUpdateVo representDiscover)
    {

        if(representDiscover.getStatus().equals(Constants.DISCOVER_STATUS_2)){
            //流程类型转换
            if(representDiscover.getProcessType().equals(Constants.DISCOVER_PROCESS_TYPE_1)){
                representDiscover.setProcessType(Constants.DISCOVER_PROCESS_TYPE_2);
                //获取总站userId
                RepresentHomeAccess access=representHomeAccessMapper.selectByLevel();
                if(access.getUserId() == null){
                    return AjaxResult.error("总驿站，未添加负责人！");
                }
                representDiscover.setReceiveUserId(access.getUserId());
            }else if(representDiscover.getProcessType().equals(Constants.DISCOVER_PROCESS_TYPE_2)){
                representDiscover.setProcessType(Constants.DISCOVER_PROCESS_TYPE_3);
                //移交给第三方 部门
                //需要测试
            }
            representDiscover.setUpdateTime(DateUtils.getNowDate());
            //转交， 这一条还是待处理  记录上是已转交
            representDiscover.setStatus(Constants.DISCOVER_STATUS_1);
            if(representDiscoverMapper.updateRepresentDiscover(representDiscover) <= 0 ){
                return AjaxResult.error("记录修改失败！");
            }
            //查原来的 记录的id
            RepresentDiscoverTrack trcl=representDiscoverTrackMapper.selectBySendUserId(representDiscover.getUserId(),representDiscover.getDiscoverId());
            if(trcl == null){
                return AjaxResult.error("流程记录，修改原来状态");
            }
            RepresentDiscoverTrack representDiscoverTrack = new RepresentDiscoverTrack();
            representDiscoverTrack.setStatus(Constants.DISCOVER_STATUS_2);
            representDiscoverTrack.setTrackId(trcl.getTrackId());
            if(representDiscoverTrackMapper.updateRepresentDiscoverTrack(representDiscoverTrack)<=0){
                return AjaxResult.error("流程记录，修改原来状态");
            }
            RepresentDiscoverTrack track = new RepresentDiscoverTrack();
            //转交
            track.setCreateBy(representDiscover.getUpdateBy());
            track.setSendUserId(representDiscover.getUserId());
            track.setProcessType(representDiscover.getProcessType());
            track.setReceiveUserId(representDiscover.getReceiveUserId());
            track.setRevert(representDiscover.getRevert());
            track.setCreateTime(DateUtils.getNowDate());
            track.setDiscoverId(representDiscover.getDiscoverId());
            track.setPicUrls(representDiscover.getTrackPicUrls());
            if(representDiscoverTrackMapper.insertRepresentDiscoverTrack(track) <= 0){
                return AjaxResult.error("记录添加失败！");
            }
            return AjaxResult.success();
        }else{
            RepresentDiscover dis = new RepresentDiscover();
            dis.setStatus(representDiscover.getStatus());
            dis.setDiscoverId(representDiscover.getDiscoverId());
            //办结流程。。发起流程修改状态   记录表新增一条 谁办结
            if(representDiscoverMapper.updateRepresentDiscover(representDiscover) <= 0 ){
                return AjaxResult.error("记录修改失败！");
            }
            //查原来的 记录的id
            RepresentDiscoverTrack trcl=representDiscoverTrackMapper.selectBySendUserId(representDiscover.getUserId(),representDiscover.getDiscoverId());
            if(trcl == null){
                return AjaxResult.error("流程记录，修改原来状态");
            }
            RepresentDiscoverTrack representDiscoverTrack = new RepresentDiscoverTrack();
            representDiscoverTrack.setStatus(Constants.DISCOVER_STATUS_2);
            representDiscoverTrack.setTrackId(trcl.getTrackId());
            if(representDiscoverTrackMapper.updateRepresentDiscoverTrack(representDiscoverTrack)<=0){
                return AjaxResult.error("流程记录，修改原来状态");
            }
            RepresentDiscoverTrack track = new RepresentDiscoverTrack();
            track.setSendUserId(representDiscover.getReceiveUserId());
            track.setDiscoverId(representDiscover.getDiscoverId());
            track.setStatus(Constants.DISCOVER_STATUS_3);
            track.setReceiveUserId(representDiscover.getReceiveUserId());
            track.setRevert(representDiscover.getRevert());
            track.setStatus(representDiscover.getStatus());
            track.setProcessType(representDiscover.getProcessType());
            track.setCreateBy(representDiscover.getUpdateBy());
            track.setCreateTime(DateUtils.getNowDate());
            track.setPicUrls(representDiscover.getTrackPicUrls());
            if(representDiscoverTrackMapper.insertRepresentDiscoverTrack(track) <= 0){
                return AjaxResult.error("记录添加失败！");
            }
            return AjaxResult.success();
        }
    }

    /**
     * 批量删除代-代发现
     * 
     * @param discoverIds 需要删除的代-代发现主键
     * @return 结果
     */
    @Override
    public int deleteRepresentDiscoverByDiscoverIds(Long[] discoverIds)
    {
        if(representDiscoverMapper.deleteRepresentDiscoverByDiscoverIds(discoverIds) > 0){
            return representDiscoverTrackMapper.deleteRepresentDiscoverTrackByDiscoverIds(discoverIds);
        }
        return 0;
    }

    /**
     * 删除代-代发现信息
     * 
     * @param discoverId 代-代发现主键
     * @return 结果
     */
    @Override
    public int deleteRepresentDiscoverByDiscoverId(Long discoverId)
    {
        return representDiscoverMapper.deleteRepresentDiscoverByDiscoverId(discoverId);
    }

    @Override
    public List<DiscoverAppListDto> doneList(Long sendUserId) {
        return representDiscoverMapper.doneList(sendUserId);
    }

    @Override
    public List<DiscoverAppListDto> todoList(RepresentDiscover representDiscover) {
        return representDiscoverMapper.todoList(representDiscover);
    }

    @Override
    public List<DiscoverAppListDto> appList(RepresentDiscover representDiscover) {
        return representDiscoverMapper.appList(representDiscover);
    }

    @Override
    public DiscoverAppDetailDto appDetail(Long discoverId) {
        return representDiscoverMapper.appDetail(discoverId);
    }

    @Override
    public List<DiscoverListDto> adminList(RepresentDiscover representDiscover) {
        return representDiscoverMapper.adminList(representDiscover);
    }

    @Override
    public DiscoverDetailDto detail(Long discoverId) {
        return representDiscoverMapper.detail(discoverId);
    }


    @Override
    public DiscoverRingDto ring() {
        return representDiscoverMapper.selectByRate();
    }

    @Override
    public DiscoverLineDto line() {
        List<String> monthList = getNearSixMonth();
        DiscoverLineDto res = new DiscoverLineDto();
        res.setLabel(monthList);
        List<Integer> yList = new ArrayList<>();
        FeatureDoubleWork work = new FeatureDoubleWork();
        List<RepresentDiscover>  list=representDiscoverMapper.selectRepresentDiscoverList(null);
        for (int i = 0; i < monthList.size(); i++) {
            int finalI = i;
            String cntt = monthList.get(finalI);
            List<RepresentDiscover> nearlist1 = list.stream().
                    filter(w -> DateUtils.dateTime(w.getCreateTime()).contains(cntt)).collect(Collectors.toList());
            yList.add(nearlist1.size());
        }
        res.setData(yList);
        Collections.reverse(res.getData());
        Collections.reverse(res.getLabel());
        return res;
    }

    /**
     * 获取最近六个月份  ["2022-07","2022-06","2022-05"...]
     *
     * @return
     */
    public List<String> getNearSixMonth() {
        List<String> resultList = new ArrayList<String>();
        Calendar cal = Calendar.getInstance();
        //近六个月
        //要先+1,才能把本月的算进去
        cal.set(Calendar.MONTH, cal.get(Calendar.MONTH) + 1);
        for (int i = 0; i < 6; i++) {
            //逐次往前推1个月
            cal.set(Calendar.MONTH, cal.get(Calendar.MONTH) - 1);
            resultList.add(String.valueOf(cal.get(Calendar.YEAR))
                    + "-" + (cal.get(Calendar.MONTH) + 1 < 10 ? "0" +
                    (cal.get(Calendar.MONTH) + 1) : (cal.get(Calendar.MONTH) + 1)));
        }
        return resultList;
    }

    @Override
    public List<DiscoverPieDto> statusPie() {
        List<DiscoverPieDto> dtoList = new ArrayList<>();
        List<RepresentDiscover> alarBudg=representDiscoverMapper.selectRepresentDiscoverList(null);
        List<SysDictData> dictList = sysDictTypeService.selectDictDataByType("discover_status");
        for (int i = 0; i < dictList.size(); i++) {
            int finalI = i;
            int v = alarBudg.stream().filter(p -> dictList.get(finalI).getDictValue().equals(p.getDiscoverType().toString()))
                    .collect(Collectors.toList()).size();
            DiscoverPieDto item = new DiscoverPieDto();
            item.setName(dictList.get(i).getDictLabel());
            item.setValue(v);
            dtoList.add(item);
        }
        return dtoList;
    }

    @Override
    public List<DiscoverPieDto> pie() {
        List<DiscoverPieDto> dtoList = new ArrayList<>();
        List<RepresentDiscover> alarBudg=representDiscoverMapper.selectRepresentDiscoverList(null);
        List<SysDictData> dictList = sysDictTypeService.selectDictDataByType("discover_type");
        for (int i = 0; i < dictList.size(); i++) {
            int finalI = i;
            int v = alarBudg.stream().filter(p -> dictList.get(finalI).getDictValue().equals(p.getDiscoverType().toString()))
                    .collect(Collectors.toList()).size();
            DiscoverPieDto item = new DiscoverPieDto();
            item.setName(dictList.get(i).getDictLabel());
            item.setValue(v);
            dtoList.add(item);
        }
        return dtoList;
    }

    @Override
    public List<DiscoverPieDto> statusCount() {
        List<DiscoverPieDto> dtoList = new ArrayList<>();
        List<RepresentDiscover> alarBudg=representDiscoverMapper.selectRepresentDiscoverList(null);
        List<SysDictData> dictList = sysDictTypeService.selectDictDataByType("discover_status");
        dictList =  dictList.stream().filter(w -> !w.getDictValue().equals("5")).collect(Collectors.toList());
        for (int i = 0; i < dictList.size(); i++) {
            int finalI = i;
            List<SysDictData> finalDictList = dictList;
            int v = alarBudg.stream().filter(p -> finalDictList.get(finalI).getDictValue().equals(p.getDiscoverType().toString()))
                    .collect(Collectors.toList()).size();
            DiscoverPieDto item = new DiscoverPieDto();
            item.setName(dictList.get(i).getDictLabel());
            item.setValue(v);
            dtoList.add(item);
        }
        return dtoList;
    }

    @Override
    public DiscoverStatusCountDto selectByStatusCount() {
        return representDiscoverMapper.selectByStatusCount();
    }

    @Autowired
    private ISysDictTypeService sysDictTypeService;

    @Override
    public List<DiscoverPieDto> funnel() {
        List<DiscoverPieDto> dtoList = new ArrayList<>();
        List<RepresentDiscoverTrack> alarBudg=representDiscoverTrackMapper.selectRepresentDiscoverTrackList(null);
        List<SysDictData> dictList=sysDictTypeService.selectDictDataByType("discover_process_type");
        dictList =  dictList.stream().filter(w -> !w.getDictValue().equals("5")).collect(Collectors.toList());
        for (int i = 0; i < dictList.size(); i++) {
            int finalI = i;
            List<SysDictData> finalDictList = dictList;
            int v = alarBudg.stream().filter(p -> finalDictList.get(finalI).getDictValue().equals(p.getStatus().toString()))
                    .collect(Collectors.toList()).size();
            DiscoverPieDto item = new DiscoverPieDto();
            /*if(dictList.get(i).getDictLabel().equals("待交办")){
                item.setName("上传");
                item.setValue(v);
            }
            if(dictList.get(i).getDictLabel().equals("待解决")){
                item.setName("已交办");
                item.setValue(v);
            }
            if(dictList.get(i).getDictLabel().equals("待评价")){
                item.setName("已解决");
                item.setValue(v);
            }
            if(dictList.get(i).getDictLabel().equals("已评价")){
                item.setName("已评价");
                item.setValue(v);
            }*/
//            item.setName(dictList.get(i).getDictLabel());
//            item.setValue(v);
            item.setName(dictList.get(i).getDictLabel());
            item.setValue(v);
            dtoList.add(item);
        }
//        DiscoverPieDto item = new DiscoverPieDto();
//        item.setValue(shangchuang);
//        item.setName("上传");
//        dtoList.add(item);
        return dtoList;
    }

    @Override
    public List<String> heatmap() {
        return representDiscoverMapper.selectByLocation();
    }

    /**
     * 退回接口  只能回退一次
     * @param fallbackVo
     * @return
     */
    @Override
    public AjaxResult fallback(DiscoverFallbackVo fallbackVo) {
        if(fallbackVo.getProcessType().equals(Constants.DISCOVER_PROCESS_TYPE_1)){
            return AjaxResult.error("您不能直接回退！");
        }
        if(fallbackVo.getProcessType().equals(Constants.DISCOVER_PROCESS_TYPE_3)){
            fallbackVo.setProcessType(Constants.DISCOVER_PROCESS_TYPE_2);
        }else if(fallbackVo.getProcessType().equals(Constants.DISCOVER_PROCESS_TYPE_2)){
            fallbackVo.setProcessType(Constants.DISCOVER_PROCESS_TYPE_1);
        }
        RepresentDiscoverTrack track=  representDiscoverTrackMapper.selectBySendUserId(fallbackVo.getReceiveUserId(),fallbackVo.getDiscoverId());
        if(track == null){
            return AjaxResult.error("上一条记录不存在！");
        }
        fallbackVo.setReceiveUserId(track.getSendUserId());
        fallbackVo.setUpdateTime(DateUtils.getNowDate());
        if(representDiscoverMapper.updateRepresentDiscover(fallbackVo) <= 0){
            return AjaxResult.error("退回接口，修改状态错误！");
        }
        RepresentDiscoverTrack ttrck = new RepresentDiscoverTrack();
        ttrck.setDiscoverId(fallbackVo.getDiscoverId());
        ttrck.setRevert(fallbackVo.getRevert());
        ttrck.setSendUserId(fallbackVo.getReceiveUserId());
        ttrck.setReceiveUserId(track.getSendUserId());
        ttrck.setStatus(Constants.DISCOVER_STATUS_4);
        ttrck.setCreateTime(DateUtils.getNowDate());
        ttrck.setCreateBy(fallbackVo.getUpdateBy());
        ttrck.setProcessType(fallbackVo.getProcessType());
        ttrck.setPicUrls(fallbackVo.getTrackPicUrls());
        if(representDiscoverTrackMapper.insertRepresentDiscoverTrack(ttrck) <=0){
            return AjaxResult.error("创建记录失败！");
        }
        return AjaxResult.success();
    }

    /**
     * 督查列表
     * @param userId
     * @return
     */
    @Override
    public List<DiscoverAppListDto> translateList(Long userId) {
        RepresentHomeAccess access= representHomeAccessMapper.selectByUserId(userId);
        if(access != null){
            if(access.getLevel() == 0){
                startPage();
                return representDiscoverMapper.translateList(null);
            }else{
                startPage();
                return representDiscoverMapper.translateList(access.getAccessId());
            }
        }
        return  null;
    }

    @Override
    public List<DiscoverRankingDto> ranking() {
        return representDiscoverMapper.selectByGeRenRanking();
    }

    @Override
    public List<DiscoverContactRankingDto> contactRanking() {
        return representDiscoverMapper.selectByContactRanking();
    }

    @Override
    public List<DiscoverContactRankingDto> contactBaiFenLvRanking() {
        return representDiscoverMapper.selectByContactbaifenlvRanking();
    }

    @Override
    public DiscoverTotalRenLVDto selectByTotalLv() {
        return representDiscoverMapper.selectByTotalLv();
    }

    @Override
    public List<RepresentDiscover> selectByUserId(Long userId) {
        return representDiscoverMapper.selectByUserId(userId);
    }

    @Override
    public List<DiscoverRankingDto> selectByExportRanking() {
        return representDiscoverMapper.selectByExportRanking();
    }

}
