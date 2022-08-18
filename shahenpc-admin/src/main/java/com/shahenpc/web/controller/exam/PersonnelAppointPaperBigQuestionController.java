package com.shahenpc.web.controller.exam;

import com.shahenpc.common.annotation.Log;
import com.shahenpc.common.core.controller.BaseController;
import com.shahenpc.common.core.domain.AjaxResult;
import com.shahenpc.common.core.page.TableDataInfo;
import com.shahenpc.common.enums.BusinessType;
import com.shahenpc.common.utils.poi.ExcelUtil;
import com.shahenpc.system.domain.exam.PersonnelAppointExamPaper;
import com.shahenpc.system.domain.exam.PersonnelAppointPaperBigQuestion;
import com.shahenpc.system.domain.exam.PersonnelAppointQuestion;
import com.shahenpc.system.domain.exam.dto.PaperQuestionDto;
import com.shahenpc.system.domain.exam.dto.RandomQuDto;
import com.shahenpc.system.service.exam.IPersonnelAppointExamPaperService;
import com.shahenpc.system.service.exam.IPersonnelAppointPaperBigQuestionService;
import com.shahenpc.system.service.exam.IPersonnelAppointQuestionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * 人事任免_法律知识考试_试卷大题对应Controller
 *
 * @author ruoyi
 * @date 2022-07-27
 */
@Api(tags = "考试_试卷试题对应")
@RestController
@RequestMapping("/exam/bigqu")
public class PersonnelAppointPaperBigQuestionController extends BaseController {
    @Autowired
    private IPersonnelAppointPaperBigQuestionService personnelAppointPaperBigQuestionService;

    @Autowired
    private IPersonnelAppointExamPaperService paperService;

    @Autowired
    private IPersonnelAppointQuestionService quService;


    /**
     * 查询人事任免_法律知识考试_试卷大题对应列表
     */
    @PreAuthorize("@ss.hasPermi('system:question:list')")
    @GetMapping("/list")
    @ApiOperation("列表")
    public TableDataInfo list(PersonnelAppointPaperBigQuestion personnelAppointPaperBigQuestion) {
        startPage();
        List<PersonnelAppointPaperBigQuestion> list = personnelAppointPaperBigQuestionService.selectPersonnelAppointPaperBigQuestionList(personnelAppointPaperBigQuestion);
        return getDataTable(list);
    }

    /**
     * 导出人事任免_法律知识考试_试卷大题对应列表
     */
    @PreAuthorize("@ss.hasPermi('system:question:export')")
    @Log(title = "人事任免_法律知识考试_试卷大题对应", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, PersonnelAppointPaperBigQuestion personnelAppointPaperBigQuestion) {
        List<PersonnelAppointPaperBigQuestion> list = personnelAppointPaperBigQuestionService.selectPersonnelAppointPaperBigQuestionList(personnelAppointPaperBigQuestion);
        ExcelUtil<PersonnelAppointPaperBigQuestion> util = new ExcelUtil<PersonnelAppointPaperBigQuestion>(PersonnelAppointPaperBigQuestion.class);
        util.exportExcel(response, list, "人事任免_法律知识考试_试卷大题对应数据");
    }

    /**
     * 获取人事任免_法律知识考试_试卷大题对应详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:question:query')")
    @GetMapping(value = "/{bigQuestionId}")
    public AjaxResult getInfo(@PathVariable("bigQuestionId") Long bigQuestionId) {
        return AjaxResult.success(personnelAppointPaperBigQuestionService.selectPersonnelAppointPaperBigQuestionByBigQuestionId(bigQuestionId));
    }


    /**
     * 删除人事任免_法律知识考试_试卷大题对应
     */
    @PreAuthorize("@ss.hasPermi('system:question:remove')")
    @Log(title = "人事任免_法律知识考试_试卷大题对应", businessType = BusinessType.DELETE)
    @DeleteMapping("/{bigQuestionIds}")
    public AjaxResult remove(@PathVariable Long[] bigQuestionIds) {
        return toAjax(personnelAppointPaperBigQuestionService.deletePersonnelAppointPaperBigQuestionByBigQuestionIds(bigQuestionIds));
    }


    @ApiOperation("新增试题试卷")
    @PreAuthorize("@ss.hasPermi('system:question:add')")
    @Log(title = "人事任免_新增试题试卷", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PaperQuestionDto dto) {
        return getAjaxResult(dto);
    }

    /**
     * 修改人事任免_法律知识考试_试卷大题对应
     */
    @ApiOperation("编辑试题试卷")
    @PreAuthorize("@ss.hasPermi('system:question:edit')")
    @Log(title = "人事任免_编辑试题试卷", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PaperQuestionDto dto) {
        PersonnelAppointPaperBigQuestion param = new PersonnelAppointPaperBigQuestion();
        param.setExamPaperId(dto.getPaperID());
        List<PersonnelAppointPaperBigQuestion> list = personnelAppointPaperBigQuestionService.selectPersonnelAppointPaperBigQuestionList(param);
        for (int i = 0; list.size() > 0 && i < list.size(); i++) {
            personnelAppointPaperBigQuestionService.deletePersonnelAppointPaperBigQuestionByBigQuestionId(list.get(i).getBigQuestionId());
        }
//        for (int i = 0; dto.getQuList().size() > 0 && i < dto.getQuList().size(); i++) {
//            PersonnelAppointPaperBigQuestion entity = new PersonnelAppointPaperBigQuestion();
//            entity.setScore(dto.getQuList().get(i).getScore());
//            entity.setQuId(dto.getQuList().get(i).getQuId());
//            entity.setQuestionType(dto.getQuList().get(i).getQuType());
//            entity.setExamPaperId(dto.getPaperID());
//            personnelAppointPaperBigQuestionService.insertPersonnelAppointPaperBigQuestion(entity);
//        }
        return getAjaxResult(dto);
    }

    /**
     * 新增/编辑 试卷试题逻辑
     *
     * @param dto
     * @return
     */
    @NotNull
    private AjaxResult getAjaxResult(@RequestBody PaperQuestionDto dto) {
        PersonnelAppointExamPaper paperEntity = paperService.selectPersonnelAppointExamPaperByExamPaperId(dto.getPaperID());
        if (paperEntity == null) {
            return AjaxResult.isEmpty("无试卷信息");
        }
        String tempType = "1";
        if (dto.getQuList()!=null && dto.getQuList().size()>0 ){
            // 修改试卷新题入库
            return getAjaxResultPart(dto);
        }
        if (paperEntity.getMakePaperType().equals(tempType)) {
            // 随机组卷
            List<PersonnelAppointQuestion> resList = getRandomQuList(dto);

            return AjaxResult.success(resList);
        } else {
            // 选题组件
            return getAjaxResultPart(dto);
        }
    }

    @NotNull
    private AjaxResult getAjaxResultPart(@RequestBody PaperQuestionDto dto) {
        if (dto.getQuList() == null || dto.getQuList().size() < 1) {
            return AjaxResult.isEmpty("无试题信息");
        }
        for (int i = 0; i < dto.getQuList().size(); i++) {
            PersonnelAppointPaperBigQuestion entity = new PersonnelAppointPaperBigQuestion();
            entity.setQuId(dto.getQuList().get(i).getQuId());
            entity.setScore(dto.getQuList().get(i).getScore());
            entity.setExamPaperId(dto.getPaperID());
            entity.setQuestionType(dto.getQuList().get(i).getQuType());
            entity.setCreateBy(getUsername());
            personnelAppointPaperBigQuestionService.insertPersonnelAppointPaperBigQuestion(entity);
        }
        return AjaxResult.success();
    }


    /**
     * 获取随机试题数据集
     *
     * @param dto
     * @return
     */
    private List<PersonnelAppointQuestion> getRandomQuList(PaperQuestionDto dto) {
        List<PersonnelAppointQuestion> resList = new ArrayList<>();
        List<RandomQuDto> dtoList = dto.getRandomInfo();
        for (int i = 0; dtoList != null && i < dtoList.size(); i++) {
            List<PersonnelAppointQuestion> itemList = quService.selectRandomQuestionList(dtoList.get(i));
            for (int j = 0; j < itemList.size(); j++) {
                resList.add(itemList.get(j));
            }
        }
        for (int i = 0; i < resList.size(); i++) {
            PersonnelAppointPaperBigQuestion entity = new PersonnelAppointPaperBigQuestion();
            entity.setBigQuestionId(resList.get(i).getQuId());
            entity.setScore(dto.getScore());
            entity.setExamPaperId(dto.getPaperID());
            entity.setQuestionType(resList.get(i).getQuType());
            entity.setCreateBy(getUsername());
            entity.setQuId(resList.get(i).getQuId());
            personnelAppointPaperBigQuestionService.insertPersonnelAppointPaperBigQuestion(entity);
        }
        return resList;
    }

}
