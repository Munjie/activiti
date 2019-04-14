package com.mwj.activiti.controller;

import com.mwj.activiti.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: munjie
 * @Date: 2019/4/14 23:50
 * @Description:
 */
@RestController
public class FakaController {


    @Autowired
    private BusinessService businessService;


    @RequestMapping("/add")
    public  Object add(String msg){

businessService.addLeave(msg);

return  "新增成功";
    }

    @RequestMapping("/queryById")
    public  Object querTaskByuserId(String userId){

return  businessService.queryByUserId(userId);
    }
    @RequestMapping("/complete")
    public  Object complete(String taskId,String userId,String audit){

          businessService.completeTaskByUser(taskId,userId,audit);
          return  "审批完成";
    }
}
