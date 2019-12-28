package com.hp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @ClassName UserApplication
 * @Description 启动类
 * @Author Ankhci
 * @Date 2019/12/26 21:44
 **/
@EnableDiscoveryClient //Eureka客户端
@SpringBootApplication
@MapperScan("com.hp.mapper")
public class UserApplication {

    public static void main(String[] args) {

        SpringApplication.run(UserApplication.class,args);

    }

}

