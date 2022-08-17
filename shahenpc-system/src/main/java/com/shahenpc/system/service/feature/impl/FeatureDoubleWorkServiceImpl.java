package com.shahenpc.system.service.feature.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import com.shahenpc.common.core.domain.AjaxResult;
import com.shahenpc.common.core.domain.entity.SysDictData;
import com.shahenpc.common.core.domain.entity.SysUser;
import com.shahenpc.common.utils.DateUtils;
import com.shahenpc.common.utils.SensitiveWordUtil;
import com.shahenpc.system.domain.feature.FeatureDoubleWorkTrace;
import com.shahenpc.system.domain.feature.dto.*;
import com.shahenpc.system.domain.represent.RepresentWorkLog;
import com.shahenpc.system.mapper.SysUserMapper;
import com.shahenpc.system.mapper.feature.FeatureDoubleWorkTraceMapper;
import com.shahenpc.system.mapper.feature.FeatureSensitiveWordMapper;
import com.shahenpc.system.service.ISysDictDataService;
import com.shahenpc.system.service.ISysDictTypeService;
import com.shahenpc.system.service.represent.IRepresentWorkLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shahenpc.system.mapper.feature.FeatureDoubleWorkMapper;
import com.shahenpc.system.domain.feature.FeatureDoubleWork;
import com.shahenpc.system.service.feature.IFeatureDoubleWorkService;
import org.springframework.transaction.annotation.Transactional;

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
        return featureDoubleWorkMapper.deleteFeatureDoubleWorkByDoubleIds(doubleIds);
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
            v = alarBudg.stream().filter(p -> dictList.get(finalI).getDictValue().equals(p.getDoubleType().toString()))
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
            v = alarBudg.stream().filter(p -> finalDictList.get(finalI).getDictValue().equals(p.getDoubleType().toString()))
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

    @Autowired
    private IRepresentWorkLogService representWorkLogService;
    @Autowired
    private FeatureSensitiveWordMapper featureSensitiveWordMapper;

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
            SysUser user = sysUserMapper.selectUserById(featureDoubleWork.getSubmitUserId());
            if (user.getUserStatus().equals(1)) {
                featureDoubleWork.setCreateTime(DateUtils.getNowDate());
                int a = featureDoubleWorkMapper.insertFeatureDoubleWork(featureDoubleWork);
                //添加日志
                RepresentWorkLog log = new RepresentWorkLog();
                log.setEventType(3);
                log.setEventId(featureDoubleWork.getDoubleId());
                log.setUserId(featureDoubleWork.getReceiveUserId());
                log.setRemark("双联工作！");
                representWorkLogService.insertRepresentWorkLog(log);
                FeatureDoubleWorkTrace featureDoubleWorkTrace = new FeatureDoubleWorkTrace();
                featureDoubleWorkTrace.setDoubleId(featureDoubleWork.getDoubleId());
                featureDoubleWorkTrace.setSendUserId(featureDoubleWork.getSubmitUserId());
                featureDoubleWorkTrace.setReceiveUserId(featureDoubleWork.getReceiveUserId());
                featureDoubleWorkTrace.setStatus(featureDoubleWork.getStatus());
                featureDoubleWorkTrace.setCreateTime(DateUtils.getNowDate());
                featureDoubleWorkTrace.setCreateBy(featureDoubleWork.getCreateBy());
                featureDoubleWorkTraceMapper.insertFeatureDoubleWorkTrace(featureDoubleWorkTrace);
                return AjaxResult.success(featureDoubleWork.getDoubleId());
            } else {
                return AjaxResult.error("您已被屏蔽！");
            }
        }
    }

    @Override
    public AjaxResult newUpdate(FeatureDoubleWork featureDoubleWork) {
            featureDoubleWork.setUpdateTime(DateUtils.getNowDate());
            int a = featureDoubleWorkMapper.updateFeatureDoubleWork(featureDoubleWork);
            FeatureDoubleWorkTrace featureDoubleWorkTrace = new FeatureDoubleWorkTrace();
            featureDoubleWorkTrace.setContent(featureDoubleWork.getReply());
            featureDoubleWorkTrace.setDoubleId(featureDoubleWork.getDoubleId());
            featureDoubleWorkTrace.setSendUserId(featureDoubleWork.getSubmitUserId());
            featureDoubleWorkTrace.setReceiveUserId(featureDoubleWork.getReceiveUserId());
            featureDoubleWorkTrace.setStatus(featureDoubleWork.getStatus());
            featureDoubleWorkTrace.setCreateTime(DateUtils.getNowDate());
            featureDoubleWorkTrace.setCreateBy(featureDoubleWork.getUpdateBy());
            featureDoubleWorkTraceMapper.insertFeatureDoubleWorkTrace(featureDoubleWorkTrace);
            return AjaxResult.success(a);
    }

    @Override
    public int appNewAdd(FeatureDoubleWork featureDoubleWork) {
        featureDoubleWork.setCreateTime(DateUtils.getNowDate());
        int a =  featureDoubleWorkMapper.insertFeatureDoubleWork(featureDoubleWork);
        FeatureDoubleWorkTrace featureDoubleWorkTrace = new FeatureDoubleWorkTrace();
        featureDoubleWorkTrace.setDoubleId(featureDoubleWork.getDoubleId());
        featureDoubleWorkTrace.setSendUserId(featureDoubleWork.getSubmitUserId());
        featureDoubleWorkTrace.setReceiveUserId(featureDoubleWork.getReceiveUserId());
        featureDoubleWorkTrace.setStatus(featureDoubleWork.getStatus());
        featureDoubleWorkTrace.setContent(featureDoubleWork.getContent());
        featureDoubleWorkTrace.setCreateTime(DateUtils.getNowDate());
        featureDoubleWorkTrace.setPicUrls(featureDoubleWork.getPicUrls());
        featureDoubleWorkTraceMapper.insertFeatureDoubleWorkTrace(featureDoubleWorkTrace);
        return a;
    }

    @Override
    public FeatureEachCount eachCount() {
        FeatureEachCount each =  featureDoubleWorkMapper.eachCount();
        if(each.getProcessed() != 0 && each.getProportion() != 0) {
            each.setProportion(each.getProcessed() / (each.getProcessed() + each.getProportion()));
        }
        each.setProportion(Double.valueOf(String.format("%.2f", each.getProportion())));
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
