package com.zmy.servlet.ColunmnServlet; /**
 * @Description
 * @version
 * @author Sam  Email:superdouble@yeah.net
 * @create 2022-03-22 18:06
 */

import com.zmy.pojo.Colunmn;
import com.zmy.service.ColunmnService;
import com.zmy.service.Impl.ColunmnServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "delColunmnServlet", value = "/delColunmnServlet")
public class delColunmnServlet extends HttpServlet {

    private final ColunmnService colunmnService = new ColunmnServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // todo 删除后页面不会刷新，因为用的ajax传递的数据，因此不会页面刷新
        // 该问题在账户删除、栏目删除、新闻删除都存在
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer colid = Integer.parseInt(request.getParameter("colid"));
        int count = colunmnService.delColunmn(colid);
        if (count > 0) { // 删除成功
            response.sendRedirect("/ColManagementServlet");
        }else {
            response.sendRedirect("/ColManagementServlet");
        }
    }
}
