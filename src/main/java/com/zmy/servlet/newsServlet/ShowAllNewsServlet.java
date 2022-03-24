package com.zmy.servlet.newsServlet; /**
 * @Description
 * @version
 * @author Sam  Email:superdouble@yeah.net
 * @create 2022-03-23 18:36
 */

import com.zmy.pojo.Account;
import com.zmy.pojo.Colunmn;
import com.zmy.pojo.News;
import com.zmy.service.Impl.NewsServiceImpl;
import com.zmy.service.NewsService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ShowAllNewsServlet", value = "/ShowAllNewsServlet")
public class ShowAllNewsServlet extends HttpServlet {

    private final NewsService newsService = new NewsServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("ShowAllNewsServlet");
        // 获取当前登录账户  用户名
        Account account = (Account) request.getSession().getAttribute("account");
        String userName = account.getUserName();
        // 获取登录账户的栏目权限
        List<Colunmn> respColunmn = newsService.getRespColunmn(userName);
        request.getSession().setAttribute("respColunmn", respColunmn);
        // 根据用户栏目权限获取权限内新闻发布历史
        // 每页展示的条数
        Integer pageSize = 1;
        // 获取新闻总数   根据登录账户获取权限以内的新闻总数
        Integer count = newsService.getWithinNewsCount(userName);
        Integer MaxPageNum = (int) Math.ceil(count * 1.0 / pageSize); // 计算最大页数
        // 获取页码
        String num = request.getParameter("npageNum");
        // 防止页码越界
        if (num == null || "".equals(num) || Integer.parseInt(num) < 1) {
            num = "1";
        }
        if (Integer.parseInt(num) > MaxPageNum){
            num = String.valueOf(MaxPageNum);
        }
        Integer npageNum = Integer.parseInt(num);
        List<News> newsList = newsService.getWithinNewsByUserName(userName).subList(npageNum*pageSize-pageSize,npageNum*pageSize);
        request.getSession().setAttribute("newsList", newsList);
        request.getSession().setAttribute("npageNum",npageNum);
        response.sendRedirect("../../view/News/AlltheNews.jsp");
    }
}
