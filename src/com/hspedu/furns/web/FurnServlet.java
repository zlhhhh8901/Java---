package com.hspedu.furns.web;

import com.hspedu.furns.entity.Furn;
import com.hspedu.furns.entity.Page;
import com.hspedu.furns.service.FurnService;
import com.hspedu.furns.service.impl.FurnServiceImpl;
import com.hspedu.furns.utils.DataUtils;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.List;

public class FurnServlet extends BasicServlet {
    /**
     * 这里我们延续前面servlet减肥的思想
     * 通过反射+动态代理+模板设计模式实现
     *
     * @author ZhengLiHua
     * @date 2023-10-26
     */
    private FurnService furnService = new FurnServiceImpl();

    //显示所有家居
    protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //想测试能否跑通，输入的网址应该是：
        //http://localhost:8080/Javaweb_project/manage/furnServlet?action=list
        //要自己传入参数action=list
        //System.out.println("FurnServlet被调用");
        List<Furn> furns = furnService.queryFurns();
        //把furns集合放入到request域，furn_manage.jsp获取该集合信息
        //再根据信息(文件地址)取图片、显示信息
        //jsp知识漏缺
        req.setAttribute("furns", furns);
        req.getRequestDispatcher("/views/manage/furn_manage.jsp").forward(req, resp);
    }

    //将jsp提交的数据封装为furn对象，调用service的add方法添加家具
    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //注意在这里写无法解决中文乱码问题！因为并不是在这里获取数据，而是在BasicServlet
        //在doPost或doGet写最合理
        //req.setCharacterEncoding("utf-8");

        /** (1)
         * String name = req.getParameter("name");
         *         String maker = req.getParameter("maker");
         *         String price = req.getParameter("price");
         *         String sales = req.getParameter("sales");
         *         String stock = req.getParameter("stock");
         *         //现在代码还存在一个问题：若用户输入格式、数据类型不对就会直接报错
         *         //解决方法一：JS前端校验 ———— 在实现用户注册功能时就是用这个方法
         *         //解决方法二：后端校验
         *         //SpringMVC有一个专门的校验框架/规则 jsr303，更方便，后面学
         *         try {
         *             Furn furn = new Furn(null, name, maker, new BigDecimal(price),
         *                     Integer.parseInt(sales), Integer.parseInt(stock),
         *                     "assets/images/product-image/6.jpg");
         *             furnService.add(furn);
         *         } catch (NumberFormatException e) {
         *             System.out.println("格式错误");
         *             req.setAttribute("mes", "输入数据格式不对");
         *             req.getRequestDispatcher("/views/manage/furn_add.jsp").forward(req, resp);
         *         }
         */

        /** (2)
         * //注掉(1)操作，现在使BeanUtils工具类完成javabean对象的自动封装（要导包）
         *         Furn furn = new Furn();
         *         try {
         *             //下面操作会将req.getParameterMap()数据封装到furn对象
         *             //底层使用反射，因此必须有无参构造器，且表单提交的数据字段名需要和JavaBean的属性名一致
         *             BeanUtils.populate(furn, req.getParameterMap());
         *             //此时又出现一个问题：我们并没有传入图片路径（因为这个功能我们选择后面通过取文件的方式解决）
         *             //那么此时图片路径就是null，但数据库此列设置的是not null不能为空
         *             //前面我们是直接设置固定的路径"assets/images/product-image/6.jpg"以解决这个问题
         *             //可现在是通过BeanUtils方法，咋办？
         *             //解决方法：直接改entity，给imgPath属性添加初始值，并给构造函数加个判断
         *             //为什么会想到这种解决方法？————因为知道BeanUtils.populate(furn, req.getParameterMap());的原理
         *         } catch (Exception e) {
         *             e.printStackTrace();
         *         }
         *         //我们可以将上面这些代码整理为一个工具类————DataUtils
         */

        //(3)自动封装最终形态！！！
        Furn furn = DataUtils.copyParamToBean(req.getParameterMap(), new Furn());
        furnService.add(furn);

        //请求转发到家具管理显示列表页面不能直接写，因为要重新获取数据
        //req.getRequestDispatcher("/views/manage/furn_manage.jsp").forward(req, resp);
        //因此要重新走一遍list方法
        //req.getRequestDispatcher("/manage/furnServlet?action=list").forward(req, resp);

        //注意上面这里用请求转发有个重大问题————
        //浏览器页面网址停留在第一次发出servlet请求时，因此刷新页面相同的请求会再次发出，导致数据重复添加
        //解决方法：用重定向
        //resp.sendRedirect(req.getContextPath() + "/manage/furnServlet?action=list");
        resp.sendRedirect(req.getContextPath() + "/manage/furnServlet?action=page&pageNo="+ req.getParameter("pageNo"));
    }


    //删除家具
    protected void deleteById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //为防止接收到的id格式不是一个数字字符串
        //在DataUtils写了一个方法
        int id = DataUtils.parseInt(req.getParameter("id"), 0);
        furnService.deleteById(id);
        //resp.sendRedirect(req.getContextPath() + "/manage/furnServlet?action=list");
        resp.sendRedirect(req.getContextPath() + "/manage/furnServlet?action=page&pageNo="+ req.getParameter("pageNo"));
    }

    //查询获取家具
    protected void queryById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = DataUtils.parseInt(req.getParameter("id"), 0);
        Furn furn = furnService.queryById(id);
        req.setAttribute("furn", furn);
        //将pageNo保存到request域
        req.setAttribute("pageNo", req.getParameter("pageNo"));
        req.getRequestDispatcher("/views/manage/furn_update.jsp").forward(req, resp);
    }

    //修改家具信息
    protected void updateFurn(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Furn furn = DataUtils.copyParamToBean(req.getParameterMap(), new Furn());
        furnService.update(furn);
        //resp.sendRedirect(req.getContextPath() + "/manage/furnServlet?action=list");
        //考虑分页并带上pageNo
        resp.sendRedirect(req.getContextPath() + "/manage/furnServlet?action=page&pageNo="+ req.getParameter("pageNo"));
    }

    //获取分页数据
    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pageSize = DataUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        int pageNo = DataUtils.parseInt(req.getParameter("pageNo"), 1);
        Page<Furn> page = furnService.page(pageNo, pageSize);
        req.setAttribute("page", page);
        req.getRequestDispatcher("/views/manage/furn_manage.jsp").forward(req, resp);
    }
}
