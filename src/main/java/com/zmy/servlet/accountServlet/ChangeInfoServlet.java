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

@WebServlet(name = "ChangeInfoServlet", value = "/ChangeInfoServlet")
public class ChangeInfoServlet extends HttpServlet {

    private final AccountSaervice accountSaervice = new AccountSaerviceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取登录账户用户名
        Account account1 = (Account) request.getSession().getAttribute("account");
        String userName = account1.getUserName();
        // 获取提交数据
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String tel = request.getParameter("tel");
        // 修改信息
        int count = accountSaervice.ChangeInfo(userName, username, password, tel);
        if (count>0){  // 修改成功
            // 根据用户名获取账户信息
            Account account = accountSaervice.getPrivateInfo(username);
            request.getSession().setAttribute("account",account);
            response.sendRedirect("../../view/account/AccountManagement.jsp");
        }else {  // 修改失败
            response.sendRedirect("../../view/account/AccountManagement.jsp");
        }
    }
}
