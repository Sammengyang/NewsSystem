package com.zmy.servlet.AuthServlet; /**
 * @Description
 * @version
 * @author Sam  Email:superdouble@yeah.net
 * @create 2022-03-22 20:34
 */

import com.zmy.pojo.Account;
import com.zmy.service.AuthService;
import com.zmy.service.Impl.AuthServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ManagementServlet", value = "/ManagementServlet")
public class AcManagementServlet extends HttpServlet {

    private final AuthService authService = new AuthServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 每页展示的条数
        Integer pageSize = 3;
        // 获取所有账户集合，计算最大页数
        Integer count = authService.getCount();
        Integer MaxPageNum = (int) Math.ceil(count * 1.0 / pageSize);
        // 获取页数
        String pageNum = request.getParameter("pageNum");
        if (pageNum == null || "".equals(pageNum) || Integer.parseInt(pageNum) < 1) {
            pageNum = "1";
        }
        if (Integer.parseInt(pageNum) > MaxPageNum) {
            pageNum = String.valueOf(MaxPageNum);
        }
        // 获取当前页面所有数据
        List<Account> allAccount = authService.getAllAccountByPage(Integer.parseInt(pageNum), pageSize);
        request.getSession().setAttribute("allAccount", allAccount);
        request.getSession().setAttribute("pageNum",pageNum);
        response.sendRedirect("../../view/account/AccountManagement.jsp");
    }
}
