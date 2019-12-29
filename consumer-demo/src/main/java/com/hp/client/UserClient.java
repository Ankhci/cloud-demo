package com.hp.client;

import com.hp.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @ClassName UserClient
 * @Description Feign客户端
 * @Author Ankhci
 * @Date 2019/12/29 1:27
 **/
@FeignClient(value = "user-service",fallback = UserClientFallback.class)
public interface UserClient {
    @GetMapping("user/{id}")
    User queryById(@PathVariable("id") Long id);
}
