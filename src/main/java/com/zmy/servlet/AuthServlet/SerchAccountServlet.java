package com.zmy.servlet.AuthServlet; /**
 * @Description
 * @version
 * @author Sam  Email:superdouble@yeah.net
 * @create 2022-03-22 19:56
 */

import com.zmy.pojo.Account;
import com.zmy.service.AuthService;
import com.zmy.service.Impl.AuthServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;
import java.util.Queue;

@WebServlet(name = "SerchAccountServlet", value = "/SerchAccountServlet")
public class SerchAccountServlet extends HttpServlet {

    private final AuthService authService = new AuthServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 查询的关键字
        String username = request.getParameter("serch_username");
//        // 每页展示条数
//        Integer pageSize = 1;
//        // 获取查询结果的集合，计算最大页数
//        Integer count = authService.getAcByUserNameCount(username);
//        Integer MaxPageNum = (int)Math.ceil(count * 1.0 / pageSize);
        if (username != null) {
            List<Account> allAccount = authService.getAccountByUserName(username);
            request.getSession().setAttribute("allAccount", allAccount);
            response.sendRedirect("../../view/account/AccountManagement.jsp");
        } else {
            List<Account> allAccount = authService.getAllAccount();
            request.getSession().setAttribute("allAccount", allAccount);
            response.sendRedirect("../../view/account/AccountManagement.jsp");
        }
    }
}
