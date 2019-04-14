package com.mwj.activiti.service;

import com.mwj.activiti.vo.LeaveInfo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: munjie
 * @Date: 2019/4/14 23:24
 * @Description:
 */
public interface BusinessService {

    //新增请假单
    void addLeave(String msg);

    //查询代办
    List<LeaveInfo> queryByUserId(String userId);



    //完成任务

    public  void completeTaskByUser(String taskId,String userId,String audit);


}
