package com.zmy.servlet.AuthServlet; /**
 * @Description
 * @version
 * @author Sam  Email:superdouble@yeah.net
 * @create 2022-03-19 16:30
 */

import com.zmy.service.AuthService;
import com.zmy.service.Impl.AuthServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "DelAccountServlet", value = "/DelAccountServlet")
public class DelAccountServlet extends HttpServlet {
    private final AuthService authService = new AuthServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        int count = authService.delAccount(username);
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        if (count > 0){
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
