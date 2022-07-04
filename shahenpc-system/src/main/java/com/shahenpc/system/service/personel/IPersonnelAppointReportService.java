package com.shahenpc.system.service.personel;

import java.util.List;
import com.shahenpc.system.domain.personel.PersonnelAppointReport;

/**
 * 人事任免_述职报告Service接口
 * 
 * @author ruoyi
 * @date 2022-07-04
 */
public interface IPersonnelAppointReportService 
{
    /**
     * 查询人事任免_述职报告
     * 
     * @param reportId 人事任免_述职报告主键
     * @return 人事任免_述职报告
     */
    public PersonnelAppointReport selectPersonnelAppointReportByReportId(Long reportId);

    /**
     * 查询人事任免_述职报告列表
     * 
     * @param personnelAppointReport 人事任免_述职报告
     * @return 人事任免_述职报告集合
     */
    public List<PersonnelAppointReport> selectPersonnelAppointReportList(PersonnelAppointReport personnelAppointReport);

    /**
     * 新增人事任免_述职报告
     * 
     * @param personnelAppointReport 人事任免_述职报告
     * @return 结果
     */
    public int insertPersonnelAppointReport(PersonnelAppointReport personnelAppointReport);

    /**
     * 修改人事任免_述职报告
     * 
     * @param personnelAppointReport 人事任免_述职报告
     * @return 结果
     */
    public int updatePersonnelAppointReport(PersonnelAppointReport personnelAppointReport);

    /**
     * 批量删除人事任免_述职报告
     * 
     * @param reportIds 需要删除的人事任免_述职报告主键集合
     * @return 结果
     */
    public int deletePersonnelAppointReportByReportIds(Long[] reportIds);

    /**
     * 删除人事任免_述职报告信息
     * 
     * @param reportId 人事任免_述职报告主键
     * @return 结果
     */
    public int deletePersonnelAppointReportByReportId(Long reportId);
}
