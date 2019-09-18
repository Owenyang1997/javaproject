package com.jia.service;

import com.jia.bean.user;

public interface userSevice {
    public int register(user user) throws Exception;
    public user selectUser(user user)throws Exception;

}
