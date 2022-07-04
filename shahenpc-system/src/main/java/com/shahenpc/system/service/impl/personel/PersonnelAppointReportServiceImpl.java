package com.shahenpc.system.service.impl.personel;

import java.util.List;
import com.shahenpc.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shahenpc.system.mapper.personel.PersonnelAppointReportMapper;
import com.shahenpc.system.domain.personel.PersonnelAppointReport;
import com.shahenpc.system.service.personel.IPersonnelAppointReportService;

/**
 * 人事任免_述职报告Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-07-04
 */
@Service
public class PersonnelAppointReportServiceImpl implements IPersonnelAppointReportService 
{
    @Autowired
    private PersonnelAppointReportMapper personnelAppointReportMapper;

    /**
     * 查询人事任免_述职报告
     * 
     * @param reportId 人事任免_述职报告主键
     * @return 人事任免_述职报告
     */
    @Override
    public PersonnelAppointReport selectPersonnelAppointReportByReportId(Long reportId)
    {
        return personnelAppointReportMapper.selectPersonnelAppointReportByReportId(reportId);
    }

    /**
     * 查询人事任免_述职报告列表
     * 
     * @param personnelAppointReport 人事任免_述职报告
     * @return 人事任免_述职报告
     */
    @Override
    public List<PersonnelAppointReport> selectPersonnelAppointReportList(PersonnelAppointReport personnelAppointReport)
    {
        return personnelAppointReportMapper.selectPersonnelAppointReportList(personnelAppointReport);
    }

    /**
     * 新增人事任免_述职报告
     * 
     * @param personnelAppointReport 人事任免_述职报告
     * @return 结果
     */
    @Override
    public int insertPersonnelAppointReport(PersonnelAppointReport personnelAppointReport)
    {
        personnelAppointReport.setCreateTime(DateUtils.getNowDate());
        return personnelAppointReportMapper.insertPersonnelAppointReport(personnelAppointReport);
    }

    /**
     * 修改人事任免_述职报告
     * 
     * @param personnelAppointReport 人事任免_述职报告
     * @return 结果
     */
    @Override
    public int updatePersonnelAppointReport(PersonnelAppointReport personnelAppointReport)
    {
        personnelAppointReport.setUpdateTime(DateUtils.getNowDate());
        return personnelAppointReportMapper.updatePersonnelAppointReport(personnelAppointReport);
    }

    /**
     * 批量删除人事任免_述职报告
     * 
     * @param reportIds 需要删除的人事任免_述职报告主键
     * @return 结果
     */
    @Override
    public int deletePersonnelAppointReportByReportIds(Long[] reportIds)
    {
        return personnelAppointReportMapper.deletePersonnelAppointReportByReportIds(reportIds);
    }

    /**
     * 删除人事任免_述职报告信息
     * 
     * @param reportId 人事任免_述职报告主键
     * @return 结果
     */
    @Override
    public int deletePersonnelAppointReportByReportId(Long reportId)
    {
        return personnelAppointReportMapper.deletePersonnelAppointReportByReportId(reportId);
    }
}
