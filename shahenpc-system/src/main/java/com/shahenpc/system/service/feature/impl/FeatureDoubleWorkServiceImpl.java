package com.shahenpc.system.service.feature.impl;

import com.shahenpc.common.constant.Constants;
import com.shahenpc.common.core.domain.AjaxResult;
import com.shahenpc.common.core.domain.entity.SysDictData;
import com.shahenpc.common.core.domain.entity.SysUser;
import com.shahenpc.common.utils.DateUtils;
import com.shahenpc.common.utils.SensitiveWordUtil;
import com.shahenpc.system.domain.dto.NewLevelVo;
import com.shahenpc.system.domain.feature.FeatureDoubleWork;
import com.shahenpc.system.domain.feature.FeatureDoubleWorkTrace;
import com.shahenpc.system.domain.feature.dto.*;
import com.shahenpc.system.domain.feature.vo.DoubleFallbackVo;
import com.shahenpc.system.domain.feature.vo.DoubleReturnVo;
import com.shahenpc.system.domain.feature.vo.FeatureDoubleWorkUpdateVo;
import com.shahenpc.system.domain.represent.RepresentDiscover;
import com.shahenpc.system.domain.represent.RepresentDiscoverTrack;
import com.shahenpc.system.domain.represent.RepresentHomeAccess;
import com.shahenpc.system.domain.represent.RepresentWorkLog;
import com.shahenpc.system.mapper.SysUserMapper;
import com.shahenpc.system.mapper.feature.FeatureDoubleWorkMapper;
import com.shahenpc.system.mapper.feature.FeatureDoubleWorkTraceMapper;
import com.shahenpc.system.mapper.feature.FeatureSensitiveWordMapper;
import com.shahenpc.system.mapper.represent.RepresentHomeAccessMapper;
import com.shahenpc.system.service.ISysDictDataService;
import com.shahenpc.system.service.ISysDictTypeService;
import com.shahenpc.system.service.feature.IFeatureDoubleWorkService;
import com.shahenpc.system.service.represent.IRepresentWorkLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 双联工作Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-07-13
 */
@Service
public class FeatureDoubleWorkServiceImpl implements IFeatureDoubleWorkService 
{
    @Autowired
    private FeatureDoubleWorkMapper featureDoubleWorkMapper;
    @Autowired
    private ISysDictDataService dictDataService;
    @Autowired
    private FeatureDoubleWorkTraceMapper featureDoubleWorkTraceMapper;
    @Autowired
    private SysUserMapper sysUserMapper;
    @Autowired
    private ISysDictTypeService sysDictTypeService;
    @Autowired
    private RepresentHomeAccessMapper representHomeAccessMapper;
    @Autowired
    private IRepresentWorkLogService representWorkLogService;
    @Autowired
    private FeatureSensitiveWordMapper featureSensitiveWordMapper;


    /**
     * 查询双联工作
     * 
     * @param doubleId 双联工作主键
     * @return 双联工作
     */
    @Override
    public FeatureDoubleWork selectFeatureDoubleWorkByDoubleId(Long doubleId)
    {
        return featureDoubleWorkMapper.selectFeatureDoubleWorkByDoubleId(doubleId);
    }

    /**
     * 查询双联工作列表
     * 
     * @param featureDoubleWork 双联工作
     * @return 双联工作
     */
    @Override
    public List<FeatureDoubleWork> selectFeatureDoubleWorkList(FeatureDoubleWork featureDoubleWork)
    {
        return featureDoubleWorkMapper.selectFeatureDoubleWorkList(featureDoubleWork);
    }

    /**
     * 新增双联工作
     * 
     * @param featureDoubleWork 双联工作
     * @return 结果
     */
    @Override
    public int insertFeatureDoubleWork(FeatureDoubleWork featureDoubleWork)
    {
        featureDoubleWork.setCreateTime(DateUtils.getNowDate());
        return featureDoubleWorkMapper.insertFeatureDoubleWork(featureDoubleWork);
    }

    /**
     * 修改双联工作
     * 
     * @param featureDoubleWork 双联工作
     * @return 结果
     */
    @Override
    public int updateFeatureDoubleWork(FeatureDoubleWork featureDoubleWork)
    {
        featureDoubleWork.setUpdateTime(DateUtils.getNowDate());
        return featureDoubleWorkMapper.updateFeatureDoubleWork(featureDoubleWork);
    }

    /**
     * 批量删除双联工作
     * 
     * @param doubleIds 需要删除的双联工作主键
     * @return 结果
     */
    @Override
    public int deleteFeatureDoubleWorkByDoubleIds(Long[] doubleIds)
    {
        if(featureDoubleWorkMapper.deleteFeatureDoubleWorkByDoubleIds(doubleIds) > 0){
            return featureDoubleWorkTraceMapper.deleteFeatureDoubleWorkTraceByDoubleIds(doubleIds);
        }
        return 0;
    }

    @Override
    public AjaxResult fallback(DoubleFallbackVo fallbackVo) {
        if(fallbackVo.getProcessType().equals(Constants.DOUBLE_PROCESS_TYPE_1)){
            return AjaxResult.error("您不能直接回退！");
        }
        if(fallbackVo.getProcessType().equals(Constants.DOUBLE_PROCESS_TYPE_3)){
            fallbackVo.setProcessType(Constants.DOUBLE_PROCESS_TYPE_2);
        }else if(fallbackVo.getProcessType().equals(Constants.DOUBLE_PROCESS_TYPE_2)){
            fallbackVo.setProcessType(Constants.DOUBLE_PROCESS_TYPE_1);
        }
        FeatureDoubleWorkTrace track=  featureDoubleWorkTraceMapper.selectBySendUserId(fallbackVo.getReceiveUserId(),fallbackVo.getDoubleId());
        if(track == null){
            return AjaxResult.error("上一条记录不存在！");
        }
        fallbackVo.setReceiveUserId(track.getSendUserId());
        fallbackVo.setUpdateTime(DateUtils.getNowDate());
        if(featureDoubleWorkMapper.updateFeatureDoubleWork(fallbackVo) <= 0){
            return AjaxResult.error("退回接口，修改状态错误！");
        }
        FeatureDoubleWorkTrace ttrck = new FeatureDoubleWorkTrace();
        ttrck.setDoubleId(fallbackVo.getDoubleId());
        ttrck.setRevert(fallbackVo.getRevert());
        ttrck.setSendUserId(fallbackVo.getReceiveUserId());
        ttrck.setReceiveUserId(track.getSendUserId());
        ttrck.setStatus(Constants.DISCOVER_STATUS_4);
        ttrck.setCreateTime(DateUtils.getNowDate());
        ttrck.setCreateBy(fallbackVo.getUpdateBy());
        ttrck.setProcessType(fallbackVo.getProcessType());
        ttrck.setPicUrls(fallbackVo.getTrackPicUrls());
        if(featureDoubleWorkTraceMapper.insertFeatureDoubleWorkTrace(ttrck) <=0){
            return AjaxResult.error("创建记录失败！");
        }
        return AjaxResult.success();
    }

    @Override
    public List<TodoListDto> todoList(FeatureDoubleWork request) {

        return featureDoubleWorkMapper.selectByTodoList(request);
    }

    @Override
    public List<TodoListDto> doneList(FeatureDoubleWork request) {

        return featureDoubleWorkMapper.selectByDoneList(request);
    }

    @Override
    public DoubleDetatilDto adminDateil(Long doubleId) {
        return featureDoubleWorkMapper.adminDateil(doubleId);
    }

    /**
     * 删除双联工作信息
     * 
     * @param doubleId 双联工作主键
     * @return 结果
     */
    @Override
    public int deleteFeatureDoubleWorkByDoubleId(Long doubleId)
    {
        featureDoubleWorkTraceMapper.deleteFeatureDoubleWorkTraceByDoubleId(doubleId);
        return featureDoubleWorkMapper.deleteFeatureDoubleWorkByDoubleId(doubleId);
    }

    @Override
    public List<FeatureCakeDto> speCake() {
        List<FeatureCakeDto> dtoList = new ArrayList<>();
        List<FeatureDoubleWork> alarBudg=featureDoubleWorkMapper.selectByCakeType();
        SysDictData dictParam = new SysDictData();
        dictParam.setDictType("double_type");
        List<SysDictData> dictList = dictDataService.selectDictDataList(dictParam);
        for (int i = 0; i < dictList.size(); i++) {
            int finalI = i;
            int v = 0;
            v = alarBudg.stream().filter(p -> dictList.get(finalI).getDictValue().equals(p.getType().toString()))
                    .collect(Collectors.toList()).size();
            FeatureCakeDto item = new FeatureCakeDto();
            item.setName(dictList.get(i).getDictLabel());
            item.setValue(v);
            dtoList.add(item);
        }
        return dtoList;
    }

    @Override
    public List<FeatureCakeDto> statusCount() {
        List<FeatureCakeDto> dtoList = new ArrayList<>();
        List<FeatureDoubleWork> alarBudg=featureDoubleWorkMapper.selectByCakeType();
        List<SysDictData> dictList = sysDictTypeService.selectDictDataByType("double_status");
        dictList =  dictList.stream().filter(w -> !w.getDictValue().equals("5")).collect(Collectors.toList());
        for (int i = 0; i < dictList.size(); i++) {
            int finalI = i;
            int v = 0;
            List<SysDictData> finalDictList = dictList;
            v = alarBudg.stream().filter(p -> finalDictList.get(finalI).getDictValue().equals(p.getType().toString()))
                    .collect(Collectors.toList()).size();
            FeatureCakeDto item = new FeatureCakeDto();
            item.setName(dictList.get(i).getDictLabel());
            item.setValue(v);
            dtoList.add(item);
        }
        return dtoList;
    }

    @Override
    public DoubleStatusCountDto selectByStatusCount() {
        return featureDoubleWorkMapper.selectByStatusCount();
    }

    @Override
    public List<String> heatmap() {
        return featureDoubleWorkMapper.selectByLocation();
    }

    @Override
    public List<FeatureMonthDto> selectByMonth() {
        return featureDoubleWorkMapper.selectByMonth();
    }



    @Override
    @Transactional
    public AjaxResult newAdd(FeatureDoubleWork featureDoubleWork) {
        //初始化 敏感词库
        SensitiveWordUtil.init(featureSensitiveWordMapper.selectAll());
        //先过滤 敏感词
        if(SensitiveWordUtil.contains(featureDoubleWork.getTitle())){
            return AjaxResult.error("提交失败：标题中存在敏感词。");
        }else if(SensitiveWordUtil.contains(featureDoubleWork.getContent())){
            return AjaxResult.error("提交失败：文本中存在敏感词。");
        }else {
            SysUser user = sysUserMapper.selectUserById(featureDoubleWork.getSendUserId());
            if (user.getUserStatus().equals("1")) {
                featureDoubleWork.setCreateTime(DateUtils.getNowDate());
                if(featureDoubleWorkMapper.insertFeatureDoubleWork(featureDoubleWork) <= 0){
                    return AjaxResult.error("增加双联工作失败！");
                }
                SysUser updateUser = new SysUser();
                updateUser.setUserId(featureDoubleWork.getSendUserId());
                updateUser.setNickName(featureDoubleWork.getNickName());
                updateUser.setPhonenumber(featureDoubleWork.getPhonenumber());
                updateUser.setIdCard(featureDoubleWork.getIdCard());
                user.setNativePlace(featureDoubleWork.getHomeAddress());
                if(sysUserMapper.updateUser(updateUser) <= 0){
                    return AjaxResult.error("修改用户表失败！");
                }
                FeatureDoubleWorkTrace featureDoubleWorkTrace = new FeatureDoubleWorkTrace();
                featureDoubleWorkTrace.setDoubleId(featureDoubleWork.getDoubleId());
                featureDoubleWorkTrace.setSendUserId(featureDoubleWork.getSendUserId());
                featureDoubleWorkTrace.setReceiveUserId(featureDoubleWork.getReceiveUserId());
                featureDoubleWorkTrace.setCreateTime(DateUtils.getNowDate());
                featureDoubleWorkTrace.setCreateBy(featureDoubleWork.getCreateBy());
                if(featureDoubleWorkTraceMapper.insertFeatureDoubleWorkTrace(featureDoubleWorkTrace)<=0){
                    AjaxResult.error("双联工作记录添加失败！");
                }
                //添加日志
                RepresentWorkLog log = new RepresentWorkLog();
                log.setEventType(3);
                log.setEventId(featureDoubleWork.getDoubleId());
                log.setUserId(featureDoubleWork.getReceiveUserId());
                log.setRemark("双联工作！");
                if(representWorkLogService.insertRepresentWorkLog(log) <= 0){
                    return AjaxResult.error("添加双联工作日志失败！");
                }
                return AjaxResult.success(featureDoubleWork.getDoubleId());
            } else {
                return AjaxResult.error("系统维护！");
            }
        }
    }
        //|| featureDoubleWork.getStatus().equals(Constants.DOUBLE_STATUS_2)
    @Override
    @Transactional
    public AjaxResult newUpdate(FeatureDoubleWorkUpdateVo featureDoubleWork) {
                //状态 转交  办结传 2
            if(featureDoubleWork.getStatus().equals(Constants.DOUBLE_STATUS_1)  ){
                FeatureDoubleWorkUpdateVo Work = new FeatureDoubleWorkUpdateVo();
                Work.setUpdateTime(DateUtils.getNowDate());
                if(Constants.DOUBLE_PROCESS_TYPE_1.equals(featureDoubleWork.getProcessType())){
                    SysUser user=sysUserMapper.selectUserById(featureDoubleWork.getReceiveUserId());
                    if(user.getContactStationId() == null){
                        return AjaxResult.error("未绑定联络站！");
                    }
                    RepresentHomeAccess access= representHomeAccessMapper.selectRepresentHomeAccessByAccessId(user.getContactStationId());
                    if(access == null){
                        return AjaxResult.error("联络站不存在！");
                    }
                    Work.setReceiveUserId(access.getUserId());
                    Work.setProcessType(Constants.DOUBLE_PROCESS_TYPE_2);
                }else if(Constants.DOUBLE_PROCESS_TYPE_2.equals(featureDoubleWork.getProcessType())){
                    RepresentHomeAccess access=representHomeAccessMapper.selectByLevel();
                    Work.setReceiveUserId(access.getUserId());
                    Work.setProcessType(Constants.DOUBLE_PROCESS_TYPE_3);
                }else if(Constants.DOUBLE_PROCESS_TYPE_3.equals(featureDoubleWork.getProcessType())){
                    Work.setProcessType(Constants.DOUBLE_PROCESS_TYPE_4);
                    //这个需要选人传入 setReceiveUserId(1)|
                    Work.setReceiveUserId(sysUserMapper.selectByZhengFuBan());
                }else if(Constants.DOUBLE_PROCESS_TYPE_4.equals(featureDoubleWork.getProcessType())){
                    Work.setProcessType(Constants.DOUBLE_PROCESS_TYPE_5);
                    //这个需要选人传入 setReceiveUserId(1)
                    Work.setReceiveUserId(featureDoubleWork.getReceiveUserId());
                }
                Work.setDoubleId(featureDoubleWork.getDoubleId());
                if(featureDoubleWorkMapper.updateFeatureDoubleWork(Work) <= 0){
                    return AjaxResult.error("修改接收人失败！");
                }
                        //修改原来记录
                        FeatureDoubleWorkTrace tracelist=  featureDoubleWorkTraceMapper.selectBySendUserId(featureDoubleWork.getUserId(),featureDoubleWork.getDoubleId());
                        if(tracelist == null){
                            return AjaxResult.error("没有以前的记录！");
                        }
                        tracelist.setStatus(Constants.DOUBLE_STATUS_2);
                        if(featureDoubleWorkTraceMapper.updateFeatureDoubleWorkTrace(tracelist) <= 0){
                            return AjaxResult.error("修改原来的记录报错！");
                        }
                        FeatureDoubleWorkTrace featureDoubleWorkTrace = new FeatureDoubleWorkTrace();
                        //然后增加
                        featureDoubleWorkTrace.setSendUserId(featureDoubleWork.getUserId());
                        featureDoubleWorkTrace.setReceiveUserId(Work.getReceiveUserId());
                        featureDoubleWorkTrace.setDoubleId(featureDoubleWork.getDoubleId());
                        featureDoubleWorkTrace.setRevert(featureDoubleWork.getRevert());
                        featureDoubleWorkTrace.setProcessType(Work.getProcessType());
                        featureDoubleWorkTrace.setPicUrls(featureDoubleWork.getTrackPicUrls());
                        featureDoubleWorkTrace.setCreateTime(DateUtils.getNowDate());
                        featureDoubleWorkTrace.setCreateBy(featureDoubleWork.getUpdateBy());
                        featureDoubleWorkTraceMapper.insertFeatureDoubleWorkTrace(featureDoubleWorkTrace);
                    return AjaxResult.success();
            }else{
                FeatureDoubleWork Work = new FeatureDoubleWork();
                Work.setDoubleId(featureDoubleWork.getDoubleId());
                Work.setStatus(Constants.DOUBLE_STATUS_3);
                if(featureDoubleWorkMapper.updateFeatureDoubleWork(Work) <= 0){
                    return AjaxResult.error("修改失败！");
                }
                //查询当前记录
                FeatureDoubleWorkTrace tr= featureDoubleWorkTraceMapper.selectBySendUserId(featureDoubleWork.getUserId(),featureDoubleWork.getDoubleId());
                if(tr == null){
                    return AjaxResult.error("没有当前记录！");
                }
                tr.setStatus(Constants.DOUBLE_STATUS_2);
                if(featureDoubleWorkTraceMapper.updateFeatureDoubleWorkTrace(tr) <= 0){
                    return AjaxResult.error("记录修改失败！");
                }
                FeatureDoubleWorkTrace track = new FeatureDoubleWorkTrace();
                track.setSendUserId(featureDoubleWork.getReceiveUserId());
                track.setDoubleId(featureDoubleWork.getDoubleId());
                track.setStatus(Constants.DOUBLE_STATUS_3);
                track.setReceiveUserId(featureDoubleWork.getReceiveUserId());
                track.setRevert(featureDoubleWork.getRevert());
                track.setProcessType(featureDoubleWork.getProcessType());
                track.setCreateBy(featureDoubleWork.getUpdateBy());
                track.setCreateTime(DateUtils.getNowDate());
                track.setPicUrls(featureDoubleWork.getTrackPicUrls());
                if(featureDoubleWorkTraceMapper.insertFeatureDoubleWorkTrace(track) <= 0){
                    return AjaxResult.error("记录添加失败！");
                }
                return AjaxResult.success();
            }
    }

    /**
     * 回退
     * @param vo
     * @return
     */
    @Override
    public AjaxResult doubleReturn(DoubleReturnVo vo) {


        return null;
    }

    @Override
    public int appNewAdd(FeatureDoubleWork featureDoubleWork) {
        featureDoubleWork.setCreateTime(DateUtils.getNowDate());
        int a =  featureDoubleWorkMapper.insertFeatureDoubleWork(featureDoubleWork);
        FeatureDoubleWorkTrace featureDoubleWorkTrace = new FeatureDoubleWorkTrace();
        featureDoubleWorkTrace.setDoubleId(featureDoubleWork.getDoubleId());
        featureDoubleWorkTrace.setSendUserId(featureDoubleWork.getSendUserId());
        featureDoubleWorkTrace.setReceiveUserId(featureDoubleWork.getReceiveUserId());
        featureDoubleWorkTrace.setStatus(featureDoubleWork.getStatus());
        featureDoubleWorkTrace.setRevert(featureDoubleWork.getContent());
        featureDoubleWorkTrace.setCreateTime(DateUtils.getNowDate());
        featureDoubleWorkTrace.setPicUrls(featureDoubleWork.getPicUrls());
        featureDoubleWorkTraceMapper.insertFeatureDoubleWorkTrace(featureDoubleWorkTrace);
        return a;
    }

    @Override
    public FeatureEachCount eachCount() {
        FeatureEachCount each =  featureDoubleWorkMapper.eachCount();
        if(each != null) {
            if (each.getProcessed() != 0 && each.getProportion() != 0) {
                each.setProportion(each.getProcessed() / (each.getProcessed() + each.getProportion()));
                each.setProportion(Double.valueOf(String.format("%.2f", each.getProportion())));
            }
        }else{
            FeatureEachCount aa= new FeatureEachCount();
            aa.setProportion(0.00);
            aa.setMasses(0);
            aa.setParticipate(0);
            aa.setProcessed(0);
            each =aa;
        }
        return each;
    }

    @Override
    public FeatureRing ring() {
        return featureDoubleWorkMapper.selectByRing();
    }

    @Override
    public FeatureLineDto line() {
        List<String> monthList = getNearSixMonth();
        FeatureLineDto res = new FeatureLineDto();
        res.setLabel(monthList);
        List<Integer> yList = new ArrayList<>();
        FeatureDoubleWork work = new FeatureDoubleWork();
        List<FeatureDoubleWork>  list=featureDoubleWorkMapper.selectFeatureDoubleWorkList(work);
        for (int i = 0; i < monthList.size(); i++) {
            int finalI = i;
            String cntt = monthList.get(finalI);
            List<FeatureDoubleWork> nearlist1 = list.stream().
                    filter(w -> DateUtils.dateTime(w.getCreateTime()).contains(cntt)).collect(Collectors.toList());
            yList.add(nearlist1.size());
        }
        res.setData(yList);
        Collections.reverse(res.getData());
        Collections.reverse(res.getLabel());
        return res;
    }

    @Override
    public List<DoubleAppListDto> appList(FeatureDoubleWork featureDoubleWork) {
        return featureDoubleWorkMapper.appList(featureDoubleWork);
    }

    @Override
    public List<DoubleListDto> adminList(FeatureDoubleWork featureDoubleWork) {
        return featureDoubleWorkMapper.adminList(featureDoubleWork);
    }

    @Override
    public DoubleCountRanDto countAndranking(Long userId) {
        return featureDoubleWorkMapper.selectByCountRanking(userId);
    }

    @Override
    public List<TodoListDto> translateList(Long userId) {
        RepresentHomeAccess access= representHomeAccessMapper.selectByUserId(userId);
        if(access != null){
            if(access.getLevel() == 0){
                return featureDoubleWorkMapper.translateList(null);
            }else{
                return featureDoubleWorkMapper.translateList(access.getAccessId());
            }
        }
        return null;
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


}
