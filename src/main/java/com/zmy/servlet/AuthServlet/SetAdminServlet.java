package com.zmy.servlet.AuthServlet; /**
 * @Description
 * @version
 * @author Sam  Email:superdouble@yeah.net
 * @create 2022-03-24 11:21
 */

import com.zmy.dao.AuthDao;
import com.zmy.service.AuthService;
import com.zmy.service.Impl.AuthServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "SetAdminServlet", value = "/SetAdminServlet")
public class SetAdminServlet extends HttpServlet {

    private final AuthService authService = new AuthServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        request.getSession().setAttribute("username",username);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取要修改的用户名
        String username = (String) request.getSession().getAttribute("username");
        // 获取设置的权限
        String role = request.getParameter("role");
        authService.SetAdmin(username,role);
        response.sendRedirect("../../view/account/AccountManagement.jsp");
    }
}
