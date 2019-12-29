package com.hp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName ConsumerApplication
 * @Description 启动类
 * @Author Ankhci
 * @Date 2019/12/26 22:26
 **/
/*@EnableCircuitBreaker //开启熔断器功能
@SpringBootApplication
@EnableDiscoveryClient //开启eureka客户端*/
@SpringCloudApplication //三合一
@EnableFeignClients //开启feign功能
public class ConsumerApplication {

   /* @Bean //使用了Feign 去掉
    @LoadBalanced
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }*/

    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class,args);
    }
}
