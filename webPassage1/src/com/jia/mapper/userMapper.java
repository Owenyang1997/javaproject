package com.jia.mapper;

import com.jia.bean.user;
import org.apache.ibatis.annotations.Param;

public interface userMapper {
    public int register(user user) throws Exception;
    public user selectUser(@Param(value = "user")user user)throws Exception;
}
