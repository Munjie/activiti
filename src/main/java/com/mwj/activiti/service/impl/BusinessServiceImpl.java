package com.mwj.activiti.service.impl;

import com.mwj.activiti.dao.FakadDao;
import com.mwj.activiti.service.BusinessService;
import com.mwj.activiti.service.FakaService;
import com.mwj.activiti.vo.LeaveInfo;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.runtime.ProcessInstanceQuery;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @Auther: munjie
 * @Date: 2019/4/14 23:27
 * @Description:
 */
@Service
public class BusinessServiceImpl implements BusinessService {

    @Autowired
    private FakaService fakaService;

    @Autowired
    private FakadDao fakadDao;

    @Autowired
    private RuntimeService runtimeService;

    @Override
    public void addLeave(String msg) {

        LeaveInfo leaveInfo = new LeaveInfo();
        leaveInfo.setMsg(msg);
        int i = 103;
        leaveInfo.setId(i);
        fakadDao.add(leaveInfo);

        fakaService.startProcess(String.valueOf(i));



    }

    @Override
    public List<LeaveInfo> queryByUserId(String userId) {
        List<Task> taskByUserId = fakaService.findTaskByUserId(userId);

        List<LeaveInfo> result = new ArrayList<>();
        for (Task tast : taskByUserId) {

            ProcessInstance processInstance = runtimeService.createProcessInstanceQuery().processInstanceId(tast.getProcessInstanceId()).singleResult();
            String businessKey = processInstance.getBusinessKey();
            LeaveInfo byKey = fakadDao.findByKey(Integer.valueOf(businessKey));
            byKey.setTaskId(tast.getId());
            result.add(byKey);

        }
        return  result;
    }

    @Override
    public void completeTaskByUser(String taskId, String userId, String audit) {

        fakaService.completeTaskByUser(taskId,userId,audit);



    }
}
