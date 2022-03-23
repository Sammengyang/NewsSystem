package com.zmy.servlet.newsServlet; /**
 * @Description
 * @version
 * @author Sam  Email:superdouble@yeah.net
 * @create 2022-03-22 23:10
 */

import com.zmy.pojo.Account;
import com.zmy.pojo.News;
import com.zmy.service.Impl.NewsServiceImpl;
import com.zmy.service.NewsService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "SerchNewsServlet", value = "/SerchNewsServlet")
public class SerchNewsServlet extends HttpServlet {

    private final NewsService newsService = new NewsServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置编码格式
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        // 获取登录账户信息
        Account account = (Account) request.getSession().getAttribute("account");
        String userName = account.getUserName();
        // 获取查询的标题
        String serchTitle = request.getParameter("SerchTitle");
        System.out.println("serchTitle = " + serchTitle);
        if (serchTitle != null || serchTitle.length()==0) { // 标题不为空
            // 获取栏目
            String serchColName = request.getParameter("SerchColName");
            System.out.println("serchColName = " + serchColName);
            // 查询当前栏目下与当前标题匹配的新闻        模糊查询
            List<News> newsList = newsService.getAllNewsByCollNameAndTitle(serchColName, serchTitle);
            request.getSession().setAttribute("newsList", newsList);
            response.sendRedirect("../../view/News/AlltheNews.jsp");
        }else { // 标题为空
            // 获取栏目
            String serchColName = request.getParameter("SerchColName");
            // 查询当前栏目下所有新闻
            List<News> newsList = newsService.getAllNewsByColName(serchColName);
            request.getSession().setAttribute("newsList", newsList);
            response.sendRedirect("../../view/News/AlltheNews.jsp");
        }
    }
}
