package com.shahenpc.system.mapper.message;

import java.util.List;
import com.shahenpc.system.domain.message.MessageReadDel;

/**
 * 消息已读或者删除Mapper接口
 * 
 * @author ruoyi
 * @date 2022-07-07
 */
public interface MessageReadDelMapper 
{
    /**
     * 查询消息已读或者删除
     * 
     * @param id 消息已读或者删除主键
     * @return 消息已读或者删除
     */
    public MessageReadDel selectMessageReadDelById(Long id);

    /**
     * 查询消息已读或者删除列表
     * 
     * @param messageReadDel 消息已读或者删除
     * @return 消息已读或者删除集合
     */
    public List<MessageReadDel> selectMessageReadDelList(MessageReadDel messageReadDel);

    /**
     * 新增消息已读或者删除
     * 
     * @param messageReadDel 消息已读或者删除
     * @return 结果
     */
    public int insertMessageReadDel(MessageReadDel messageReadDel);

    /**
     * 修改消息已读或者删除
     * 
     * @param messageReadDel 消息已读或者删除
     * @return 结果
     */
    public int updateMessageReadDel(MessageReadDel messageReadDel);

    /**
     * 删除消息已读或者删除
     * 
     * @param id 消息已读或者删除主键
     * @return 结果
     */
    public int deleteMessageReadDelById(Long id);

    /**
     * 批量删除消息已读或者删除
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteMessageReadDelByIds(Long[] ids);
}
