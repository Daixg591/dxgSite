package com.shahenpc.system.service.represent;

import java.util.List;
import com.shahenpc.system.domain.represent.RepresentProposal;
import com.shahenpc.system.domain.represent.dto.ProposalRingDto;

/**
 * 代-建议Service接口
 *
 * @author ruoyi
 * @date 2022-09-20
 */
public interface IRepresentProposalService
{
    /**
     * 查询代-建议
     *
     * @param proposalId 代-建议主键
     * @return 代-建议
     */
    public RepresentProposal selectRepresentProposalByProposalId(Long proposalId);

    /**
     * 查询代-建议列表
     *
     * @param representProposal 代-建议
     * @return 代-建议集合
     */
    public List<RepresentProposal> selectRepresentProposalList(RepresentProposal representProposal);

    /**
     * 新增代-建议
     *
     * @param representProposal 代-建议
     * @return 结果
     */
    public int insertRepresentProposal(RepresentProposal representProposal);

    /**
     * 修改代-建议
     *
     * @param representProposal 代-建议
     * @return 结果
     */
    public int updateRepresentProposal(RepresentProposal representProposal);

    /**
     * 批量删除代-建议
     *
     * @param proposalIds 需要删除的代-建议主键集合
     * @return 结果
     */
    public int deleteRepresentProposalByProposalIds(Long[] proposalIds);

    /**
     * 删除代-建议信息
     *
     * @param proposalId 代-建议主键
     * @return 结果
     */
    public int deleteRepresentProposalByProposalId(Long proposalId);


    public ProposalRingDto concludeRing();
    public ProposalRingDto satisfiedRing();
}
