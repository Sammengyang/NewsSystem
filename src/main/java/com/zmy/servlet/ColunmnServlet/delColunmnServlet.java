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
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer colid = Integer.parseInt(request.getParameter("colid"));
        int count = colunmnService.delColunmn(colid);
        if (count > 0) { // 删除成功
            //重新获取栏目
            List<Colunmn> allColunmn = colunmnService.getAllColunmn();
            request.getSession().setAttribute("allColunmn",allColunmn);
            response.sendRedirect("../../view/Column/ColumnManagement.jsp");
        }else {
            response.sendRedirect("../../view/Column/ColumnManagement.jsp");
        }
    }
}
