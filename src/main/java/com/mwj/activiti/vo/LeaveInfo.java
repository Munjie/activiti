package com.mwj.activiti.vo;

/**
 * @Auther: munjie
 * @Date: 2019/4/14 23:00
 * @Description:
 */
public class LeaveInfo {

    private int id;
    private String status;
    private  String msg;

    private  String taskId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }
}
