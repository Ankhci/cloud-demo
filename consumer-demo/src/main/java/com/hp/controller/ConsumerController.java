package com.hp.controller;

import com.hp.client.UserClient;
import com.hp.pojo.User;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
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
//使用了Feign 去掉@DefaultProperties(defaultFallback = "defaultFallback")
public class ConsumerController {

    /*@Autowired //使用了Feign 去掉
    private RestTemplate template; //eureka 客户端

    @Autowired
    private DiscoveryClient discoveryClient;*/

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

    /*@GetMapping("/{i}")
    public User getUser(@PathVariable("i") Long id){
        String url="http://user-service/user/"+id;
        User user= template.getForObject(url,User.class);
        return user;
    }*/
    /*//增加熔断功能
    @GetMapping("/{i}")
    @HystrixCommand(fallbackMethod = "queryByIdFallback")
    public String getUser(@PathVariable("i") Long id){
        String url="http://user-service/user/"+id;

        return this.template.getForObject(url,String.class);
    }
    //熔断器退回方法
    public String queryByIdFallback(){
        return "yooho, 服务器繁忙，请稍后再试！";
    }
    */
    /*//使用了Feign 去掉
    //第二种熔断器的使用，在类上添加默认熔断器
    @GetMapping("/{i}")
    @HystrixCommand
    public String getUser(@PathVariable("i") Long id){
        String url="http://user-service/user/"+id;

        return this.template.getForObject(url,String.class);
    }
    //熔断器退回方法
    public String defaultFallback(){
        return "yooho, 服务器繁忙，请稍后再试！";
    }*/
    @Autowired
    private UserClient userClient;

    @GetMapping("/{id}")
    public User queryById(@PathVariable("id") Long id){
        return userClient.queryById(id);
    }

}
