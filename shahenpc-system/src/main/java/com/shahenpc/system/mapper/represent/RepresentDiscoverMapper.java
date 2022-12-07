package com.shahenpc.system.mapper.represent;

import java.util.List;
import com.shahenpc.system.domain.represent.RepresentDiscover;
import com.shahenpc.system.domain.represent.dto.*;

/**
 * 代-代发现Mapper接口
 * 
 * @author ruoyi
 * @date 2022-07-28
 */
public interface RepresentDiscoverMapper 
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
    public int insertRepresentDiscover(RepresentDiscover representDiscover);

    /**
     * 修改代-代发现
     * 
     * @param representDiscover 代-代发现
     * @return 结果
     */
    public int updateRepresentDiscover(RepresentDiscover representDiscover);

    /**
     * 删除代-代发现
     * 
     * @param discoverId 代-代发现主键
     * @return 结果
     */
    public int deleteRepresentDiscoverByDiscoverId(Long discoverId);

    /**
     * 批量删除代-代发现
     * 
     * @param discoverIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteRepresentDiscoverByDiscoverIds(Long[] discoverIds);

    public List<DiscoverAppListDto> appList(RepresentDiscover representDiscover);

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

    public DiscoverAppDetailDto appDetail(Long discoverId);

    public DiscoverDetailDto detail(Long discoverId);

    public List<DiscoverListDto> adminList(RepresentDiscover representDiscover);

    public Integer getCount();

    public DiscoverRingDto selectByRate();

    public List<RepresentDiscover> selectRepresentStatusList();

    public DiscoverStatusCountDto selectByStatusCount();

    public Integer selectByTotal();

    public List<String> selectByLocation();




    public List<DiscoverAppListDto> translateList(Long stationId);


    public List<DiscoverRankingDto> selectByGeRenRanking();

    public List<DiscoverContactRankingDto> selectByContactRanking();

    public List<DiscoverContactRankingDto> selectByContactbaifenlvRanking();

    public DiscoverTotalRenLVDto selectByTotalLv();

    public List<DiscoverUserIdDto> selectByReceiveUserId(Long userId);

    public List<RepresentDiscover> selectByUserId(Long userId);

    public  List<DiscoverRankingDto> selectByExportRanking();
}
