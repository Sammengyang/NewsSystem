package com.zmy.servlet.signServlet; /**
 * @Description
 * @version
 * @author Sam  Email:superdouble@yeah.net
 * @create 2022-03-18 17:38
 */

import com.zmy.pojo.Account;
import com.zmy.service.Impl.SignServiceImpl;
import com.zmy.service.SignService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "SignUpServlet", value = "/SignUpServlet")
public class SignUpServlet extends HttpServlet {
    private final SignService signService = new SignServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("SignUpServlet");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if (username.length()!=0&&password.length()!=0){
            Account account = signService.SignUp(username, password);
            if (account!=null){ //返回不为空登录成功
                request.getSession().setAttribute("account",account);
                response.sendRedirect("../../view/index.jsp");
            }
        }else{
            response.sendRedirect("../../view/Sign_up.jsp");
        }
    }
}
