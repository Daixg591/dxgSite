package com.shahenpc.web.controller.personel;

import java.util.*;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletResponse;
import javax.swing.plaf.synth.Region;

import com.shahenpc.common.core.domain.entity.SysDictData;
import com.shahenpc.common.core.domain.entity.SysUser;
import com.shahenpc.common.utils.DateUtils;
import com.shahenpc.common.utils.StringUtils;
import com.shahenpc.system.domain.BackVo.PersonalInfo;
import com.shahenpc.system.domain.personel.PersonnelAppointEduLog;
import com.shahenpc.system.domain.personel.dto.PersonnelQueryDto;
import com.shahenpc.system.domain.personel.vo.EchartItemVo;
import com.shahenpc.system.domain.personel.vo.PersonelStatisticsVo;
import com.shahenpc.system.domain.personel.vo.TendencyChart;
import com.shahenpc.system.service.ISysDictDataService;
import com.shahenpc.system.service.ISysUserService;
import com.shahenpc.system.service.personel.IPersonnelAppointEduLogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.joda.time.DateTime;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.shahenpc.common.annotation.Log;
import com.shahenpc.common.core.controller.BaseController;
import com.shahenpc.common.core.domain.AjaxResult;
import com.shahenpc.common.enums.BusinessType;
import com.shahenpc.system.domain.personel.PersonnelAppointRegister;
import com.shahenpc.system.service.personel.IPersonnelAppointRegisterService;
import com.shahenpc.common.utils.poi.ExcelUtil;
import com.shahenpc.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 人事任免_任免记录Controller
 *
 * @author ruoyi
 * @date 2022-07-04
 */
@Api(tags = "人事任免_信息登记 Done √")
@ApiOperation("人事任免_信息登记")
@RestController
@RequestMapping("/system/register")
public class PersonnelAppointRegisterController extends BaseController {
    @Autowired
    private IPersonnelAppointRegisterService personnelAppointRegisterService;

    @Autowired
    private ISysUserService userService;

    @Autowired
    private IPersonnelAppointEduLogService eduLogService;

    @Autowired
    private ISysDictDataService dictDataService;

    /**
     * 查询人事任免_任免记录列表
     */
    @PreAuthorize("@ss.hasPermi('system:register:list')")
    @GetMapping("/list")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "appointType", value = "任免类型", dataType = "Integer", dataTypeClass = String.class),
            @ApiImplicitParam(name = "nickName", value = "人员姓名", dataType = "String", dataTypeClass = String.class),
            @ApiImplicitParam(name = "keyWords", value = "关键词", dataType = "String", dataTypeClass = String.class),
            @ApiImplicitParam(name = "startTime", value = "开始时间", dataType = "String", dataTypeClass = Date.class),
            @ApiImplicitParam(name = "endTime", value = "结束时间", dataType = "String", dataTypeClass = Date.class)
    })
    @ApiOperation("任免列表")
    public TableDataInfo list(PersonnelQueryDto personnelAppointRegister) {
        startPage();
        List<PersonnelAppointRegister> list = personnelAppointRegisterService.selectPersonnelAppointRegisterList(personnelAppointRegister);
        return getDataTable(list);
    }

    /**
     * 导出人事任免_任免记录列表
     */
    @PreAuthorize("@ss.hasPermi('system:register:export')")
    @ApiOperation("批量导出")
    @Log(title = "人事任免_任免记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, PersonnelQueryDto personnelAppointRegister) {
        List<PersonnelAppointRegister> list = personnelAppointRegisterService.selectPersonnelAppointRegisterList(personnelAppointRegister);
        ExcelUtil<PersonnelAppointRegister> util = new ExcelUtil<PersonnelAppointRegister>(PersonnelAppointRegister.class);
        util.exportExcel(response, list, "人事任免_任免记录数据");
    }
    /**
     * 导入人事任免_任免记录列表
     */
    @PreAuthorize("@ss.hasPermi('system:user:import')")
    @ApiOperation("批量导入")
    @Log(title = "人事任免_任免记录", businessType = BusinessType.IMPORT)
    @PostMapping("/importData")
    public AjaxResult importData(MultipartFile file, boolean updateSupport)throws Exception{
        ExcelUtil<PersonnelAppointRegister> util = new ExcelUtil<PersonnelAppointRegister>(PersonnelAppointRegister.class);
        List<PersonnelAppointRegister> userList = util.importExcel(file.getInputStream());
        String operName = getUsername();
        String message = personnelAppointRegisterService.importUser(userList, updateSupport, operName);
        return AjaxResult.success(message);
    }
    /**
     * 获取人事任免_任免记录详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:register:query')")
    @GetMapping(value = "/{registerId}")
    @ApiOperation("任免详情")
    public AjaxResult getInfo(@PathVariable("registerId") Long registerId) {
        PersonnelAppointRegister regEntity = personnelAppointRegisterService.selectPersonnelAppointRegisterByRegisterId(registerId);
        SysUser userEntity = userService.selectUserById(regEntity.getUserId());
        List<PersonnelAppointEduLog> eduList = eduLogService.selectPersonnelAppointEduLogList(null);

        PersonalInfo res = new PersonalInfo();
        res.setRegEntity(regEntity);
        regEntity.setSysUser(userEntity);
//        res.setEduLogList(eduList);

        return AjaxResult.success(res);
    }

    /**
     * 新增人事任免_任免记录
     */
    @PreAuthorize("@ss.hasPermi('system:register:add')")
    @Log(title = "人事任免_任免记录", businessType = BusinessType.INSERT)
    @ApiOperation("新增任免")
    @PostMapping
    public AjaxResult add(@RequestBody PersonnelAppointRegister personnelAppointRegister) {
        personnelAppointRegister.setCreateBy(getUsername());
        personnelAppointRegisterService.insertPersonnelAppointRegister(personnelAppointRegister);
        return AjaxResult.success(personnelAppointRegister.getRegisterId());
    }

    /**
     * 修改人事任免_任免记录
     */
    @ApiOperation("更新任免")
    @PreAuthorize("@ss.hasPermi('system:register:edit')")
    @Log(title = "人事任免_任免记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PersonnelAppointRegister personnelAppointRegister) {
        personnelAppointRegister.setUpdateBy(getUsername());
        return toAjax(personnelAppointRegisterService.updatePersonnelAppointRegister(personnelAppointRegister));
    }

    /**
     * 删除人事任免_任免记录
     */
    @ApiOperation("删除任免")
    @PreAuthorize("@ss.hasPermi('system:register:remove')")
    @Log(title = "人事任免_任免记录", businessType = BusinessType.DELETE)
    @DeleteMapping("/{registerIds}")
    public AjaxResult remove(@PathVariable Long[] registerIds) {
        return toAjax(personnelAppointRegisterService.deletePersonnelAppointRegisterByRegisterIds(registerIds));
    }

    /**
     * 人事任免统计数据集
     *
     * @return
     */
    @ApiOperation("人事任免统计数据集")
    @GetMapping("/statistics")
    public AjaxResult statisticsData() {
        PersonelStatisticsVo res = new PersonelStatisticsVo();
        List<PersonnelAppointRegister> list = personnelAppointRegisterService.selectPersonnelAppointRegisterList(null);
        res.registerCnt = list.size();

        // 1. 任免类型字典列表
        // 2. 循环字典列表,Lambda查询赋值item;
        List<SysDictData> appointmentList = getDictDataList();
        res.pieChart = getPieRes(appointmentList, list);

        // 3. 从当前时间开始,查询最近的六个月份
        // 4. 根据月份查询对应月份的数据值
        res.tendencyChart = getTendencyChart();

        return AjaxResult.success(res);
    }


    //region 统计私有方法


    //region 趋势图统计

    /**
     * 获取最近六个月份  ["2022-07","2022-06","2022-05"...]
     *
     * @return
     */
    public List<String> getNearSixMonth() {
        List<String> resultList = new ArrayList<String>();
        Calendar cal = Calendar.getInstance();
        //近六个月
        //要先+1,才能把本月的算进去
        cal.set(Calendar.MONTH, cal.get(Calendar.MONTH) + 1);
        for (int i = 0; i < 6; i++) {
            //逐次往前推1个月
            cal.set(Calendar.MONTH, cal.get(Calendar.MONTH) - 1);
            resultList.add(String.valueOf(cal.get(Calendar.YEAR))
                    + "-" + (cal.get(Calendar.MONTH) + 1 < 10 ? "0" +
                    (cal.get(Calendar.MONTH) + 1) : (cal.get(Calendar.MONTH) + 1)));
        }
        return resultList;
    }

    /**
     * 获取趋势图
     *
     * @return
     */
    public TendencyChart getTendencyChart() {

        List<String> monthList = getNearSixMonth();
        TendencyChart res = new TendencyChart();
        res.tendencyX = monthList;
        List<Integer> yList = new ArrayList<>();

        //获取最小日期
        Date minMonth = DateUtils.parseDate(monthList.get(monthList.size() - 1));
        PersonnelQueryDto dto = new PersonnelQueryDto();
//        dto.setStartTime(minMonth);
        List<PersonnelAppointRegister> nearlist = personnelAppointRegisterService.selectPersonnelAppointRegisterList(dto);
        for (int i = 0; i < monthList.size(); i++) {
            int finalI = i;
            dto.setCurrentData(DateUtils.parseDate(monthList.get(finalI)));
            String cntt = monthList.get(finalI);
            List<PersonnelAppointRegister> nearlist1 = nearlist.stream().
                    filter(w -> DateUtils.dateTime(w.getCreateTime()).contains(cntt)).collect(Collectors.toList());
//                    filter(w -> DateUtils.dateTime(w.getRegTime()).contains(cntt)).collect(Collectors.toList());
            yList.add(nearlist1.size());
        }
        res.tendencyY = yList;
        Collections.reverse(res.getTendencyY());
        Collections.reverse(res.getTendencyX());
        return res;
    }
    //endregion

    //region 饼状图计算

    /**
     * 获取人事任免类型集合
     *
     * @return List<SysDictData>
     */
    private List<SysDictData> getDictDataList() {
        SysDictData dictData = new SysDictData();
        dictData.setDictType("personnel_register_type");
        List<SysDictData> dictList = dictDataService.selectDictDataList(dictData);
        return dictList;
    }

    /**
     * 获取饼状图数据集合
     *
     * @param appointmentList
     * @return List<EchartItemVo>
     */
    private List<EchartItemVo> getPieRes(List<SysDictData> appointmentList, List<PersonnelAppointRegister> list) {
        List<EchartItemVo> res = new ArrayList<>();
        for (int i = 0; i < appointmentList.size(); i++) {
            EchartItemVo item = new EchartItemVo();
            item.name = appointmentList.get(i).getDictLabel();
            int finalI = i;
            item.value = list.stream().filter(w -> w.getAppointType().equals(appointmentList.get(finalI).getDictValue())).collect(Collectors.toList()).size();
            res.add(item);
        }
        return res;
    }
    //endregion

    //endregion


}
