package com.shahenpc.system.service.represent.impl;

import java.util.List;
import com.shahenpc.common.utils.DateUtils;
import com.shahenpc.system.domain.represent.dto.WorkLogRankingDto;
import com.shahenpc.system.mapper.represent.RepresentWorkLogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shahenpc.system.mapper.represent.RepresentWorkRankingMapper;
import com.shahenpc.system.domain.represent.RepresentWorkRanking;
import com.shahenpc.system.service.represent.IRepresentWorkRankingService;

/**
 * 排行 以及 类型数  总数Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-08-11
 */
@Service
public class RepresentWorkRankingServiceImpl implements IRepresentWorkRankingService 
{
    @Autowired
    private RepresentWorkRankingMapper representWorkRankingMapper;
    @Autowired
    private RepresentWorkLogMapper representWorkLogMapper;
    /**
     * 查询排行 以及 类型数  总数
     * 
     * @param rankingId 排行 以及 类型数  总数主键
     * @return 排行 以及 类型数  总数
     */
    @Override
    public RepresentWorkRanking selectRepresentWorkRankingByRankingId(Long rankingId)
    {
        return representWorkRankingMapper.selectRepresentWorkRankingByRankingId(rankingId);
    }

    /**
     * 查询排行 以及 类型数  总数列表
     * 
     * @param representWorkRanking 排行 以及 类型数  总数
     * @return 排行 以及 类型数  总数
     */
    @Override
    public List<RepresentWorkRanking> selectRepresentWorkRankingList(RepresentWorkRanking representWorkRanking)
    {
        return representWorkRankingMapper.selectRepresentWorkRankingList(representWorkRanking);
    }

    /**
     * 新增排行 以及 类型数  总数
     * 
     * @param representWorkRanking 排行 以及 类型数  总数
     * @return 结果
     */
    @Override
    public int insertRepresentWorkRanking(RepresentWorkRanking representWorkRanking)
    {
        representWorkRanking.setCreateTime(DateUtils.getNowDate());
        return representWorkRankingMapper.insertRepresentWorkRanking(representWorkRanking);
    }

    /**
     * 修改排行 以及 类型数  总数
     * 
     * @param representWorkRanking 排行 以及 类型数  总数
     * @return 结果
     */
    @Override
    public int updateRepresentWorkRanking(RepresentWorkRanking representWorkRanking)
    {
        representWorkRanking.setUpdateTime(DateUtils.getNowDate());
        return representWorkRankingMapper.updateRepresentWorkRanking(representWorkRanking);
    }

    /**
     * 批量删除排行 以及 类型数  总数
     * 
     * @param rankingIds 需要删除的排行 以及 类型数  总数主键
     * @return 结果
     */
    @Override
    public int deleteRepresentWorkRankingByRankingIds(Long[] rankingIds)
    {
        return representWorkRankingMapper.deleteRepresentWorkRankingByRankingIds(rankingIds);
    }

    /**
     * 删除排行 以及 类型数  总数信息
     * 
     * @param rankingId 排行 以及 类型数  总数主键
     * @return 结果
     */
    @Override
    public int deleteRepresentWorkRankingByRankingId(Long rankingId)
    {
        return representWorkRankingMapper.deleteRepresentWorkRankingByRankingId(rankingId);
    }

    @Override
    public int timingAdd() {
        //先删 后存
        representWorkRankingMapper.deleteAll();
        //存
        List<WorkLogRankingDto> list= representWorkLogMapper.selectByRankingList();
        RepresentWorkRanking ranking = new RepresentWorkRanking();
        for (WorkLogRankingDto item:list){
            ranking.setRanking(item.getRanking());
            ranking.setTotal(item.getTotal());
            ranking.setUserId(item.getUserId());
            ranking.setTypeCount(item.getTypeCount());
            ranking.setCreateTime(DateUtils.getNowDate());
            representWorkRankingMapper.insertRepresentWorkRanking(ranking);
        }
        return 1;
    }
}
