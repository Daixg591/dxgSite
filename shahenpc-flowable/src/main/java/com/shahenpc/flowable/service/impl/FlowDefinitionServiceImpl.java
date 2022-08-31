package com.shahenpc.flowable.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shahenpc.common.core.domain.entity.SysDictData;
import com.shahenpc.common.utils.DateUtils;
import com.shahenpc.flowable.common.constant.ProcessConstants;
import com.shahenpc.common.core.domain.AjaxResult;
import com.shahenpc.common.core.domain.entity.SysUser;
import com.shahenpc.flowable.common.enums.FlowComment;
import com.shahenpc.common.utils.SecurityUtils;
import com.shahenpc.flowable.domain.dto.CakeDto;
import com.shahenpc.system.domain.FlowProcDefDto;
import com.shahenpc.flowable.factory.FlowServiceFactory;
import com.shahenpc.flowable.service.IFlowDefinitionService;
import com.shahenpc.flowable.service.ISysDeployFormService;
import com.shahenpc.system.domain.SysForm;
import com.shahenpc.system.domain.represent.RepresentMotion;
import com.shahenpc.system.domain.represent.RepresentMotionRecord;
import com.shahenpc.system.domain.represent.RepresentWorkLog;
import com.shahenpc.system.domain.standard.StandardCensor;
import com.shahenpc.system.domain.standard.StandardCensorRecord;
import com.shahenpc.system.mapper.FlowDeployMapper;
import com.shahenpc.system.service.ISysDeptService;
import com.shahenpc.system.service.ISysDictDataService;
import com.shahenpc.system.service.ISysPostService;
import com.shahenpc.system.service.ISysUserService;
import com.shahenpc.system.service.represent.IRepresentMotionRecordService;
import com.shahenpc.system.service.represent.IRepresentMotionService;
import com.shahenpc.system.service.represent.IRepresentWorkLogService;
import com.shahenpc.system.service.standard.IStandardCensorRecordService;
import com.shahenpc.system.service.standard.IStandardCensorService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.flowable.bpmn.model.BpmnModel;
import org.flowable.engine.repository.Deployment;
import org.flowable.engine.repository.ProcessDefinition;
import org.flowable.engine.repository.ProcessDefinitionQuery;
import org.flowable.engine.runtime.ProcessInstance;
import org.flowable.image.impl.DefaultProcessDiagramGenerator;
import org.flowable.task.api.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 流程定义
 *
 * @author XuanXuan
 * @date 2021-04-03
 */
@Service
@Slf4j
public class FlowDefinitionServiceImpl extends FlowServiceFactory implements IFlowDefinitionService {

    @Resource
    private ISysDeployFormService sysDeployFormService;

    @Resource
    private ISysUserService sysUserService;

    @Resource
    private ISysDeptService sysDeptService;

    @Resource
    private ISysPostService postService;

    @Resource
    private FlowDeployMapper flowDeployMapper;

    @Resource
    private ISysDictDataService dictDataService;
    @Resource
    private IRepresentMotionService representMotionService;
    @Resource
    private IRepresentMotionRecordService representMotionRecordService;
    @Resource
    private IStandardCensorService standardCensorService;
    @Resource
    private IStandardCensorRecordService standardCensorRecordService;

    private static final String BPMN_FILE_SUFFIX = ".bpmn";

    @Override
    public boolean exist(String processDefinitionKey) {
        ProcessDefinitionQuery processDefinitionQuery
                = repositoryService.createProcessDefinitionQuery().processDefinitionKey(processDefinitionKey);
        long count = processDefinitionQuery.count();
        return count > 0 ? true : false;
    }


    /**
     * 流程定义列表
     *
     * @param pageNum  当前页码
     * @param pageSize 每页条数
     * @return 流程定义分页列表数据
     */
    @Override
    public Page<FlowProcDefDto> list(String name, Integer pageNum, Integer pageSize) {
        Page<FlowProcDefDto> page = new Page<>();
//        // 流程定义列表数据查询
//        final ProcessDefinitionQuery processDefinitionQuery = repositoryService.createProcessDefinitionQuery();
//        if (StringUtils.isNotEmpty(name)) {
//            processDefinitionQuery.processDefinitionNameLike(name);
//        }
////        processDefinitionQuery.orderByProcessDefinitionKey().asc();
//        page.setTotal(processDefinitionQuery.count());
//        List<ProcessDefinition> processDefinitionList = processDefinitionQuery.listPage(pageSize * (pageNum - 1), pageSize);
//
//        List<FlowProcDefDto> dataList = new ArrayList<>();
//        for (ProcessDefinition processDefinition : processDefinitionList) {
//            String deploymentId = processDefinition.getDeploymentId();
//            Deployment deployment = repositoryService.createDeploymentQuery().deploymentId(deploymentId).singleResult();
//            FlowProcDefDto reProcDef = new FlowProcDefDto();
//            BeanUtils.copyProperties(processDefinition, reProcDef);
//            SysForm sysForm = sysDeployFormService.selectSysDeployFormByDeployId(deploymentId);
//            if (Objects.nonNull(sysForm)) {
//                reProcDef.setFormName(sysForm.getFormName());
//                reProcDef.setFormId(sysForm.getFormId());
//            }
//            // 流程定义时间
//            reProcDef.setDeploymentTime(deployment.getDeploymentTime());
//            dataList.add(reProcDef);
//        }
        PageHelper.startPage(pageNum, pageSize);
        final List<FlowProcDefDto> dataList = flowDeployMapper.selectDeployList(name);
        // 加载挂表单
        for (FlowProcDefDto procDef : dataList) {
            SysForm sysForm = sysDeployFormService.selectSysDeployFormByDeployId(procDef.getDeploymentId());
            if (Objects.nonNull(sysForm)) {
                procDef.setFormName(sysForm.getFormName());
                procDef.setFormId(sysForm.getFormId());
            }
        }
        page.setTotal(new PageInfo(dataList).getTotal());
        page.setRecords(dataList);
        return page;
    }

    @Override
    public FlowProcDefDto detail(String name) {
        FlowProcDefDto  procDef=  flowDeployMapper.detail(name);
        SysForm sysForm = sysDeployFormService.selectSysDeployFormByDeployId(procDef.getDeploymentId());
        if (Objects.nonNull(sysForm)) {
            procDef.setFormName(sysForm.getFormName());
            procDef.setFormId(sysForm.getFormId());
        }
        return procDef;
    }


    /**
     * 导入流程文件
     *
     * @param name
     * @param category
     * @param in
     */
    @Override
    public void importFile(String name, String category, InputStream in) {
        Deployment deploy = repositoryService.createDeployment().addInputStream(name + BPMN_FILE_SUFFIX, in).name(name).category(category).deploy();
        ProcessDefinition definition = repositoryService.createProcessDefinitionQuery().deploymentId(deploy.getId()).singleResult();
        repositoryService.setProcessDefinitionCategory(definition.getId(), category);

    }

    /**
     * 读取xml
     *
     * @param deployId
     * @return
     */
    @Override
    public AjaxResult readXml(String deployId) throws IOException {
        ProcessDefinition definition = repositoryService.createProcessDefinitionQuery().deploymentId(deployId).singleResult();
        InputStream inputStream = repositoryService.getResourceAsStream(definition.getDeploymentId(), definition.getResourceName());
        String result = IOUtils.toString(inputStream, StandardCharsets.UTF_8.name());
        return AjaxResult.success("", result);
    }

    /**
     * 读取xml
     *
     * @param deployId
     * @return
     */
    @Override
    public InputStream readImage(String deployId) {
        ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery().deploymentId(deployId).singleResult();
        //获得图片流
        DefaultProcessDiagramGenerator diagramGenerator = new DefaultProcessDiagramGenerator();
        BpmnModel bpmnModel = repositoryService.getBpmnModel(processDefinition.getId());
        //输出为图片
        return diagramGenerator.generateDiagram(
                bpmnModel,
                "png",
                Collections.emptyList(),
                Collections.emptyList(),
                "宋体",
                "宋体",
                "宋体",
                null,
                1.0,
                false);

    }


    /**
     * 根据流程定义ID启动流程实例
     *
     * @param procDefId 流程定义Id
     * @param variables 流程变量
     * @return
     */
    @Override
    public AjaxResult startProcessInstanceById(String procDefId, Map<String, Object> variables) {
        try {
            ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery().processDefinitionId(procDefId)
                    .latestVersion().singleResult();
            if (Objects.nonNull(processDefinition) && processDefinition.isSuspended()) {
                return AjaxResult.error("流程已被挂起,请先激活流程");
            }
//           variables.put("skip", true);
//           variables.put(ProcessConstants.FLOWABLE_SKIP_EXPRESSION_ENABLED, true);
            // 设置流程发起人Id到流程中
            SysUser sysUser = SecurityUtils.getLoginUser().getUser();
            identityService.setAuthenticatedUserId(sysUser.getUserId().toString());
            variables.put(ProcessConstants.PROCESS_INITIATOR, "");
            ProcessInstance processInstance = runtimeService.startProcessInstanceById(procDefId, variables);
            // 给第一步申请人节点设置任务执行人和意见 todo:第一个节点不设置为申请人节点有点问题？
            Task task = taskService.createTaskQuery().processInstanceId(processInstance.getProcessInstanceId()).singleResult();
            if (Objects.nonNull(task)) {
                taskService.addComment(task.getId(), processInstance.getProcessInstanceId(), FlowComment.NORMAL.getType(), sysUser.getNickName() + "发起流程申请");
//                taskService.setAssignee(task.getId(), sysUser.getUserId().toString());
                taskService.complete(task.getId(), variables);
            }
            return AjaxResult.success("流程启动成功");
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.error("流程启动错误");
        }
    }

    @Autowired
    private IRepresentWorkLogService representWorkLogService;

    @Override
    @Transactional
    public AjaxResult addMotion(RepresentMotion representMotion,String procDefId) {
        try {
            ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery().processDefinitionId(procDefId)
                    .latestVersion().singleResult();
            if (Objects.nonNull(processDefinition) && processDefinition.isSuspended()) {
                return AjaxResult.error("流程已被挂起,请先联系管理员！");
            }
//           variables.put("skip", true);
//           variables.put(ProcessConstants.FLOWABLE_SKIP_EXPRESSION_ENABLED, true);
            // 设置流程发起人Id到流程中
            SysUser sysUser = SecurityUtils.getLoginUser().getUser();
            identityService.setAuthenticatedUserId(sysUser.getUserId().toString());
            Map<String, Object> variables = new HashMap<>();
            variables.put("approval",representMotion.getApprovalUserId());
            variables.put(ProcessConstants.PROCESS_INITIATOR, "");
            ProcessInstance processInstance = runtimeService.startProcessInstanceById(procDefId,variables);
            // 给第一步申请人节点设置任务执行人和意见 todo:第一个节点不设置为申请人节点有点问题？
            Task task = taskService.createTaskQuery().processInstanceId(processInstance.getProcessInstanceId()).singleResult();
            if (Objects.nonNull(task)) {
                taskService.addComment(task.getId(), processInstance.getProcessInstanceId(), FlowComment.NORMAL.getType(), sysUser.getNickName() + "发起流程申请");
                taskService.setAssignee(task.getId(), sysUser.getUserId().toString());
                taskService.complete(task.getId(), variables);
            }
            //motion.setMotionType(Integer.parseInt(variables.get("motionType").toString()));
           // motion.setTitle(variables.get("title").toString());
            //motion.setContent(variables.get("content").toString());
            //提议人
           // motion.setSuggestUserName(variables.get("suggestUserName").toString());
            //选择审批人
           // motion.setSuggestUserId(variables.get("approval").toString());
            //数组存储
           // List<SysUser> user=sysUserService.selectUserByuserIds(variables.get("approval").toString());
            //prochsid 3b2bf51d-f863-11ec-a590-24698ed5e50b  创建流程id
            // deployId 流程模板的id 417b0131-f85d-11ec-a590-24698ed5e50b
            representMotion.setProcinsId(task.getProcessInstanceId());
            representMotion.setDeployId(processInstance.getDeploymentId());
            //处理环节
            task.getName();
            //处理状态
            task.getDelegationState();
            representMotionService.insertRepresentMotion(representMotion);
            RepresentWorkLog log = new RepresentWorkLog();
            log.setEventType(5);
            log.setEventId(representMotion.getMotionId());
            log.setUserId(representMotion.getSendUserId());
            log.setRemark("议案建议！");
            representWorkLogService.insertRepresentWorkLog(log);
            RepresentMotionRecord  record = new RepresentMotionRecord();
            record.setMotionId(representMotion.getMotionId());
            record.setDeployId(processInstance.getDeploymentId());
            record.setProcinsId(task.getProcessInstanceId());
            representMotionRecordService.insertRepresentMotionRecord(record);
            return AjaxResult.success("流程启动成功");
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.error("流程启动错误");
        }
    }

    @Override
    @Transactional
    public AjaxResult addCensor(StandardCensor standardCensor, String procDefId) {
        try {
            ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery().processDefinitionId(procDefId)
                    .latestVersion().singleResult();
            if (Objects.nonNull(processDefinition) && processDefinition.isSuspended()) {
                return AjaxResult.error("流程已被挂起,请先联系管理员！");
            }
            // 设置流程发起人Id到流程中
            SysUser sysUser = SecurityUtils.getLoginUser().getUser();
            identityService.setAuthenticatedUserId(sysUser.getUserId().toString());
            Map<String, Object> variables = new HashMap<>();
            variables.put("approval",standardCensor.getApprovalUserId());
            variables.put(ProcessConstants.PROCESS_INITIATOR, "");
            variables.put("skip", true);
            ProcessInstance processInstance = runtimeService.startProcessInstanceById(procDefId,variables);
            // 给第一步申请人节点设置任务执行人和意见 todo:第一个节点不设置为申请人节点有点问题？
            Task task = taskService.createTaskQuery().processInstanceId(processInstance.getProcessInstanceId()).singleResult();
            if (Objects.nonNull(task)) {
                taskService.addComment(task.getId(), processInstance.getProcessInstanceId(), FlowComment.NORMAL.getType(), sysUser.getNickName() + "发起流程申请");
                taskService.setAssignee(task.getId(), sysUser.getUserId().toString());
                taskService.complete(task.getId(), variables);
            }
            //处理环节
            task.getName();
            //处理状态
            task.getDelegationState();
            standardCensor.setProcinsId(task.getProcessInstanceId());
            standardCensor.setDeployId(processInstance.getDeploymentId());
            standardCensor.setCreateTime(DateUtils.getNowDate());
            standardCensorService.insertStandardCensor(standardCensor);
            StandardCensorRecord record = new StandardCensorRecord();
            record.setCensorId(standardCensor.getCensorId());
            record.setDeployId(processInstance.getDeploymentId());
            record.setProcinsId(task.getProcessInstanceId());
            record.setCreateTime(DateUtils.getNowDate());
            standardCensorRecordService.insertStandardCensorRecord(record);
            return AjaxResult.success("流程启动成功");
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.error("流程启动错误");
        }
    }

    /**
     * 激活或挂起流程定义
     *
     * @param state    状态
     * @param deployId 流程部署ID
     */
    @Override
    public void updateState(Integer state, String deployId) {
        ProcessDefinition procDef = repositoryService.createProcessDefinitionQuery().deploymentId(deployId).singleResult();
        // 激活
        if (state == 1) {
            repositoryService.activateProcessDefinitionById(procDef.getId(), true, null);
        }
        // 挂起
        if (state == 2) {
            repositoryService.suspendProcessDefinitionById(procDef.getId(), true, null);
        }
    }


    /**
     * 删除流程定义
     *
     * @param deployId 流程部署ID act_ge_bytearray 表中 deployment_id值
     */
    @Override
    public void delete(String deployId) {
        // true 允许级联删除 ,不设置会导致数据库外键关联异常
        repositoryService.deleteDeployment(deployId, true);
    }




    @Override
    public List<Integer> monthCount() {
        List<Integer> intss = new ArrayList<>();
        // 跟 按月  柱状
        
        //两个接收的总数
        //intss.add(list.size());
        return intss;
    }

    @Override
    public List<CakeDto> fileTypeCake() {
        List<CakeDto> dto = new ArrayList<>();
        StandardCensor censorProcess = new StandardCensor();
        List<StandardCensor> listuser= standardCensorService.selectStandardCensorList(censorProcess);
        SysDictData dictParam = new SysDictData();
        dictParam.setDictType("file_type");
        List<SysDictData> dictList = dictDataService.selectDictDataList(dictParam);
        for (int i = 0; i < dictList.size(); i++) {
            int finalI = i;
            int v = listuser.stream().filter(p -> dictList.get(finalI).getDictValue().equals(p.getReportType().toString()))
                    .collect(Collectors.toList()).size();
            CakeDto item = new CakeDto();
            item.setName(dictList.get(i).getDictLabel());
            item.setValue(v);
            dto.add(item);
        }
        return dto;
    }

    @Override
    public List<CakeDto> receiveRate(String taskName,String deployName) {
        List<CakeDto> list = new ArrayList<>();
        Long userId = SecurityUtils.getLoginUser().getUser().getUserId();

        //等待数
        Integer stayTotal = taskService.createTaskQuery()
                .active()
                .includeProcessVariables()
                .taskName(taskName)
                .taskAssignee(userId.toString())
                .orderByTaskCreateTime().desc().list().size();
        List<FlowProcDefDto> dto = flowDeployMapper.selectDeployList(deployName);
        //过来数
        int receiveTotal= historyService
                .createHistoricActivityInstanceQuery()
                .activityName(taskName)
                .taskAssignee(userId.toString())
                .processDefinitionId(dto.get(0).getId())
                .orderByHistoricActivityInstanceStartTime()
                .desc().list().size();
        //先查 流程id
        ProcessDefinition pd1 = repositoryService.createProcessDefinitionQuery()
                .processDefinitionName(deployName)
                .singleResult();
        //已完成 接收的总数
        int doneTotal = historyService.createHistoricTaskInstanceQuery()
                .includeProcessVariables()
                .finished()
                .processDefinitionId(pd1.getId())
                .taskAssignee(userId.toString())
                .orderByHistoricTaskInstanceEndTime()
                .desc().list().size();
        int count = stayTotal+receiveTotal+doneTotal;
        CakeDto cakedto =new CakeDto();
        cakedto.setName(taskName+"占总数比例");
        BigDecimal a = new BigDecimal(stayTotal);
        BigDecimal b = new BigDecimal(count);
        BigDecimal gd =  a.divide(b,0,BigDecimal.ROUND_UP);
        cakedto.setValue(Integer.parseInt(gd.toString()));
        list.add(cakedto);
        return list;
    }

}
