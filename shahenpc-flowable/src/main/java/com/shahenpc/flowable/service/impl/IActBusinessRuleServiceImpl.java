package com.shahenpc.flowable.service.impl;

import com.shahenpc.common.core.domain.PageQuery;
import com.shahenpc.common.core.page.TableDataInfo;
import com.shahenpc.flowable.domain.bo.ActBusinessRuleBo;
import com.shahenpc.flowable.domain.vo.ActBusinessRuleVo;
import com.shahenpc.flowable.service.IActBusinessRuleService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class IActBusinessRuleServiceImpl implements IActBusinessRuleService {
    @Override
    public ActBusinessRuleVo queryById(Long id) {
        return null;
    }

    @Override
    public TableDataInfo<ActBusinessRuleVo> queryPageList(ActBusinessRuleBo bo, PageQuery pageQuery) {
        return null;
    }

    @Override
    public List<ActBusinessRuleVo> queryList(ActBusinessRuleBo bo) {
        return null;
    }

    @Override
    public Boolean insertByBo(ActBusinessRuleBo bo) {
        return null;
    }

    @Override
    public Boolean updateByBo(ActBusinessRuleBo bo) {
        return null;
    }

    @Override
    public Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid) {
        return null;
    }
}
