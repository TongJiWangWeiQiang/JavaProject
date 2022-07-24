package com.cccproject.controller;

import com.cccproject.pojo.Admin;
import com.cccproject.service.AdminService;
import com.cccproject.utils.Consts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/admin")
public class AdminAction {

    //界面层一定会有业务逻辑层的对象
    @Autowired
    AdminService adminService;

    @RequestMapping("/login")
    public String login(String name, String pwd, HttpServletRequest request){
        Admin admin = adminService.login(name, pwd);
        if(admin != null){
            System.out.println("login success");
            request.setAttribute(Consts.ADMIN, admin);
            return "/admin/mIndex";
        }else {
            request.setAttribute("errmsg","用户名或密码不正确");
            return "/admin/login";
        }
    }

    @RequestMapping("/mexit")
    public String mexit(HttpServletRequest request){
        request.getSession().setAttribute(Consts.ADMIN, null);
        System.out.println("exit login");
        return "/admin/login";
    }

}
