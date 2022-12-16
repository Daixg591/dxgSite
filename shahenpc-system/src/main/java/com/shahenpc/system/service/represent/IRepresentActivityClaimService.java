package com.shahenpc.system.service.represent;

import java.util.List;
import com.shahenpc.system.domain.represent.RepresentActivityClaim;

/**
 * 【活动分组认领记录】Service接口
 * 
 * @author ruoyi
 * @date 2022-12-15
 */
public interface IRepresentActivityClaimService 
{
    /**
     * 查询【活动分组认领记录】
     * 
     * @param claimId 【活动分组认领记录】主键
     * @return 【活动分组认领记录】
     */
    public RepresentActivityClaim selectRepresentActivityClaimByClaimId(Long claimId);

    /**
     * 查询【活动分组认领记录】列表
     * 
     * @param representActivityClaim 【活动分组认领记录】
     * @return 【活动分组认领记录】集合
     */
    public List<RepresentActivityClaim> selectRepresentActivityClaimList(RepresentActivityClaim representActivityClaim);

    /**
     * 新增【活动分组认领记录】
     * 
     * @param representActivityClaim 【活动分组认领记录】
     * @return 结果
     */
    public int insertRepresentActivityClaim(RepresentActivityClaim representActivityClaim);

    /**
     * 修改【活动分组认领记录】
     * 
     * @param representActivityClaim 【活动分组认领记录】
     * @return 结果
     */
    public int updateRepresentActivityClaim(RepresentActivityClaim representActivityClaim);

    /**
     * 批量删除【活动分组认领记录】
     * 
     * @param claimIds 需要删除的【活动分组认领记录】主键集合
     * @return 结果
     */
    public int deleteRepresentActivityClaimByClaimIds(Long[] claimIds);

    /**
     * 删除【活动分组认领记录】信息
     * 
     * @param claimId 【活动分组认领记录】主键
     * @return 结果
     */
    public int deleteRepresentActivityClaimByClaimId(Long claimId);


    /**
     * 新增【活动分组认领记录】列表
     * @param list 【活动分组认领记录】列表
     * @return 结果
     */
    public int insertList(List<RepresentActivityClaim> list);

    /**
     * 根据指定条件，查询【活动分组认领记录】实体
     * @param claim 【活动分组认领记录】实体
     * @return 结果
     */
    public RepresentActivityClaim selectRepresentActivityClaim(RepresentActivityClaim claim);

    /**
     * 根据活动Id，删除【活动分组认领记录】
     * @param activityId 活动id
     * @return  结果
     */
    public int deleteByActivityId(Long activityId);

    /**
     * 新列表
     * @param claim
     * @return
     */
    public List<RepresentActivityClaim> selectClaimList(RepresentActivityClaim claim);

    /**
     * 代表认领
     * @param claim claim实体类
     * @return  结果
     */
    public int npcClaim( RepresentActivityClaim claim);
}
