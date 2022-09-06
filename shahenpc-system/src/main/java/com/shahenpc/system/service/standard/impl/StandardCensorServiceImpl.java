package com.shahenpc.system.service.standard.impl;

import com.shahenpc.common.constant.Constants;
import com.shahenpc.common.core.domain.AjaxResult;
import com.shahenpc.common.utils.DateUtils;
import com.shahenpc.common.utils.StringUtils;
import com.shahenpc.system.domain.standard.StandardCensor;
import com.shahenpc.system.domain.standard.StandardCensorRecord;
import com.shahenpc.system.domain.standard.dto.CemsorDetailDto;
import com.shahenpc.system.domain.standard.vo.CensorAddVo;
import com.shahenpc.system.domain.standard.vo.CensorUpdateVo;
import com.shahenpc.system.mapper.standard.StandardCensorMapper;
import com.shahenpc.system.mapper.standard.StandardCensorRecordMapper;
import com.shahenpc.system.service.standard.IStandardCensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

/**
 * 审查流程Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-07-22
 */
@Service
public class StandardCensorServiceImpl implements IStandardCensorService 
{
    @Autowired
    private StandardCensorMapper standardCensorMapper;
    @Autowired
    private StandardCensorRecordMapper standardCensorRecordMapper;
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
        standardCensor.setReceiveUserId(StringUtils.join(standardCensor.getReceiveUserIds(),","));
        int su =  standardCensorMapper.insertStandardCensor(standardCensor);
        if(su > 0){
            for (String itme:standardCensor.getReceiveUserIds()){
                StandardCensorRecord standardCensorRecord = new StandardCensorRecord();
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
    public AjaxResult updateStandardCensor(CensorUpdateVo standardCensor)
    {
        standardCensor.setUpdateTime(DateUtils.getNowDate());
        standardCensor.setReceiveUserId(StringUtils.join(standardCensor.getReceiveUserIds(),","));
        if(standardCensor.getType().equals(Constants.CENSOR_TYPE_0)){
            standardCensor.setType(Constants.CENSOR_TYPE_1);
        }
        int su = standardCensorMapper.updateStandardCensor(standardCensor);
        if(su > 0){
            for (String itme:standardCensor.getReceiveUserIds()){
                StandardCensorRecord standardCensorRecord = new StandardCensorRecord();
                //发送人
                standardCensorRecord.setSendUserId(standardCensor.getSendUserId());
                //接收人
                standardCensorRecord.setReceiveUserId(Long.valueOf(itme));
                //绑定id
                standardCensorRecord.setCensorId(standardCensor.getCensorId());

                standardCensorRecord.setType(standardCensor.getType());
                standardCensorRecord.setCreateTime(DateUtils.getNowDate());
                standardCensorRecord.setCreateBy(standardCensor.getCreateBy());
                return AjaxResult.success(standardCensorRecordMapper.insertStandardCensorRecord(standardCensorRecord));
            }
        }
        return AjaxResult.error();
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


}
