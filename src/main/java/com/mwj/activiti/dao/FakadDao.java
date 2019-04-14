package com.mwj.activiti.dao;

import com.mwj.activiti.vo.LeaveInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Auther: munjie
 * @Date: 2019/4/14 23:03
 * @Description:
 */
@Mapper
public interface FakadDao {

    @Insert(" insert into leave_info (id, msg) values (#{id}, #{msg})")
    void add(LeaveInfo leaveInfo);


    @Select("select * from leave_info")
    LeaveInfo findByKey(int key);

    @Update("update leave_info  set status = #{status} where id = #{id}")
    void update(LeaveInfo leaveInfo);


}
