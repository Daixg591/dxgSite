package com.shahenpc.system.service.contactstation;

import java.util.List;
import com.shahenpc.system.domain.contactstation.ContactStationAct;

/**
 * 联络站活动Service接口
 * 
 * @author ruoyi
 * @date 2022-08-09
 */
public interface IContactStationActService 
{
    /**
     * 查询联络站活动
     * 
     * @param contactStationActId 联络站活动主键
     * @return 联络站活动
     */
    public ContactStationAct selectContactStationActByContactStationActId(Long contactStationActId);

    /**
     * 查询联络站活动列表
     * 
     * @param contactStationAct 联络站活动
     * @return 联络站活动集合
     */
    public List<ContactStationAct> selectContactStationActList(ContactStationAct contactStationAct);

    /**
     * 新增联络站活动
     * 
     * @param contactStationAct 联络站活动
     * @return 结果
     */
    public int insertContactStationAct(ContactStationAct contactStationAct);

    /**
     * 修改联络站活动
     * 
     * @param contactStationAct 联络站活动
     * @return 结果
     */
    public int updateContactStationAct(ContactStationAct contactStationAct);

    /**
     * 批量删除联络站活动
     * 
     * @param contactStationActIds 需要删除的联络站活动主键集合
     * @return 结果
     */
    public int deleteContactStationActByContactStationActIds(Long[] contactStationActIds);

    /**
     * 删除联络站活动信息
     * 
     * @param contactStationActId 联络站活动主键
     * @return 结果
     */
    public int deleteContactStationActByContactStationActId(Long contactStationActId);
}
