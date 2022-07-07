package com.shahenpc.system.service.message.impl;

import java.util.List;
import com.shahenpc.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shahenpc.system.mapper.message.MessageDataMapper;
import com.shahenpc.system.domain.message.MessageData;
import com.shahenpc.system.service.message.IMessageDataService;

/**
 * 消息Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-07-07
 */
@Service
public class MessageDataServiceImpl implements IMessageDataService 
{
    @Autowired
    private MessageDataMapper messageDataMapper;

    /**
     * 查询消息
     * 
     * @param id 消息主键
     * @return 消息
     */
    @Override
    public MessageData selectMessageDataById(Long id)
    {
        return messageDataMapper.selectMessageDataById(id);
    }

    /**
     * 查询消息列表
     * 
     * @param messageData 消息
     * @return 消息
     */
    @Override
    public List<MessageData> selectMessageDataList(MessageData messageData)
    {
        return messageDataMapper.selectMessageDataList(messageData);
    }

    /**
     * 新增消息
     * 
     * @param messageData 消息
     * @return 结果
     */
    @Override
    public int insertMessageData(MessageData messageData)
    {
        messageData.setCreateTime(DateUtils.getNowDate());
        return messageDataMapper.insertMessageData(messageData);
    }

    /**
     * 修改消息
     * 
     * @param messageData 消息
     * @return 结果
     */
    @Override
    public int updateMessageData(MessageData messageData)
    {
        messageData.setUpdateTime(DateUtils.getNowDate());
        return messageDataMapper.updateMessageData(messageData);
    }

    /**
     * 批量删除消息
     * 
     * @param ids 需要删除的消息主键
     * @return 结果
     */
    @Override
    public int deleteMessageDataByIds(Long[] ids)
    {
        return messageDataMapper.deleteMessageDataByIds(ids);
    }

    /**
     * 删除消息信息
     * 
     * @param id 消息主键
     * @return 结果
     */
    @Override
    public int deleteMessageDataById(Long id)
    {
        return messageDataMapper.deleteMessageDataById(id);
    }
}
