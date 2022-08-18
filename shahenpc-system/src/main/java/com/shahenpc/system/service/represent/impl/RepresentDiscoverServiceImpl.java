package com.shahenpc.system.service.represent.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import com.shahenpc.common.core.domain.entity.SysDictData;
import com.shahenpc.common.utils.DateUtils;
import com.shahenpc.system.domain.feature.FeatureDoubleWork;
import com.shahenpc.system.domain.feature.dto.FeatureCakeDto;
import com.shahenpc.system.domain.feature.dto.FeatureLineDto;
import com.shahenpc.system.domain.represent.RepresentDiscoverTrack;
import com.shahenpc.system.domain.represent.RepresentWorkLog;
import com.shahenpc.system.domain.represent.dto.*;
import com.shahenpc.system.mapper.represent.RepresentDiscoverTrackMapper;
import com.shahenpc.system.service.ISysDictDataService;
import com.shahenpc.system.service.ISysDictTypeService;
import com.shahenpc.system.service.represent.IRepresentWorkLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shahenpc.system.mapper.represent.RepresentDiscoverMapper;
import com.shahenpc.system.domain.represent.RepresentDiscover;
import com.shahenpc.system.service.represent.IRepresentDiscoverService;

/**
 * 代-代发现Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-07-28
 */
@Service
public class RepresentDiscoverServiceImpl implements IRepresentDiscoverService 
{
    @Autowired
    private RepresentDiscoverMapper representDiscoverMapper;
    @Autowired
    private ISysDictDataService dictDataService;
    @Autowired
    private RepresentDiscoverTrackMapper representDiscoverTrackMapper;
    /**
     * 查询代-代发现
     * 
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
    @Autowired
    private IRepresentWorkLogService representWorkLogService;
    @Override
    public int insertRepresentDiscover(RepresentDiscover representDiscover)
    {
        representDiscover.setCreateTime(DateUtils.getNowDate());
        int disc =  representDiscoverMapper.insertRepresentDiscover(representDiscover);
        RepresentWorkLog log = new RepresentWorkLog();
        log.setEventType(4);
        log.setEventId(representDiscover.getDiscoverId());
        log.setUserId(representDiscover.getSendUserId());
        log.setRemark("代表发现！");
        representWorkLogService.insertRepresentWorkLog(log);

        RepresentDiscoverTrack track = new RepresentDiscoverTrack();
        track.setSendUserId(representDiscover.getSendUserId());
        track.setReceiveUserId(representDiscover.getReceiveUserId());
        track.setCreateTime(DateUtils.getNowDate());
        track.setDiscoverId(representDiscover.getDiscoverId());
        track.setStatus(representDiscover.getStatus());
        representDiscoverTrackMapper.insertRepresentDiscoverTrack(track);
        return disc;
    }

    /**
     * 修改代-代发现
     * 
     * @param representDiscover 代-代发现
     * @return 结果
     */
    @Override
    public int updateRepresentDiscover(RepresentDiscover representDiscover)
    {
        representDiscover.setUpdateTime(DateUtils.getNowDate());
        int disc =  representDiscoverMapper.updateRepresentDiscover(representDiscover);
        RepresentDiscoverTrack track = new RepresentDiscoverTrack();
        track.setSendUserId(representDiscover.getSendUserId());
        track.setReceiveUserId(representDiscover.getReceiveUserId());
        track.setCreateTime(DateUtils.getNowDate());
        track.setDiscoverId(representDiscover.getDiscoverId());
        track.setStatus(representDiscover.getStatus());
        representDiscoverTrackMapper.insertRepresentDiscoverTrack(track);
        return disc;
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
        return representDiscoverMapper.deleteRepresentDiscoverByDiscoverIds(discoverIds);
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
        List<SysDictData> dictList=sysDictTypeService.selectDictDataByType("discover_status");
        dictList =  dictList.stream().filter(w -> !w.getDictValue().equals("5")).collect(Collectors.toList());
        for (int i = 0; i < dictList.size(); i++) {
            int finalI = i;
            List<SysDictData> finalDictList = dictList;
            int v = alarBudg.stream().filter(p -> finalDictList.get(finalI).getDictValue().equals(p.getStatus().toString()))
                    .collect(Collectors.toList()).size();
            DiscoverPieDto item = new DiscoverPieDto();
            if(dictList.get(i).getDictLabel().equals("待交办")){
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
            }
//            item.setName(dictList.get(i).getDictLabel());
//            item.setValue(v);
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
}
