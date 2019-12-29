package com.hp;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @ClassName ZuulApplication
 * @Description Zuul启动类
 * @Author Ankhci
 * @Date 2019/12/29 18:34
 **/
@EnableDiscoveryClient //开启Eureka客户端
@SpringCloudApplication
@EnableZuulProxy //开启Zuul网关功能
public class ZuulApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZuulApplication.class,args);
    }
}
