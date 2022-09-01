package com.shahenpc.flowable.service.impl;


import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.shahenpc.common.core.domain.PageQuery;
import com.shahenpc.common.core.domain.entity.SysUser;
import com.shahenpc.common.core.page.TableDataInfo;
import com.shahenpc.common.helper.LoginHelper;
import com.shahenpc.flowable.domain.SysMessage;
import com.shahenpc.flowable.domain.SysMessageVo;
import com.shahenpc.flowable.domain.bo.SysMessageBo;
import com.shahenpc.flowable.mapper.SysMessageMapper;
import com.shahenpc.flowable.service.ISysMessageService;
import com.shahenpc.system.mapper.SysUserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 消息通知Service业务层处理
 *
 * @author gssong
 * @date 2022-06-17
 */
@RequiredArgsConstructor
@Service
public class ISysMessageServiceImpl  implements ISysMessageService {
    private final SysMessageMapper baseMapper;
    private final SysUserMapper sysUserMapper;

    /**
     * 查询消息通知
     *
     * @param id 消息通知主键
     * @return 消息通知
     */
    @Override
    public SysMessageVo queryById(Long id) {
        //baseMapper.selectVoById(id)
        return null;
    }

    /**
     * 查询消息通知列表
     *
     * @param bo 消息通知
     * @return 消息通知
     */
    @Override
    public TableDataInfo<SysMessageVo> queryPageList(SysMessageBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<SysMessage> lqw = buildQueryWrapper(bo);
        //baseMapper.selectVoPage(pageQuery.build(), lqw)
        Page<SysMessageVo> result = null;
        if (CollectionUtil.isNotEmpty(result.getRecords())) {
            List<Long> userIds = result.getRecords().stream().map(SysMessageVo::getSendId).collect(Collectors.toList());
            List<Long> recordIds = result.getRecords().stream().map(SysMessageVo::getRecordId).collect(Collectors.toList());
            userIds.addAll(recordIds);
            LambdaQueryWrapper<SysUser> wrapper = new LambdaQueryWrapper<>();
            wrapper.in(SysUser::getUserId, userIds);
            //sysUserMapper.selectList(wrapper)
            List<SysUser> sysUsers = null;
            result.getRecords().forEach(e -> {
                SysUser recordUser = sysUsers.stream().filter(t -> t.getUserId().compareTo(e.getRecordId()) == 0).findFirst().orElse(null);
                SysUser sendUser = sysUsers.stream().filter(t -> t.getUserId().compareTo(e.getSendId()) == 0).findFirst().orElse(null);
                if (ObjectUtil.isNotEmpty(recordUser)) {
                    e.setRecordName(recordUser.getNickName());
                }
                if (ObjectUtil.isNotEmpty(sendUser)) {
                    e.setSendName(sendUser.getNickName());
                }
            });
        }
        return TableDataInfo.build(result);
    }

    /**
     * 查询消息通知列表
     *
     * @return 消息通知
     */
    @Override
    public TableDataInfo<SysMessageVo> queryPage() {
        PageQuery pageQuery = new PageQuery();
        pageQuery.setPageNum(1);
        pageQuery.setPageSize(3);
        LambdaQueryWrapper<SysMessage> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(SysMessage::getStatus, false);
        wrapper.eq(SysMessage::getRecordId, LoginHelper.getUserId());
        //baseMapper.selectVoPage(pageQuery.build(), wrapper)
        Page<SysMessageVo> result = null;
        return TableDataInfo.build(result);
    }

    /**
     * 查询消息通知列表
     *
     * @param bo 消息通知
     * @return 消息通知
     */
    @Override
    public List<SysMessageVo> queryList(SysMessageBo bo) {
        LambdaQueryWrapper<SysMessage> lqw = buildQueryWrapper(bo);
        //baseMapper.selectVoList(lqw)
        return null;
    }

    private LambdaQueryWrapper<SysMessage> buildQueryWrapper(SysMessageBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<SysMessage> lqw = Wrappers.lambdaQuery();
        if (!LoginHelper.isAdmin()) {
            lqw.eq(SysMessage::getRecordId, LoginHelper.getUserId());
        }
        lqw.eq(bo.getSendId() != null, SysMessage::getSendId, bo.getSendId());
        lqw.eq(bo.getRecordId() != null, SysMessage::getRecordId, bo.getRecordId());
        lqw.eq(bo.getType() != null, SysMessage::getType, bo.getType());
        lqw.eq(bo.getStatus() != null, SysMessage::getStatus, bo.getStatus());
        lqw.like(StringUtils.isNotBlank(bo.getMessageContent()), SysMessage::getMessageContent, bo.getMessageContent());
        lqw.between(params.get("beginReadTime") != null && params.get("endReadTime") != null,
                SysMessage::getReadTime, params.get("beginReadTime"), params.get("endReadTime"));
        return lqw;
    }

    /**
     * 发送消息通知
     *
     * @param bo 消息通知
     * @return 结果
     */
    @Override
    public Boolean sendMessage(SysMessageBo bo) {
        SysMessage add = BeanUtil.toBean(bo, SysMessage.class);
        //baseMapper.insert(add) > 0
        boolean flag = false;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 批量发送消息通知
     *
     * @param messageList 消息通知
     * @return 结果
     */
    @Override
    public Boolean sendBatchMessage(List<SysMessage> messageList) {
        //baseMapper.insertBatch(messageList);
        return null;
    }

    /**
     * 修改消息通知
     *
     * @param bo 消息通知
     * @return 结果
     */
    @Override
    public Boolean updateMessage(SysMessageBo bo) {
        SysMessage update = BeanUtil.toBean(bo, SysMessage.class);
        //baseMapper.updateById(update) > 0
        return null;
    }

    /**
     * 批量修改消息通知
     *
     * @param messageList 消息通知
     * @return 结果
     */
    @Override
    public Boolean updateBatchMessage(List<SysMessage> messageList) {
        //baseMapper.updateBatchById(messageList)
        return false;
    }

    /**
     * 批量删除消息通知
     *
     * @param ids 需要删除的消息通知主键
     * @return 结果
     */
    @Override
    public Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid) {
        //baseMapper.deleteBatchIds(ids) > 0
        return false;
    }

    /**
     * @Description: 阅读消息
     * @param: id
     * @return: java.lang.Boolean
     * @author: gssong
     * @Date: 2022/6/19 17:11
     */
    @Override
    public Boolean readMessage(Long id) {
        //baseMapper.selectById(id)
        SysMessage sysMessage = null;
        sysMessage.setStatus(1);
        sysMessage.setReadTime(new Date());
        //baseMapper.updateById(sysMessage) > 0;
        return false;
    }

    /**
     * @Description: 批量阅读消息
     * @return: boolean
     * @author: gssong
     * @Date: 2022/6/19 17:16
     */
    @Override
    public boolean batchReadMessage() {
        LambdaQueryWrapper<SysMessage> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(SysMessage::getRecordId, LoginHelper.getUserId());
        //baseMapper.selectList(wrapper)
        List<SysMessage> messageList = null;
        messageList.forEach(e -> {
            e.setStatus(1);
            e.setReadTime(new Date());
        });
        //baseMapper.updateBatchById(messageList)
        return false;
    }
}