package com.hp.service;

import com.hp.mapper.UserMapper;
import com.hp.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName UserService
 * @Description 服务层
 * @Author Ankhci
 * @Date 2019/12/26 21:58
 **/
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public User queryById(Long id) {
        return this.userMapper.selectByPrimaryKey(id);
    }
}
