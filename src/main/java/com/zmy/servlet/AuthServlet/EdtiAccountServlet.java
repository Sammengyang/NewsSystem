package com.zmy.servlet.AuthServlet; /**
 * @Description
 * @version
 * @author Sam  Email:superdouble@yeah.net
 * @create 2022-03-19 16:31
 */

import com.zmy.pojo.Account;
import com.zmy.service.AuthService;
import com.zmy.service.Impl.AuthServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "EdtiAccountServlet", value = "/EdtiAccountServlet")
public class EdtiAccountServlet extends HttpServlet {
    private final AuthService authService = new AuthServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        request.getSession().setAttribute("username", username);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = (String) request.getSession().getAttribute("username");
        String editName = request.getParameter("editName");
        String password = request.getParameter("editPassword");
        int count = authService.changeAccount(username, editName, password);
        if (count > 0) {
            // 读取所有数据
            List<Account> allAccount = authService.getAllAccount();
            // 覆盖域中原有数据
            request.getSession().setAttribute("allAccount", allAccount);
            response.sendRedirect("../../view/account/AccountManagement.jsp");
        } else {
            response.sendRedirect("../../view/account/AccountManagement.jsp");
        }
    }
}
