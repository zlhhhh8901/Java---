package com.hspedu.furns.web;

import com.hspedu.furns.entity.Member;
import com.hspedu.furns.service.MemberService;
import com.hspedu.furns.service.impl.MemberServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MemberServlet extends BasicServlet {
    private MemberService memberService = new MemberServiceImpl();

    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("MemberServlet login 方法被调用");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        Member member = new Member(null, username, password, null);
        //MemberService memberService = new MemberServiceImpl();注意这个定义为私有属性
        if(memberService.login(member) == null){
            System.out.println("该用户不存在，登录失败");
            req.setAttribute("msg", "用户名或密码错误");
            req.setAttribute("username", username);
            req.getRequestDispatcher("/views/member/login.jsp").forward(req, resp);
        }else {
            System.out.println("登录成功");
            req.getRequestDispatcher("/views/member/login_ok.html").forward(req, resp);
        }
    }

    protected void register(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("MemberServlet register 方法被调用！");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String repassword = req.getParameter("repassword");
        if (!memberService.isExistsUsername(username)) {
            System.out.println("用户名不存在" + username + "可以注册");
            Member member = new Member(null, username, password, repassword);
            if (memberService.registerMember(member)) {
                System.out.println("注册成功");
                req.getRequestDispatcher("/views/member/register_ok.html").forward(req, resp);
            } else {
                System.out.println("注册失败");
                req.getRequestDispatcher("/views/member/register_fail.html").forward(req, resp);
            }
        } else {
            System.out.println("用户名存在" + username + "不可以注册");
            req.getRequestDispatcher("/views/member/login.jsp").forward(req, resp);
        }
    }
}
