package com.zmy.servlet.newsServlet; /**
 * @Description
 * @version
 * @author Sam  Email:superdouble@yeah.net
 * @create 2022-03-23 20:53
 */

import com.zmy.pojo.Account;
import com.zmy.pojo.News;
import com.zmy.service.Impl.NewsServiceImpl;
import com.zmy.service.NewsService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "EditNewsServlet", value = "/EditNewsServlet")
public class EditNewsServlet extends HttpServlet {
    private final NewsService newsService = new NewsServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置编码格式
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String newId = request.getParameter("newId");
        request.getSession().setAttribute("newId", newId);
        // 通过newid获取到新闻标题
        String title = newsService.getTitleByNewId(Integer.parseInt(newId));
        PrintWriter out = response.getWriter();
        if (title!=null){
            out.write(title);
            out.flush();
            out.close();
        }else{
            out.write(title);
            out.flush();
            out.close();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置编码格式
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        // 获取登录账户信息
        Account account = (Account) request.getSession().getAttribute("account");
        String userName = account.getUserName();
        // 获取正在编辑的新闻id
        Integer newId = Integer.parseInt((String) request.getSession().getAttribute("newId"));
        // 获取修改的标题
        String editTitle = request.getParameter("editTitle");
        // 获取修改的栏目
        String editColName = request.getParameter("EditColName");
        // 修改新闻数据
        newsService.EditNew(newId,editColName,editTitle);
        // 重新获取该账户负责的新闻
        List<News> newsList = newsService.getWithinNewsByUserName(userName);
        request.getSession().setAttribute("newsList",newsList);
        response.sendRedirect("../../view/News/AlltheNews.jsp");
    }
}
