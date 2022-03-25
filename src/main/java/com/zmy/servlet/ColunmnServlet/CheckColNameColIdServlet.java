package com.zmy.servlet.ColunmnServlet; /**
 * @Description
 * @version
 * @author Sam  Email:superdouble@yeah.net
 * @create 2022-03-25 22:03
 */

import com.zmy.service.ColunmnService;
import com.zmy.service.Impl.ColunmnServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CheckColNameColIdServlet", value = "/CheckColNameColIdServlet")
public class CheckColNameColIdServlet extends HttpServlet {

    private final ColunmnService colunmnService = new ColunmnServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String colName = request.getParameter("colName");
        boolean exit = colunmnService.CheckColName(colName);
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        if (exit){
            out.write("success");
            out.flush();
            out.close();
        }else {
            out.write("false");
            out.flush();
            out.close();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String colId = request.getParameter("colId");
        boolean exit = colunmnService.CheckColCid(Integer.parseInt(colId));
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        if (exit){
            out.write("success");
            out.flush();
            out.close();
        }else {
            out.write("false");
            out.flush();
            out.close();
        }
    }
}
