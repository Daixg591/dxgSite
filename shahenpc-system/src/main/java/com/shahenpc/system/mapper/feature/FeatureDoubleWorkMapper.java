package com.shahenpc.system.mapper.feature;

import java.util.List;
import com.shahenpc.system.domain.feature.FeatureDoubleWork;
import com.shahenpc.system.domain.feature.dto.*;

/**
 * 双联工作Mapper接口
 * 
 * @author ruoyi
 * @date 2022-07-13
 */
public interface FeatureDoubleWorkMapper 
{
    /**
     * 查询双联工作
     * 
     * @param doubleId 双联工作主键
     * @return 双联工作
     */
    public FeatureDoubleWork selectFeatureDoubleWorkByDoubleId(Long doubleId);

    /**
     * 查询双联工作列表
     * 
     * @param featureDoubleWork 双联工作
     * @return 双联工作集合
     */
    public List<FeatureDoubleWork> selectFeatureDoubleWorkList(FeatureDoubleWork featureDoubleWork);

    /**
     * 新增双联工作
     * 
     * @param featureDoubleWork 双联工作
     * @return 结果
     */
    public int insertFeatureDoubleWork(FeatureDoubleWork featureDoubleWork);

    /**
     * 修改双联工作
     * 
     * @param featureDoubleWork 双联工作
     * @return 结果
     */
    public int updateFeatureDoubleWork(FeatureDoubleWork featureDoubleWork);

    /**
     * 删除双联工作
     * 
     * @param doubleId 双联工作主键
     * @return 结果
     */
    public int deleteFeatureDoubleWorkByDoubleId(Long doubleId);

    /**
     * 待办
     */
    public List<FeatureDoubleWork> selectByTodoList(FeatureDoubleWork request);
    /**
     * 已办
     */
    public List<FeatureDoubleWork> selectByDoneList(FeatureDoubleWork request);
    /**
     * 详情
     * @param doubleId
     * @return
     */
    public DoubleDetatilDto adminDateil(Long doubleId);
    /**
     * 批量删除双联工作
     * 
     * @param doubleIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteFeatureDoubleWorkByDoubleIds(Long[] doubleIds);

    public List<FeatureDoubleWork> selectByCakeType();

    public List<FeatureMonthDto> selectByMonth();

    public FeatureEachCount eachCount();

    public FeatureRing selectByRing();

    public Integer getCount();

    public List<DoubleAppListDto> appList(FeatureDoubleWork featureDoubleWork);

    public List<DoubleListDto> adminList(FeatureDoubleWork featureDoubleWork);

    public DoubleCountRanDto selectByCountRanking(Long userId);

    public DoubleStatusCountDto selectByStatusCount();

    public Integer selectByTotal();

    public List<String> selectByLocation();
}
