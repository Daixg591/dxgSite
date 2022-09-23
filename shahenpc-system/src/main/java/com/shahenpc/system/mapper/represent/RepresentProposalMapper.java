package com.shahenpc.system.mapper.represent;

import java.util.List;
import com.shahenpc.system.domain.represent.RepresentProposal;
import com.shahenpc.system.domain.represent.dto.ProposalRingDto;

/**
 * 代-建议Mapper接口
 * 
 * @author ruoyi
 * @date 2022-09-20
 */
public interface RepresentProposalMapper 
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
    public List<RepresentProposal> adminList(RepresentProposal representProposal);
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
     * 删除代-建议
     * 
     * @param proposalId 代-建议主键
     * @return 结果
     */
    public int deleteRepresentProposalByProposalId(Long proposalId);

    /**
     * 批量删除代-建议
     * 
     * @param proposalIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteRepresentProposalByProposalIds(Long[] proposalIds);

    public ProposalRingDto selectByConcludeRate();

    public ProposalRingDto selectBySatisfiedRate();

    public Integer getCount();




}
