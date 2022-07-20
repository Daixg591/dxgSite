package com.shahenpc.system.service.representative;

import java.util.List;
import com.shahenpc.system.domain.representative.PerformNpcOverview;

/**
 * 小程序-信息发布Service接口
 * 
 * @author ruoyi
 * @date 2022-07-08
 */
public interface IPerformNpcOverviewService 
{
    /**
     * 查询小程序-信息发布
     * 
     * @param overviewId 小程序-信息发布主键
     * @return 小程序-信息发布
     */
    public PerformNpcOverview selectPerformNpcOverviewByOverviewId(Long overviewId);

    /**
     * 查询小程序-信息发布列表
     * 
     * @param performNpcOverview 小程序-信息发布
     * @return 小程序-信息发布集合
     */
    public List<PerformNpcOverview> selectPerformNpcOverviewList(PerformNpcOverview performNpcOverview);

    /**
     * 新增小程序-信息发布
     * 
     * @param performNpcOverview 小程序-信息发布
     * @return 结果
     */
    public int insertPerformNpcOverview(PerformNpcOverview performNpcOverview);

    /**
     * 修改小程序-信息发布
     * 
     * @param performNpcOverview 小程序-信息发布
     * @return 结果
     */
    public int updatePerformNpcOverview(PerformNpcOverview performNpcOverview);

    /**
     * 批量删除小程序-信息发布
     * 
     * @param overviewIds 需要删除的小程序-信息发布主键集合
     * @return 结果
     */
    public int deletePerformNpcOverviewByOverviewIds(Long[] overviewIds);

    /**
     * 删除小程序-信息发布信息
     * 
     * @param overviewId 小程序-信息发布主键
     * @return 结果
     */
    public int deletePerformNpcOverviewByOverviewId(Long overviewId);
}
