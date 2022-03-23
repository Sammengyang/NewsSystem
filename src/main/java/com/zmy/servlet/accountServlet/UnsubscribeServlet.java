package com.zmy.servlet.accountServlet; /**
 * @Description
 * @version
 * @author Sam  Email:superdouble@yeah.net
 * @create 2022-03-23 9:46
 */

import com.zmy.pojo.Account;
import com.zmy.service.AccountSaervice;
import com.zmy.service.Impl.AccountSaerviceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UnsubscribeServlet", value = "/UnsubscribeServlet")
public class UnsubscribeServlet extends HttpServlet {

    private final AccountSaervice accountSaervice = new AccountSaerviceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Account account = (Account) request.getSession().getAttribute("account");
        String userName = account.getUserName();
        accountSaervice.Unsubscribe(userName);
        // 清除数据
        request.getSession().invalidate();
        response.sendRedirect("../../Sign/Sign_up.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
