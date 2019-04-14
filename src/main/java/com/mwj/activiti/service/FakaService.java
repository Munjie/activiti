package com.mwj.activiti.service;

import com.mwj.activiti.dao.FakadDao;
import com.mwj.activiti.vo.LeaveInfo;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: munjie
 * @Date: 2019/4/14 22:47
 * @Description:
 */
@Service
public class FakaService {

    //${FakaService.findProManager(execution)}
    //${FakaService.findHrManager(execution)}
    //#{FakaService.changeStatus(execution,'ing')}
    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private TaskService taskService;

    @Autowired
    private FakadDao fakadDao;

    public List<String> findProManager(DelegateExecution execution){

         return Arrays.asList("pro1","pro2");
    }



    public List<String> findHrManager(DelegateExecution execution){

        return Arrays.asList("hr1","hr2");
    }

    public void changeStatus(DelegateExecution execution,String status){


       System.out.println("修改业务单据"+status);

        String processBusinessKey = execution.getProcessBusinessKey();
        LeaveInfo byKey = fakadDao.findByKey(Integer.valueOf(processBusinessKey));
        byKey.setStatus(status);
        fakadDao.update(byKey);

    }

    //启动流程
    public  void startProcess(String bizKey){
        runtimeService.startProcessInstanceByKey("fkpro",bizKey);
    }

    //查询相关审批人
public List<Task> findTaskByUserId(String userID){

    List<Task> list = taskService.createTaskQuery().taskCandidateOrAssigned(userID).list();
    return list;


}

    //审批
    public  void completeTaskByUser(String taskId,String userId,String audit){

        //认领任务
        taskService.claim(taskId,userId);
        Map<String ,Object> map = new HashMap();
        map.put("audit",audit);
        taskService.complete(taskId,map);


    }



}
