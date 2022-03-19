package com.zmy.servlet.signServlet; /**
 * @Description
 * @version
 * @author Sam  Email:superdouble@yeah.net
 * @create 2022-03-18 17:37
 */

import com.zmy.Utils.SendSmsUtil;
import com.zmy.pojo.Account;
import com.zmy.service.Impl.SignServiceImpl;
import com.zmy.service.SignService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "SignInServlet", value = "/SignInServlet")
public class SignInServlet extends HttpServlet {
    private final SignService signService = new SignServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 验证码发送成功才会转发到 SignInServlet
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String tel = request.getParameter("tel");
        String code = request.getParameter("code");
        String code1 = (String) request.getSession().getAttribute("code");
        if (code1.equals(code)){
            if(username.length()!=0&&password.length()!=0&&tel.length()!=0){
                Account account = new Account(username,tel,password);
                signService.login(account);
                response.sendRedirect("/Sign/Sign_up.jsp");
            }
        }







    }
}
