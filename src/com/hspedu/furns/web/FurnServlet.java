package com.hspedu.furns.web;

import com.hspedu.furns.entity.Furn;
import com.hspedu.furns.service.FurnService;
import com.hspedu.furns.service.impl.FurnServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class FurnServlet extends BasicServlet {
    /**
     * 这里我们延续前面servlet减肥的思想
     * 通过反射+动态代理+模板设计模式实现
     * @author ZhengLiHua
     * @date 2023-10-26
     */
    private FurnService furnService = new FurnServiceImpl();
    protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //想测试能否跑通，输入的网址应该是：
        //http://localhost:8080/Javaweb_project/manage/furnServlet?action=list
        //要自己传入参数action=list
        //System.out.println("FurnServlet被调用");
        List<Furn> furns = furnService.queryFurns();
        req.setAttribute("furns", furns);
        req.getRequestDispatcher("/views/manage/furn_manage.jsp").forward(req, resp);

    }
}
