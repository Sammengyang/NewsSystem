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

@WebServlet(name = "SerchAccountServlet", value = "/SerchAccountServlet")
public class SerchAccountServlet extends HttpServlet {

    private final AuthService authService = new AuthServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("serch_username");
        if (username!=null){
            List<Account> allAccount = authService.getAccountByUserName(username);
            request.getSession().setAttribute("allAccount",allAccount);
            response.sendRedirect("../../view/account/AccountManagement.jsp");
        }else {
            List<Account> allAccount = authService.getAllAccount();
            request.getSession().setAttribute("allAccount",allAccount);
            response.sendRedirect("../../view/account/AccountManagement.jsp");
        }
    }
}
