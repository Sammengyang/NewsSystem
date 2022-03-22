package com.zmy.servlet.AuthServlet; /**
 * @Description
 * @version
 * @author Sam  Email:superdouble@yeah.net
 * @create 2022-03-19 16:31
 */

import com.zmy.dao.AuthDao;
import com.zmy.dao.Impl.AuthDaoImpl;
import com.zmy.pojo.Account;
import com.zmy.service.AuthService;
import com.zmy.service.Impl.AuthServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "GrantServlet", value = "/GrantServlet")
public class GrantServlet extends HttpServlet {
    private final AuthService authService = new AuthServiceImpl();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        request.getSession().setAttribute("username",username);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置请求的编码格式
        request.setCharacterEncoding("UTF-8");
        // 设置响应的编码格式
        response.setContentType("test/html;charset=utf-8");
        // 获取正在编辑的账户
        String username = (String) request.getSession().getAttribute("username");
        String[] colunmns = request.getParameterValues("colunmn");
        int count = authService.grantColunmntoAccount(username, colunmns);
        if (count>0){
            List<Account> allAccount = authService.getAllAccount();
            request.getSession().setAttribute("allAccount",allAccount);
            response.sendRedirect("../../view/account/AccountManagement.jsp");
        }else {
            response.sendRedirect("../../view/account/AccountManagement.jsp");
        }
    }
}
