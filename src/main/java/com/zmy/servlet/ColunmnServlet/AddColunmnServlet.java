package com.zmy.servlet.ColunmnServlet; /**
 * @Description
 * @version
 * @author Sam  Email:superdouble@yeah.net
 * @create 2022-03-22 18:05
 */

import com.zmy.pojo.Colunmn;
import com.zmy.service.ColunmnService;
import com.zmy.service.Impl.ColunmnServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AddColunmnServlet", value = "/AddColunmnServlet")
public class AddColunmnServlet extends HttpServlet {
    private final ColunmnService colunmnService = new ColunmnServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String colName = request.getParameter("colName");
        Integer colId = Integer.parseInt(request.getParameter("colId"));
        int count = colunmnService.addColunmn(colId, colName);
        if (count > 0){
            //从新获取栏目
            List<Colunmn> allColunmn = colunmnService.getAllColunmn();
            request.getSession().setAttribute("allColunmn",allColunmn);
            response.sendRedirect("../../view/Column/ColumnManagement.jsp");
        }else {
            response.sendRedirect("../../view/Column/ColumnManagement.jsp");
        }
    }
}
