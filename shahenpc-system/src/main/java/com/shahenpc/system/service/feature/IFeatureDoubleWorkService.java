package com.shahenpc.system.service.feature;

import java.util.List;

import com.shahenpc.common.core.domain.AjaxResult;
import com.shahenpc.system.domain.feature.FeatureDoubleWork;
import com.shahenpc.system.domain.feature.dto.*;

/**
 * 双联工作Service接口
 * 
 * @author ruoyi
 * @date 2022-07-13
 */
public interface IFeatureDoubleWorkService 
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
     * 批量删除双联工作
     * 
     * @param doubleIds 需要删除的双联工作主键集合
     * @return 结果
     */
    public int deleteFeatureDoubleWorkByDoubleIds(Long[] doubleIds);

    /**
     * 删除双联工作信息
     * 
     * @param doubleId 双联工作主键
     * @return 结果
     */
    public int deleteFeatureDoubleWorkByDoubleId(Long doubleId);

    public List<FeatureCakeDto> speCake();

    public List<FeatureCakeDto> statusCount();

    public DoubleStatusCountDto selectByStatusCount();

    public List<String> heatmap();

    public List<FeatureMonthDto> selectByMonth();

    public AjaxResult newAdd(FeatureDoubleWork featureDoubleWork);

    public AjaxResult newUpdate(FeatureDoubleWork featureDoubleWork);

    //public FeatureDoubleWork  newDetail(Long doubleId);

    public int appNewAdd(FeatureDoubleWork featureDoubleWork);
    //误伤 这是 活动列表 上的
    public FeatureEachCount eachCount();
    //两个率
    public FeatureRing ring();
    //曲线
    public FeatureLineDto line();

    public List<DoubleAppListDto> appList(FeatureDoubleWork featureDoubleWork);

    public List<DoubleListDto> adminList(FeatureDoubleWork featureDoubleWork);


    public DoubleCountRanDto countAndranking(Long userId);
}
