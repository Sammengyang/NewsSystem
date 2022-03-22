package com.zmy.servlet.ColunmnServlet; /**
 * @Description
 * @version
 * @author Sam  Email:superdouble@yeah.net
 * @create 2022-03-22 20:59
 */

import com.zmy.pojo.Colunmn;
import com.zmy.service.ColunmnService;
import com.zmy.service.Impl.ColunmnServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "SerchColunmnServlet", value = "/SerchColunmnServlet")
public class SerchColunmnServlet extends HttpServlet {

    private final ColunmnService colunmnService = new ColunmnServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String colName = request.getParameter("SerchColName");
        if (colName!=null){
            List<Colunmn> allColunmn = colunmnService.SerchColunmnByColName(colName);
            request.getSession().setAttribute("allColunmn",allColunmn);
            response.sendRedirect("../../view/Column/ColumnManagement.jsp");
        }else {
            List<Colunmn> allColunmn = colunmnService.getAllColunmn();
            request.getSession().setAttribute("allColunmn",allColunmn);
            response.sendRedirect("../../view/Column/ColumnManagement.jsp");
        }

    }
}
