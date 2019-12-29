package com.hp.client;

import com.hp.pojo.User;
import org.springframework.stereotype.Component;

/**
 * @ClassName UserClientFallback
 * @Description feign中的熔断器
 * @Author Ankhci
 * @Date 2019/12/29 17:26
 **/
@Component
public class UserClientFallback implements UserClient{
    @Override
    public User queryById(Long id) {
        User user = new User();
        user.setName("hehe，又拥堵了");
        return user;
    }
}
