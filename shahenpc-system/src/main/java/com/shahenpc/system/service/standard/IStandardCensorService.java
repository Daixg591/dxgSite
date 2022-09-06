package com.shahenpc.system.service.standard;

import java.util.List;

import com.shahenpc.common.core.domain.AjaxResult;
import com.shahenpc.system.domain.represent.dto.MotionLingDto;
import com.shahenpc.system.domain.represent.dto.MotionPieDto;
import com.shahenpc.system.domain.represent.vo.MotionTaskVo;
import com.shahenpc.system.domain.standard.StandardCensor;
import com.shahenpc.system.domain.standard.dto.CemsorDetailDto;
import com.shahenpc.system.domain.standard.vo.CensorAddVo;
import com.shahenpc.system.domain.standard.vo.CensorUpdateVo;

/**
 * 审查流程Service接口
 * 
 * @author ruoyi
 * @date 2022-07-22
 */
public interface IStandardCensorService 
{
    /**
     * 查询审查流程
     * 
     * @param processId 审查流程主键
     * @return 审查流程
     */
    public StandardCensor selectStandardCensorByProcessId(Long processId);

    /**
     * 查询审查流程列表
     * 
     * @param standardCensor 审查流程
     * @return 审查流程集合
     */
    public List<StandardCensor> selectStandardCensorList(StandardCensor standardCensor);

    /**
     * 待办
     * @param request
     * @return
     */
    public List<StandardCensor> selectByTodoList(StandardCensor request);

    /**
     * 已办
     * @param userId
     * @return
     */
    public List<StandardCensor> selectByDoneList(Long userId);
    /**
     * 新增审查流程
     * 
     * @param standardCensor 审查流程
     * @return 结果
     */
    public AjaxResult insertStandardCensor(CensorAddVo standardCensor);

    /**
     * 修改审查流程
     * 
     * @param standardCensor 审查流程
     * @return 结果
     */
    public AjaxResult updateStandardCensor(CensorUpdateVo standardCensor);

    /**
     * 批量删除审查流程
     * 
     * @param processIds 需要删除的审查流程主键集合
     * @return 结果
     */
    public int deleteStandardCensorByProcessIds(Long[] processIds);

    /**
     * 删除审查流程信息
     * 
     * @param processId 审查流程主键
     * @return 结果
     */
    public int deleteStandardCensorByProcessId(Long processId);

    /**
     *
     * @param processId
     * @return
     */
    public StandardCensor selectByProcessId(String processId);

    public CemsorDetailDto selectByCensorId(Long cemsorId);

    /**
     * 落实率
     * @param
     * @return
     */
    String ring();
    /**
     * 按类别饼图
     * @param
     * @return
     */
    List<MotionPieDto> pie();
    /**
     * 曲线
     * @param
     * @return
     */
    MotionLingDto line();

}
