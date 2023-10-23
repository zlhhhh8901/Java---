package com.hspedu.furns.web;

import com.hspedu.furns.entity.Member;
import com.hspedu.furns.service.MemberService;
import com.hspedu.furns.service.impl.MemberServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    private MemberService memberService = new MemberServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("LoginServlet被调用");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        Member member = new Member(null, username, password, null);
        //MemberService memberService = new MemberServiceImpl();注意这个定义为私有属性
        if(memberService.login(member) == null){
            System.out.println("该用户不存在，登录失败");
            req.getRequestDispatcher("/views/member/login_ok.html").forward(req, resp);
        }else {
            System.out.println("登录成功");
            req.getRequestDispatcher("/views/member/register_ok.html").forward(req, resp);
        }
    }
}
