package com.shahenpc.system.service.standard.impl;

import com.shahenpc.common.constant.Constants;
import com.shahenpc.common.core.controller.BaseController;
import com.shahenpc.common.core.domain.AjaxResult;
import com.shahenpc.common.core.domain.entity.SysDictData;
import com.shahenpc.common.utils.DateUtils;
import com.shahenpc.common.utils.SecurityUtils;
import com.shahenpc.common.utils.StringUtils;
import com.shahenpc.system.domain.represent.dto.MotionLingDto;
import com.shahenpc.system.domain.represent.dto.MotionPieDto;
import com.shahenpc.system.domain.represent.dto.MotionRingDto;
import com.shahenpc.system.domain.standard.StandardCensor;
import com.shahenpc.system.domain.standard.StandardCensorRecord;
import com.shahenpc.system.domain.standard.dto.CemsorDetailDto;
import com.shahenpc.system.domain.standard.dto.TotalAndStatyDto;
import com.shahenpc.system.domain.standard.vo.*;
import com.shahenpc.system.mapper.standard.StandardCensorMapper;
import com.shahenpc.system.mapper.standard.StandardCensorRecordMapper;
import com.shahenpc.system.service.ISysDictTypeService;
import com.shahenpc.system.service.standard.IStandardCensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 审查流程Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-07-22
 */
@Service
public class StandardCensorServiceImpl extends BaseController implements IStandardCensorService
{
    @Autowired
    private StandardCensorMapper standardCensorMapper;
    @Autowired
    private StandardCensorRecordMapper standardCensorRecordMapper;
    @Resource
    private ISysDictTypeService dictTypeService;
    /**
     * 查询审查流程
     * 
     * @param processId 审查流程主键
     * @return 审查流程
     */
    @Override
    public StandardCensor selectStandardCensorByProcessId(Long processId)
    {
        return standardCensorMapper.selectStandardCensorByCensorId(processId);
    }

    /**
     * 查询审查流程列表
     * 
     * @param standardCensor 审查流程
     * @return 审查流程
     */
    @Override
    public List<StandardCensor> selectStandardCensorList(StandardCensor standardCensor)
    {
        return standardCensorMapper.selectStandardCensorList(standardCensor);
    }

    @Override
    public List<StandardCensor> selectByTodoList(StandardCensor request) {
        return standardCensorMapper.selectByTodoList(request);
    }

    @Override
    public List<StandardCensor> selectByDoneList(Long userId) {
        return standardCensorMapper.selectByDoneList(userId);
    }

    /**
     * 新增审查流程
     * 
     * @param standardCensor 审查流程
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public AjaxResult insertStandardCensor(CensorAddVo standardCensor)
    {
        standardCensor.setCreateTime(DateUtils.getNowDate());
        standardCensor.setReceiveUserId(StringUtils.join(standardCensor.getApprovalUserId(),","));
        standardCensor.setType(Constants.CENSOR_TYPE_1);
        int su =  standardCensorMapper.insertStandardCensor(standardCensor);
        if(su > 0){
            for (String itme:standardCensor.getApprovalUserId()){
                StandardCensorRecord standardCensorRecord = new StandardCensorRecord();
                standardCensorRecord.setType(Constants.CENSOR_TYPE_1);
                //发送人
                standardCensorRecord.setSendUserId(standardCensor.getSendUserId());
                //接收人
                standardCensorRecord.setReceiveUserId(Long.valueOf(itme));
                //绑定id
                standardCensorRecord.setCensorId(standardCensor.getCensorId());
                standardCensorRecord.setCreateTime(DateUtils.getNowDate());
                standardCensorRecord.setCreateBy(standardCensor.getCreateBy());
                return AjaxResult.success(standardCensorRecordMapper.insertStandardCensorRecord(standardCensorRecord));
            }
       }
        return AjaxResult.error("异常");
    }


    /**
     * 修改审查流程
     * 
     * @param standardCensor 审查流程
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public AjaxResult updateStandardCensor(CensorUpdateVo standardCensor)
    {
        standardCensor.setUpdateTime(DateUtils.getNowDate());
        standardCensor.setReceiveUserId(StringUtils.join(standardCensor.getApprovalUserId(),","));
        //修改原来的记录的状态 不修改type
        StandardCensorRecord updateRecord = new StandardCensorRecord();
        RecordByRecordIdVo vo = new RecordByRecordIdVo();
        vo.setCensorId(standardCensor.getCensorId());
        vo.setType(standardCensor.getType());
        vo.setReceiveUserId(getUserId());//当前人
        StandardCensorRecord recordId=standardCensorRecordMapper.selectByRecordId(vo);
        updateRecord.setRecordId(recordId.getRecordId());
        updateRecord.setRevert(standardCensor.getRevert());
        updateRecord.setStatus(Constants.CENSOR_TYPE_STATUS_1);
        updateRecord.setUpdateTime(DateUtils.getNowDate());
        updateRecord.setUpdateBy(standardCensor.getCreateBy());
        standardCensorRecordMapper.updateStandardCensorRecord(updateRecord);
        //
        if(standardCensor.getType().equals(Constants.CENSOR_TYPE_1)){
            standardCensor.setType(Constants.CENSOR_TYPE_2);
        }else if(standardCensor.getType().equals(Constants.CENSOR_TYPE_2)){
            standardCensor.setType(Constants.CENSOR_TYPE_3);
        }else if(standardCensor.getType().equals(Constants.CENSOR_TYPE_3)){
            standardCensor.setType(Constants.CENSOR_TYPE_4);
        }else{
            standardCensor.setType(Constants.CENSOR_TYPE_5);
        }
        // 先判断  是否是分发
        if(standardCensor.getType().equals(Constants.CENSOR_TYPE_4)){
            List<StandardCensorRecord> distribute= standardCensorRecordMapper.selectByDistribute(standardCensor.getCensorId());
            int dist = distribute.stream().filter(p -> p.getStatus().equals(Constants.CENSOR_TYPE_STATUS_0)).collect(Collectors.toList()).size();
            if(dist == 0){
                standardCensor.setReceiveUserId(standardCensor.getSendUserId().toString());
                int su = standardCensorMapper.updateStandardCensor(standardCensor);
                if(su > 0) {
                    StandardCensorRecord standardCensorRecord = new StandardCensorRecord();
                        //发送人
                        standardCensorRecord.setSendUserId(standardCensor.getSendUserId());
                        //接收人
                        standardCensorRecord.setReceiveUserId(Long.parseLong(standardCensor.getReceiveUserId()));
                        //绑定id
                        standardCensorRecord.setCensorId(standardCensor.getCensorId());
                        //回复
                        standardCensorRecord.setType(standardCensor.getType());
                        standardCensorRecord.setCreateTime(DateUtils.getNowDate());
                        standardCensorRecord.setCreateBy(standardCensor.getCreateBy());
                        standardCensorRecordMapper.insertStandardCensorRecord(standardCensorRecord);
                    return AjaxResult.success();
                }
            }else{
               /* StandardCensorRecord updateRecord1 = new StandardCensorRecord();
                updateRecord1.setRecordId(standardCensor.getRecordId());
                updateRecord1.setRevert(standardCensor.getRevert());
                updateRecord1.setStatus(Constants.CENSOR_TYPE_STATUS_1);
                updateRecord1.setUpdateTime(DateUtils.getNowDate());
                updateRecord1.setUpdateBy(standardCensor.getCreateBy());
                standardCensorRecordMapper.updateStandardCensorRecord(updateRecord);*/
                return AjaxResult.success();
            }
        }
        int su = standardCensorMapper.updateStandardCensor(standardCensor);
        if(su > 0){
            StandardCensorRecord standardCensorRecord = new StandardCensorRecord();
            for (String itme:standardCensor.getApprovalUserId()){
                //发送人
                standardCensorRecord.setSendUserId(standardCensor.getSendUserId());
                //接收人
                standardCensorRecord.setReceiveUserId(Long.valueOf(itme));
                //绑定id
                standardCensorRecord.setCensorId(standardCensor.getCensorId());
                //回复
                standardCensorRecord.setType(standardCensor.getType());
                standardCensorRecord.setCreateTime(DateUtils.getNowDate());
                standardCensorRecord.setCreateBy(standardCensor.getCreateBy());
                standardCensorRecordMapper.insertStandardCensorRecord(standardCensorRecord);
            }
            return AjaxResult.success();
        }
        return AjaxResult.error();
    }



    @Override
    public AjaxResult censorReturn(CensorReturnVo vo) {
        StandardCensor standardCensor = new StandardCensor();
        standardCensor.setUpdateTime(DateUtils.getNowDate());
        if(vo.getType().equals(Constants.CENSOR_TYPE_3)){
            standardCensor.setType(Constants.CENSOR_TYPE_2);
        }else if(vo.getType().equals(Constants.CENSOR_TYPE_2)){
            standardCensor.setType(Constants.CENSOR_TYPE_1);
        }
        StandardCensorRecord sup = standardCensorRecordMapper.selectBySuperior(vo.getCensorId(),standardCensor.getType());
        //修改当前状态
        StandardCensorRecord update =standardCensorRecordMapper.selectBySuperior(vo.getCensorId(),vo.getType());
        update.setStatus(Constants.CENSOR_TYPE_STATUS_3);
        update.setRevert(vo.getRevert());
        if(standardCensorRecordMapper.updateStandardCensorRecord(update) < 0){
            AjaxResult.error();
        }
        if(sup != null){
            standardCensor.setReceiveUserId(sup.getReceiveUserId().toString());
            standardCensor.setCensorId(vo.getCensorId());
            if(standardCensorMapper.updateStandardCensor(standardCensor) > 0){
                StandardCensorRecord standardCensorRecord = new StandardCensorRecord();
                //发送人
                standardCensorRecord.setSendUserId(vo.getUserId());
                //接收人
                standardCensorRecord.setReceiveUserId(sup.getReceiveUserId());
                //绑定id
                standardCensorRecord.setCensorId(vo.getCensorId());
                //回复
                standardCensorRecord.setType(standardCensor.getType());
                standardCensorRecord.setCreateTime(DateUtils.getNowDate());
                standardCensorRecord.setCreateBy(vo.getCreateBy());
                standardCensorRecordMapper.insertStandardCensorRecord(standardCensorRecord);
                return AjaxResult.success();
            }
        }
        return AjaxResult.error();
    }

    @Override
    public AjaxResult CensorPass(CensorPassVo vo) {
        StandardCensorRecord standardCensorRecord = new StandardCensorRecord();
        standardCensorRecord.setRecordId(vo.getRecordId());
        standardCensorRecord.setStatus(Constants.CENSOR_TYPE_STATUS_1);
        standardCensorRecord.setUpdateBy(vo.getUpdateBy());
        standardCensorRecord.setUpdateTime(DateUtils.getNowDate());
        standardCensorRecordMapper.updateStandardCensorRecord(standardCensorRecord);
        return AjaxResult.success();
    }

    /**
     * 批量删除审查流程
     * 
     * @param processIds 需要删除的审查流程主键
     * @return 结果
     */
    @Override
    public int deleteStandardCensorByProcessIds(Long[] processIds)
    {
        return standardCensorMapper.deleteStandardCensorByCensorIds(processIds);
    }

    /**
     * 删除审查流程信息
     * 
     * @param processId 审查流程主键
     * @return 结果
     */
    @Override
    public int deleteStandardCensorByProcessId(Long processId)
    {
        return standardCensorMapper.deleteStandardCensorByCensorId(processId);
    }

    @Override
    public StandardCensor selectByProcessId(String processId) {

        return standardCensorMapper.selectByProcessId(processId);
    }

    @Override
    public CemsorDetailDto selectByCensorId(Long cemsorId) {
        return standardCensorMapper.selectByCensorId(cemsorId);
    }



    @Override
    public String ring() {
        TotalAndStatyDto dto=standardCensorMapper.selectByTotalAndStay();
        // 待处理的  已处理的   全部接收的
        //int count = stayTotal+receiveTotal+doneTotal;
        MotionRingDto cakedto =new MotionRingDto();
        BigDecimal a = new BigDecimal(dto.getStayTotal());
        BigDecimal b = new BigDecimal(dto.getTotal());
        BigDecimal gd = new BigDecimal(0.00);
        if(!b.equals(BigDecimal.ZERO)){
            gd = a.divide(b,2,BigDecimal.ROUND_CEILING);
        }
        cakedto.setValue(gd.toString());
        return cakedto.getValue();
    }



    @Override
    public List<MotionPieDto> pie() {
        StandardCensor standardCensor = new StandardCensor();
        List<StandardCensor> receiveTotal =  standardCensorMapper.selectStandardCensorList(standardCensor);
        List<MotionPieDto> dto = new ArrayList<>();
        List<SysDictData> dictList = dictTypeService.selectDictDataByType("censor_type");
        for (int i = 0; i < dictList.size(); i++) {
            int finalI = i;
            int v = receiveTotal.stream().filter(p -> dictList.get(finalI).getDictLabel().equals(p.getType()))
                    .collect(Collectors.toList()).size();
            MotionPieDto item = new MotionPieDto();
            item.setName(dictList.get(i).getDictLabel());
            item.setValue(v);
            dto.add(item);
        }
        return dto;
    }

    @Override
    public MotionLingDto line() {
        List<String> monthList = getNearSixMonth();
        MotionLingDto res = new MotionLingDto();
        res.setLabel(monthList);
        List<Integer> yList = new ArrayList<>();
        StandardCensor cen = new StandardCensor();
        List<StandardCensor> receiveTotal=standardCensorMapper.selectStandardCensorList(cen);
        for (int i = 0; i < monthList.size(); i++) {
            int finalI = i;
            String cntt = monthList.get(finalI);
            List<StandardCensor> nearlist1 = receiveTotal.stream().
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
}
