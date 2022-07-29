package com.shahenpc.system.service.represent.impl;

import java.util.ArrayList;
import java.util.List;
import com.shahenpc.common.utils.DateUtils;
import com.shahenpc.system.domain.represent.dto.PerformDutieRankingDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shahenpc.system.mapper.represent.RepresentWorkLogMapper;
import com.shahenpc.system.domain.represent.RepresentWorkLog;
import com.shahenpc.system.service.represent.IRepresentWorkLogService;

/**
 * 代履职日志Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-07-28
 */
@Service
public class RepresentWorkLogServiceImpl implements IRepresentWorkLogService 
{
    @Autowired
    private RepresentWorkLogMapper representWorkLogMapper;

    /**
     * 查询代履职日志
     * 
     * @param id 代履职日志主键
     * @return 代履职日志
     */
    @Override
    public RepresentWorkLog selectRepresentWorkLogById(Long id)
    {
        return representWorkLogMapper.selectRepresentWorkLogById(id);
    }

    /**
     * 查询代履职日志列表
     * 
     * @param representWorkLog 代履职日志
     * @return 代履职日志
     */
    @Override
    public List<RepresentWorkLog> selectRepresentWorkLogList(RepresentWorkLog representWorkLog)
    {
        return representWorkLogMapper.selectRepresentWorkLogList(representWorkLog);
    }

    /**
     * 新增代履职日志
     * 
     * @param representWorkLog 代履职日志
     * @return 结果
     */
    @Override
    public int insertRepresentWorkLog(RepresentWorkLog representWorkLog)
    {
        representWorkLog.setCreateTime(DateUtils.getNowDate());
        return representWorkLogMapper.insertRepresentWorkLog(representWorkLog);
    }

    /**
     * 修改代履职日志
     * 
     * @param representWorkLog 代履职日志
     * @return 结果
     */
    @Override
    public int updateRepresentWorkLog(RepresentWorkLog representWorkLog)
    {
        representWorkLog.setUpdateTime(DateUtils.getNowDate());
        return representWorkLogMapper.updateRepresentWorkLog(representWorkLog);
    }

    /**
     * 批量删除代履职日志
     * 
     * @param ids 需要删除的代履职日志主键
     * @return 结果
     */
    @Override
    public int deleteRepresentWorkLogByIds(Long[] ids)
    {
        return representWorkLogMapper.deleteRepresentWorkLogByIds(ids);
    }

    /**
     * 删除代履职日志信息
     * 
     * @param id 代履职日志主键
     * @return 结果
     */
    @Override
    public int deleteRepresentWorkLogById(Long id)
    {
        return representWorkLogMapper.deleteRepresentWorkLogById(id);
    }

    /**排行 */
    @Override
    public List<PerformDutieRankingDto> ranking() {
        return representWorkLogMapper.selectByRanking();
    }
}
