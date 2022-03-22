package com.zmy.servlet.newsServlet; /**
 * @Description
 * @version
 * @author Sam  Email:superdouble@yeah.net
 * @create 2022-03-22 23:10
 */

import com.zmy.pojo.Account;
import com.zmy.service.Impl.NewsServiceImpl;
import com.zmy.service.NewsService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "PostNewsServlet", value = "/PostNewsServlet")
public class PostNewsServlet extends HttpServlet {

    private final NewsService newsService = new NewsServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        // 获取标题
        String title = request.getParameter("title");
        // 获取栏目
        String postColName = request.getParameter("PostColName");
        // 获取新闻内容
        String content = request.getParameter("content");
        // 获取发布人
        Account account = (Account) request.getSession().getAttribute("account");
        String userName = account.getUserName();
        newsService.postNew(title,postColName,content,userName);
        response.sendRedirect("../../view/News/NewsManagement.jsp");
    }
}
