package com.hspedu.furns.web;

import com.hspedu.furns.entity.Admin;
import com.hspedu.furns.entity.Member;
import com.hspedu.furns.service.AdminService;
import com.hspedu.furns.service.impl.AdminServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AdminServlet extends BasicServlet{
    private AdminService adminService = new AdminServiceImpl();
    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("AdminServlet login 方法被调用");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        Admin admin = new Admin(null, username, password);
        if(adminService.login(admin) == null){
            System.out.println("不存在该管理员！");
            //req.setAttribute("msg", "用户名或密码错误");
            //req.setAttribute("username", username);
            //req.getRequestDispatcher("/views/member/login.jsp").forward(req, resp);
        }else {
            System.out.println("管理员登录成功");
            req.getRequestDispatcher("/views/manage/manage_menu.jsp").forward(req, resp);
        }
    }
}
