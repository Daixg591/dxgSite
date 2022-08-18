package com.shahenpc.web.controller.exam;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.shahenpc.system.domain.exam.PersonnelAppointAnswer;
import com.shahenpc.system.service.exam.IPersonnelAppointAnswerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
import com.shahenpc.system.domain.exam.PersonnelAppointQuestion;
import com.shahenpc.system.service.exam.IPersonnelAppointQuestionService;
import com.shahenpc.common.utils.poi.ExcelUtil;
import com.shahenpc.common.core.page.TableDataInfo;

/**
 * 人事任免_法律知识考试_试题管理Controller
 *
 * @author ruoyi
 * @date 2022-07-27
 */
@Api(tags = "考试_试题管理")
@RestController
@RequestMapping("/exam/smallqu")
public class PersonnelAppointQuestionController extends BaseController {
    @Autowired
    private IPersonnelAppointQuestionService personnelAppointQuestionService;

    @Autowired
    private IPersonnelAppointAnswerService answerService;

    /**
     * 查询人事任免_法律知识考试_试题管理列表
     */
    @ApiOperation("考试_试题列表")
    @PreAuthorize("@ss.hasPermi('system:question:list')")
    @GetMapping("/list")
    public TableDataInfo list(PersonnelAppointQuestion personnelAppointQuestion) {
        startPage();
        List<PersonnelAppointQuestion> list = personnelAppointQuestionService.selectPersonnelAppointQuestionList(personnelAppointQuestion);
        for (int i = 0; i < list.size(); i++) {
            PersonnelAppointAnswer param = new PersonnelAppointAnswer();
            param.setQuId(list.get(i).getQuId());
            list.get(i).setAnswerList(answerService.selectPersonnelAppointAnswerList(param));
        }
        return getDataTable(list);
    }

    /**
     * 导出人事任免_法律知识考试_试题管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:question:export')")
    @Log(title = "人事任免_法律知识考试_试题管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, PersonnelAppointQuestion personnelAppointQuestion) {
        List<PersonnelAppointQuestion> list = personnelAppointQuestionService.selectPersonnelAppointQuestionList(personnelAppointQuestion);
        ExcelUtil<PersonnelAppointQuestion> util = new ExcelUtil<PersonnelAppointQuestion>(PersonnelAppointQuestion.class);
        util.exportExcel(response, list, "人事任免_法律知识考试_试题管理数据");
    }

    /**
     * 获取人事任免_法律知识考试_试题管理详细信息
     */
    @ApiOperation("考试_试题详情")
    @PreAuthorize("@ss.hasPermi('system:question:query')")
    @GetMapping(value = "/{quId}")
    public AjaxResult getInfo(@PathVariable("quId") Long quId) {
        return AjaxResult.success(personnelAppointQuestionService.selectPersonnelAppointQuestionByQuId(quId));
    }

    /**
     * 新增人事任免_法律知识考试_试题管理
     */
    @ApiOperation("考试_新增试题")
    @PreAuthorize("@ss.hasPermi('system:question:add')")
    @Log(title = "人事任免_法律知识考试_试题管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PersonnelAppointQuestion personnelAppointQuestion) {
        if (personnelAppointQuestion.getAnswerList() == null || personnelAppointQuestion.getAnswerList().size() < 1) {
            return AjaxResult.error("请完善答案信息");
        }
        personnelAppointQuestion.setCreateBy(getUsername());
        int res = personnelAppointQuestionService.insertPersonnelAppointQuestion(personnelAppointQuestion);
        //添加试题答案信息
        Long quId = personnelAppointQuestion.getQuId();
        for (int i = 0; i < personnelAppointQuestion.getAnswerList().size(); i++) {
            personnelAppointQuestion.getAnswerList().get(i).setQuId(quId);
            personnelAppointQuestion.getAnswerList().get(i).setCreateBy(getUsername());
            answerService.insertPersonnelAppointAnswer(personnelAppointQuestion.getAnswerList().get(i));
        }
        return toAjax(res);
    }

    /**
     * 修改人事任免_法律知识考试_试题管理
     */
    @ApiOperation("考试_编辑试题")
    @PreAuthorize("@ss.hasPermi('system:question:edit')")
    @Log(title = "人事任免_法律知识考试_试题管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PersonnelAppointQuestion personnelAppointQuestion) {
        int res = personnelAppointQuestionService.updatePersonnelAppointQuestion(personnelAppointQuestion);
        List<PersonnelAppointAnswer> answerList = personnelAppointQuestionService.selectPersonnelAppointQuestionByQuId(personnelAppointQuestion.getQuId()).getAnswerList();
        // 删除试题==>再进行添加
        for (int i = 0; answerList.size() > 0 && i < answerList.size(); i++) {
//            answerService.updatePersonnelAppointAnswer(answerList.get(i));
            answerService.deletePersonnelAppointAnswerByAnswerId(answerList.get(i).getAnswerId());
        }
        for (int i = 0; i < personnelAppointQuestion.getAnswerList().size(); i++) {
            personnelAppointQuestion.getAnswerList().get(i).setQuId(personnelAppointQuestion.getQuId());
            answerService.insertPersonnelAppointAnswer(personnelAppointQuestion.getAnswerList().get(i));
        }


        return toAjax(res);
    }


    /**
     * 删除人事任免_法律知识考试_试题管理
     */
    @ApiOperation("考试_删除试题")
    @PreAuthorize("@ss.hasPermi('system:question:remove')")
    @Log(title = "人事任免_法律知识考试_试题管理", businessType = BusinessType.DELETE)
    @DeleteMapping("/{quIds}")
    public AjaxResult remove(@PathVariable Long[] quIds) {

        // 试题删除之后,答案删除答案
        for (int i = 0; i < quIds.length; i++) {
            Long quId = personnelAppointQuestionService.selectPersonnelAppointQuestionByQuId(quIds[i]).getQuId();
            PersonnelAppointAnswer param = new PersonnelAppointAnswer();
            param.setQuId(quId);
            List<PersonnelAppointAnswer> answerList = answerService.selectPersonnelAppointAnswerList(param);

            Long[] paramArray = new Long[answerList.size()];
            for (int j = 0; j < answerList.size(); j++) {
                paramArray[i] = answerList.get(i).getAnswerId();
            }
            answerService.deletePersonnelAppointAnswerByAnswerIds(paramArray);
        }
        int res = personnelAppointQuestionService.deletePersonnelAppointQuestionByQuIds(quIds);
        return toAjax(res);
    }
}
