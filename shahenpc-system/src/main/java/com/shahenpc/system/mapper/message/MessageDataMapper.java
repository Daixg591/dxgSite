package com.shahenpc.system.mapper.message;

import java.util.List;
import com.shahenpc.system.domain.message.MessageData;

/**
 * 消息Mapper接口
 * 
 * @author ruoyi
 * @date 2022-07-07
 */
public interface MessageDataMapper 
{
    /**
     * 查询消息
     * 
     * @param id 消息主键
     * @return 消息
     */
    public MessageData selectMessageDataById(Long id);

    /**
     * 查询消息列表
     * 
     * @param messageData 消息
     * @return 消息集合
     */
    public List<MessageData> selectMessageDataList(MessageData messageData);

    /**
     * 新增消息
     * 
     * @param messageData 消息
     * @return 结果
     */
    public int insertMessageData(MessageData messageData);

    /**
     * 修改消息
     * 
     * @param messageData 消息
     * @return 结果
     */
    public int updateMessageData(MessageData messageData);

    /**
     * 删除消息
     * 
     * @param id 消息主键
     * @return 结果
     */
    public int deleteMessageDataById(Long id);

    /**
     * 批量删除消息
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteMessageDataByIds(Long[] ids);
}
