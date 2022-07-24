package com.cccproject.service;

import com.cccproject.pojo.Admin;

public interface AdminService {
    //登录判断
    Admin login(String name, String pwd);
}
