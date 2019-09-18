package com.jia.service.serviceImpl;

import com.jia.bean.user;
import com.jia.mapper.userMapper;
import com.jia.service.userSevice;
import org.springframework.beans.factory.annotation.Autowired;

public class userSeviceImpl implements userSevice {
    @Autowired
    private userMapper userMapper;
    @Override
    public int register(user user) throws Exception {
        int a=userMapper.register(user);
        return a;
    }

    @Override
    public user selectUser(user user) throws Exception {
        return userMapper.selectUser(user);
    }

}
