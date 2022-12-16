package com.shahenpc.system.service.represent.impl;

import java.util.List;

import com.shahenpc.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shahenpc.system.mapper.represent.RepresentActivityClaimMapper;
import com.shahenpc.system.domain.represent.RepresentActivityClaim;
import com.shahenpc.system.service.represent.IRepresentActivityClaimService;

/**
 * 【活动分组认领记录】Service业务层处理
 *
 * @author ruoyi
 * @date 2022-12-15
 */
@Service
public class RepresentActivityClaimServiceImpl implements IRepresentActivityClaimService {
    @Autowired
    private RepresentActivityClaimMapper representActivityClaimMapper;

    /**
     * 查询【活动分组认领记录】
     *
     * @param claimId 【活动分组认领记录】主键
     * @return 【活动分组认领记录】
     */
    @Override
    public RepresentActivityClaim selectRepresentActivityClaimByClaimId(Long claimId) {
        return representActivityClaimMapper.selectRepresentActivityClaimByClaimId(claimId);
    }

    /**
     * 查询【活动分组认领记录】列表
     *
     * @param representActivityClaim 【活动分组认领记录】
     * @return 【活动分组认领记录】
     */
    @Override
    public List<RepresentActivityClaim> selectRepresentActivityClaimList(RepresentActivityClaim representActivityClaim) {
        return representActivityClaimMapper.selectRepresentActivityClaimList(representActivityClaim);
    }

    /**
     * 新增【活动分组认领记录】
     *
     * @param representActivityClaim 【活动分组认领记录】
     * @return 结果
     */
    @Override
    public int insertRepresentActivityClaim(RepresentActivityClaim representActivityClaim) {
        representActivityClaim.setCreateTime(DateUtils.getNowDate());
        return representActivityClaimMapper.insertRepresentActivityClaim(representActivityClaim);
    }

    /**
     * 修改【活动分组认领记录】
     *
     * @param representActivityClaim 【活动分组认领记录】
     * @return 结果
     */
    @Override
    public int updateRepresentActivityClaim(RepresentActivityClaim representActivityClaim) {
        representActivityClaim.setUpdateTime(DateUtils.getNowDate());
        return representActivityClaimMapper.updateRepresentActivityClaim(representActivityClaim);
    }

    /**
     * 批量删除【活动分组认领记录】
     *
     * @param claimIds 需要删除的【活动分组认领记录】主键
     * @return 结果
     */
    @Override
    public int deleteRepresentActivityClaimByClaimIds(Long[] claimIds) {
        return representActivityClaimMapper.deleteRepresentActivityClaimByClaimIds(claimIds);
    }

    /**
     * 删除【活动分组认领记录】信息
     *
     * @param claimId 【活动分组认领记录】主键
     * @return 结果
     */
    @Override
    public int deleteRepresentActivityClaimByClaimId(Long claimId) {
        return representActivityClaimMapper.deleteRepresentActivityClaimByClaimId(claimId);
    }

    /**
     * 新增【活动分组认领记录】列表
     *
     * @param list 【活动分组认领记录】列表
     * @return 结果
     */
    @Override
    public int insertList(List<RepresentActivityClaim> list) {
        return representActivityClaimMapper.insertList(list);
    }

    /**
     * 根据指定条件，查询【活动分组认领记录】实体
     *
     * @param claim 【活动分组认领记录】实体
     * @return 结果
     */
    @Override
    public RepresentActivityClaim selectRepresentActivityClaim(RepresentActivityClaim claim) {
        return representActivityClaimMapper.selectRepresentActivityClaim(claim);
    }

    /**
     * 根据活动Id，删除【活动分组认领记录】
     *
     * @param activityId 活动id
     * @return 结果
     */
    @Override
    public int deleteByActivityId(Long activityId) {
        return representActivityClaimMapper.deleteByActivityId(activityId);
    }

    /**
     * 新列表
     *
     * @param claim
     * @return
     */
    @Override
    public List<RepresentActivityClaim> selectClaimList(RepresentActivityClaim claim) {
        return representActivityClaimMapper.selectClaimList(claim);
    }

    /**
     * 代表认领
     * @param claim claim实体参数
     * @return 结果
     */
    @Override
    public int npcClaim(RepresentActivityClaim claim) {
        return representActivityClaimMapper.npcClaim(claim);
    }
}
