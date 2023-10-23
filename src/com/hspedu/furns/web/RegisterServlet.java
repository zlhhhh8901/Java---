package com.hspedu.furns.web;

import com.hspedu.furns.dao.MemberDao;
import com.hspedu.furns.entity.Member;
import com.hspedu.furns.service.MemberService;
import com.hspedu.furns.service.impl.MemberServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterServlet extends HttpServlet {
    private MemberService memberService = new MemberServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("RegisterServlet被调用！");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String repassword = req.getParameter("repassword");
        if (!memberService.isExistsUsername(username)) {
            System.out.println("用户名不存在" + username + "可以注册");
            Member member = new Member(null, username, password, repassword);
            if (memberService.registerMember(member)) {
                System.out.println("注册成功");
                req.getRequestDispatcher("/view/member/register_ok.html").forward(req, resp);
            } else {
                System.out.println("注册失败");
                req.getRequestDispatcher("/view/member/register_fail.html").forward(req, resp);
            }
        } else {
            System.out.println("用户名存在" + username + "不可以注册");
            req.getRequestDispatcher("/view/member/login.html").forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
