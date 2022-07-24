package com.cccproject.service.impl;

import com.cccproject.mapper.AdminMapper;
import com.cccproject.pojo.Admin;
import com.cccproject.pojo.AdminExample;
import com.cccproject.service.AdminService;
import com.cccproject.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    //业务逻辑层必定有数据访问层的对象
    @Autowired
    AdminMapper adminMapper;

    @Override
    public Admin login(String name, String pwd) {

        //如果有条件则需要创建AdminExample对象来封装条件
        AdminExample example = new AdminExample();
        example.createCriteria().andANameEqualTo(name);

        List<Admin> list = adminMapper.selectByExample(example);
        if(list.size() > 0){
            Admin admin = list.get(0);

            String miPwd = MD5Util.getMD5(pwd);
//            System.out.println(miPwd);
            if(miPwd.equals(admin.getaPass())){
                return admin;
            }
        }
        return null;
    }
}
