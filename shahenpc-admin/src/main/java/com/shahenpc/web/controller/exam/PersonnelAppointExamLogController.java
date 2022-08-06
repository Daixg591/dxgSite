package com.shahenpc.web.controller.exam;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.shahenpc.system.domain.exam.PersonnelAppointAnswer;
import com.shahenpc.system.domain.exam.PersonnelAppointGrade;
import com.shahenpc.system.domain.exam.dto.AnswerDto;
import com.shahenpc.system.domain.exam.dto.AnswerLogDto;
import com.shahenpc.system.service.exam.IPersonnelAppointAnswerService;
import io.swagger.annotations.Api;
import net.bytebuddy.asm.Advice;
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
import com.shahenpc.system.domain.exam.PersonnelAppointExamLog;
import com.shahenpc.system.service.exam.IPersonnelAppointExamLogService;
import com.shahenpc.common.utils.poi.ExcelUtil;
import com.shahenpc.common.core.page.TableDataInfo;

/**
 * 人事任免_法律知识考试_答题记录Controller
 *
 * @author ruoyi
 * @date 2022-07-27
 */
@Api(tags = "考试_答题")
@RestController
@RequestMapping("/exam/log")
public class PersonnelAppointExamLogController extends BaseController {
    @Autowired
    private IPersonnelAppointExamLogService personnelAppointExamLogService;

    @Autowired
    private IPersonnelAppointAnswerService answerService;

    /**
     * 查询人事任免_法律知识考试_答题记录列表
     */
    @PreAuthorize("@ss.hasPermi('system:log:list')")
    @GetMapping("/list")
    public TableDataInfo list(PersonnelAppointExamLog personnelAppointExamLog) {
        startPage();
        List<PersonnelAppointExamLog> list = personnelAppointExamLogService.selectPersonnelAppointExamLogList(personnelAppointExamLog);
        return getDataTable(list);
    }

    /**
     * 导出人事任免_法律知识考试_答题记录列表
     */
    @PreAuthorize("@ss.hasPermi('system:log:export')")
    @Log(title = "人事任免_法律知识考试_答题记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, PersonnelAppointExamLog personnelAppointExamLog) {
        List<PersonnelAppointExamLog> list = personnelAppointExamLogService.selectPersonnelAppointExamLogList(personnelAppointExamLog);
        ExcelUtil<PersonnelAppointExamLog> util = new ExcelUtil<PersonnelAppointExamLog>(PersonnelAppointExamLog.class);
        util.exportExcel(response, list, "人事任免_法律知识考试_答题记录数据");
    }

    /**
     * 获取人事任免_法律知识考试_答题记录详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:log:query')")
    @GetMapping(value = "/{logId}")
    public AjaxResult getInfo(@PathVariable("logId") Long logId) {
        return AjaxResult.success(personnelAppointExamLogService.selectPersonnelAppointExamLogByLogId(logId));
    }

    /**
     * 新增人事任免_法律知识考试_答题记录
     */
    @PreAuthorize("@ss.hasPermi('system:log:add')")
    @Log(title = "人事任免_法律知识考试_答题记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AnswerLogDto dto) {
        List<AnswerDto> answerLogList = dto.getAnswerLog();
        List<PersonnelAppointExamLog> resLogList = new ArrayList<>();
        for (int i = 0; i < answerLogList.size(); i++) {
            PersonnelAppointExamLog entity = new PersonnelAppointExamLog();
            entity.setExamId(dto.getExamId());
            String answerIds = "";
            for (int j = 0; j < answerLogList.get(i).getAnswerId().size(); j++) {
                answerIds += answerLogList.get(i) + ",";
            }
            entity.setRegExamId(dto.getRegExamId());
            entity.setAnswerId(answerIds.substring(0, answerIds.length() - 1));
            entity.setQuId(answerLogList.get(i).getQuId());
            entity.setExamId(dto.getExamId());
            entity.setUserId(getUserId());
            entity.setCreateBy(getUsername());
            entity.setScore(getScore(answerLogList.get(i).getAnswerId(), answerLogList.get(i).getScore()));
            personnelAppointExamLogService.insertPersonnelAppointExamLog(entity);
            resLogList.add(entity);
        }


        // 成绩入库
        PersonnelAppointGrade gradeEntity=addGrade(resLogList);



        return AjaxResult.success();
    }


    /**
     * 删除人事任免_法律知识考试_答题记录
     */
    @PreAuthorize("@ss.hasPermi('system:log:remove')")
    @Log(title = "人事任免_法律知识考试_答题记录", businessType = BusinessType.DELETE)
    @DeleteMapping("/{logIds}")
    public AjaxResult remove(@PathVariable Long[] logIds) {
        return toAjax(personnelAppointExamLogService.deletePersonnelAppointExamLogByLogIds(logIds));
    }


    /**
     * 添加成绩信息
     * @param logList
     * @return
     */
    private PersonnelAppointGrade addGrade(List<PersonnelAppointExamLog> logList) {
        PersonnelAppointGrade res = new PersonnelAppointGrade();
        if (logList.size() < 1) {
            return null;
        }
        for (int i = 0; i < logList.size(); i++) {
            res.setRegExamId(logList.get(0).getRegExamId());
            res.setUserId(getUserId());
            res.setExamId(logList.get(i).getExamId());
            res.setCreateBy(getUsername());
        }
        return res;
    }


    /**
     * 获取得分情况
     *
     * @param answerIdList 答案id集合
     * @param score        得分
     * @return
     */
    private Double getScore(List<Long> answerIdList, Double score) {
        boolean res = true;
        for (int i = 0; i < answerIdList.size(); i++) {
            PersonnelAppointAnswer entity = answerService.selectPersonnelAppointAnswerByAnswerId(answerIdList.get(i));
            if (entity.getIsAnswer() == 0) {
                res = false;
            }
        }
        if (res) {
            return score;
        } else {
            return Double.valueOf(0);
        }
    }

}
