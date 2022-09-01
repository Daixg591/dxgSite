package com.shahenpc.flowable.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.shahenpc.flowable.domain.ActTaskNode;
import com.shahenpc.flowable.service.IActTaskNodeService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

@Service
public class IActTaskNodeServiceImpl implements IActTaskNodeService {
    @Override
    public List<ActTaskNode> getListByInstanceId(String processInstanceId) {
        return null;
    }

    @Override
    public ActTaskNode getListByInstanceIdAndNodeId(String processInstanceId, String nodeId) {
        return null;
    }

    @Override
    public Boolean deleteBackTaskNode(String processInstanceId, String targetActivityId) {
        return null;
    }

    @Override
    public Boolean deleteByInstanceId(String processInstanceId) {
        return null;
    }

    @Override
    public void saveTaskNode(ActTaskNode actTaskNode) {

    }

    @Override
    public boolean saveBatch(Collection<ActTaskNode> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean saveOrUpdateBatch(Collection<ActTaskNode> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean updateBatchById(Collection<ActTaskNode> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean saveOrUpdate(ActTaskNode entity) {
        return false;
    }

    @Override
    public ActTaskNode getOne(Wrapper<ActTaskNode> queryWrapper, boolean throwEx) {
        return null;
    }

    @Override
    public Map<String, Object> getMap(Wrapper<ActTaskNode> queryWrapper) {
        return null;
    }

    @Override
    public <V> V getObj(Wrapper<ActTaskNode> queryWrapper, Function<? super Object, V> mapper) {
        return null;
    }

    @Override
    public BaseMapper<ActTaskNode> getBaseMapper() {
        return null;
    }

    @Override
    public Class<ActTaskNode> getEntityClass() {
        return null;
    }
}
