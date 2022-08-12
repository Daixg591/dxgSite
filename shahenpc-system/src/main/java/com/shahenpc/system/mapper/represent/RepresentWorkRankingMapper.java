package com.shahenpc.system.mapper.represent;

import java.util.List;
import com.shahenpc.system.domain.represent.RepresentWorkRanking;

/**
 * 排行 以及 类型数  总数Mapper接口
 * 
 * @author ruoyi
 * @date 2022-08-11
 */
public interface RepresentWorkRankingMapper 
{
    /**
     * 查询排行 以及 类型数  总数
     * 
     * @param rankingId 排行 以及 类型数  总数主键
     * @return 排行 以及 类型数  总数
     */
    public RepresentWorkRanking selectRepresentWorkRankingByRankingId(Long rankingId);

    /**
     * 查询排行 以及 类型数  总数列表
     * 
     * @param representWorkRanking 排行 以及 类型数  总数
     * @return 排行 以及 类型数  总数集合
     */
    public List<RepresentWorkRanking> selectRepresentWorkRankingList(RepresentWorkRanking representWorkRanking);

    /**
     * 新增排行 以及 类型数  总数
     * 
     * @param representWorkRanking 排行 以及 类型数  总数
     * @return 结果
     */
    public int insertRepresentWorkRanking(RepresentWorkRanking representWorkRanking);

    /**
     * 修改排行 以及 类型数  总数
     * 
     * @param representWorkRanking 排行 以及 类型数  总数
     * @return 结果
     */
    public int updateRepresentWorkRanking(RepresentWorkRanking representWorkRanking);

    /**
     * 删除排行 以及 类型数  总数
     * 
     * @param rankingId 排行 以及 类型数  总数主键
     * @return 结果
     */
    public int deleteRepresentWorkRankingByRankingId(Long rankingId);

    /**
     * 批量删除排行 以及 类型数  总数
     * 
     * @param rankingIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteRepresentWorkRankingByRankingIds(Long[] rankingIds);

    public int deleteAll();
}
