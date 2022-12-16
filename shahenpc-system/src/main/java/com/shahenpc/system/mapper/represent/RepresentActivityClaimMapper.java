package com.shahenpc.system.mapper.represent;

import java.util.List;
import com.shahenpc.system.domain.represent.RepresentActivityClaim;
import com.shahenpc.system.domain.represent.RepresentActivityRecord;

/**
 * 【活动分组认领记录】Mapper接口
 * 
 * @author ruoyi
 * @date 2022-12-15
 */
public interface RepresentActivityClaimMapper 
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
     * 删除【活动分组认领记录】
     * 
     * @param claimId 【活动分组认领记录】主键
     * @return 结果
     */
    public int deleteRepresentActivityClaimByClaimId(Long claimId);

    /**
     * 批量删除【活动分组认领记录】
     * 
     * @param claimIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteRepresentActivityClaimByClaimIds(Long[] claimIds);

    public int insertList(List<RepresentActivityClaim> list);

    public RepresentActivityClaim selectRepresentActivityClaim(RepresentActivityClaim claim);

    public int deleteByActivityId(Long activityId);

    public List<RepresentActivityClaim> selectClaimList(RepresentActivityClaim claim);

    public int npcClaim( RepresentActivityClaim claim);
}
