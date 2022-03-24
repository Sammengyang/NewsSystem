package com.zmy.servlet.ColunmnServlet; /**
 * @Description
 * @version
 * @author Sam  Email:superdouble@yeah.net
 * @create 2022-03-22 20:45
 */

import com.zmy.pojo.Colunmn;
import com.zmy.service.ColunmnService;
import com.zmy.service.Impl.ColunmnServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ColManagementServlet", value = "/ColManagementServlet")
public class ColManagementServlet extends HttpServlet {

    private final ColunmnService colunmnService = new ColunmnServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 每页展示的条数
        Integer cpageSize = 1;
        // 获取栏目总数，计算最大页数
        int count = colunmnService.getColunmnCount();
        Integer MaxPageNum = (int) Math.ceil(count * 1.0 / cpageSize);
        // 获取页数
        String cpageNum = request.getParameter("cpageNum");
        if (cpageNum == null || "".equals(cpageNum) || Integer.parseInt(cpageNum) < 1){
            cpageNum = "1";
        }
        if (Integer.parseInt(cpageNum) > MaxPageNum){
            cpageNum = String.valueOf(MaxPageNum);
        }

        List<Colunmn> allColunmn = colunmnService.getAllColunmnByPage(Integer.parseInt(cpageNum),cpageSize);
        request.getSession().setAttribute("allColunmn", allColunmn);
        request.getSession().setAttribute("cpageNum",cpageNum);
        response.sendRedirect("../../view/Column/ColumnManagement.jsp");
    }
}
