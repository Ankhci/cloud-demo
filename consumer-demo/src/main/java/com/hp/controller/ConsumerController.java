package com.hp.controller;

import com.hp.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @ClassName ConsumerController
 * @Description 控制层
 * @Author Ankhci
 * @Date 2019/12/26 22:30
 **/
@RestController
@RequestMapping("consumer")
public class ConsumerController {

    @Autowired
    private RestTemplate template; //eureka 客户端

    @Autowired
    private DiscoveryClient discoveryClient;

    /*@GetMapping("/{i}")
    public User getUser(@PathVariable("i") Long id){
        //调用User-Service里的方法
        return this.template.getForObject("http://localhost:8081/user/"+id,User.class);

    }*/

    /*@GetMapping("/{i}")
    public User getUser(@PathVariable("i") Long id){
        //获取服务列表
        List<ServiceInstance> instances = discoveryClient.getInstances("user-service");
        //列表中取出一个服务实例
        ServiceInstance serviceInstance = instances.get(0);
        String url = "http://"+serviceInstance.getHost()+":"+serviceInstance.getPort()+"/user/"+id;
        return this.template.getForObject(url,User.class);
    }*/

    @GetMapping("/{i}")
    public User getUser(@PathVariable("i") Long id){
        String url="http://user-service/user/"+id;
        User user= template.getForObject(url,User.class);
        return user;
    }

}
