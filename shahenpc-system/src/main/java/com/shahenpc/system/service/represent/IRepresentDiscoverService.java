package com.shahenpc.system.service.represent;

import java.util.List;

import com.shahenpc.common.core.domain.AjaxResult;
import com.shahenpc.system.domain.represent.RepresentDiscover;
import com.shahenpc.system.domain.represent.dto.*;
import com.shahenpc.system.domain.represent.vo.DiscoverFallbackVo;
import com.shahenpc.system.domain.represent.vo.DiscoverUpdateVo;

/**
 * 代-代发现Service接口
 * 
 * @author ruoyi
 * @date 2022-07-28
 */
public interface IRepresentDiscoverService 
{
    /**
     * 查询代-代发现
     * 
     * @param discoverId 代-代发现主键
     * @return 代-代发现
     */
    public RepresentDiscover selectRepresentDiscoverByDiscoverId(Long discoverId);

    /**
     * 查询代-代发现列表
     * 
     * @param representDiscover 代-代发现
     * @return 代-代发现集合
     */
    public List<RepresentDiscover> selectRepresentDiscoverList(RepresentDiscover representDiscover);

    /**
     * 新增代-代发现
     * 
     * @param representDiscover 代-代发现
     * @return 结果
     */
    public AjaxResult insertRepresentDiscover(RepresentDiscover representDiscover);

    /**
     * 修改代-代发现
     * 
     * @param representDiscover 代-代发现
     * @return 结果
     */
    public AjaxResult updateRepresentDiscover(DiscoverUpdateVo representDiscover);

    /**
     * 批量删除代-代发现
     * 
     * @param discoverIds 需要删除的代-代发现主键集合
     * @return 结果
     */
    public int deleteRepresentDiscoverByDiscoverIds(Long[] discoverIds);

    /**
     * 删除代-代发现信息
     * 
     * @param discoverId 代-代发现主键
     * @return 结果
     */
    public int deleteRepresentDiscoverByDiscoverId(Long discoverId);

    /**
     * 已办
     * @param sendUserId
     * @return
     */
    public List<DiscoverAppListDto> doneList(Long sendUserId);

    /**
     * 待办
     * @param representDiscover
     * @return
     */
    public List<DiscoverAppListDto> todoList(RepresentDiscover representDiscover);
    /***/
    public List<DiscoverAppListDto> appList(RepresentDiscover representDiscover);

    public DiscoverAppDetailDto appDetail(Long discoverId);
    /** 列表*/
    public List<DiscoverListDto> adminList(RepresentDiscover representDiscover);
    /**详情*/
    public DiscoverDetailDto detail(Long discoverId);
    /**环*/
    public DiscoverRingDto ring();
    /**曲线*/
    public DiscoverLineDto line();
    /**饼图*/
    public List<DiscoverPieDto> pie();

    public List<DiscoverPieDto> statusPie();

    public List<DiscoverPieDto> statusCount();

    public DiscoverStatusCountDto selectByStatusCount();

    public List<DiscoverPieDto> funnel();

    public List<String> heatmap();


    public AjaxResult fallback(DiscoverFallbackVo fallbackVo);


    /**
     * 督查列表
     * @param userId
     * @return
     */
    public List<DiscoverAppListDto> translateList(Long userId);

    public List<DiscoverRankingDto> ranking();

    public List<DiscoverContactRankingDto> contactRanking();

    public List<DiscoverContactRankingDto> contactBaiFenLvRanking();

    public DiscoverTotalRenLVDto selectByTotalLv();
}
