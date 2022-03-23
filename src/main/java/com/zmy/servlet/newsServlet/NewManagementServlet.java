package com.zmy.servlet.newsServlet; /**
 * @Description
 * @version
 * @author Sam  Email:superdouble@yeah.net
 * @create 2022-03-23 9:26
 */

import com.zmy.pojo.Account;
import com.zmy.pojo.Colunmn;
import com.zmy.service.Impl.NewsServiceImpl;
import com.zmy.service.NewsService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "NewManagementServlet", value = "/NewManagementServlet")
public class NewManagementServlet extends HttpServlet {

    private final NewsService newsService = new NewsServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("NewManagementServlet");
        // 获取登录人信息
        Account account = (Account) request.getSession().getAttribute("account");
        String userName = account.getUserName();
        System.out.println("userName = " + userName);
        List<Colunmn> respColunmn = newsService.getRespColunmn(userName);
        request.getSession().setAttribute("respColunmn",respColunmn);
        response.sendRedirect("../../view/News/NewsManagement.jsp");
    }
}
