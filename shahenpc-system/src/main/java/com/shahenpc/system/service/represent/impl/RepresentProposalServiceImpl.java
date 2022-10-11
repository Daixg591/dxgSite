package com.shahenpc.system.service.represent.impl;

import java.util.List;
import com.shahenpc.common.utils.DateUtils;
import com.shahenpc.system.domain.represent.dto.ProposalRingDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shahenpc.system.mapper.represent.RepresentProposalMapper;
import com.shahenpc.system.domain.represent.RepresentProposal;
import com.shahenpc.system.service.represent.IRepresentProposalService;

/**
 * 代-建议Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-09-20
 */
@Service
public class RepresentProposalServiceImpl implements IRepresentProposalService 
{
    @Autowired
    private RepresentProposalMapper representProposalMapper;

    /**
     * 查询代-建议
     * 
     * @param proposalId 代-建议主键
     * @return 代-建议
     */
    @Override
    public RepresentProposal selectRepresentProposalByProposalId(Long proposalId)
    {
        return representProposalMapper.selectRepresentProposalByProposalId(proposalId);
    }

    /**
     * 查询代-建议列表
     * 
     * @param representProposal 代-建议
     * @return 代-建议
     */
    @Override
    public List<RepresentProposal> selectRepresentProposalList(RepresentProposal representProposal)
    {
        return representProposalMapper.adminList(representProposal);
    }

    /**
     * 新增代-建议
     * 
     * @param representProposal 代-建议
     * @return 结果
     */
    @Override
    public int insertRepresentProposal(RepresentProposal representProposal)
    {
        representProposal.setCreateTime(DateUtils.getNowDate());
        return representProposalMapper.insertRepresentProposal(representProposal);
    }

    /**
     * 修改代-建议
     * 
     * @param representProposal 代-建议
     * @return 结果
     */
    @Override
    public int updateRepresentProposal(RepresentProposal representProposal)
    {
        representProposal.setUpdateTime(DateUtils.getNowDate());
        return representProposalMapper.updateRepresentProposal(representProposal);
    }

    /**
     * 批量删除代-建议
     * 
     * @param proposalIds 需要删除的代-建议主键
     * @return 结果
     */
    @Override
    public int deleteRepresentProposalByProposalIds(Long[] proposalIds)
    {
        return representProposalMapper.deleteRepresentProposalByProposalIds(proposalIds);
    }

    /**
     * 删除代-建议信息
     * 
     * @param proposalId 代-建议主键
     * @return 结果
     */
    @Override
    public int deleteRepresentProposalByProposalId(Long proposalId)
    {
        return representProposalMapper.deleteRepresentProposalByProposalId(proposalId);
    }

    @Override
    public ProposalRingDto concludeRing() {

        return representProposalMapper.selectByConcludeRate();
    }

    @Override
    public ProposalRingDto satisfiedRing() {

        return representProposalMapper.selectBySatisfiedRate();
    }
}
