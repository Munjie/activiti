package com.mwj.activiti;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan("com.mwj.activiti.dao")
@SpringBootApplication(exclude={org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class,
        org.activiti.spring.boot.SecurityAutoConfiguration.class})
public class ActivitiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ActivitiApplication.class, args);
    }

}
