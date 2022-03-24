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

@WebServlet(name = "editColunmnServlet", value = "/editColunmnServlet")
public class editColunmnServlet extends HttpServlet {

    private final ColunmnService colunmnService = new ColunmnServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String colid = request.getParameter("colid");
        System.out.println("colid = " + colid);
        request.getSession().setAttribute("colid", colid);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        // 获取到原id
        Integer colid = Integer.parseInt((String) request.getSession().getAttribute("colid"));
        String editName = request.getParameter("editName");
        Integer editId = Integer.parseInt(request.getParameter("editId"));
        int count = colunmnService.editColunmn(colid, editId, editName);
        if (count > 0){
//            //从新获取栏目
//            List<Colunmn> allColunmn = colunmnService.getAllColunmn();
//            request.getSession().setAttribute("allColunmn",allColunmn);
//            response.sendRedirect("../../view/Column/ColumnManagement.jsp");
            response.sendRedirect("/ColManagementServlet");
        }else {
//            response.sendRedirect("../../view/Column/ColumnManagement.jsp");
            response.sendRedirect("/ColManagementServlet");
        }

    }
}
