package com.shahenpc.system.service.message.impl;

import java.util.List;
import com.shahenpc.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shahenpc.system.mapper.message.MessageReadDelMapper;
import com.shahenpc.system.domain.message.MessageReadDel;
import com.shahenpc.system.service.message.IMessageReadDelService;

/**
 * 消息已读或者删除Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-07-07
 */
@Service
public class MessageReadDelServiceImpl implements IMessageReadDelService 
{
    @Autowired
    private MessageReadDelMapper messageReadDelMapper;

    /**
     * 查询消息已读或者删除
     * 
     * @param id 消息已读或者删除主键
     * @return 消息已读或者删除
     */
    @Override
    public MessageReadDel selectMessageReadDelById(Long id)
    {
        return messageReadDelMapper.selectMessageReadDelById(id);
    }

    /**
     * 查询消息已读或者删除列表
     * 
     * @param messageReadDel 消息已读或者删除
     * @return 消息已读或者删除
     */
    @Override
    public List<MessageReadDel> selectMessageReadDelList(MessageReadDel messageReadDel)
    {
        return messageReadDelMapper.selectMessageReadDelList(messageReadDel);
    }

    /**
     * 新增消息已读或者删除
     * 
     * @param messageReadDel 消息已读或者删除
     * @return 结果
     */
    @Override
    public int insertMessageReadDel(MessageReadDel messageReadDel)
    {
        messageReadDel.setCreateTime(DateUtils.getNowDate());
        return messageReadDelMapper.insertMessageReadDel(messageReadDel);
    }

    /**
     * 修改消息已读或者删除
     * 
     * @param messageReadDel 消息已读或者删除
     * @return 结果
     */
    @Override
    public int updateMessageReadDel(MessageReadDel messageReadDel)
    {
        messageReadDel.setUpdateTime(DateUtils.getNowDate());
        return messageReadDelMapper.updateMessageReadDel(messageReadDel);
    }

    /**
     * 批量删除消息已读或者删除
     * 
     * @param ids 需要删除的消息已读或者删除主键
     * @return 结果
     */
    @Override
    public int deleteMessageReadDelByIds(Long[] ids)
    {
        return messageReadDelMapper.deleteMessageReadDelByIds(ids);
    }

    /**
     * 删除消息已读或者删除信息
     * 
     * @param id 消息已读或者删除主键
     * @return 结果
     */
    @Override
    public int deleteMessageReadDelById(Long id)
    {
        return messageReadDelMapper.deleteMessageReadDelById(id);
    }
}
