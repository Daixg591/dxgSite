package com.shahenpc.system.service.represent;

import java.util.List;
import com.shahenpc.system.domain.represent.RepresentWorkLog;
import com.shahenpc.system.domain.represent.dto.PerformDutieRankingDto;
import com.shahenpc.system.domain.represent.dto.WorkLogListDto;

/**
 * 代履职日志Service接口
 * 
 * @author ruoyi
 * @date 2022-07-28
 */
public interface IRepresentWorkLogService 
{
    /**
     * 查询代履职日志
     * 
     * @param id 代履职日志主键
     * @return 代履职日志
     */
    public RepresentWorkLog selectRepresentWorkLogById(Long id);

    /**
     * 查询代履职日志列表
     * 
     * @param representWorkLog 代履职日志
     * @return 代履职日志集合
     */
    public List<RepresentWorkLog> selectRepresentWorkLogList(RepresentWorkLog representWorkLog);

    /**
     * 新增代履职日志
     * 
     * @param representWorkLog 代履职日志
     * @return 结果
     */
    public int insertRepresentWorkLog(RepresentWorkLog representWorkLog);

    /**
     * 修改代履职日志
     * 
     * @param representWorkLog 代履职日志
     * @return 结果
     */
    public int updateRepresentWorkLog(RepresentWorkLog representWorkLog);

    /**
     * 批量删除代履职日志
     * 
     * @param ids 需要删除的代履职日志主键集合
     * @return 结果
     */
    public int deleteRepresentWorkLogByIds(Long[] ids);

    /**
     * 删除代履职日志信息
     * 
     * @param id 代履职日志主键
     * @return 结果
     */
    public int deleteRepresentWorkLogById(Long id);

    public List<PerformDutieRankingDto> ranking();

    public List<WorkLogListDto> appList(RepresentWorkLog representWorkLog);
}
