package com.shahenpc.flowable.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.shahenpc.flowable.domain.ActHiTaskInst;
import com.shahenpc.flowable.service.IActHiTaskInstService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Map;
import java.util.function.Function;

@Service
public class IActHiTaskInstServiceImpl implements IActHiTaskInstService {
    @Override
    public boolean saveBatch(Collection<ActHiTaskInst> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean saveOrUpdateBatch(Collection<ActHiTaskInst> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean updateBatchById(Collection<ActHiTaskInst> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean saveOrUpdate(ActHiTaskInst entity) {
        return false;
    }

    @Override
    public ActHiTaskInst getOne(Wrapper<ActHiTaskInst> queryWrapper, boolean throwEx) {
        return null;
    }

    @Override
    public Map<String, Object> getMap(Wrapper<ActHiTaskInst> queryWrapper) {
        return null;
    }

    @Override
    public <V> V getObj(Wrapper<ActHiTaskInst> queryWrapper, Function<? super Object, V> mapper) {
        return null;
    }

    @Override
    public BaseMapper<ActHiTaskInst> getBaseMapper() {
        return null;
    }

    @Override
    public Class<ActHiTaskInst> getEntityClass() {
        return null;
    }
}
