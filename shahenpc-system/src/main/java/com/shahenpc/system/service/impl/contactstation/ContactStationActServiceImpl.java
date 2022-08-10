package com.shahenpc.system.service.impl.contactstation;

import java.util.List;
import com.shahenpc.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shahenpc.system.mapper.contactstation.ContactStationActMapper;
import com.shahenpc.system.domain.contactstation.ContactStationAct;
import com.shahenpc.system.service.contactstation.IContactStationActService;

/**
 * 联络站活动Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-08-09
 */
@Service
public class ContactStationActServiceImpl implements IContactStationActService 
{
    @Autowired
    private ContactStationActMapper contactStationActMapper;

    /**
     * 查询联络站活动
     * 
     * @param contactStationActId 联络站活动主键
     * @return 联络站活动
     */
    @Override
    public ContactStationAct selectContactStationActByContactStationActId(Long contactStationActId)
    {
        return contactStationActMapper.selectContactStationActByContactStationActId(contactStationActId);
    }

    /**
     * 查询联络站活动列表
     * 
     * @param contactStationAct 联络站活动
     * @return 联络站活动
     */
    @Override
    public List<ContactStationAct> selectContactStationActList(ContactStationAct contactStationAct)
    {
        return contactStationActMapper.selectContactStationActList(contactStationAct);
    }

    /**
     * 新增联络站活动
     * 
     * @param contactStationAct 联络站活动
     * @return 结果
     */
    @Override
    public int insertContactStationAct(ContactStationAct contactStationAct)
    {
        contactStationAct.setCreateTime(DateUtils.getNowDate());
        return contactStationActMapper.insertContactStationAct(contactStationAct);
    }

    /**
     * 修改联络站活动
     * 
     * @param contactStationAct 联络站活动
     * @return 结果
     */
    @Override
    public int updateContactStationAct(ContactStationAct contactStationAct)
    {
        contactStationAct.setUpdateTime(DateUtils.getNowDate());
        return contactStationActMapper.updateContactStationAct(contactStationAct);
    }

    /**
     * 批量删除联络站活动
     * 
     * @param contactStationActIds 需要删除的联络站活动主键
     * @return 结果
     */
    @Override
    public int deleteContactStationActByContactStationActIds(Long[] contactStationActIds)
    {
        return contactStationActMapper.deleteContactStationActByContactStationActIds(contactStationActIds);
    }

    /**
     * 删除联络站活动信息
     * 
     * @param contactStationActId 联络站活动主键
     * @return 结果
     */
    @Override
    public int deleteContactStationActByContactStationActId(Long contactStationActId)
    {
        return contactStationActMapper.deleteContactStationActByContactStationActId(contactStationActId);
    }
}
