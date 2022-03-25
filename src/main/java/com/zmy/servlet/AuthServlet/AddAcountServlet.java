package com.zmy.servlet.AuthServlet; /**
 * @Description
 * @version
 * @author Sam  Email:superdouble@yeah.net
 * @create 2022-03-19 16:29
 */

import com.zmy.pojo.Account;
import com.zmy.service.AuthService;
import com.zmy.service.Impl.AuthServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AddAcountServlet", value = "/AddAcountServlet")
public class AddAcountServlet extends HttpServlet {
    private final AuthService authService = new AuthServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("AddAcountServlet");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        // 添加账户
        if (username.length() != 0 && password.length() != 0) {
            authService.addAccount(username, password);
            response.sendRedirect("/ManagementServlet");
        } else {
            response.sendRedirect("/ManagementServlet");
        }
    }
}
